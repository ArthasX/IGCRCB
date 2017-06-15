/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * ����: SOC0117VW���������ӿ�
  * ��������: SOC0117VW���������ӿ�
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
public interface SOC0117VWSearchCond {

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

	/**
	 * �ʲ�ģ��ID likeȡ��
	 * @return �ʲ�ģ��ID like
	 */
	public String getEidStr_like();
	/**
	 * @return the ���ݿ�id
	 */
	public Integer getId();
}