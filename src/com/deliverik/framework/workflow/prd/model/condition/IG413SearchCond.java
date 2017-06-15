package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * �����¼�������Ϣ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>pdid</td>
 * <td>���̶���ID</td>
 * </tr>
 * <tr>
 * <td>psdid</td>
 * <td>״̬ID</td>
 * </tr>
 * <tr>
 * <td>pedtype</td>
 * <td>�¼�����</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG413SearchCond {
	
	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid();
	
	/**
	 * ״̬IDȡ��
	 * 
	 * @return ״̬ID
	 */
	public String getPsdid();

	/**
	 * �¼�����ȡ��
	 * 
	 * @return �¼�����
	 */
	public String getPedtype();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPedid_like();
}
