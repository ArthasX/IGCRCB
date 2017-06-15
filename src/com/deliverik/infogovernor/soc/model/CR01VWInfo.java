/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ɼ�������Ϣ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface CR01VWInfo extends BaseModel{

	/**
	 * ������ʶȡ��
	 * @return ������ʶ
	 */
	public String getHost();

	/**
	 * �ɼ�ʱ��ȡ��
	 * @return �ɼ�ʱ��
	 */
	public String getCollecttime();

	/**
	 * �ɼ�����ȡ��
	 * @return �ɼ�����
	 */
	public String getCommand();

	/**
	 * �ɼ����˳��ȡ��
	 * @return �ɼ����˳��
	 */
	public Integer getCdataorder();

	/**
	 * �ɼ����ȡ��
	 * @return �ɼ����
	 */
	public String getCdata();

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getInserttime();
	
	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getCategory();

	/**
	 * �ؼ���ȡ��
	 * @return �ؼ���
	 */
	public String getKeys();
	
	/**
	 * ƽ̨IP���
	 * @return
	 */
	public String getIp();
	
	/**
	 * server��ȡ��
	 * @return
	 */
	public String getServername();
	
	/**
	 * server����ȡ��
	 * @return
	 */
	public String getServertype();
}
