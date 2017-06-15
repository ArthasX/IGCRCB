package com.deliverik.infogovernor.ven.form;

import com.deliverik.framework.base.BaseForm;


/**
 * ���ռ����FORM
 * 
 */
@SuppressWarnings("serial")
public class IGVEN0201Form extends BaseForm {
	
	protected Integer rmid;

	/** ���ղ�������id */
	protected Integer rsid;

	/** ����������� */
	protected String rmname;

	/** �ƻ���ʼʱ�� */
	protected String rmstartdate;
	
	/** ��ѯ���� �ƻ���ʼʱ��*/
	protected String rmstartdate_from;
	
	/** ��ѯ���� �ƻ���ʼʱ��*/
	protected String rmstartdate_to;

	/** ʵ�����ʱ�� */
	protected String rmenddate;
	
	/** ��ѯ���� ʵ�����ʱ��*/
	protected String rmenddate_from;
	
	/** ��ѯ���� ʵ�����ʱ��*/
	protected String rmenddate_to;

	/**
	 * rmidȡ��
	 * @return rmid  rmid
	 */
	public Integer getRmid() {
		return rmid;
	}

	/**
	 * rmid�趨
	 * @param rmid  rmid
	 */
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}

	/**
	 * ���ղ�������idȡ��
	 * @return rsid  ���ղ�������id
	 */
	public Integer getRsid() {
		return rsid;
	}

	/**
	 * ���ղ�������id�趨
	 * @param rsid  ���ղ�������id
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}

	/**
	 * �����������ȡ��
	 * @return rmname  �����������
	 */
	public String getRmname() {
		return rmname;
	}

	/**
	 * ������������趨
	 * @param rmname  �����������
	 */
	public void setRmname(String rmname) {
		this.rmname = rmname;
	}

	/**
	 * �ƻ���ʼʱ��ȡ��
	 * @return rmstartdate  �ƻ���ʼʱ��
	 */
	public String getRmstartdate() {
		return rmstartdate;
	}

	/**
	 * �ƻ���ʼʱ���趨
	 * @param rmstartdate  �ƻ���ʼʱ��
	 */
	public void setRmstartdate(String rmstartdate) {
		this.rmstartdate = rmstartdate;
	}

	/**
	 * ��ѯ�����ƻ���ʼʱ��ȡ��
	 * @return rmstartdate_from  ��ѯ�����ƻ���ʼʱ��
	 */
	public String getRmstartdate_from() {
		return rmstartdate_from;
	}

	/**
	 * ��ѯ�����ƻ���ʼʱ���趨
	 * @param rmstartdate_from  ��ѯ�����ƻ���ʼʱ��
	 */
	public void setRmstartdate_from(String rmstartdate_from) {
		this.rmstartdate_from = rmstartdate_from;
	}

	/**
	 * ��ѯ�����ƻ���ʼʱ��ȡ��
	 * @return rmstartdate_to  ��ѯ�����ƻ���ʼʱ��
	 */
	public String getRmstartdate_to() {
		return rmstartdate_to;
	}

	/**
	 * ��ѯ�����ƻ���ʼʱ���趨
	 * @param rmstartdate_to  ��ѯ�����ƻ���ʼʱ��
	 */
	public void setRmstartdate_to(String rmstartdate_to) {
		this.rmstartdate_to = rmstartdate_to;
	}

	/**
	 * ʵ�����ʱ��ȡ��
	 * @return rmenddate  ʵ�����ʱ��
	 */
	public String getRmenddate() {
		return rmenddate;
	}

	/**
	 * ʵ�����ʱ���趨
	 * @param rmenddate  ʵ�����ʱ��
	 */
	public void setRmenddate(String rmenddate) {
		this.rmenddate = rmenddate;
	}

	/**
	 * ��ѯ����ʵ�����ʱ��ȡ��
	 * @return rmenddate_from  ��ѯ����ʵ�����ʱ��
	 */
	public String getRmenddate_from() {
		return rmenddate_from;
	}

	/**
	 * ��ѯ����ʵ�����ʱ���趨
	 * @param rmenddate_from  ��ѯ����ʵ�����ʱ��
	 */
	public void setRmenddate_from(String rmenddate_from) {
		this.rmenddate_from = rmenddate_from;
	}

	/**
	 * ��ѯ����ʵ�����ʱ��ȡ��
	 * @return rmenddate_to  ��ѯ����ʵ�����ʱ��
	 */
	public String getRmenddate_to() {
		return rmenddate_to;
	}

	/**
	 * ��ѯ����ʵ�����ʱ���趨
	 * @param rmenddate_to  ��ѯ����ʵ�����ʱ��
	 */
	public void setRmenddate_to(String rmenddate_to) {
		this.rmenddate_to = rmenddate_to;
	}

	
	
	
	
	
	
	//-----------------------------------------------
