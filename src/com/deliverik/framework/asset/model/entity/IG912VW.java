package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.asset.model.IG912Info;


/**
 * </p>
 * 设备资产视图信息实体
 *</p>
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "IG912")
@SuppressWarnings("serial")
//public class ComputerDeviceVW extends BaseEntity implements Serializable, ComputerDeviceVWInfo {
public class IG912VW implements Serializable, IG912Info {

	/** 设备资产ID */
	@Id
	protected int eiid;
	
	/** 设备资产模型ID */
	protected int eid;
	
	/** 设备资产名称 */
	protected String einame;
	
	/** 设备资产模型名称 */
	protected String ename;
	
	/** 设备资产编号 */
	protected String eilabel;
	
	/** 设备资产说明 */
	protected String eidesc;
	
	/** 设备资产版本号 */
	protected int eiversion;
	
	/** 登记日 */
	protected String eiinsdate;
	
	/** 设备资产位置（U） */
	protected String u_value;
	
	/** 设备资产高度（U） */
	protected String u_width;
	
	/** 设备资产型号 */
	protected String model;
	
	/** 所属机柜ID */
	protected Integer container_eiid;
	
	/** 所属机柜编号 */
	protected String container_eilabel;
	
	/** 所属机柜名 */
	protected String container_einame;
	
	/** 设备层次码 */
	protected String esyscoding;
	
	/** 是否是机房设备 */
	protected String inroomFlg;
	
	/** 设备状态 */
	protected String eistatus;
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return eiid;
	}

	/**
	 * 设备资产ID取得
	 * @return 设备资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 设备资产ID设定
	 *
	 * @param eiid 设备资产ID
	 */
	public void setEiid(int eiid) {
		this.eiid = eiid;
	}

	/**
	 * 设备资产模型ID取得
	 * @return 设备资产模型ID
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * 设备资产模型ID设定
	 *
	 * @param eid 设备资产模型ID
	 */
	public void setEid(int eid) {
		this.eid = eid;
	}

	/**
	 * 设备资产名称取得
	 * @return 设备资产名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 设备资产名称设定
	 *
	 * @param einame 设备资产名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 设备资产说明取得
	 * @return 设备资产说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 设备资产说明设定
	 *
	 * @param eidesc 设备资产说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 设备资产版本号取得
	 * @return 设备资产版本号
	 */
	public int getEiversion() {
		return eiversion;
	}

	/**
	 * 设备资产版本号设定
	 *
	 * @param eiversion 设备资产版本号
	 */
	public void setEiversion(int eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 设备资产编号取得
	 * @return 设备资产编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 设备资产编号设定
	 *
	 * @param eilabel 设备资产编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 登记日取得
	 * @return 登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 登记日设定
	 *
	 * @param eiinsdate 登记日
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * 设备资产位置（U）取得
	 * @return 设备资产位置（U）
	 */
	public String getU_value() {
		return u_value;
	}

	/**
	 * 设备资产位置（U）设定
	 *
	 * @param u_value 设备资产位置（U）
	 */
	public void setU_value(String u_value) {
		this.u_value = u_value;
	}

	/**
	 * 设备资产高度（U）取得
	 * @return 设备资产高度（U）
	 */
	public String getU_width() {
		return u_width;
	}

	/**
	 * 设备资产高度（U）设定
	 *
	 * @param u_width 设备资产高度（U）
	 */
	public void setU_width(String u_width) {
		this.u_width = u_width;
	}

	/**
	 * 所属机柜ID取得
	 * @return 所属机柜ID
	 */
	public int getContainer_eiid() {
		return container_eiid;
	}

	/**
	 * 所属机柜ID设定
	 *
	 * @param container_eiid 所属机柜ID
	 */
	public void setContainer_eiid(Integer container_eiid) {
		this.container_eiid = container_eiid;
	}

	/**
	 * 所属机柜编号取得
	 * @return 所属机柜编号
	 */
	public String getContainer_eilabel() {
		return container_eilabel;
	}

	/**
	 * 所属机柜编号设定
	 *
	 * @param container_eilabel 所属机柜编号
	 */
	public void setContainer_eilabel(String container_eilabel) {
		this.container_eilabel = container_eilabel;
	}

	/**
	 * 所属机柜名取得
	 * @return 所属机柜名
	 */
	public String getContainer_einame() {
		return container_einame;
	}

	/**
	 * 所属机柜名设定
	 *
	 * @param container_einame 所属机柜名
	 */
	public void setContainer_einame(String container_einame) {
		this.container_einame = container_einame;
	}

	/**
	 * 设备资产模型名称取得
	 * @return 设备资产模型名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 设备资产模型名称设定
	 *
	 * @param ename 设备资产模型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 设备资产型号取得
	 * @return 设备资产型号
	 */
	public String getModel() {
		return model;
	}

	/**
	 * 设备资产型号设定
	 *
	 * @param model 设备资产型号
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * 设备层次码取得
	 * @return 设备层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 设备层次码设定
	 *
	 * @param esyscoding 设备层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 是否是机房设备标志位取得
	 * @return 是否是机房设备标志位
	 */
	public String getInroomFlg() {
		return inroomFlg;
	}
	
	/**
	 * 是否是机房设备标志位设定
	 *
	 * @param esyscoding 是否是机房设备标志位
	 */
	public void setInroomFlg(String inroomFlg) {
		this.inroomFlg = inroomFlg;
	}

	/**
	 * @return 设备状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * @param 设备状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}
	
}
