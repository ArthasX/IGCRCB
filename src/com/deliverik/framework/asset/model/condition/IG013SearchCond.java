package com.deliverik.framework.asset.model.condition;

import java.util.List;

/**
 * <p>
 * �ʲ���Ϣ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>eid</td>
 * <td>�ʲ�ģ��ID</td>
 * </tr>
 * <tr>
 * <td>einame</td>
 * <td>�ʲ����ƣ�ģ��ƥ�䣩</td>
 * </tr>
 * <tr>
 * <td>eilabel</td>
 * <td>�ʲ����</td>
 * </tr> 
 * <tr>
 * <td>eiorgsyscoding</td>
 * <td>�ʲ�������������루ǰ��һ��ģ��ƥ�䣩</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG013SearchCond {
	
	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

	/**
	 * �ʲ����ȡ��
	 * @return �ʲ����
	 */
	public String getEilabel();
	
	/**
	 * �ʲ�����ȡ��
	 * @return �ʲ�����
	 */
	public String getEiname();
	
	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding();
	
	/**
	 * �ʲ�IDȡ�ã�ƽ̨������
	 * @return �ʲ�ID
	 */
	public String getEiid();
	
	/**
	 * �ʲ��汾��ȡ��
	 * @return �ʲ��汾��
	 */
	public Integer getEiversion();
	
	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion() ;
	
	public List<String> getEilabel_list();
	
	/**
	 * �ʲ����ƣ���ȫƥ�� ��ȡ��
	 * @return �ʲ����ƣ���ȫƥ�� ��
	 */
	public String getEiname_equal();

}
