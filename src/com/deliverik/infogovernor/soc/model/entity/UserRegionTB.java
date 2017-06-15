/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: UserRegionʵ�� ��������: UserRegionʵ�� ������¼: 2014/01/10 �޸ļ�¼:
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
	 * IDȡ��
	 * 
	 * @return ID
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * ID�趨
	 * 
	 * @param ID
	 *            ID
	 */
	public void setID(Integer ID) {
		this.ID = ID;
	}

	/**
	 * flexIDȡ��
	 * 
	 * @return flexID
	 */
	public String getFlexID() {
		return flexID;
	}

	/**
	 * flexID�趨
	 * 
	 * @param flexID
	 *            flexID
	 */
	public void setFlexID(String flexID) {
		this.flexID = flexID;
	}

	/**
	 * UserIDȡ��
	 * 
	 * @return UserID
	 */
	public String getUserID() {
		return UserID;
	}

	/**
	 * UserID�趨
	 * 
	 * @param UserID
	 *            UserID
	 */
	public void setUserID(String UserID) {
		this.UserID = UserID;
	}

	/**
	 * xȡ��
	 * 
	 * @return x
	 */
	public String getX() {
		return x;
	}

	/**
	 * x�趨
	 * 
	 * @param x
	 *            x
	 */
	public void setX(String x) {
		this.x = x;
	}

	/**
	 * yȡ��
	 * 
	 * @return y
	 */
	public String getY() {
		return y;
	}

	/**
	 * y�趨
	 * 
	 * @param y
	 *            y
	 */
	public void setY(String y) {
		this.y = y;
	}

	/**
	 * widthȡ��
	 * 
	 * @return width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * width�趨
	 * 
	 * @param width
	 *            width
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * heightȡ��
	 * 
	 * @return height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * height�趨
	 * 
	 * @param height
	 *            height
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * titleȡ��
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * title�趨
	 * 
	 * @param title
	 *            title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Serializable getPK() {
		return ID;
	}

}