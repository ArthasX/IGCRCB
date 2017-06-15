/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.rpt.model.SOC0201Info;

/**
 * 
 * @Description:�Զ��������ɱ�ʵ��TB��
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼:2012/08/09 ��REPORT_GDATA_ITEMTB������ΪSOC0201TB
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SOC0201")
public class SOC0201TB extends BaseEntity implements Serializable,
		Cloneable, SOC0201Info {
	/**
	 *��������������
	 */
	@Id
	@TableGenerator(name = "REPORT_GDATA_ITEM_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "REPORT_GDATA_ITEM_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "REPORT_GDATA_ITEM_TABLE_GENERATOR")
	protected Integer id;

	/**
	 *��������������ȡ��
	 * 
	 * @return ��������������
	 */
	public Integer getId() {
		return id;
	}

	/**
	 *���������������趨
	 * 
	 * @param id��������������
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 *ͳ������
	 */
	protected String r_category;

	/**
	 *ͳ������ȡ��
	 * 
	 * @return ͳ������
	 */
	public String getR_category() {
		return r_category;
	}

	/**
	 *ͳ�������趨
	 * 
	 * @param r_categoryͳ������
	 */
	public void setR_category(String r_category) {
		this.r_category = r_category;
	}

	/**
	 *�����ļ�����
	 */
	protected String r_path;

	/**
	 *�����ļ�����ȡ��
	 * 
	 * @return �����ļ�����
	 */
	public String getR_path() {
		return r_path;
	}

	/**
	 *�����ļ������趨
	 * 
	 * @param r_path�����ļ�����
	 */
	public void setR_path(String r_path) {
		this.r_path = r_path;
	}

	/**
	 *��������id
	 */
	protected Integer r_rcid;

	/**
	 *��������idȡ��
	 * 
	 * @return ��������id
	 */
	public Integer getR_rcid() {
		return r_rcid;
	}

	/**
	 *��������id�趨
	 * 
	 * @param r_rcid��������id
	 */
	public void setR_rcid(Integer r_rcid) {
		this.r_rcid = r_rcid;
	}

	/**
	 *����ͳ������
	 */
	protected String r_time;

	/**
	 *����ͳ������ȡ��
	 * 
	 * @return ����ͳ������
	 */
	public String getR_time() {
		return r_time;
	}

	/**
	 *����ͳ�������趨
	 * 
	 * @param r_time����ͳ������
	 */
	public void setR_time(String r_time) {
		this.r_time = r_time;
	}

	public Serializable getPK() {
		return id;
	}
	
	/**
	 *����ID
	 */
	protected String dataid;

	/**
	 * @return the ����ID
	 */
	public String getDataid() {
		return dataid;
	}

	/**
	 * @param ����ID
	 */
	public void setDataid(String dataid) {
		this.dataid = dataid;
	}
}
