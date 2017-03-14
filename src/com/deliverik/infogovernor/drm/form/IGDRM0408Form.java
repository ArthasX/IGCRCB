/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.form;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * 流程组定义查询画面Form
 * 
 */
@SuppressWarnings("serial")
public class IGDRM0408Form extends BaseForm  {

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
	private String civalue;
	private FormFile files;
	private String flag ; // 返回标识
	private String parFlag;
	private String pidid;
	

	/**
	 * @return the pidid
	 */
	public String getPidid() {
		return pidid;
	}
	/**
	 * @param pidid the pidid to set
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
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
	public String getCivalue() {
		return civalue;
	}
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}
	/**
	 * flag取得
	 *
	 * @return flag flag
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * flag设定
	 *
	 * @param flag flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getParFlag() {
		return parFlag;
	}
	public void setParFlag(String parFlag) {
		this.parFlag = parFlag;
	}

	
	
	
	
}
