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
 * Description: ���̶����ѯForm
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD1001Form extends BaseForm{

	/** ���̶���ģ��ID */
	protected Integer ptid;

	/**
	 * ���̶���ģ��IDȡ��
	 * @return ptid ���̶���ģ��ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * ���̶���ģ��ID�趨
	 * @param ptid ���̶���ģ��ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}
}
