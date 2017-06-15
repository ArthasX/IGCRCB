/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.prj.model.InvestUseInfoVW;

/**
 * 概述: 投资使用情况导出实体
 * 功能描述：投资使用情况导出实体
 * 创建人：王廷志
 * 创建记录： 2012-5-22
 * 修改记录：
 */
@Entity
@SuppressWarnings("serial")
public class InvestUseInfoTB implements InvestUseInfoVW,Serializable{
	@Id
	/** 项目ID */
	private Integer pid;
	/** 项目性质 */
	private String ppquality;
	/** 项目类别 */
	private String ptype;
	/** 项目名称 */
	private String pname;
	/** 项目简介 */
	private String pdesc;
	/** 预算项目编号 */
	private String pstorecode;
	/** 合同金额总计 */
	private Double ltotal;
	/** 合同金额资本金总计 */
	private Double ltotalctsum;
	/** 合同金额成本金总计 */
	private Double ltotalcssum;
	/** 合同金额资本金开发 */
	private Double ltotal1;
	/** 合同金额资本金软件 */
	private Double ltotal2;
	/** 合同金额资本金硬件 */
	private Double ltotal3;
	/** 合同金额资本金工程 */
	private Double ltotal4;
	/** 合同金额资本金其他 */
	private Double ltotal5;
	/** 合同金额成本金实施 */
	private Double ltotal6;
	/** 合同金额成本金其他 */
	private Double ltotal7;
	/** 付款条件 */
	private String term;
	/** 付款 */
	private Double fktotal;
	/** 预算总计 */
	private Double bztotal;
	/** 预算资本金总计 */
	private Double bztotalctsum;
	/** 预算成本金总计 */
	private Double bztotalcssum;
	/** 预算资本金开发 */
	private Double bztotal1;
	/** 预算资本金软件 */
	private Double bztotal2;
	/** 预算资本金硬件 */
	private Double bztotal3;
	/** 预算资本金工程 */
	private Double bztotal4;
	/** 预算资本金其他 */
	private Double bztotal5;
	/** 预算成本金实施 */
	private Double bztotal6;
	/** 预算成本金其他 */
	private Double bztotal7;
	/** 项目总计 */
	private Double ptotal;
	/** 项目资本金总计 */
	private Double ptotalctsum;
	/** 项目成本金总计 */
	private Double ptotalcssum;
	/** 项目资本金开发 */
	private Double ptotal1;
	/** 项目资本金软件 */
	private Double ptotal2;
	/** 项目资本金硬件 */
	private Double ptotal3;
	/** 项目资本金工程 */
	private Double ptotal4;
	/** 项目资本金其他 */
	private Double ptotal5;
	/** 项目成本金实施 */
	private Double ptotal6;
	/** 项目成本金其他 */
	private Double ptotal7;
	/** 项目用途 */
	private String ppurpose;
	/**
	 * pid取得
	 * @return pid pid
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * pid设定
	 * @param pid pid
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 项目性质取得
	 * @return ppquality 项目性质
	 */
	public String getPpquality() {
		return ppquality;
	}
	/**
	 * 项目性质设定
	 * @param ppquality 项目性质
	 */
	public void setPpquality(String ppquality) {
		this.ppquality = ppquality;
	}
	/**
	 * 项目类别取得
	 * @return ptype 项目类别
	 */
	public String getPtype() {
		return ptype;
	}
	/**
	 * 项目类别设定
	 * @param ptype 项目类别
	 */
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	/**
	 * 项目名称取得
	 * @return pname 项目名称
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * 项目名称设定
	 * @param pname 项目名称
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * 项目简介取得
	 * @return pdesc 项目简介
	 */
	public String getPdesc() {
		return pdesc;
	}
	/**
	 * 项目简介设定
	 * @param pdesc 项目简介
	 */
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	/**
	 * 预算项目编号取得
	 * @return pstorecode 预算项目编号
	 */
	public String getPstorecode() {
		return pstorecode;
	}
	/**
	 * 预算项目编号设定
	 * @param pstorecode 预算项目编号
	 */
	public void setPstorecode(String pstorecode) {
		this.pstorecode = pstorecode;
	}
	/**
	 * 合同金额总计取得
	 * @return ltotal 合同金额总计
	 */
	public Double getLtotal() {
		return ltotal;
	}
	/**
	 * 合同金额总计设定
	 * @param ltotal 合同金额总计
	 */
	public void setLtotal(Double ltotal) {
		this.ltotal = ltotal;
	}
	/**
	 * 合同金额资本金总计取得
	 * @return ltotalctsum 合同金额资本金总计
	 */
	public Double getLtotalctsum() {
		return ltotalctsum;
	}
	/**
	 * 合同金额资本金总计设定
	 * @param ltotalctsum 合同金额资本金总计
	 */
	public void setLtotalctsum(Double ltotalctsum) {
		this.ltotalctsum = ltotalctsum;
	}
	/**
	 * 合同金额成本金总计取得
	 * @return ltotalcssum 合同金额成本金总计
	 */
	public Double getLtotalcssum() {
		return ltotalcssum;
	}
	/**
	 * 合同金额成本金总计设定
	 * @param ltotalcssum 合同金额成本金总计
	 */
	public void setLtotalcssum(Double ltotalcssum) {
		this.ltotalcssum = ltotalcssum;
	}
	/**
	 * 合同金额资本金开发取得
	 * @return ltotal1 合同金额资本金开发
	 */
	public Double getLtotal1() {
		return ltotal1;
	}
	/**
	 * 合同金额资本金开发设定
	 * @param ltotal1 合同金额资本金开发
	 */
	public void setLtotal1(Double ltotal1) {
		this.ltotal1 = ltotal1;
	}
	/**
	 * 合同金额资本金软件取得
	 * @return ltotal2 合同金额资本金软件
	 */
	public Double getLtotal2() {
		return ltotal2;
	}
	/**
	 * 合同金额资本金软件设定
	 * @param ltotal2 合同金额资本金软件
	 */
	public void setLtotal2(Double ltotal2) {
		this.ltotal2 = ltotal2;
	}
	/**
	 * 合同金额资本金硬件取得
	 * @return ltotal3 合同金额资本金硬件
	 */
	public Double getLtotal3() {
		return ltotal3;
	}
	/**
	 * 合同金额资本金硬件设定
	 * @param ltotal3 合同金额资本金硬件
	 */
	public void setLtotal3(Double ltotal3) {
		this.ltotal3 = ltotal3;
	}
	/**
	 * 合同金额资本金工程取得
	 * @return ltotal4 合同金额资本金工程
	 */
	public Double getLtotal4() {
		return ltotal4;
	}
	/**
	 * 合同金额资本金工程设定
	 * @param ltotal4 合同金额资本金工程
	 */
	public void setLtotal4(Double ltotal4) {
		this.ltotal4 = ltotal4;
	}
	/**
	 * 合同金额资本金其他取得
	 * @return ltotal5 合同金额资本金其他
	 */
	public Double getLtotal5() {
		return ltotal5;
	}
	/**
	 * 合同金额资本金其他设定
	 * @param ltotal5 合同金额资本金其他
	 */
	public void setLtotal5(Double ltotal5) {
		this.ltotal5 = ltotal5;
	}
	/**
	 * 合同金额成本金实施取得
	 * @return ltotal6 合同金额成本金实施
	 */
	public Double getLtotal6() {
		return ltotal6;
	}
	/**
	 * 合同金额成本金实施设定
	 * @param ltotal6 合同金额成本金实施
	 */
	public void setLtotal6(Double ltotal6) {
		this.ltotal6 = ltotal6;
	}
	/**
	 * 合同金额成本金其他取得
	 * @return ltotal7 合同金额成本金其他
	 */
	public Double getLtotal7() {
		return ltotal7;
	}
	/**
	 * 合同金额成本金其他设定
	 * @param ltotal7 合同金额成本金其他
	 */
	public void setLtotal7(Double ltotal7) {
		this.ltotal7 = ltotal7;
	}
	/**
	 * 付款条件取得
	 * @return term 付款条件
	 */
	public String getTerm() {
		return term;
	}
	/**
	 * 付款条件设定
	 * @param term 付款条件
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	/**
	 * 付款取得
	 * @return fktotal 付款
	 */
	public Double getFktotal() {
		return fktotal;
	}
	/**
	 * 付款设定
	 * @param fktotal 付款
	 */
	public void setFktotal(Double fktotal) {
		this.fktotal = fktotal;
	}
	/**
	 * 预算总计取得
	 * @return bztotal 预算总计
	 */
	public Double getBztotal() {
		return bztotal;
	}
	/**
	 * 预算总计设定
	 * @param bztotal 预算总计
	 */
	public void setBztotal(Double bztotal) {
		this.bztotal = bztotal;
	}
	/**
	 * 预算资本金总计取得
	 * @return bztotalctsum 预算资本金总计
	 */
	public Double getBztotalctsum() {
		return bztotalctsum;
	}
	/**
	 * 预算资本金总计设定
	 * @param bztotalctsum 预算资本金总计
	 */
	public void setBztotalctsum(Double bztotalctsum) {
		this.bztotalctsum = bztotalctsum;
	}
	/**
	 * 预算成本金总计取得
	 * @return bztotalcssum 预算成本金总计
	 */
	public Double getBztotalcssum() {
		return bztotalcssum;
	}
	/**
	 * 预算成本金总计设定
	 * @param bztotalcssum 预算成本金总计
	 */
	public void setBztotalcssum(Double bztotalcssum) {
		this.bztotalcssum = bztotalcssum;
	}
	/**
	 * 预算资本金开发取得
	 * @return bztotal1 预算资本金开发
	 */
	public Double getBztotal1() {
		return bztotal1;
	}
	/**
	 * 预算资本金开发设定
	 * @param bztotal1 预算资本金开发
	 */
	public void setBztotal1(Double bztotal1) {
		this.bztotal1 = bztotal1;
	}
	/**
	 * 预算资本金软件取得
	 * @return bztotal2 预算资本金软件
	 */
	public Double getBztotal2() {
		return bztotal2;
	}
	/**
	 * 预算资本金软件设定
	 * @param bztotal2 预算资本金软件
	 */
	public void setBztotal2(Double bztotal2) {
		this.bztotal2 = bztotal2;
	}
	/**
	 * 预算资本金硬件取得
	 * @return bztotal3 预算资本金硬件
	 */
	public Double getBztotal3() {
		return bztotal3;
	}
	/**
	 * 预算资本金硬件设定
	 * @param bztotal3 预算资本金硬件
	 */
	public void setBztotal3(Double bztotal3) {
		this.bztotal3 = bztotal3;
	}
	/**
	 * 预算资本金工程取得
	 * @return bztotal4 预算资本金工程
	 */
	public Double getBztotal4() {
		return bztotal4;
	}
	/**
	 * 预算资本金工程设定
	 * @param bztotal4 预算资本金工程
	 */
	public void setBztotal4(Double bztotal4) {
		this.bztotal4 = bztotal4;
	}
	/**
	 * 预算资本金其他取得
	 * @return bztotal5 预算资本金其他
	 */
	public Double getBztotal5() {
		return bztotal5;
	}
	/**
	 * 预算资本金其他设定
	 * @param bztotal5 预算资本金其他
	 */
	public void setBztotal5(Double bztotal5) {
		this.bztotal5 = bztotal5;
	}
	/**
	 * 预算成本金实施取得
	 * @return bztotal6 预算成本金实施
	 */
	public Double getBztotal6() {
		return bztotal6;
	}
	/**
	 * 预算成本金实施设定
	 * @param bztotal6 预算成本金实施
	 */
	public void setBztotal6(Double bztotal6) {
		this.bztotal6 = bztotal6;
	}
	/**
	 * 预算成本金其他取得
	 * @return bztotal7 预算成本金其他
	 */
	public Double getBztotal7() {
		return bztotal7;
	}
	/**
	 * 预算成本金其他设定
	 * @param bztotal7 预算成本金其他
	 */
	public void setBztotal7(Double bztotal7) {
		this.bztotal7 = bztotal7;
	}
	/**
	 * 项目总计取得
	 * @return ptotal 项目总计
	 */
	public Double getPtotal() {
		return ptotal;
	}
	/**
	 * 项目总计设定
	 * @param ptotal 项目总计
	 */
	public void setPtotal(Double ptotal) {
		this.ptotal = ptotal;
	}
	/**
	 * 项目资本金总计取得
	 * @return ptotalctsum 项目资本金总计
	 */
	public Double getPtotalctsum() {
		return ptotalctsum;
	}
	/**
	 * 项目资本金总计设定
	 * @param ptotalctsum 项目资本金总计
	 */
	public void setPtotalctsum(Double ptotalctsum) {
		this.ptotalctsum = ptotalctsum;
	}
	/**
	 * 项目成本金总计取得
	 * @return ptotalcssum 项目成本金总计
	 */
	public Double getPtotalcssum() {
		return ptotalcssum;
	}
	/**
	 * 项目成本金总计设定
	 * @param ptotalcssum 项目成本金总计
	 */
	public void setPtotalcssum(Double ptotalcssum) {
		this.ptotalcssum = ptotalcssum;
	}
	/**
	 * 项目资本金开发取得
	 * @return ptotal1 项目资本金开发
	 */
	public Double getPtotal1() {
		return ptotal1;
	}
	/**
	 * 项目资本金开发设定
	 * @param ptotal1 项目资本金开发
	 */
	public void setPtotal1(Double ptotal1) {
		this.ptotal1 = ptotal1;
	}
	/**
	 * 项目资本金软件取得
	 * @return ptotal2 项目资本金软件
	 */
	public Double getPtotal2() {
		return ptotal2;
	}
	/**
	 * 项目资本金软件设定
	 * @param ptotal2 项目资本金软件
	 */
	public void setPtotal2(Double ptotal2) {
		this.ptotal2 = ptotal2;
	}
	/**
	 * 项目资本金硬件取得
	 * @return ptotal3 项目资本金硬件
	 */
	public Double getPtotal3() {
		return ptotal3;
	}
	/**
	 * 项目资本金硬件设定
	 * @param ptotal3 项目资本金硬件
	 */
	public void setPtotal3(Double ptotal3) {
		this.ptotal3 = ptotal3;
	}
	/**
	 * 项目资本金工程取得
	 * @return ptotal4 项目资本金工程
	 */
	public Double getPtotal4() {
		return ptotal4;
	}
	/**
	 * 项目资本金工程设定
	 * @param ptotal4 项目资本金工程
	 */
	public void setPtotal4(Double ptotal4) {
		this.ptotal4 = ptotal4;
	}
	/**
	 * 项目资本金其他取得
	 * @return ptotal5 项目资本金其他
	 */
	public Double getPtotal5() {
		return ptotal5;
	}
	/**
	 * 项目资本金其他设定
	 * @param ptotal5 项目资本金其他
	 */
	public void setPtotal5(Double ptotal5) {
		this.ptotal5 = ptotal5;
	}
	/**
	 * 项目成本金实施取得
	 * @return ptotal6 项目成本金实施
	 */
	public Double getPtotal6() {
		return ptotal6;
	}
	/**
	 * 项目成本金实施设定
	 * @param ptotal6 项目成本金实施
	 */
	public void setPtotal6(Double ptotal6) {
		this.ptotal6 = ptotal6;
	}
	/**
	 * 项目成本金其他取得
	 * @return ptotal7 项目成本金其他
	 */
	public Double getPtotal7() {
		return ptotal7;
	}
	/**
	 * 项目成本金其他设定
	 * @param ptotal7 项目成本金其他
	 */
	public void setPtotal7(Double ptotal7) {
		this.ptotal7 = ptotal7;
	}
	/**
	 * 项目用途取得
	 * @return ppurpose 项目用途
	 */
	public String getPpurpose() {
		return ppurpose;
	}
	/**
	 * 项目用途设定
	 * @param ppurpose 项目用途
	 */
	public void setPpurpose(String ppurpose) {
		this.ppurpose = ppurpose;
	}
}
