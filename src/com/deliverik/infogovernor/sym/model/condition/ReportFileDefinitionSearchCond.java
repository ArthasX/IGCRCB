/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
 * ������Ϣ��ѯ�����ӿ�
 * 
 */
public interface ReportFileDefinitionSearchCond {
	
	/**
	 * ������ʾ����(ģ��ƥ��)ȡ��
	 * @return ������ʾ����(ģ��ƥ��)
	 */
	public String getRfdtitle_like();
	
	/**
	 * ������ʾ����ȡ��
	 * @return ������ʾ����
	 */
	public String getRfdtitle();
	
	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getRfdfilename();
	
	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getRfdtype();
	
	public Integer getRfdid();

}
