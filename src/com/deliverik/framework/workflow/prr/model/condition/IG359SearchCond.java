/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>����:����ʲ�����ͳ�ƻ���ͳ�Ʋ�ѯ�����ӿ�</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public interface IG359SearchCond {

	/**
	 * ���ܣ�����ʲ����̱���ȡ��
	 * @return prassetcategory ����ʲ����̱���
	 */
	public String getPrassetcategory();
	
	/**
	 * ���ܣ�ͳ�Ʋ�ѯʱ��_��ȡ��
	 * @return propentime_to ͳ�Ʋ�ѯʱ��_��
	 */
	public String getPropentime_to();
	
	/**
	 * ���ܣ�ͳ�Ʋ�ѯʱ��_��ȡ��
	 * @return propentime_from
	 */
	public String getPropentime_from();
	
	

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
