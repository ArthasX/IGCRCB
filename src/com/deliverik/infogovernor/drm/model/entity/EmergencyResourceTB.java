/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.EmergencyResourceInfo;

/**
  * ����: Ӧ����Դģ�Ͷ���ʵ��
  * ��������: Ӧ����Դģ�Ͷ���ʵ��
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="EmergencyResource")
public class EmergencyResourceTB extends BaseEntity implements Serializable,
		Cloneable, EmergencyResourceInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="EMERGENCYRESOURCE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="EMERGENCYRESOURCE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EMERGENCYRESOURCE_TABLE_GENERATOR")

	protected Integer erid;
	
	/** ��Ӧ�ʲ��� */
	protected String esyscoding;
	
	/** ��Ӧ�ʲ�����cid */
	protected String ercids;
	
	/** ��Դ���� */
	protected String ername;

	/** ��Դ���� */
	protected String erdesc;

	/** ��Դ״̬ */
	protected String erstatus;

	/** ��Դ��� */
	protected String erlabel;

	/** ��Դ���� */
	protected String ercode;

	/** �������� */
	protected String erparcode;

	/** ¼��ʱ�� */
	protected String ercreatetime;

	/** ¼����id */
	protected String eruserid;

	/** ¼�������� */
	protected String erusername;

	/**
	 * @return the ��Ӧ�ʲ�����cid
	 */
	public String getErcids() {
		return ercids;
	}

	/**
	 * @param ercids the ercids to set
	 */
	public void setErcids(String ercids) {
		this.ercids = ercids;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getErid() {
		return erid;
	}

	/**
	 * �����趨
	 *
	 * @param erid ����
	 */
	public void setErid(Integer erid) {
		this.erid = erid;
	}

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErname() {
		return ername;
	}

	/**
	 * ��Դ�����趨
	 *
	 * @param ername ��Դ����
	 */
	public void setErname(String ername) {
		this.ername = ername;
	}

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErdesc() {
		return erdesc;
	}

	/**
	 * ��Դ�����趨
	 *
	 * @param erdesc ��Դ����
	 */
	public void setErdesc(String erdesc) {
		this.erdesc = erdesc;
	}

	/**
	 * ��Դ״̬ȡ��
	 *
	 * @return ��Դ״̬
	 */
	public String getErstatus() {
		return erstatus;
	}

	/**
	 * ��Դ״̬�趨
	 *
	 * @param erstatus ��Դ״̬
	 */
	public void setErstatus(String erstatus) {
		this.erstatus = erstatus;
	}

	/**
	 * ��Դ���ȡ��
	 *
	 * @return ��Դ���
	 */
	public String getErlabel() {
		return erlabel;
	}

	/**
	 * ��Դ����趨
	 *
	 * @param erlabel ��Դ���
	 */
	public void setErlabel(String erlabel) {
		this.erlabel = erlabel;
	}

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErcode() {
		return ercode;
	}

	/**
	 * ��Դ�����趨
	 *
	 * @param ercode ��Դ����
	 */
	public void setErcode(String ercode) {
		this.ercode = ercode;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getErparcode() {
		return erparcode;
	}

	/**
	 * ���������趨
	 *
	 * @param erparcode ��������
	 */
	public void setErparcode(String erparcode) {
		this.erparcode = erparcode;
	}

	/**
	 * ¼��ʱ��ȡ��
	 *
	 * @return ¼��ʱ��
	 */
	public String getErcreatetime() {
		return ercreatetime;
	}

	/**
	 * ¼��ʱ���趨
	 *
	 * @param ercreatetime ¼��ʱ��
	 */
	public void setErcreatetime(String ercreatetime) {
		this.ercreatetime = ercreatetime;
	}

	/**
	 * ¼����idȡ��
	 *
	 * @return ¼����id
	 */
	public String getEruserid() {
		return eruserid;
	}

	/**
	 * ¼����id�趨
	 *
	 * @param eruserid ¼����id
	 */
	public void setEruserid(String eruserid) {
		this.eruserid = eruserid;
	}

	/**
	 * ¼��������ȡ��
	 *
	 * @return ¼��������
	 */
	public String getErusername() {
		return erusername;
	}

	/**
	 * ¼���������趨
	 *
	 * @param erusername ¼��������
	 */
	public void setErusername(String erusername) {
		this.erusername = erusername;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return erid;
	}

	/**
	 * @return the esyscoding
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * @param ��Ӧ�ʲ���  the esyscoding to set
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

}