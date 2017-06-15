package com.deliverik.infogovernor.asset.form;



import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.base.BaseForm;

/**
 * �����ѯ����FORM
 * 
 */
public class IGASM1712Form extends BaseForm implements IG013Info{

	private static final long serialVersionUID = 1L;

	/** �ʲ�ģ�ͱ�� */
	protected String elabel;
	
	/** �ʲ�ģ���� */
	protected String ename;
	
	/** ������ */
	protected String eilabel;
	
	/** ������� */
	protected String einame;
	
	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;
	
	/** �ʲ�ģ��һ������ */
	protected String ekey1;
	
	/** �ʲ�ģ�Ͷ������� */
	protected String ekey2;
	
	/** �������ʱ��FROM */
	protected String eiupdtime_from;
	
	/** �������ʱ��TO */
	protected String eiupdtime_to;
	
	/** ɾ��������� */
	protected String[] deleteEiid;
	
	/** ��������������������� */
	protected String[] cname = new String[4];
	
	/** �������ֵ������������ */
	protected String[] civalue = new String[4];
	
	/** �����ͨ���ñ�ż����������� */
	protected String[] cclabel = new String[2];
	
	/** �����ͨ����ֵ������������ */
	protected String[] ccivalue = new String[2];
	
	/** �ʲ�����������*/
	protected String eiorgsyscoding;
	
	/** �ʲ���������������*/
	protected String eiorgname;
	
	/** �ʲ�������ģ��*/
	protected String esyscoding;
	
	/** �ʲ����״̬ */
	protected String eistatus;//�·���N|R  �Ͻɴ�U  ���ϴ�N|R  
	/** ���id */
	protected Integer eiid;
	
	/** ����Ǽ��� */
	protected String eiinsdate;
	
	/** ģ��id */
	protected Integer eid;

	/** �������ʱ��*/
	protected String eiupdtime;
	/** ����汾*/
	protected Integer eiversion;
	
	/** ���˵��*/
	protected String eidesc;
	
	/** ������ */
	protected String eilabelbak;
	
	/** �ʲ�������*/
	protected String eiuserid;
	
	protected String fingerPrint;
	
	/** Ȩ��*/
	protected boolean permission;
	
	/** �ʲ�����������*/
	protected String eiusername;
	
	/** �Ƿ��ɫ������ */
	protected boolean roleManager;

	/** �ʲ�С�汾*/
	protected Integer eismallversion;
	
	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	public String getEidesc() {
		return eidesc;
	}

	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	public Integer getEiversion() {
		return eiversion;
	}

	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	public String getEiupdtime() {
		return eiupdtime;
	}

	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEiinsdate() {
		return eiinsdate;
	}

	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
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
	 * �ʲ�ģ����ȡ��
	 * @return �ʲ�ģ����
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ�ģ�����趨
	 *
	 * @param ename �ʲ�ģ����
	 */
	public void setEname(String ename) {
		this.ename = ename;
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
	 * �ʲ�ģ�ͷ���ȡ��
	 * @return �ʲ�ģ�ͷ���
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * �ʲ�ģ�ͷ����趨
	 *
	 * @param ecategory �ʲ�ģ�ͷ���
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	/**
	 * �ʲ�ģ��һ������ȡ��
	 * @return �ʲ�ģ��һ������
	 */
	public String getEkey1() {
		return ekey1;
	}

	/**
	 * �ʲ�ģ��һ�������趨
	 *
	 * @param ekey1 �ʲ�ģ��һ������
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * �ʲ�ģ�Ͷ�������ȡ��
	 * @return �ʲ�ģ�Ͷ�������
	 */
	public String getEkey2() {
		return ekey2;
	}

	/**
	 * �ʲ�ģ�Ͷ��������趨
	 *
	 * @param ekey1 �ʲ�ģ�Ͷ�������
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * �������ʱ��FROMȡ��
	 * @return �������ʱ��FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * �������ʱ��FROM�趨
	 *
	 * @param eiupdtime_from �������ʱ��FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * �������ʱ��TOȡ��
	 * @return �������ʱ��TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * �������ʱ��TO�趨
	 *
	 * @param eiupdtime_to �������ʱ��TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}


	/**
	 * ɾ���������ȡ��
	 * @return ɾ���������
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}


	/**
	 * ɾ����������趨
	 *
	 * @param deleteEiid ɾ���������
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * ���������������������ȡ��
	 * @return ���������������������
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * ����������������������趨
	 *
	 * @param cname ���������������������
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * �������ֵ������������ȡ��
	 * @return �������ֵ������������
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * �������ֵ�������������趨
	 *
	 * @param civalue �������ֵ������������
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * �����ͨ���ñ�ż�����������ȡ��
	 * @return �����ͨ���ñ�ż�����������
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * �����ͨ���ñ�ż������������趨
	 *
	 * @param cclabel �����ͨ���ñ�ż�����������
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * �����ͨ����ֵ������������ȡ��
	 * @return �����ͨ����ֵ������������
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * �����ͨ����ֵ�������������趨
	 *
	 * @param ccivalue �����ͨ����ֵ������������
	 */
	public void setCcivalue(String[] ccivalue) {
		this.ccivalue = ccivalue;
	}
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getEilabelbak() {
		return eilabelbak;
	}

	/**
	 * �������趨
	 *
	 * @param eilabelbak ������
	 */
	public void setEilabelbak(String eilabelbak) {
		this.eilabelbak = eilabelbak;
	}

	/**
	 * ��ʼ������
	 *
	 * @param mapping 
	 * @param request 
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.deleteEiid = null;
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
	 * Ȩ��ȡ��
	 * @return Ȩ��
	 */
	public boolean isPermission() {
		return permission;
	}

	/**
	 * Ȩ���趨
	 *
	 * @param permission Ȩ��
	 */
	public void setPermission(boolean permission) {
		this.permission = permission;
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
	/**
	 * �Ƿ��ɫ������ȡ��
	 * @return �Ƿ��ɫ������
	 */
	public boolean isRoleManager() {
		return roleManager;
	}

	/**
	 * �Ƿ��ɫ�������趨
	 *
	 * @param roleManager �Ƿ��ɫ������
	 */
	public void setRoleManager(boolean roleManager) {
		this.roleManager = roleManager;
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
