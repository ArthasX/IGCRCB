package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * <p>
 * ��ɫ��Ϣ��������
 * </p>
 * <p>
 * (δ��˵��������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>rolename</td>
 * <td>��ɫ����</td>
 * </tr> 
 * <tr>
 * <td>rolename_q</td>
 * <td>��ɫ���ƣ�ǰ��һ��ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>roletype</td>
 * <td>��ɫ���ͣ���roletypeEqual����1ʱ����ȫƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>roletypeEqual</td>
 * <td>sql���ȽϹ�ϵ��ֵ1Ϊ���ڣ�</td>
 * </tr> 
 * <tr>
 * <td>roledomain</td>
 * <td>��ɫ��������Χ</td>
 * </tr> 
 * <tr>
 * <td>roledomain_Like</td>
 * <td>��ɫ��������Χ��ǰ��һ��ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>roles_Like</td>
 * <td>��ɫ���ͣ���roletypeEqual����1ʱ��ǰ��һ��ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>roles_BP_EX</td>
 * <td>��չ��ɫ����</td>
 * </tr> 
 * <tr>
 * <td>assetdomain</td>
 * <td>��ɫ�ʲ�����Χ</td>
 * </tr> 
 * <tr>
 * <td>assetdomain_q</td>
 * <td>��ɫ�ʲ�����Χ��ǰ��һ��ģ��ƥ�䣩</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface RoleSearchCond {
	
	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRolename();
	
	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRolename_q();
	
	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRoletype();
	
	/**
	 * SQL���ȽϹ�ϵȡ��
	 * @return SQL���ȽϹ�ϵ
	 */
	public int getRoletypeEqual();
	
	/**
	 * ��ɫ��������Χȡ��
	 * @return ��ɫ��������Χ
	 */
	public String getRoledomain();
	
	/**
	 * ��ɫ��������Χȡ��
	 * @return ��ɫ��������Χ
	 */
	public String getRoledomain_Like();
	
	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRoles_Like();
	
	/**
	 * ��չ��ɫ����ȡ��
	 * @return ��չ��ɫ����
	 */
	public String[] getRoles_BP_EX();
	
	/**
	 * ��ɫ�ʲ�����Χȡ��
	 * @return ��ɫ�ʲ�����Χ
	 */
	public String getAssetdomain();

	/**
	 * ��ɫ�ʲ�����Χȡ��
	 * @return ��ɫ�ʲ�����Χ
	 */
	public String getAssetdomain_q();
	
	/**
	 * ��ɫ���Ͳ�ѯ����ȡ��
	 * @return ��ɫ���Ͳ�ѯ����
	 */
	public String getRoletype_gt();
	
	/**
	 *  �Զ�������IDȡ��
	 * @return �Զ�������ID
	 */
	public String getPdid();
	
	/**
	 * ��ɫID��Χȡ��
	 * @return roleid_in ��ɫID��Χ
	 */
	public List<Integer> getRoleid_in();
	
	/**
	 * ��ɫID���ڴ˷�Χȡ��
	 * @return ��ɫID���ڴ˷�Χ
	 */
	public String getRoleid_not_in();

}
