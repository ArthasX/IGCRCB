/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * ���̲����߼�������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>psdid</td>
 * <td>����״̬ID</td>
 * </tr>
 * <tr>
 * <td>ppdid</td>
 * <td>���̲�����ID</td>
 * </tr>
 * <tr>
 * <td>roleid</td>
 * <td>���̲����߽�ɫID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG222SearchCond {
	/**
	 * ���̲�����IDȡ��
	 * @return ���̲�����ID
	 */
	public String getPpdid();
	
	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid();
	
	/**
	 * ���̲����߽�ɫIDȡ��
	 * @return ���̲����߽�ɫID
	 */
	public Integer getRoleid();

	/**
	 * ���̲�������׼ȡ��
	 * @return ���̲�������׼
	 */
	public String getPpapprove();
	
	/**
	 * ���̲����߲���ȡ��
	 * @return ���̲����߲���
	 */
	public String getPpdeny();
	
	/**
	 * ���̲������ύȡ��
	 * @return ���̲������ύ
	 */
	public String getPpsubmit();
	
	/**
	 * ���̲�������ֹȡ��
	 * @return ���̲�������ֹ
	 */
	public String getPpterm();
	
	/**
	 * ���̲����߸���ȡ��
	 * @return ���̲����߸���
	 */
	public String getPpupdate();
	
	public String getPdid();

	public Integer getPrid();

	/**
	 * ���̲�����IDȡ��
	 * 
	 * @return ���̲�����ID
	 */
	public String getPpdid_like();
	
	/**
	 * �Ƿ񰴻���ȡ�� 
	 * @return �Ƿ񰴻���
	 */
	public String getIsOrg();
	
}
