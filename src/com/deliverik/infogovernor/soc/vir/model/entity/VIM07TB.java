/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.vir.model.VIM07Info;

/**
  * ����: ���������Ϣ��ʵ��
  * ��������: ���������Ϣ��ʵ��
  * ������¼: 2014/03/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="vim07")
public class VIM07TB extends BaseEntity implements Serializable,
		Cloneable, VIM07Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="VIM07_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VIM07_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VIM07_TABLE_GENERATOR")
	protected Integer id;

	/** ������� */
	protected Integer vmid;
	
	/** ��ĿID */
	protected Integer pid;

	/** �������� */
	protected String ctype;

	/** �������� */
	protected Integer prid;

	/** ��������ʱ�� */
	protected String ctime;

	/** �������ʱ�� */
	protected String atime;
	
	/** �����û�ID */
	protected String userid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 *
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public Integer getVmid() {
		return vmid;
	}

	/**
	 * ��������趨
	 *
	 * @param vmid �������
	 */
	public void setVmid(Integer vmid) {
		this.vmid = vmid;
	}

	/**
	 * ��ĿIDȡ��
	 * @return pid ��ĿID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ��ĿID�趨
	 * @param pid ��ĿID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getCtype() {
		return ctype;
	}

	/**
	 * ���������趨
	 *
	 * @param ctype ��������
	 */
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

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
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getCtime() {
		return ctime;
	}

	/**
	 * ��������ʱ���趨
	 *
	 * @param ctime ��������ʱ��
	 */
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	/**
	 * �������ʱ��ȡ��
	 *
	 * @return �������ʱ��
	 */
	public String getAtime() {
		return atime;
	}

	/**
	 * �������ʱ���趨
	 *
	 * @param atime �������ʱ��
	 */
	public void setAtime(String atime) {
		this.atime = atime;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

	/**
	 * �����û�IDȡ��
	 * @return userid �����û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �����û�ID�趨
	 * @param userid �����û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

}