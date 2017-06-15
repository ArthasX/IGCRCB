/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�������Ϣ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0002Info extends BaseModel{

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId();

	/**
	 * �ƻ�����ȡ��
	 * @return planid �ƻ�����
	 */
	public Integer getPlanid();

	/**
	 * ���̱���ȡ��
	 * @return prtitle ���̱���
	 */
	public String getPrtitle();

	/**
	 * ��������ȡ��
	 * @return prdesc ��������
	 */
	public String getPrdesc();

	/**
	 * ��ϵ��ʽȡ��
	 * @return prinfo ��ϵ��ʽ
	 */
	public String getPrinfo();

	/**
	 * �����˽�ɫIDȡ��
	 * @return prroleid �����˽�ɫID
	 */
	public Integer getPrroleid();
}
