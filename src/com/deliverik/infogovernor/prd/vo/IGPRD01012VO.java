/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̵�������У�������Ϣvo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD01012VO extends BaseVO{

	/** ������Ϣ */
	protected List<String> errorMessages;

	/**
	 * ������Ϣȡ��
	 * @return errorMessages ������Ϣ
	 */
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	/**
	 * ������Ϣ�趨
	 * @param errorMessages ������Ϣ
	 */
	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}
}
