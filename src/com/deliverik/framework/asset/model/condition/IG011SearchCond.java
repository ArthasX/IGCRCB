package com.deliverik.framework.asset.model.condition;

/**
 * <p>
 * �ʲ�ͳ����Ϣ��������
 * </p>
 * <p>
 * (δ��˵��������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>ciupdtime_from</td>
 * <td>�ʲ��Ǽǿ�ʼʱ�䣨���ڵ��ڣ�</td>
 * </tr>
 * <tr>
 * <td>ciupdtime_to</td>
 * <td>�ʲ��Ǽǽ�ֹʱ�䣨С�ڵ��ڣ�</td>
 * </tr> 
 * <tr>
 * <td>eiorgsyscoding_q</td>
 * <td>�ʲ�������������루ǰ��һ��ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>eparcoding</td>
 * <td>�ʲ�ģ���ϼ�����루���ݲ����ͳ�Ƹ��ʲ�ģ���µ��ʲ�������</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG011SearchCond {
	
	/**
	 * �ʲ��Ǽǿ�ʼʱ��ȡ��
	 * @return �ʲ��Ǽǿ�ʼʱ��
	 */
	public String getCiupdtime_from();
	
	/**
	 * �ʲ��Ǽǽ�ֹʱ��ȡ��
	 * @return �ʲ��Ǽǽ�ֹʱ��
	 */
	public String getCiupdtime_to();
	
	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding_q();
	
	/**
	 * ������ѯ���ͣ�ƽ̨������ȡ��
	 * @return ������ѯ���ͣ�ƽ̨������
	 */
	public String getOrgType();
	
	/**
	 * �ʲ�ģ���ϼ������ȡ��
	 * @return �ʲ�ģ���ϼ������
	 */
	public String getEparcoding();
}
