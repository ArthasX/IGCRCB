/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.infogovernor.prj.model.Pbsummary;


/**
 * <p>概述:预算及工程分类信息视图实体</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */

@SuppressWarnings("serial")
@Entity
@Table(name="PbsummaryVW")

public class PbsummaryVW implements Serializable,Cloneable, Pbsummary {
	/** 主键*/
	@Id
	protected Integer pbrid;
	
	/** 预算表ID*/
	protected Integer bid;
	
	/** 预算类型*/
	protected String btype;
	
	/** 预算状态*/
	protected String bstatus;
	
	/** 预算名称*/
	protected String btitle;
	
	/** 预算简介*/
	protected String bdesc;
	
	/** 预算年份*/
	protected String byear;
	
	/** 预算总额*/
	protected Double bamount;
	
	/** 预算性质*/
	protected String pquality;	

	/** 预算储备预算编号*/
	protected String pstorecode;
	
	/** 预算需求部门*/
	protected String pneeddispart;
	
	/** 预算组成*/
	protected String pbuggetform;
	
	/** 预算用途*/
	protected String puse;
	
	/** 预算备注*/
	protected String remark;
	
	/** 资本金开发预算总额*/
	protected float total1;

	/** 资本金硬件预算总额*/
	protected float total2;

	/** 资本金软件预算总额*/
	protected float total3;
	
	/** 资本金工程预算总额*/
	protected float total4;
	
	/** 资本金其他预算总额*/
	protected float total5;

	/** 成本金实施预算总额*/
	protected float total6;
	
	/** 成本金其他预算总额*/
	protected float total7;
	
	/** 资本金开发已使用总额*/
	protected float totaluse1;

	/** 资本金硬件已使用总额*/
	protected float totaluse2;

	/** 资本金软件已使用总额*/
	protected float totaluse3;
	
	/** 资本金工程已使用总额*/
	protected float totaluse4;
	
	/** 资本金其他已使用总额*/
	protected float totaluse5;

	/** 成本金实施已使用总额*/
	protected float totaluse6;
	
	/** 成本金其他已使用总额*/
	protected float totaluse7;
	
	/** 资本金开发剩余总额*/
	protected float sub1;

	/** 资本金硬件剩余总额*/
	protected float sub2;

	/** 资本金软件剩余总额*/
	protected float sub3;
	
	/** 资本金工程剩余总额*/
	protected float sub4;
	
	/** 资本金其他剩余总额*/
	protected float sub5;

	/** 成本金实施剩余总额*/
	protected float sub6;
	
	/** 成本金其他剩余总额*/
	protected float sub7;
	
	/** 资本金开发单笔预算使用额*/
	protected float use1;

	/** 资本金硬件单笔预算使用额*/
	protected float use2;

	/** 资本金软件单笔预算使用额*/
	protected float use3;
	
	/** 资本金工程单笔预算使用额*/
	protected float use4;
	
	/** 资本金其他单笔预算使用额*/
	protected float use5;

	/** 成本金实施单笔预算使用额*/
	protected float use6;
	
	/** 成本金其他单笔预算使用额*/
	protected float use7;
	
	/** 项目ID*/
	protected Integer pid;
	
	/** 预算项目关系表ID*/
	protected Integer pbid;
	
	public boolean equals(Object obj) {
		if (!(obj instanceof PbsummaryVW))
			return false;
		Pbsummary target = (Pbsummary) obj;
		if (!(getPbrid().equals(target.getPbrid())))
			return false;
		return true;
	}
	
	/**
	 * 获取主键
	 * @return 主键
	 */
	public Integer getPbrid() {
		return pbrid;
	}

	/**
	 * 设置主键
	 * @param pbrid  主键
	 */
	public void setPbrid(Integer pbrid) {
		this.pbrid = pbrid;
	}

	/**
	 * 获取预算表ID
	 * @return 预算表ID
	 */
	public Integer getBid() {
		return bid;
	}

	/**
	 * 设置预算表ID
	 * @param bid  预算表ID
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
	}

	/**
	 * 获取预算类型
	 * @return 预算类型
	 */
	public String getBtype() {
		return btype;
	}

	/**
	 * 设置预算类型
	 * @param btype  预算类型
	 */
	public void setBtype(String btype) {
		this.btype = btype;
	}

	/**
	 * 获取预算状态
	 * @return 预算状态
	 */
	public String getBstatus() {
		return bstatus;
	}

