/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model;

/**
 * <p>����:�������Ͷ�����Ϣ�ӿ�</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public interface IG359Info {
	
	/**
	 * ���ܣ��ʲ�IDȡ��
	 * @return prassetid �ʲ�ID
	 */
	public abstract Integer getPrassetid();

	/**
	 * ���ܣ��ʲ�����ȡ��
	 * @return prassetname �ʲ�����
	 */
	public abstract String getPrassetname();

	/**
	 * ���ܣ��¼�ȡ��
	 * @return incident �¼�
	 */
	public abstract Integer getIncident();

	/**
	 * ���ܣ�����ȡ��
	 * @return problem ����
	 */
	public abstract Integer getProblem();

	/**
	 * ���ܣ����ȡ��
	 * @return change ���
	 */
	public abstract Integer getChange();

	/**
	 * ���ܣ�����ȡ��
	 * @return deployment ����
	 */
	public abstract Integer getDeployment();

	/**
	 * ���ܣ�����ȡ��
	 * @return work ����
	 */
	public abstract Integer getWork();
}