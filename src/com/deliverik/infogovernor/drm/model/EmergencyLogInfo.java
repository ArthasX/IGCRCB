/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ������Ӧ����־��Ϣ��ӿ�
 * ����������Ӧ����־��Ϣ��ӿ�
 * ������¼��2014/05/19
 * �޸ļ�¼��
 */
public interface EmergencyLogInfo extends BaseModel {
	/**
	 * ����IDȡ��
	 * @return elid
	 */
	public Integer getElid();
    /**
	 * Ӧ����������IDȡ��
	 * @return elprid
	 */
	public Integer getElprid();
	/**
	 * ��־��Ϣ����ȡ��
	 * (ĿǰProcessLog��NoticeLog����)
	 * @return ellitype
	 */
	public String getEllitype();
	/**
	 * ��־��Ϣ����ʱ��ȡ��
	 * @return ellidtime
	 */
	public String getEllidtime();
	/**
	 * ��־��Ϣ�������û�IDȡ��
	 * @return eluserid
	 */
	public String getEluserid();
	/**
	 * ��־��Ϣ�������û�����ȡ��
	 * @return elusername
	 */
	public String getElusername();
	/**
	 * ��־��Ϣ����ȡ��
	 * @return elliinfo
	 */
	public String getElliinfo();
	
	/**
	 * ��־״̬IDȡ��
	 * @return elliinfo
	 */
	public String getElpsdid();
	
	/**
	 * ��־״̬����ȡ��
	 * @return elliinfo
	 */
	public String getElpsdname();
	/**  
	 * ��ȡoperate  
	 * @return operate 
	 */
	public String getOperate() ;
}