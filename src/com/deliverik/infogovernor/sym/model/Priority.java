/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.model;
/**
 * ����:ʵ��ӿ�
 * �������������ȼ�priority�ӿ�
 * ������¼��fangyunlong@deliverik.com    2010/12/14
 */
public interface Priority {

	/***
	 * ���ȼ�KEY
	 */
	public String getPvalue() ;

	/***
	 * �����̶�KEY
	 */
	public String getUvalue() ;

	/***
	 * Ӱ���KEY	
	 */
	public String getIvalue() ;
	/***
	 * ��Ӧ��������
	 */
	public String getPprtype();
}
