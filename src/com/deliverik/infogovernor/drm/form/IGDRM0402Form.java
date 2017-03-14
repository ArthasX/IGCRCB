/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.form;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;

/**
 * 流程组定义查询画面Form
 * 
 */
@SuppressWarnings("serial")
public class IGDRM0402Form extends BaseForm  implements SOC0124SearchCond{

	private String eid ; // 资产模型ID
	private String eidesc ; // 资产说明
	private String einame ; // 资产名称
	private String eilabel ; // 资产编号
	private String eiinsdate ;// 资产登记日
	private String eiorgsyscoding ; // 资产所属机构层次码
	private String eiorgname; // 资产所属机构名称
	private String esyscoding ; // 资产模型层次码
	private String eiupdtime ; // 资产更新时间
	private String eistatus ; // 资产状态
	private String estatus ; // 模型状态
	private Integer eiversion ; // 资产版本号
	private String fingerprint ; // 时间戳
	private String eiuserid ; // 资产管理人
	private String eiusername ; // 资产管理人姓名
	private Integer eismallversion; // 资产小版本
	private Integer eirootmark ; // 资产所属树根节点实体标识
	private String ename;
	private String[] cids;
	private Integer eiid;
	protected String[] ciattach;
	private String[] civalues;
	private FormFile files;
	private String[] deleteEiid;
	/**开始时间*/
	protected String propentime;
	
	/**结束时间*/
	protected String prclosetime;
	
	/**应急资源id*/
	protected Integer erid;
	
	/**应急资源编码*/
	protected String ercode;
	
	/**应急资源名称*/
	protected String ername;
	
	/** 关联设备对象 */
	protected String[] relationEiid;
	
	/** 资产更新开始时间 */
	protected String eiupdtime_from;
	
	/** 资产更新截止时间 */
	protected String eiupdtime_to;
	
	/** 弹出页标识 */
	protected String openFlag;
	
	/**需要过滤掉的eiid(应急资源专用)*/
	protected String eiidNotIn;
	
	/** 对应资产模型码  */
	protected String esyscode;
	
	/** 单选标识  */
	protected String sign;
	
	/** 清空标识  */
	protected String hasAClear;
	
