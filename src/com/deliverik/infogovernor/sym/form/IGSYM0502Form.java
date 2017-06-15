/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;


import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.sym.model.FormFileInfo;
import com.deliverik.infogovernor.sym.model.Notice;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_֪ͨ����_�����޸�FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0502Form extends BaseForm implements Notice{
	
	
	/**
	 * ҳ�������ʾ��־0-����,1-���
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
	//�Ƿ�ɾ������
	protected String delfile;
	public String deletekeys;
	
	private String isPush;//�Ƿ����͵�ָ��̨  (�ݶ�����Ҫ�˹��� 2015��2��3��11:07:27)
	
	private String pushPrid;//ָ��̨����  (�ݶ�����Ҫ�˹��� 2015��2��3��11:07:27)
	
	protected String ntargettype;//�������� 1:��Ա  2:��ɫ

	protected String ntargetuserid; //��Աid

	protected String ntargetusername;//��Ա����

	protected String ntargetroleid;//��ɫid

	protected String ntargetrolename;//��ɫ��
	
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
	
	public IGSYM0502Form(){
		
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
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
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
	
	//�Ƿ���֪ͨ��ʶ
	protected String isSend;
	//���Ͷ��ű�ʶ
	protected String sendSMS;
	//�����ʼ���ʶ
	protected String sendEML;
	
	/**
	 * �����ʼ���ʶȡ��
	 * @return �����ʼ���ʶ
	 */
	public String getIsSend() {
		return isSend;
	}
	/**
	 * �����ʼ���ʶ�趨
	 * @param isSend �����ʼ���ʶ
	 */
	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}
	
	/**
	 * ���Ͷ��ű�ʶȡ��
	 * @return ���Ͷ��ű�ʶ
	 */
	public String getSendSMS() {
		return sendSMS;
	}
	/**
	 * ���Ͷ��ű�ʶ�趨
	 * @param sendSMS ���Ͷ��ű�ʶ
	 */
	public void setSendSMS(String sendSMS) {
		this.sendSMS = sendSMS;
	}
	
	/**
	 * �����ʼ���ʶȡ��
	 * @return �����ʼ���ʶ
	 */
	public String getSendEML() {
		return sendEML;
	}
	/**
	 * �����ʼ���ʶ�趨
	 * @param sendEML �����ʼ���ʶ
	 */
	public void setSendEML(String sendEML) {
		this.sendEML = sendEML;
	}

	/**
	 * userid   ȡ��
	 * @return userid userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * userid   �趨
	 * @param userid userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * roleid   ȡ��
	 * @return roleid roleid
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * roleid   �趨
	 * @param roleid roleid
	 */
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	
}
