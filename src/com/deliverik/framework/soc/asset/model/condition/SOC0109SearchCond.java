package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;


/**
 * <p>
 * �ʲ�ģ��������Ϣ��������
 * </p>
 * <p>
 * (δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>eid</td>
 * <td>�ʲ�ģ��ID</td>
 * </tr>
 * <tr>
 * <td>cname</td>
 * <td>�ʲ�ģ���������ƣ�ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>ccategory</td>
 * <td>�ʲ�ģ����������</td>
 * </tr> 
 * <tr>
 * <td>cstatus</td>
 * <td>�ʲ�ģ������״̬1���ã�2ͣ�ã�</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface SOC0109SearchCond {
	/**
	 * �ʲ�����IDȡ��
	 * @return
	 */
	public String getCid();
	/**
	 * �ʲ�����ID likeȡ��
	 * @return
	 */
	public String getCid_like();
	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ����������
	 */
	public String getCname();
	
	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ����������
	 */
	public String getCcategory();
	
	/**
	 * �ʲ�ģ������״̬ȡ��
	 * @return �ʲ�ģ������״̬
	 */
	public String getCstatus();
	
	/**
	 * �ʲ�ģ�����Ա��ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ�����Ա��
	 */
	public String getClabel();

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶȡ�ã�ƽ̨������
	 * @return �ʲ�ģ�������Ƿ���ʾ��ʶ
	 */
	public Integer getCseq();
	
	/**
	 * �ʲ�ģ�Ͳ���������������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ�Ͳ���������������
	 */
	public List<String> getEsyscodingList();
	
	/**
	 * �ʲ�ģ�������������������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ�������������������
	 */
	public List<String> getCattachList();
	/**
	 *�ʲ���ģ����ѯ
	 * @return �ʲ���ģ����ѯ��������
	 */
	public String getEsyscoding_like() ;
}
