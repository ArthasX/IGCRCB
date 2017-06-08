/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.wkm.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;

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

public class IGWKM0102Form extends BaseForm implements IG500SearchCond{
	
	public String getDwpType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrpdname() {
		return null;
	}

	private static final long serialVersionUID = 1L;

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
	/**
	 * ������������
	 */
	protected String[] prTypeArray;
	/**
	 * ����״̬����
	 */
	protected String[] prStatusArray;
	/**����*/
	protected String prdesc;
	
	/**�����ʶ*/
	protected String order;
	
	protected String sing;
	
	/**
	 * ������������
	 */
	protected String[] prtypes;
	
	
	protected String prserialnum;
	protected String prplantime_like;
	
	protected String userid_q;
	
	/** 
	 * ���˹����ĵ�ǰ�û��Ƿ��������������ɫ 
	 * ����:1
	 */
	protected String approveflag;
	
	/** ���̲�����ID��like��*/
	protected String ppuserid_like;
	
	/** ���̲�������������״̬*/
	protected String ppstatus_eq;
	
	/** ���̲�����ID(��״̬����)*/
	protected String ppuserid_status_eq;
	
	/** ���̲����˽�ɫ����(��״̬����)*/
	protected String roletype_status_eq;
	
	/** ���̲�����������ɫ����(��״̬����)*/
	protected String[] pproleid_status_in;
	
	/**
	 * �������ı�ʾ(Y����ɹ�)ȡ��
	 */
	public String pivarlabel;
	
	/**
	 * �¼�����
	 */
	public String pivarValue;
	
	/**
	 * �������
	 */
	public String pppivarValue;
		
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
	 * ���̲�����ID��like��ȡ��
	 * @return ���̲�����ID��like��
	 */
	public String getPpuserid_like() {
		return ppuserid_like;
	}

	/**
	 * ���̲�����ID��like���趨
	 * @param ppuserid_like ���̲�����ID��like��
	 */
	public void setPpuserid_like(String ppuserid_like) {
		this.ppuserid_like = ppuserid_like;
	}

	public String getUserid_q() {
		return userid_q;
	}

	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}
	
	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}
	/**
	 * ��ȡ�������
	 * @return �������
	 */
	public Integer getPrid() {
		if(prid!=null && prid==0){
			return null;
		} else {
			return prid;
		}
	}

	/**
	 * ���ù������
	 * @param prid �������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}


	/**
	 * ��ȡ��������
	 * @return ��������
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���ù�������
	 * @param prtitle ��������
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ��ȡ����״̬
	 * @return ����״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ���ù���״̬
	 * @param prstatus ����״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ��ȡ��������
	 * @return ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ������������
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ��ȡ��Ŀ���
	 * @return ��Ŀ���
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * ������Ŀ���
	 * @param pcode ��Ŀ���
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * ��ȡ����������
	 * @return ����������
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * ���÷���������
	 * @param prusername ����������
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * ��ȡ��ʼʱ��
	 * @return ��ʼʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ���ÿ�ʼʱ��
	 * @param propentime ��ʼʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ��ȡ����ʱ��
	 * @return ����ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * ���ý���ʱ��
	 * @param prclosetime ����ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * ��ȡ�����̶�
	 * @return �����̶�
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * ���ý����̶�
	 * @param prurgency �����̶�
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	public String getPrActive() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPrroleid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPruserid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrduration() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrplantime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSelectMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIsWork() {
		return isWork;
	}

	public void setIsWork(int isWork) {
		this.isWork = isWork;
	}

	public String getPrassetcategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPrassetid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrsubstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getPridNotInList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getPrserialnumNotInList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrpdid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrplantime_like() {
		return prplantime_like;
	}

	public void setPrplantime_like(String prplantime_like) {
		this.prplantime_like = prplantime_like;
	}

	public String[] getPrTypeArray() {
		return prTypeArray;
	}

	public void setPrTypeArray(String[] prTypeArray) {
		this.prTypeArray = prTypeArray;
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

	public String getSing() {
		return sing;
	}

	public void setSing(String sing) {
		this.sing = sing;
	}

	public String[] getPrtypes() {
		return prtypes;
	}

	public void setPrtypes(String[] prtypes) {
		this.prtypes = prtypes;
	}

	public String[] getPrStatusArray() {
		return prStatusArray;
	}

	public void setPrStatusArray(String[] prStatusArray) {
		this.prStatusArray = prStatusArray;
	}

	public String getPrimpact() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrpriority() {
		// TODO Auto-generated method stub
		return null;
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

	public String getPivarlabel() {
		return pivarlabel;
	}

	public void setPivarlabel(String pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	public String[] getPrpdid_like_or() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getVarnames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getVarvalues() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpusername_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProrgid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getPrserialnum_likeArr() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrstatus_ne() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPropentime_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLctype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProrgid_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrassetname() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrid_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPdactname() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getPrroleid_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getPrroleid_not_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpuserid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrclosetime_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getVarvalues_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getVarnames_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAlarm_Is() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpbacktime_isNull() {
		// TODO Auto-generated method stub
		return null;
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

	public String[] getVarmodes() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getPrpdidAndPpstatus_or() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpproctime_status_active() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLeaderFlag() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOrgID() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFlag() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond#getAffiliatedPerson()
	 */
	public String getAffiliatedPerson() {
		// TODO Auto-generated method stub
		return null;
	}

}
