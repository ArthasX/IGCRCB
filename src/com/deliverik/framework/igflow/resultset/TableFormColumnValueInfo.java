/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.igflow.resultset;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ʽ����ֵ��Ϣ
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface TableFormColumnValueInfo {


	/**
	 * ��ȫ·��ȡ��
	 * @return fullName ��ȫ·��
	 */
	public String getFullName();

	/**
	 * �к�ȡ��
	 * @return rownumber �к�
	 */
	public String getRownumber();

	/**
	 * ��ֵȡ��
	 * @return value ��ֵ
	 */
	public String getValue();
}
