/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̲�ѯ��������ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IG111Info extends BaseModel{

	/**
	 * ����ȡ��
	 * @return qid ����
	 */
	public String getQid();

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid();

	/**
	 * ��ѯ��ʽȡ��
	 * @return qmode ��ѯ��ʽ
	 */
	public String getQmode();

	/**
	 * ��ѯ������ʶȡ��
	 * @return qtype ��ѯ������ʶ
	 */
	public String getQtype();

	/**
	 * ��ѯ������ʶȡ��
	 * @return qflag ��ѯ������ʶ
	 */
	public String getQflag();
	
	/**
	 * ��ʶ����ȡ��
	 * @return qname ��ʶ����
	 */
	public String getQname();
	
	/**
	 * ������ʵ��ȡ��
	 * @return pid ������ʵ��
	 */
	public IG007Info getPid();
}
