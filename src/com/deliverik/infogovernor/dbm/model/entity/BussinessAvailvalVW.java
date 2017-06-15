/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.dbm.model.BussinessAvailval;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 业务系统可用性显示
 * </p>
 * 
 * @version 1.0
 */
@Entity
public class BussinessAvailvalVW implements Serializable, Cloneable, BussinessAvailval {

	private static final long serialVersionUID = 1L;
	/**业务系统名称 */
	@Id
	protected String gname;
	
	/** 可用性*/
	protected String availval;

	
	public Serializable getPK() {
		return this.gname;
	}


	/**
	 * gname取得
	 *
	 * @return gname gname
	 */
	public String getGname() {
		return gname;
	}


	/**
	 * availval取得
	 *
	 * @return availval availval
	 */
	public String getAvailval() {
		return availval;
	}


	/**
	 * gname设定
	 *
	 * @param gname gname
	 */
	public void setGname(String gname) {
		this.gname = gname;
	}


	/**
	 * availval设定
	 *
	 * @param availval availval
	 */
	public void setAvailval(String availval) {
		this.availval = availval;
	}



}
