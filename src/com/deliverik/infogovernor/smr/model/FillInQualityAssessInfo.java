/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model;

/**
 * ����:��������� 
 * �������������������
 * �����ˣ�����͢
 * ������¼�� 2012-12-21
 * �޸ļ�¼��
 */
public interface FillInQualityAssessInfo {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();
	
	/**
	 * �û�id���߲��Ż����� ȡ��
	 *
	 * @return �û�id���߲��Ż�����
	 */
	public String getPpuserid();
	
	/**
	 * �û������߲����� ȡ��
	 *
	 * @return �û������߲�����
	 */
	public String getUsername();
	
	/**
	 * �걨���id�������idȡ��
	 *
	 * @return �걨���id�������id
	 */
	public String getPpuserid1();
	
	/**
	 * �������id�������id ȡ��
	 *
	 * @return �������id�������id 
	 */
	public String getPpuserid2();
	
	/**
	 *�����ڱ����id�������id ȡ��
	 *
	 * @return �����ڱ����id�������id
	 */
	public String getPpuserid3();
	
	/**
	 *�걨�Ƿ�ʱ ȡ��
	 *
	 * @return �걨�Ƿ�ʱ
	 */
	public String getTimely1();
	
	/**
	 *�����Ƿ�ʱ ȡ��
	 *
	 * @return �����Ƿ�ʱ
	 */
	public String getTimely2();
	
	/**
	 *�����ڱ��Ƿ�ʱ ȡ��
	 *
	 * @return �����ڱ��Ƿ�ʱ
	 */
	public String getTimely3();
	
	public String getPporgid();
	
	public String getPporgname() ;
	
	public String getTruely1();
	
	public String getTruely2();
	
	public String getTruely3();
}
