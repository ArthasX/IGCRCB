/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * ����: �ʲ���ϵ���������ʵ��
  * ��������: �ʲ���ϵ���������ʵ��
  * ������¼: ����ȫ 2013/05/27
  * �޸ļ�¼: 
  */
public class SOC0152SearchCondImpl implements
		SOC0152SearchCond {
	/**ģ����*/
	protected String rlnCode_eq;

	/** ��ʼģ��ID */
	protected String fromModelEid_eq;

	/** ��ģ��ID */
	protected String toModelEid_eq;
	
	/**���ģ����*/
	protected List<String> rlnCode_in;

	/**��ϵ������*/
	protected String rlnType_eq;

	/**
	 * ģ����ȡ��
	 *
	 * @return rlnCode_eq ģ����
	 */
	
	public String getRlnCode_eq() {
		return rlnCode_eq;
	}

	/**
	 * ģ�����趨
	 *
	 * @param rlnCode_eq ģ����
	 */
	
	public void setRlnCode_eq(String rlnCode_eq) {
		this.rlnCode_eq = rlnCode_eq;
	}

	/**
	 * ��ʼģ��IDȡ��
	 *
	 * @return fromModelEid_eq ��ʼģ��ID
	 */
	
	public String getFromModelEid_eq() {
		return fromModelEid_eq;
	}

	/**
	 * ��ʼģ��ID�趨
	 *
	 * @param fromModelEid_eq ��ʼģ��ID
	 */
	
	public void setFromModelEid_eq(String fromModelEid_eq) {
		this.fromModelEid_eq = fromModelEid_eq;
	}

	/**
	 * ��ģ��IDȡ��
	 *
	 * @return toModelEid_eq ��ģ��ID
	 */
	
	public String getToModelEid_eq() {
		return toModelEid_eq;
	}

	/**
	 * ��ģ��ID�趨
	 *
	 * @param toModelEid_eq ��ģ��ID
	 */
	
	public void setToModelEid_eq(String toModelEid_eq) {
		this.toModelEid_eq = toModelEid_eq;
	}

	/**
	 * ���ģ����ȡ��
	 *
	 * @return rlnCode_in ���ģ����
	 */
	
	public List<String> getRlnCode_in() {
		return rlnCode_in;
	}

	/**
	 * ���ģ�����趨
	 *
	 * @param rlnCode_in ���ģ����
	 */
	
	public void setRlnCode_in(List<String> rlnCode_in) {
		this.rlnCode_in = rlnCode_in;
	}

	/**
	 * ��ϵ������ȡ��
	 *
	 * @return rlnType_eq ��ϵ������
	 */
	
	public String getRlnType_eq() {
		return rlnType_eq;
	}

	/**
	 * ��ϵ�������趨
	 *
	 * @param rlnType_eq ��ϵ������
	 */
	
	public void setRlnType_eq(String rlnType_eq) {
		this.rlnType_eq = rlnType_eq;
	}


	

}