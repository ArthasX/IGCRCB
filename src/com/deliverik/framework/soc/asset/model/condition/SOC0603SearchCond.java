/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

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
public interface SOC0603SearchCond {

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
     * ������ȡ��
     *
     * @return eilabel_like ������
     */
    public String getEilabel_like();

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
	
	 /**
     * ʣ��U��ȡ��
     *
     * @return u_last ʣ��U��
     */
    public String getU_last();

    /**
     * ʣ�ฺ��ȡ��
     *
     * @return load_last ʣ�ฺ��
     */
    public String getLoad_last();

    /**
     * ʣ�����ȡ��
     *
     * @return power_last ʣ�����
     */
    public String getPower_last();
}
