/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.sym.model.FormFileInfo;
import com.deliverik.infogovernor.sym.model.Notice;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * Description: 系统管理_通知管理_新增修改FormBean
 * 
 */

@SuppressWarnings("serial")
public class IGDRM1402Form extends BaseForm implements Notice{
	
	
	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	
	protected String mode = "0";

	public String nattkey;
	
	public String userid;
	public String roleid;

	public String ndesc;

	public Integer nid;

	public String nname;

	public String norgid;

	public String norgname;

	public String ntime;

	public String nuserid;

	public String nusername;

	public String attachDel;

	protected FormFile file;

	protected String attacthname;
	//是否删除附件
	protected String delfile;
	public String deletekeys;
	
	private String isPush;
	
	private String pushPrid;
	
	protected String ntargettype;

	protected String ntargetuserid;

	protected String ntargetusername;

	protected String ntargetroleid;

	protected String ntargetrolename;
	
	public String getDeletekeys() {
		return deletekeys;
	}

	public void setDeletekeys(String deletekeys) {
		this.deletekeys = deletekeys;
	}
	public String getAttachDel() {
		return attachDel;
	}

	public void setAttachDel(String attachDel) {
		this.attachDel = attachDel;
	}

	public List<Attachment>attachmentList;
	
	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	protected List<FormFileInfo> fileList;
	
	public IGDRM1402Form(){
		
		fileList = new ArrayList<FormFileInfo>();
		
		fileList.add(new FormFileInfo());	
	}
	
	public List<FormFileInfo> getFileListInfo() {
		return fileList;
	}

	public void setFileListInfo(List<FormFileInfo> fileList) {
		this.fileList = fileList;
	}
	public FormFileInfo getFileList(int index){
		
		int size = fileList.size();
		if (index>size-1) {
			for (int i = 0; i < index-size+1; i++) {
				fileList.add(new FormFileInfo());
			}
		}
		return fileList.get(index);
	}

	public Integer flag;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getNattkey() {
		return nattkey;
	}

	public void setNattkey(String nattkey) {
		this.nattkey = nattkey;
	}

	public String getNdesc() {
		return ndesc;
	}

	public void setNdesc(String ndesc) {
		this.ndesc = ndesc;
	}

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getNorgid() {
		return norgid;
	}

	public void setNorgid(String norgid) {
		this.norgid = norgid;
	}

	public String getNorgname() {
		return norgname;
	}

	public void setNorgname(String norgname) {
		this.norgname = norgname;
	}

	public String getNtime() {
		return ntime;
	}

	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

	public String getNuserid() {
		return nuserid;
	}

	public void setNuserid(String nuserid) {
		this.nuserid = nuserid;
	}

	public String getNusername() {
		return nusername;
	}

	public void setNusername(String nusername) {
		this.nusername = nusername;
	}
	
	protected String fingerprint;

	public FormFile getAttachFile() {
		return this.file;
	}

	public void setAttachFile( FormFile file) {
		this.file=file;
	}

	public String getAttacthname() {
		return attacthname;
	}

	public void setAttacthname(String attacthname) {
		this.attacthname = attacthname;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	public String getDelfile() {
		return delfile;
	}

	public void setDelfile(String delfile) {
		this.delfile = delfile;
	}

	public String getIsPush() {
		return isPush;
	}

	public void setIsPush(String isPush) {
		this.isPush = isPush;
	}

	public String getPushPrid() {
		return pushPrid;
	}

	public void setPushPrid(String pushPrid) {
		this.pushPrid = pushPrid;
	}

	public String getNtargettype() {
		return ntargettype;
	}

	public void setNtargettype(String ntargettype) {
		this.ntargettype = ntargettype;
	}

	public String getNtargetuserid() {
		return ntargetuserid;
	}

	public void setNtargetuserid(String ntargetuserid) {
		this.ntargetuserid = ntargetuserid;
	}

	public String getNtargetusername() {
		return ntargetusername;
	}

	public void setNtargetusername(String ntargetusername) {
		this.ntargetusername = ntargetusername;
	}

	public String getNtargetroleid() {
		return ntargetroleid;
	}

	public void setNtargetroleid(String ntargetroleid) {
		this.ntargetroleid = ntargetroleid;
	}

	public String getNtargetrolename() {
		return ntargetrolename;
	}

	public void setNtargetrolename(String ntargetrolename) {
		this.ntargetrolename = ntargetrolename;
	}
	
	//是否发送通知标识
	protected String isSend;
	//发送短信标识
	protected String sendSMS;
	//发送邮件标识
	protected String sendEML;
	
	/**
	 * 发送邮件标识取得
	 * @return 发送邮件标识
	 */
	public String getIsSend() {
		return isSend;
	}
	/**
	 * 发送邮件标识设定
	 * @param isSend 发送邮件标识
	 */
	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}
	
	/**
	 * 发送短信标识取得
	 * @return 发送短信标识
	 */
	public String getSendSMS() {
		return sendSMS;
	}
	/**
	 * 发送短信标识设定
	 * @param sendSMS 发送短信标识
	 */
	public void setSendSMS(String sendSMS) {
		this.sendSMS = sendSMS;
	}
	
	/**
	 * 发送邮件标识取得
	 * @return 发送邮件标识
	 */
	public String getSendEML() {
		return sendEML;
	}
	/**
	 * 发送邮件标识设定
	 * @param sendEML 发送邮件标识
	 */
	public void setSendEML(String sendEML) {
		this.sendEML = sendEML;
	}

	/**
	 * userid   取得
	 * @return userid userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * userid   设定
	 * @param userid userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * roleid   取得
	 * @return roleid roleid
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * roleid   设定
	 * @param roleid roleid
	 */
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	/**
	 * @return the fingerprint
	 */
	public String getFingerprint() {
		return fingerprint;
	}

	/**
	 * @param fingerprint the fingerprint to set
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public String getFingerPrint() {
		return null;
	}

	
	
}