/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: SOC0109VW接口
  * 功能描述: SOC0109VW接口
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
public interface SOC0109VWInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

	/**
	 * 资产模型属性ID                           取得
	 *
	 * @return 资产模型属性ID                           
	 */
	public String getCid();

	/**
	 * 资产模型ID（外键）                       取得
	 *
	 * @return 资产模型ID（外键）                       
	 */
	public String getEid();

	/**
	 * 资产模型属性名称                         取得
	 *
	 * @return 资产模型属性名称                         
	 */
	public String getCname();

	/**
	 * CLABEL                                   取得
	 *
	 * @return CLABEL                                   
	 */
	public String getClabel();

	/**
	 * 资产模型属性说明                         取得
	 *
	 * @return 资产模型属性说明                         
	 */
	public String getCdesc();

	/**
	 * 资产模型属性单位                         取得
	 *
	 * @return 资产模型属性单位                         
	 */
	public String getCunit();

	/**
	 * 资产模型属性状态                         取得
	 *
	 * @return 资产模型属性状态                         
	 */
	public String getCstatus();

	/**
	 * 资产模型属性是否显示标识（1显示，0不显示?取得
	 *
	 * @return 资产模型属性是否显示标识（1显示，0不显示?
	 */
	public String getCseq();

	/**
	 * 资产模型属性所属模型的模型分类           取得
	 *
	 * @return 资产模型属性所属模型的模型分类           
	 */
	public String getCcategory();

	/**
	 * 资产模型属性取值范围ID                   取得
	 *
	 * @return 资产模型属性取值范围ID                   
	 */
	public String getCoption();

	/**
	 * 资产模型属性数据类型                     取得
	 *
	 * @return 资产模型属性数据类型                     
	 */
	public String getCattach();

	/**
	 * 资产模型属性所属模型层次码               取得
	 *
	 * @return 资产模型属性所属模型层次码               
	 */
	public String getEsyscoding();

	/**
	 * 排序标识取得
	 * @return 排序标识
	 */
	public Integer getCorder();

}