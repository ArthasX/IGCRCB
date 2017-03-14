package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.asset.model.IG790Info;

/**
 * </p>
 * ��������ͳ�Ʒ���
 *</p>
 */
@SuppressWarnings("serial")
@Entity
//public class ComputerRoomAndContainerVW extends BaseEntity implements Serializable,
//		Cloneable, ComputerRoomAndContainerVWInfo {
public class IG790VW implements Serializable,
	Cloneable, IG790Info {	
	/** ����ID */
	protected String room_id;
	/** �������� */
	protected String room_name;
	/** ����ID */
	protected String container_id;
	/** �������� */
	protected String container_name;
	/** �ʲ�ģ��ID */
	protected String eid;
	/** �ʲ�ģ������ */
	protected String ename;
	/** �ʲ���� */
	@Id
	protected String eilabel;
	/** �ʲ��ڻ�����λ�� */
	protected String position;
	/** �ʲ��ͺ� */
	protected String model;
	
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public String getRoom_id() {
		return room_id;
	}
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */

	public String getRoom_name() {
		return room_name;
	}

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */

	public String getContainer_id() {
		return container_id;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */

	public String getContainer_name() {
		return container_name;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ����ȡ��
	 * @return �ʲ����
	 */

	public String getEilabel() {
		return eilabel;
	}
	
	/**
	 * �ʲ��ڻ�����λ��ȡ��
	 * @return �ʲ��ڻ�����λ��
	 */

	public String getPosition() {
		return position;
	}
	
	/**
	 * �ʲ��ͺ�ȡ��
	 * @return �ʲ��ͺ�
	 */
	
	public String getModel() {
		return model;
	}	

	/**
	 * ����ID�趨
	 *
	 * @param room_id ����ID
	 */

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	/**
	 * ���������趨
	 *
	 * @param room_name ��������
	 */

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	/**
	 * ����ID�趨
	 *
	 * @param container_id ����ID
	 */

	public void setContainer_id(String container_id) {
		this.container_id = container_id;
	}

	/**
	 * ���������趨
	 *
	 * @param container_name ��������
	 */

	public void setContainer_name(String container_name) {
		this.container_name = container_name;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */

	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ�ģ�������趨
	 *
	 * @param ename �ʲ�ģ������
	 */

	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * �ʲ�����趨
	 *
	 * @param eilabel �ʲ����
	 */

	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �ʲ��ڻ�����λ���趨
	 *
	 * @param position �ʲ��ڻ�����λ��
	 */

	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * �ʲ��ͺ��趨
	 *
	 * @param model �ʲ��ͺ�
	 */

	public void setModel(String model) {
		this.model = model;
	}



	public boolean equals(Object obj) {
		if (!(obj instanceof IG790VW))
			return false;
		IG790Info target = (IG790Info) obj;
		if (!(getEilabel() == target.getEilabel()))
			return false;

		return true;
	}

}
