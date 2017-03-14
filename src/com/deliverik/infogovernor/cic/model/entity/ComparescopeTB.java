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
import com.deliverik.infogovernor.cic.model.ComparescopeInfo;

/**
  * ����: �Ա���ʵ��
  * ��������: �Ա���ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="comparescope")
public class ComparescopeTB extends BaseEntity implements Serializable,
		Cloneable, ComparescopeInfo {

	/** ���� */
	@Id
	@GeneratedValue(generator = "csid")
	@GenericGenerator(name = "csid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "comparescope_seq") })
	protected Integer csid;

	/** ���� */
	protected String csname;
	
	protected String createtime;
	
	protected Integer csversion;
	
	

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCsid() {
		return csid;
	}

	/**
	 * �����趨
	 *
	 * @param csid ����
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCsname() {
		return csname;
	}

	/**
	 * �����趨
	 *
	 * @param csname ����
	 */
	public void setCsname(String csname) {
		this.csname = csname;
	}

	
	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Integer getCsversion() {
		return csversion;
	}

	public void setCsversion(Integer csversion) {
		this.csversion = csversion;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	@Override
	public Serializable getPK() {
		return csid;
	}

	
}