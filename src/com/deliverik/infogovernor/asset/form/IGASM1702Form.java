package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.base.BaseForm;

/**
 * ����༭����FORM
 * 
 */
public class IGASM1702Form extends BaseForm implements IG013Info{

	private static final long serialVersionUID = 1L;

	/** ���ID */
	protected Integer eiid;
	
	/** ���ID�����֣� */
	protected String eiidStr;

	/** �ʲ�ģ��ID */
	protected Integer eid;
	
	/** �ʲ�ģ��ID�����֣� */
	protected String eidStr;
	
	/** �ʲ�ģ�ͱ��� */
	protected String elabel;

	/** �ʲ�ģ������ */
	protected String ename;

	/** ������� */
	protected String einame;
	
	/** ������� */
	protected String eilabel;

	/** ���˵�� */
	protected String eidesc;

	/** ���״̬ */
	protected String eistatus;

	/** ������ʱ�� */
	protected String eiupdtime;
	
	/** ����汾�� */
	protected Integer eiversion;

	/** ����Ǽ��� */
	protected String eiinsdate;
	
	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";

	/** �������� */
	protected String eiorgname;

	/** �ʲ�������ģ��*/
	protected String esyscoding;
	
	/** ��������豸ģ��id*/
	protected String deviceEid;
	
	/** ��������豸id*/
	protected String deviceEiid;
	
	/** ��������豸����*/
	protected String deviceEiname;
	
	/** ����������ģ��id*/
	protected String moduleEid;
	
	/** ����������id*/
	protected String moduleEiid;
	
	/** ��������������*/
	protected String moduleEiname;
	
	/** �ʲ�������*/
	protected String eiuserid;
	
	/** �ʲ�����������*/
	protected String eiusername;
	
	protected String fingerPrint;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	
	protected String eiorgsyscoding;

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	/**
	 * ���IDȡ��
	 * @return ���ID
	 */
	public Integer getEiid() {
		if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
	}

	/**
	 * ���ID�趨
	 *
	 * @param eiid ���ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * ���ID�����֣�ȡ��
	 * @return ���ID�����֣�
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * ���ID�����֣��趨
	 *
	 * @param eiidStr ���ID�����֣�
	 */
	public void setEiidStr(String eiidStr) {
		this.eiidStr = eiidStr;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ�ģ��ID�����֣�ȡ��
	 * @return �ʲ�ģ��ID�����֣�
	 */
	public String getEidStr() {
		return eidStr;
	}

	/**
	 * �ʲ�ģ��ID�����֣��趨
	 *
	 * @param eidStr �ʲ�ģ��ID�����֣�
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
	}

	/**
	 * �ʲ�ģ�ͱ���ȡ��
	 * @return �ʲ�ģ�ͱ���
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * �ʲ�ģ�ͱ����趨
	 *
	 * @param elabel �ʲ�ģ�ͱ���
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ�ģ�������趨
	 *
	 * @param ename �ʲ�ģ������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ��������趨
	 *
	 * @param einame �������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ��������趨
	 *
	 * @param eilabel �������
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ���˵��ȡ��
	 * @return ���˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * ���˵���趨
	 *
	 * @param eidesc ���˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * �������ʱ��ȡ��
	 * @return �������ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * �������ʱ���趨
	 *
	 * @param eiupdtime �������ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * ���״̬ȡ��
	 * @return ���״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * ���״̬�趨
	 *
	 * @param eistatus ���״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * ����汾��ȡ��
	 * @return ����汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * ����汾���趨
	 *
	 * @param eiversion ����汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * ����Ǽ���ȡ��
	 * @return ����Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * ����Ǽ����趨
	 *
	 * @param eiinsdate ����Ǽ���
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * �༭ģʽȡ��
	 * @return �༭ģʽ
	 */
	public String getMode() {
		return mode;
	}


	/**
	 * �༭ģʽ�趨
	 *
	 * @param mode �༭ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * ��������豸ģ��idȡ��
	 * @return ��������豸ģ��id
	 */
	public String getDeviceEid() {
		return deviceEid;
	}

	/**
	 * ��������豸ģ��id�趨
	 *
	 * @param deviceEid ��������豸ģ��id
	 */
	public void setDeviceEid(String deviceEid) {
		this.deviceEid = deviceEid;
	}

	/**
	 * ��������豸idȡ��
	 * @return ��������豸id
	 */
	public String getDeviceEiid() {
		return deviceEiid;
	}
	
	/**
	 * ��������豸id�趨
	 *
	 * @param deviceEiid ��������豸id
	 */
	public void setDeviceEiid(String deviceEiid) {
		this.deviceEiid = deviceEiid;
	}
	
	/**
	 * ��������豸ȡ��
	 * @return ��������豸
	 */
	public String getDeviceEiname() {
		return deviceEiname;
	}

	/**
	 * ��������豸�趨
	 *
	 * @param deviceEiname ��������豸
	 */
	public void setDeviceEiname(String deviceEiname) {
		this.deviceEiname = deviceEiname;
	}

	public String getModuleEid() {
		return moduleEid;
	}

	public void setModuleEid(String moduleEid) {
		this.moduleEid = moduleEid;
	}

	public String getModuleEiid() {
		return moduleEiid;
	}

	public void setModuleEiid(String moduleEiid) {
		this.moduleEiid = moduleEiid;
	}

	public String getModuleEiname() {
		return moduleEiname;
	}

	public void setModuleEiname(String moduleEiname) {
		this.moduleEiname = moduleEiname;
	}
	/**
	 * �ʲ�������ȡ��
	 * @return �ʲ�������
	 */
	public String getEiuserid() {
		return eiuserid;
	}
	
	/**
	 * �ʲ��������趨
	 *
	 * @param eiuserid �ʲ�������
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	
	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public String getEiusername() {
		return eiusername;
	}
	
	/**
	 * �ʲ������������趨
	 *
	 * @param eiusername �ʲ�����������
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	public Integer getEirootmark() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * �ʲ�С�汾�趨
	 *
	 * @param eismallversion �ʲ�С�汾
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

}