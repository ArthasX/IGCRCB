package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.deliverik.framework.asset.model.IG011Info;

/**
 * �ʲ�ͳ����Ϣʵ��
 * 
 */
@SuppressWarnings("serial")
@Entity
public class IG011VW implements Serializable,
	Cloneable, IG011Info {
	
	/** �ʲ�ģ�Ͳ����*/
	@Id
	protected String cid;
	
	/** �ʲ�ģ������*/
	protected String cvalue;
	
	/** ����*/
	protected Integer total;
	
	/** ��ռ�ٷ���*/
	@Transient
	protected String proportion;
	
	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * �ʲ�ģ�Ͳ�����趨
	 *
	 * @param cid �ʲ�ģ�Ͳ����
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getCvalue() {
		return cvalue;
	}

	/**
	 * �ʲ�ģ�������趨
	 *
	 * @param cvalue �ʲ�ģ������
	 */
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * �����趨
	 *
	 * @param total ����
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	/**
	 * ÿ���ʲ�ģ��������ռ�����İٷ���ȡ��
	 * @return ÿ���ʲ�ģ��������ռ�����İٷ���
	 */
	public String getProportion() {
		return proportion;
	}

	/**
	 * ÿ���ʲ�ģ��������ռ�����İٷ����趨
	 *
	 * @param proportion ÿ���ʲ�ģ��������ռ�����İٷ���
	 */
	public void setProportion(String proportion) {
		this.proportion = proportion;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof IG011VW))
			return false;
		IG011Info target = (IG011Info) obj;
		if (!(getCid() == target.getCid()))
			return false;

		return true;
	}

}
