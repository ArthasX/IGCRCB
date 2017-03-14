/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * ���̱���������Ϣ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>pidid</td>
 * <td>���̱�������ID</td>
 * </tr>
 * <tr>
 * <td>pdid</td>
 * <td>��������ID</td>
 * </tr>
 * <tr>
 * <td>pidlabel</td>
 * <td>���̱�����ʾ����</td>
 * </tr> 
 * <tr>
 * <td>pidname</td>
 * <td>���̱�������</td>
 * </tr> 
 * <tr>
 * <td>pidtype</td>
 * <td>���̱�������</td>
 * </tr> 
 * <tr>
 * <td>pidrequired</td>
 * <td>���̱����Ƿ����</td>
 * </tr> 
 * <tr>
 * <td>pidname_like</td>
 * <td>���̱�������(ģ��ƥ��)</td>
 * </tr> 
 * <tr>
 * <td>isDefault</td>
 * <td>���̱��������Ƿ��жϱ���Ϊȱʡ������ʶ��WorkFlowConstDefine.YES:�жϣ�WorkFlowConstDefine.NO:���жϣ�</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG007SearchCond {
	
	/**
	 * ���ܣ����̱�������IDȡ��
	 * @return ���̱�������ID
	 */
	public String getPidid();

	/**
	 * ���ܣ���������IDȡ��
	 * @return ��������ID
	 */
	public String getPdid();

	/**
	 * ���ܣ����̱�����ʾ����ȡ��
	 * @return ���̱�����ʾ����
	 */
	public String getPidlabel();

	/**
	 * ���ܣ����̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidtype();

	/**
	 * ���ܣ����̱����Ƿ����ȡ��
	 * @return ���̱����Ƿ����
	 */
	public String getPidrequired();

	/**
	 * ���ܣ����̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidname();

	/**
	 * ���ܣ����̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidname_like();

	/**
	 * ���ܣ����̱��������Ƿ��жϱ���Ϊȱʡ������ʶȡ��
	 * @return ���̱��������Ƿ��жϱ���Ϊȱʡ������ʶ
	 */
	public String getIsDefault();
	
	public Integer getPidgid();
	
	/**
	 * ���ܣ����̹�ͨ����IDȡ��
	 * @return ���̹�ͨ����ID
	 */
	public String getPidmode();
	
	public String getPidid_notlike();
	
	public String getPsdcode_like();

	public String getPpdid_like();

	public String getPsdid_like();
	
	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPidid_like();
	
	public String[] getPidtypes();
	
	/**
	 * �������б�ʶȡ��
	 * @return tableColumn �������б�ʶ
	 */
	public String getTableColumn();
	
	 /**
		 * ������������ȡ��
		 * @return ppidid ������������
		 */
	public String getPpidid();
	
	/**
	 *�Ƿ񵼳�����ȡ��
	 */
	public String getIsExport();
		
	public String getPiduse();
}
