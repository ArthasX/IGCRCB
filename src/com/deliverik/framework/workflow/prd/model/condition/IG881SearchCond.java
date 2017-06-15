/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * ���̲����߱���Ȩ�޲�ѯ����
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>psdid</td>
 * <td>����״̬ID</td>
 * </tr>
 * <tr>
 * <td>ppdid</td>
 * <td>���̲�����ID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG881SearchCond {
	/**
	 * ���̲����߱���Ȩ��IDȡ��
	 * @return ���̲����߱���Ȩ��ID
	 */
	public String getPipdid();
	
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
	 * ���̲����߱���Ȩ��ȡ��
	 * @return ���̲����߱���Ȩ��
	 */
	public String getPidaccess();
	
	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid();
	
	/**
	 * ���̲�����IDȡ��
	 * @return ���̲�����ID
	 */
	public String getPpdid();
	
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public String getPdid();

	/**
	 * ���̲����߱���Ȩ��IDȡ��
	 * 
	 * @return ���̲����߱���Ȩ��ID
	 */
	public String getPipdid_like();
	
}
