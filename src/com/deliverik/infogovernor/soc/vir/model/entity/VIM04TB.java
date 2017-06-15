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
import com.deliverik.infogovernor.soc.vir.model.VIM04Info;

/**
  * ����: ��־��ʵ��
  * ��������: ��־��ʵ��
  * ������¼: 2014/02/19
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="VIM04")
public class VIM04TB extends BaseEntity implements Serializable,
		Cloneable, VIM04Info {

	/** �������� */
	@Id
	@TableGenerator(
		name="VIM04_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VIM04_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VIM04_TABLE_GENERATOR")
	protected Integer id;

	/** ��Ŀ���� */
	protected Integer pid;

	/** ������� */
	protected String vmName;

	/** ��־���� */
	protected String content;

	/** ����ʱ�� */
	protected String updateTime;

	/** ��־ ��0��ʧ�� 1���ɹ��� */
	protected String flag;
	
	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * ���������趨
	 *
	 * @param id ��������
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
     * ��ȡ����ʱ��
     * @return ����ʱ�� 
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * ���÷���ʱ��
     * @param updateTime ����ʱ��
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
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
     * ��ȡ��־��0��ʧ��1���ɹ���
     * @return ��־��0��ʧ��1���ɹ��� 
     */
    public String getFlag() {
        return flag;
    }

    /**
     * ���ñ�־��0��ʧ��1���ɹ���
     * @param flag ��־��0��ʧ��1���ɹ���
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

}