//	/** ���ռ����ID */
//	protected Integer rcrid;
//	
//	/** ���ռ��ID */
//	protected Integer rcid;
//
//	/** ���ռ��ƻ����ʱ�� */
//	protected String rcrplandate;
//	
//	/** ���ռ��ʵ�ʼ��ʱ�� */
//	protected String rcrrealtime;
//	
//	/** ���ռ�����ύ��ID */
//	protected String rcruserid;
//	
//	/** ���ռ��������������_like */
//	protected String rcusername_like;
//	
//	/** ���ռ�����ύ������ */
//	protected String rcrusername;
//	
//	/** ���ռ���� */
//	protected String rcrresult;
//	
//	/** ���ռ����˵�� */
//	protected String rcrcomment;
//	
//	/** ���ռ����� */
//	protected RiskCheck riskCheck;
//
//	
//	/** �ƻ�ִ�м�鿪ʼ���ڣ���ѯ������ */
//	protected String startdate;
//	
//	/** �ƻ�ִ�м��������ڣ���ѯ������*/
//	protected String enddate;
//	
//	/** �ƻ�ִ�м�����ѯ������*/
//	protected String rcname_like;
//	
//	/** �ƻ�ִ�м�鿪ʼ����from����ѯ������*/
//	protected String ntime_from;
//	
//	/** �ƻ�ִ�м�鿪ʼ����to����ѯ������*/
//	protected String ntime_to;
//	
//	/** �ƻ�ִ�м���������from����ѯ������*/
//	protected String etime_from;
//	
//	/** �ƻ�ִ�м���������to����ѯ������*/
//	protected String etime_to;	
//
//	/** δ��鹤����ʶ */
//	protected String chtype;
//	
//	/** ���ռ������� */
//	protected String rccategory;
//	
//	/** ���ռ����������� */
//	protected String rccategoryname;
//	
//	protected Integer csid;
//	
//	
//	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
//	
//	/** ���ռ��״̬ */
//	protected String rcrstatic;
//	
//	/** ��Ҫ�̶� */
//	protected String rctype_eq;
//	
//	/** ���ر�ʶ */
//	protected String mode;
//	protected String ciiop;
//	protected String rcrtestmode;
//	
//	/** ���ռ������ */
//	protected String rcclass;
//	/**
//	 * ���ر�ʶ��ȡ
//	 * 
//	 * @return ���ر�ʶ
//	 */
//	public String getMode() {
//		return mode;
//	}
//
//	/**
//	 * ���ر�ʶ�趨
//	 * 
//	 * @param mode ���ر�ʶ
//	 */
//	public void setMode(String mode) {
//		this.mode = mode;
//	}
//	
//	/**
//	 * ��Ҫ�̶Ȼ�ȡ
//	 * 
//	 * @return ��Ҫ�̶�
//	 */
//	public String getRctype_eq() {
//		return rctype_eq;
//	}
//
//	/**
//	 * ��Ҫ�̶��趨
//	 * 
//	 * @param rctype_eq ��Ҫ�̶�
//	 */
//	public void setRctype_eq(String rctype_eq) {
//		this.rctype_eq = rctype_eq;
//	}
//	/**
//	 * �ƻ�ִ�м�鿪ʼ���ڣ���ѯ������ȡ��
//	 * @return �ƻ�ִ�м�鿪ʼ���ڣ���ѯ������
//	 */
//	public String getStartdate() {
//		return startdate;
//	}
//
//
//	/**
//	 * �ƻ�ִ�м��������ڣ���ѯ������ȡ��
//	 * @return �ƻ�ִ�м��������ڣ���ѯ������
//	 */
//	public String getEnddate() {
//		return enddate;
//	}
//
//
//	/**
//	 * �ƻ�ִ�м�鿪ʼ���ڣ���ѯ�������趨
//	 * @param startdate �ƻ�ִ�м�鿪ʼ���ڣ���ѯ������
//	 */
//	public void setStartdate(String startdate) {
//		this.startdate = startdate;
//	}
//
//
//	/**
//	 * �ƻ�ִ�м��������ڣ���ѯ�������趨
//	 * @param enddate �ƻ�ִ�м��������ڣ���ѯ������
//	 */
//	public void setEnddate(String enddate) {
//		this.enddate = enddate;
//	}
//
//
//	/**
//	 * @return the fileMap
//	 */
//	public Map<Integer, FormFile> getFileMap() {
//		return fileMap;
//	}
//
//
//	/**
//	 * @param fileMap the fileMap to set
//	 */
//	public void setFileMap(Map<Integer, FormFile> fileMap) {
//		this.fileMap = fileMap;
//	}
//
//
//	/**
//	 * ���ռ������������ȡ��
//	 * @return ���ռ������������
//	 */
//	public FormFile getAttachFile(int index) {
//		return (FormFile) fileMap.get( new Integer( index ) );
//	}
//
//
//	/**
//	 * ���ռ������������
//	 *
//	 * @param index ���ռ��������������������
//	 * @param file ���ռ������������
//	 */
//	public void setAttachFile(int index, FormFile file) {
//		fileMap.put( new Integer( index ), file );
//	}
//
//
//	/**
//	 * ���ռ����IDȡ��
//	 * @return ���ռ����ID
//	 */
//	public Integer getRcrid() {
//		return rcrid;
//	}
//
//	/**
//	 * ���ռ��IDȡ��
//	 * @return the ���ռ��ID
//	 */
//	public Integer getRcid() {
//		return rcid;
//	}
//
//	/**
//	 * ���ռ��ƻ����ʱ��ȡ��
//	 * @return ���ռ��ƻ����ʱ��
//	 */
//	public String getRcrplandate() {
//		return rcrplandate;
//	}
//
//	/**
//	 * ���ռ��ʵ�ʼ��ʱ��ȡ��
//	 * @return ���ռ��ʵ�ʼ��ʱ��
//	 */
//	public String getRcrrealtime() {
//		return rcrrealtime;
//	}
//
//	/**
//	 * ���ռ�����ύ��IDȡ��
//	 * @return ���ռ�����ύ��ID
//	 */
//	public String getRcruserid() {
//		return rcruserid;
//	}
//
//	/**
//	 * ���ռ�����ύ������ȡ��
//	 * @return ���ռ�����ύ������
//	 */
//	public String getRcrusername() {
//		return rcrusername;
//	}
//
//	/**
//	 * ���ռ�����趨
//	 * @param rcrresult ���ռ����
//	 */
//	public String getRcrresult() {
//		return rcrresult;
//	}
//
//	/**
//	 * ���ռ����˵��ȡ��
//	 * @return ���ռ����˵��
//	 */
//	public String getRcrcomment() {
//		return rcrcomment;
//	}
//
//	/**
//	 * ���ռ�����ȡ��
//	 * @return ���ռ�����
//	 */
//	public RiskCheck getRiskCheck() {
//		return riskCheck;
//	}
//
//	/**
//	 * ���ռ����ID�趨
//	 * @param rcrid ���ռ����ID
//	 */
//	public void setRcrid(Integer rcrid) {
//		this.rcrid = rcrid;
//	}
//
//	/**
//	 * ���ռ��ID�趨
//	 * @param rcid ���ռ��ID
//	 */
//	public void setRcid(Integer rcid) {
//		this.rcid = rcid;
//	}
//
//	/**
//	 * ���ռ��ƻ����ʱ���趨
//	 * @param rcrplandate ���ռ��ƻ����ʱ��
//	 */
//	public void setRcrplandate(String rcrplandate) {
//		this.rcrplandate = rcrplandate;
//	}
//
//	/**
//	 * ���ռ��ʵ�ʼ��ʱ���趨
//	 * @param rcrrealtime ���ռ��ʵ�ʼ��ʱ��
//	 */
//	public void setRcrrealtime(String rcrrealtime) {
//		this.rcrrealtime = rcrrealtime;
//	}
//
//	/**
//	 * ���ռ�����ύ��ID�趨
//	 * @param rcruserid ���ռ�����ύ��ID
//	 */
//	public void setRcruserid(String rcruserid) {
//		this.rcruserid = rcruserid;
//	}
//
//	/**
//	 * ���ռ�����ύ�������趨
//	 * @param rcrusername ���ռ�����ύ������
//	 */
//	public void setRcrusername(String rcrusername) {
//		this.rcrusername = rcrusername;
//	}
//
//	/**
//	 * ���ռ�����趨
//	 * @param rcrresult ���ռ����
//	 */
//	public void setRcrresult(String rcrresult) {
//		this.rcrresult = rcrresult;
//	}
//
//	/**
//	 * ���ռ����˵���趨
//	 * @param rcrcomment ���ռ����˵��
//	 */
//	public void setRcrcomment(String rcrcomment) {
//		this.rcrcomment = rcrcomment;
//	}
//
//	/**
//	 * ���ռ������趨
//	 * @param riskCheck ���ռ�����
//	 */
//	public void setRiskCheck(RiskCheck riskCheck) {
//		this.riskCheck = riskCheck;
//	}
//
//	/**
//	 * ���ռ��������������_likeȡ��
//	 * return ���ռ��������������_like
//	 */	
//	public String getRcusername_like() {
//		return rcusername_like;
//	}
//
//	/**
//	 * ���ռ��������������_like�趨
//	 * @param rcrcomment ���ռ��������������_like
//	 */
//	public void setRcusername_like(String rcusername_like) {
//		this.rcusername_like = rcusername_like;
//	}
//
//	
//	public String getRcname_like() {
//		return rcname_like;
//	}
//
//
//	public void setRcname_like(String rcname_like) {
//		this.rcname_like = rcname_like;
//	}
//
//
//	public String getNtime_from() {
//		return ntime_from;
//	}
//
//
//	public void setNtime_from(String ntime_from) {
//		this.ntime_from = ntime_from;
//	}
//
//
//	public String getNtime_to() {
//		return ntime_to;
//	}
//
//
//	public void setNtime_to(String ntime_to) {
//		this.ntime_to = ntime_to;
//	}
//
//	/**
//	 * δ��鹤����ʶȡ��
//	 * @return δ��鹤����ʶ
//	 */
//	public String getChtype() {
//		return chtype;
//	}
//	
//	/**
//	 * δ��鹤����ʶ�趨
//	 *
//	 * @param notReview δ��鹤����ʶ
//	 */
//	public void setChtype(String chtype) {
//		this.chtype = chtype;
//	}
//	
//	/**
//	 * ���ռ�������ȡ��
//	 * @return ���ռ�������
//	 */
//	public String getRccategory() {
//		return rccategory;
//	}
//
//	/**
//	 * ���ռ��������趨
//	 *
//	 * @param rccategory ���ռ�������
//	 */
//	public void setRccategory(String rccategory) {
//		this.rccategory = rccategory;
//	}
//
//	/**
//	 * ���ռ�����������ȡ��
//	 * @return ���ռ�����������
//	 */
//	public String getRccategoryname() {
//		return rccategoryname;
//	}
//
//	/**
//	 * ���ռ������������趨
//	 *
//	 * @param rccategoryname ���ռ�����������
//	 */
//	public void setRccategoryname(String rccategoryname) {
//		this.rccategoryname = rccategoryname;
//	}
//
//	/**
//	 * ���ռ��״̬ȡ��
//	 * @return ���ռ��״̬
//	 */
//	public String getRcrstatic() {
//		return rcrstatic;
//	}
//
//	/**
//	 * ���ռ��״̬�趨
//	 *
//	 * @param rcrstatic ���ռ��״̬
//	 */
//	public void setRcrstatic(String rcrstatic) {
//		this.rcrstatic = rcrstatic;
//	}
//
//	public String getCiiop() {
//		return ciiop;
//	}
//
//	public void setCiiop(String ciiop) {
//		this.ciiop = ciiop;
//	}
//
//	public String getRcrtestmode() {
//		return rcrtestmode;
//	}
//
//	public void setRcrtestmode(String rcrtestmode) {
//		this.rcrtestmode = rcrtestmode;
//	}
//
//	/**
//	 * ���ռ������ȡ��
//	 * @return rcclass ���ռ������
//	 */
//	public String getRcclass() {
//		return rcclass;
//	}
//
//	
//	/**
//	 * @return the etime_from
//	 */
//	public String getEtime_from() {
//		return etime_from;
//	}
//
//	/**
//	 * @param etime_from the etime_from to set
//	 */
//	public void setEtime_from(String etime_from) {
//		this.etime_from = etime_from;
//	}
//
//	/**
//	 * @return the etime_to
//	 */
//	public String getEtime_to() {
//		return etime_to;
//	}
//
//	/**
//	 * @param etime_to the etime_to to set
//	 */
//	public void setEtime_to(String etime_to) {
//		this.etime_to = etime_to;
//	}
//
//	/**
//	 * ���ռ�������趨
//	 * @param rcclass ���ռ������
//	 */
//	public void setRcclass(String rcclass) {
//		this.rcclass = rcclass;
//	}
//
//	/**
//	 * @return the csid
//	 */
//	public Integer getCsid() {
//		return csid;
//	}
//
//	/**
//	 * @param csid the csid to set
//	 */
//	public void setCsid(Integer csid) {
//		this.csid = csid;
//	}
	
	
}
