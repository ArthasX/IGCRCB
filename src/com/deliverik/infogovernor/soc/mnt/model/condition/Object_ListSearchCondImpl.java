/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * ����: ���󼯺ϱ��������ʵ��
  * ��������: ���󼯺ϱ��������ʵ��
  * ������¼: 2012/05/11
  * �޸ļ�¼: 
  */
public class Object_ListSearchCondImpl implements
		Object_ListSearchCond {
	/** ���к� */
	protected String dataId;

	/** ������� */
	protected String object_Type;

	/**
	 * ���к�ȡ��
	 *
	 * @return dataId ���к�
	 */
	public String getDataId() {
		return dataId;
	}

	/**
	 * ���к��趨
	 *
	 * @param dataId ���к�
	 */
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	/**
	 * �������ȡ��
	 *
	 * @return object_Type �������
	 */
	public String getObject_Type() {
		return object_Type;
	}

	/**
	 * ��������趨
	 *
	 * @param object_Type �������
	 */
	public void setObject_Type(String object_Type) {
		this.object_Type = object_Type;
	}
	
	
}