/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��Ŀ��־��ͬ��ӿ�
  * ��������: ��Ŀ��־��ͬ��ӿ�
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
public interface ProjectLogContractInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPlcid();

	/**
	 * ��ͬ���ȡ��
	 *
	 * @return ��ͬ���
	 */
	public Double getPlcsum();

	/**
	 * ��ͬ��������ȡ��
	 *
	 * @return ��ͬ��������
	 */
	public String getPlcsumterm();

	/**
	 * һ�ڸ�����ȡ��
	 *
	 * @return һ�ڸ�����
	 */
	public Double getPlcfirst();

	/**
	 * һ�ڸ�������ȡ��
	 *
	 * @return һ�ڸ�������
	 */
	public String getPlcfirstterm();

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlcsecond();

	/**
	 * ���ڸ�������ȡ��
	 *
	 * @return ���ڸ�������
	 */
	public String getPlcsecondterm();

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlcthird();

	/**
	 * ���ڸ�������ȡ��
	 *
	 * @return ���ڸ�������
	 */
	public String getPlcthirdterm();

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlcfourth();

	/**
	 * ���ڸ�������ȡ��
	 *
	 * @return ���ڸ�������
	 */
	public String getPlcfourthterm();

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlcfifth();

	/**
	 * ���ڸ�������ȡ��
	 *
	 * @return ���ڸ�������
	 */
	public String getPlcfifthterm();
	
	/**
	 * ��Ӧ��Ŀidȡ��
	 *
	 * @return ��Ӧ��Ŀid
	 */
	public Integer getPlcpid();

	/**
	 * ��Ӧ��Ŀ��־idȡ��
	 *
	 * @return ��Ӧ��Ŀ��־id
	 */
	public Integer getPlcplid();
	
	/**
	 * ��Ŀ �ʱ��� ����ȡ��
	 *
	 * @return ��Ŀ �ʱ��� ����
	 */
	public Double getBzdevelop();
	
	/**
	 * ��Ŀ �ʱ��� Ӳ��ȡ��
	 *
	 * @return ��Ŀ �ʱ��� Ӳ��
	 */
	public Double getBzhardware();
	
	/**
	 * ��Ŀ �ʱ��� ���ȡ��
	 *
	 * @return ��Ŀ �ʱ��� ���
	 */
	public Double getBzsoftware();
	
	/**
	 * ��Ŀ �ʱ��� ����ȡ��
	 *
	 * @return ��Ŀ �ʱ��� ����
	 */
	public Double getBzproject();

	/**
	 * ��Ŀ �ʱ��� ����ȡ��
	 *
	 * @return ��Ŀ �ʱ��� ����
	 */
	public Double getBzelse();
	
	/**
	 * ��Ŀ �ɱ��� ʵʩȡ��
	 *
	 * @return ��Ŀ �ɱ��� ʵʩ
	 */
	public Double getBcimplement();

	/**
	 * ��Ŀ �ɱ��� ����ȡ��
	 *
	 * @return ��Ŀ �ɱ��� ����
	 */
	public Double getBcelse();
	
	/**
	 * ��ͬ���ȡ��
	 * @return ��ͬ���
	 */
	public String getPlcnumber();

}