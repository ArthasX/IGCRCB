package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * ����ҳ�涨����Ϣ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>pdid</td>
 * <td>���̶���ID</td>
 * </tr>
 * <tr>
 * <td>pjdtype</td>
 * <td>ҳ������</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG126SearchCond {
	
	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid();
	
	/**
	 * ҳ������ȡ��
	 * 
	 * @return ҳ������
	 */
	public String getPjdtype();

	/**
	 * ����ҳ�涨��IDȡ��
	 * 
	 * @return ����ҳ�涨��ID
	 */
	public String getPjdid_like();
}
