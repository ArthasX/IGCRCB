/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.soc.dbs.model.condition;


/**
 * 
 * @Description:存储基本信息Cond接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_InfoSearchCond{
	/**
	 *序列号
	 */
	public String getSymm_id();

	/**
	 *型号
	 */
	public String getSymm_model();

	/**
	 *微码版本
	 */
	public String getSymm_version();

	/**
	 *缓存
	 */
	public String getSymm_cachesize();

	/**
	 * 存储名称取得
	 * 
	 * @return 存储名称
	 */
	public String getSymm_id_like();
	
	/**
	 * 存储类型取得
	 * @return 存储类型
	 */
	public String getSymm_type();
	
	/**
	 * 存储类型数组取得
	 * @return 存储类型数组
	 */
	public String[] getSymm_typeStr();

}

