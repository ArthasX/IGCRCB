package com.deliverik.framework.workflow.prr.model.condition;

import java.util.List;

/**
 * <p>
 * ��־��Ϣ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>prid</td>
 * <td>���̼�¼ID</td>
 * </tr>
 * <tr>
 * <td>rluserid</td>
 * <td>��־������ID</td>
 * </tr>
 * <tr>
 * <td>rlusername</td>
 * <td>��־����������</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG036SearchCond {
	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid();

	/**
	 * ��־������IDȡ��
	 * @return ��־������ID
	 */
	public String getRluserid();
	
	/**
	 * ��־����������ȡ��
	 * @return ��־����������
	 */
	public String getRlusername();
	
	/**
	 * �û���ɫ
	 * @return �û���ɫ
	 */
	public List<Integer> getRoleid();
	
	/**
	 * �û���ɫ�����ʶ
	 * @return �û���ɫ�����ʶ
	 */
	public boolean isRoleorder() ;
	
	/**
	 * �ų�������־����
	 * @return �ų�������־����
	 */
	public String getNotEqualrlType();
	
	/**
	 * ��־����
	 * @return ��־����
	 */
	public String getRlType();
	
	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public String getPsdcode();
	
	/**
	 * �����ʶȡ��
	 * @return �����ʶ
	 */
	public String getRoleorder_type();
	
	/**
	 * ��ɫ�����˱�ʶȡ��
	 * @return ��ɫ�����˱�ʶ
	 */
	public String getRolemanger();

	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid();

	/**
	 * ����״̬��֧���ȡ��
	 * @return ����״̬��֧���
	 */
	public Integer getPsdnum();

}
