package com.deliverik.framework.asset.model.condition;

/**
 * <p>
 * �ʲ�������Ϣ��������
 * </p>
 * <p>
 * <br>
 * <table border="1">
 * <tr>
 * <td>eid</td>
 * <td>�ʲ�ģ��ID</td>
 * </tr> 
 * <tr>
 * <td>eiid</td>
 * <td>�ʲ�ID</td>
 * </tr>
 * <tr>
 * <td>cid</td>
 * <td>�ʲ�ģ������ID</td>
 * </tr> 
 * <tr>
 * <td>civersion</td>
 * <td>�ʲ����Դ�汾��</td>
 * </tr> 
 * <tr>
 * <td>cismallversion</td>
 * <td>�ʲ�����С�汾��</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG800SearchCond {

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid();
	
	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

	/**
	 * �ʲ����Դ�汾��ȡ��
	 * @return �ʲ����Դ�汾��
	 */
	public String getCiversion();
	
	/**
	 * �ʲ�ģ������IDȡ��
	 * @return �ʲ�ģ������ID
	 */
	public Integer getCid();
	
	/**
	 * �ʲ�ģ������ֵȡ��
	 * @return �ʲ�ģ������ֵ
	 */
	public String getCivalue();
	
	/**
	 * �ʲ�����С�汾��ȡ��
	 * @return �ʲ�����С�汾��
	 */
	public String getCismallversion();

}
