package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.soc.asset.model.SOC0601Info;


/**
 * </p>
 * 机房视图信息实体
 *</p>
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "SOC0601")
@SuppressWarnings("serial")
//public class ComputerRoomVW extends BaseEntity implements Serializable, Cloneable, ComputerRoomVWInfo {
public class SOC0601VW implements Serializable, Cloneable, SOC0601Info {

	/** 机房ID */
	@Id
	protected Integer eiid;
	
	/** 资产模型ID */
	protected String eid;
	
	/** 机房名称 */
	protected String einame;
	
	/** 机房编码 */
	protected String eilabel;
	
	/** 机房说明 */
	protected String eidesc;
	
	/** 机房版本号 */
	protected Integer eiversion;
	
	/** 登记日 */
	protected String eiinsdate;
	
	/** 横向位置坐标长 */
	protected String x_total;
	
	/** 纵向位置坐标长 */
	protected String y_total;
	
	/** 负责人 */
	protected String manager;
	
	/** 联系电话 */
	protected String tel;
	
	/** 关联机房ID */
	protected String relateroom;
	
	/** 关联地板块X */
	protected String relatex;
	
	/** 关联地板块Y */
	protected String relatey;

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return eiid;
	}

	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 机房ID设定
	 *
	 * @param eiid 机房ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid() {
		return eid;
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
	 * 机房名称取得
	 * @return 机房名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 机房名称设定
	 *
	 * @param einame 机房名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 机房说明取得
	 * @return 机房说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 机房说明设定
	 *
	 * @param eidesc 机房说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 机房编号取得
	 * @return 机房编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 机房编号设定
	 *
	 * @param eilabel 机房编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 机房版本号取得
	 * @return 机房版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 机房版本号设定
	 *
	 * @param eiversion 机房版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
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
	 * 横向位置坐标轴长取得
	 * @return 横向位置坐标轴长
	 */
	public String getX_total() {
		return x_total;
	}

	/**
	 * 横向位置坐标轴长设定
	 *
	 * @param x_total 横向位置坐标轴长
	 */
	public void setX_total(String x_total) {
		this.x_total = x_total;
	}

	/**
	 * 纵向位置坐标轴长取得
	 * @return 纵向位置坐标轴长
	 */
	public String getY_total() {
		return y_total;
	}

	/**
	 * 纵向位置坐标轴长设定
	 *
	 * @param y_total 纵向位置坐标轴长
	 */
	public void setY_total(String y_total) {
		this.y_total = y_total;
	}

	/**
	 * 负责人取得
	 * @return 负责人
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * 负责人设定
	 *
	 * @param manager 负责人
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * 联系电话取得
	 * @return 联系电话
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 联系电话设定
	 *
	 * @param tel 联系电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRelateroom() {
		return relateroom;
	}

	public void setRelateroom(String relateroom) {
		this.relateroom = relateroom;
	}

	public String getRelatex() {
		return relatex;
	}

	public void setRelatex(String relatex) {
		this.relatex = relatex;
	}

	public String getRelatey() {
		return relatey;
	}

	public void setRelatey(String relatey) {
		this.relatey = relatey;
	}

}
