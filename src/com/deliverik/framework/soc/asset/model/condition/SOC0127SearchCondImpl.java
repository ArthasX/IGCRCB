/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: ����������ϵ��ͼ��������ʵ��
  * ��������: ����������ϵ��ͼ��������ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class SOC0127SearchCondImpl implements
	SOC0127SearchCond {
	
	/** Դ�ʲ���汾 */
	protected Integer brparversion;

	/** Ŀ���ʲ���汾 */
	protected Integer brcldversion;

	/** �ʲ����������ڵ�ʵ���ʶ */
	protected Integer eirootmark;
	
	/**
	 * Ŀ���ʲ���汾ȡ��
	 *
	 * @return Ŀ���ʲ���汾
	 */
	public Integer getBrcldversion() {
		return brcldversion;
	}

	/**
	 * Ŀ���ʲ���汾�趨
	 *
	 * @param brcldversionĿ���ʲ���汾
	 */
	public void setBrcldversion(Integer brcldversion) {
		this.brcldversion = brcldversion;
	}

	/**
	 * Դ�ʲ���汾ȡ��
	 *
	 * @return Դ�ʲ���汾
	 */
	public Integer getBrparversion() {
		return brparversion;
	}

	/**
	 * Դ�ʲ���汾�趨
	 *
	 * @param brparversionԴ�ʲ���汾
	 */
	public void setBrparversion(Integer brparversion) {
		this.brparversion = brparversion;
	}

	/**
	 * �ʲ����������ڵ�ʵ���ʶȡ��
	 * @return �ʲ����������ڵ�ʵ���ʶ
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}
	
	/**
	 * �ʲ����������ڵ�ʵ���ʶ�趨
	 *
	 * @param eirootmark �ʲ����������ڵ�ʵ���ʶ
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}
}