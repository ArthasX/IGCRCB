package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.asset.model.IG912Info;


/**
 * </p>
 * �豸�ʲ���ͼ��Ϣʵ��
 *</p>
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "IG912")
@SuppressWarnings("serial")
//public class ComputerDeviceVW extends BaseEntity implements Serializable, ComputerDeviceVWInfo {
public class IG912VW implements Serializable, IG912Info {

	/** �豸�ʲ�ID */
	@Id
	protected int eiid;
	
	/** �豸�ʲ�ģ��ID */
	protected int eid;
	
	/** �豸�ʲ����� */
	protected String einame;
	
	/** �豸�ʲ�ģ������ */
	protected String ename;
	
	/** �豸�ʲ���� */
	protected String eilabel;
	
	/** �豸�ʲ�˵�� */
	protected String eidesc;
	
	/** �豸�ʲ��汾�� */
	protected int eiversion;
	
	/** �Ǽ��� */
	protected String eiinsdate;
	
	/** �豸�ʲ�λ�ã�U�� */
	protected String u_value;
	
	/** �豸�ʲ��߶ȣ�U�� */
	protected String u_width;
	
	/** �豸�ʲ��ͺ� */
	protected String model;
	
	/** ��������ID */
	protected Integer container_eiid;
	
	/** ���������� */
	protected String container_eilabel;
	
	/** ���������� */
	protected String container_einame;
	
	/** �豸����� */
	protected String esyscoding;
	
	/** �Ƿ��ǻ����豸 */
	protected String inroomFlg;
	
	/** �豸״̬ */
	protected String eistatus;
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return eiid;
	}

	/**
	 * �豸�ʲ�IDȡ��
	 * @return �豸�ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �豸�ʲ�ID�趨
	 *
	 * @param eiid �豸�ʲ�ID
	 */
	public void setEiid(int eiid) {
		this.eiid = eiid;
	}

	/**
	 * �豸�ʲ�ģ��IDȡ��
	 * @return �豸�ʲ�ģ��ID
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * �豸�ʲ�ģ��ID�趨
	 *
	 * @param eid �豸�ʲ�ģ��ID
	 */
	public void setEid(int eid) {
		this.eid = eid;
	}

	/**
	 * �豸�ʲ�����ȡ��
	 * @return �豸�ʲ�����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �豸�ʲ������趨
	 *
	 * @param einame �豸�ʲ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �豸�ʲ�˵��ȡ��
	 * @return �豸�ʲ�˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * �豸�ʲ�˵���趨
	 *
	 * @param eidesc �豸�ʲ�˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * �豸�ʲ��汾��ȡ��
	 * @return �豸�ʲ��汾��
	 */
	public int getEiversion() {
		return eiversion;
	}

	/**
	 * �豸�ʲ��汾���趨
	 *
	 * @param eiversion �豸�ʲ��汾��
	 */
	public void setEiversion(int eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �豸�ʲ����ȡ��
	 * @return �豸�ʲ����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �豸�ʲ�����趨
	 *
	 * @param eilabel �豸�ʲ����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
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
	 * �豸�ʲ�λ�ã�U��ȡ��
	 * @return �豸�ʲ�λ�ã�U��
	 */
	public String getU_value() {
		return u_value;
	}

	/**
	 * �豸�ʲ�λ�ã�U���趨
	 *
	 * @param u_value �豸�ʲ�λ�ã�U��
	 */
	public void setU_value(String u_value) {
		this.u_value = u_value;
	}

	/**
	 * �豸�ʲ��߶ȣ�U��ȡ��
	 * @return �豸�ʲ��߶ȣ�U��
	 */
	public String getU_width() {
		return u_width;
	}

	/**
	 * �豸�ʲ��߶ȣ�U���趨
	 *
	 * @param u_width �豸�ʲ��߶ȣ�U��
	 */
	public void setU_width(String u_width) {
		this.u_width = u_width;
	}

	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public int getContainer_eiid() {
		return container_eiid;
	}

	/**
	 * ��������ID�趨
	 *
	 * @param container_eiid ��������ID
	 */
	public void setContainer_eiid(Integer container_eiid) {
		this.container_eiid = container_eiid;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getContainer_eilabel() {
		return container_eilabel;
	}

	/**
	 * �����������趨
	 *
	 * @param container_eilabel ����������
	 */
	public void setContainer_eilabel(String container_eilabel) {
		this.container_eilabel = container_eilabel;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getContainer_einame() {
		return container_einame;
	}

	/**
	 * �����������趨
	 *
	 * @param container_einame ����������
	 */
	public void setContainer_einame(String container_einame) {
		this.container_einame = container_einame;
	}

	/**
	 * �豸�ʲ�ģ������ȡ��
	 * @return �豸�ʲ�ģ������
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �豸�ʲ�ģ�������趨
	 *
	 * @param ename �豸�ʲ�ģ������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * �豸�ʲ��ͺ�ȡ��
	 * @return �豸�ʲ��ͺ�
	 */
	public String getModel() {
		return model;
	}

	/**
	 * �豸�ʲ��ͺ��趨
	 *
	 * @param model �豸�ʲ��ͺ�
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * �豸�����ȡ��
	 * @return �豸�����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �豸������趨
	 *
	 * @param esyscoding �豸�����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * �Ƿ��ǻ����豸��־λȡ��
	 * @return �Ƿ��ǻ����豸��־λ
	 */
	public String getInroomFlg() {
		return inroomFlg;
	}
	
	/**
	 * �Ƿ��ǻ����豸��־λ�趨
	 *
	 * @param esyscoding �Ƿ��ǻ����豸��־λ
	 */
	public void setInroomFlg(String inroomFlg) {
		this.inroomFlg = inroomFlg;
	}

	/**
	 * @return �豸״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * @param �豸״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}
	
}
