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
 * Description: ���ʹ�����չʾForm
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1202Form extends BaseForm{

	/** vCenter����ID */
	protected Integer vcid;

	/**
	 * vCenter����IDȡ��
	 * @return vcid vCenter����ID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCenter����ID�趨
	 * @param vcid vCenter����ID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}
}
