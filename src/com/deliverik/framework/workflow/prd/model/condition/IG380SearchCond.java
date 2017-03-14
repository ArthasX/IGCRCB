package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * �������Ͷ�����Ϣ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>pdid</td>
 * <td>�������Ͷ���ID</td>
 * </tr>
 * <tr>
 * <td>ptid</td>
 * <td>����ģ��ID</td>
 * </tr>
 * <tr>
 * <td>pdname</td>
 * <td>�������Ͷ�������</td>
 * </tr> 
 * <tr>
 * <td>pdstatus</td>
 * <td>�������Ͷ���״̬��a:���ã�i:ͣ�ã�</td>
 * </tr> 
 * <tr>
 * <td>notSelfPd</td>
 * <td>����ģ��ID����ƥ�䣩</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG380SearchCond {
	
	/**
	 * �������Ͷ���IDȡ��
	 * @return �������Ͷ���ID
	 */
	public String getPdid();

	/**
	 * ����ģ��IDȡ��
	 * @return ����ģ��ID
	 */
	public Integer getPtid();

	/**
	 * �������Ͷ�������ȡ��
	 * @return �������Ͷ�������
	 */
	public String getPdname();

	/**
	 * �������Ͷ���״̬��a���ã�iͣ�ã�ȡ��
	 * @return �������Ͷ���״̬
	 */
	public String getPdstatus();

	/**
	 * ����ģ��ID����ƥ�䣩ȡ��
	 * @return ����ģ��ID
	 */
	public Integer getNotSelfPd();
	
	/**
	 * ��������IDȡ���Զ������̺ͱ�׼����ID
	 * @return ����ģ��ID
	 */
	public Integer[] getPrTypeArray();
	
	/**
	 * ����״̬����
	 * @return ����״̬����
	 */
	public String[] getPdstatuses();
	
	/**
	 * ������־Ȩ��ȡ��
	 * @return ������־Ȩ��
	 */
	public String getPermission();
	
	/**
	 * �������Ͷ���IDȡ��
	 * 
	 * @return �������Ͷ���ID
	 */
	public String getPdid_like();
	
    /**
     * һ�����̼�¼��������IDģ����ѯ
     */
	public String[] getPrpdid_like_or();
	public String[] getPdid_in();
	public String[] getPdid_not_in();
	
	/**
     * ���̷���λ�ò˵�ȡ��
     * @return  ���̷���λ�ò˵�  
     */
    public String getActname();
	
}
