/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ɼ������ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface CR01SearchCond {

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getTablename();

	/**
	 * �豸��ʶȡ��
	 * @return �豸��ʶ
	 */
	public String getHost() ;
	
	/**
	 * �ɼ�ʱ��ȡ��
	 *
	 * @return �ɼ�ʱ��
	 */
	public String getCollecttime();
	
	/**
	 * �ɼ�����ȡ��
	 *
	 * @return command �ɼ�����
	 */
	
	public String getCommand();
	
	public String getIp();
	
	public String getServername();
	
	public String getServertype();
}
