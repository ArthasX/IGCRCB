package com.deliverik.framework.asset.model.condition;

import java.util.List;

/**
 * <p>
 * �ʲ�ģ����Ϣ��������
 * </p>
 * <p>
 * (δ��˵��������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>eidStr</td>
 * <td>�ʲ�ģ��ID</td>
 * </tr> 
 * <tr>
 * <td>ename</td>
 * <td>�ʲ�ģ�����ƣ�ģ��ƥ�䣩</td>
 * </tr>
 * <tr>
 * <td>elabel</td>
 * <td>�ʲ�ģ�ͱ��</td>
 * </tr> 
 * <tr>
 * <td>estatus</td>
 * <td>�ʲ�ģ��״̬</td>
 * </tr>
 * <tr>
 * <td>ecategory_q</td>
 * <td>�ʲ�ģ�ͷ���</td>
 * </tr> 
 * <tr>
 * <td>eparcoding_q</td>
 * <td>�ʲ�ģ�͸��������</td>
 * </tr>
 * <tr>
 * <td>esyscoding_q</td>
 * <td>�ʲ�ģ�͸�������루ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>esyscoding_nq</td>
 * <td>�ʲ�ģ�͸�������루ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>esyscoding</td>
 * <td>�ʲ�ģ�Ͳ����</td>
 * </tr> 
 * <tr>
 * <td>syscoding_q</td>
 * <td>�ʲ�ģ�Ͳ���루ǰ��һ��ģ��ƥ�䣩</td>
 * </tr>
 * <tr>
 * <td>delList_q</td>
 * <td>�ʲ�ģ�Ͳ�����������������ȥ���ʲ�ģ�Ͳ������ü����ڵ�Ԫ��ģ��ƥ����ʲ�ģ����Ϣ��</td>
 * </tr>
 * </table>
 * </p>
 * 
 */

public interface IG117SearchCond {

	/**
	 * �ʲ�ģ��״̬ȡ��
	 * @return �ʲ�ģ��״̬
	 */
	public String getEstatus();


	/**
	 * �ʲ�ģ�͸���������������ȡ��
	 * @return �ʲ�ģ�͸���������������
	 */
	public String getEparcoding_q();


	/**
	 * �ʲ�ģ�͸��������ǰ��һ��ģ��ƥ���������ȡ��
	 * @return �ʲ�ģ�͸��������ǰ��һ��ģ��ƥ���������
	 */
	public String getEsyscoding_q();


	/**
	 * �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ���������ȡ��
	 * @return �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ���������
	 */
	public String getSyscoding_q();


	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding();
	
	/**
	 * �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ�����������not like��ȡ��
	 * @return �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ�����������not like��
	 */
	public String getEsyscoding_nq();

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEidStr();


	/**
	 * �ʲ�ģ�ͱ��ȡ��
	 * @return �ʲ�ģ�ͱ��
	 */
	public String getElabel();

	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getEname();
	
	/**
	 * �ʲ�ģ�ͷ���ȡ��
	 * @return �ʲ�ģ�ͷ���
	 */
	public String getEcategory_q();
	
	/**
	 * �ʲ�ģ�Ͳ���������������ȡ��
	 * @return ȥ���ʲ�ģ�Ͳ������ü����ڵ�Ԫ��ģ��ƥ����ʲ�ģ����Ϣ
	 */
	public List<String> getDelList_q();
	
	/**
	 * �ʲ�ģ�Ͳ���������������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ�Ͳ���������������
	 */
	public List<String> getDelList();
	

	/**
	 * �ʲ�ģ�Ͳ���������������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ�Ͳ���������������
	 */
	public List<String> getSelectList();

	
	/**
	 * �ʲ�ģ�Ͳ���븨����������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ�Ͳ���븨����������
	 */
	public String getEsyscoding_tree();


	/**
	 * �ʲ�ģ�Ͳ�����������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ�Ͳ�����������
	 */
	public String getEparcoding_status_start();


	/**
	 * �ʲ�ģ�͸���������������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ�͸���������������
	 */
	public String getEparcoding_status();
	
	/**
	 * �ʲ�ģ�͸��������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ�͸��������
	 */
	public String getEparcoding();

	

	/**
	 * �ʲ�ģ�ͷ���ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ�ͷ���
	 */
	public String getEcategory();

	/**
	 * �ʲ�ģ��һ������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ��һ������
	 */
	public String getEkey1();

	/**
	 * �ʲ�ģ�Ͷ�������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ�Ͷ�������
	 */
	public String getEkey2();

	/**
	 * �ʲ�ģ����������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ����������
	 */
	public String getEkey3();

	/**
	 * �ʲ�ģ�Ͳ���������������ȡ�� ��ƽ̨������
	 * @return �ʲ�ģ�Ͳ���������������
	 */
	public List<String> getEsyscodingList();
	
	/** �ʲ�ģ�������Ƿ���ʾ������ʶ 0����ʾ*/
	public String getType();
}
