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
 * Description: �������_ͳ�ƻ���_���kpi��ϢMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface ChangeKpi {

	/**
	 * ��ȡ����ID
	 * @return ����Id
	 */
	public abstract Integer getTypeId();
	/**
	 * ��ȡ��������
	 * @return ��������
	 */
	public abstract String getTypeName();

	/**
	 * ��ȡ�ɹ���״̬
	 * @return �ɹ���״̬
	 */
	public abstract Integer getSuccess();
	
	/**
	 * ��ȡ����������״̬
	 * @return ����������״̬
	 */
	public abstract Integer getProblem();
	
	
	/**
	 * ��ȡʧ����״̬
	 * @return ʧ����״̬
	 */
	public abstract Integer getFail();
	

}