/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ����������������ʵ��
  * ��������: ����������������ʵ��
  * ������¼: 2012/07/17
  * �޸ļ�¼: 2012/08/09 ��CapacityObjectListSearchCondImpl������ΪSOC0423SearchCondImpl
  */
public class SOC0423SearchCondImpl implements
		SOC0423SearchCond {
	/**
	 * ����eq
	 */
	private String name;
	/**
	 * ����like 
	 */
	private String name_like;
	
	/**
	 * ��������
	 */
	private String objectType;
	
	/**
	 * ��������
	 */
	private String objectName;
	
	/**
	 * ��������ȡ��
	 * @return
	 */
	public String getObjectName() {
		return objectName;
	}

	/**
	 * ���������趨
	 * @param objectName
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	/**
	 * �޸�״̬ 0��δ�޸� 1�����޸�
	 */
	private Integer status;

	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	/**
	 * ����likeȡ��
	 *
	 * @return name_like ����like
	 */
	public String getName_like() {
		return name_like;
	}

	/**
	 * ����like�趨
	 *
	 * @param name_like ����like
	 */
	public void setName_like(String name_like) {
		this.name_like = name_like;
	}
}