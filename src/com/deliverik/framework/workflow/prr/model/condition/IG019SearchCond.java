/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>����:�¼��ͷ����������̻���ͳ�Ʋ�ѯ�����ӿ�</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public interface IG019SearchCond {
	
	/**
	 * ���ܣ����������ȡ��
	 * @retrun Orgsyscoding �����㼶��
	 */
	public String getOrgsyscoding();
	
	/**
	 * ���ܣ����ȡ��
	 * @return year ���
	 */
	public String getYear();
	
	/**
	 * ���ܣ���������ȡ��
	 * @return prtype ��������
	 */
	public String getPrtype();
	
	  /**
     * �¼�ͳ��ģ��idȡ��
     *
     * @return ipdid �¼�ͳ��ģ��id
     */
    public String getIpdid();
    
    /**
     * ����ͳ��ģ��idȡ��
     *
     * @return ppdid ����ͳ��ģ��id
     */
    public String getPpdid();
    
    /**
     * ���ͳ��ģ��idȡ��
     *
     * @return cpdid ���ͳ��ģ��id
     */
    public String getCpdid();
    /**
     * ��������ͳ��ģ��idȡ��
     *
     * @return spdid ��������ͳ��ģ��id
     */
    public String getSpdid();

}
