package com.deliverik.framework.model.condition;

/**
 * <p>
 * ������Ϣ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>attname</td>
 * <td>��������</td>
 * </tr>
 * <tr>
 * <td>attkey</td>
 * <td>��������</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface AttachmentSearchCond {
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getAttname();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getAttkey();

}
