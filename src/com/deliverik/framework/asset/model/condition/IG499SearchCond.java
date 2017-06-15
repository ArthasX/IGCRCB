/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: ��ͬ�ʲ���Ϣ��ͼ���������ӿ�
  * ��������: ��ͬ�ʲ���Ϣ��ͼ���������ӿ�
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
public interface IG499SearchCond {
	/**
	 * ��ͬ���ȡ��
	 * @return ��ͬ���
	 */
	public String getCompacttype();


	/**
	 * ǩ��ʱ��ȡ��
	 * @return ǩ��ʱ��
	 */
	public String getCondudetime();


	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getFacilitator();


	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getOperator();


	/**
	 * ��ͬ����ȡ��
	 * @return ��ͬ����
	 */
	public String getEiname();


	/**
	 * ��ͬ���ȡ��
	 * @return ��ͬ���
	 */
	public String getEilabel();


	/**
	 * ��ѯʱ���ȡ��
	 * @return ��ѯʱ���
	 */
	public String getDatetime();

	/**
	 * ǩ��ʱ��:��ȡ��
	 * @return ǩ��ʱ��:��
	 */
	public String getCondudetime_from();

	/**
	 * ǩ��ʱ��:��ȡ��
	 * @return ǩ��ʱ��:��
	 */
	public String getCondudetime_to();
	
	/**
	 * ��ͬeiid
	 * @return
	 */
	public String getEiid();

	/**
	 * �Ƿ񸶿����ȡ��
	 * @return
	 */
	public String getPayed();
	
	/**
	 * �����������ȡ
	 * @return eiorgsyscoding_in
	 */
	public String getEiorgsyscoding_in();

	/**
	 * �����������趨
	 * @param eiorgsyscoding_in
	 */
	public void setEiorgsyscoding_in(String eiorgsyscoding_in);
	
	/**
	 * eiusernameȡ��
	 *
	 * @return eiusername eiusername
	 */
	public String getEiusername();
	
	/**
     * �ʲ�ģ����ȡ��
     *
     * @return ename �ʲ�ģ����
     */
    public String getEname();

    /**
     * �ʲ�������ģ��ȡ��
     *
     * @return esyscoding �ʲ�������ģ��
     */
    public String getEsyscoding();
}