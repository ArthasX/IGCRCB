/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;


/**
 * ����: ���󼯺�ʵ������
 * ��������: ���󼯺�ʵ������
 * ������¼: 2011/05/24
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class Object_ListPK extends BasePK implements Serializable{
	
	/** ���к� */
	protected String dataId;
	/** ������� */
	protected String object_Type;
	
	/** �������� */
	protected String object_Name;
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
	/**
	 * ��������ȡ��
	 *
	 * @return object_Name ��������
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
