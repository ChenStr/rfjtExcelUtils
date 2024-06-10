package com.rfjttest.controller;

import cn.hutool.json.JSONObject;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.util.StringUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson2.JSON;
import com.rfjttest.entity.Receivable;
import com.rfjttest.entity.Result;
import com.rfjttest.handler.ReceivableHeightWriteConfig;
import com.rfjttest.handler.ReceivableWriteHandler;
import com.rfjttest.handler.ReceivableWriteWidthConfig;
import org.apache.commons.collections4.map.LinkedMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Chen Zhenyang
 * @Data 2024/6/8
 * @apiNote
 */
//@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class ExcelController {

    @PostMapping("/upload")
//    public MultipartFile test(MultipartFile file) {
    public void test(MultipartFile file, HttpServletResponse response) throws IOException {
        // 获取数据
        List<Receivable> list = null;
        Receivable title;
        Receivable column;
        try {
            list = EasyExcel.read(file.getInputStream())
                    .head(Receivable.class)
                    .sheet()
                    .headRowNumber(0) // 默认值为1
                    .doReadSync();
        } catch (IOException e) {
            e.printStackTrace();
        }
        title = list.get(0);
        column = list.get(1);
        list.remove(title);
        list.remove(column);
        // 拆分数据小记数据
        Map<String,List<Receivable>> dateMap = new LinkedMap<>();
        Map<String,Receivable> map = new LinkedMap<>();
        for (Receivable receivable:list) {
            if (receivable.getCustomerCode().indexOf("(小计)")!=-1) {
                // 存小计
                map.put(receivable.getCustomerCode(),receivable);
            } else {
                List<Receivable> list1 = new ArrayList<>();
                if (dateMap.containsKey(receivable.getCustomerCode())) {
                    list1 = dateMap.get(receivable.getCustomerCode());
                }
                list1.add(receivable);
                dateMap.put(receivable.getCustomerCode(),list1);
            }
        }
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream())
        .useDefaultStyle(Boolean.FALSE).registerWriteHandler(new ReceivableWriteWidthConfig()) /*自适应列宽*/
        .registerWriteHandler(new ReceivableHeightWriteConfig()).build();
        WriteSheet writeSheet;int i = 0;
        for (Map.Entry<String,List<Receivable>> entry : dateMap.entrySet()) {
            List<Receivable> list1 = entry.getValue();
            list1.add(map.get(entry.getKey()+"(小计)"));
            String sheetName = entry.getValue().get(0).getCustomerName();
            if (StringUtils.isBlank(sheetName)) {
                sheetName = entry.getKey();
            }
            writeSheet = EasyExcel.writerSheet(i, sheetName).head(Receivable.class).build();
            excelWriter.write(list1, writeSheet);
            i++;
        }
        excelWriter.finish();
//        List<Receivable> test = new ArrayList<>();
//        test.add(title);test.add(column);
//        EasyExcel.write(response.getOutputStream(), Receivable.class)
//        .sheet("模板111")
//        .doWrite(() -> {
//            // 分页查询数据
//            return test;
//        });
    }


    @GetMapping("/test")
    public Result test1() {
        return new Result("200","This is an about page!");
    }

}
