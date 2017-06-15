package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * <p>
 * �û���ɫ��Ȩ��Ϣ��������
 * </p>
 * <p>
 * (δ��˵��������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>roleid</td>
 * <td>��ɫID</td>
 * </tr> 
 * <tr>
 * <td>roleid</td>
 * <td>�û���ɫID</td>
 * </tr> 
 * <tr>
 * <td>roletype</td>
 * <td>�û���ɫ����</td>
 * </tr> 
 * <tr>
 * <td>roles_Like</td>
 * <td>�û���ɫ���ͣ�ǰ��һ��ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>roles_BP_EX</td>
 * <td>��չ�û���ɫ���ͣ�ֻ����roles_Like���ã�ȡ����������ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>isRolemanager</td>
 * <td>��ɫ�����ˣ���ֵΪtrueʱ��ѯ����ɫ�����ˣ�����ֵʱ�����ˣ�</td>
 * </tr> 
 * <tr>
 * <td>dutyflag</td>
 * <td>��ɫֵ���ˣ���ֵΪtrueʱ��ѯ����ɫֵ���ˣ�����ֵʱ�����ˣ�</td>
 * </tr> 
 * <tr>
 * <td>assetdomain</td>
 * <td>��ɫ��������</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface UserRoleVWSearchCond {
	
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

	/**
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRoletype();
	
	/**
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRoles_Like();
	
	/**
	 * ��չ�û���ɫ����ȡ��
	 * @return ��չ�û���ɫ����
	 */
	public String[] getRoles_BP_EX();
	
	/**
	 * ��ɫ������ȡ��
	 * @return ��ɫ������ȡ��
	 */
	public boolean isRolemanager();
	
	/**
	 * ��ɫֵ����ȡ��
	 * @return ��ɫֵ����ȡ��
	 */
	public boolean isDutyflag();
	
	/**
	 * ��ɫ��������ȡ��
	 * @return ��ɫ��������
	 */
	public String getAssetdomain();
	
	/**
	 * ��ɫ��������Χȡ��
	 * 
	 * @return ��ɫ��������Χ
	 */
	public String getRoledomain_like();
	
	/**
	 * ��ɫ��������Χȡ��
	 * 
	 * @return ��ɫ��������Χ
	 */
	public String getRoledomain();
	
	/**
	 * ����syscoding���ģ����ѯȡ��
	 *
	 * @return orgid_like ����syscoding���ģ����ѯ
	 */
	public String getOrgid_like();
	
	/**
	 * ����ɫ����ģ����ѯȡ��
	 *
	 * @return rolename_like ����ɫ����ģ����ѯ
	 */
	public String getRolename_like();

	/**
	 * ����ɫ�û���ȨID��ѯ�趨
	 *
	 * @param urid ����ɫ�û���ȨID��ѯ
	 */
	public void setUrid_eq(Integer urid_eq);
	
	/**
	 * �û���ȡ��
	 * @return username_like �û���
	 */
	public String getUsername_like();
	
	/**
	 * ��ɫ��Χȡ��
	 *
	 * @return roleid_in ��ɫ��Χ
	 */
	public List<Integer> getRoleid_in();
}
