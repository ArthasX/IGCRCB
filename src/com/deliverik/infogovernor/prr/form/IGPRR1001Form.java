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
 * Description: ���̵���ģ�嵼��Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR1001Form extends BaseForm{

	/** ���̶���ID���� */
	protected String [] pdids;

	/**
	 * ���̶���ID����ȡ��
	 * @return pdids ���̶���ID����
	 */
	public String[] getPdids() {
		return pdids;
	}

	/**
	 * ���̶���ID�����趨
	 * @param pdids ���̶���ID����
	 */
	public void setPdids(String[] pdids) {
		this.pdids = pdids;
	}
}
