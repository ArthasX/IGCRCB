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
import com.deliverik.infogovernor.soc.vir.model.VCD04Info;

/**
  * ����: vCloud������־ʵ��
  * ��������: vCloud������־ʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="VCD04")
public class VCD04TB extends BaseEntity implements Serializable,
		Cloneable, VCD04Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="VCD04_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VCD04_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VCD04_TABLE_GENERATOR")
	protected Integer id;

	/** ��Ŀ���� */
	protected Integer pid;

	/** ������� */
	protected String vmName;

	/** ��־���� */
	protected String content;

	/** ����ʱ�� */
	protected String updateTime;

	/** ��־ */
	protected String flag;

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
	 * ��Ŀ����ȡ��
	 *
	 * @return ��Ŀ����
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ��Ŀ�����趨
	 *
	 * @param pid ��Ŀ����
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getVmName() {
		return vmName;
	}

	/**
	 * ��������趨
	 *
	 * @param vmName �������
	 */
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	/**
	 * ��־����ȡ��
	 *
	 * @return ��־����
	 */
	public String getContent() {
		return content;
	}

	/**
	 * ��־�����趨
	 *
	 * @param content ��־����
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param updateTime ����ʱ��
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * ��־ȡ��
	 *
	 * @return ��־
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * ��־�趨
	 *
	 * @param flag ��־
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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