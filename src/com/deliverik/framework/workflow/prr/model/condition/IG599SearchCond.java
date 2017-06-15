package com.deliverik.framework.workflow.prr.model.condition;


/**
 * <p>
 * ���̱�����Ϣ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>prid</td>
 * <td>���̼�¼ID</td>
 * </tr>
 * <tr>
 * <td>pdid</td>
 * <td>���̶���ID</td>
 * </tr>
 * <tr>
 * <td>pivarname</td>
 * <td>���̱�����ʶ</td>
 * </tr>
 * <tr>
 * <td>pivartype</td>
 * <td>���̱�������</td>
 * </tr>
 * <tr>
 * <td>userid</td>
 * <td>�û�ID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG599SearchCond {
	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid();
	
	/**
	 * ���̶���IDȡ��
	 * @return ���̶���ID
	 */
	public String getPdid();
	
	/**
	 * ���̱�����ʶȡ��
	 * @return ���̱�����ʶ
	 */
	public String getPivarname();
	
	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPivartype();
	
	/**
	 * ���̱�����ʶ
	 */
	public String getPivarlabel();
	
	/**
	 * ���̱���ֵ
	 */
	public String getPivarvalue();

	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid();

}
