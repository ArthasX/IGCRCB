/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: ����־�鿴Form
 * @Author  
 * @History 2010-9-17     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0106Form extends BaseForm {
	
	/** ������־ID */
	protected Integer rlid;

	
	/**
	 * ������־IDȡ��
	 * @return ������־ID
	 */
	public Integer getRlid() {
		return rlid;
	}

	/**
	 * ������־ID�趨
	 * @param rlid ������־ID
	 */
	public void setRlid(Integer rlid) {
		this.rlid = rlid;
	}

	
}
