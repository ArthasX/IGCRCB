/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: ʵ����·ͼ���������ӿ�
  * ��������: ʵ����·ͼ���������ӿ�
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
public interface EiLinkMapSearchCond {
	
	/**
	 * ��IDȡ��
	 * 
	 * @return ��ID
	 */
	public Integer getDomainid_eq();

	/**
	 * ��汾ȡ��
	 * 
	 * @return ��汾
	 */
	public Integer getDomainversion_eq();

	/**
	 * �ʲ�IDȡ��
	 * 
	 * @return �ʲ�ID
	 */
	public Integer getEiid_eq();

	/**
	 * ����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getCreatetime_eq();
	
	/**
	 * ��ͼ���ȡ��
	 * 
	 * @return ��ͼ���
	 */
	public String getLinkflag_eq();
	
	/**
	 * �ʲ������ȡ��
	 *
	 * @return �ʲ������
	 */
	public String getEsyscoding_eq();
	/**
	 * otherEiidȡ��
	 *
	 * @return otherEiid otherEiid
	 */
	public Integer getOtherEiid();

}