/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * ����: SOC0109VW���������ӿ�
  * ��������: SOC0109VW���������ӿ�
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
public interface SOC0109VWSearchCond {
	public Integer getId() ;
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