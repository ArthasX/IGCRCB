/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Դ����ͳ��Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1401Form extends BaseForm{

	/** ��ʼʱ�� */
	protected String propentime_from;
	
	/** ����ʱ�� */
	protected String propentime_to;

	/**
	 * ��ʼʱ��ȡ��
	 * @return propentime_from ��ʼʱ��
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * ��ʼʱ���趨
	 * @param propentime_from ��ʼʱ��
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return propentime_to ����ʱ��
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * ����ʱ���趨
	 * @param propentime_to ����ʱ��
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}
}
