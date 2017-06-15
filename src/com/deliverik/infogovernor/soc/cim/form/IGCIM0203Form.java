/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0111SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0111PK;
/**
 * 概述: 资产域定义查询画面FORM
 * 功能描述: 资产域定义查询画面FORM
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
public class IGCIM0203Form extends BaseForm implements SOC0111SearchCond{
	private static final long serialVersionUID = 1L;
	/**
	 * 资产域定义名称
	 */
	protected String name_like;
	/**
	 * 资产域定义开始时间
	 */
	protected String createtime_from;
	/**
	 * 资产域定义截止时间
	 */
	protected String createtime_to;
	
	/** 删除资产域定义对象 */
	protected String[] deleteEiddid;
	/**
	 * 资产域定义eiddid
	 */
	protected Integer eiddid;
	/**
	 * 资产预定义版本号
	 */
	protected Integer version;
	
	/**
	 * 资产域定义名称取得
	 */
	public String getName_like() {
		return name_like;
	}
	/**
	 * 资产域定义名称设置
	 * @param name_like资产域定义名称
	 */
	public void setName_like(String name_like) {
		this.name_like = name_like;
	}
	/**
	 * 资产域定义开始时间取得
	 */
	public String getCreatetime_from() {
		return createtime_from;
	}
	/**
	 * 资产域定义开始时间设定
	 * @param createtime_from资产域定义开始时间
	 */
	public void setCreatetime_from(String createtime_from) {
		this.createtime_from = createtime_from;
	}
	/**
	 * 资产域定义截止时间取得
	 */
	public String getCreatetime_to() {
		return createtime_to;
	}
	/**
	 * 资产域定义截止时间设定
	 * @param createtime_to资产域定义截止时间
	 */
	public void setCreatetime_to(String createtime_to) {
		this.createtime_to = createtime_to;
	}
	/**
	 * 删除资产域定义对象取得
	 * @return 删除资产域定义对象
	 */
	public String[] getDeleteEiddid() {
		return deleteEiddid;
	}
	/**
	 * 删除资产域定义对象设定
	 * @param deleteEiddid删除资产域定义对象
	 */
	public void setDeleteEiddid(String[] deleteEiddid) {
		this.deleteEiddid = deleteEiddid;
	}
	/**
	 * 资产域定义eiddid取得
	 * @return 资产域定义eiddid
	 */
	public Integer getEiddid() {
		return eiddid;
	}
	/**
	 * 资产域定义eiddid设定
	 * @param eiddid 资产域定义eiddid
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}
	/**
	 * 资产预定义版本号取得
	 * @return 资产预定义版本号
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * 资产预定义版本号设定
	 * @param version资产预定义版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	/**
	 * 主键取得
	 */
	public Serializable getPK() {
		return new SOC0111PK(eiddid,version);
	}
	public String getEiddid_eq() {
		return null;
	}
	

}
