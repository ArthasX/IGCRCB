/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.User;

/**
 * 
 * ���񹤵���־ʵ��ӿ�
 * 
 */

public interface IG941Info extends BaseModel {
	/**
	 * ���񹤵���־IDȡ��
	 * 
	 * @return ���񹤵���־ID
	 */
	public Integer getSflid();
	
	/**
	 * ���񹤵�IDȡ��
	 * 
	 * @return ���񹤵�ID
	 */
	public Integer getSfid();
	
	/**
	 * ���񹤵������¼ȡ��
	 * 
	 * @return ���񹤵������¼
	 */
	public String getSfldesc();
	
	/**
	 * ���񹤵�������IDȡ��
	 * 
	 * @return ���񹤵�������ID
	 */
	public String getSfluserid();
	
	/**
	 * ���񹤵���־�Ǽ�ʱ��ȡ��
	 * 
	 * @return ���񹤵���־�Ǽ�ʱ��
	 */
	public String getSflinstime();
	
	/**
	 * ���񹤵�������ȡ��
	 * @return ���񹤵�������
	 */
	public User getSfluser();
	
	/**
	 * ���񹤵�����KEYȡ��
	 * @return ���񹤵�����KEY
	 */
	public String getSflattkey();
}