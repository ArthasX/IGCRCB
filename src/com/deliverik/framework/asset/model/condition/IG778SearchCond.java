package com.deliverik.framework.asset.model.condition;

/**
 * <p>
 * ������Ϣ��������
 * </p>
 * <p>
 * (δ��˵��������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>eiid</td>
 * <td>����ID</td>
 * </tr> 
 * <tr>
 * <td>room_eiid</td>
 * <td>����ID</td>
 * </tr>
 * <tr>
 * <td>eilabel</td>
 * <td>������</td>
 * </tr> 
 * <tr>
 * <td>einame</td>
 * <td>�������ƣ�ģ��ƥ�䣩��</td>
 * </tr>
 * <tr>
 * <td>u_total</td>
 * <td>�����
 * </td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG778SearchCond {

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getEiid();

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getRoom_eiid();

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getEilabel();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getEiname();

	/**
	 * ����߶ȣ�U��ȡ��
	 * @return ����߶ȣ�U��
	 */
	public String getU_total();
	
	/**
	 * �����Ƿ����ϼ�
	 * @return �����Ƿ����ϼ�
	 */
	public String getGraphstatus();
	
	/**
	 * ������λ��ȡ��
	 * 
	 * @return ������λ��
	 */
	public String getU_value();

	/**
	 * �ʲ����ͣ��յ�����������ʽ��ʽ��ȡ��
	 * 
	 * @return �ʲ����ͣ��յ�����������ʽ��ʽ��
	 */
	public String getEitype();

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getContainertype();
}
