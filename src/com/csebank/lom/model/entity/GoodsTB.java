/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.csebank.lom.model.Goods;
import com.deliverik.framework.base.BaseEntity;

/**
 * 
 * ��Ʒ��Ϣʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="Goods")
public class GoodsTB extends BaseEntity implements Serializable, Cloneable, Goods {
	
	/** ��Ʒ��ϢID */
	@Id
	@TableGenerator(
		    name="GOODS_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="GOODS_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="GOODS_TABLE_GENERATOR")
	
	protected Integer gid;
	
	/** ��Ʒ���� */
	protected String gcategory;
	
	/** ��Ʒ�������� */
	@Transient
	protected String gcategoryname;
	
	/** ��Ʒ���� */
	protected String gname;
	
	/** ��Ʒ��� */
	protected String gcode;
	
	/** Ԥ����ʾ���� */
	protected Integer gwarningnum;
	
	/** ��Ʒ�ڲ�ת�ƶ��ۣ�%�� */
	protected BigDecimal gprice;
	
	/** ״̬��0:ͣ�� 1:���ã� */
	protected String gstatus;
	
	/** ��λ */
	protected String gunit;
	
	/** ԭ�� */
	protected String greason;

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
	 * ��Ʒ���������趨
	 * @param gcategory ��Ʒ��������
	 */
	public void setGcategoryname(String gcategoryname) {
		this.gcategoryname = gcategoryname;
	}
	
	/**
	 * ��Ʒ��������ȡ��
	 * @return ��Ʒ��������
	 */
	public String getGcategoryname() {
		return gcategoryname;
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
	public BigDecimal getGprice() {
		return gprice;
	}

	/**
	 * ��Ʒ�ڲ�ת�ƶ��ۣ�%���趨
	 * @param gprice ��Ʒ�ڲ�ת�ƶ��ۣ�%��
	 */
	public void setGprice(BigDecimal gprice) {
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

	public String getGunit() {
		return gunit;
	}

	public void setGunit(String gunit) {
		this.gunit = gunit;
	}

	public String getGreason() {
		return greason;
	}

	public void setGreason(String greason) {
		this.greason = greason;
	}


	
}
