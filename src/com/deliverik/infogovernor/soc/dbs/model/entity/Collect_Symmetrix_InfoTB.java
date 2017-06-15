/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.dbs.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;

/**
 * 
 * @Description:存储基本信息实体TB类
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Collect_Symmetrix_Info", schema="cst")
public class Collect_Symmetrix_InfoTB extends BaseEntity implements
		Serializable, Cloneable, Collect_Symmetrix_Info {
	@Id
	@TableGenerator(name = "COLLECT_SYMMETRIX_INFO_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "COLLECT_SYMMETRIX_INFO_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "COLLECT_SYMMETRIX_INFO_TABLE_GENERATOR")
	/*
	 * *主键ID
	 */
	protected Integer id;

	/**
	 *主键ID取得
	 * 
	 * @return 主键ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 *主键ID设定
	 * 
	 * @param id主键ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 *序列号
	 */
	protected String symm_id;

	/**
	 *序列号取得
	 * 
	 * @return 序列号
	 */
	public String getSymm_id() {
		return symm_id;
	}

	/**
	 *序列号设定
	 * 
	 * @param symm_id序列号
	 */
	public void setSymm_id(String symm_id) {
		this.symm_id = symm_id;
	}

	/**
	 *型号
	 */
	protected String symm_model;

	/**
	 *型号取得
	 * 
	 * @return 型号
	 */
	public String getSymm_model() {
		return symm_model;
	}

	/**
	 *型号设定
	 * 
	 * @param symm_model型号
	 */
	public void setSymm_model(String symm_model) {
		this.symm_model = symm_model;
	}

	/**
	 *微码版本
	 */
	protected String symm_version;

	/**
	 *微码版本取得
	 * 
	 * @return 微码版本
	 */
	public String getSymm_version() {
		return symm_version;
	}

	/**
	 *微码版本设定
	 * 
	 * @param symm_version微码版本
	 */
	public void setSymm_version(String symm_version) {
		this.symm_version = symm_version;
	}

	/**
	 *缓存
	 */
	protected String symm_cachesize;

	/**
	 *缓存取得
	 * 
	 * @return 缓存
	 */
	public String getSymm_cachesize() {
		return symm_cachesize;
	}

	/**
	 *缓存设定
	 * 
	 * @param symm_cachesize缓存
	 */
	public void setSymm_cachesize(String symm_cachesize) {
		this.symm_cachesize = symm_cachesize;
	}

	public Serializable getPK() {
		return id;
	}
	
	/**
	 *存储类型
	 */
	protected String symm_type;

	/**
	 * @return 存储类型
	 */
	public String getSymm_type() {
		return symm_type;
	}

	/**
	 * @param 存储类型
	 */
	public void setSymm_type(String symm_Type) {
		symm_type = symm_Type;
	}
}
