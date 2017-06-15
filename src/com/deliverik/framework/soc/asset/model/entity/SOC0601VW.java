package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.soc.asset.model.SOC0601Info;


/**
 * </p>
 * ������ͼ��Ϣʵ��
 *</p>
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "SOC0601")
@SuppressWarnings("serial")
//public class ComputerRoomVW extends BaseEntity implements Serializable, Cloneable, ComputerRoomVWInfo {
public class SOC0601VW implements Serializable, Cloneable, SOC0601Info {

	/** ����ID */
	@Id
	protected Integer eiid;
	
	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �������� */
	protected String einame;
	
	/** �������� */
	protected String eilabel;
	
	/** ����˵�� */
	protected String eidesc;
	
	/** �����汾�� */
	protected Integer eiversion;
	
	/** �Ǽ��� */
	protected String eiinsdate;
	
	/** ����λ�����곤 */
	protected String x_total;
	
	/** ����λ�����곤 */
	protected String y_total;
	
	/** ������ */
	protected String manager;
	
	/** ��ϵ�绰 */
	protected String tel;
	
	/** ��������ID */
	protected String relateroom;
	
	/** �����ذ��X */
	protected String relatex;
	
	/** �����ذ��Y */
	protected String relatey;

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return eiid;
	}

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param eiid ����ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		return eid;
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
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ���������趨
	 *
	 * @param einame ��������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ����˵��ȡ��
	 * @return ����˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * ����˵���趨
	 *
	 * @param eidesc ����˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ��������趨
	 *
	 * @param eilabel �������
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �����汾��ȡ��
	 * @return �����汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �����汾���趨
	 *
	 * @param eiversion �����汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �Ǽ���ȡ��
	 * @return �Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �Ǽ����趨
	 *
	 * @param eiinsdate �Ǽ���
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * ����λ�������᳤ȡ��
	 * @return ����λ�������᳤
	 */
	public String getX_total() {
		return x_total;
	}

	/**
	 * ����λ�������᳤�趨
	 *
	 * @param x_total ����λ�������᳤
	 */
	public void setX_total(String x_total) {
		this.x_total = x_total;
	}

	/**
	 * ����λ�������᳤ȡ��
	 * @return ����λ�������᳤
	 */
	public String getY_total() {
		return y_total;
	}

	/**
	 * ����λ�������᳤�趨
	 *
	 * @param y_total ����λ�������᳤
	 */
	public void setY_total(String y_total) {
		this.y_total = y_total;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * �������趨
	 *
	 * @param manager ������
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * ��ϵ�绰ȡ��
	 * @return ��ϵ�绰
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * ��ϵ�绰�趨
	 *
	 * @param tel ��ϵ�绰
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
