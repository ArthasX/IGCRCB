/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * <p>
 * ������Ϣ��������
 * </p>
 * <p>
 * <br>
 * <table border="1">
 * <tr>
 * <td>eiid</td>
 * <td>����ID</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface SOC0601SearchCond {

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public String getEiid();
	
	/**
	 * ������������ȡ��
	 * @return ������������
	 */
	public String getRelateroom();
}
