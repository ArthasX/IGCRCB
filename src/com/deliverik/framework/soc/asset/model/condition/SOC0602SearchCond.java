/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * <p>
 * �豸�ʲ���Ϣ��������
 * </p>
 * <p>
 * (δ��˵��������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>eiid</td>
 * <td>�豸�ʲ�ID</td>
 * </tr> 
 * <tr>
 * <td>container_eiid</td>
 * <td>����ID</td>
 * </tr>
 * <tr>
 * <td>eilabel</td>
 * <td>�豸�ʲ����</td>
 * </tr> 
 * <tr>
 * <td>einame</td>
 * <td>�豸�ʲ����ƣ�ģ��ƥ�䣩</td>
 * </tr>
 * <tr>
 * <td>u_total</td>
 * <td>�豸�ʲ���</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface SOC0602SearchCond {

	/**
	 * �豸�ʲ�IDȡ��
	 * @return ����ID
	 */
	public Integer getEiid();

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getContainer_eiid();

	/**
	 * �豸�ʲ����ȡ��
	 * @return �豸�ʲ����
	 */
	public String getEilabel();

	/**
	 * �豸�ʲ�����ȡ��
	 * @return �豸�ʲ�����
	 */
	public String getEiname();

	/**
	 * �豸�ʲ��߶ȣ�U��ȡ��
	 * @return �豸�ʲ��߶ȣ�U��
	 */
	public String getU_total();
	
	/**
	 * �Ƿ��ϼܱ�־λȡ��
	 * @return �Ƿ��ϼܱ�־λ
	 */
	String getInJiguiFlg();
	
	/**
	 * �豸�����
	 * @return �豸�����
	 */
	String getEsyscoding();
	
	/**
	 * �豸�����ȡ��
	 * @return �豸�����
	 */
	public String getInroomFlg();

	/**
	 * �豸��״
	 */
	public String[] getEiStatuses();
	
	  /**
     * ����IDȡ��
     *
     * @return room_eiid ����ID
     */
    public Integer getRoom_eiid();
    
    /**
	 * ��������ȡ��
	 * @return cabinet  ��������
	 */
	public String getCabinet();
}
