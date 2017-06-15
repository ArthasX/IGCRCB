/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̷���form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0103Form extends BaseForm{

	/** �������� */
	protected Integer prid;
	
	/** ���̶������� */
	protected String pdid;
	
	/** ״̬�ڵ����� */
	protected String psdid;
	
	/** ������ť��ʶ */
	protected String action;
	
	/** ������ɫ */
	protected Integer prroleid;
	
	/** ������ID����ʽ��roleid_userid��*/
	protected String[] participants;
	
	/** ������ID����ʽ��roleid_��*/
	protected String[] participants_;
	
	/** ���첿�� */
	protected String[] ppsupers;
	
	/** ��ݷ����ʶ */
	protected String isServiceStart;

	/**
	 * ��������ȡ��
	 * @return prid ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���̶�������ȡ��
	 * @return pdid ���̶�������
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶��������趨
	 * @param pdid ���̶�������
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ״̬�ڵ�����ȡ��
	 * @return psdid ״̬�ڵ�����
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬�ڵ������趨
	 * @param psdid ״̬�ڵ�����
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ������ť��ʶȡ��
	 * @return action ������ť��ʶ
	 */
	public String getAction() {
		return action;
	}

	/**
	 * ������ť��ʶ�趨
	 * @param action ������ť��ʶ
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * ������ɫȡ��
	 * @return prroleid ������ɫ
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * ������ɫ�趨
	 * @param prroleid ������ɫ
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * ������ID����ʽ��roleid_userid��ȡ��
	 * @return participants ������ID����ʽ��roleid_userid��
	 */
	public String[] getParticipants() {
		return participants;
	}

	/**
	 * ������ID����ʽ��roleid_userid���趨
	 * @param participants ������ID����ʽ��roleid_userid��
	 */
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}

	/**
	 * ������ID����ʽ��roleid_��ȡ��
	 * @return participants_ ������ID����ʽ��roleid_��
	 */
	public String[] getParticipants_() {
		return participants_;
	}

	/**
	 * ������ID����ʽ��roleid_���趨
	 * @param participants_ ������ID����ʽ��roleid_��
	 */
	public void setParticipants_(String[] participants_) {
		this.participants_ = participants_;
	}

	/**
	 * ���첿��ȡ��
	 * @return ppsupers ���첿��
	 */
	public String[] getPpsupers() {
		return ppsupers;
	}

	/**
	 * ���첿���趨
	 * @param ppsupers ���첿��
	 */
	public void setPpsupers(String[] ppsupers) {
		this.ppsupers = ppsupers;
	}

	/**
	 * ��ݷ����ʶȡ��
	 * @return isServiceStart ��ݷ����ʶ
	 */
	public String getIsServiceStart() {
		return isServiceStart;
	}

	/**
	 * ��ݷ����ʶ�趨
	 * @param isServiceStart ��ݷ����ʶ
	 */
	public void setIsServiceStart(String isServiceStart) {
		this.isServiceStart = isServiceStart;
	}
}
