package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 资产关系信息
 *
 */
public interface SOC0119Info  extends BaseModel {

	/**
	 * 资产关系ID取得
	 * @return 资产关系ID
	 */
	public Integer getEirid();

	/**
	 * 资产ID（正向）取得
	 * @return 资产ID（正向）
	 */
	public Integer getPareiid();

	/**
	 * 资产模型ID（正向）取得
	 * @return 资产模型ID（正向）
	 */
	public String getPareid();

	/**
	 * 资产ID（反向）取得
	 * @return 资产ID（反向）
	 */
	public Integer getCldeiid();

	/**
	 * 资产ID（反向）取得
	 * @return 资产ID（反向）
	 */
	public String getCldeid();

	/**
	 * 资产关系更新时间取得
	 * @return 资产关系更新时间
	 */
	public String getEirupdtime();

	/**
	 * 资产关系是否可以删除标识取得
	 * @return 资产关系是否可以删除标识
	 */
	public String getEirstatus();

	/**
	 * 资产关系ID取得
	 * @return 资产关系ID
	 */
	public String getEirrelation();
	
	/**
	 * 资产关系编码取得
	 * @return 资产关系编码
	 */
	public String getEirrelationcode();

	/**
	 * 资产关系说明取得
	 * @return 资产关系说明
	 */
	public String getEirdesc();

	/**
	 * 资产（正向）信息取得
	 * @return 资产（正向）信息
	 */
	public SOC0123Info getParEntityItemVW();
	
	/**
	 * 资产(反向)信息取得
	 * @return 资产（反向）信息
	 */
	public SOC0123Info getCldEntityItemVW();
	
	/**
	 * 资产关系方向（0正向，1反向）取得
	 * @return 资产关系方向
	 */
	public String getParflag();
	
	/**
	 * 正向资产大版本取得
	 * @return 正向资产大版本
	 */
	public Integer getParversion();
	
	/**
	 * 正向资产小版本取得
	 * @return 正向资产小版本
	 */
	public Integer getParsmallversion();
	
	/**
	 * 反向资产大版本取得
	 * @return 反向资产大版本
	 */
	public Integer getCldversion();
	
	/**
	 * 反向资产小版本取得
	 * @return 反向资产小版本
	 */
	public Integer getCldsmallversion();
	
	/**
	 * 逻辑删除标识取得
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag();
	
	/**
	 * 通过资产属性增加自动生成的关系信息取得
	 * @return 通过资产属性增加自动生成的关系信息
	 */
	public String getEirinfo();
	
}