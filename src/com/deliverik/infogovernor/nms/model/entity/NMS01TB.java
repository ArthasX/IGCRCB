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
import com.deliverik.infogovernor.nms.model.NMS01Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����Ϣʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS01",schema = "ig")
public class NMS01TB extends BaseEntity implements NMS01Info {
	
	/** ���� */
	@Id
	@TableGenerator(
			name="NMS01_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="NMS01_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE,generator="NMS01_TABLE_GENERATOR")
	protected Integer id;
	
	/** ������ */
	protected String name;
	
	/** �ϼ��� */
	protected Integer parentid;
	
	/** ��ע */
	protected String remark;
	
	/** �汾 */
	protected Integer version;
	
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
	 * ������ȡ��
	 * @return name ������
	 */
	public String getName() {
		return name;
	}

	/**
	 * �������趨
	 * @param name ������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * �ϼ���ȡ��
	 * @return parentid �ϼ���
	 */
	public Integer getParentid() {
		return parentid;
	}

	/**
	 * �ϼ����趨
	 * @param parentid �ϼ���
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	/**
	 * ��עȡ��
	 * @return remark ��ע
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * ��ע�趨
	 * @param remark ��ע
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * �汾ȡ��
	 * @return version �汾
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * �汾�趨
	 * @param version �汾
	 */
	public void setVersion(Integer version) {
		this.version = version;
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
