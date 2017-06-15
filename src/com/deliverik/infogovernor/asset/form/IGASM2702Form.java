package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * ���յ�༭����FORM
 * 
 */
public class IGASM2702Form extends BaseForm implements SOC0118Info{

	private static final long serialVersionUID = 1L;

	/** ���յ�ID */
	protected Integer eiid;
	
	/** ���յ�ID�����֣� */
	protected String eiidStr;

	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ�ģ��ID�����֣� */
	protected String eidStr;
	
	/** �ʲ�ģ�ͱ��� */
	protected String elabel;

	/** �ʲ�ģ������ */
	protected String ename;

	/** ���յ����� */
	protected String einame;
	
	/** ���յ���� */
	protected String eilabel;

	/** ���յ�˵�� */
	protected String eidesc;

	/** ���յ�״̬ */
	protected String eistatus;

	/** ���յ���ʱ�� */
	protected String eiupdtime;
	
	/** ���յ�汾�� */
	protected Integer eiversion;

	/** ���յ�Ǽ��� */
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
	
	protected String mguserid;
	
	protected String mgusername;
	
	protected String[] civalue;

	/**
	 * civalueȡ��
	 * @return civalue civalue
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * civalue�趨
	 * @param civalue civalue
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * mguseridȡ��
	 * @return mguserid mguserid
	 */
	public String getMguserid() {
		return mguserid;
	}

	/**
	 * mguserid�趨
	 * @param mguserid mguserid
	 */
	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}

	/**
	 * mgusernameȡ��
	 * @return mgusername mgusername
	 */
	public String getMgusername() {
		return mgusername;
	}

	/**
	 * mgusername�趨
	 * @param mgusername mgusername
	 */
	public void setMgusername(String mgusername) {
		this.mgusername = mgusername;
	}

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
	 * ���յ�IDȡ��
	 * @return ���յ�ID
	 */
	public Integer getEiid() {
		if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
	}

	/**
	 * ���յ�ID�趨
	 *
	 * @param eiid ���յ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * ���յ�ID�����֣�ȡ��
	 * @return ���յ�ID�����֣�
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * ���յ�ID�����֣��趨
	 *
	 * @param eiidStr ���յ�ID�����֣�
	 */
	public void setEiidStr(String eiidStr) {
		this.eiidStr = eiidStr;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(String eid) {
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
	 * ���յ�����ȡ��
	 * @return ���յ�����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ���յ������趨
	 *
	 * @param einame ���յ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ���յ����ȡ��
	 * @return ���յ����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ���յ�����趨
	 *
	 * @param eilabel ���յ����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ���յ�˵��ȡ��
	 * @return ���յ�˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * ���յ�˵���趨
	 *
	 * @param eidesc ���յ�˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * ���յ����ʱ��ȡ��
	 * @return ���յ����ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * ���յ����ʱ���趨
	 *
	 * @param eiupdtime ���յ����ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * ���յ�״̬ȡ��
	 * @return ���յ�״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * ���յ�״̬�趨
	 *
	 * @param eistatus ���յ�״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * ���յ�汾��ȡ��
	 * @return ���յ�汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * ���յ�汾���趨
	 *
	 * @param eiversion ���յ�汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * ���յ�Ǽ���ȡ��
	 * @return ���յ�Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * ���յ�Ǽ����趨
	 *
	 * @param eiinsdate ���յ�Ǽ���
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

	public SOC0117TB getSoc0117TB() {
		// TODO Auto-generated method stub
		return null;
	}

}
