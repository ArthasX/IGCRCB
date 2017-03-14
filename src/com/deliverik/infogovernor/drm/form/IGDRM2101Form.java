package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �豸�༭����FORM
 * 
 */
public class IGDRM2101Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** �豸ID */
	protected Integer eiid;
	
	/** �豸ID�����֣� */
	protected String eiidStr;

	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ�ģ��ID�����֣� */
	protected String eidStr;
	
	/** �ʲ�ģ�ͱ��� */
	protected String elabel;

	/** �ʲ�ģ������ */
	protected String ename;

	/** �豸���� */
	protected String einame;
	
	/** �豸���� */
	protected String eilabel;

	/** �豸˵�� */
	protected String eidesc;

	/** �豸״̬ */
	protected String eistatus;

	/** �豸���ʱ�� */
	protected String eiupdtime;
	
	/** �豸�汾�� */
	protected Integer eiversion;

	/** �豸�Ǽ��� */
	protected String eiinsdate;
	
	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";
	
	/** �ʲ�����������*/
	protected String eiorgsyscoding;
	
	/** �ʲ���������������*/
	protected String eiorgname;
	
	/** �ʲ�������ģ��*/
	protected String esyscoding;
	
	/** �ʲ�������*/
	protected String eiuserid;
	
	/** �ʲ�����������*/
	protected String eiusername;
	
	protected String fingerPrint;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;
	
	private String pidid;

	/**��ʼʱ��*/
	protected String propentime;
	
	/**����ʱ��*/
	protected String prclosetime;
	
	/**Ӧ����Դid*/
	protected Integer erid;
	
	/**Ӧ����Դ����*/
	protected String ercode;
	
	/**Ӧ����Դ����*/
	protected String ername;
	
	/** �����豸���� */
	protected String[] relationEiid;
	
	/** �ʲ����¿�ʼʱ�� */
	protected String eiupdtime_from;
	
	/** �ʲ����½�ֹʱ�� */
	protected String eiupdtime_to;
	
	/** ����ҳ��ʶ */
	protected String openFlag;
	
	/**��Ҫ���˵���eiid(Ӧ����Դר��)*/
	protected String eiidNotIn;
	
	/** ��Ӧ�ʲ�ģ����  */
	protected String esyscode;
	
	/** ��ѡ��ʶ  */
	protected String sign;
	
	protected String[] einames;
	protected String[] eids;
	protected String[] eiids;
	protected String[] eiversions;

	private String[] ids;

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
	 * �豸ID�趨
	 *
	 * @param eiid �豸ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �豸IDȡ��
	 * @return �豸ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �豸ID�����֣�ȡ��
	 * @return �豸ID�����֣�
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * �豸ID�����֣��趨
	 *
	 * @param eiidStr �豸ID�����֣�
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
	 * �豸����ȡ��
	 * @return �豸����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �豸�����趨
	 *
	 * @param einame �豸����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �豸����ȡ��
	 * @return �豸����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �豸�����趨
	 *
	 * @param eilabel �豸����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �豸˵��ȡ��
	 * @return �豸˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * �豸˵���趨
	 *
	 * @param eidesc �豸˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * �豸����ʱ��ȡ��
	 * @return �豸����ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * �豸����ʱ���趨
	 *
	 * @param eiupdtime �豸����ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * �豸״̬ȡ��
	 * @return �豸״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * �豸״̬�趨
	 *
	 * @param eistatus �豸״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * �豸�汾��ȡ��
	 * @return �豸�汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �豸�汾���趨
	 *
	 * @param eiversion �豸�汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �༭ģʽȡ��
	 * @return �༭ģʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * �豸�Ǽ���ȡ��
	 * @return �豸�Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �豸�Ǽ����趨
	 *
	 * @param eiinsdate �豸�Ǽ���
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
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

	public String getPidid() {
		return pidid;
	}

	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	public String getPrclosetime() {
		return prclosetime;
	}

	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	public String getErname() {
		return ername;
	}

	public void setErname(String ername) {
		this.ername = ername;
	}

	public String[] getRelationEiid() {
		return relationEiid;
	}

	public void setRelationEiid(String[] relationEiid) {
		this.relationEiid = relationEiid;
	}

	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}

	public String getOpenFlag() {
		return openFlag;
	}

	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}

	public String getEiidNotIn() {
		return eiidNotIn;
	}

	public void setEiidNotIn(String eiidNotIn) {
		this.eiidNotIn = eiidNotIn;
	}

	public String getEsyscode() {
		return esyscode;
	}

	public void setEsyscode(String esyscode) {
		this.esyscode = esyscode;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String[] getEinames() {
		return einames;
	}

	public void setEinames(String[] einames) {
		this.einames = einames;
	}

	public String[] getEids() {
		return eids;
	}

	public void setEids(String[] eids) {
		this.eids = eids;
	}

	public String[] getEiids() {
		return eiids;
	}

	public void setEiids(String[] eiids) {
		this.eiids = eiids;
	}

	public String[] getEiversions() {
		return eiversions;
	}

	public void setEiversions(String[] eiversions) {
		this.eiversions = eiversions;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

}
