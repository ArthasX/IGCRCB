/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;

/**
  * ����: ���������ʵ��
  * ��������: ���������ʵ��
  * ������¼: 2013/07/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ApproveSuggestion")
public class ApproveSuggestionTB extends BaseEntity implements Serializable,
		Cloneable, ApproveSuggestionInfo {

	/** ����ID */
	@Id
	@TableGenerator(
		name="APPROVESUGGESTION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="APPROVESUGGESTION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="APPROVESUGGESTION_TABLE_GENERATOR")
	protected Integer id;

	/** ������ID */
	protected String pidid;

	/** ����ID */
	protected Integer prid;
	
	/** ״̬��ʶ */
	protected String psdcode;

	/** ״̬���� */
	protected String psdname;

	/** ��� */
	protected String suggestion;

	/** ���״̬ */
	protected String status;

	/** ����ʱ�� */
	protected String inserttime;

	/** ������ID */
	protected String userid;

	/** ���������� */
	protected String username;
	
	/** ���ʽ���к� */
	protected String rownumber;

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
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getPidid() {
		return pidid;
	}
	
	/**
	 * ������ID�趨
	 *
	 * @param pidid ������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return prid ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ״̬��ʶȡ��
	 *
	 * @return ״̬��ʶ
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * ״̬��ʶ�趨
	 *
	 * @param psdcode ״̬��ʶ
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * ״̬����ȡ��
	 *
	 * @return ״̬����
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * ״̬�����趨
	 *
	 * @param psdname ״̬����
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getSuggestion() {
		return suggestion;
	}

	/**
	 * ����趨
	 *
	 * @param suggestion ���
	 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	/**
	 * ���״̬ȡ��
	 *
	 * @return ���״̬
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ���״̬�趨
	 *
	 * @param status ���״̬
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getInserttime() {
		return inserttime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param inserttime ����ʱ��
	 */
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ������ID�趨
	 *
	 * @param userid ������ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �����������趨
	 *
	 * @param username ����������
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ���ʽ���к�ȡ��
	 * @return rownumber ���ʽ���к�
	 */
	public String getRownumber() {
		return rownumber;
	}

	/**
	 * ���ʽ���к��趨
	 * @param rownumber ���ʽ���к�
	 */
	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

}