	/**
	 * @return the hasAClear
	 */
	public String getHasAClear() {
		return hasAClear;
	}
	/**
	 * @param hasAClear the hasAClear to set
	 */
	public void setHasAClear(String hasAClear) {
		this.hasAClear = hasAClear;
	}
	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}
	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
	/**
	 * @return the esyscode
	 */
	public String getEsyscode() {
		return esyscode;
	}
	/**
	 * @param esyscode the esyscode to set
	 */
	public void setEsyscode(String esyscode) {
		this.esyscode = esyscode;
	}
	/**
	 * @return the eiidNotIn
	 */
	public String getEiidNotIn() {
		return eiidNotIn;
	}
	/**
	 * @param eiidNotIn the eiidNotIn to set
	 */
	public void setEiidNotIn(String eiidNotIn) {
		this.eiidNotIn = eiidNotIn;
	}
	/**
	 * @return the openFlag
	 */
	public String getOpenFlag() {
		return openFlag;
	}
	/**
	 * @param openFlag the openFlag to set
	 */
	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}
	/**
	 * @return the ername
	 */
	public String getErname() {
		return ername;
	}
	/**
	 * @param ername the ername to set
	 */
	public void setErname(String ername) {
		this.ername = ername;
	}
	/**
	 * @return the eiupdtime_from
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}
	/**
	 * @param eiupdtime_from the eiupdtime_from to set
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}
	/**
	 * @return the eiupdtime_to
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}
	/**
	 * @param eiupdtime_to the eiupdtime_to to set
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}
	/**
	 * @return the erid
	 */
	public Integer getErid() {
		return erid;
	}
	/**
	 * @return the ercode
	 */
	public String getErcode() {
		return ercode;
	}
	/**
	 * @param ercode the ercode to set
	 */
	public void setErcode(String ercode) {
		this.ercode = ercode;
	}
	/**
	 * @param erid the erid to set
	 */
	public void setErid(Integer erid) {
		this.erid = erid;
	}
	/**
	 * @return the relationEiid
	 */
	public String[] getRelationEiid() {
		return relationEiid;
	}
	/**
	 * @param relationEiid the relationEiid to set
	 */
	public void setRelationEiid(String[] relationEiid) {
		this.relationEiid = relationEiid;
	}
	
	/**
	 * eid   取得
	 * @return eid eid
	 */
	public String getEid() {
		return eid;
	}
	/**
	 * eid   设定
	 * @param eid eid
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}
	/**
	 * eidesc   取得
	 * @return eidesc eidesc
	 */
	public String getEidesc() {
		return eidesc;
	}
	/**
	 * eidesc   设定
	 * @param eidesc eidesc
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}
	/**
	 * einame   取得
	 * @return einame einame
	 */
	public String getEiname() {
		return einame;
	}
	/**
	 * einame   设定
	 * @param einame einame
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	/**
	 * eilabel   取得
	 * @return eilabel eilabel
	 */
	public String getEilabel() {
		return eilabel;
	}
	/**
	 * eilabel   设定
	 * @param eilabel eilabel
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}
	/**
	 * eiinsdate   取得
	 * @return eiinsdate eiinsdate
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}
	/**
	 * eiinsdate   设定
	 * @param eiinsdate eiinsdate
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}
	/**
	 * eiorgsyscoding   取得
	 * @return eiorgsyscoding eiorgsyscoding
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	/**
	 * eiorgsyscoding   设定
	 * @param eiorgsyscoding eiorgsyscoding
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	/**
	 * eiorgname   取得
	 * @return eiorgname eiorgname
	 */
	public String getEiorgname() {
		return eiorgname;
	}
	/**
	 * eiorgname   设定
	 * @param eiorgname eiorgname
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	/**
	 * esyscoding   取得
	 * @return esyscoding esyscoding
	 */
	public String getEsyscoding() {
		return esyscoding;
	}
	/**
	 * esyscoding   设定
	 * @param esyscoding esyscoding
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**
	 * eiupdtime   取得
	 * @return eiupdtime eiupdtime
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}
	/**
	 * eiupdtime   设定
	 * @param eiupdtime eiupdtime
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}
	/**
	 * eistatus   取得
	 * @return eistatus eistatus
	 */
	public String getEistatus() {
		return eistatus;
	}
	/**
	 * eistatus   设定
	 * @param eistatus eistatus
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}
	/**
	 * estatus   取得
	 * @return estatus estatus
	 */
	public String getEstatus() {
		return estatus;
	}
	/**
	 * estatus   设定
	 * @param estatus estatus
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	/**
	 * eiversion   取得
	 * @return eiversion eiversion
	 */
	public Integer getEiversion() {
		return eiversion;
	}
	/**
	 * eiversion   设定
	 * @param eiversion eiversion
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}
	/**
	 * fingerprint   取得
	 * @return fingerprint fingerprint
	 */
	public String getFingerprint() {
		return fingerprint;
	}
	/**
	 * fingerprint   设定
	 * @param fingerprint fingerprint
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	/**
	 * eiuserid   取得
	 * @return eiuserid eiuserid
	 */
	public String getEiuserid() {
		return eiuserid;
	}
	/**
	 * eiuserid   设定
	 * @param eiuserid eiuserid
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	/**
	 * eiusername   取得
	 * @return eiusername eiusername
	 */
	public String getEiusername() {
		return eiusername;
	}
	/**
	 * eiusername   设定
	 * @param eiusername eiusername
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}
	/**
	 * eismallversion   取得
	 * @return eismallversion eismallversion
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * eismallversion   设定
	 * @param eismallversion eismallversion
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
	/**
	 * eirootmark   取得
	 * @return eirootmark eirootmark
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}
	/**
	 * eirootmark   设定
	 * @param eirootmark eirootmark
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}
	/**
	 * ename   取得
	 * @return ename ename
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * eiid   取得
	 * @return eiid eiid
	 */
	public Integer getEiid() {
		return eiid;
	}
	/**
	 * eiid   设定
	 * @param eiid eiid
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	/**
	 * ename   设定
	 * @param ename ename
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * cids   取得
	 * @return cids cids
	 */
	public String[] getCids() {
		return cids;
	}
	/**
	 * cids   设定
	 * @param cids cids
	 */
	public void setCids(String[] cids) {
		this.cids = cids;
	}
	/**
	 * ciattach   取得
	 * @return ciattach ciattach
	 */
	public String[] getCiattach() {
		return ciattach;
	}
	/**
	 * ciattach   设定
	 * @param ciattach ciattach
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}
	/**
	 * cvalues   取得
	 * @return cvalues cvalues
	 */
	public String[] getCivalues() {
		return civalues;
	}
	/**
	 * cvalues   设定
	 * @param cvalues cvalues
	 */
	public void setCivalues(String[] civalues) {
		this.civalues = civalues;
	}
	/**
	 * files   取得
	 * @return files files
	 */
	public FormFile getFiles() {
		return files;
	}
	/**
	 * files   设定
	 * @param files files
	 */
	public void setFiles(FormFile files) {
		this.files = files;
	}
	/**
	 * deleteEiid   取得
	 * @return deleteEiid deleteEiid
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}
	/**
	 * deleteEiid   设定
	 * @param deleteEiid deleteEiid
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}
	/**  
	 * 获取开始时间  
	 * @return propentime 开始时间  
	 */
	
	public String getPropentime() {
		return propentime;
	}
	/**  
	 * 设置开始时间  
	 * @param propentime 开始时间  
	 */
	
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}
	/**  
	 * 获取结束时间  
	 * @return prclosetime 结束时间  
	 */
	
	public String getPrclosetime() {
		return prclosetime;
	}
	/**  
	 * 设置结束时间  
	 * @param prclosetime 结束时间  
	 */
	
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}
	public String getElabel() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEcategory() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEkey1() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEkey2() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEiupdtime_from2() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEiupdtime_to2() {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] getCname() {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] getCivalue() {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] getCclabel() {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] getCcivalue() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEiorgcode() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEiorgsyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEistatus_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> getEiidList() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getUsesyscoding() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getWbdate_from() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getWbdate_to() {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getEirootmark_eq() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isTopCiFlag() {
		// TODO Auto-generated method stub
		return false;
	}
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

	
	
	
	
}
