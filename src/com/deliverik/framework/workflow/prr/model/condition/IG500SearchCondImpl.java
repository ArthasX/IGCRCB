/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

import java.util.List;

/**
 * <p>����:���̼�¼��Ϣ��������ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public class IG500SearchCondImpl implements IG500SearchCond {

	/**
	 * ���̼�¼��Ŀ
	 */
	protected String prtitle;
	
	/**
	 * ���̼�¼����
	 */
	protected String prtype;
	
	/**
	 * ���̼�¼״̬
	 */
	protected String prstatus;
	
	/** �����˴���״̬*/
	protected String ppstatus;
	
	/**
	 * ���̼�¼ID
	 */
	protected Integer prid;
	
	/**
	 * ���̼�¼��������ID
	 */
	protected String prpdid;
	
	/**
	 * һ�����̼�¼��������IDģ����ѯ
	 */
	protected String[] prpdid_like_or;
	
	/**
	 * ���̼�¼�����Ŀ���
	 */
	protected String pcode;
	
	/**
	 * ���̼�¼�������û�����
	 */
	protected String prusername;
	
	/**
	 * ���̼�¼�����̶�
	 */
	protected String prurgency;
	
	/**
	 * ���̼�¼Ӱ��̶�
	 */
	protected String primpact;
	
	/**
	 * ���̼�¼���ȼ�
	 */
	protected String prpriority;
	
	/**
	 * ���̼�¼����ʱ�䣨����ڣ�
	 */
	protected String propentime;
	
	/**
	 * ���̼�¼����ʱ�䣨С���ڣ�
	 */
	protected String prclosetime;
	
	/**
	 * ���̼�¼�ر�ʱ�䣨like��
	 */
	protected String prclosetime_like;
	
	/**
	 * ���̼�¼����ʲ�ID
	 */
	protected Integer prassetid;
	
	/**
	 * ���̼�¼����ʲ�����
	 */
	protected String prassetcategory;
	
	/**
	 * ���̼�¼������
	 */
	protected String prserialnum;
	
	/**
	 * ���̼�¼״̬��״̬
	 */
	protected String prsubstatus;
	
	/**
	 * ���̼�¼�������û�ID
	 */
	protected String pruserid;
	
	/**
	 * ���̼�¼�����߽�ɫID
	 */
	protected Integer prroleid;
	
	/**
	 * ���̼�¼�ƻ�ִ��ʱ��
	 */
	protected String prplantime;
	
	/**
	 * ���̼�¼�ƻ�ִ��ʱ��
	 */
	protected String prplantime_like;
	
	/**
	 * ���̼�¼�ƻ�ִ������
	 */
	protected String prduration;
	
	/**
	 * ������������
	 */
	protected String[] prTypeArray;
	
	/**
	 * ����״̬����
	 */
	protected String[] prStatusArray;
	
	/**
	 * ƽ̨����
	 */
	protected String prActive;
	
	/**
	 * ƽ̨����
	 */
	protected String selectMode;
	
	/**
	 * ƽ̨����
	 */
	protected int isWork;
	
	/**
	 * ƽ̨����
	 */
	public List<Integer> pridNotInList;
	
	/**
	 * ƽ̨����
	 */
	public List<String> prserialnumNotInList;
	
	/**
	 * ƽ̨����
	 */
	protected String userid_q;
	
	/**����*/
	protected String prdesc;
	
	/**�����ʶ*/
	protected String order;
	
	protected String sing;
	
	/**���������̱�ʶ*/
	protected String lctype;
	
	/**�Ƿ�Ϊ�澯�¼�1Ϊ��0Ϊ���ȡ*/
	protected String alarm_Is;
	
	/** ���Ƿ��Ѿ�ȷ��1Ϊ��0Ϊ��*/
	protected String ppbacktime_isNull;
	
	/** ��������(����/Ӧ��) */
	protected String dwpType;

	/**
	 * ������������
	 */
	protected String[] prtypes;
	
	/** 
	 * ���˹����ĵ�ǰ�û��Ƿ��������������ɫ 
	 * ����:1
	 */
	protected String approveflag;
	
	/** �������� */
	protected String[] varnames;
	
	/** ��ֵ���� */
	protected String[] varvalues;
	
	/** ������ʶ */
	protected String[] varmodes;
	
	/** ���̲����ˣ�like��*/
	protected String ppusername_like;
	
	/** ���̲�����ID */
	protected String ppuserid;
		/** ���̲�����ID��like��*/
	/** ��������ָ��״̬����(���ݸ�ʽ��prpdid_ppstatus) */
	protected String[] prpdidAndPpstatus_or;
	
	/** ���̲�������������״̬*/
	protected String ppstatus_eq;
	
	/** ���̲����˴���ʱ���Ƿ�Ϊ�ձ�ʶ */
	protected String ppproctime_status_active;
	
	/** ���̲�����ID(��״̬����)*/
	protected String ppuserid_status_eq;
	
	/** ���̲����˽�ɫ����(��״̬����)*/
	protected String roletype_status_eq;
	
	/** ���̲�����������ɫ����(��״̬����)*/
	protected String[] pproleid_status_in;
	
	protected String ppuserid_like;

	/** �����˻����� */
	protected String prorgid_like;
	
	/**  ���̼�¼������like���� */
    protected String prserialnum_likeArr[];
    
    /** ����״̬������ */
    protected String prstatus_ne;

    /** ���̼�¼����ʱ�䣨like��*/
	protected String propentime_like;
	
	/** �����˻����� */
	protected String prorgid_in;
    
	/** ������Դ */
    protected String prassetname;
    
	/**����id��Χ*/
	protected String prid_in;
	
	/** �����˵� */
	protected String pdactname;
    
	/** �������ı�ʾ (Y����ɹ�) */
	protected String pivarlabel;
	
	/** �����ɫID���� */
	protected List<Integer> prroleid_in;
	
	/** �����ɫID���� */
	
	/**�¼�����*/
	protected String pivarValue;
	
	/**����������*/
	protected String pppivarValue;
	
	/**��鹤�����*/
	protected String csrtestmode;
	
	/**�Ƿ�Ϊ�쵼*/
	public String leaderFlag;
	
	/**����id*/
	public String orgID;
	
	
	/**
	 * ������ID
	 */
	protected Integer pid;
	
	protected String flag;
	protected List<Integer> prroleid_not_in;
	
	/** �����ؼ��� */
	protected String content;
	
	/** �������� */
	protected String[] varnames_in;
	
	/** ��ֵ���� */
	protected String[] varvalues_in;

	/**
	 * ������
	 */
	protected String prpdname;

	/**
	 * ƽ̨����
	 */
	public String getUserid_q() {
		return userid_q;
	}

	/**
	 * ƽ̨����
	 */
	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	public String getSing() {
		return sing;
	}

	public void setSing(String sing) {
		this.sing = sing;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * ���ܣ����̼�¼��Ŀȡ��
	 * @return  ���̼�¼��Ŀ
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���ܣ����̼�¼��Ŀ�趨
	 * @param prtitle ���̼�¼��Ŀ
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ���ܣ����̼�¼����ȡ��
	 * @return  ���̼�¼����
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���ܣ����̼�¼�����趨
	 * @param prtype ���̼�¼����
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ���ܣ����̼�¼״̬ȡ��
	 * @return ���̼�¼״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ���ܣ����̼�¼״̬�趨
	 * @param prstatus ���̼�¼״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	
	/**�����˴���״̬��ȡ
	 * @return the ppstatus
	 */
	public String getPpstatus() {
		return ppstatus;
	}

	/**�����˴���״̬�趨
	 * @param ppstatus the ppstatus to set
	 */
	public void setPpstatus(String ppstatus) {
		this.ppstatus = ppstatus;
	}

	/**
	 * ���ܣ����̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���ܣ����̼�¼ID�趨
	 * @param prid ���̼�¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���ܣ����̼�¼�����Ŀ���ȡ��
	 * @return ���̼�¼�����Ŀ���
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * ���ܣ����̼�¼�����Ŀ����趨
	 * @param pcode ���̼�¼�����Ŀ���
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * ���ܣ����̼�¼�������û�����ȡ��
	 * @return ���̼�¼�������û�����
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * ���ܣ����̼�¼�������û������趨
	 * @param prusername ���̼�¼�������û�����
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * ���ܣ����̼�¼�����̶�ȡ��
	 * @return ���̼�¼�����̶�
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * ���ܣ����̼�¼�����̶��趨
	 * @param prurgency ���̼�¼�����̶�
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * ���ܣ����̼�¼����ʱ�䣨����ڣ�ȡ��
	 * @return ���̼�¼����ʱ�䣨����ڣ�
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ���ܣ����̼�¼����ʱ�䣨����ڣ��趨
	 * @param propentime ���̼�¼����ʱ�䣨����ڣ�
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ���ܣ����̼�¼����ʱ�䣨С���ڣ�ȡ��
	 * @return ���̼�¼����ʱ�䣨С���ڣ�
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * ���ܣ����̼�¼����ʱ�䣨С���ڣ��趨
	 * @param prclosetime ���̼�¼����ʱ�䣨С���ڣ�
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * ���ܣ����̼�¼��������IDȡ��
	 * @return ���̼�¼��������ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ���ܣ����̼�¼��������ID�趨
	 * @param prpdid ���̼�¼��������ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * һ�����̼�¼��������IDģ����ѯȡ��
	 *
	 * @return prpdid_like_or һ�����̼�¼��������IDģ����ѯ
	 */
	public String[] getPrpdid_like_or() {
		return prpdid_like_or;
	}

	/**
	 * һ�����̼�¼��������IDģ����ѯ�趨
	 *
	 * @param prpdid_like_or һ�����̼�¼��������IDģ����ѯ
	 */
	public void setPrpdid_like_or(String[] prpdid_like_or) {
		this.prpdid_like_or = prpdid_like_or;
	}

	/**
	 * ���ܣ����̼�¼�������û�IDȡ��
	 * @return ���̼�¼�������û�ID
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * ���ܣ����̼�¼�������û�ID�趨
	 * @param pruserid ���̼�¼�������û�ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * ���ܣ����̼�¼�����߽�ɫIDȡ��
	 * @return ���̼�¼�����߽�ɫID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * ���ܣ����̼�¼�����߽�ɫID�趨
	 * @param prroleid ���̼�¼�����߽�ɫID
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * ���ܣ����̼�¼�ƻ�ִ��ʱ��ȡ��
	 * @return ���̼�¼�ƻ�ִ��ʱ��
	 */
	public String getPrplantime() {
		return prplantime;
	}
	
	/**
	 * ���ܣ����̼�¼�ƻ�ִ��ʱ���趨
	 * @param prplantime ���̼�¼�ƻ�ִ��ʱ��
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}
	
	/**
	 * ���ܣ����̼�¼�ƻ�ִ��ʱ��ȡ��
	 * @return ���̼�¼�ƻ�ִ��ʱ��
	 */
	public String getPrplantime_like() {
		return prplantime_like;
	}

	/**
	 * ���ܣ����̼�¼�ƻ�ִ��ʱ���趨
	 * @param prplantime_like ���̼�¼�ƻ�ִ��ʱ��
	 */
	public void setPrplantime_like(String prplantime_like) {
		this.prplantime_like = prplantime_like;
	}

	/**
	 * ���ܣ����̼�¼�ƻ�ִ������ȡ��
	 * @return ���̼�¼�ƻ�ִ������
	 */
	public String getPrduration() {
		return prduration;
	}

	/**
	 * ���ܣ����̼�¼�ƻ�ִ�������趨
	 * @param prduration ���̼�¼�ƻ�ִ������
	 */
	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	
	/**
	 * ���ܣ����̼�¼����ʲ�IDȡ��
	 * @return ���̼�¼����ʲ�ID
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * ���ܣ����̼�¼����ʲ�ID�趨
	 * @param prassetid ���̼�¼����ʲ�ID
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	/**
	 * ���ܣ����̼�¼����ʲ�����ȡ��
	 * @return ���̼�¼����ʲ�����
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * ���ܣ����̼�¼����ʲ������趨
	 * @param prassetcategory ���̼�¼����ʲ�����
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * ���ܣ����̼�¼������ȡ��
	 * @return ���̼�¼������
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * ���ܣ����̼�¼�������趨
	 * @param prserialnum ���̼�¼������
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * ���ܣ����̼�¼״̬��״̬ȡ��
	 * @return ���̼�¼״̬��״̬
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}

	/**
	 * ���ܣ����̼�¼״̬��״̬�趨
	 * @param prsubstatus ���̼�¼״̬��״̬
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	
	/**
	 * ƽ̨����
	 * @return 
	 */
	public int getIsWork() {
		return isWork;
	}

	/**
	 * ƽ̨����
	 * @param isWork 
	 */
	public void setIsWork(int isWork) {
		this.isWork = isWork;
	}

	/**
	 * ƽ̨����
	 * @return 
	 */
	public String getSelectMode() {
		return selectMode;
	}

	/**
	 * ƽ̨����
	 * @param selectMode 
	 */
	public void setSelectMode(String selectMode) {
		this.selectMode = selectMode;
	}
	
	/**
	 * ƽ̨����
	 * @return 
	 */
	public List<Integer> getPridNotInList() {
		return pridNotInList;
	}

	/**
	 * ƽ̨����
	 * @param pridNotInList 
	 */
	public void setPridNotInList(List<Integer> pridNotInList) {
		this.pridNotInList = pridNotInList;
	}

	/**
	 * ƽ̨����
	 * @return 
	 */
	public List<String> getPrserialnumNotInList() {
		return prserialnumNotInList;
	}

	/**
	 * ƽ̨����
	 * @param prserialnumNotInList 
	 */
	public void setPrserialnumNotInList(List<String> prserialnumNotInList) {
		this.prserialnumNotInList = prserialnumNotInList;
	}

	/**
	 * ƽ̨����
	 * @return 
	 */
	public String getPrActive() {
		return prActive;
	}

	/**
	 * ƽ̨����
	 * @param prActive 
	 */
	public void setPrActive(String prActive) {
		this.prActive = prActive;
	}

	public String getPrdesc() {
		return prdesc;
	}

	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	public String[] getPrtypes() {
		return prtypes;
	}

	public void setPrtypes(String[] prtypes) {
		this.prtypes = prtypes;
	}


	/**
	 * ���ܣ����̼�¼����������������ȡ��
	 * @return ���̼�¼������������
	 */
	public String[] getPrTypeArray() {
		return prTypeArray;
	}

	/**
	 * ���ܣ����̼�¼��������������������
	 * @param prTypeArray
	 */
	public void setPrTypeArray(String[] prTypeArray) {
		this.prTypeArray = prTypeArray;
	}

	public String[] getPrStatusArray() {
		return prStatusArray;
	}

	public void setPrStatusArray(String[] prStatusArray) {
		this.prStatusArray = prStatusArray;
	}

	public String getPrimpact() {
		return primpact;
	}

	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}

	public String getPrpriority() {
		return prpriority;
	}

	public void setPrpriority(String prpriority) {
		this.prpriority = prpriority;
	}

	/**
	 * ����������ɫ��ʶ��ȡ
	 * @return ����������ɫ��ʶ
	 */
	public String getApproveflag() {
		return approveflag;
	}

	/**
	 * ����������ɫ��ʶ�趨
	 * @param approveflag ����������ɫ��ʶ
	 */
	public void setApproveflag(String approveflag) {
		this.approveflag = approveflag;
	}
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String[] getVarnames() {
		return varnames;
	}

	/**
	 * ���������趨
	 * @return ��������
	 */
	public String[] getVarvalues() {
		return varvalues;
	}

	/**
	 * ���̲����ˣ�like��ȡ��
	 *
	 * @return ppusername_like ���̲����ˣ�like��
	 */
	public String getPpusername_like() {
		return ppusername_like;
	}

	/**
	 * ���̲����ˣ�like���趨
	 *
	 * @param ppusername_like ���̲����ˣ�like��
	 */
	public void setPpusername_like(String ppusername_like) {
		this.ppusername_like = ppusername_like;
	}

	/**
	 * ���̲�����IDȡ��
	 * @return ppuserid ���̲�����ID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * ���̲�����ID�趨
	 * @param ppuserid ���̲�����ID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * ��ֵ����ȡ��
	 * @param varnames ��ֵ����
	 */
	public void setVarnames(String[] varnames) {
		this.varnames = varnames;
	}

	/**
	 * ��ֵ�����趨
	 * @param varvalues ��ֵ����
	 */
	public void setVarvalues(String[] varvalues) {
		this.varvalues = varvalues;
	}

	/**
	 * �����˻�����ȡ��
	 * @return �����˻�����
	 */
	public String getProrgid_like() {
		return prorgid_like;
	}

	/**
	 * �����˻������趨
	 * @param prorgid_like �����˻�����
	 */
	public void setProrgid_like(String prorgid_like) {
		this.prorgid_like = prorgid_like;
	}

	/**
	 * ��������ָ��״̬����(���ݸ�ʽ��prpdid_ppstatus)ȡ��
	 * @return ��������ָ��״̬����(���ݸ�ʽ��prpdid_ppstatus)
	 */
	public String[] getPrpdidAndPpstatus_or() {
		return prpdidAndPpstatus_or;
	}

	/**
	 * ��������ָ��״̬����(���ݸ�ʽ��prpdid_ppstatus)�趨
	 * @param prpdidAndPpstatus_or ��������ָ��״̬����(���ݸ�ʽ��prpdid_ppstatus)
	 */
	public void setPrpdidAndPpstatus_or(String[] prpdidAndPpstatus_or) {
		this.prpdidAndPpstatus_or = prpdidAndPpstatus_or;
	}

	/**
	 * ���̲�������������״̬ȡ��
	 * @return ���̲�������������״̬
	 */
    public String getPpstatus_eq() {
		return ppstatus_eq;
	}
    
    /**
     * ���̲�������������״̬�趨
     * @param ppstatus_eq ���̲�������������״̬
     */
	public void setPpstatus_eq(String ppstatus_eq) {
		this.ppstatus_eq = ppstatus_eq;
	}

	/**
	 * ���̲����˴���ʱ���Ƿ�Ϊ�ձ�ʶȡ��
	 * @return ���̲����˴���ʱ���Ƿ�Ϊ�ձ�ʶ
	 */
	public String getPpproctime_status_active() {
		return ppproctime_status_active;
	}

	/**
	 * ���̲����˴���ʱ���Ƿ�Ϊ�ձ�ʶ�趨
	 * @param ppproctime_status_active ���̲����˴���ʱ���Ƿ�Ϊ�ձ�ʶ
	 */
	public void setPpproctime_status_active(String ppproctime_status_active) {
		this.ppproctime_status_active = ppproctime_status_active;
	}

	/**
	 * ���̲�����ID(��״̬����)ȡ��
	 * @return ���̲�����ID(��״̬����)
	 */
	public String getPpuserid_status_eq() {
		return ppuserid_status_eq;
	}

	/**
	 * ���̲�����ID(��״̬����)�趨
	 * @param ppuserid_status_eq ���̲�����ID(��״̬����)
	 */
	public void setPpuserid_status_eq(String ppuserid_status_eq) {
		this.ppuserid_status_eq = ppuserid_status_eq;
	}

	/**
	 * ���̲����˽�ɫ����(��״̬����)ȡ��
	 * @return ���̲����˽�ɫ����(��״̬����)
	 */
	public String getRoletype_status_eq() {
		return roletype_status_eq;
	}

	/**
	 * ���̲����˽�ɫ����(��״̬����)�趨
	 * @param roletype_status_eq ���̲����˽�ɫ����(��״̬����)
	 */
	public void setRoletype_status_eq(String roletype_status_eq) {
		this.roletype_status_eq = roletype_status_eq;
	}

	/**
	 * ���̲�����������ɫ����(��״̬����)ȡ��
	 * @return ���̲�����������ɫ����(��״̬����)
	 */
	public String[] getPproleid_status_in() {
		return pproleid_status_in;
	}

	/**
	 * ���̲�����������ɫ����(��״̬����)�趨
	 * @param pproleid_status_in ���̲�����������ɫ����(��״̬����)
	 */
	public void setPproleid_status_in(String[] pproleid_status_in) {
		this.pproleid_status_in = pproleid_status_in;
	}

	/**
     * ���̼�¼������like����ȡ��
     * @return prserialnum_likeArr ���̼�¼������like����
     */
    public String[] getPrserialnum_likeArr() {
        return prserialnum_likeArr;
    }
    
    /**
     * ���̼�¼������like�����趨
     * @param prserialnum_likeArr ���̼�¼������like����
     */
    public void setPrserialnum_likeArr(String[] prserialnum_likeArr) {
        this.prserialnum_likeArr = prserialnum_likeArr;
    }

	/**
	 * ����״̬������ȡ��
	 * @return prstatus_ne ����״̬������
	 */
	public String getPrstatus_ne() {
		return prstatus_ne;
	}

	/**
	 * ����״̬�������趨
	 * @param prstatus_ne ����״̬������
	 */
	public void setPrstatus_ne(String prstatus_ne) {
		this.prstatus_ne = prstatus_ne;
	}

	/**
	 * ���̼�¼����ʱ�䣨like��ȡ��
	 * @return propentime_like ���̼�¼����ʱ�䣨like��
	 */
	public String getPropentime_like() {
		return propentime_like;
	}

	/**
	 * ���̼�¼����ʱ�䣨like���趨
	 * @param propentime_like ���̼�¼����ʱ�䣨like��
	 */
	public void setPropentime_like(String propentime_like) {
		this.propentime_like = propentime_like;
	}

	
	/**
	 * ���̼�¼�ر�ʱ��(like)ȡ��
	 * @return the prclosetime_like
	 */
	public String getPrclosetime_like() {
		return prclosetime_like;
	}

	/**
	 * ���̼�¼�ر�ʱ��(like)�趨
	 * @param prclosetime_like the prclosetime_like to set
	 */
	public void setPrclosetime_like(String prclosetime_like) {
		this.prclosetime_like = prclosetime_like;
	}

	/**
	 * ���������̱�ʶȡ��
	 * @return lctype ���������̱�ʶ
	 */
	public String getLctype() {
		return lctype;
	}

	/**
	 * ���������̱�ʶ�趨
	 * @param lctype ���������̱�ʶ
	 */
	public void setLctype(String lctype) {
		this.lctype = lctype;
	}

	/**
	 * �����˻�����ȡ��
	 * @return prorgid_in �����˻�����
	 */
	public String getProrgid_in() {
		return prorgid_in;
	}

	/**
	 * �����˻������趨
	 * @param prorgid_in
	 */
	public void setProrgid_in(String prorgid_in) {
		this.prorgid_in = prorgid_in;
	}

    /**
     * ������Դȡ��
     *
     * @return prassetname ������Դ
     */
    public String getPrassetname() {
        return prassetname;
    }

    /**
     * ������Դ�趨
     *
     * @param prassetname ������Դ
     */
    public void setPrassetname(String prassetname) {
        this.prassetname = prassetname;
    }
	
		/**
	 * ��ȡ����id��Χ
	 * @return
	 */
	public String getPrid_in() {
		return prid_in;
	}
	/**
	 * ��������id��Χ
	 * @param prid_in
	 */
	public void setPrid_in(String prid_in) {
		this.prid_in = prid_in;
	}

	/**
	 * �����˵�ȡ��
	 * @return pdactname �����˵�
	 */
	public String getPdactname() {
		return pdactname;
	}

	/**
	 * �����˵��趨
	 * @param pdactname �����˵�
	 */
	public void setPdactname(String pdactname) {
		this.pdactname = pdactname;
	}

	/**
	 * �����ɫID����ȡ��
	 * @return prroleid_in �����ɫID����
	 */
	public List<Integer> getPrroleid_in() {
		return prroleid_in;
	}

	/**
	 * �����ɫID�����趨
	 * @param prroleid_in �����ɫID����
	 */
	public void setPrroleid_in(List<Integer> prroleid_in) {
		this.prroleid_in = prroleid_in;
	}

	/**
	 * �����ɫID����ȡ��
	 * @return prroleid_not_in �����ɫID����
	 */
	public List<Integer> getPrroleid_not_in() {
		return prroleid_not_in;
	}

	/**
	 * �����ɫID�����趨
	 * @param prroleid_not_in �����ɫID����
	 */
	public void setPrroleid_not_in(List<Integer> prroleid_not_in) {
		this.prroleid_not_in = prroleid_not_in;
	}

	/**
	 * �����ؼ���ȡ��
	 * @return content �����ؼ���
	 */
	public String getContent() {
		return content;
	}

	/**
	 * �����ؼ����趨
	 * @param content �����ؼ���
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * ��������ȡ��
	 * @return the varnames_in
	 */
	public String[] getVarnames_in() {
		return varnames_in;
	}

	/**
	 * ���������趨
	 * @param varnames_in the ��������
	 */
	public void setVarnames_in(String[] varnames_in) {
		this.varnames_in = varnames_in;
	}

	/**
	 * ��ֵ����ȡ��
	 * @return the varvalues_in
	 */
	public String[] getVarvalues_in() {
		return varvalues_in;
	}

	/**
	 * ��ֵ�����趨
	 * @param varvalues_in the ��ֵ����
	 */
	public void setVarvalues_in(String[] varvalues_in) {
		this.varvalues_in = varvalues_in;
	}

	/**
	 * �Ƿ�Ϊ�澯�¼�1Ϊ��0Ϊ���ȡ��ȡ
	 * @return the alarm_Is
	 */
	public String getAlarm_Is() {
		return alarm_Is;
	}

	/**
	 * �Ƿ�Ϊ�澯�¼�1Ϊ��0Ϊ���ȡ�趨
	 * @param alarm_Is
	 */
	public void setAlarm_Is(String alarm_Is) {
		this.alarm_Is = alarm_Is;
	}

	/**
	 * ���Ƿ��Ѿ�ȷ��1Ϊ��0Ϊ�ǻ�ȡ
	 * @return the ppbacktime_isNull
	 */
	public String getPpbacktime_isNull() {
		return ppbacktime_isNull;
	}

	/**
	 * ���Ƿ��Ѿ�ȷ��1Ϊ��0Ϊ���趨
	 * @param ppbacktime_isNull
	 */
	public void setPpbacktime_isNull(String ppbacktime_isNull) {
		this.ppbacktime_isNull = ppbacktime_isNull;
	}

	/**
	 * @return the varmodes
	 */
	public String[] getVarmodes() {
		return varmodes;
	}

	/**
	 * @param varmodes the varmodes to set
	 */
	public void setVarmodes(String[] varmodes) {
		this.varmodes = varmodes;
	}

	/**
	 * @return the ppuserid_like
	 */
	public String getPpuserid_like() {
		return ppuserid_like;
	}

	/**
	 * @param ppuserid_like the ppuserid_like to set
	 */
	public void setPpuserid_like(String ppuserid_like) {
		this.ppuserid_like = ppuserid_like;
	}

	/**
	 * @return the pivarlabel
	 */
	public String getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * @param pivarlabel the pivarlabel to set
	 */
	public void setPivarlabel(String pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * @return the pivarValue
	 */
	public String getPivarValue() {
		return pivarValue;
	}

	/**
	 * @param pivarValue the pivarValue to set
	 */
	public void setPivarValue(String pivarValue) {
		this.pivarValue = pivarValue;
	}

	/**
	 * @return the pppivarValue
	 */
	public String getPppivarValue() {
		return pppivarValue;
	}

	/**
	 * @param pppivarValue the pppivarValue to set
	 */
	public void setPppivarValue(String pppivarValue) {
		this.pppivarValue = pppivarValue;
	}

	/**
	 * @return the csrtestmode
	 */
	public String getCsrtestmode() {
		return csrtestmode;
	}

	/**
	 * @param csrtestmode the csrtestmode to set
	 */
	public void setCsrtestmode(String csrtestmode) {
		this.csrtestmode = csrtestmode;
	}

	/**
	 * @return the leaderFlag
	 */
	public String getLeaderFlag() {
		return leaderFlag;
	}

	/**
	 * @param leaderFlag the leaderFlag to set
	 */
	public void setLeaderFlag(String leaderFlag) {
		this.leaderFlag = leaderFlag;
	}

	/**
	 * @return the orgID
	 */
	public String getOrgID() {
		return orgID;
	}

	/**
	 * @param orgID the orgID to set
	 */
	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}

	/**
	 * @return the pid
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/** ��������(����/Ӧ��) */
	public String getDwpType() {
		return dwpType;
	}

	/** ��������(����/Ӧ��) */
	public void setDwpType(String dwpType) {
		this.dwpType = dwpType;
	}

	/** ������ */
	public String getPrpdname() {
		return prpdname;
	}

	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}
}
