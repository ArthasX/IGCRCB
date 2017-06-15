/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.aut.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_��������_��ѯForm
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGAUT0105Form extends BaseForm{
	
	/**�������*/
	protected Integer prid;
	
	/**��������*/
	protected String prtitle;
	
	/**����״̬*/
	protected String prstatus;
	
	/**��������*/
	protected String prtype;
	
	/**��Ŀ���*/
	protected String pcode;
	
	/**����������*/
	protected String prusername;
	
	/**��ʼʱ��*/
	protected String propentime;
	
	/**����ʱ��*/
	protected String prclosetime;
	
	/**�����̶�*/
	protected String prurgency;
	
	/**�Ƿ���*/
	protected int isWork;
	
	/** ���̱�� */
	protected String prserialnum;
	
	/** ƽ̨���� */
	protected String prActive;
	
	/** ���̶������� */
	protected String prpdid;
	
	/** ���̼�¼�ƻ�ִ��ʱ�� */
	protected String prplantime_like;
	
	/** ������������ */
	protected String[] prTypeArray;
	
	/** ����״̬���� */
	protected String[] prStatusArray;
	
	/** ƽ̨���� */
	protected String userid_q;
	
	/** ɾ���ı����¼ID*/
	protected Integer delprid;
	
	/** �����ʶ */
	protected String isAdmin;
	
	/**����*/
	protected String prdesc;
	
	/**�����ʶ*/
	protected String order;
	
	/** �����ֶ� */
	protected String sing;
	
	protected String selectstatus;
	/**
	 * ������������
	 */
	protected String[] prtypes;
	
	/** 
	 * ���˹����ĵ�ǰ�û��Ƿ��������������ɫ 
	 * ����:1
	 */
	protected String approveflag;
	
	/** �˵�ID */
	protected String actname;
	
	/** �Ƿ��Ʋ�ѯҳ�� 0���� */
	protected String custom;
	
	/** �������� */
	protected String[] varnames;
	
	/** ��ֵ���� */
	protected String[] varvalues;
	
	/** ����ʾֵ���� */
	protected String[] varvalue;
	
	/** ������ */
	protected String prorgid_like;
	
	/** ��ѯ���ͱ�ʶ */
	protected String type ;

	/**
	 * �������ȡ��
	 * @return prid �������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ��������趨
	 * @param prid �������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��������ȡ��
	 * @return prtitle ��������
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���������趨
	 * @param prtitle ��������
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ����״̬ȡ��
	 * @return prstatus ����״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬�趨
	 * @param prstatus ����״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ��������ȡ��
	 * @return prtype ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���������趨
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ��Ŀ���ȡ��
	 * @return pcode ��Ŀ���
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * ��Ŀ����趨
	 * @param pcode ��Ŀ���
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * ����������ȡ��
	 * @return prusername ����������
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * �����������趨
	 * @param prusername ����������
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * ��ʼʱ��ȡ��
	 * @return propentime ��ʼʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ��ʼʱ���趨
	 * @param propentime ��ʼʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return prclosetime ����ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * ����ʱ���趨
	 * @param prclosetime ����ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * �����̶�ȡ��
	 * @return prurgency �����̶�
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * �����̶��趨
	 * @param prurgency �����̶�
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * �Ƿ���ȡ��
	 * @return isWork �Ƿ���
	 */
	public int getIsWork() {
		return isWork;
	}

	/**
	 * �Ƿ����趨
	 * @param isWork �Ƿ���
	 */
	public void setIsWork(int isWork) {
		this.isWork = isWork;
	}

	/**
	 * ���̱��ȡ��
	 * @return prserialnum ���̱��
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * ���̱���趨
	 * @param prserialnum ���̱��
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * ƽ̨����ȡ��
	 * @return prActive ƽ̨����
	 */
	public String getPrActive() {
		return prActive;
	}

	/**
	 * ƽ̨�����趨
	 * @param prActive ƽ̨����
	 */
	public void setPrActive(String prActive) {
		this.prActive = prActive;
	}

	/**
	 * ���̶�������ȡ��
	 * @return prpdid ���̶�������
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ���̶��������趨
	 * @param prpdid ���̶�������
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * ���̼�¼�ƻ�ִ��ʱ��ȡ��
	 * @return prplantime_like ���̼�¼�ƻ�ִ��ʱ��
	 */
	public String getPrplantime_like() {
		return prplantime_like;
	}

	/**
	 * ���̼�¼�ƻ�ִ��ʱ���趨
	 * @param prplantime_like ���̼�¼�ƻ�ִ��ʱ��
	 */
	public void setPrplantime_like(String prplantime_like) {
		this.prplantime_like = prplantime_like;
	}

	/**
	 * ������������ȡ��
	 * @return prTypeArray ������������
	 */
	public String[] getPrTypeArray() {
		return prTypeArray;
	}

	/**
	 * �������������趨
	 * @param prTypeArray ������������
	 */
	public void setPrTypeArray(String[] prTypeArray) {
		this.prTypeArray = prTypeArray;
	}

	/**
	 * ����״̬����ȡ��
	 * @return prStatusArray ����״̬����
	 */
	public String[] getPrStatusArray() {
		return prStatusArray;
	}

	/**
	 * ����״̬�����趨
	 * @param prStatusArray ����״̬����
	 */
	public void setPrStatusArray(String[] prStatusArray) {
		this.prStatusArray = prStatusArray;
	}

	/**
	 * ƽ̨����ȡ��
	 * @return userid_q ƽ̨����
	 */
	public String getUserid_q() {
		return userid_q;
	}

	/**
	 * ƽ̨�����趨
	 * @param userid_q ƽ̨����
	 */
	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	/**
	 * ɾ���ı����¼IDȡ��
	 * @return delprid ɾ���ı����¼ID
	 */
	public Integer getDelprid() {
		return delprid;
	}

	/**
	 * ɾ���ı����¼ID�趨
	 * @param delprid ɾ���ı����¼ID
	 */
	public void setDelprid(Integer delprid) {
		this.delprid = delprid;
	}

	/**
	 * �����ʶȡ��
	 * @return isAdmin �����ʶ
	 */
	public String getIsAdmin() {
		return isAdmin;
	}

	/**
	 * �����ʶ�趨
	 * @param isAdmin �����ʶ
	 */
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * ����ȡ��
	 * @return prdesc ����
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * �����趨
	 * @param prdesc ����
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * �����ʶȡ��
	 * @return order �����ʶ
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * �����ʶ�趨
	 * @param order �����ʶ
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * �����ֶ�ȡ��
	 * @return sing �����ֶ�
	 */
	public String getSing() {
		return sing;
	}

	/**
	 * �����ֶ��趨
	 * @param sing �����ֶ�
	 */
	public void setSing(String sing) {
		this.sing = sing;
	}

	/**
	 * selectstatusȡ��
	 * @return selectstatus selectstatus
	 */
	public String getSelectstatus() {
		return selectstatus;
	}

	/**
	 * selectstatus�趨
	 * @param selectstatus selectstatus
	 */
	public void setSelectstatus(String selectstatus) {
		this.selectstatus = selectstatus;
	}

	/**
	 * ������������ȡ��
	 * @return prtypes ������������
	 */
	public String[] getPrtypes() {
		return prtypes;
	}

	/**
	 * �������������趨
	 * @param prtypes ������������
	 */
	public void setPrtypes(String[] prtypes) {
		this.prtypes = prtypes;
	}

	/**
	 * ���˹����ĵ�ǰ�û��Ƿ��������������ɫ����:1ȡ��
	 * @return approveflag ���˹����ĵ�ǰ�û��Ƿ��������������ɫ����:1
	 */
	public String getApproveflag() {
		return approveflag;
	}

	/**
	 * ���˹����ĵ�ǰ�û��Ƿ��������������ɫ����:1�趨
	 * @param approveflag ���˹����ĵ�ǰ�û��Ƿ��������������ɫ����:1
	 */
	public void setApproveflag(String approveflag) {
		this.approveflag = approveflag;
	}

	/**
	 * �˵�IDȡ��
	 * @return actname �˵�ID
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * �˵�ID�趨
	 * @param actname �˵�ID
	 */
	public void setActname(String actname) {
		this.actname = actname;
	}

	/**
	 * �Ƿ��Ʋ�ѯҳ��0����ȡ��
	 * @return custom �Ƿ��Ʋ�ѯҳ��0����
	 */
	public String getCustom() {
		return custom;
	}

	/**
	 * �Ƿ��Ʋ�ѯҳ��0�����趨
	 * @param custom �Ƿ��Ʋ�ѯҳ��0����
	 */
	public void setCustom(String custom) {
		this.custom = custom;
	}

	/**
	 * ��������ȡ��
	 * @return varnames ��������
	 */
	public String[] getVarnames() {
		return varnames;
	}

	/**
	 * ���������趨
	 * @param varnames ��������
	 */
	public void setVarnames(String[] varnames) {
		this.varnames = varnames;
	}

	/**
	 * ��ֵ����ȡ��
	 * @return varvalues ��ֵ����
	 */
	public String[] getVarvalues() {
		return varvalues;
	}

	/**
	 * ��ֵ�����趨
	 * @param varvalues ��ֵ����
	 */
	public void setVarvalues(String[] varvalues) {
		this.varvalues = varvalues;
	}

	/**
	 * ����ʾֵ����ȡ��
	 * @return varvalue ����ʾֵ����
	 */
	public String[] getVarvalue() {
		return varvalue;
	}

	/**
	 * ����ʾֵ�����趨
	 * @param varvalue ����ʾֵ����
	 */
	public void setVarvalue(String[] varvalue) {
		this.varvalue = varvalue;
	}

	/**
	 * ������ȡ��
	 * @return prorgid_like ������
	 */
	public String getProrgid_like() {
		return prorgid_like;
	}

	/**
	 * �������趨
	 * @param prorgid_like ������
	 */
	public void setProrgid_like(String prorgid_like) {
		this.prorgid_like = prorgid_like;
	}

	/**
	 * ��ѯ���ͱ�ʶȡ��
	 * @return type ��ѯ���ͱ�ʶ
	 */
	public String getType() {
		return type;
	}

	/**
	 * ��ѯ���ͱ�ʶ�趨
	 * @param type ��ѯ���ͱ�ʶ
	 */
	public void setType(String type) {
		this.type = type;
	}
}
