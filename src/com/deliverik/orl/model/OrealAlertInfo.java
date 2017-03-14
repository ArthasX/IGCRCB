/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.orl.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ������ŷ���Ÿ澯��ʵ��ӿ�
 * ����������ŷ���Ÿ澯��ʵ��ӿ�
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
public interface OrealAlertInfo extends BaseModel{
	/**
	 * �澯IDȡ��
	 * @return id �澯ID
	 */
	public Integer getId();
	/**
	 * IPȡ��
	 * @return ip IP
	 */
	public String getIp();
	/**
	 * ƽ̨IDȡ��
	 * @return platform_id ƽ̨ID
	 */
	public Integer getPlatform_id();
	/**
	 * �澯����ȡ��
	 * @return defname �澯����
	 */
	public String getDefname();
	/**
	 * �澯����ʱ��ȡ��
	 * @return ctime �澯����ʱ��
	 */
	public Long getCtime();
	/**
	 * �澯ָ����ֵȡ��
	 * @return value �澯ָ����ֵ
	 */
	public String getValue();
	/**
	 * �Ƿ��޸�(��ʶ)ȡ��
	 * @return fixed �Ƿ��޸�(��ʶ)
	 */
	public Integer getFixed() ;
	/**
	 * �澯���ȼ�(��ʶ)ȡ��
	 * @return priority �澯���ȼ�(��ʶ)
	 */
	public Integer getPriority();
	/**
	 * ҵ��ϵͳIDȡ��
	 * @return bid ҵ��ϵͳID
	 */
	public Integer getBid() ;
	/**
	 * ҵ��ϵͳ����ȡ��
	 * @return bname ҵ��ϵͳ����
	 */
	public String getBname() ;
	
	/**
	 * Tools������
	 */
	/**
	 * Long����ʱ��ת��Ϊyyyy/mm/dd hh:mi��ʽ
	 */
	public String getLong2SDF() ;
}
