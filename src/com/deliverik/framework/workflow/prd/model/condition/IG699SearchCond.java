/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * ����ȱʡ�����߱���Ȩ�޲�ѯ����
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>psdid</td>
 * <td>����״̬ID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG699SearchCond {
	
	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPdvid_like();
	
	
}
