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
 * Description: ��������˸�������Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC0405Form extends BaseForm{

	/** ����ID */
	protected Integer prid;

	/**
	 * ����IDȡ��
	 * @return prid ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
}
