/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����������Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC0403Form extends BaseForm{

	/** ����ID���� */
	protected Integer[] prid;
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ����״̬�� */
	protected String prstatus;
	
	/** ��ť���� */
	protected String buttonName;
	
	/** ��ť��ʶ */
	protected String buttonCode;
	
	/** �����ɲ�������Ϣ���� */
	protected String[] participants;

	protected Integer[] prids;
	/**
	 * ����ID����ȡ��
	 * @return prid ����ID����
	 */
	public Integer[] getPrid() {
		return prid;
	}

	/**
	 * ����ID�����趨
	 * @param prid ����ID����
	 */
	public void setPrid(Integer[] prid) {
		this.prid = prid;
	}

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����״̬��ȡ��
	 * @return prstatus ����״̬��
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬���趨
	 * @param prstatus ����״̬��
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ��ť����ȡ��
	 * @return buttonName ��ť����
	 */
	public String getButtonName() {
		return buttonName;
	}

	/**
	 * ��ť�����趨
	 * @param buttonName ��ť����
	 */
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	/**
	 * ��ť��ʶȡ��
	 * @return buttonCode ��ť��ʶ
	 */
	public String getButtonCode() {
		return buttonCode;
	}

	/**
	 * ��ť��ʶ�趨
	 * @param buttonCode ��ť��ʶ
	 */
	public void setButtonCode(String buttonCode) {
		this.buttonCode = buttonCode;
	}

	/**
	 * �����ɲ�������Ϣ����ȡ��
	 * @return participants �����ɲ�������Ϣ����
	 */
	public String[] getParticipants() {
		return participants;
	}

	/**
	 * �����ɲ�������Ϣ�����趨
	 * @param participants �����ɲ�������Ϣ����
	 */
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}

	/**
	 * @return the prids
	 */
	public Integer[] getPrids() {
		return prids;
	}

	/**
	 * @param prids the prids to set
	 */
	public void setPrids(Integer[] prids) {
		this.prids = prids;
	}
	
	
}
