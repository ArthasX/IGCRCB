/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.smr.model.ReportDetailVWInfo;


/**
  * ����: ��ر�����ϸҳ��ͼ
  * ��������: ��ر�����ϸҳ��ͼ
  * ������¼: 2013/09/04
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
public class ReportDetailVW implements Serializable,
		Cloneable, ReportDetailVWInfo {
	
	/** ����ID */
	@Id
	protected Integer id;
	
	/** �û�ID */
	protected String userid;

	/** �û����� */
	protected String username;

	/** ����ID */
	protected String orgid;

	/** ����(�걨) */
	protected String name_y;

	/** �Ƿ�ʱ���걨��0-��ʱ 1-����ʱ */
	protected String ontime_y;
	
	/** �Ƿ�׼ȷ���걨������1��׼ȷ */
	protected String con_y;
	
	/** ����(����) */
	protected String name_m;

	/** �Ƿ�ʱ��������0-��ʱ 1-����ʱ */
	protected String ontime_m;
	
	/** �Ƿ�׼ȷ������������1��׼ȷ */
	protected String con_m;
	
	/** ����(������) */
	protected String name_z;

	/** �Ƿ�ʱ�������ڣ�0-��ʱ 1-����ʱ */
	protected String ontime_z;
	
	/** �Ƿ�׼ȷ�������ڣ�����1��׼ȷ */
	protected String con_z;


	
	
	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * ����ID�趨
	 *
	 * @param id ����ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 *
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * �û�����ȡ��
	 *
	 * @return �û�����
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �û������趨
	 *
	 * @param username �û�����
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param orgid ����ID
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ���ƣ��걨��ȡ��
	 *
	 * @return ���ƣ��걨��
	 */
	public String getName_y() {
		return name_y;
	}

	/**
	 * ���ƣ��걨���趨
	 *
	 * @param name_y ���ƣ��걨��
	 */
	public void setName_y(String name_y) {
		this.name_y = name_y;
	}

	/**
	 * �Ƿ�ʱ���걨��0-��ʱ 1-����ʱ ȡ��
	 *
	 * @return �Ƿ�ʱ���걨��0-��ʱ 1-����ʱ
	 */
	public String getOntime_y() {
		return ontime_y;
	}

	/**
	 * �Ƿ�ʱ���걨��0-��ʱ 1-����ʱ �趨
	 *
	 * @param ontime_y �Ƿ�ʱ���걨��0-��ʱ 1-����ʱ
	 */
	public void setOntime_y(String ontime_y) {
		this.ontime_y = ontime_y;
	}

	/**
	 * �Ƿ�׼ȷ���걨������1��׼ȷ ȡ��
	 *
	 * @return �Ƿ�׼ȷ���걨������1��׼ȷ
	 */
	public String getCon_y() {
		return con_y;
	}

	/**
	 * �Ƿ�׼ȷ���걨������1��׼ȷ �趨
	 *
	 * @param con_y �Ƿ�׼ȷ���걨������1��׼ȷ
	 */
	public void setCon_y(String con_y) {
		this.con_y = con_y;
	}

	/**
	 * ���ƣ�������ȡ��
	 *
	 * @return ���ƣ�������
	 */
	public String getName_m() {
		return name_m;
	}

	/**
	 * ���ƣ��������趨
	 *
	 * @param name_m ���ƣ�������
	 */
	public void setName_m(String name_m) {
		this.name_m = name_m;
	}

	/**
	 * �Ƿ�ʱ��������0-��ʱ 1-����ʱ ȡ��
	 *
	 * @return �Ƿ�ʱ��������0-��ʱ 1-����ʱ
	 */
	public String getOntime_m() {
		return ontime_m;
	}

	/**
	 * �Ƿ�ʱ��������0-��ʱ 1-����ʱ �趨
	 *
	 * @param ontime_m �Ƿ�ʱ��������0-��ʱ 1-����ʱ
	 */
	public void setOntime_m(String ontime_m) {
		this.ontime_m = ontime_m;
	}

	/**
	 * �Ƿ�׼ȷ������������1��׼ȷ ȡ��
	 *
	 * @return �Ƿ�׼ȷ������������1��׼ȷ
	 */
	public String getCon_m() {
		return con_m;
	}

	/**
	 * �Ƿ�׼ȷ������������1��׼ȷ �趨
	 *
	 * @param con_m �Ƿ�׼ȷ������������1��׼ȷ
	 */
	public void setCon_m(String con_m) {
		this.con_m = con_m;
	}

	/**
	 * ���ƣ������ڣ�ȡ��
	 *
	 * @return ���ƣ������ڣ�
	 */
	public String getName_z() {
		return name_z;
	}

	/**
	 * ���ƣ������ڣ��趨
	 *
	 * @param name_z ���ƣ������ڣ�
	 */
	public void setName_z(String name_z) {
		this.name_z = name_z;
	}

	/**
	 * �Ƿ�ʱ�������ڣ�0-��ʱ 1-����ʱ ȡ��
	 *
	 * @return �Ƿ�ʱ�������ڣ�0-��ʱ 1-����ʱ
	 */
	public String getOntime_z() {
		return ontime_z;
	}

	/**
	 * �Ƿ�ʱ�������ڣ�0-��ʱ 1-����ʱ �趨
	 *
	 * @param ontime_z �Ƿ�ʱ�������ڣ�0-��ʱ 1-����ʱ
	 */
	public void setOntime_z(String ontime_z) {
		this.ontime_z = ontime_z;
	}

	/**
	 * �Ƿ�׼ȷ�������ڣ�����1��׼ȷ ȡ��
	 *
	 * @return �Ƿ�׼ȷ�������ڣ�����1��׼ȷ
	 */
	public String getCon_z() {
		return con_z;
	}

	/**
	 * �Ƿ�׼ȷ�������ڣ�����1��׼ȷ �趨
	 *
	 * @param con_z �Ƿ�׼ȷ�������ڣ�����1��׼ȷ
	 */
	public void setCon_z(String con_z) {
		this.con_z = con_z;
	}

}
