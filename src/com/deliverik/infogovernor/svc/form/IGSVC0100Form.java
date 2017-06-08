/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.svc.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�¼�����_��ѯForm
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSVC0100Form extends BaseForm implements IG500SearchCond {

	/** �¼���� */
	protected Integer prid;

	/** �¼����� */
	protected String prtitle;

	/** �¼�״̬ */
	protected String prstatus;

	/** �������� */
	protected String prtype;

	/** ��Ŀ��� */
	protected String pcode;

	/** ���������� */
	protected String prusername;

	/** ��ʼʱ�� */
	protected String propentime;

	/** ����ʱ�� */
	protected String prclosetime;

	/** �����̶� */
	protected String prurgency;

	/** ������ID */
	protected String pruserid;

	/** �Ƿ�ر� */
	public String prActive;

	/** �����߽�ɫID */
	public Integer prroleid;
	protected String prplantime_like;
	/**
	 * ��ȡ�¼����
	 * 
	 * @return �¼����
	 */

	protected String prserialnum;
	/**
	 * ������������
	 */
	protected String[] prTypeArray;
	// ��ѯ��
	/** ���� */
	protected String prdesc;

	/** �����ʶ */
	protected String order;

	protected String sing;

	/**
	 * ������������
	 */
	protected String[] prtypes;
	protected List<Integer> pridNotInList;// �ѽ���֪ʶ�������ID

	protected String userid_q;

	protected List<String> prserialnumNotInList;// �ѽ���֪ʶ������̹�����

	/** ���̶���ID */
	protected String prpdid;

	public List<String> getPrserialnumNotInList() {
		return prserialnumNotInList;
	}

	public void setPrserialnumNotInList(List<String> prserialnumNotInList) {
		this.prserialnumNotInList = prserialnumNotInList;
	}

	public List<Integer> getPridNotInList() {
		return pridNotInList;
	}

	public void setPridNotInList(List<Integer> pridNotInList) {
		this.pridNotInList = pridNotInList;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	public Integer getPrid() {
		if (prid != null && prid == 0) {
			return null;
		} else {
			return prid;
		}
	}

	/**
	 * �����¼����
	 * 
	 * @param prid
	 *            �¼����
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��ȡ�¼�����
	 * 
	 * @return �¼�����
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * �����¼�����
	 * 
	 * @param prtitle
	 *            �¼�����
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ��ȡ�¼�״̬
	 * 
	 * @return �¼�״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * �����¼�״̬
	 * 
	 * @param prstatus
	 *            �¼�״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @return ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ������������
	 * 
	 * @param prtype
	 *            ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ��ȡ��Ŀ���
	 * 
	 * @return ��Ŀ���
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * ������Ŀ���
	 * 
	 * @param pcode
	 *            ��Ŀ���
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * ��ȡ����������
	 * 
	 * @return ����������
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * ���÷���������
	 * 
	 * @param prusername
	 *            ����������
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * ��ȡ��ʼʱ��
	 * 
	 * @return ��ʼʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ���ÿ�ʼʱ��
	 * 
	 * @param propentime
	 *            ��ʼʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ��ȡ����ʱ��
	 * 
	 * @return ����ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * ���ý���ʱ��
	 * 
	 * @param prclosetime
	 *            ����ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * ��ȡ�����̶�
	 * 
	 * @return �����̶�
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * ���ý����̶�
	 * 
	 * @param prurgency
	 *            �����̶�
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	public String getPruserid() {
		return pruserid;
	}

	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	public String getPrActive() {
		return prActive;
	}

	public void setPrActive(String prActive) {
		this.prActive = prActive;
	}

	public Integer getPrroleid() {
		return prroleid;
	}

	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	public String getPrduration() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrplantime() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIsWork() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getSelectMode() {
		// TODO Auto-generated method stub
		return null;
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

	/**
	 * userid_q�趨
	 * 
	 * @param userid_q
	 *            userid_q
	 */
	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	public String getUserid_q() {
		// TODO Auto-generated method stub
		return this.userid_q;
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
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrimpact() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrpriority() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getApproveflag() {
		// TODO Auto-generated method stub
		return null;
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

	/**
	 * ���̶���IDȡ��
	 * 
	 * @return prpdid ���̶���ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ���̶���ID�趨
	 * 
	 * @param prpdid
	 *            ���̶���ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
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

	public String[] getVarmodes() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpuserid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getPrpdidAndPpstatus_or() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpstatus_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpproctime_status_active() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpuserid_status_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoletype_status_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getPproleid_status_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPivarlabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPivarValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPppivarValue() {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond#
	 * getAffiliatedPerson()
	 */
	public String getAffiliatedPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDwpType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrpdname() {
		return null;
	}
}
