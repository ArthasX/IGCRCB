/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sta.model.condition;

/**
  * ����: �������ļල���������ӿ�
  * ��������: �������ļල���������ӿ�
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public interface RiskCheckProblemSuperviseVWSearchCond {
	/**
	 * �������ȡ��
	 * @return prtitle �������
	 */
	public String getPrtitle() ;

	/**
	 * ��������ȡ��
	 * @return prdesc ��������
	 */
	public String getPrdesc() ;

	/**
	 * ���ⷢ��ʱ���ȡ��
	 * @return propentime_from ���ⷢ��ʱ���
	 */
	public String getPropentime_from() ;

	/**
	 * ���ⷢ��ʱ�䵽ȡ��
	 * @return propentime_to ���ⷢ��ʱ�䵽
	 */
	public String getPropentime_to() ;

	/**
	 * ����״̬ȡ��
	 * @return prstatus ����״̬
	 */
	public String getPrstatus() ;
	
	/**
	 * �����ѯ״̬ȡ��
	 * @return questionstatus �����ѯ״̬
	 */
	public String getQuestionstatus();
	
	/**
     * �������ȡ��
     *
     * @return category �������
     */
    public String getCategory();
    
	public String getRcclass();
	
	public String getRcsourse();
}