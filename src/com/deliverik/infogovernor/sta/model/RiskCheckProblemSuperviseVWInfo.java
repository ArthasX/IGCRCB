/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sta.model;


/**
  * ����: ��������ͳ�ƽӿ�
  * ��������: ��������ͳ�ƽӿ�
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public interface RiskCheckProblemSuperviseVWInfo {
	/**
	 * ��������IDȡ��
	 * @return prid ��������ID
	 */
	public String getPrid() ;

	/**
	 * ���̶���Idȡ��
	 * @return prpdid ���̶���Id
	 */
	public String getPrpdid();
	
	/**
	 * ��������ȡ��
	 * @return prtitle ��������
	 */
	public String getPrtitle() ;

	/**
	 * ��������ȡ��
	 * @return prdesc ��������
	 */
	public String getPrdesc() ;

	/**
	 * ���̷�����idȡ��
	 * @return pruserid ���̷�����id
	 */
	public String getPruserid() ;

	/**
	 * ���̷���������ȡ��
	 * @return prusername ���̷���������
	 */
	public String getPrusername() ;

	/**
	 * ���ⷢ��ʱ��ȡ��
	 * @return propentime ���ⷢ��ʱ��
	 */
	public String getPropentime() ;
	/**
	 * �������ʱ��ȡ��
	 * @return prclosetime �������ʱ��
	 */
	public String getPrclosetime() ;
	/**
	 * ����״̬ȡ��
	 * @return prstatus ����״̬
	 */
	public String getPrstatus();
	/**
	 * ��������ȡ��
	 * @return riskprype ��������
	 */
	public String getRiskprype() ;

	/**
	 * ������Դȡ��
	 * @return problemsource ������Դ
	 */
	public String getProblemsource() ;

	

}