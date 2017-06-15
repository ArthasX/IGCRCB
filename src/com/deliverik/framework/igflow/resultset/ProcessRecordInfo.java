/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ���̻�����Ϣ
 */
public interface ProcessRecordInfo {

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getPrid();
	
	/**
	 * ���̶�������ȡ��
	 * @return ���̶�������
	 */
	public String getPrpdname();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPrserialnum();

    /**
     * ����ʱ��ȡ��
     * @return ����ʱ��
     */
    public String getPropentime();

    /**
     * �ر�ʱ��ȡ��
     * @return �ر�ʱ��
     */
    public String getPrclosetime();

    /**
     * ��������ȡ��
     * @return ��������
     */
    public String getPrdesc();

    /**
     * ����״̬ȡ��
     * @return ����״̬
     */
    public String getPrstatus();

    /**
     * ��������ȡ��
     * @return ��������
     */
    public String getPrtitle();
    
    /**
     * ���ȼ�ȡ��
     * @return ���ȼ�
     */
    public String getPrPriority();

	/**
	 * ���̶���IDȡ��
	 * @return ���̶���ID
	 */
	public String getPrpdid();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getPrtype();
	
	/**
	 * �����ɫIDȡ��
	 * @return prroleid �����ɫID
	 */
	public Integer getPrroleid();

	/**
	 * �����û�IDȡ��
	 * @return pruserid �����û�ID
	 */
	public String getPruserid();
}
