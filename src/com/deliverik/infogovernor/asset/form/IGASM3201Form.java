package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ��Ա�༭����FORM
 * 
 */
public class IGASM3201Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** �ʲ�ID */
	protected Integer eiid;
	
	/** �����¼����� */
	protected String fcname;
	
	/** �����¼����� */
	protected String fcdesc;
	
	/** �����¼���Դ */
	protected String fcorigin;
	
	/** �����¼��������� */
	protected String fccategory;
	
	/** ��������������� */
	protected String fccheckjob;
	
	/** �����������ID */
	protected String riskjobid;
	
	/** ���յ����� */
	protected String fcriskname;
	
	/** ���յ�ID */
	protected String riskid;
	
	/** ���յ�������� */
	protected String fctypename;
	
	/** ���յ����ID */
	protected String risktype;
	
	/** �������ؼ������� */
	protected String fcseveritylevel;
	
	/** ���շ������������� */
	protected String fcpossibility;
	
	/** ���ռ������� */
	protected String fclevel;
	
	/** ����ʶ��ʱ�� */
	protected String riskcatchtime;
	
	/** Ӧ���������� */
	protected String fcrisktask;
	
	/** Ӧ���������� */
	protected String fcrisktaskdesc;
	
	/** Ӧ�Բ��� */
	protected String fcpolicy;
	
	/** Ӧ��Ŀ�� */
	protected String fcoperatoraim;
	
	/** Ӧ�Բ��� */
	protected String fcoperatordept;
	
	/** Ӧ�Բ���ID */
	protected String riskoperatordept;
	
	/** Ӧ�Ը����� */
	protected String fcoperator;
	
	/** Ӧ�Ը�����ID */
	protected String riskoperator;
	
	/** ���ͷ����Ա */
	protected String fcccoperator;
	
	/** ���ͷ����ԱID */
	protected String riskccoperator;
	
	/** ������ */
	protected String riskreviewresult;
	
	/** �������Ĺ���ID */
	protected String riskdealid;
	
	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ�ģ�ͱ��� */
	protected String elabel;

	/** �ʲ�ģ������ */
	protected String ename;

	/** �ʲ����� */
	protected String einame;
	
	/** �ʲ���� */
	protected String eilabel;

	/** �ʲ�˵�� */
	protected String eidesc;

	/** �ʲ�״̬ */
	protected String eistatus;

	/** �ʲ����ʱ�� */
	protected String eiupdtime;
	
	/** �ʲ����°汾�� */
	protected String eiversion;

	/** �Ǽ��� */
	protected String eiinsdate;
	
	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";
	
	/** �ʲ���������*/
	public String eiorgsyscoding;
	
	/** �ʲ�������������*/
	public String eiorgname;
	
	/** �ʲ��Ǽ���*/
	protected String eiuserid;
	
	/** �ʲ��Ǽ�������*/
	protected String eiusername;
	
	protected String fingerPrint;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;
	
	/** ����ʶ��ʼʱ��*/
	protected String riskcatchtime_from;
	
	/** ����ʶ�����ʱ��*/
	protected String riskcatchtime_to;
	
	/**����*/
	protected String prdesc;
	
	/**�����ʶ*/
	protected String order;
	
	/** �����ֶ� */
	protected String sing;
	
	/** �ʲ�������ģ��*/
	public String esyscoding;
	
	/**�����˵�����־λ*/
	protected String showFlag;

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

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
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
	 * ��Ա����ȡ��
	 * @return ��Ա����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ��Ա�����趨
	 *
	 * @param einame ��Ա����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ��Ա����ȡ��
	 * @return ��Ա����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ��Ա�����趨
	 *
	 * @param eilabel ��Ա����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ��Ա˵��ȡ��
	 * @return ��Ա˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * ��Ա˵���趨
	 *
	 * @param eidesc ��Ա˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * ��Ա����ʱ��ȡ��
	 * @return ��Ա����ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * ��Ա����ʱ���趨
	 *
	 * @param eiupdtime ��Ա����ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * ��Ա״̬ȡ��
	 * @return ��Ա״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * ��Ա״̬�趨
	 *
	 * @param eistatus ��Ա״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * ��Ա�汾��ȡ��
	 * @return ��Ա�汾��
	 */
	public String getEiversion() {
		return eiversion;
	}

	/**
	 * ��Ա�汾���趨
	 *
	 * @param eiversion ��Ա�汾��
	 */
	public void setEiversion(String eiversion) {
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
	 * ��Ա�Ǽ���ȡ��
	 * @return ��Ա�Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * ��Ա�Ǽ����趨
	 *
	 * @param eiinsdate ��Ա�Ǽ���
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
	

	public String getFccategory() {
		return fccategory;
	}

	public void setFccategory(String fccategory) {
		this.fccategory = fccategory;
	}

	public String getFcname() {
		return fcname;
	}

	public void setFcname(String fcname) {
		this.fcname = fcname;
	}

	public String getFcdesc() {
		return fcdesc;
	}

	public void setFcdesc(String fcdesc) {
		this.fcdesc = fcdesc;
	}
	
	public String getFcorigin() {
		return fcorigin;
	}

	public void setFcorigin(String fcorigin) {
		this.fcorigin = fcorigin;
	}

	public String getFcriskname() {
		return fcriskname;
	}

	public void setFcriskname(String fcriskname) {
		this.fcriskname = fcriskname;
	}

	public String getRiskid() {
		return riskid;
	}

	public void setRiskid(String riskid) {
		this.riskid = riskid;
	}

	public String getFccheckjob() {
		return fccheckjob;
	}

	public void setFccheckjob(String fccheckjob) {
		this.fccheckjob = fccheckjob;
	}

	public String getRiskjobid() {
		return riskjobid;
	}

	public void setRiskjobid(String riskjobid) {
		this.riskjobid = riskjobid;
	}

	public String getFctypename() {
		return fctypename;
	}

	public void setFctypename(String fctypename) {
		this.fctypename = fctypename;
	}

	public String getRisktype() {
		return risktype;
	}

	public void setRisktype(String risktype) {
		this.risktype = risktype;
	}

	public String getFcseveritylevel() {
		return fcseveritylevel;
	}

	public void setFcseveritylevel(String fcseveritylevel) {
		this.fcseveritylevel = fcseveritylevel;
	}

	public String getFcpossibility() {
		return fcpossibility;
	}

	public void setFcpossibility(String fcpossibility) {
		this.fcpossibility = fcpossibility;
	}

	public String getFclevel() {
		return fclevel;
	}

	public void setFclevel(String fclevel) {
		this.fclevel = fclevel;
	}

	public String getRiskcatchtime() {
		return riskcatchtime;
	}

	public void setRiskcatchtime(String riskcatchtime) {
		this.riskcatchtime = riskcatchtime;
	}

	public String getFcrisktask() {
		return fcrisktask;
	}

	public void setFcrisktask(String fcrisktask) {
		this.fcrisktask = fcrisktask;
	}

	public String getFcrisktaskdesc() {
		return fcrisktaskdesc;
	}

	public void setFcrisktaskdesc(String fcrisktaskdesc) {
		this.fcrisktaskdesc = fcrisktaskdesc;
	}

	public String getFcpolicy() {
		return fcpolicy;
	}

	public void setFcpolicy(String fcpolicy) {
		this.fcpolicy = fcpolicy;
	}

	public String getFcoperatoraim() {
		return fcoperatoraim;
	}

	public void setFcoperatoraim(String fcoperatoraim) {
		this.fcoperatoraim = fcoperatoraim;
	}

	public String getFcoperatordept() {
		return fcoperatordept;
	}

	public void setFcoperatordept(String fcoperatordept) {
		this.fcoperatordept = fcoperatordept;
	}

	public String getRiskoperatordept() {
		return riskoperatordept;
	}

	public void setRiskoperatordept(String riskoperatordept) {
		this.riskoperatordept = riskoperatordept;
	}

	public String getFcoperator() {
		return fcoperator;
	}

	public void setFcoperator(String fcoperator) {
		this.fcoperator = fcoperator;
	}

	public String getRiskoperator() {
		return riskoperator;
	}

	public void setRiskoperator(String riskoperator) {
		this.riskoperator = riskoperator;
	}

	public String getFcccoperator() {
		return fcccoperator;
	}

	public void setFcccoperator(String fcccoperator) {
		this.fcccoperator = fcccoperator;
	}

	public String getRiskccoperator() {
		return riskccoperator;
	}

	public void setRiskccoperator(String riskccoperator) {
		this.riskccoperator = riskccoperator;
	}

	public String getRiskreviewresult() {
		return riskreviewresult;
	}

	public void setRiskreviewresult(String riskreviewresult) {
		this.riskreviewresult = riskreviewresult;
	}

	public String getRiskdealid() {
		return riskdealid;
	}

	public void setRiskdealid(String riskdealid) {
		this.riskdealid = riskdealid;
	}

	public Integer getEiid() {
		return eiid;
	}

	public String getRiskcatchtime_from() {
		return riskcatchtime_from;
	}

	public void setRiskcatchtime_from(String riskcatchtime_from) {
		this.riskcatchtime_from = riskcatchtime_from;
	}

	public String getRiskcatchtime_to() {
		return riskcatchtime_to;
	}

	public void setRiskcatchtime_to(String riskcatchtime_to) {
		this.riskcatchtime_to = riskcatchtime_to;
	}

	public String getSing() {
		return sing;
	}

	public void setSing(String sing) {
		this.sing = sing;
	}

	public String getPrdesc() {
		return prdesc;
	}

	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	/**
	 * @return the showFlag
	 */
	public String getShowFlag() {
		return showFlag;
	}

	/**
	 * @param showFlag the showFlag to set
	 */
	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}

}
