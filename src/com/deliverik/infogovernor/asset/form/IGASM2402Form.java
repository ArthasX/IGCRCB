package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.base.BaseForm;

/**
 * �ĵ��༭����FORM
 * 
 */
public class IGASM2402Form extends BaseForm implements IG013Info{

	private static final long serialVersionUID = 1L;

	/** �ĵ�ID */
	protected Integer eiid;
	
	/** �ĵ�ID�����֣� */
	protected String eiidStr;

	/** �ʲ�ģ��ID */
	protected Integer eid;
	
	/** �ʲ�ģ��ID�����֣� */
	protected String eidStr;
	
	/** �ʲ�ģ�ͱ��� */
	protected String elabel;

	/** �ʲ�ģ������ */
	protected String ename;

	/** �ĵ����� */
	protected String einame;
	
	/** �ĵ����� */
	protected String eilabel;

	/** �ĵ�˵�� */
	protected String eidesc;

	/** �ĵ�״̬ */
	protected String eistatus;

	/** �ĵ����ʱ�� */
	protected String eiupdtime;
	
	/** �ĵ��汾�� */
	protected Integer eiversion;

	/** �ĵ��Ǽ��� */
	protected String eiinsdate;
	
	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";
	
	/** �ʲ�����������*/
	protected String eiorgsyscoding;
	
	/** �ʲ���������������*/
	protected String eiorgname;
	
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
	
	/** �ʲ�������ģ��*/
	public String esyscoding;
	
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
	 * �ĵ�IDȡ��
	 * @return �ĵ�ID
	 */
	public Integer getEiid() {
		if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
	}

	/**
	 * �ĵ�ID�趨
	 *
	 * @param eiid �ĵ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * �ĵ�ID�����֣�ȡ��
	 * @return �ĵ�ID�����֣�
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * �ĵ�ID�����֣��趨
	 *
	 * @param eiidStr �ĵ�ID�����֣�
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
	 * �ĵ�����ȡ��
	 * @return �ĵ�����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �ĵ������趨
	 *
	 * @param einame �ĵ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �ĵ�����ȡ��
	 * @return �ĵ�����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �ĵ������趨
	 *
	 * @param eilabel �ĵ�����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �ĵ�˵��ȡ��
	 * @return �ĵ�˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * �ĵ�˵���趨
	 *
	 * @param eidesc �ĵ�˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * �ĵ�����ʱ��ȡ��
	 * @return �ĵ�����ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * �ĵ�����ʱ���趨
	 *
	 * @param eiupdtime �ĵ�����ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * �ĵ�״̬ȡ��
	 * @return �ĵ�״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * �ĵ�״̬�趨
	 *
	 * @param eistatus �ĵ�״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * �ĵ��汾��ȡ��
	 * @return �ĵ��汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �ĵ��汾���趨
	 *
	 * @param eiversion �ĵ��汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �ĵ��Ǽ���ȡ��
	 * @return �ĵ��Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �ĵ��Ǽ����趨
	 *
	 * @param eiinsdate �ĵ��Ǽ���
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