	/**
	 * 设置预算状态
	 * @param bstatus  预算状态
	 */
	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	/**
	 * 获取预算名称
	 * @return 预算名称
	 */
	public String getBtitle() {
		return btitle;
	}

	/**
	 * 设置预算名称
	 * @param btitle  预算名称
	 */
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	/**
	 * 获取预算简介
	 * @return 预算简介
	 */
	public String getBdesc() {
		return bdesc;
	}

	/**
	 * 设置预算简介
	 * @param bdesc  预算简介
	 */
	public void setBdesc(String bdesc) {
		this.bdesc = bdesc;
	}

	/**
	 * 获取预算年份
	 * @return 预算年份
	 */
	public String getByear() {
		return byear;
	}

	/**
	 * 设置预算年份
	 * @param byear  预算年份
	 */
	public void setByear(String byear) {
		this.byear = byear;
	}

	/**
	 * 获取预算总额
	 * @return 预算总额
	 */
	public Double getBamount() {
		return bamount;
	}

	/**
	 * 设置预算总额
	 * @param bamount  预算总额
	 */
	public void setBamount(Double bamount) {
		this.bamount = bamount;
	}

	/**
	 * 获取预算性质
	 * @return 预算性质
	 */
	public String getPquality() {
		return pquality;
	}

	/**
	 * 设置预算性质
	 * @param pquality  预算性质
	 */
	public void setPquality(String pquality) {
		this.pquality = pquality;
	}

	/**
	 * 获取预算储备预算编号
	 * @return 预算储备预算编号
	 */
	public String getPstorecode() {
		return pstorecode;
	}

	/**
	 * 设置预算储备预算编号
	 * @param pstorecode  预算储备预算编号
	 */
	public void setPstorecode(String pstorecode) {
		this.pstorecode = pstorecode;
	}

	/**
	 * 获取预算需求部门
	 * @return 预算需求部门
	 */
	public String getPneeddispart() {
		return pneeddispart;
	}

	/**
	 * 设置预算需求部门
	 * @param pneeddispart  预算需求部门
	 */
	public void setPneeddispart(String pneeddispart) {
		this.pneeddispart = pneeddispart;
	}

	/**
	 * 获取预算组成
	 * @return 预算组成
	 */
	public String getPbuggetform() {
		return pbuggetform;
	}

	/**
	 * 设置预算组成
	 * @param pbuggetform  预算组成
	 */
	public void setPbuggetform(String pbuggetform) {
		this.pbuggetform = pbuggetform;
	}

	/**
	 * 获取预算用途
	 * @return 预算用途
	 */
	public String getPuse() {
		return puse;
	}

	/**
	 * 设置预算用途
	 * @param puse  预算用途
	 */
	public void setPuse(String puse) {
		this.puse = puse;
	}

	/**
	 * 获取预算备注
	 * @return 预算备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置预算备注
	 * @param remark  预算备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取资本金开发预算总额
	 * @return 资本金开发预算总额
	 */
	public float getTotal1() {
		return total1;
	}

	/**
	 * 设置资本金开发预算总额
	 * @param total1  资本金开发预算总额
	 */
	public void setTotal1(float total1) {
		this.total1 = total1;
	}

	/**
	 * 获取资本金硬件预算总额
	 * @return 资本金硬件预算总额
	 */
	public float getTotal2() {
		return total2;
	}

	/**
	 * 设置资本金硬件预算总额
	 * @param total2  资本金硬件预算总额
	 */
	public void setTotal2(float total2) {
		this.total2 = total2;
	}

	/**
	 * 获取资本金软件预算总额
	 * @return 资本金软件预算总额
	 */
	public float getTotal3() {
		return total3;
	}

	/**
	 * 设置资本金软件预算总额
	 * @param total3  资本金软件预算总额
	 */
	public void setTotal3(float total3) {
		this.total3 = total3;
	}

	/**
	 * 获取资本金工程预算总额
	 * @return 资本金工程预算总额
	 */
	public float getTotal4() {
		return total4;
	}

	/**
	 * 设置资本金工程预算总额
	 * @param total4  资本金工程预算总额
	 */
	public void setTotal4(float total4) {
		this.total4 = total4;
	}

	/**
	 * 获取资本金其他预算总额
	 * @return 资本金其他预算总额
	 */
	public float getTotal5() {
		return total5;
	}

	/**
	 * 设置资本金其他预算总额
	 * @param total5  资本金其他预算总额
	 */
	public void setTotal5(float total5) {
		this.total5 = total5;
	}

