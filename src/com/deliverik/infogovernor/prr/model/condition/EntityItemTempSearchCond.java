/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.condition;

/**
  * ����: ������ʱ�豸��Ϣ����������ӿ�
  * ��������: ������ʱ�豸��Ϣ����������ӿ�
  * ������¼: 2013/08/29
  * �޸ļ�¼: 
  */
public interface EntityItemTempSearchCond {
	/**
	 * ��Ӧ�ĺ�ͬ���ȡ��
	 *
	 * @return eitConNum ��Ӧ�ĺ�ͬ���
	 */
	public String getEitConNum();
	
	/**
	 * ����idȡ��
	 *
	 * @return prid ����id
	 */
	public Integer getPrid();
	
	/**
	 * �豸����ȡ��
	 *
	 * @return eitBClass �豸����
	 */
	public String getEitBClass();
	
//	/**
//	 * �豸С��ȡ��
//	 *
//	 * @return eitSClass �豸С��
//	 */
//	public String getEitSClass();
	
	/**
	 * �豸Ʒ��ȡ��
	 *
	 * @return eitBrand �豸Ʒ��
	 */
	public String getEitBrand();
	/** ��� -�����豸��������Ĳģ�����*/
	public  String getType();
	
}