package com.deliverik.framework.user.model.condition;

/**
 * <p>
 * �û���ɫ��Ȩ��Ϣ��������
 * </p>
 * <p>
 * (δ��˵��������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>userid</td>
 * <td>�û�ID</td>
 * </tr> 
 * <tr>
 * <td>roleid</td>
 * <td>�û���ɫID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface UserRoleSearchCond {
	
	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid();
	
	/**
	 * �û���ɫIDȡ��
	 * @return �û���ɫID
	 */
	public Integer getRoleid();

}
