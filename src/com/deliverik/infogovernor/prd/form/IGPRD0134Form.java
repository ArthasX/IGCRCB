/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������֧�ֻ���ѡ��form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD0134Form extends BaseForm{

	/** ����ID */
	protected String pdid;
	
	/** ����״̬ID */
	protected String psdid;
	
	/** �����뼯�� */
	protected String [] orgids;
	
	/** �û�id���� */
	protected String [] ppuserids;
	
	/** ������������Ϣ�������� */
	protected String [] ppdids;
	
	/**����ʽ��0-ɾ����1-����*/
	protected String mode;
	
	/** �鿴ģʽ 0���£��ɱ༭��1����ʷ��ֻ�鿴 */
	protected String viewhistory;

	/** �ϼ�״̬ID */
	protected String ppsdid;

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ����ID�趨
	 * @param pdid ����ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ״̬IDȡ��
	 * @return ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}
	
	/**
	 * ״̬ID�趨
	 * @param psdid ״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �����뼯��ȡ��
	 * @return �����뼯��
	 */
	public String[] getOrgids() {
		return orgids;
	}

	/**
	 * �����뼯���趨
	 * @param orgids �����뼯��
	 */
	public void setOrgids(String[] orgids) {
		this.orgids = orgids;
	}

	/**
	 * �û�id����ȡ��
	 * @return �û�id����
	 */
	public String[] getPpuserids() {
		return ppuserids;
	}

	/**
	 * �û�id�����趨
	 * @param ppuserids �û�id����
	 */
	public void setPpuserids(String[] ppuserids) {
		this.ppuserids = ppuserids;
	}

	/**
	 * ������������Ϣ��������ȡ��
	 * @return ������������Ϣ��������
	 */
	public String[] getPpdids() {
		return ppdids;
	}

	/**
	 * ������������Ϣ���������趨
	 * @param ppdids ������������Ϣ��������
	 */
	public void setPpdids(String[] ppdids) {
		this.ppdids = ppdids;
	}

	/**
	 * ����ʽȡ��
	 * @return ����ʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ����ʽ�趨
	 * @param mode ����ʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * �鿴ģʽȡ��
	 * @return viewHistory �鿴ģʽ
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * �鿴ģʽ�趨
	 * @param viewHistory  �鿴ģʽ
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}

	/**
	 * �ϼ�״̬IDȡ��
	 * @return �ϼ�״̬ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * �ϼ�״̬ID�趨
	 * @param ppsdid �ϼ�״̬ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}
	
}
