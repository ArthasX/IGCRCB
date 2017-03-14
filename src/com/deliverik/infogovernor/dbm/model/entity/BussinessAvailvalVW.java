/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.dbm.model.BussinessAvailval;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ҵ��ϵͳ��������ʾ
 * </p>
 * 
 * @version 1.0
 */
@Entity
public class BussinessAvailvalVW implements Serializable, Cloneable, BussinessAvailval {

	private static final long serialVersionUID = 1L;
	/**ҵ��ϵͳ���� */
	@Id
	protected String gname;
	
	/** ������*/
	protected String availval;

	
	public Serializable getPK() {
		return this.gname;
	}


	/**
	 * gnameȡ��
	 *
	 * @return gname gname
	 */
	public String getGname() {
		return gname;
	}


	/**
	 * availvalȡ��
	 *
	 * @return availval availval
	 */
	public String getAvailval() {
		return availval;
	}


	/**
	 * gname�趨
	 *
	 * @param gname gname
	 */
	public void setGname(String gname) {
		this.gname = gname;
	}


	/**
	 * availval�趨
	 *
	 * @param availval availval
	 */
	public void setAvailval(String availval) {
		this.availval = availval;
	}



}
