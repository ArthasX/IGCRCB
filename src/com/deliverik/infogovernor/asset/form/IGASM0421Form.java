/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import java.math.BigDecimal;
import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;

/**
 * 概述: 合同付款登记Form
 * 功能描述: 合同付款登记Form
 * 创建记录: 2012/04/27
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM0421Form extends BaseForm implements SOC0129SearchCond{
	
	/** 资产eiid */
	protected String eiid;
	
	/** 第一笔付款额 */
	protected String expectday1;
	
	/** 第一笔应付日 */
	protected String actualday1;
	
	/** 第一笔实付日 */
	protected String actualmoney1;
	
	/** 发票说明 */
	protected String invoiceexplain1;
	
	/** 第二笔付款额 */
	protected String expectday2;
	
	/** 第二笔应付日 */
	protected String actualday2;
	
	/** 第二笔实付日 */
	protected String actualmoney2;
	
	/** 发票说明 */
	protected String invoiceexplain2;
	
	/** 第三笔付款额 */
	protected String expectday3;
	
	/** 第三笔应付日 */
	protected String actualday3;
	
	/** 第三笔实付日 */
	protected String actualmoney3;
	
	/** 发票说明 */
	protected String invoiceexplain3;
	
	/** 第四笔付款额 */
	protected String expectday4;
	
	/** 第四笔应付日 */
	protected String actualday4;
	
	/** 第四笔实付日 */
	protected String actualmoney4;
	
	/** 发票说明 */
	protected String invoiceexplain4;
    
    /** 第五笔付款额 */
    protected String expectday5;
    
    /** 第五笔应付日 */
    protected String actualday5;
    
    /** 第五笔实付日 */
    protected String actualmoney5;
    
    /** 发票说明 */
    protected String invoiceexplain5;
    
    /** 第6笔付款额 */
    protected String expectday6;
    
    /** 第6笔应付日 */
    protected String actualday6;
    
    /** 第6笔实付日 */
    protected String actualmoney6;
    
    /** 发票说明 */
    protected String invoiceexplain6;
    
    /** 第7笔付款额 */
    protected String expectday7;
    
    /** 第7笔应付日 */
    protected String actualday7;
    
    /** 第7笔实付日 */
    protected String actualmoney7;
    
    /** 发票说明 */
    protected String invoiceexplain7;
    
    /** 第8笔付款额 */
    protected String expectday8;
    
    /** 第8笔应付日 */
    protected String actualday8;
    
    /** 第8笔实付日 */
    protected String actualmoney8;
    
    /** 发票说明 */
    protected String invoiceexplain8;
    
    /** 第9笔付款额 */
    protected String expectday9;
    
    /** 第9笔应付日 */
    protected String actualday9;
    
    /** 第9笔实付日 */
    protected String actualmoney9;
    
    /** 发票说明 */
    protected String invoiceexplain9;
    
    /** 第10笔付款额 */
    protected String expectday10;
    
    /** 第10笔应付日 */
    protected String actualday10;
    
    /** 第10笔实付日 */
    protected String actualmoney10;
    
    /** 发票说明 */
    protected String invoiceexplain10;
    
    /** 第11笔付款额 */
    protected String expectday11;
    
    /** 第11笔应付日 */
    protected String actualday11;
    
    /** 第11笔实付日 */
    protected String actualmoney11;
    
    /** 发票说明 */
    protected String invoiceexplain11;
    
    /** 第12笔付款额 */
    protected String expectday12;
    
    /** 第12笔应付日 */
    protected String actualday12;
    
    /** 第12笔实付日 */
    protected String actualmoney12;
    
    /** 发票说明 */
    protected String invoiceexplain12;
    
    /** 第13笔付款额 */
    protected String expectday13;
    
    /** 第13笔应付日 */
    protected String actualday13;
    
    /** 第13笔实付日 */
    protected String actualmoney13;
    
    /** 发票说明 */
    protected String invoiceexplain13;
    
    /** 第14笔付款额 */
    protected String expectday14;
    
    /** 第14笔应付日 */
    protected String actualday14;
    
    /** 第14笔实付日 */
    protected String actualmoney14;
    
    /** 发票说明 */
    protected String invoiceexplain14;
    
    /** 第15笔付款额 */
    protected String expectday15;
    
    /** 第15笔应付日 */
    protected String actualday15;
    
    /** 第15笔实付日 */
    protected String actualmoney15;
    
    /** 发票说明 */
    protected String invoiceexplain15;
	
	/** 资产版本 */
	protected Integer eiversion;
	
	/** 机构层次码 */
	protected String eiorgsyscoding;
	
	/** 资产模型码 */
	protected String esyscoding_q;
	
	/** 已付款 */
	protected BigDecimal accountMoney=new BigDecimal(0.0);
	
	/** 最后付款日 */
	protected String lastDateTime;
	
	/** 付款标识 */
	protected boolean flag1=false;
	protected boolean flag2=false;
	protected boolean flag3=false;
	protected boolean flag4=false;
	protected boolean flag5=false;
	protected boolean flag6=false;
	protected boolean flag7=false;
	protected boolean flag8=false;
	protected boolean flag9=false;
	protected boolean flag10=false;
	protected boolean flag11=false;
	protected boolean flag12=false;
	protected boolean flag13=false;
	protected boolean flag14=false;
	
	/** 第一笔制单日 */
	protected String zhidanday1;
	
	/** 第一笔应付款比例 */
	protected String yingfumoneyratio1;
	
	/** 第一笔实付款额 */
	protected String shifumoney1;
	
	/** 第二笔制单日 */
	protected String zhidanday2;
	
	/** 第二笔应付款比例 */
	protected String yingfumoneyratio2;
	
	/** 第二笔实付款额 */
	protected String shifumoney2;
	
	/** 第三笔制单日 */
	protected String zhidanday3;
	
	/** 第三笔应付款比例 */
	protected String yingfumoneyratio3;
	
	/** 第三笔实付款额 */
	protected String shifumoney3;
	
	/** 第四笔制单日 */
	protected String zhidanday4;
	
	/** 第四笔应付款比例 */
	protected String yingfumoneyratio4;
	
	/** 第四笔实付款额 */
	protected String shifumoney4;
	
	/** 第五笔制单日 */
	protected String zhidanday5;
	
	/** 第五笔应付款比例 */
	protected String yingfumoneyratio5;
	
	/** 第五笔实付款额 */
	protected String shifumoney5;
	
	/** 第6笔制单日 */
    protected String zhidanday6;
    
    /** 第6笔应付款比例 */
    protected String yingfumoneyratio6;
    
    /** 第6笔实付款额 */
    protected String shifumoney6;
    
    /** 第7笔制单日 */
    protected String zhidanday7;
    
    /** 第7笔应付款比例 */
    protected String yingfumoneyratio7;
    
    /** 第7笔实付款额 */
    protected String shifumoney7;
    
    /** 第8笔制单日 */
    protected String zhidanday8;
    
    /** 第8笔应付款比例 */
    protected String yingfumoneyratio8;
    
    /** 第8笔实付款额 */
    protected String shifumoney8;
    
    /** 第9笔制单日 */
    protected String zhidanday9;
    
    /** 第9笔应付款比例 */
    protected String yingfumoneyratio9;
    
    /** 第9笔实付款额 */
    protected String shifumoney9;
    
    /** 第10笔制单日 */
    protected String zhidanday10;
    
    /** 第10笔应付款比例 */
    protected String yingfumoneyratio10;
    
    /** 第10笔实付款额 */
    protected String shifumoney10;
    
    /** 第11笔制单日 */
    protected String zhidanday11;
    
    /** 第11笔应付款比例 */
    protected String yingfumoneyratio11;
    
    /** 第11笔实付款额 */
    protected String shifumoney11;
    
    /** 第12笔制单日 */
    protected String zhidanday12;
    
    /** 第12笔应付款比例 */
    protected String yingfumoneyratio12;
    
    /** 第12笔实付款额 */
    protected String shifumoney12;
    
    /** 第13笔制单日 */
    protected String zhidanday13;
    
    /** 第13笔应付款比例 */
    protected String yingfumoneyratio13;
    
    /** 第13笔实付款额 */
    protected String shifumoney13;
    
    /** 第14笔制单日 */
    protected String zhidanday14;
    
    /** 第14笔应付款比例 */
    protected String yingfumoneyratio14;
    
    /** 第14笔实付款额 */
    protected String shifumoney14;
    
    /** 第15笔制单日 */
    protected String zhidanday15;
    
    /** 第15笔应付款比例 */
    protected String yingfumoneyratio15;
    
    /** 第15笔实付款额 */
    protected String shifumoney15;
	
	/** 第一笔付款主键 */
	protected String contractId1;
	
	/** 第一笔付款编号 */
	protected String contractLabel1;
	
	/** 第一笔付款名称 */
	protected String contractName1;
	
	/** 第一笔付款发票说明 */
	protected String contractDesc1;
	
	/** 第二笔付款主键 */
	protected String contractId2;
	
	/** 第二笔付款编号 */
	protected String contractLabel2;
	
	/** 第二笔付款名称 */
	protected String contractName2;
	
	/** 第二笔付款发票说明 */
	protected String contractDesc2;
	
	/** 第三笔付款主键 */
	protected String contractId3;
	
	/** 第三笔付款编号 */
	protected String contractLabel3;
	
	/** 第三笔付款名称 */
	protected String contractName3;
	
	/** 第三笔付款发票说明 */
	protected String contractDesc3;
	
	/** 第四笔付款主键 */
	protected String contractId4;
	
	/** 第四笔付款编号 */
	protected String contractLabel4;
	
	/** 第四笔付款名称 */
	protected String contractName4;
	
	/** 第四笔付款发票说明 */
	protected String contractDesc4;
	
	/** 第五笔付款主键 */
	protected String contractId5;
	
	/** 第五笔付款编号 */
	protected String contractLabel5;
	
	/** 第五笔付款名称 */
	protected String contractName5;
	
	/** 第五笔付款发票说明 */
	protected String contractDesc5;
	
	/** 第6笔付款主键 */
    protected String contractId6;
    
    /** 第6笔付款编号 */
    protected String contractLabel6;
    
    /** 第6笔付款名称 */
    protected String contractName6;
    
    /** 第6笔付款发票说明 */
    protected String contractDesc6;
    
    /** 第7笔付款主键 */
    protected String contractId7;
    
    /** 第7笔付款编号 */
    protected String contractLabel7;
    
    /** 第7笔付款名称 */
    protected String contractName7;
    
    /** 第7笔付款发票说明 */
    protected String contractDesc7;
    
    /** 第8笔付款主键 */
    protected String contractId8;
    
    /** 第8笔付款编号 */
    protected String contractLabel8;
    
    /** 第8笔付款名称 */
    protected String contractName8;
    
    /** 第8笔付款发票说明 */
    protected String contractDesc8;
    
    /** 第9笔付款主键 */
    protected String contractId9;
    
    /** 第9笔付款编号 */
    protected String contractLabel9;
    
    /** 第9笔付款名称 */
    protected String contractName9;
    
    /** 第9笔付款发票说明 */
    protected String contractDesc9;
    
    /** 第10笔付款主键 */
    protected String contractId10;
    
    /** 第10笔付款编号 */
    protected String contractLabel10;
    
    /** 第10笔付款名称 */
    protected String contractName10;
    
    /** 第10笔付款发票说明 */
    protected String contractDesc10;
    
    /** 第11笔付款主键 */
    protected String contractId11;
    
    /** 第11笔付款编号 */
    protected String contractLabel11;
    
    /** 第11笔付款名称 */
    protected String contractName11;
    
    /** 第11笔付款发票说明 */
    protected String contractDesc11;
    
    /** 第12笔付款主键 */
    protected String contractId12;
    
    /** 第12笔付款编号 */
    protected String contractLabel12;
    
    /** 第12笔付款名称 */
    protected String contractName12;
    
    /** 第12笔付款发票说明 */
    protected String contractDesc12;
    
    /** 第13笔付款主键 */
    protected String contractId13;
    
    /** 第13笔付款编号 */
    protected String contractLabel13;
    
    /** 第13笔付款名称 */
    protected String contractName13;
    
    /** 第13笔付款发票说明 */
    protected String contractDesc13;
    
    /** 第14笔付款主键 */
    protected String contractId14;
    
    /** 第14笔付款编号 */
    protected String contractLabel14;
    
    /** 第14笔付款名称 */
    protected String contractName14;
    
    /** 第14笔付款发票说明 */
    protected String contractDesc14;
    
    /** 第15笔付款主键 */
    protected String contractId15;
    
    /** 第15笔付款编号 */
    protected String contractLabel15;
    
    /** 第15笔付款名称 */
    protected String contractName15;
    
    /** 第15笔付款发票说明 */
    protected String contractDesc15;
	
	/**
     * 第6笔付款额 is returned.
     * @return expectday6
     */
    public String getExpectday6() {
        return expectday6;
    }

    /**
     * 第6笔付款额 is set.
     * @param expectday6 第6笔付款额
     */
    public void setExpectday6(String expectday6) {
        this.expectday6 = expectday6;
    }

    /**
     * 第6笔应付日 is returned.
     * @return actualday6
     */
    public String getActualday6() {
        return actualday6;
    }

    /**
     * 第6笔应付日 is set.
     * @param actualday6 第6笔应付日
     */
    public void setActualday6(String actualday6) {
        this.actualday6 = actualday6;
    }

    /**
     * 第6笔实付日 is returned.
     * @return actualmoney6
     */
    public String getActualmoney6() {
        return actualmoney6;
    }

    /**
     * 第6笔实付日 is set.
     * @param actualmoney6 第6笔实付日
     */
    public void setActualmoney6(String actualmoney6) {
        this.actualmoney6 = actualmoney6;
    }

    /**
     * 发票说明 is returned.
     * @return invoiceexplain6
     */
    public String getInvoiceexplain6() {
        return invoiceexplain6;
    }

    /**
     * 发票说明 is set.
     * @param invoiceexplain6 发票说明
     */
    public void setInvoiceexplain6(String invoiceexplain6) {
        this.invoiceexplain6 = invoiceexplain6;
    }

    /**
     * 第7笔付款额 is returned.
     * @return expectday7
     */
    public String getExpectday7() {
        return expectday7;
    }

    /**
     * 第7笔付款额 is set.
     * @param expectday7 第7笔付款额
     */
    public void setExpectday7(String expectday7) {
        this.expectday7 = expectday7;
    }

    /**
     * 第7笔应付日 is returned.
     * @return actualday7
     */
    public String getActualday7() {
        return actualday7;
    }

    /**
     * 第7笔应付日 is set.
     * @param actualday7 第7笔应付日
     */
    public void setActualday7(String actualday7) {
        this.actualday7 = actualday7;
    }

    /**
     * 第7笔实付日 is returned.
     * @return actualmoney7
     */
    public String getActualmoney7() {
        return actualmoney7;
    }

    /**
     * 第7笔实付日 is set.
     * @param actualmoney7 第7笔实付日
     */
    public void setActualmoney7(String actualmoney7) {
        this.actualmoney7 = actualmoney7;
    }

    /**
     * 发票说明 is returned.
     * @return invoiceexplain7
     */
    public String getInvoiceexplain7() {
        return invoiceexplain7;
    }

    /**
     * 发票说明 is set.
     * @param invoiceexplain7 发票说明
     */
    public void setInvoiceexplain7(String invoiceexplain7) {
        this.invoiceexplain7 = invoiceexplain7;
    }

    /**
     * 第8笔付款额 is returned.
     * @return expectday8
     */
    public String getExpectday8() {
        return expectday8;
    }

    /**
     * 第8笔付款额 is set.
     * @param expectday8 第8笔付款额
     */
    public void setExpectday8(String expectday8) {
        this.expectday8 = expectday8;
    }

    /**
     * 第8笔应付日 is returned.
     * @return actualday8
     */
    public String getActualday8() {
        return actualday8;
    }

    /**
     * 第8笔应付日 is set.
     * @param actualday8 第8笔应付日
     */
    public void setActualday8(String actualday8) {
        this.actualday8 = actualday8;
    }

    /**
     * 第8笔实付日 is returned.
     * @return actualmoney8
     */
    public String getActualmoney8() {
        return actualmoney8;
    }

    /**
     * 第8笔实付日 is set.
     * @param actualmoney8 第8笔实付日
     */
    public void setActualmoney8(String actualmoney8) {
        this.actualmoney8 = actualmoney8;
    }

    /**
     * 发票说明 is returned.
     * @return invoiceexplain8
     */
    public String getInvoiceexplain8() {
        return invoiceexplain8;
    }

    /**
     * 发票说明 is set.
     * @param invoiceexplain8 发票说明
     */
    public void setInvoiceexplain8(String invoiceexplain8) {
        this.invoiceexplain8 = invoiceexplain8;
    }

    /**
     * 第9笔付款额 is returned.
     * @return expectday9
     */
    public String getExpectday9() {
        return expectday9;
    }

    /**
     * 第9笔付款额 is set.
     * @param expectday9 第9笔付款额
     */
    public void setExpectday9(String expectday9) {
        this.expectday9 = expectday9;
    }

    /**
     * 第9笔应付日 is returned.
     * @return actualday9
     */
    public String getActualday9() {
        return actualday9;
    }

    /**
     * 第9笔应付日 is set.
     * @param actualday9 第9笔应付日
     */
    public void setActualday9(String actualday9) {
        this.actualday9 = actualday9;
    }

    /**
     * 第9笔实付日 is returned.
     * @return actualmoney9
     */
    public String getActualmoney9() {
        return actualmoney9;
    }

    /**
     * 第9笔实付日 is set.
     * @param actualmoney9 第9笔实付日
     */
    public void setActualmoney9(String actualmoney9) {
        this.actualmoney9 = actualmoney9;
    }

    /**
     * 发票说明 is returned.
     * @return invoiceexplain9
     */
    public String getInvoiceexplain9() {
        return invoiceexplain9;
    }

    /**
     * 发票说明 is set.
     * @param invoiceexplain9 发票说明
     */
    public void setInvoiceexplain9(String invoiceexplain9) {
        this.invoiceexplain9 = invoiceexplain9;
    }

    /**
     * 第10笔付款额 is returned.
     * @return expectday10
     */
    public String getExpectday10() {
        return expectday10;
    }

    /**
     * 第10笔付款额 is set.
     * @param expectday10 第10笔付款额
     */
    public void setExpectday10(String expectday10) {
        this.expectday10 = expectday10;
    }

    /**
     * 第10笔应付日 is returned.
     * @return actualday10
     */
    public String getActualday10() {
        return actualday10;
    }

    /**
     * 第10笔应付日 is set.
     * @param actualday10 第10笔应付日
     */
    public void setActualday10(String actualday10) {
        this.actualday10 = actualday10;
    }

    /**
     * 第10笔实付日 is returned.
     * @return actualmoney10
     */
    public String getActualmoney10() {
        return actualmoney10;
    }

    /**
     * 第10笔实付日 is set.
     * @param actualmoney10 第10笔实付日
     */
    public void setActualmoney10(String actualmoney10) {
        this.actualmoney10 = actualmoney10;
    }

    /**
     * 发票说明 is returned.
     * @return invoiceexplain10
     */
    public String getInvoiceexplain10() {
        return invoiceexplain10;
    }

    /**
     * 发票说明 is set.
     * @param invoiceexplain10 发票说明
     */
    public void setInvoiceexplain10(String invoiceexplain10) {
        this.invoiceexplain10 = invoiceexplain10;
    }

    /**
     * 第11笔付款额 is returned.
     * @return expectday11
     */
    public String getExpectday11() {
        return expectday11;
    }

    /**
     * 第11笔付款额 is set.
     * @param expectday11 第11笔付款额
     */
    public void setExpectday11(String expectday11) {
        this.expectday11 = expectday11;
    }

    /**
     * 第11笔应付日 is returned.
     * @return actualday11
     */
    public String getActualday11() {
        return actualday11;
    }

    /**
     * 第11笔应付日 is set.
     * @param actualday11 第11笔应付日
     */
    public void setActualday11(String actualday11) {
        this.actualday11 = actualday11;
    }

    /**
     * 第11笔实付日 is returned.
     * @return actualmoney11
     */
    public String getActualmoney11() {
        return actualmoney11;
    }

    /**
     * 第11笔实付日 is set.
     * @param actualmoney11 第11笔实付日
     */
    public void setActualmoney11(String actualmoney11) {
        this.actualmoney11 = actualmoney11;
    }

    /**
     * 发票说明 is returned.
     * @return invoiceexplain11
     */
    public String getInvoiceexplain11() {
        return invoiceexplain11;
    }

    /**
     * 发票说明 is set.
     * @param invoiceexplain11 发票说明
     */
    public void setInvoiceexplain11(String invoiceexplain11) {
        this.invoiceexplain11 = invoiceexplain11;
    }

    /**
     * 第12笔付款额 is returned.
     * @return expectday12
     */
    public String getExpectday12() {
        return expectday12;
    }

    /**
     * 第12笔付款额 is set.
     * @param expectday12 第12笔付款额
     */
    public void setExpectday12(String expectday12) {
        this.expectday12 = expectday12;
    }

    /**
     * 第12笔应付日 is returned.
     * @return actualday12
     */
    public String getActualday12() {
        return actualday12;
    }

    /**
     * 第12笔应付日 is set.
     * @param actualday12 第12笔应付日
     */
    public void setActualday12(String actualday12) {
        this.actualday12 = actualday12;
    }

    /**
     * 第12笔实付日 is returned.
     * @return actualmoney12
     */
    public String getActualmoney12() {
        return actualmoney12;
    }

    /**
     * 第12笔实付日 is set.
     * @param actualmoney12 第12笔实付日
     */
    public void setActualmoney12(String actualmoney12) {
        this.actualmoney12 = actualmoney12;
    }

    /**
     * 发票说明 is returned.
     * @return invoiceexplain12
     */
    public String getInvoiceexplain12() {
        return invoiceexplain12;
    }

    /**
     * 发票说明 is set.
     * @param invoiceexplain12 发票说明
     */
    public void setInvoiceexplain12(String invoiceexplain12) {
        this.invoiceexplain12 = invoiceexplain12;
    }

    /**
     * 第13笔付款额 is returned.
     * @return expectday13
     */
    public String getExpectday13() {
        return expectday13;
    }

    /**
     * 第13笔付款额 is set.
     * @param expectday13 第13笔付款额
     */
    public void setExpectday13(String expectday13) {
        this.expectday13 = expectday13;
    }

    /**
     * 第13笔应付日 is returned.
     * @return actualday13
     */
    public String getActualday13() {
        return actualday13;
    }

    /**
     * 第13笔应付日 is set.
     * @param actualday13 第13笔应付日
     */
    public void setActualday13(String actualday13) {
        this.actualday13 = actualday13;
    }

    /**
     * 第13笔实付日 is returned.
     * @return actualmoney13
     */
    public String getActualmoney13() {
        return actualmoney13;
    }

    /**
     * 第13笔实付日 is set.
     * @param actualmoney13 第13笔实付日
     */
    public void setActualmoney13(String actualmoney13) {
        this.actualmoney13 = actualmoney13;
    }

    /**
     * 发票说明 is returned.
     * @return invoiceexplain13
     */
    public String getInvoiceexplain13() {
        return invoiceexplain13;
    }

    /**
     * 发票说明 is set.
     * @param invoiceexplain13 发票说明
     */
    public void setInvoiceexplain13(String invoiceexplain13) {
        this.invoiceexplain13 = invoiceexplain13;
    }

    /**
     * 第14笔付款额 is returned.
     * @return expectday14
     */
    public String getExpectday14() {
        return expectday14;
    }

    /**
     * 第14笔付款额 is set.
     * @param expectday14 第14笔付款额
     */
    public void setExpectday14(String expectday14) {
        this.expectday14 = expectday14;
    }

    /**
     * 第14笔应付日 is returned.
     * @return actualday14
     */
    public String getActualday14() {
        return actualday14;
    }

    /**
     * 第14笔应付日 is set.
     * @param actualday14 第14笔应付日
     */
    public void setActualday14(String actualday14) {
        this.actualday14 = actualday14;
    }

    /**
     * 第14笔实付日 is returned.
     * @return actualmoney14
     */
    public String getActualmoney14() {
        return actualmoney14;
    }

    /**
     * 第14笔实付日 is set.
     * @param actualmoney14 第14笔实付日
     */
    public void setActualmoney14(String actualmoney14) {
        this.actualmoney14 = actualmoney14;
    }

    /**
     * 发票说明 is returned.
     * @return invoiceexplain14
     */
    public String getInvoiceexplain14() {
        return invoiceexplain14;
    }

    /**
     * 发票说明 is set.
     * @param invoiceexplain14 发票说明
     */
    public void setInvoiceexplain14(String invoiceexplain14) {
        this.invoiceexplain14 = invoiceexplain14;
    }

    /**
     * 第15笔付款额 is returned.
     * @return expectday15
     */
    public String getExpectday15() {
        return expectday15;
    }

    /**
     * 第15笔付款额 is set.
     * @param expectday15 第15笔付款额
     */
    public void setExpectday15(String expectday15) {
        this.expectday15 = expectday15;
    }

    /**
     * 第15笔应付日 is returned.
     * @return actualday15
     */
    public String getActualday15() {
        return actualday15;
    }

    /**
     * 第15笔应付日 is set.
     * @param actualday15 第15笔应付日
     */
    public void setActualday15(String actualday15) {
        this.actualday15 = actualday15;
    }

    /**
     * 第15笔实付日 is returned.
     * @return actualmoney15
     */
    public String getActualmoney15() {
        return actualmoney15;
    }

    /**
     * 第15笔实付日 is set.
     * @param actualmoney15 第15笔实付日
     */
    public void setActualmoney15(String actualmoney15) {
        this.actualmoney15 = actualmoney15;
    }

    /**
     * 发票说明 is returned.
     * @return invoiceexplain15
     */
    public String getInvoiceexplain15() {
        return invoiceexplain15;
    }

    /**
     * 发票说明 is set.
     * @param invoiceexplain15 发票说明
     */
    public void setInvoiceexplain15(String invoiceexplain15) {
        this.invoiceexplain15 = invoiceexplain15;
    }

    /**
     * 第6笔制单日 is returned.
     * @return zhidanday6
     */
    public String getZhidanday6() {
        return zhidanday6;
    }

    /**
     * 第6笔制单日 is set.
     * @param zhidanday6 第6笔制单日
     */
    public void setZhidanday6(String zhidanday6) {
        this.zhidanday6 = zhidanday6;
    }

    /**
     * 第6笔应付款比例 is returned.
     * @return yingfumoneyratio6
     */
    public String getYingfumoneyratio6() {
        return yingfumoneyratio6;
    }

    /**
     * 第6笔应付款比例 is set.
     * @param yingfumoneyratio6 第6笔应付款比例
     */
    public void setYingfumoneyratio6(String yingfumoneyratio6) {
        this.yingfumoneyratio6 = yingfumoneyratio6;
    }

    /**
     * 第6笔实付款额 is returned.
     * @return shifumoney6
     */
    public String getShifumoney6() {
        return shifumoney6;
    }

    /**
     * 第6笔实付款额 is set.
     * @param shifumoney6 第6笔实付款额
     */
    public void setShifumoney6(String shifumoney6) {
        this.shifumoney6 = shifumoney6;
    }

    /**
     * 第7笔制单日 is returned.
     * @return zhidanday7
     */
    public String getZhidanday7() {
        return zhidanday7;
    }

    /**
     * 第7笔制单日 is set.
     * @param zhidanday7 第7笔制单日
     */
    public void setZhidanday7(String zhidanday7) {
        this.zhidanday7 = zhidanday7;
    }

    /**
     * 第7笔应付款比例 is returned.
     * @return yingfumoneyratio7
     */
    public String getYingfumoneyratio7() {
        return yingfumoneyratio7;
    }

    /**
     * 第7笔应付款比例 is set.
     * @param yingfumoneyratio7 第7笔应付款比例
     */
    public void setYingfumoneyratio7(String yingfumoneyratio7) {
        this.yingfumoneyratio7 = yingfumoneyratio7;
    }

    /**
     * 第7笔实付款额 is returned.
     * @return shifumoney7
     */
    public String getShifumoney7() {
        return shifumoney7;
    }

    /**
     * 第7笔实付款额 is set.
     * @param shifumoney7 第7笔实付款额
     */
    public void setShifumoney7(String shifumoney7) {
        this.shifumoney7 = shifumoney7;
    }

    /**
     * 第8笔制单日 is returned.
     * @return zhidanday8
     */
    public String getZhidanday8() {
        return zhidanday8;
    }

    /**
     * 第8笔制单日 is set.
     * @param zhidanday8 第8笔制单日
     */
    public void setZhidanday8(String zhidanday8) {
        this.zhidanday8 = zhidanday8;
    }

    /**
     * 第8笔应付款比例 is returned.
     * @return yingfumoneyratio8
     */
    public String getYingfumoneyratio8() {
        return yingfumoneyratio8;
    }

    /**
     * 第8笔应付款比例 is set.
     * @param yingfumoneyratio8 第8笔应付款比例
     */
    public void setYingfumoneyratio8(String yingfumoneyratio8) {
        this.yingfumoneyratio8 = yingfumoneyratio8;
    }

    /**
     * 第8笔实付款额 is returned.
     * @return shifumoney8
     */
    public String getShifumoney8() {
        return shifumoney8;
    }

    /**
     * 第8笔实付款额 is set.
     * @param shifumoney8 第8笔实付款额
     */
    public void setShifumoney8(String shifumoney8) {
        this.shifumoney8 = shifumoney8;
    }

    /**
     * 第9笔制单日 is returned.
     * @return zhidanday9
     */
    public String getZhidanday9() {
        return zhidanday9;
    }

    /**
     * 第9笔制单日 is set.
     * @param zhidanday9 第9笔制单日
     */
    public void setZhidanday9(String zhidanday9) {
        this.zhidanday9 = zhidanday9;
    }

    /**
     * 第9笔应付款比例 is returned.
     * @return yingfumoneyratio9
     */
    public String getYingfumoneyratio9() {
        return yingfumoneyratio9;
    }

    /**
     * 第9笔应付款比例 is set.
     * @param yingfumoneyratio9 第9笔应付款比例
     */
    public void setYingfumoneyratio9(String yingfumoneyratio9) {
        this.yingfumoneyratio9 = yingfumoneyratio9;
    }

    /**
     * 第9笔实付款额 is returned.
     * @return shifumoney9
     */
    public String getShifumoney9() {
        return shifumoney9;
    }

    /**
     * 第9笔实付款额 is set.
     * @param shifumoney9 第9笔实付款额
     */
    public void setShifumoney9(String shifumoney9) {
        this.shifumoney9 = shifumoney9;
    }

    /**
     * 第10笔制单日 is returned.
     * @return zhidanday10
     */
    public String getZhidanday10() {
        return zhidanday10;
    }

    /**
     * 第10笔制单日 is set.
     * @param zhidanday10 第10笔制单日
     */
    public void setZhidanday10(String zhidanday10) {
        this.zhidanday10 = zhidanday10;
    }

    /**
     * 第10笔应付款比例 is returned.
     * @return yingfumoneyratio10
     */
    public String getYingfumoneyratio10() {
        return yingfumoneyratio10;
    }

    /**
     * 第10笔应付款比例 is set.
     * @param yingfumoneyratio10 第10笔应付款比例
     */
    public void setYingfumoneyratio10(String yingfumoneyratio10) {
        this.yingfumoneyratio10 = yingfumoneyratio10;
    }

    /**
     * 第10笔实付款额 is returned.
     * @return shifumoney10
     */
    public String getShifumoney10() {
        return shifumoney10;
    }

    /**
     * 第10笔实付款额 is set.
     * @param shifumoney10 第10笔实付款额
     */
    public void setShifumoney10(String shifumoney10) {
        this.shifumoney10 = shifumoney10;
    }

    /**
     * 第11笔制单日 is returned.
     * @return zhidanday11
     */
    public String getZhidanday11() {
        return zhidanday11;
    }

    /**
     * 第11笔制单日 is set.
     * @param zhidanday11 第11笔制单日
     */
    public void setZhidanday11(String zhidanday11) {
        this.zhidanday11 = zhidanday11;
    }

    /**
     * 第11笔应付款比例 is returned.
     * @return yingfumoneyratio11
     */
    public String getYingfumoneyratio11() {
        return yingfumoneyratio11;
    }

    /**
     * 第11笔应付款比例 is set.
     * @param yingfumoneyratio11 第11笔应付款比例
     */
    public void setYingfumoneyratio11(String yingfumoneyratio11) {
        this.yingfumoneyratio11 = yingfumoneyratio11;
    }

    /**
     * 第11笔实付款额 is returned.
     * @return shifumoney11
     */
    public String getShifumoney11() {
        return shifumoney11;
    }

    /**
     * 第11笔实付款额 is set.
     * @param shifumoney11 第11笔实付款额
     */
    public void setShifumoney11(String shifumoney11) {
        this.shifumoney11 = shifumoney11;
    }

    /**
     * 第12笔制单日 is returned.
     * @return zhidanday12
     */
    public String getZhidanday12() {
        return zhidanday12;
    }

    /**
     * 第12笔制单日 is set.
     * @param zhidanday12 第12笔制单日
     */
    public void setZhidanday12(String zhidanday12) {
        this.zhidanday12 = zhidanday12;
    }

    /**
     * 第12笔应付款比例 is returned.
     * @return yingfumoneyratio12
     */
    public String getYingfumoneyratio12() {
        return yingfumoneyratio12;
    }

    /**
     * 第12笔应付款比例 is set.
     * @param yingfumoneyratio12 第12笔应付款比例
     */
    public void setYingfumoneyratio12(String yingfumoneyratio12) {
        this.yingfumoneyratio12 = yingfumoneyratio12;
    }

    /**
     * 第12笔实付款额 is returned.
     * @return shifumoney12
     */
    public String getShifumoney12() {
        return shifumoney12;
    }

    /**
     * 第12笔实付款额 is set.
     * @param shifumoney12 第12笔实付款额
     */
    public void setShifumoney12(String shifumoney12) {
        this.shifumoney12 = shifumoney12;
    }

    /**
     * 第13笔制单日 is returned.
     * @return zhidanday13
     */
    public String getZhidanday13() {
        return zhidanday13;
    }

    /**
     * 第13笔制单日 is set.
     * @param zhidanday13 第13笔制单日
     */
    public void setZhidanday13(String zhidanday13) {
        this.zhidanday13 = zhidanday13;
    }

    /**
     * 第13笔应付款比例 is returned.
     * @return yingfumoneyratio13
     */
    public String getYingfumoneyratio13() {
        return yingfumoneyratio13;
    }

    /**
     * 第13笔应付款比例 is set.
     * @param yingfumoneyratio13 第13笔应付款比例
     */
    public void setYingfumoneyratio13(String yingfumoneyratio13) {
        this.yingfumoneyratio13 = yingfumoneyratio13;
    }

    /**
     * 第13笔实付款额 is returned.
     * @return shifumoney13
     */
    public String getShifumoney13() {
        return shifumoney13;
    }

    /**
     * 第13笔实付款额 is set.
     * @param shifumoney13 第13笔实付款额
     */
    public void setShifumoney13(String shifumoney13) {
        this.shifumoney13 = shifumoney13;
    }

    /**
     * 第14笔制单日 is returned.
     * @return zhidanday14
     */
    public String getZhidanday14() {
        return zhidanday14;
    }

    /**
     * 第14笔制单日 is set.
     * @param zhidanday14 第14笔制单日
     */
    public void setZhidanday14(String zhidanday14) {
        this.zhidanday14 = zhidanday14;
    }

    /**
     * 第14笔应付款比例 is returned.
     * @return yingfumoneyratio14
     */
    public String getYingfumoneyratio14() {
        return yingfumoneyratio14;
    }

    /**
     * 第14笔应付款比例 is set.
     * @param yingfumoneyratio14 第14笔应付款比例
     */
    public void setYingfumoneyratio14(String yingfumoneyratio14) {
        this.yingfumoneyratio14 = yingfumoneyratio14;
    }

    /**
     * 第14笔实付款额 is returned.
     * @return shifumoney14
     */
    public String getShifumoney14() {
        return shifumoney14;
    }

    /**
     * 第14笔实付款额 is set.
     * @param shifumoney14 第14笔实付款额
     */
    public void setShifumoney14(String shifumoney14) {
        this.shifumoney14 = shifumoney14;
    }

    /**
     * 第15笔制单日 is returned.
     * @return zhidanday15
     */
    public String getZhidanday15() {
        return zhidanday15;
    }

    /**
     * 第15笔制单日 is set.
     * @param zhidanday15 第15笔制单日
     */
    public void setZhidanday15(String zhidanday15) {
        this.zhidanday15 = zhidanday15;
    }

    /**
     * 第15笔应付款比例 is returned.
     * @return yingfumoneyratio15
     */
    public String getYingfumoneyratio15() {
        return yingfumoneyratio15;
    }

    /**
     * 第15笔应付款比例 is set.
     * @param yingfumoneyratio15 第15笔应付款比例
     */
    public void setYingfumoneyratio15(String yingfumoneyratio15) {
        this.yingfumoneyratio15 = yingfumoneyratio15;
    }

    /**
     * 第15笔实付款额 is returned.
     * @return shifumoney15
     */
    public String getShifumoney15() {
        return shifumoney15;
    }

    /**
     * 第15笔实付款额 is set.
     * @param shifumoney15 第15笔实付款额
     */
    public void setShifumoney15(String shifumoney15) {
        this.shifumoney15 = shifumoney15;
    }

    /**
     * 第6笔付款主键 is returned.
     * @return contractId6
     */
    public String getContractId6() {
        return contractId6;
    }

    /**
     * 第6笔付款主键 is set.
     * @param contractId6 第6笔付款主键
     */
    public void setContractId6(String contractId6) {
        this.contractId6 = contractId6;
    }

    /**
     * 第6笔付款编号 is returned.
     * @return contractLabel6
     */
    public String getContractLabel6() {
        return contractLabel6;
    }

    /**
     * 第6笔付款编号 is set.
     * @param contractLabel6 第6笔付款编号
     */
    public void setContractLabel6(String contractLabel6) {
        this.contractLabel6 = contractLabel6;
    }

    /**
     * 第6笔付款名称 is returned.
     * @return contractName6
     */
    public String getContractName6() {
        return contractName6;
    }

    /**
     * 第6笔付款名称 is set.
     * @param contractName6 第6笔付款名称
     */
    public void setContractName6(String contractName6) {
        this.contractName6 = contractName6;
    }

    /**
     * 第6笔付款发票说明 is returned.
     * @return contractDesc6
     */
    public String getContractDesc6() {
        return contractDesc6;
    }

    /**
     * 第6笔付款发票说明 is set.
     * @param contractDesc6 第6笔付款发票说明
     */
    public void setContractDesc6(String contractDesc6) {
        this.contractDesc6 = contractDesc6;
    }

    /**
     * 第7笔付款主键 is returned.
     * @return contractId7
     */
    public String getContractId7() {
        return contractId7;
    }

    /**
     * 第7笔付款主键 is set.
     * @param contractId7 第7笔付款主键
     */
    public void setContractId7(String contractId7) {
        this.contractId7 = contractId7;
    }

    /**
     * 第7笔付款编号 is returned.
     * @return contractLabel7
     */
    public String getContractLabel7() {
        return contractLabel7;
    }

    /**
     * 第7笔付款编号 is set.
     * @param contractLabel7 第7笔付款编号
     */
    public void setContractLabel7(String contractLabel7) {
        this.contractLabel7 = contractLabel7;
    }

    /**
     * 第7笔付款名称 is returned.
     * @return contractName7
     */
    public String getContractName7() {
        return contractName7;
    }

    /**
     * 第7笔付款名称 is set.
     * @param contractName7 第7笔付款名称
     */
    public void setContractName7(String contractName7) {
        this.contractName7 = contractName7;
    }

    /**
     * 第7笔付款发票说明 is returned.
     * @return contractDesc7
     */
    public String getContractDesc7() {
        return contractDesc7;
    }

    /**
     * 第7笔付款发票说明 is set.
     * @param contractDesc7 第7笔付款发票说明
     */
    public void setContractDesc7(String contractDesc7) {
        this.contractDesc7 = contractDesc7;
    }

    /**
     * 第8笔付款主键 is returned.
     * @return contractId8
     */
    public String getContractId8() {
        return contractId8;
    }

    /**
     * 第8笔付款主键 is set.
     * @param contractId8 第8笔付款主键
     */
    public void setContractId8(String contractId8) {
        this.contractId8 = contractId8;
    }

    /**
     * 第8笔付款编号 is returned.
     * @return contractLabel8
     */
    public String getContractLabel8() {
        return contractLabel8;
    }

    /**
     * 第8笔付款编号 is set.
     * @param contractLabel8 第8笔付款编号
     */
    public void setContractLabel8(String contractLabel8) {
        this.contractLabel8 = contractLabel8;
    }

    /**
     * 第8笔付款名称 is returned.
     * @return contractName8
     */
    public String getContractName8() {
        return contractName8;
    }

    /**
     * 第8笔付款名称 is set.
     * @param contractName8 第8笔付款名称
     */
    public void setContractName8(String contractName8) {
        this.contractName8 = contractName8;
    }

    /**
     * 第8笔付款发票说明 is returned.
     * @return contractDesc8
     */
    public String getContractDesc8() {
        return contractDesc8;
    }

    /**
     * 第8笔付款发票说明 is set.
     * @param contractDesc8 第8笔付款发票说明
     */
    public void setContractDesc8(String contractDesc8) {
        this.contractDesc8 = contractDesc8;
    }

    /**
     * 第9笔付款主键 is returned.
     * @return contractId9
     */
    public String getContractId9() {
        return contractId9;
    }

    /**
     * 第9笔付款主键 is set.
     * @param contractId9 第9笔付款主键
     */
    public void setContractId9(String contractId9) {
        this.contractId9 = contractId9;
    }

    /**
     * 第9笔付款编号 is returned.
     * @return contractLabel9
     */
    public String getContractLabel9() {
        return contractLabel9;
    }

    /**
     * 第9笔付款编号 is set.
     * @param contractLabel9 第9笔付款编号
     */
    public void setContractLabel9(String contractLabel9) {
        this.contractLabel9 = contractLabel9;
    }

    /**
     * 第9笔付款名称 is returned.
     * @return contractName9
     */
    public String getContractName9() {
        return contractName9;
    }

    /**
     * 第9笔付款名称 is set.
     * @param contractName9 第9笔付款名称
     */
    public void setContractName9(String contractName9) {
        this.contractName9 = contractName9;
    }

    /**
     * 第9笔付款发票说明 is returned.
     * @return contractDesc9
     */
    public String getContractDesc9() {
        return contractDesc9;
    }

    /**
     * 第9笔付款发票说明 is set.
     * @param contractDesc9 第9笔付款发票说明
     */
    public void setContractDesc9(String contractDesc9) {
        this.contractDesc9 = contractDesc9;
    }

    /**
     * 第10笔付款主键 is returned.
     * @return contractId10
     */
    public String getContractId10() {
        return contractId10;
    }

    /**
     * 第10笔付款主键 is set.
     * @param contractId10 第10笔付款主键
     */
    public void setContractId10(String contractId10) {
        this.contractId10 = contractId10;
    }

    /**
     * 第10笔付款编号 is returned.
     * @return contractLabel10
     */
    public String getContractLabel10() {
        return contractLabel10;
    }

    /**
     * 第10笔付款编号 is set.
     * @param contractLabel10 第10笔付款编号
     */
    public void setContractLabel10(String contractLabel10) {
        this.contractLabel10 = contractLabel10;
    }

    /**
     * 第10笔付款名称 is returned.
     * @return contractName10
     */
    public String getContractName10() {
        return contractName10;
    }

    /**
     * 第10笔付款名称 is set.
     * @param contractName10 第10笔付款名称
     */
    public void setContractName10(String contractName10) {
        this.contractName10 = contractName10;
    }

    /**
     * 第10笔付款发票说明 is returned.
     * @return contractDesc10
     */
    public String getContractDesc10() {
        return contractDesc10;
    }

    /**
     * 第10笔付款发票说明 is set.
     * @param contractDesc10 第10笔付款发票说明
     */
    public void setContractDesc10(String contractDesc10) {
        this.contractDesc10 = contractDesc10;
    }

    /**
     * 第11笔付款主键 is returned.
     * @return contractId11
     */
    public String getContractId11() {
        return contractId11;
    }

    /**
     * 第11笔付款主键 is set.
     * @param contractId11 第11笔付款主键
     */
    public void setContractId11(String contractId11) {
        this.contractId11 = contractId11;
    }

    /**
     * 第11笔付款编号 is returned.
     * @return contractLabel11
     */
    public String getContractLabel11() {
        return contractLabel11;
    }

    /**
     * 第11笔付款编号 is set.
     * @param contractLabel11 第11笔付款编号
     */
    public void setContractLabel11(String contractLabel11) {
        this.contractLabel11 = contractLabel11;
    }

    /**
     * 第11笔付款名称 is returned.
     * @return contractName11
     */
    public String getContractName11() {
        return contractName11;
    }

    /**
     * 第11笔付款名称 is set.
     * @param contractName11 第11笔付款名称
     */
    public void setContractName11(String contractName11) {
        this.contractName11 = contractName11;
    }

    /**
     * 第11笔付款发票说明 is returned.
     * @return contractDesc11
     */
    public String getContractDesc11() {
        return contractDesc11;
    }

    /**
     * 第11笔付款发票说明 is set.
     * @param contractDesc11 第11笔付款发票说明
     */
    public void setContractDesc11(String contractDesc11) {
        this.contractDesc11 = contractDesc11;
    }

    /**
     * 第12笔付款主键 is returned.
     * @return contractId12
     */
    public String getContractId12() {
        return contractId12;
    }

    /**
     * 第12笔付款主键 is set.
     * @param contractId12 第12笔付款主键
     */
    public void setContractId12(String contractId12) {
        this.contractId12 = contractId12;
    }

    /**
     * 第12笔付款编号 is returned.
     * @return contractLabel12
     */
    public String getContractLabel12() {
        return contractLabel12;
    }

    /**
     * 第12笔付款编号 is set.
     * @param contractLabel12 第12笔付款编号
     */
    public void setContractLabel12(String contractLabel12) {
        this.contractLabel12 = contractLabel12;
    }

    /**
     * 第12笔付款名称 is returned.
     * @return contractName12
     */
    public String getContractName12() {
        return contractName12;
    }

    /**
     * 第12笔付款名称 is set.
     * @param contractName12 第12笔付款名称
     */
    public void setContractName12(String contractName12) {
        this.contractName12 = contractName12;
    }

    /**
     * 第12笔付款发票说明 is returned.
     * @return contractDesc12
     */
    public String getContractDesc12() {
        return contractDesc12;
    }

    /**
     * 第12笔付款发票说明 is set.
     * @param contractDesc12 第12笔付款发票说明
     */
    public void setContractDesc12(String contractDesc12) {
        this.contractDesc12 = contractDesc12;
    }

    /**
     * 第13笔付款主键 is returned.
     * @return contractId13
     */
    public String getContractId13() {
        return contractId13;
    }

    /**
     * 第13笔付款主键 is set.
     * @param contractId13 第13笔付款主键
     */
    public void setContractId13(String contractId13) {
        this.contractId13 = contractId13;
    }

    /**
     * 第13笔付款编号 is returned.
     * @return contractLabel13
     */
    public String getContractLabel13() {
        return contractLabel13;
    }

    /**
     * 第13笔付款编号 is set.
     * @param contractLabel13 第13笔付款编号
     */
    public void setContractLabel13(String contractLabel13) {
        this.contractLabel13 = contractLabel13;
    }

    /**
     * 第13笔付款名称 is returned.
     * @return contractName13
     */
    public String getContractName13() {
        return contractName13;
    }

    /**
     * 第13笔付款名称 is set.
     * @param contractName13 第13笔付款名称
     */
    public void setContractName13(String contractName13) {
        this.contractName13 = contractName13;
    }

    /**
     * 第13笔付款发票说明 is returned.
     * @return contractDesc13
     */
    public String getContractDesc13() {
        return contractDesc13;
    }

    /**
     * 第13笔付款发票说明 is set.
     * @param contractDesc13 第13笔付款发票说明
     */
    public void setContractDesc13(String contractDesc13) {
        this.contractDesc13 = contractDesc13;
    }

    /**
     * 第14笔付款主键 is returned.
     * @return contractId14
     */
    public String getContractId14() {
        return contractId14;
    }

    /**
     * 第14笔付款主键 is set.
     * @param contractId14 第14笔付款主键
     */
    public void setContractId14(String contractId14) {
        this.contractId14 = contractId14;
    }

    /**
     * 第14笔付款编号 is returned.
     * @return contractLabel14
     */
    public String getContractLabel14() {
        return contractLabel14;
    }

    /**
     * 第14笔付款编号 is set.
     * @param contractLabel14 第14笔付款编号
     */
    public void setContractLabel14(String contractLabel14) {
        this.contractLabel14 = contractLabel14;
    }

    /**
     * 第14笔付款名称 is returned.
     * @return contractName14
     */
    public String getContractName14() {
        return contractName14;
    }

    /**
     * 第14笔付款名称 is set.
     * @param contractName14 第14笔付款名称
     */
    public void setContractName14(String contractName14) {
        this.contractName14 = contractName14;
    }

    /**
     * 第14笔付款发票说明 is returned.
     * @return contractDesc14
     */
    public String getContractDesc14() {
        return contractDesc14;
    }

    /**
     * 第14笔付款发票说明 is set.
     * @param contractDesc14 第14笔付款发票说明
     */
    public void setContractDesc14(String contractDesc14) {
        this.contractDesc14 = contractDesc14;
    }

    /**
     * 第15笔付款主键 is returned.
     * @return contractId15
     */
    public String getContractId15() {
        return contractId15;
    }

    /**
     * 第15笔付款主键 is set.
     * @param contractId15 第15笔付款主键
     */
    public void setContractId15(String contractId15) {
        this.contractId15 = contractId15;
    }

    /**
     * 第15笔付款编号 is returned.
     * @return contractLabel15
     */
    public String getContractLabel15() {
        return contractLabel15;
    }

    /**
     * 第15笔付款编号 is set.
     * @param contractLabel15 第15笔付款编号
     */
    public void setContractLabel15(String contractLabel15) {
        this.contractLabel15 = contractLabel15;
    }

    /**
     * 第15笔付款名称 is returned.
     * @return contractName15
     */
    public String getContractName15() {
        return contractName15;
    }

    /**
     * 第15笔付款名称 is set.
     * @param contractName15 第15笔付款名称
     */
    public void setContractName15(String contractName15) {
        this.contractName15 = contractName15;
    }

    /**
     * 第15笔付款发票说明 is returned.
     * @return contractDesc15
     */
    public String getContractDesc15() {
        return contractDesc15;
    }

    /**
     * 第15笔付款发票说明 is set.
     * @param contractDesc15 第15笔付款发票说明
     */
    public void setContractDesc15(String contractDesc15) {
        this.contractDesc15 = contractDesc15;
    }

    /** 保存按钮显示标示 */
	protected boolean btnFlag1=false;
	protected boolean btnFlag2=false;
	protected boolean btnFlag3=false;
	protected boolean btnFlag4=false;
	protected boolean btnFlag5=false;
	protected boolean btnFlag6=false;
    protected boolean btnFlag7=false;
    protected boolean btnFlag8=false;
    protected boolean btnFlag9=false;
    protected boolean btnFlag10=false;
    protected boolean btnFlag11=false;
    protected boolean btnFlag12=false;
    protected boolean btnFlag13=false;
    protected boolean btnFlag14=false;
    protected boolean btnFlag15=false;
	
	/**
     * btnFlag6 is returned.
     * @return btnFlag6
     */
    public boolean isBtnFlag6() {
        return btnFlag6;
    }

    /**
     * btnFlag6 is set.
     * @param btnFlag6 btnFlag6
     */
    public void setBtnFlag6(boolean btnFlag6) {
        this.btnFlag6 = btnFlag6;
    }

    /**
     * btnFlag7 is returned.
     * @return btnFlag7
     */
    public boolean isBtnFlag7() {
        return btnFlag7;
    }

    /**
     * btnFlag7 is set.
     * @param btnFlag7 btnFlag7
     */
    public void setBtnFlag7(boolean btnFlag7) {
        this.btnFlag7 = btnFlag7;
    }

    /**
     * btnFlag8 is returned.
     * @return btnFlag8
     */
    public boolean isBtnFlag8() {
        return btnFlag8;
    }

    /**
     * btnFlag8 is set.
     * @param btnFlag8 btnFlag8
     */
    public void setBtnFlag8(boolean btnFlag8) {
        this.btnFlag8 = btnFlag8;
    }

    /**
     * btnFlag9 is returned.
     * @return btnFlag9
     */
    public boolean isBtnFlag9() {
        return btnFlag9;
    }

    /**
     * btnFlag9 is set.
     * @param btnFlag9 btnFlag9
     */
    public void setBtnFlag9(boolean btnFlag9) {
        this.btnFlag9 = btnFlag9;
    }

    /**
     * btnFlag10 is returned.
     * @return btnFlag10
     */
    public boolean isBtnFlag10() {
        return btnFlag10;
    }

    /**
     * btnFlag10 is set.
     * @param btnFlag10 btnFlag10
     */
    public void setBtnFlag10(boolean btnFlag10) {
        this.btnFlag10 = btnFlag10;
    }

    /**
     * btnFlag11 is returned.
     * @return btnFlag11
     */
    public boolean isBtnFlag11() {
        return btnFlag11;
    }

    /**
     * btnFlag11 is set.
     * @param btnFlag11 btnFlag11
     */
    public void setBtnFlag11(boolean btnFlag11) {
        this.btnFlag11 = btnFlag11;
    }

    /**
     * btnFlag12 is returned.
     * @return btnFlag12
     */
    public boolean isBtnFlag12() {
        return btnFlag12;
    }

    /**
     * btnFlag12 is set.
     * @param btnFlag12 btnFlag12
     */
    public void setBtnFlag12(boolean btnFlag12) {
        this.btnFlag12 = btnFlag12;
    }

    /**
     * btnFlag13 is returned.
     * @return btnFlag13
     */
    public boolean isBtnFlag13() {
        return btnFlag13;
    }

    /**
     * btnFlag13 is set.
     * @param btnFlag13 btnFlag13
     */
    public void setBtnFlag13(boolean btnFlag13) {
        this.btnFlag13 = btnFlag13;
    }

    /**
     * btnFlag14 is returned.
     * @return btnFlag14
     */
    public boolean isBtnFlag14() {
        return btnFlag14;
    }

    /**
     * btnFlag14 is set.
     * @param btnFlag14 btnFlag14
     */
    public void setBtnFlag14(boolean btnFlag14) {
        this.btnFlag14 = btnFlag14;
    }

    /**
     * btnFlag15 is returned.
     * @return btnFlag15
     */
    public boolean isBtnFlag15() {
        return btnFlag15;
    }

    /**
     * btnFlag15 is set.
     * @param btnFlag15 btnFlag15
     */
    public void setBtnFlag15(boolean btnFlag15) {
        this.btnFlag15 = btnFlag15;
    }

    public BigDecimal getAccountMoney() {
		return accountMoney;
	}

	public void setAccountMoney(BigDecimal accountMoney) {
		this.accountMoney = accountMoney;
	}

	public String getLastDateTime() {
		return lastDateTime;
	}

	public void setLastDateTime(String lastDateTime) {
		this.lastDateTime = lastDateTime;
	}

	public String getEsyscoding_q() {
		return esyscoding_q;
	}

	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}

	public Integer getEiversion() {
		return eiversion;
	}

	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getExpectday1() {
		return expectday1;
	}

	public void setExpectday1(String expectday1) {
		this.expectday1 = expectday1;
	}

	public String getActualday1() {
		return actualday1;
	}

	public void setActualday1(String actualday1) {
		this.actualday1 = actualday1;
	}

	public String getActualmoney1() {
		return actualmoney1;
	}

	public void setActualmoney1(String actualmoney1) {
		this.actualmoney1 = actualmoney1;
	}

	public String getInvoiceexplain1() {
		return invoiceexplain1;
	}

	public void setInvoiceexplain1(String invoiceexplain1) {
		this.invoiceexplain1 = invoiceexplain1;
	}

	public String getExpectday2() {
		return expectday2;
	}

	public void setExpectday2(String expectday2) {
		this.expectday2 = expectday2;
	}

	public String getActualday2() {
		return actualday2;
	}

	public void setActualday2(String actualday2) {
		this.actualday2 = actualday2;
	}

	public String getActualmoney2() {
		return actualmoney2;
	}

	public void setActualmoney2(String actualmoney2) {
		this.actualmoney2 = actualmoney2;
	}

	public String getInvoiceexplain2() {
		return invoiceexplain2;
	}

	public void setInvoiceexplain2(String invoiceexplain2) {
		this.invoiceexplain2 = invoiceexplain2;
	}

	public String getExpectday3() {
		return expectday3;
	}

	public void setExpectday3(String expectday3) {
		this.expectday3 = expectday3;
	}

	public String getActualday3() {
		return actualday3;
	}

	public void setActualday3(String actualday3) {
		this.actualday3 = actualday3;
	}

	public String getActualmoney3() {
		return actualmoney3;
	}

	public void setActualmoney3(String actualmoney3) {
		this.actualmoney3 = actualmoney3;
	}

	public String getInvoiceexplain3() {
		return invoiceexplain3;
	}

	public void setInvoiceexplain3(String invoiceexplain3) {
		this.invoiceexplain3 = invoiceexplain3;
	}

	public String getExpectday4() {
		return expectday4;
	}

	public void setExpectday4(String expectday4) {
		this.expectday4 = expectday4;
	}

	public String getActualday4() {
		return actualday4;
	}

	public void setActualday4(String actualday4) {
		this.actualday4 = actualday4;
	}

	public String getActualmoney4() {
		return actualmoney4;
	}

	public void setActualmoney4(String actualmoney4) {
		this.actualmoney4 = actualmoney4;
	}

	public String getInvoiceexplain4() {
		return invoiceexplain4;
	}

	public void setInvoiceexplain4(String invoiceexplain4) {
		this.invoiceexplain4 = invoiceexplain4;
	}

	public String getExpectday5() {
		return expectday5;
	}

	public void setExpectday5(String expectday5) {
		this.expectday5 = expectday5;
	}

	public String getActualday5() {
		return actualday5;
	}

	public void setActualday5(String actualday5) {
		this.actualday5 = actualday5;
	}

	public String getActualmoney5() {
		return actualmoney5;
	}

	public void setActualmoney5(String actualmoney5) {
		this.actualmoney5 = actualmoney5;
	}

	public String getInvoiceexplain5() {
		return invoiceexplain5;
	}

	public void setInvoiceexplain5(String invoiceexplain5) {
		this.invoiceexplain5 = invoiceexplain5;
	}

	public String getClabel_q() {
		return null;
	}

	public String getCname() {
		return null;
	}

	public List<Integer> getEiid_list() {
		return null;
	}

	public String getSreilabel_q() {
		return null;
	}

	public String getSrname_q() {
		return null;
	}

	public String getCiversion() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEid_q() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * flag1取得
	 *
	 * @return flag1 flag1
	 */
	
	public boolean getFlag1() {
		return flag1;
	}

	/**
	 * flag1设定
	 *
	 * @param flag1 flag1
	 */
	
	public void setFlag1(boolean flag1) {
		this.flag1 = flag1;
	}

	/**
	 * flag2取得
	 *
	 * @return flag2 flag2
	 */
	
	public boolean getFlag2() {
		return flag2;
	}

	/**
	 * flag2设定
	 *
	 * @param flag2 flag2
	 */
	
	public void setFlag2(boolean flag2) {
		this.flag2 = flag2;
	}

	/**
	 * flag3取得
	 *
	 * @return flag3 flag3
	 */
	
	public boolean getFlag3() {
		return flag3;
	}

	/**
	 * flag3设定
	 *
	 * @param flag3 flag3
	 */
	
	public void setFlag3(boolean flag3) {
		this.flag3 = flag3;
	}

	/**
	 * flag4取得
	 *
	 * @return flag4 flag4
	 */
	
	public boolean getFlag4() {
		return flag4;
	}

	/**
	 * flag4设定
	 *
	 * @param flag4 flag4
	 */
	
	public void setFlag4(boolean flag4) {
		this.flag4 = flag4;
	}

	public String getZhidanday1() {
		return zhidanday1;
	}

	public void setZhidanday1(String zhidanday1) {
		this.zhidanday1 = zhidanday1;
	}

	public String getYingfumoneyratio1() {
		return yingfumoneyratio1;
	}

	public void setYingfumoneyratio1(String yingfumoneyratio1) {
		this.yingfumoneyratio1 = yingfumoneyratio1;
	}

	public String getShifumoney1() {
		return shifumoney1;
	}

	public void setShifumoney1(String shifumoney1) {
		this.shifumoney1 = shifumoney1;
	}

	public String getZhidanday2() {
		return zhidanday2;
	}

	public void setZhidanday2(String zhidanday2) {
		this.zhidanday2 = zhidanday2;
	}

	public String getYingfumoneyratio2() {
		return yingfumoneyratio2;
	}

	public void setYingfumoneyratio2(String yingfumoneyratio2) {
		this.yingfumoneyratio2 = yingfumoneyratio2;
	}

	public String getShifumoney2() {
		return shifumoney2;
	}

	public void setShifumoney2(String shifumoney2) {
		this.shifumoney2 = shifumoney2;
	}

	public String getZhidanday3() {
		return zhidanday3;
	}

	public void setZhidanday3(String zhidanday3) {
		this.zhidanday3 = zhidanday3;
	}

	public String getYingfumoneyratio3() {
		return yingfumoneyratio3;
	}

	public void setYingfumoneyratio3(String yingfumoneyratio3) {
		this.yingfumoneyratio3 = yingfumoneyratio3;
	}

	public String getShifumoney3() {
		return shifumoney3;
	}

	public void setShifumoney3(String shifumoney3) {
		this.shifumoney3 = shifumoney3;
	}

	public String getZhidanday4() {
		return zhidanday4;
	}

	public void setZhidanday4(String zhidanday4) {
		this.zhidanday4 = zhidanday4;
	}

	public String getYingfumoneyratio4() {
		return yingfumoneyratio4;
	}

	public void setYingfumoneyratio4(String yingfumoneyratio4) {
		this.yingfumoneyratio4 = yingfumoneyratio4;
	}

	public String getShifumoney4() {
		return shifumoney4;
	}

	public void setShifumoney4(String shifumoney4) {
		this.shifumoney4 = shifumoney4;
	}

	public String getZhidanday5() {
		return zhidanday5;
	}

	public void setZhidanday5(String zhidanday5) {
		this.zhidanday5 = zhidanday5;
	}

	public String getYingfumoneyratio5() {
		return yingfumoneyratio5;
	}

	public void setYingfumoneyratio5(String yingfumoneyratio5) {
		this.yingfumoneyratio5 = yingfumoneyratio5;
	}

	public String getShifumoney5() {
		return shifumoney5;
	}

	public void setShifumoney5(String shifumoney5) {
		this.shifumoney5 = shifumoney5;
	}

	public String getContractId1() {
		return contractId1;
	}

	public void setContractId1(String contractId1) {
		this.contractId1 = contractId1;
	}

	public String getContractLabel1() {
		return contractLabel1;
	}

	public void setContractLabel1(String contractLabel1) {
		this.contractLabel1 = contractLabel1;
	}

	public String getContractName1() {
		return contractName1;
	}

	public void setContractName1(String contractName1) {
		this.contractName1 = contractName1;
	}

	public String getContractDesc1() {
		return contractDesc1;
	}

	public void setContractDesc1(String contractDesc1) {
		this.contractDesc1 = contractDesc1;
	}

	public String getContractId2() {
		return contractId2;
	}

	public void setContractId2(String contractId2) {
		this.contractId2 = contractId2;
	}

	public String getContractLabel2() {
		return contractLabel2;
	}

	public void setContractLabel2(String contractLabel2) {
		this.contractLabel2 = contractLabel2;
	}

	public String getContractName2() {
		return contractName2;
	}

	public void setContractName2(String contractName2) {
		this.contractName2 = contractName2;
	}

	public String getContractDesc2() {
		return contractDesc2;
	}

	public void setContractDesc2(String contractDesc2) {
		this.contractDesc2 = contractDesc2;
	}

	public String getContractId3() {
		return contractId3;
	}

	public void setContractId3(String contractId3) {
		this.contractId3 = contractId3;
	}

	public String getContractLabel3() {
		return contractLabel3;
	}

	public void setContractLabel3(String contractLabel3) {
		this.contractLabel3 = contractLabel3;
	}

	public String getContractName3() {
		return contractName3;
	}

	public void setContractName3(String contractName3) {
		this.contractName3 = contractName3;
	}

	public String getContractDesc3() {
		return contractDesc3;
	}

	public void setContractDesc3(String contractDesc3) {
		this.contractDesc3 = contractDesc3;
	}

	public String getContractId4() {
		return contractId4;
	}

	public void setContractId4(String contractId4) {
		this.contractId4 = contractId4;
	}

	public String getContractLabel4() {
		return contractLabel4;
	}

	public void setContractLabel4(String contractLabel4) {
		this.contractLabel4 = contractLabel4;
	}

	public String getContractName4() {
		return contractName4;
	}

	public void setContractName4(String contractName4) {
		this.contractName4 = contractName4;
	}

	public String getContractDesc4() {
		return contractDesc4;
	}

	public void setContractDesc4(String contractDesc4) {
		this.contractDesc4 = contractDesc4;
	}

	public String getContractId5() {
		return contractId5;
	}

	public void setContractId5(String contractId5) {
		this.contractId5 = contractId5;
	}

	public String getContractLabel5() {
		return contractLabel5;
	}

	public void setContractLabel5(String contractLabel5) {
		this.contractLabel5 = contractLabel5;
	}

	public String getContractName5() {
		return contractName5;
	}

	public void setContractName5(String contractName5) {
		this.contractName5 = contractName5;
	}

	public String getContractDesc5() {
		return contractDesc5;
	}

	public void setContractDesc5(String contractDesc5) {
		this.contractDesc5 = contractDesc5;
	}

	public boolean isBtnFlag1() {
		return btnFlag1;
	}

	public void setBtnFlag1(boolean btnFlag1) {
		this.btnFlag1 = btnFlag1;
	}

	public boolean isBtnFlag2() {
		return btnFlag2;
	}

	public void setBtnFlag2(boolean btnFlag2) {
		this.btnFlag2 = btnFlag2;
	}

	public boolean isBtnFlag3() {
		return btnFlag3;
	}

	public void setBtnFlag3(boolean btnFlag3) {
		this.btnFlag3 = btnFlag3;
	}

	public boolean isBtnFlag4() {
		return btnFlag4;
	}

	public void setBtnFlag4(boolean btnFlag4) {
		this.btnFlag4 = btnFlag4;
	}

	public boolean isBtnFlag5() {
		return btnFlag5;
	}

	public void setBtnFlag5(boolean btnFlag5) {
		this.btnFlag5 = btnFlag5;
	}

	public boolean getFlag5() {
		return flag5;
	}

	public void setFlag5(boolean flag5) {
		this.flag5 = flag5;
	}

	public boolean getFlag6() {
		return flag6;
	}

	public void setFlag6(boolean flag6) {
		this.flag6 = flag6;
	}

	public boolean getFlag7() {
		return flag7;
	}

	public void setFlag7(boolean flag7) {
		this.flag7 = flag7;
	}

	public boolean getFlag8() {
		return flag8;
	}

	public void setFlag8(boolean flag8) {
		this.flag8 = flag8;
	}

	public boolean getFlag9() {
		return flag9;
	}

	public void setFlag9(boolean flag9) {
		this.flag9 = flag9;
	}

	public boolean getFlag10() {
		return flag10;
	}

	public void setFlag10(boolean flag10) {
		this.flag10 = flag10;
	}

	public boolean getFlag11() {
		return flag11;
	}

	public void setFlag11(boolean flag11) {
		this.flag11 = flag11;
	}

	public boolean getFlag12() {
		return flag12;
	}

	public void setFlag12(boolean flag12) {
		this.flag12 = flag12;
	}

	public boolean getFlag13() {
		return flag13;
	}

	public void setFlag13(boolean flag13) {
		this.flag13 = flag13;
	}

	public boolean getFlag14() {
		return flag14;
	}

	public void setFlag14(boolean flag14) {
		this.flag14 = flag14;
	}

	public String getEkey2() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond#getCheckersion()
	 */
	public int getCheckersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
