/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: ���̴���_��������ѯִ����Form
 * @Author  
 * @History 2013-02-28     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0121Form extends BaseForm {
	
	/** ����ID */
	protected int prid;

	/** ���̵�ǰ״̬ */
	protected String prstatus;
	
	/** ��ǰ�����˻�������� */
	protected String pporgid;
	
	/** ��Ӳ��������� */
	protected String[] ppuserids;
	
	/** ��Ӳ����˽�ɫ��Ȩid*/
	protected int[] urids;
	
	/**
	 * ����IDȡ��
	 *
	 * @return prid ����ID
	 */
	public int getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param prid ����ID
	 */
	public void setPrid(int prid) {
		this.prid = prid;
	}

	/**
	 * ���̵�ǰ״̬ȡ��
	 *
	 * @return prstatus ���̵�ǰ״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ���̵�ǰ״̬�趨
	 *
	 * @param prstatus ���̵�ǰ״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ��ǰ�����˻��������ȡ��
	 *
	 * @return pporgid ��ǰ�����˻��������
	 */
	public String getPporgid() {
		return pporgid;
	}

	/**
	 * ��ǰ�����˻���������趨
	 *
	 * @param pporgid ��ǰ�����˻��������
	 */
	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}

	/**
	 * ��Ӳ���������ȡ��
	 *
	 * @return ppuserids ��Ӳ���������
	 */
	
	public String[] getPpuserids() {
		return ppuserids;
	}

	/**
	 * ��Ӳ����������趨
	 *
	 * @param ppuserids ��Ӳ���������
	 */
	public void setPpuserids(String[] ppuserids) {
		this.ppuserids = ppuserids;
	}

	/**
	 * ��Ӳ����˽�ɫ��Ȩidȡ��
	 *
	 * @return urids ��Ӳ����˽�ɫ��Ȩid
	 */
	public int[] getUrids() {
		return urids;
	}

	/**
	 * ��Ӳ����˽�ɫ��Ȩid�趨
	 *
	 * @param urids ��Ӳ����˽�ɫ��Ȩid
	 */
	public void setUrids(int[] urids) {
		this.urids = urids;
	}
	
}
