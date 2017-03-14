/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model;

/**
 * <p>����:���������Ա����ͳ����ͼ�ӿ�</p>
 * <p>����������1.���̳�ʼ��</p>
 * <p>          2.���̲�ѯ</p>
 * <p>������¼��</p>
 */
public interface IG160Info {
	
	/**
	 * ���ܣ��û�IDȡ��
	 * @return ppuserid �û�ID
	 */
	public abstract String getPpuserid();

	/**
	 * ���ܣ��û�����ȡ��
	 * @return ppusername �û�����
	 */
	public abstract String getPpusername();
	
	/**
	 * ���ܣ�����IDȡ��
	 * @return orgid ����ID
	 */
	public abstract String getOrgid();
	
	/**
	 * ���ܣ���������ȡ��
	 * @return orgname ��������
	 */
	public abstract String getOrgname();

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
	/**
	 * ���ܣ�����ȡ��
	 * @return ask ����  
	 */
	public abstract Integer getAsk();
}