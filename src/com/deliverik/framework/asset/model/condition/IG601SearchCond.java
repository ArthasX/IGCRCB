package com.deliverik.framework.asset.model.condition;

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
public interface IG601SearchCond {

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getEiid();
	
	/**
	 * ������������ȡ��
	 * @return ������������
	 */
	public String getRelateroom();
}
