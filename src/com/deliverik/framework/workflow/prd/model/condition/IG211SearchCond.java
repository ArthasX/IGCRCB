/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * ����״̬����ǰ�����������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>psdid</td>
 * <td>����״̬ID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG211SearchCond {
	/**
	 * ����״̬����ǰ����IDȡ��
	 * @return ����״̬����ǰ����ID
	 */
	public String getPsidid();
	
	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid();
	
	/**
	 * ���̱���IDȡ��
	 * @return ���̱���ID
	 */
	public String getPidid();

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidname();
	
	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidtype();

	/**
	 * ���̱���ֵȡ��
	 * @return ���̱���ֵ
	 */
	public String getPidvalue();
	
	/**
	 * ����ȡ��
	 * 
	 * @return ���� 
	 */
	public String getPsidid_like();
}
