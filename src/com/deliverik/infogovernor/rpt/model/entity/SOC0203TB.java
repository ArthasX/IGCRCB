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
import com.deliverik.infogovernor.rpt.model.SOC0203Info;

/**
 * 
 * @Description:�Զ����������б�ʵ��TB��
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��ReportConfigurationTB������ΪSOC0203TB
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SOC0203")
public class SOC0203TB extends BaseEntity implements Serializable,
		Cloneable, SOC0203Info {
	@Id
	@TableGenerator(name = "REPORT_CONFIGURATION_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "REPORT_CONFIGURATION_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "REPORT_CONFIGURATION_TABLE_GENERATOR")
	/**
	 *��������������
	 */
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
	 *�����ļ�������
	 */
	protected String r_path;

	/**
	 *�����ļ�������ȡ��
	 * 
	 * @return �����ļ�������
	 */
	public String getR_path() {
		return r_path;
	}

	/**
	 *�����ļ��������趨
	 * 
	 * @param r_path�����ļ�������
	 */
	public void setR_path(String r_path) {
		this.r_path = r_path;
	}

	/**
	 *�����ļ������ĺ���
	 */
	protected String r_title;

	/**
	 *�����ļ������ĺ���ȡ��
	 * 
	 * @return �����ļ������ĺ���
	 */
	public String getR_title() {
		return r_title;
	}

	/**
	 *�����ļ������ĺ����趨
	 * 
	 * @param r_title�����ļ������ĺ���
	 */
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	/**
	 *��������ʱ���õĲ���
	 */
	protected String para;

	/**
	 *��������ʱ���õĲ���ȡ��
	 * 
	 * @return ��������ʱ���õĲ���
	 */
	public String getPara() {
		return para;
	}

	/**
	 *��������ʱ���õĲ����趨
	 * 
	 * @param para��������ʱ���õĲ���
	 */
	public void setPara(String para) {
		this.para = para;
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
