package com.rfjttest.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;


/**
 * @author Chen Zhenyang
 * @Data 2024/6/9
 * @apiNote
 */
@Data
public class Receivable {

    // 往来单位编码
    @ExcelProperty(value = "往来单位编码")
    private String customerCode;

    // 往来单位名称
    @ExcelProperty(value = "往来单位名称")
    private String customerName;

    // 集团客户
    @ExcelProperty(value = "集团客户")
    private String customer;

    // 客户分组
    @ExcelProperty(value = "客户分组")
    private String customerGroup;

    // 销售组织
    @ExcelProperty(value = "销售组织")
    private String SalesOrg;

    // 结算组织
    @ExcelProperty(value = "结算组织")
    private String SettleOrg;

    // 收款组织
    @ExcelProperty(value = "收款组织")
    private String ReceOrg;

    // 销售部门名称
    @ExcelProperty(value = "销售部门名称")
    private String SalesDeptName;

    // 销售部门分组
    @ExcelProperty(value = "销售部门分组")
    private String SalesDeptGroup;

    // 销售组
    @ExcelProperty(value = "销售组")
    private String SalesGroup;

    // 销售员
    @ExcelProperty(value = "销售员")
    private String Sales;

    // 业务描述
    @ExcelProperty(value = "业务描述")
    private String businessType;

    // 单据类型
    @ExcelProperty(value = "单据类型")
    private String documenType;

    // 单据编码
    @ExcelProperty(value = "单据编码")
    private String documentCode;

    // 订单编号
    @ExcelProperty(value = "订单编号")
    private String orderCode;

    // 物料编号
    @ExcelProperty(value = "物料编号")
    private String mateCode;

    // 物料名称
    @ExcelProperty(value = "物料名称")
    private String mateName;

    // 规格型号
    @ExcelProperty(value = "规格型号")
    private String model;

    // 批号
    @ExcelProperty(value = "批号")
    private String batch;

    // 计价单位
    @ExcelProperty(value = "计价单位")
    private String priceUnit;

    // 计价数量
    @ExcelProperty(value = "计价数量")
    private String priceNumber;

    // 含税单价
    @ExcelProperty(value = "含税单价")
    private String taxPrice;

    // 折扣额
    @ExcelProperty(value = "折扣额")
    private String discount;

    // 立账类型
    @ExcelProperty(value = "立账类型")
    private String accounType;

    // 现销(现场交易)
    @ExcelProperty(value = "现销")
    private String currentSales;

    // 业务日期
    @ExcelProperty(value = "业务日期")
    private String businessDate;

    // 备注
    @ExcelProperty(value = "备注")
    private String remarks;

    // 订货方
    @ExcelProperty(value = "订货方")
    private String order;

    // 收货方
    @ExcelProperty(value = "收货方")
    private String recipient;

    // 付款方
    @ExcelProperty(value = "付款方")
    private String payer;

    // 收款用途
    @ExcelProperty(value = "收款用途")
    private String collectionPurpose;

    // (原币)币别
    @ExcelProperty(value = "(原币)币别")
    private String oCurrency;

    // (原币)本期应收
    @ExcelProperty(value = "(原币)本期应收")
    private String oReceivable;

    // (原币)已开票金额
    @ExcelProperty(value = "(原币)已开票金额")
    private String oInvoiced;

    // (原币)本期收款
    @ExcelProperty(value = "(原币)本期收款")
    private String oCollection;

    // (原币)本期冲销额
    @ExcelProperty(value = "(原币)本期冲销额")
    private String oOffset;

    // (原币)期末余额
    @ExcelProperty(value = "(原币)期末余额")
    private String oEndingBalance;

    // (原币)收款币别
    @ExcelProperty(value = "(原币)收款币别")
    private String oReceipt;

    // (原币)收款币别金额
    @ExcelProperty(value = "(原币)收款币别金额")
    private String oPayment;

    // (本位币)币别
    @ExcelProperty(value = "(本位币)币别")
    private String bCurrency;

    // (本位币)本期应收
    @ExcelProperty(value = "(本位币)本期应收")
    private String bReceivable;

    // (本位币)已开票金额
    @ExcelProperty(value = "(本位币)已开票金额")
    private String bInvoiced;

    // (本位币)本期收款
    @ExcelProperty(value = "(本位币)本期收款")
    private String bCollection;

    // (本位币)本期冲销额
    @ExcelProperty(value = "(本位币)本期冲销额")
    private String bOffset;

    // (本位币)期末余额
    @ExcelProperty(value = "(本位币)期末余额")
    private String bEndingBalance;

    // 源单类型
    @ExcelProperty(value = "源单类型")
    private String orderType;

    // 源单编号
    @ExcelProperty(value = "源单编号")
    private String orderNumber;

    // 明细备注
    @ExcelProperty(value = "明细备注")
    private String detailedRemark;

    // 凭证.会计年度
    @ExcelProperty(value = "凭证.会计年度")
    private String year;

    // 凭证.会计期间
    @ExcelProperty(value = "凭证.会计期间")
    private String period;

    // 凭证.凭证号
    @ExcelProperty(value = "凭证.凭证号")
    private String voucherCode;

    // 凭证.凭证字
    @ExcelProperty(value = "凭证.凭证字")
    private String voucherWord;

}
