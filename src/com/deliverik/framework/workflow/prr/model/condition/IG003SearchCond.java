/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>����:������Ȼ���ͳ�Ʋ�ѯ�����ӿ�</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public interface IG003SearchCond {
	
	/**
	 * ���ܣ���ȡ��ǰ���
	 * @return currentyear
	 */
	public String getCurrentyear();
	
	/**
	 * ���ܣ���ȡ��һ�����
	 * @return precedingyear
	 */
	public String getPrecedingyear();
	
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
