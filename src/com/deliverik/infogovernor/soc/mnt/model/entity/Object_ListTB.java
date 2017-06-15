/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;

/**
  * ����: ���󼯺ϱ�ʵ��
  * ��������: ���󼯺ϱ�ʵ��
  * ������¼: 2012/05/11
  * �޸ļ�¼: 
  */
@Entity
@IdClass(Object_ListPK.class)
@Table(name="collect_Object_List", schema="cst")
public class Object_ListTB implements Object_ListInfo {

	@Id
	/** ���к� */
	protected String dataId;
	@Id
	/** ������� */
	protected String object_Type;
	@Id
	/** �������� */
	protected String object_Name;

	/**
	 * ���к�ȡ��
	 *
	 * @return ���к�
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
	 * @return �������
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

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getObject_Name() {
		return object_Name;
	}

	/**
	 * ���������趨
	 *
	 * @param object_Name ��������
	 */
	public void setObject_Name(String object_Name) {
		this.object_Name = object_Name;
	}




}