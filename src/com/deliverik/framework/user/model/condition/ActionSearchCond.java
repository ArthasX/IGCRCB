package com.deliverik.framework.user.model.condition;

/**
 * <p>
 * �˵���Ϣ��������
 * </p>
 * <p>
 * (δ��˵��������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>actlabel</td>
 * <td>�˵���ʾ����</td>
 * </tr>
 * <tr>
 * <td>actroletype</td>
 * <td>�˵��������ɫ���ͣ�ģ��ƥ�䣩</td>
 * </tr>
 * <tr>
 * <td>actname</td>
 * <td>�˵�����</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface ActionSearchCond {
	
	/**
	 * �˵���ʾ����ȡ��
	 * @return �˵���ʾ����
	 */
	public String getActlabel();
	
	/**
	 * �˵��������ɫ����ȡ��
	 * @return �˵��������ɫ����
	 */
	public String getActroletype();
	
	/**
	 * �˵�����ȡ��
	 * @return �˵�����
	 */
	public String getActname_like();
	
	/**
	 * URLȡ��
	 * @return URL����
	 */
	public String getActurl_like();
	
	/**
     * �˵�����ȡ��
     * @return �˵�����
     */
    public String getActtype();
    
    /**
     * @return the �Զ��������Զ����ɲ˵���״̬��ǣ�1������Ч��
     */
    public String getActl1id();
}
