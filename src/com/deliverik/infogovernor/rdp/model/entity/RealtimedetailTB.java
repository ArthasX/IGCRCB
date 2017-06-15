/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rdp.model.RealtimedetailInfo;

/**
  * ����: ��־��Ϣʵ��
  * ��������: ��־��Ϣʵ��
  * ������¼: 2014/05/06
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="realtimedetail")
public class RealtimedetailTB extends BaseEntity implements Serializable,
		Cloneable, RealtimedetailInfo {

	/** ���� */
	@Id
	protected Integer id;

	/** �������� */
	protected Integer taskid;

	/** ����ip */
	protected String hostip;

	/** ���� */
	protected String content;

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
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getTaskid() {
		return taskid;
	}

	/**
	 * ���������趨
	 *
	 * @param taskid ��������
	 */
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	/**
	 * ����ipȡ��
	 *
	 * @return ����ip
	 */
	public String getHostip() {
		return hostip;
	}

	/**
	 * ����ip�趨
	 *
	 * @param hostip ����ip
	 */
	public void setHostip(String hostip) {
		this.hostip = hostip;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getContent() {
		return content;
	}

	/**
	 * �����趨
	 *
	 * @param content ����
	 */
	public void setContent(String content) {
		this.content = content;
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