/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.model.condition;

/**
  * ����: ��Ŀ��־�������������ӿ�
  * ��������: ��Ŀ��־�������������ӿ�
  * ������¼: 2012/04/11
  * �޸ļ�¼: 
  */
public interface ProjectLogBusinessSearchCond {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPlbid();

	/**
	 * ��ͬ�ܶ�ȡ��
	 *
	 * @return ��ͬ�ܶ�
	 */
	public Double getPlbplcsum();

	/**
	 * һ�ڸ�����ȡ��
	 *
	 * @return һ�ڸ�����
	 */
	public Double getPlbfirst();

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlbsecond();

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlbthird();

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlbfourth();

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlbfifth();

	/**
	 * ��Ӧ��Ŀidȡ��
	 *
	 * @return ��Ӧ��Ŀid
	 */
	public Integer getPlbpid();
	
	/**
	 * ��Ӧ��Ŀ��־idȡ��
	 *
	 * @return ��Ӧ��Ŀ��־id
	 */
	public Integer getPlbplid();

	/**
	 * �Ѹ����ܶ�ȡ��
	 *
	 * @return �Ѹ����ܶ�
	 */
	public Double getPlbsum();

	/**
	 * �Ѹ������ȡ��
	 *
	 * @return �Ѹ������
	 */
	public Double getPlbscale();

	/**
	 * δ�����ܶ�ȡ��
	 *
	 * @return δ�����ܶ�
	 */
	public Double getPlbnotsum();

	/**
	 * δ�������ȡ��
	 *
	 * @return δ�������
	 */
	public Double getPlbnotscale();


}