package com.deliverik.infogovernor.soc.vir.form;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;

/**
 * 设备查询画面FORM
 * 
 */
public class IGVIR0605Form extends BaseForm implements SOC0124SearchCond{

	private static final long serialVersionUID = 1L;
	/** 维保到期日查询开始时间 */
	public String wbdate_from;
	/** 维保到期日查询结束时间 */
	public String wbdate_to;
	/** 资产模型编号 */
	protected String elabel;
	
	/** 资产模型名 */
	protected String ename;
	
	/** 设备编号 */
	protected String eilabel;
	
	/** 设备名称 */
	protected String einame;
	
	/** 资产模型分类 */
	protected String ecategory;
	
	/** 资产模型一级子类 */
	protected String ekey1;
	
	/** 资产模型二级子类 */
	protected String ekey2;
	
	/** 设备更新时间FROM */
	protected String eiupdtime_from;
	
	/** 设备更新时间TO */
	protected String eiupdtime_to;
	
	/** 删除设备对象 */
	protected String[] deleteEiid;
	
	/** 设备配置名检索条件数组 */
	protected String[] cname = new String[4];
	
	/** 设备配置值检索条件数组 */
	protected String[] civalue = new String[4];
	
	/** 设备共通配置编号检索条件数组 */
	protected String[] cclabel = new String[2];
	
	/** 设备共通配置值检索条件数组 */
	protected String[] ccivalue = new String[2];
	/** 资产项所属机构*/
	protected String eiorgsyscoding;
	
	/** 资产项所属机构名称*/
	protected String eiorgname;
	/** 资产项所属模型*/
	protected String esyscoding;
	
	/** 资产项的状态 */
	protected String eistatus;//下发存N|R  上缴存U  报废存N|R  
	
	/** 资产使用机构code*/
	protected String usesyscoding;
	/** 资产使用机构名称*/
	protected String useorgname;
	
	/** 资产配置信息结点ID*/
	protected String nodeID;

	protected String eiid;
	
	protected String eiversion;
	
	protected String filename;
	
	/** 资产小版本*/
	protected String eismallversion;
	
	/** 资产更新2开始时间 */
	protected String eiupdtime_from2;
	
	/** 资产更新2截止时间 */
	protected String eiupdtime_to2;
	
	/** 查询顶级实体标识*/
	protected boolean topCiFlag;
	
	/** 顶级实体名称*/
	protected String topCi;
	
	protected String ip;
	
	public String getTopCi() {
		return topCi;
	}

	public void setTopCi(String topCi) {
		this.topCi = topCi;
	}

	/**资产父节点*/
	protected Integer eirootmark_eq;
	

	public void setEirootmark_eq(Integer eirootmark_eq) {
		this.eirootmark_eq = eirootmark_eq;
	}

	public boolean isTopCiFlag() {
		return topCiFlag;
	}

	public void setTopCiFlag(boolean topCiFlag) {
		this.topCiFlag = topCiFlag;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getEiversion() {
		return eiversion;
	}

	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	public String getNodeID() {
		return nodeID;
	}

	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}

	public String getUseorgname() {
		return useorgname;
	}

	public void setUseorgname(String useorgname) {
		this.useorgname = useorgname;
	}

	public String getUsesyscoding() {
		return usesyscoding;
	}

	public void setUsesyscoding(String usesyscoding) {
		this.usesyscoding = usesyscoding;
	}

	public String getEistatus() {
		return eistatus;
	}

	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
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
	 * 资产模型名取得
	 * @return 资产模型名
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名设定
	 *
	 * @param ename 资产模型名
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 设备编码取得
	 * @return 设备编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 设备编码设定
	 *
	 * @param eilabel 设备编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 设备名称取得
	 * @return 设备名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 设备名称设定
	 *
	 * @param einame 设备名称
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
	 * 设备更新时间FROM取得
	 * @return 设备更新时间FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * 设备更新时间FROM设定
	 *
	 * @param eiupdtime_from 设备更新时间FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * 设备更新时间TO取得
	 * @return 设备更新时间TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * 设备更新时间TO设定
	 *
	 * @param eiupdtime_to 设备更新时间TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}


	/**
	 * 删除设备对象取得
	 * @return 删除设备对象
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}


	/**
	 * 删除设备对象设定
	 *
	 * @param deleteEiid 删除设备对象
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * 设备配置名检索条件数组取得
	 * @return 设备配置名检索条件数组
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * 设备配置名检索条件数组设定
	 *
	 * @param cname 设备配置名检索条件数组
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * 设备配置值检索条件数组取得
	 * @return 设备配置值检索条件数组
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * 设备配置值检索条件数组设定
	 *
	 * @param civalue 设备配置值检索条件数组
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * 设备共通配置编号检索条件数组取得
	 * @return 设备共通配置编号检索条件数组
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * 设备共通配置编号检索条件数组设定
	 *
	 * @param cclabel 设备共通配置编号检索条件数组
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * 设备共通配置值检索条件数组取得
	 * @return 设备共通配置值检索条件数组
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * 设备共通配置值检索条件数组设定
	 *
	 * @param ccivalue 设备共通配置值检索条件数组
	 */
	public void setCcivalue(String[] ccivalue) {
		this.ccivalue = ccivalue;
	}

	/**
	 * 初始化处理
	 *
	 * @param mapping 
	 * @param request 
	 */
	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.deleteEiid = null;
	}

	public String getEiorgsyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEistatus_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiorgcode() {
		// TODO Auto-generated method stub
		return null;
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
	 * 资产小版本取得
	 * @return 资产小版本
	 */
	public String getEismallversion() {
		return eismallversion;
	}
	/**
	 * 资产小版本设定
	 *
	 * @param eismallversion 资产小版本
	 */
	public void setEismallversion(String eismallversion) {
		this.eismallversion = eismallversion;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.asset.model.condition.EntityItemVWSearchCond#getEirootmark_eq()
	 */
	public Integer getEirootmark_eq() {
		return eirootmark_eq;
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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
