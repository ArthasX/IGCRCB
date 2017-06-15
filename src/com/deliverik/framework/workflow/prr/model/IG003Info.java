/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model;

/**
 * <p>����:����ͳ����Ϣ�ӿ�</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public interface IG003Info {
	
	/**
	 * ���ܣ��·�ȡ��
	 * @return month �·�
	 */
	public abstract String getMonth();
	
	/**
	 * ���ܣ���ǰ�¼�ȡ��
	 * @return currentIncident ��ǰ�¼�
	 */
	public abstract Integer getCurrentIncident();
	
	/**
	 * ���ܣ���ǰ�¼�ȡ��
	 * @return precedingIncident ��ǰ�¼�
	 */
	public abstract Integer getPrecedingIncident();
	
	/**
	 * ���ܣ���ǰ����ȡ��
	 * @return currentProblem ��ǰ����
	 */
	public abstract Integer getCurrentProblem();
	
	/**
	 * ���ܣ���ǰ����ȡ��
	 * @return precedingProblem ��ǰ����
	 */
	public abstract Integer getPrecedingProblem();
	
	/**
	 * ���ܣ���ǰ���ȡ��
	 * @return currentChange ��ǰ���
	 */
	public abstract Integer getCurrentChange();
	
	/**
	 * ���ܣ���ǰ���ȡ��
	 * @return precedingChange ��ǰ���
	 */
	public abstract Integer getPrecedingChange();
	
	/**
	 * ���ܣ���ǰ����ȡ��
	 * @return currentDeployment ��ǰ����
	 */
	public abstract Integer getCurrentDeployment();
	
	/**
	 * ���ܣ���ǰ����ȡ��
	 * @return precedingDeployment ��ǰ����
	 */
	public abstract Integer getPrecedingDeployment();
	
	/**
	 * ���ܣ���ǰ����ȡ��
	 * @return currentWork ��ǰ����
	 */
	public abstract Integer getCurrentWork();
	
	/**
	 * ���ܣ���ǰ����ȡ��
	 * @return precedingWork ��ǰ����
	 */
	public abstract Integer getPrecedingWork();
	
	/**
	 * ���ܣ���ǰ�ܹ������趨
	 * @param totalPreceding ��ǰ�ܹ�����
	 */
	public abstract Integer getTotalCurrent();
	
	/**
	 * ���ܣ���ǰ�ܹ�����ȡ��
	 * @return totalPreceding ��ǰ�ܹ�����
	 */
	public abstract Integer getTotalPreceding();
	
}
