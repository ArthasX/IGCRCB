package com.deliverik.infogovernor.asset.form;



import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * �����¼��ѯ����FORM
 * 
 */
public class IGASM1412Form extends BaseForm implements SOC0118Info{

	private static final long serialVersionUID = 1L;

	/** �ʲ�ģ�ͱ�� */
	protected String elabel;
	
	/** �ʲ�ģ���� */
	protected String ename;
	
	/** �����¼��� */
	protected String eilabel;
	
	/** �����¼���� */
	protected String einame;
	
	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;
	
	/** �ʲ�ģ��һ������ */
	protected String ekey1;
	
	/** �ʲ�ģ�Ͷ������� */
	protected String ekey2;
	
	/** �����¼����ʱ��FROM */
	protected String eiupdtime_from;
	
	/** �����¼����ʱ��TO */
	protected String eiupdtime_to;
	
	/** ɾ�������¼���� */
	protected String[] deleteEiid;
	
	/** �����¼������������������ */
	protected String[] cname = new String[4];
	
	/** �����¼����ֵ������������ */
	protected String[] civalue = new String[4];
	
	/** �����¼��ͨ���ñ�ż����������� */
	protected String[] cclabel = new String[2];
	
	/** �����¼��ͨ����ֵ������������ */
	protected String[] ccivalue = new String[2];
	/** �ʲ�����������*/
	protected String eiorgsyscoding;
	
	/** �ʲ���������������*/
	protected String eiorgname;
	
	/** �ʲ�������ģ��*/
	protected String esyscoding;
	
	/** �ʲ����״̬ */
	protected String eistatus;//�·���N|R  �Ͻɴ�U  ���ϴ�N|R  
	/** �����¼id */
	protected Integer eiid;
	
	/** �����¼�Ǽ��� */
	protected String eiinsdate;
	
	/** ģ��id */
	protected String eid;

	/** �����¼����ʱ��*/
	protected String eiupdtime;
	/** �����¼�汾*/
	protected Integer eiversion;
	
	/** �����¼˵��*/
	protected String eidesc;
	
	/** �����¼��� */
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
	 * �����¼����ȡ��
	 * @return �����¼����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �����¼�����趨
	 *
	 * @param eilabel �����¼����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �����¼����ȡ��
	 * @return �����¼����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �����¼�����趨
	 *
	 * @param einame �����¼����
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
	 * �����¼����ʱ��FROMȡ��
	 * @return �����¼����ʱ��FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * �����¼����ʱ��FROM�趨
	 *
	 * @param eiupdtime_from �����¼����ʱ��FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * �����¼����ʱ��TOȡ��
	 * @return �����¼����ʱ��TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * �����¼����ʱ��TO�趨
	 *
	 * @param eiupdtime_to �����¼����ʱ��TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}


	/**
	 * ɾ�������¼����ȡ��
	 * @return ɾ�������¼����
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}


	/**
	 * ɾ�������¼�����趨
	 *
	 * @param deleteEiid ɾ�������¼����
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * �����¼������������������ȡ��
	 * @return �����¼������������������
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * �����¼�������������������趨
	 *
	 * @param cname �����¼������������������
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * �����¼����ֵ������������ȡ��
	 * @return �����¼����ֵ������������
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * �����¼����ֵ�������������趨
	 *
	 * @param civalue �����¼����ֵ������������
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * �����¼��ͨ���ñ�ż�����������ȡ��
	 * @return �����¼��ͨ���ñ�ż�����������
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * �����¼��ͨ���ñ�ż������������趨
	 *
	 * @param cclabel �����¼��ͨ���ñ�ż�����������
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * �����¼��ͨ����ֵ������������ȡ��
	 * @return �����¼��ͨ����ֵ������������
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * �����¼��ͨ����ֵ�������������趨
	 *
	 * @param ccivalue �����¼��ͨ����ֵ������������
	 */
	public void setCcivalue(String[] ccivalue) {
		this.ccivalue = ccivalue;
	}
	
	/**
	 * �����¼���ȡ��
	 * @return �����¼���
	 */
	public String getEilabelbak() {
		return eilabelbak;
	}

	/**
	 * �����¼����趨
	 *
	 * @param eilabelbak �����¼���
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
	 * @param isRoleManager �Ƿ��ɫ������
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

	public SOC0117TB getSoc0117TB() {
		// TODO Auto-generated method stub
		return null;
	}
}
