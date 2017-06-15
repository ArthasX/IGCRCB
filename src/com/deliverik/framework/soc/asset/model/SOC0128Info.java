package com.deliverik.framework.soc.asset.model;


/**
 * 资产属性历史版本更新时间
 * 
 */
public interface SOC0128Info  {

	/**
	 * 资产属性大版本号取得
	 * @return 资产属性大版本号
	 */
	public Integer getCiversion();
	
	 /**
	 * 资产属性小版本号取得
	 * @return 资产属性小版本号
	 */
	public Integer getCismallversion();
	
	/**
	 * 资产属性更新时间取得
	 * @return 资产属性更新时间
	 */
	public String getCiupdtime();
	
	
	/**
	 * 是否存在配置文件附件，不存在的在版本比较时不显示 0不显示 1显示
	 * @return 显示标识
	 */
    public String getIsshow();
}