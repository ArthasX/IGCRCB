package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * ���̲����߱���Ȩ����ͼ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>psdid</td>
 * <td>���̶���ID</td>
 * </tr>
 * <tr>
 * <td>ppdid</td>
 * <td>���̲�����ID</td>
 * </tr>
 * <tr>
 * <td>pdid</td>
 * <td>��������ID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG100SearchCond {
	
	/**
	 * ����״̬IDȡ��
	 * 
	 * @return ����״̬ID
	 */
	public String getPsdid();
	
	/**
	 * ���̲�����IDȡ��
	 * 
	 * @return ���̲�����ID
	 */
	public String getPpdid();
	
	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public String getPdid();

}
