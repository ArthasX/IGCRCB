/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * ����״̬��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>pdid</td>
 * <td>��������ID</td>
 * </tr>
 * <tr>
 * <td>psdid</td>
 * <td>����״̬ID</td>
 * </tr>
 * <tr>
 * <td>psdname</td>
 * <td>����״̬����</td>
 * </tr>
 * <tr>
 * <td>psdcode</td>
 * <td>����״̬��ʶ</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG213SearchCond {
	/**
	 * ���̽�ɫ���Ͷ���IDȡ��
	 * @return ���̽�ɫ���Ͷ���ID
	 */
	public String getPrtdid();
	
	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public String getPdid();

	/**
	 * ���̽�ɫ����ȡ��
	 * @return ���̽�ɫ����
	 */
	public String getRoletype();

	/**
	 * ����״̬IDȡ��
	 * 
	 * @return ����״̬ID
	 */
	public String getPrtdid_like();
}
