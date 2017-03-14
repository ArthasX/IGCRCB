/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.csebank.lom.model.GstockVWInfo;

/**
 * 
 * ���Ԥ����Ϣ��ͼʵ��
 *
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "GstockVW")
@SuppressWarnings("serial")
public class GstockVW implements Serializable,GstockVWInfo {
	
	/** ��Ʒ��ϢID */
	@Id
	protected Integer gid;
	
	/** ��Ʒ���� */
	protected String gcategory;
	
	/** ��Ʒ���� */
	protected String gname;
	
	/** ��Ʒ��� */
	protected String gcode;
	
	/** Ԥ����ʾ���� */
	protected Integer gwarningnum;
	
	/** ��Ʒ�ڲ�ת�ƶ��ۣ�%�� */
	protected Double gprice;
	
	/** ״̬��0:ͣ�� 1:���ã� */
	protected String gstatus;
	

	
	/** ��Ʒ�����ϢID */
	protected Integer gsid;
	
	/** ������ */
	protected Integer gsnum;
	
	/** ������������� */
	protected String gsorg;
	
	/** �ɹ�ƽ���� */
	protected String gsavgprice;
	
	/** �������� */
	protected Integer gsfreezenum;
	
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return gid;
	}

	/**
	 * ��Ʒ��ϢIDȡ��
	 * @return ��Ʒ��ϢID
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * ��Ʒ��ϢID�趨
	 * @param gid ��Ʒ��ϢID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGcategory() {
		return gcategory;
	}

	/**
	 * ��Ʒ�����趨
	 * @param gcategory ��Ʒ����
	 */
	public void setGcategory(String gcategory) {
		this.gcategory = gcategory;
	}

	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGname() {
		return gname;
	}

	/**
	 * ��Ʒ�����趨
	 * @param gname ��Ʒ����
	 */
	public void setGname(String gname) {
		this.gname = gname;
	}

	/**
	 * ��Ʒ���ȡ��
	 * @return ��Ʒ���
	 */
	public String getGcode() {
		return gcode;
	}

	/**
	 * ��Ʒ����趨
	 * @param gcode ��Ʒ���
	 */
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}

	/**
	 * Ԥ����ʾ����ȡ��
	 * @return Ԥ����ʾ����
	 */
	public Integer getGwarningnum() {
		return gwarningnum;
	}

	/**
	 * Ԥ����ʾ�����趨
	 * @param gwarningnum Ԥ����ʾ����
	 */
	public void setGwarningnum(Integer gwarningnum) {
		this.gwarningnum = gwarningnum;
	}

	/**
	 * ��Ʒ�ڲ�ת�ƶ��ۣ�%��ȡ��
	 * @return ��Ʒ�ڲ�ת�ƶ��ۣ�%��
	 */
	public Double getGprice() {
		return gprice;
	}

	/**
	 * ��Ʒ�ڲ�ת�ƶ��ۣ�%���趨
	 * @param gprice ��Ʒ�ڲ�ת�ƶ��ۣ�%��
	 */
	public void setGprice(Double gprice) {
		this.gprice = gprice;
	}

	/**
	 * ״̬��0:ͣ�� 1:���ã�ȡ��
	 * @return ״̬��0:ͣ�� 1:���ã�
	 */
	public String getGstatus() {
		return gstatus;
	}

	/**
	 * ״̬��0:ͣ�� 1:���ã��趨
	 * @param gstatus ״̬��0:ͣ�� 1:���ã�
	 */
	public void setGstatus(String gstatus) {
		this.gstatus = gstatus;
	}


	
	/**
	 * ��Ʒ�����ϢIDȡ��
	 * @return ��Ʒ�����ϢID
	 */
	public Integer getGsid() {
		return gsid;
	}
	/**
	 * ��Ʒ�����ϢID
	 * @param gsid ��Ʒ�����ϢID
	 */
	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public Integer getGsnum() {
		return gsnum;
	}
	/**
	 * ������
	 * @param ������
	 */
	public void setGsnum(Integer gsnum) {
		this.gsnum = gsnum;
	}
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getGsorg() {
		return gsorg;
	}
	/**
	 * �������������
	 * @param �������������
	 */
	public void setGsorg(String gsorg) {
		this.gsorg = gsorg;
	}
	/**
	 * �ɹ�ƽ����ȡ��
	 * @return �ɹ�ƽ����
	 */
	public String getGsavgprice() {
		return gsavgprice;
	}
	/**
	 * �ɹ�ƽ����
	 * @param ���ɹ�ƽ����
	 */
	public void setGsavgprice(String gsavgprice) {
		this.gsavgprice = gsavgprice;
	}
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGsfreezenum() {
		return gsfreezenum;
	}
	/**
	 * ��������
	 * @param ��������
	 */
	public void setGsfreezenum(Integer gsfreezenum) {
		this.gsfreezenum = gsfreezenum;
	}

}
