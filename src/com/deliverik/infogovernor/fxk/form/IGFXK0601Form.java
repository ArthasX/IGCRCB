/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������Ĺ����ʲ���Ϣȡ��Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK0601Form extends BaseForm{

	/** �ʲ�ID */
	protected Integer eiid;

	/**
	 * �ʲ�IDȡ��
	 * @return eiid �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
}
