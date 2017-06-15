package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.base.BaseModel;

/**
 * 资产属性信息
 *
 */
public interface SOC0507Info  extends BaseModel {

	/**
	 * 资产属性ID取得
	 * @return 资产属性ID
	 */
	public Integer getCiid();

	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public Integer getEiid();

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
	 * 资产属性失效时间取得
	 * @return 资产属性失效时间
	 */
	public String getCiexpire();

	/**
	 * 资产属性状态取得
	 * @return 资产属性状态
	 */
	public String getCistatus();

	/**
	 * 资产属性当前版本取得
	 * @return 资产属性当前版本
	 */
	public String getCicurver();

	/**
	 * 资产属性版本取得
	 * @return 资产属性版本
	 */
	public Integer getCiversion();

	/**
	 * 资产属性版本信息取得
	 * @return 资产属性版本信息
	 */
	public String getCiverinfo();

	/**
	 * 资产模型属性信息取得
	 * @return 资产模型属性信息
	 */
	public SOC0109Info getConfiguration();
	
	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding();
	
	/**
	 * 资产属性小版本取得
	 * @return 资产属性小版本
	 */
	public Integer getCismallversion();
}