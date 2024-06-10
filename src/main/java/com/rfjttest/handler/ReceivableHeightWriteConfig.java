package com.rfjttest.handler;

import com.alibaba.excel.write.style.row.AbstractRowHeightStyleStrategy;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.util.Iterator;

/**
 * @author Chen Zhenyang
 * @Data 2024/6/10
 * @apiNote excel 导出默认高度
 */
public class ReceivableHeightWriteConfig extends AbstractRowHeightStyleStrategy {

    /**
     * 默认高度
     */
    private static final Integer DEFAULT_HEIGHT = 300;

    @Override
    protected void setHeadColumnHeight(Row row, int x) {

    }

    @Override
    protected void setContentColumnHeight(Row row, int x) {
        Iterator<Cell> cellIterator = row.cellIterator();
        if (!cellIterator.hasNext()) {
            return;
        }
        // 默认为 1行高度
        int maxHeight = 2;
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if (cell.getCellTypeEnum() == CellType.STRING) {
                String value = cell.getStringCellValue();
                int len = value.length();
                int num = 0;
                if (len > 50) {
                    num = len % 50 > 0 ? len / 50 : len / 2 - 1;
                }
                if (num > 0) {
                    for (int i = 0; i < num; i++) {
                        value = value.substring(0, (i + 1) * 50 + i) + "\n" + value.substring((i + 1) * 50 + i, len + i);
                    }
                }
                if (value.contains("\n")) {
                    int length = value.split("\n").length;
                    maxHeight = Math.max(maxHeight, length) + 1;
                }
            }
        }
        row.setHeight((short) ((maxHeight) * DEFAULT_HEIGHT));
    }
}
