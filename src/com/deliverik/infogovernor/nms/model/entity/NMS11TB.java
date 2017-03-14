/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS11Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������־ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS11")
public class NMS11TB extends BaseEntity implements NMS11Info {
	
	/** ���� */
	@Id
	@TableGenerator(
			name="NMS11_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="NMS11_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE,generator="NMS11_TABLE_GENERATOR")
	protected Integer id;
	
	/** ��ID */
	protected Integer gid;
	
	/** ��汾 */
	protected Integer gversion;
	
	/** ��־��Ϣ */
	protected String msg;
	
	/** ����ʱ�� */
	protected String instime;

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ��IDȡ��
	 * @return gid ��ID
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * ��ID�趨
	 * @param gid ��ID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * ��汾ȡ��
	 * @return gversion ��汾
	 */
	public Integer getGversion() {
		return gversion;
	}

	/**
	 * ��汾�趨
	 * @param gversion ��汾
	 */
	public void setGversion(Integer gversion) {
		this.gversion = gversion;
	}

	/**
	 * ��־��Ϣȡ��
	 * @return msg ��־��Ϣ
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * ��־��Ϣ�趨
	 * @param msg ��־��Ϣ
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return instime ����ʱ��
	 */
	public String getInstime() {
		return instime;
	}

	/**
	 * ����ʱ���趨
	 * @param instime ����ʱ��
	 */
	public void setInstime(String instime) {
		this.instime = instime;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.id;
	}

}
