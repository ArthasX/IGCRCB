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
 * Description: ��ѯ��ʾ�ж���ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IG110Info extends BaseModel{

	/**
	 * ����ȡ��
	 * @return sid ����
	 */
	public String getSid();

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid();

	/**
	 * ��ʾ������ȡ��
	 * @return stype ��ʾ������
	 */
	public String getStype();

	/**
	 * ��ʾ�б�ʶȡ��
	 * @return sflag ��ʾ�б�ʶ
	 */
	public String getSflag();
	
	/**
	 * ��ʶ����ȡ��
	 * @return sname ��ʶ����
	 */
	public String getSname();
	
	/**
	 * ���ȡ��
	 * @return width ���
	 */
	public Integer getWidth();

}
