package com.deliverik.framework.user.model.condition;

/**
 * <p>
 * ��ɫ�˵���Ȩ��Ϣ��������
 * </p>
 * <p>
 * (δ��˵��������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>roleid</td>
 * <td>��ɫID</td>
 * </tr> 
 * <tr>
 * <td>actname</td>
 * <td>�˵�ID</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface RoleActionSearchCond {
	
	/**
	 * ��ɫIDȡ��
	 * @return ��ɫID
	 */
	public  Integer getRoleid();
	
	/**
	 * �˵�IDȡ��
	 * @return �˵�ID
	 */
	public String getActname();
	
}
