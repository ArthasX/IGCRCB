package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * ���̲����߱���Ȩ����ͼ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>����״̬ID</td>
 * <td>���̶���ID</td>
 * </tr>
 * <tr>
 * <td>roleid</td>
 * <td>���̲����߽�ɫID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG893SearchCond {
	
	/**
	 * ����״̬IDȡ��
	 * 
	 * @return ����״̬ID
	 */
	public String getPsdid();
	
	/**
	 * ���̲����߽�ɫIDȡ��
	 * 
	 * @return ���̲����߽�ɫID
	 */
	public Integer getRoleid();
	
	/**
	 * ��ȫ�ֿ��ƽڵ�id����ȡ��
	 * @return ��ȫ�ֿ��ƽڵ�id
	 */
	public String getFormGlobalPsdids();

}
