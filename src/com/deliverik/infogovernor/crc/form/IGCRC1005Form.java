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
 * Description: ���򿪷�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1005Form extends BaseForm{

	/** ������ID */
	protected Integer parprid;

	/**
	 * ������IDȡ��
	 * @return parprid ������ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * ������ID�趨
	 * @param parprid ������ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}
}
