/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.condition;

/**
 * ����: �ճ�ά����ѯ�����ӿ�
 * ��������: �ճ�ά����ѯ�����ӿ�
 * ������¼: 2012/04/01
 * �޸ļ�¼: 
 */
public interface OnDutyPersonRecordSearchCond{
	
	/**
	 * �ؼ���ȡ��
	 * @return the keywords_like
	 */
	public String getKeywords_like();
	
	
    /**
     * ��������ѯȡ��
     *
     * @return odprid_eq ��������ѯ
     */
    public Integer getOdprid_eq();
    
    /**
     * ʱ���������� ȡ��
     * @return ʱ����������
     */
	public String getOdprctime_ge();

	/**
	 * ʱ����������ȡ��
	 * @return ʱ����������
	 */
	public String getOdprctime_le();

}
