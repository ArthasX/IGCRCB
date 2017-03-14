package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.asset.model.IG790Info;

/**
 * </p>
 * 机房机柜统计分析
 *</p>
 */
@SuppressWarnings("serial")
@Entity
//public class ComputerRoomAndContainerVW extends BaseEntity implements Serializable,
//		Cloneable, ComputerRoomAndContainerVWInfo {
public class IG790VW implements Serializable,
	Cloneable, IG790Info {	
	/** 机房ID */
	protected String room_id;
	/** 机房名称 */
	protected String room_name;
	/** 机柜ID */
	protected String container_id;
	/** 机柜名称 */
	protected String container_name;
	/** 资产模型ID */
	protected String eid;
	/** 资产模型名称 */
	protected String ename;
	/** 资产编号 */
	@Id
	protected String eilabel;
	/** 资产在机柜中位置 */
	protected String position;
	/** 资产型号 */
	protected String model;
	
	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public String getRoom_id() {
		return room_id;
	}
	
	/**
	 * 机房名称取得
	 * @return 机房名称
	 */

	public String getRoom_name() {
		return room_name;
	}

	/**
	 * 机柜ID取得
	 * @return 机柜ID
	 */

	public String getContainer_id() {
		return container_id;
	}

	/**
	 * 机柜名称取得
	 * @return 机柜名称
	 */

	public String getContainer_name() {
		return container_name;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	
	public String getEname() {
		return ename;
	}

	/**
	 * 资产编号取得
	 * @return 资产编号
	 */

	public String getEilabel() {
		return eilabel;
	}
	
	/**
	 * 资产在机柜中位置取得
	 * @return 资产在机柜中位置
	 */

	public String getPosition() {
		return position;
	}
	
	/**
	 * 资产型号取得
	 * @return 资产型号
	 */
	
	public String getModel() {
		return model;
	}	

	/**
	 * 机房ID设定
	 *
	 * @param room_id 机房ID
	 */

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	/**
	 * 机房名称设定
	 *
	 * @param room_name 机房名称
	 */

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	/**
	 * 机柜ID设定
	 *
	 * @param container_id 机柜ID
	 */

	public void setContainer_id(String container_id) {
		this.container_id = container_id;
	}

	/**
	 * 机柜名称设定
	 *
	 * @param container_name 机柜名称
	 */

	public void setContainer_name(String container_name) {
		this.container_name = container_name;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */

	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 资产模型名称设定
	 *
	 * @param ename 资产模型名称
	 */

	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 资产编号设定
	 *
	 * @param eilabel 资产编号
	 */

	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 资产在机柜中位置设定
	 *
	 * @param position 资产在机柜中位置
	 */

	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * 资产型号设定
	 *
	 * @param model 资产型号
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