	/**
	 * 获取成本金实施预算总额
	 * @return 成本金实施预算总额
	 */
	public float getTotal6() {
		return total6;
	}

	/**
	 * 设置成本金实施预算总额
	 * @param total6  成本金实施预算总额
	 */
	public void setTotal6(float total6) {
		this.total6 = total6;
	}

	/**
	 * 获取成本金其他预算总额
	 * @return 成本金其他预算总额
	 */
	public float getTotal7() {
		return total7;
	}

	/**
	 * 设置成本金其他预算总额
	 * @param total7  成本金其他预算总额
	 */
	public void setTotal7(float total7) {
		this.total7 = total7;
	}

	/**
	 * 获取资本金开发已使用总额
	 * @return 资本金开发已使用总额
	 */
	public float getTotaluse1() {
		return totaluse1;
	}

	/**
	 * 设置资本金开发已使用总额
	 * @param totaluse1  资本金开发已使用总额
	 */
	public void setTotaluse1(float totaluse1) {
		this.totaluse1 = totaluse1;
	}

	/**
	 * 获取资本金硬件已使用总额
	 * @return 资本金硬件已使用总额
	 */
	public float getTotaluse2() {
		return totaluse2;
	}

	/**
	 * 设置资本金硬件已使用总额
	 * @param totaluse2  资本金硬件已使用总额
	 */
	public void setTotaluse2(float totaluse2) {
		this.totaluse2 = totaluse2;
	}

	/**
	 * 获取资本金软件已使用总额
	 * @return 资本金软件已使用总额
	 */
	public float getTotaluse3() {
		return totaluse3;
	}

	/**
	 * 设置资本金软件已使用总额
	 * @param totaluse3  资本金软件已使用总额
	 */
	public void setTotaluse3(float totaluse3) {
		this.totaluse3 = totaluse3;
	}

	/**
	 * 获取资本金工程已使用总额
	 * @return 资本金工程已使用总额
	 */
	public float getTotaluse4() {
		return totaluse4;
	}

	/**
	 * 设置资本金工程已使用总额
	 * @param totaluse4  资本金工程已使用总额
	 */
	public void setTotaluse4(float totaluse4) {
		this.totaluse4 = totaluse4;
	}

	/**
	 * 获取资本金其他已使用总额
	 * @return 资本金其他已使用总额
	 */
	public float getTotaluse5() {
		return totaluse5;
	}

	/**
	 * 设置资本金其他已使用总额
	 * @param totaluse5  资本金其他已使用总额
	 */
	public void setTotaluse5(float totaluse5) {
		this.totaluse5 = totaluse5;
	}

	/**
	 * 获取成本金实施已使用总额
	 * @return 成本金实施已使用总额
	 */
	public float getTotaluse6() {
		return totaluse6;
	}

	/**
	 * 设置成本金实施已使用总额
	 * @param totaluse6  成本金实施已使用总额
	 */
	public void setTotaluse6(float totaluse6) {
		this.totaluse6 = totaluse6;
	}

	/**
	 * 获取成本金其他已使用总额
	 * @return 成本金其他已使用总额
	 */
	public float getTotaluse7() {
		return totaluse7;
	}

	/**
	 * 设置成本金其他已使用总额
	 * @param totaluse7  成本金其他已使用总额
	 */
	public void setTotaluse7(float totaluse7) {
		this.totaluse7 = totaluse7;
	}

	/**
	 * 获取资本金开发剩余总额
	 * @return 资本金开发剩余总额
	 */
	public float getSub1() {
		return sub1;
	}

	/**
	 * 设置资本金开发剩余总额
	 * @param sub1  资本金开发剩余总额
	 */
	public void setSub1(float sub1) {
		this.sub1 = sub1;
	}

	/**
	 * 获取资本金硬件剩余总额
	 * @return 资本金硬件剩余总额
	 */
	public float getSub2() {
		return sub2;
	}

	/**
	 * 设置资本金硬件剩余总额
	 * @param sub2  资本金硬件剩余总额
	 */
	public void setSub2(float sub2) {
		this.sub2 = sub2;
	}

	/**
	 * 获取资本金软件剩余总额
	 * @return 资本金软件剩余总额
	 */
	public float getSub3() {
		return sub3;
	}

	/**
	 * 设置资本金软件剩余总额
	 * @param sub3  资本金软件剩余总额
	 */
	public void setSub3(float sub3) {
		this.sub3 = sub3;
	}

