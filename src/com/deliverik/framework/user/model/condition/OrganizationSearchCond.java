package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * <p>
 * ������Ϣ��������
 * </p>
 * <p>
 * (δ��˵��������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>orgname</td>
 * <td>��������</td>
 * </tr> 
 * <tr>
 * <td>orgname_q</td>
 * <td>�������ƣ�ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>orgpar</td>
 * <td>�ϼ����������</td>
 * </tr> 
 * <tr>
 * <td>is_in_use</td>
 * <td>����״̬</td>
 * </tr> 
 * <tr>
 * <td>orgparid</td>
 * <td>�ϼ����������</td>
 * </tr> 
 * <tr>
 * <td>orgsuper</td>
 * <td>�ϼ���������루��ֵ��Ϊ�գ��Ҳ�����0ʱ����ѯ���ڵ�����Ļ�����</td>
 * </tr> 
 * <tr>
 * <td>orgsyscoding</td>
 * <td>���������</td>
 * </tr> 
 * <tr>
 * <td>roledomain_q</td>
 * <td>��ɫ��������Χ��ǰ��һ��ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>orgparstr_q</td>
 * <td>�ϼ���������루ǰ��һ��ģ��ƥ�䣬������orgparstr_q��ֵ����</td>
 * </tr> 
 * <tr>
 * <td>orgsyscoding_q</td>
 * <td>���������</td>
 * </tr> 
 * <tr>
 * <td>syscoding_area</td>
 * <td>��������뼯�ϣ�����ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>sortType</td>
 * <td>����ʽ������CommonDefineUtils.SORT_BY_ORGSYSCODING���ջ����������������</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface OrganizationSearchCond {
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgname();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgname_q();

	/**
	 * �ϼ����������ȡ��
	 * @return �ϼ����������
	 */
	public String getOrgpar();

	/**
	 * ����״̬ȡ��
	 * @return ����״̬
	 */
	public String getIs_in_use();

	/**
	 * �ϼ����������ȡ��
	 * @return �ϼ����������
	 */
	public String getOrgparid();

	/**
	 * �ϼ����������ȡ��
	 * @return �ϼ����������
	 */
	public Integer getOrgsuper();

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getOrgsyscoding();

	/**
	 * ��ɫ��������Χȡ��
	 * @return ��ɫ��������Χ
	 */
	public String getRoledomain_q();

	/**
	 * ��ɫ��������Χ���ȫ��ȡ�ã�ƽ̨������
	 * @return ��ɫ��������Χ���ȫ��
	 */
	public String getComplete_name();

	/**
	 * �ϼ����������ȡ��
	 * @return �ϼ����������
	 */
	public String getOrgparstr_q();

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getOrgsyscoding_q();
	
	/**
	 * ��������뼯��ȡ��
	 * @return ��������뼯��
	 */
	public List<String> getSyscoding_area();
	
	/**
	 * ����ʽȡ��
	 * @return ����ʽ
	 */
	public String getSortType();
	
	/**
	 * ��������뼯��ȡ�ã�ƽ̨������
	 * @return ��������뼯��
	 */
	public List<String> getNot_in_syscoding_area();
	
	/**
	 * ��Ҫ���˵Ļ��������ȡ�ã�ƽ̨������
	 * @return ��Ҫ���˵Ļ��������
	 */
	public String getXbtype();
	
	/**
	 * ��������(ģ����ѯ)ȡ��
	 *
	 * @return orgname_like ��������(ģ����ѯ)
	 */
	public String getOrgname_like();
}
