package com.deliverik.infogovernor.drm.form;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * Ӧ������̨FORM
 * 
 */
@SuppressWarnings("serial")
public class IGDRM1010Form extends BaseForm{
	
	/** ����ID */
	protected Integer prid;
	
	/** �����û�ID */
	protected String userid;
	
	/** �ڵ���Ϣ */
	protected String status;
	
	/** ״̬������ */
	protected Integer pvlid;

	/** ״̬id */
	protected String psdid;

	/** װ���ֵ������˵���� */
	protected String psdValue;

	/** �����ɫID */
	protected Integer roleid;
	
	/** ������ */
	protected String btnid;
	
	/** ������ */
	protected String result;
	
	/** �����¼ */
	protected String rlcomment;

	/** ��Ϣ���� */
	protected String msg;

	/** ���Ž�����id */
	protected String userids;
	/** ����(֪ͨ)������id */
	protected String sendUserid;
	/** ����(֪ͨ)������id */
	protected String sendUserName;

	protected FormFile file;

	/** ����eiid */
	protected String senceEiid;
	/** �����汾 */
	protected String senceEiversion;

	public String getSenceEiid() {
		return senceEiid;
	}

	public void setSenceEiid(String senceEiid) {
		this.senceEiid = senceEiid;
	}

	public String getSenceEiversion() {
		return senceEiversion;
	}

	public void setSenceEiversion(String senceEiversion) {
		this.senceEiversion = senceEiversion;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	public String getSendUserid() {
		return sendUserid;
	}

	public void setSendUserid(String sendUserid) {
		this.sendUserid = sendUserid;
	}

	public String getSendUserName() {
		return sendUserName;
	}

	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUserids() {
		return userids;
	}

	public void setUserids(String userids) {
		this.userids = userids;
	}

	/**
	 * ����IDȡ��
	 * @return prid ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * �����û�IDȡ��
	 * @return userid �����û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �����û�ID�趨
	 * @param userid �����û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * �ڵ���Ϣȡ��
	 * @return status �ڵ���Ϣ
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * �ڵ���Ϣ�趨
	 * @param status �ڵ���Ϣ
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * �����ɫIDȡ��
	 * @return roleid �����ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �����ɫID�趨
	 * @param roleid �����ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ������ȡ��
	 * @return btnid ������
	 */
	public String getBtnid() {
		return btnid;
	}

	/**
	 * �������趨
	 * @param btnid ������
	 */
	public void setBtnid(String btnid) {
		this.btnid = btnid;
	}

	/**
	 * ������ȡ��
	 * @return result ������
	 */
	public String getResult() {
		return result;
	}

	/**
	 * �������趨
	 * @param result ������
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * �����¼ȡ��
	 * @return rlcomment �����¼
	 */
	public String getRlcomment() {
		return rlcomment;
	}

	/**
	 * �����¼�趨
	 * @param rlcomment �����¼
	 */
	public void setRlcomment(String rlcomment) {
		this.rlcomment = rlcomment;
	}

	public String getPsdValue() {
		return psdValue;
	}

	public void setPsdValue(String psdValue) {
		this.psdValue = psdValue;
	}

	public Integer getPvlid() {
		return pvlid;
	}

	public void setPvlid(Integer pvlid) {
		this.pvlid = pvlid;
	}
}
