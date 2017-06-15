/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model;

import java.io.Serializable;

/**
 * ����:�걨��ͼ
 * �����������걨��ͼ
 * �����ˣ�����͢
 * ������¼�� 2013-07-29
 * �޸ļ�¼��
 */
public interface AnnualReportVWInfo extends Serializable{

	public Integer getPrid();
	
	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getInstanceID();
	
	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPrtype();
	
	/**
	 * ���ʶȡ��
	 *
	 * @return ���ʶ
	 */
	public String getKey();
	
	/**
	 * �����ʱ��ȡ��
	 *
	 * @return �����ʱ��
	 */
	public String getInittime();
	
	/**
	 * �����ʱ��ȡ��
	 *
	 * @return �����ʱ��
	 */
	public String getEndtime();
	
	/**
	 * �����ʱ��ȡ��
	 *
	 * @return �����ʱ��
	 */
	public String getLimittime();
	
	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getRemark();
	
	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getStatus();
	
	/**
	 * ������ID
	 * 
	 * @return ������ID
	 */
	public String getUserid();
	
	/**
	 * ����������
	 * @return ����������
	 */
	public String getUsername();
	
	/**
	 * �걨˵��
	 * @return �걨˵��
	 */
	public String getReportdesc() ;
	
	/**
	 * ������
	 * @return ������
	 */
	public String getPrtitle();
	
	/**
	 * ����״̬��ȡ��
	 *
	 * @return psdname ����״̬��
	 */
	public String getPsdname();
	
	/**
	 * ��ǰ״̬ȡ��
	 *
	 * @return prstatus ��ǰ״̬
	 */
	public String getPrstatus();
	
	/**
	 * �Ƿ��Ϳձ��ʶȡ��
	 *
	 * @return flag �Ƿ��Ϳձ��ʶ
	 */
	public String getFlag();
	
	/**
	 * �ϱ��������ȡ��
	 *
	 * @return year �ϱ��������
	 */
	public String getYear();
	
	/**
	 * �ϱ�������ȡ��
	 *
	 * @return quarter �ϱ�������
	 */
	public String getQuarter();
}
