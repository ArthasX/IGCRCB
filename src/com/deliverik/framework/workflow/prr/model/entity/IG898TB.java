/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG898Info;

/**
  * ����: ������ֵ��ʵ��
  * ��������: ������ֵ��ʵ��
  * ������¼: 2013/06/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG898PK.class)
@Table(name="IG898")
public class IG898TB extends BaseEntity implements Serializable, Cloneable, IG898Info {

	/** �������� */
	@Id
	protected Integer prid;

	/** ���������� */
	@Id
	protected String pidid;

	/** �ж������� */
	@Id
	protected String pvcolpidid;

	/** �к� */
	@Id
	protected String pvrownumber;

	/** ��ֵ */
	protected String  pvalue;
	
	/** ������ */
	protected String pidname;
	
	/** ���� */
	protected String pvcolname;
	
	/** ����key */
	protected String attkey;

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 *
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * �����������趨
	 *
	 * @param pidid ����������
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}
	

	/**
	 * �ж�������ȡ��
	 * @return pvcolpidid �ж�������
	 */
	public String getPvcolpidid() {
		return pvcolpidid;
	}

	/**
	 * �ж��������趨
	 * @param pvcolpidid �ж�������
	 */
	public void setPvcolpidid(String pvcolpidid) {
		this.pvcolpidid = pvcolpidid;
	}

	/**
	 * �к�ȡ��
	 *
	 * @return �к�
	 */
	public String getPvrownumber() {
		return pvrownumber;
	}

	/**
	 * �к��趨
	 *
	 * @param pvrownumber �к�
	 */
	public void setPvrownumber(String pvrownumber) {
		this.pvrownumber = pvrownumber;
	}

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getPvalue() {
		return pvalue;
	}

	/**
	 * ��ֵ�趨
	 *
	 * @param pvalue ��ֵ
	 */
	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}

	/**
	 * ������ȡ��
	 * @return pidname ������
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * �������趨
	 * @param pidname ������
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ����ȡ��
	 * @return pvcolname ����
	 */
	public String getPvcolname() {
		return pvcolname;
	}

	/**
	 * �����趨
	 * @param pvcolname ����
	 */
	public void setPvcolname(String pvcolname) {
		this.pvcolname = pvcolname;
	}

	/**
	 * ����keyȡ��
	 * @return attkey ����key
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * ����key�趨
	 * @param attkey ����key
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new IG898PK(prid, pidid, pvcolpidid, pvrownumber);
	}

}