/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.model.UserRegionInfo;

/**
 * 概述: UserRegion实体 功能描述: UserRegion实体 创建记录: 2014/01/10 修改记录:
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "UserRegion", schema = "ig")
public class UserRegionTB extends BaseEntity implements Serializable,
		Cloneable, UserRegionInfo {

	/** ID */
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "UserRegion_seq") })
	protected Integer ID;

	/** flexID */
	protected String flexID;

	/** UserID */
	protected String UserID;

	/** x */
	protected String x;

	/** y */
	protected String y;

	/** width */
	protected String width;

	/** height */
	protected String height;

	/** title */
	protected String title;

	/**
	 * ID取得
	 * 
	 * @return ID
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * ID设定
	 * 
	 * @param ID
	 *            ID
	 */
	public void setID(Integer ID) {
		this.ID = ID;
	}

	/**
	 * flexID取得
	 * 
	 * @return flexID
	 */
	public String getFlexID() {
		return flexID;
	}

	/**
	 * flexID设定
	 * 
	 * @param flexID
	 *            flexID
	 */
	public void setFlexID(String flexID) {
		this.flexID = flexID;
	}

	/**
	 * UserID取得
	 * 
	 * @return UserID
	 */
	public String getUserID() {
		return UserID;
	}

	/**
	 * UserID设定
	 * 
	 * @param UserID
	 *            UserID
	 */
	public void setUserID(String UserID) {
		this.UserID = UserID;
	}

	/**
	 * x取得
	 * 
	 * @return x
	 */
	public String getX() {
		return x;
	}

	/**
	 * x设定
	 * 
	 * @param x
	 *            x
	 */
	public void setX(String x) {
		this.x = x;
	}

	/**
	 * y取得
	 * 
	 * @return y
	 */
	public String getY() {
		return y;
	}

	/**
	 * y设定
	 * 
	 * @param y
	 *            y
	 */
	public void setY(String y) {
		this.y = y;
	}

	/**
	 * width取得
	 * 
	 * @return width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * width设定
	 * 
	 * @param width
	 *            width
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * height取得
	 * 
	 * @return height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * height设定
	 * 
	 * @param height
	 *            height
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * title取得
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * title设定
	 * 
	 * @param title
	 *            title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public Serializable getPK() {
		return ID;
	}

}