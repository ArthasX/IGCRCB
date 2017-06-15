package com.deliverik.infogovernor.asset.form;



import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * �ĵ���ѯ����FORM
 * 
 */
public class IGASM5008Form extends BaseForm implements SOC0118Info{

	private static final long serialVersionUID = 1L;

	/** �ʲ�ģ�ͱ�� */
	protected String elabel;
	
	/** �ʲ�ģ���� */
	protected String ename;
	
	/** �ĵ���� */
	protected String eilabel;
	
	/** �ĵ����� */
	protected String einame;
	
	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;
	
	/** �ʲ�ģ��һ������ */
	protected String ekey1;
	
	/** �ʲ�ģ�Ͷ������� */
	protected String ekey2;
	
	/** �ĵ�����ʱ��FROM */
	protected String eiupdtime_from;
	
	/** �ĵ�����ʱ��TO */
	protected String eiupdtime_to;
	
	/** ɾ���ĵ����� */
	protected String[] deleteEiid;
	
	/** �ĵ������������������� */
	protected String[] cname = new String[4];
	
	/** �ĵ�����ֵ������������ */
	protected String[] civalue = new String[4];
	
	/** �ĵ���ͨ���ñ�ż����������� */
	protected String[] cclabel = new String[2];
	
	/** �ĵ���ͨ����ֵ������������ */
	protected String[] ccivalue = new String[2];
	
	/** �ʲ�����������*/
	protected String eiorgsyscoding;
	
	/** �ʲ���������������*/
	protected String eiorgname;
	
	/** �ʲ�������ģ��*/
	protected String esyscoding;
	
	/** �ʲ����״̬ */
	protected String eistatus;//�·���N|R  �Ͻɴ�U  ���ϴ�N|R  
	/** �ĵ�id */
	protected Integer eiid;
	
	/** �ĵ��Ǽ��� */
	protected String eiinsdate;
	
	/** ģ��id */
	protected String eid;

	/** �ĵ�����ʱ��*/
	protected String eiupdtime;
	/** �ĵ��汾*/
	protected Integer eiversion;
	
	/** �ĵ�˵��*/
	protected String eidesc;
	
	/** �ĵ���� */
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

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
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
	 * �ĵ�����ʱ��FROMȡ��
	 * @return �ĵ�����ʱ��FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * �ĵ�����ʱ��FROM�趨
	 *
	 * @param eiupdtime_from �ĵ�����ʱ��FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * �ĵ�����ʱ��TOȡ��
	 * @return �ĵ�����ʱ��TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * �ĵ�����ʱ��TO�趨
	 *
	 * @param eiupdtime_to �ĵ�����ʱ��TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}


	/**
	 * ɾ���ĵ�����ȡ��
	 * @return ɾ���ĵ�����
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}


	/**
	 * ɾ���ĵ������趨
	 *
	 * @param deleteEiid ɾ���ĵ�����
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * �ĵ�������������������ȡ��
	 * @return �ĵ�������������������
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * �ĵ��������������������趨
	 *
	 * @param cname �ĵ�������������������
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * �ĵ�����ֵ������������ȡ��
	 * @return �ĵ�����ֵ������������
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * �ĵ�����ֵ�������������趨
	 *
	 * @param civalue �ĵ�����ֵ������������
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * �ĵ���ͨ���ñ�ż�����������ȡ��
	 * @return �ĵ���ͨ���ñ�ż�����������
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * �ĵ���ͨ���ñ�ż������������趨
	 *
	 * @param cclabel �ĵ���ͨ���ñ�ż�����������
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * �ĵ���ͨ����ֵ������������ȡ��
	 * @return �ĵ���ͨ����ֵ������������
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * �ĵ���ͨ����ֵ�������������趨
	 *
	 * @param ccivalue �ĵ���ͨ����ֵ������������
	 */
	public void setCcivalue(String[] ccivalue) {
		this.ccivalue = ccivalue;
	}
	
	/**
	 * �ĵ����ȡ��
	 * @return �ĵ����
	 */
	public String getEilabelbak() {
		return eilabelbak;
	}

	/**
	 * �ĵ�����趨
	 *
	 * @param eilabelbak �ĵ����
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
		return null;
	}
	
}
