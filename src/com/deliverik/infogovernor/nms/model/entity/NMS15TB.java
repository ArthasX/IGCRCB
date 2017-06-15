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
import com.deliverik.infogovernor.nms.model.NMS15Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Զ����ּ�¼ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS15")
public class NMS15TB extends BaseEntity implements NMS15Info {

	/** ���� */
	@Id
	@TableGenerator(
			name="NMS15_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="NMS15_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE,generator="NMS15_TABLE_GENERATOR")
	protected Integer id;
	
	/** ����汾 */
	protected Integer rversion;

	/** ��ID */
	protected Integer gid;
	
	/** ��汾 */
	protected Integer gversion;
	
	/** ��ʼʱ�� */
	protected String starttime;
	
	/** ����ʱ�� */
	protected String endtime;
	
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
	 * ����汾ȡ��
	 * @return rversion ����汾
	 */
	public Integer getRversion() {
		return rversion;
	}

	/**
	 * ����汾�趨
	 * @param rversion ����汾
	 */
	public void setRversion(Integer rversion) {
		this.rversion = rversion;
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
	 * ��ʼʱ��ȡ��
	 * @return starttime ��ʼʱ��
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * ��ʼʱ���趨
	 * @param starttime ��ʼʱ��
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return endtime ����ʱ��
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * ����ʱ���趨
	 * @param endtime ����ʱ��
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.id;
	}

}