	/**
	 * 获取资本金工程剩余总额
	 * @return 资本金工程剩余总额
	 */
	public float getSub4() {
		return sub4;
	}

	/**
	 * 设置资本金工程剩余总额
	 * @param sub4  资本金工程剩余总额
	 */
	public void setSub4(float sub4) {
		this.sub4 = sub4;
	}

	/**
	 * 获取资本金其他剩余总额
	 * @return 资本金其他剩余总额
	 */
	public float getSub5() {
		return sub5;
	}

	/**
	 * 设置资本金其他剩余总额
	 * @param sub5  资本金其他剩余总额
	 */
	public void setSub5(float sub5) {
		this.sub5 = sub5;
	}

	/**
	 * 获取成本金实施剩余总额
	 * @return 成本金实施剩余总额
	 */
	public float getSub6() {
		return sub6;
	}

	/**
	 * 设置成本金实施剩余总额
	 * @param sub6  成本金实施剩余总额
	 */
	public void setSub6(float sub6) {
		this.sub6 = sub6;
	}

	/**
	 * 获取成本金其他剩余总额
	 * @return 成本金其他剩余总额
	 */
	public float getSub7() {
		return sub7;
	}

	/**
	 * 设置成本金其他剩余总额
	 * @param sub7  成本金其他剩余总额
	 */
	public void setSub7(float sub7) {
		this.sub7 = sub7;
	}

	/**
	 * 获取资本金开发单笔预算使用额
	 * @return 资本金开发单笔预算使用额
	 */
	public float getUse1() {
		return use1;
	}

	/**
	 * 设置资本金开发单笔预算使用额
	 * @param use1  资本金开发单笔预算使用额
	 */
	public void setUse1(float use1) {
		this.use1 = use1;
	}

	/**
	 * 获取资本金硬件单笔预算使用额
	 * @return 资本金硬件单笔预算使用额
	 */
	public float getUse2() {
		return use2;
	}

	/**
	 * 设置资本金硬件单笔预算使用额
	 * @param use2  资本金硬件单笔预算使用额
	 */
	public void setUse2(float use2) {
		this.use2 = use2;
	}

	/**
	 * 获取资本金软件单笔预算使用额
	 * @return 资本金软件单笔预算使用额
	 */
	public float getUse3() {
		return use3;
	}

	/**
	 * 设置资本金软件单笔预算使用额
	 * @param use3  资本金软件单笔预算使用额
	 */
	public void setUse3(float use3) {
		this.use3 = use3;
	}

	/**
	 * 获取资本金工程单笔预算使用额
	 * @return 资本金工程单笔预算使用额
	 */
	public float getUse4() {
		return use4;
	}

	/**
	 * 设置资本金工程单笔预算使用额
	 * @param use4  资本金工程单笔预算使用额
	 */
	public void setUse4(float use4) {
		this.use4 = use4;
	}

	/**
	 * 获取资本金其他单笔预算使用额
	 * @return 资本金其他单笔预算使用额
	 */
	public float getUse5() {
		return use5;
	}

	/**
	 * 设置资本金其他单笔预算使用额
	 * @param use5  资本金其他单笔预算使用额
	 */
	public void setUse5(float use5) {
		this.use5 = use5;
	}

	/**
	 * 获取成本金实施单笔预算使用额
	 * @return 成本金实施单笔预算使用额
	 */
	public float getUse6() {
		return use6;
	}

	/**
	 * 设置成本金实施单笔预算使用额
	 * @param use6  成本金实施单笔预算使用额
	 */
	public void setUse6(float use6) {
		this.use6 = use6;
	}

	/**
	 * 获取成本金其他单笔预算使用额
	 * @return 成本金其他单笔预算使用额
	 */
	public float getUse7() {
		return use7;
	}

	/**
	 * 设置成本金其他单笔预算使用额
	 * @param use7  成本金其他单笔预算使用额
	 */
	public void setUse7(float use7) {
		this.use7 = use7;
	}

	/**
	 * 获取项目ID
	 * @return 项目ID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 设置项目ID
	 * @param pid  项目ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 获取预算项目关系表ID
	 * @return 预算项目关系表ID
	 */
	public Integer getPbid() {
		return pbid;
	}

	/**
	 * 设置预算项目关系表ID
	 * @param pbid  预算项目关系表ID
	 */
	public void setPbid(Integer pbid) {
		this.pbid = pbid;
	}
}
