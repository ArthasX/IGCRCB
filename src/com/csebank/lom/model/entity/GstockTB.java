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

import com.csebank.lom.model.Gstock;
import com.deliverik.framework.base.BaseEntity;

/**
 * 
 * ��Ʒʵ��
 * 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "Gstock")
public class GstockTB extends BaseEntity implements Serializable, Cloneable,
		Gstock {

	/** GStock���� */
	@Id
	@TableGenerator(name = "GSTOCK_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", 
					pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", 
					pkColumnValue = "GSTOCK_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "GSTOCK_TABLE_GENERATOR")
	protected Integer gsid;
	/** ��Ʒ���� */
	protected String gscategory;
	/** ��Ʒ���� */
	protected String gsname;
	/** ��Ʒ��� */
	protected String gscode;
	/** ������ */
	protected Integer gsnum;
	/** ������������� */
	protected String gsorg;
	/** �ɹ�ƽ���� */
	protected BigDecimal gsavgprice;
	/** �������� */
	protected Integer gsfreezenum;
	/** ���һ�θ�����ID */
	protected String gsuserid;
	/** ���һ�θ��������� */
	protected String gsusername;
	/** ���һ�θ���ʱ�� */
	protected String gsdate;

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getGsid() {
		return gsid;
	}
	/**
	 * ����ID
	 * @param gsid ����ID
	 */
	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}
	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGscategory() {
		return gscategory;
	}
	/**
	 * ��Ʒ����
	 * @param ��Ʒ����
	 */
	public void setGscategory(String gscategory) {
		this.gscategory = gscategory;
	}
	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGsname() {
		return gsname;
	}
	/**
	 * ��Ʒ����
	 * @param ��Ʒ����
	 */
	public void setGsname(String gsname) {
		this.gsname = gsname;
	}
	/**
	 * ��Ʒ���ȡ��
	 * @return ��Ʒ���
	 */
	public String getGscode() {
		return gscode;
	}
	/**
	 * ��Ʒ���
	 * @param ��Ʒ���
	 */
	public void setGscode(String gscode) {
		this.gscode = gscode;
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
	public BigDecimal getGsavgprice() {
		return gsavgprice;
	}
	/**
	 * �ɹ�ƽ����
	 * @param ���ɹ�ƽ����
	 */
	public void setGsavgprice(BigDecimal gsavgprice) {
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

	public String getGsuserid() {
		return gsuserid;
	}
	public void setGsuserid(String gsuserid) {
		this.gsuserid = gsuserid;
	}
	public String getGsusername() {
		return gsusername;
	}
	public void setGsusername(String gsusername) {
		this.gsusername = gsusername;
	}
	public String getGsdate() {
		return gsdate;
	}
	public void setGsdate(String gsdate) {
		this.gsdate = gsdate;
	}
	@Override
	public Serializable getPK() {
		return gsid;
	}

}
