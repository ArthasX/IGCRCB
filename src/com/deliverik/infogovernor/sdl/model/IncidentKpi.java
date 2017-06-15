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
 * Description: �������_ͳ�ƻ���_�¼�kpi��ϢMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IncidentKpi {

	/**
	 * ��ȡ���ID
	 * @return ���Id
	 */
	public abstract String getTypeId();
	/**
	 * ��ȡ�������
	 * @return �������
	 */
	public abstract String getTypeName();
	/**
	 * ��ȡ�������
	 * @return �������
	 */
	public abstract String getSyscoding();

	/**
	 * ��ȡ�����̶�
	 * @return �����̶�
	 */
	public abstract String getUrgency();
	/**
	 * ��ȡ�����̶�����
	 * @return �����̶�����
	 */
	public abstract String getUrgencyName();
	
	/**
	 * ��ȡƽ�����ʱ��
	 * @return ƽ�����ʱ��
	 */
	public abstract Float getResolve();

}