package com.deliverik.framework.user.model.condition;

/**
 * <p>
 * �û���ɫ������Ϣ��������
 * </p>
 * <p>
 * (δ��˵��������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>userida</td>
 * <td>�û�ID</td>
 * </tr> 
 * <tr>
 * <td>username</td>
 * <td>�û�������ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>roleida</td>
 * <td>�û���ɫID</td>
 * </tr>
 * <tr>
 * <td>rolename</td>
 * <td>�û���ɫ����</td>
 * </tr> 
 * <tr>
 * <td>roletype</td>
 * <td>�û���ɫ����</td>
 * </tr> 
 * <tr>
 * <td>orgida</td>
 * <td>�û���������루ǰ��һ��ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>orgname</td>
 * <td>�û���������</td>
 * </tr>  
 * </table>
 * </p>
 * 
 */
public interface UserInfoSearchCond {
	
	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserida();

	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUsername();
	
	/**
	 * �û���ɫIDȡ��
	 * @return �û���ɫID
	 */
	public Integer getRoleida();

	/**
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRolename();
	
	/**
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRoletype();
	
	/**
	 * �û����������ȡ��
	 * @return �û����������
	 */
	public String getOrgida();

	/**
	 * �û���������ȡ��
	 * @return �û���������
	 */
	public String getOrgname();
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getUserinfo();
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getUserinfo_like();

	/**
	 * �û����ƣ�PMSϵͳ�Խ�ר��ȡ��
	 * @return username_forPms �û����ƣ�PMSϵͳ�Խ�ר��
	 */
	
	public String getUsername_forPms() ;
}
