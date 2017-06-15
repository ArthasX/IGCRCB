/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.soc.dbs.model.condition;


/**
 * 
 * @Description:存储基本信息Cond类
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Symmetrix_InfoSearchCondImpl implements Collect_Symmetrix_InfoSearchCond{
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
	
	/** 存储名称 */
	protected String symm_id_like;
	
	/**
	 * 存储名称取得
	 * @return 存储名称
	 */
	public String getSymm_id_like() {
		return symm_id_like;
	}

	/**
	 * 存储名称设定
	 * @param symm_id_like存储名称
	 */
	public void setSymm_id_like(String symm_id_like) {
		this.symm_id_like = symm_id_like;
	}
	
	/** 存储类型 */
	protected String symm_type;
	
	/** 存储类型数组 */
	protected String[] symm_typeStr;
	
	/**
	 * 存储类型数组取得
	 * @return 存储类型数组
	 */
	public String[] getSymm_typeStr() {
		return symm_typeStr;
	}

	/**
	 * 存储类型数组设定
	 * @param symm_typeStr存储类型数组
	 */
	public void setSymm_typeStr(String[] symm_typeStr) {
		this.symm_typeStr = symm_typeStr;
	}

	/**
	 * 存储类型取得
	 * @return 存储类型
	 */
	public String getSymm_type() {
		return symm_type;
	}

	/**
	 * 存储类型设定
	 * @param symm_type存储类型
	 */
	public void setSymm_type(String symm_type) {
		this.symm_type = symm_type;
	}
}

