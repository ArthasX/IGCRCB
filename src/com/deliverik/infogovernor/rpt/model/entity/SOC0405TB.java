/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0405Info;

/**
  * ����: �߼�������ʵʱ��ʵ��
  * ��������: �߼�������ʵʱ��ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��LVCapacityRealTimeTB������ΪSOC0405TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0405")
public class SOC0405TB extends BaseEntity implements Serializable,
		Cloneable, SOC0405Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="LVCAPACITYREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="LVCAPACITYREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="LVCAPACITYREALTIME_TABLE_GENERATOR")
	protected Integer lvId;

	/** ������ */
	protected String hostName;

	/** ������ */
	protected String vgName;

	/** �߼������� */
	protected String lvType;

	/** �߼����� */
	protected String lvName;

	/** �߼����С */
	protected Integer lvSize;

	/** �߼���״̬ */
	protected String lvState;

	/** �ļ�ϵͳ�� */
	protected String fsName;

	/** ���� */
	protected String createDate;

	/** �ѷ������� */
	protected Integer allottedCapacity;

	/** �������� */
	protected Integer freeCapacity;

	/** ��ʹ������ */
	protected Integer usedCapacity;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getLvId() {
		return lvId;
	}

	/**
	 * �����趨
	 *
	 * @param lvId ����
	 */
	public void setLvId(Integer lvId) {
		this.lvId = lvId;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * �������趨
	 *
	 * @param hostName ������
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getVgName() {
		return vgName;
	}

	/**
	 * �������趨
	 *
	 * @param vgName ������
	 */
	public void setVgName(String vgName) {
		this.vgName = vgName;
	}

	/**
	 * �߼�������ȡ��
	 *
	 * @return �߼�������
	 */
	public String getLvType() {
		return lvType;
	}

	/**
	 * �߼��������趨
	 *
	 * @param lvType �߼�������
	 */
	public void setLvType(String lvType) {
		this.lvType = lvType;
	}

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public String getLvName() {
		return lvName;
	}

	/**
	 * �߼������趨
	 *
	 * @param lvName �߼�����
	 */
	public void setLvName(String lvName) {
		this.lvName = lvName;
	}

	/**
	 * �߼����Сȡ��
	 *
	 * @return �߼����С
	 */
	public Integer getLvSize() {
		return lvSize;
	}

	/**
	 * �߼����С�趨
	 *
	 * @param lvSize �߼����С
	 */
	public void setLvSize(Integer lvSize) {
		this.lvSize = lvSize;
	}

	/**
	 * �߼���״̬ȡ��
	 *
	 * @return �߼���״̬
	 */
	public String getLvState() {
		return lvState;
	}

	/**
	 * �߼���״̬�趨
	 *
	 * @param lvState �߼���״̬
	 */
	public void setLvState(String lvState) {
		this.lvState = lvState;
	}

	/**
	 * �ļ�ϵͳ��ȡ��
	 *
	 * @return �ļ�ϵͳ��
	 */
	public String getFsName() {
		return fsName;
	}

	/**
	 * �ļ�ϵͳ���趨
	 *
	 * @param fsName �ļ�ϵͳ��
	 */
	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * �����趨
	 *
	 * @param createDate ����
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * �ѷ�������ȡ��
	 *
	 * @return �ѷ�������
	 */
	public Integer getAllottedCapacity() {
		return allottedCapacity;
	}

	/**
	 * �ѷ��������趨
	 *
	 * @param allottedCapacity �ѷ�������
	 */
	public void setAllottedCapacity(Integer allottedCapacity) {
		this.allottedCapacity = allottedCapacity;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getFreeCapacity() {
		return freeCapacity;
	}

	/**
	 * ���������趨
	 *
	 * @param freeCapacity ��������
	 */
	public void setFreeCapacity(Integer freeCapacity) {
		this.freeCapacity = freeCapacity;
	}

	/**
	 * ��ʹ������ȡ��
	 *
	 * @return ��ʹ������
	 */
	public Integer getUsedCapacity() {
		return usedCapacity;
	}

	/**
	 * ��ʹ�������趨
	 *
	 * @param usedCapacity ��ʹ������
	 */
	public void setUsedCapacity(Integer usedCapacity) {
		this.usedCapacity = usedCapacity;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return lvId;
	}

}