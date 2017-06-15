/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.room.model.condition;


/**
  * ����: compareTemplate���������ӿ�
  * ��������: compareTemplate���������ӿ�
  * ������¼: 2011/05/23
  * �޸ļ�¼: 
  */
public interface CompareTemplateSearchCond {

	/**
	 * ���IDȡ��
	 *
	 * @return ���ID
	 */
	public String getCategory();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getType();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getXwidth();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getYwidth();

	/**
	 * ֵȡ��
	 *
	 * @return ֵ
	 */
	public String getValue();
	
	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getCabtype();
	
	/**
	 * ͼ������ȡ��
	 *
	 * @return ͼ������
	 */
	public String[] getLegendArray();

	/**
	 * cteiidȡ��
	 *
	 * @return cteiid cteiid
	 */
	public String getCteiid();
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCtid();
	/**
	 * netypeȡ��
	 *
	 * @return netype netype
	 */
	public String getNetype();
	/**
	 * ctZoneIdȡ��
	 *
	 * @return ctZoneId ctZoneId
	 */
	public String getCtZoneId();
	/**
	 * type��Ϊzone��naf��ʶ ȡ��
	 *
	 * @return notZoneAndNotNafFlag
	 */
	public String getNotZoneAndNotNafFlag();
	
	public String getCtfloorx();
	
	public String getCtfloory();
}