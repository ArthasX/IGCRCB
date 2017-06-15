package com.deliverik.framework.soc.asset.model;
/**
 * 资产属性信息视图
 * 
 * @author
 */
public interface SOC0606Info {

	/**
	 * 资产属性ID取得
	 * @return 资产属性ID
	 */
	public String getCiid();

	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public String getEiid();

	/**
	 * 资产模型属性ID取得
	 * @return 资产模型属性ID
	 */
	public String getCid();

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid();

	/**
	 * 资产模型属性名称取得
	 * @return 资产模型属性名称
	 */
	public String getCname();

	/**
	 * 资产模型属性说明取得
	 * @return 资产模型属性说明
	 */
	public String getCdesc();

	/**
	 * 资产模型属性单位取得
	 * @return 资产模型属性单位
	 */
	public String getCunit();

	/**
	 * 资产模型属性状态取得
	 * @return 资产模型属性状态
	 */
	public String getCstatus();

	/**
	 * 资产模型属性类型取得
	 * @return 资产模型属性类型 
	 */
	public String getCcategory();

	/**
	 * 资产模型属性是否显示标识取得
	 * @return 资产模型属性是否显示标识
	 */
	public String getCseq();

	/**
	 * 资产模型属性编号取得
	 * @return 资产模型属性编号
	 */
	public String getClabel();

	/**
	 * 资产模型属性取值范围取得
	 * @return 资产模型属性取值范围
	 */
	public String getCoption();

	/**
	 * 资产模型属性附件标识取得
	 * @return 资产模型属性附件标识
	 */
	public String getCattach();

	/**
	 * 资产属性值取得
	 * @return 资产属性值
	 */
	public String getCivalue();

	/**
	 * 资产属性更新时间取得
	 * @return 资产属性更新时间
	 */
	public String getCiupdtime();

	/**
	 * 资产属性过期时间取得
	 * @return 资产属性过期时间
	 */
	public String getCiexpire();

	/**
	 * 资产属性状态取得
	 * @return 资产属性状态
	 */
	public String getCistatus();

	/**
	 * 资产属性大版本号取得
	 * @return 资产属性大版本号
	 */
	public Integer getCiversion();

	/**
	 * 资产属性版本信息取得
	 * @return 资产属性版本信息
	 */
	public String getCiverinfo();
	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding();
	
	public String getEilabel();
	
	public String getEiname();
	
	public String getSrename();
	
	public String getCicurver();
	
	 /**
	 * 资产属性小版本号取得
	 * @return 资产属性小版本号
	 */
	public Integer getCismallversion();
	
	/**
	 * 
	 * 排序标识
	 * @return
	 */
	public Integer getCorder();
	
}