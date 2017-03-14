package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * <p>
 * �û���Ϣ��������
 * </p>
 * <p>
 * (δ��˵��������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>userid</td>
 * <td>�û�ID</td>
 * </tr> 
 * <tr>
 * <td>userid_q</td>
 * <td>�û�ID��ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>username</td>
 * <td>�û�����</td>
 * </tr> 
 * <tr>
 * <td>username_q</td>
 * <td>�û�������ģ��ƥ�䣩</td>
 * </tr>
 * <tr>
 * <td>password</td>
 * <td>�û�����</td>
 * </tr> 
 * <tr>
 * <td>orgid</td>
 * <td>�û���������루ǰ��һ��ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>usermobile</td>
 * <td>�û��ֻ�</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface UserSearchCond {
	
	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid();
	
	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid_q();
	
	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUsername();
	
	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUsername_q();

	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getPassword();
	
	/**
	 * �û����������ȡ��
	 * @return �û����������
	 */
	public String getOrgid();
	
	/**
	 * �û����������ȡ��
	 * @return �û����������
	 */
	public String getOrgid_like();
	
	/**
	 * �û��ֻ�ȡ��
	 * @return �û��ֻ�
	 */
	public String getUsermobile();

	/**
	 * �߼�ɾ����־λȡ��
	 * @return �߼�ɾ����־λ
	 */
	public String getDeleteflag();
	
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
	 * �û�ID��Χȡ��
	 * @return userid_in �û�ID��Χ
	 */
	public List<String> getUserid_in();
}
