/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;

/**
  * ����: �ȶԽ��ʵ��
  * ��������: �ȶԽ��ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="compareresult")
public class CompareresultTB extends BaseEntity implements Serializable,
		Cloneable, CompareresultInfo {

	/** crid */
	@Id
	@GeneratedValue(generator = "crid")
	@GenericGenerator(name = "crid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "compareresult_seq") })
	protected Integer crid;

	/** �Ƚ϶����id */
	protected Integer fkCoid;

	/** �Ƚ�ִ�б�ID */
	protected Integer fkCpid;

	/** eid */
	protected String eid;

	/** cid */
	protected String cid;

	/** Ŀ��eiid */
	protected Integer teiid;

	/** Ŀ��ciid */
	protected String tciid;

	/** Դeiid */
	protected Integer seiid;

	/** Դciid */
	protected String sciid;

	/** Դ����ֵ */
	protected String svalue;

	/** Ŀ������ֵ */
	protected String tvalue;

	/** �������� */
	protected String configtype;

	/** �Ƿ��ǻ������� */
	protected Integer isbase;

	/** ���ڵ�ģ��id */
	protected String peid;

	/**
	 * cridȡ��
	 *
	 * @return crid
	 */
	public Integer getCrid() {
		return crid;
	}

	/**
	 * crid�趨
	 *
	 * @param crid crid
	 */
	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	/**
	 * �Ƚ϶����idȡ��
	 *
	 * @return �Ƚ϶����id
	 */
	public Integer getFkCoid() {
		return fkCoid;
	}

	/**
	 * �Ƚ϶����id�趨
	 *
	 * @param fkCoid �Ƚ϶����id
	 */
	public void setFkCoid(Integer fkCoid) {
		this.fkCoid = fkCoid;
	}

	/**
	 * �Ƚ�ִ�б�IDȡ��
	 *
	 * @return �Ƚ�ִ�б�ID
	 */
	public Integer getFkCpid() {
		return fkCpid;
	}

	/**
	 * �Ƚ�ִ�б�ID�趨
	 *
	 * @param fkCpid �Ƚ�ִ�б�ID
	 */
	public void setFkCpid(Integer fkCpid) {
		this.fkCpid = fkCpid;
	}

	/**
	 * eidȡ��
	 *
	 * @return eid
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * eid�趨
	 *
	 * @param eid eid
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * cidȡ��
	 *
	 * @return cid
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * cid�趨
	 *
	 * @param cid cid
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * Ŀ��eiidȡ��
	 *
	 * @return Ŀ��eiid
	 */
	public Integer getTeiid() {
		return teiid;
	}

	/**
	 * Ŀ��eiid�趨
	 *
	 * @param teiid Ŀ��eiid
	 */
	public void setTeiid(Integer teiid) {
		this.teiid = teiid;
	}

	/**
	 * Ŀ��ciidȡ��
	 *
	 * @return Ŀ��ciid
	 */
	public String getTciid() {
		return tciid;
	}

	/**
	 * Ŀ��ciid�趨
	 *
	 * @param tciid Ŀ��ciid
	 */
	public void setTciid(String tciid) {
		this.tciid = tciid;
	}

	/**
	 * Դeiidȡ��
	 *
	 * @return Դeiid
	 */
	public Integer getSeiid() {
		return seiid;
	}

	/**
	 * Դeiid�趨
	 *
	 * @param seiid Դeiid
	 */
	public void setSeiid(Integer seiid) {
		this.seiid = seiid;
	}

	/**
	 * Դciidȡ��
	 *
	 * @return Դciid
	 */
	public String getSciid() {
		return sciid;
	}

	/**
	 * Դciid�趨
	 *
	 * @param sciid Դciid
	 */
	public void setSciid(String sciid) {
		this.sciid = sciid;
	}

	/**
	 * Դ����ֵȡ��
	 *
	 * @return Դ����ֵ
	 */
	public String getSvalue() {
		return svalue;
	}

	/**
	 * Դ����ֵ�趨
	 *
	 * @param svalue Դ����ֵ
	 */
	public void setSvalue(String svalue) {
		this.svalue = svalue;
	}

	/**
	 * Ŀ������ֵȡ��
	 *
	 * @return Ŀ������ֵ
	 */
	public String getTvalue() {
		return tvalue;
	}

	/**
	 * Ŀ������ֵ�趨
	 *
	 * @param tvalue Ŀ������ֵ
	 */
	public void setTvalue(String tvalue) {
		this.tvalue = tvalue;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getConfigtype() {
		return configtype;
	}

	/**
	 * ���������趨
	 *
	 * @param configtype ��������
	 */
	public void setConfigtype(String configtype) {
		this.configtype = configtype;
	}

	/**
	 * �Ƿ��ǻ�������ȡ��
	 *
	 * @return �Ƿ��ǻ�������
	 */
	public Integer getIsbase() {
		return isbase;
	}

	/**
	 * �Ƿ��ǻ��������趨
	 *
	 * @param isbase �Ƿ��ǻ�������
	 */
	public void setIsbase(Integer isbase) {
		this.isbase = isbase;
	}

	/**
	 * ���ڵ�ģ��idȡ��
	 *
	 * @return ���ڵ�ģ��id
	 */
	public String getPeid() {
		return peid;
	}

	/**
	 * ���ڵ�ģ��id�趨
	 *
	 * @param peid ���ڵ�ģ��id
	 */
	public void setPeid(String peid) {
		this.peid = peid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	@Override
	public Serializable getPK() {
		return crid;
	}

}