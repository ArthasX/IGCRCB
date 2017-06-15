/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.model;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_����ˮƽ��׼��ϢMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface SdlSummary {

	/**
	 * ��ȡ��
	 * @return ��
	 */
	public abstract String getMonth();
	
	/**
	 * ��ȡ���ж�ʱ��
	 * @return ���ж�ʱ��
	 */
	public abstract Integer getBreakm();

	/**
	 * ��ȡ������ʱ��ٷֱ�
	 * @return ������ʱ��ٷֱ�
	 */
	public abstract Double getContinuousm();

	/**
	 * ��ȡ��Ӱ��ʱ��
	 * @return ��Ӱ��ʱ��
	 */
	public abstract Integer getImpactm();

	/**
	 * ��ȡ���ȶ�ʱ��ٷֱ�
	 * @return ���ȶ�ʱ��ٷֱ�
	 */
	public abstract Double getSteadym();

	/**
	 * ��ȡ�°�ȫ�¼�����
	 * @return �°�ȫ�¼�����
	 */
	public abstract Integer getSafecasem();

	/**
	 * ��ȡ�°�ȫ�¼�����
	 * @return �°�ȫ�¼�����
	 */
	public abstract Integer getSafemarkm();

	/**
	 * ��ȡ�·��ռ������
	 * @return �·��ռ������
	 */
	public abstract Integer getRiskmarkm();

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public abstract Integer getCapacitycasem();

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public abstract Integer getCapacitymarkm();

}