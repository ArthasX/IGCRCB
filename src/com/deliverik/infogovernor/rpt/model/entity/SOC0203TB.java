/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
 * @Description:自动报表配置列表实体TB类
 * @Author
 * @History
 * @Version V1.0
 * 修改记录：2012/08/09 将ReportConfigurationTB表名改为SOC0203TB
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
	 *自增无意义主键
	 */
	protected Integer id;

	/**
	 *自增无意义主键取得
	 * 
	 * @return 自增无意义主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 *自增无意义主键设定
	 * 
	 * @param id自增无意义主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 *报表文件的名称
	 */
	protected String r_path;

	/**
	 *报表文件的名称取得
	 * 
	 * @return 报表文件的名称
	 */
	public String getR_path() {
		return r_path;
	}

	/**
	 *报表文件的名称设定
	 * 
	 * @param r_path报表文件的名称
	 */
	public void setR_path(String r_path) {
		this.r_path = r_path;
	}

	/**
	 *报表文件的中文含义
	 */
	protected String r_title;

	/**
	 *报表文件的中文含义取得
	 * 
	 * @return 报表文件的中文含义
	 */
	public String getR_title() {
		return r_title;
	}

	/**
	 *报表文件的中文含义设定
	 * 
	 * @param r_title报表文件的中文含义
	 */
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	/**
	 *报表运行时所用的参数
	 */
	protected String para;

	/**
	 *报表运行时所用的参数取得
	 * 
	 * @return 报表运行时所用的参数
	 */
	public String getPara() {
		return para;
	}

	/**
	 *报表运行时所用的参数设定
	 * 
	 * @param para报表运行时所用的参数
	 */
	public void setPara(String para) {
		this.para = para;
	}

	public Serializable getPK() {
		return id;
	}

	/**
	 *数据ID
	 */
	protected String dataid;

	/**
	 * @return the 数据ID
	 */
	public String getDataid() {
		return dataid;
	}

	/**
	 * @param 数据ID
	 */
	public void setDataid(String dataid) {
		this.dataid = dataid;
	}
}
