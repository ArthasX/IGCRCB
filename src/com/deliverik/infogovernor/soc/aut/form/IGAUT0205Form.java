package com.deliverik.infogovernor.soc.aut.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;

/**
 * 资产项查询HELP画面用FORM
 * IGCOM0302Form ActionForm
 */
public class IGAUT0205Form extends BaseForm implements SOC0124SearchCond{

	private static final long serialVersionUID = 1L;

	/** 资产模型编号 */
	protected String elabel;
	
	/** 资产项编号 */
	protected String eilabel;
	
	/** 资产项名称 */
	protected String einame;
	
	/** 资产模型分类 */
	protected String ecategory;
	
	/** 资产模型一级子类 */
	protected String ekey1;
	
	/** 资产模型二级子类 */
	protected String ekey2;
	
	/** 资产更新时间FROM */
	protected String eiupdtime_from;
	
	/** 资产更新时间TO */
	protected String eiupdtime_to;
	
	/** 资产项所属机构*/
	public String eiorgsyscoding;
	
	/** 资产项所属机构名称*/
	public String eiorgname;
	
	public String eistatus;
	
	/** 资产模型名 */
	protected String ename;
	
	/** 模型层次码 */
	protected String esyscoding;
	
	/** 初始化层次码 */
	protected String esyscodingbegin;
	
	/** 复选框选中ID */
	protected String[] selectId;
	
	/** 资产使用机构code*/
	public String usesyscoding;
	
	/** 维保到期日查询开始时间 */
	public String wbdate_from;
	/** 维保到期日查询结束时间 */
	public String wbdate_to;
	
	/** 动态表单ID */
	protected String pidid;
	
	protected boolean flag;
	
	/** 资产更新2开始时间 */
	protected String eiupdtime_from2;
	
	/** 资产更新2截止时间 */
	protected String eiupdtime_to2;
	protected String useorgname;
	
	/** 查询顶级实体标识*/
	protected boolean topCiFlag;
	
	public boolean isTopCiFlag() {
		return topCiFlag;
	}

	public void setTopCiFlag(boolean topCiFlag) {
		this.topCiFlag = topCiFlag;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getUsesyscoding() {
		return usesyscoding;
	}

	public void setUsesyscoding(String usesyscoding) {
		this.usesyscoding = usesyscoding;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	public String getEistatus() {
		return eistatus;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * 资产模型编码取得
	 * @return 资产模型编码
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * 资产模型编码设定
	 *
	 * @param elabel 资产模型编码
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * 资产项编码取得
	 * @return 资产项编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 资产项编码设定
	 *
	 * @param eilabel 资产项编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 资产项名称取得
	 * @return 资产项名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 资产项名称设定
	 *
	 * @param einame 资产项名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 资产模型分类取得
	 * @return 资产模型分类
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * 资产模型分类设定
	 *
	 * @param ecategory 资产模型分类
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	/**
	 * 资产模型一级子类取得
	 * @return 资产模型一级子类
	 */
	public String getEkey1() {
		return ekey1;
	}

	/**
	 * 资产模型一级子类设定
	 *
	 * @param ekey1 资产模型一级子类
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * 资产模型二级子类取得
	 * @return 资产模型二级子类
	 */
	public String getEkey2() {
		return ekey2;
	}

	/**
	 * 资产模型二级子类设定
	 *
	 * @param ekey1 资产模型二级子类
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * 资产项更新时间FROM取得
	 * @return 资产项更新时间FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * 资产项更新时间FROM设定
	 *
	 * @param eiupdtime_from 资产项更新时间FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * 资产项更新时间TO取得
	 * @return 资产项更新时间TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * 资产项更新时间TO设定
	 *
	 * @param eiupdtime_to 资产项更新时间TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}
	
	public String getEname() {
		return ename;
	}

	public String getEsyscoding() {
		return esyscoding;
	}
	
	public String[] getCivalue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCname() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCcivalue() {
		return null;
	}

	public String[] getCclabel() {
		return null;
	}

	public String getEiorgsyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEsyscodingbegin() {
		return esyscodingbegin;
	}

	public void setEsyscodingbegin(String esyscodingbegin) {
		this.esyscodingbegin = esyscodingbegin;
	}

	public String getEistatus_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiorgcode() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 复选框选中ID取得
	 * @return 复选框选中ID
	 */
	public String[] getSelectId() {
		return selectId;
	}

	/**
	 * 复选框选中ID设定
	 *
	 * @param selectId 复选框选中ID
	 */
	public void setSelectId(String[] selectId) {
		this.selectId = selectId;
	}

	public List<String> getEiidList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWbdate_from() {
		return wbdate_from;
	}

	public void setWbdate_from(String wbdate_from) {
		this.wbdate_from = wbdate_from;
	}

	public String getWbdate_to() {
		return wbdate_to;
	}

	public void setWbdate_to(String wbdate_to) {
		this.wbdate_to = wbdate_to;
	}

	/**
	 * 动态表单ID取得
	 * @return 动态表单ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 动态表单ID设定
	 * @param pidid 动态表单ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}
	
	

	/* (non-Javadoc)
	 * @see com.deliverik.framework.asset.model.condition.EntityItemVWSearchCond#getEirootmark_eq()
	 */
	public Integer getEirootmark_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTopCI() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the 资产更新2开始时间
	 */
	public String getEiupdtime_from2() {
		return eiupdtime_from2;
	}

	/**
	 * @param 资产更新2开始时间 the eiupdtime_from2 to set
	 */
	public void setEiupdtime_from2(String eiupdtime_from2) {
		this.eiupdtime_from2 = eiupdtime_from2;
	}

	/**
	 * @return the 资产更新2截止时间
	 */
	public String getEiupdtime_to2() {
		return eiupdtime_to2;
	}

	/**
	 * @param 资产更新2截止时间 the eiupdtime_to2 to set
	 */
	public void setEiupdtime_to2(String eiupdtime_to2) {
		this.eiupdtime_to2 = eiupdtime_to2;
	}

	public String getUseorgname() {
		return useorgname;
	}

	public void setUseorgname(String useorgname) {
		this.useorgname = useorgname;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getIp()
	 */
	public String getIp() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAssetNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIpAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAote() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDeviceType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLifeCycle() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getEiidNotInList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPayee() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUpgrade() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getEiinsdate_gt() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiinsdate_lt() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiusername() {
		// TODO Auto-generated method stub
		return null;
	}

}
