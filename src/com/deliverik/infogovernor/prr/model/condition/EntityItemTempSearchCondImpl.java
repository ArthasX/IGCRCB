/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.condition;

/**
  * ����: ������ʱ�豸��Ϣ���������ʵ��
  * ��������: ������ʱ�豸��Ϣ���������ʵ��
  * ������¼: 2013/08/29
  * �޸ļ�¼: 
  */
public class EntityItemTempSearchCondImpl implements
		EntityItemTempSearchCond {
	
	/** ��Ӧ�Ĳɹ���� */
	protected String eitConNum;
	
	/** �豸���� */
	protected String eitBClass;

//	/** �豸С�� */
//	protected String eitSClass;
	
	/** ����id */
	protected Integer prid;
	
	/** �豸Ʒ�� */
	protected String eitBrand;
	/** ��� */
	protected String type;
	/** ��������豸��������Ĳģ�����*/
	public  String getType() {
		return type;
	}
	/** ��� �����豸��������Ĳģ�����*/
	public  void setType(String type) {
		this.type = type;
	}

	/**
	 * �豸Ʒ��ȡ��
	 *
	 * @return eitBrand �豸Ʒ��
	 */
	public String getEitBrand() {
		return eitBrand;
	}

	/**
	 * �豸Ʒ���趨
	 *
	 * @param eitBrand �豸Ʒ��
	 */
	public void setEitBrand(String eitBrand) {
		this.eitBrand = eitBrand;
	}

	/**
	 * �豸����ȡ��
	 *
	 * @return eitBClass �豸����
	 */
	public String getEitBClass() {
		return eitBClass;
	}

	/**
	 * �豸�����趨
	 *
	 * @param eitBClass �豸����
	 */
	public void setEitBClass(String eitBClass) {
		this.eitBClass = eitBClass;
	}

//	/**
//	 * �豸С��ȡ��
//	 *
//	 * @return eitSClass �豸С��
//	 */
//	public String getEitSClass() {
//		return eitSClass;
//	}
//
//	/**
//	 * �豸С���趨
//	 *
//	 * @param eitSClass �豸С��
//	 */
//	public void setEitSClass(String eitSClass) {
//		this.eitSClass = eitSClass;
//	}

	/**
	 * ����idȡ��
	 *
	 * @return prid ����id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����id�趨
	 *
	 * @param prid ����id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��Ӧ�Ĳɹ����ȡ��
	 *
	 * @return eitConNum ��Ӧ�Ĳɹ����
	 */
	public String getEitConNum() {
		return eitConNum;
	}

	/**
	 * ��Ӧ�Ĳɹ�����趨
	 *
	 * @param eitConNum ��Ӧ�Ĳɹ����
	 */
	public void setEitConNum(String eitConNum) {
		this.eitConNum = eitConNum;
	}

	


}