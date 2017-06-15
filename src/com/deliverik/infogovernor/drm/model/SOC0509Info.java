/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 预案章节信息接口
  * 功能描述: 预案章节信息接口
  * 创建记录: 2016/07/07
  * 修改记录: 
  */
public interface SOC0509Info extends BaseModel {

	/**
	 * cid取得
	 *
	 * @return cid
	 */
	public String getCid();

	/**
	 * eid取得
	 *
	 * @return eid
	 */
	public String getEid();

	/**
	 * pcid取得
	 *
	 * @return pcid
	 */
	public String getPcid();

	/**
	 * cname取得
	 *
	 * @return cname
	 */
	public String getCname();

	/**
	 * clabel取得
	 *
	 * @return clabel
	 */
	public String getClabel();

	/**
	 * cdesc取得
	 *
	 * @return cdesc
	 */
	public String getCdesc();

	/**
	 * cunit取得
	 *
	 * @return cunit
	 */
	public String getCunit();

	/**
	 * cstatus取得
	 *
	 * @return cstatus
	 */
	public String getCstatus();

	/**
	 * cseq取得
	 *
	 * @return cseq
	 */
	public Integer getCseq();

	/**
	 * ccategory取得
	 *
	 * @return ccategory
	 */
	public String getCcategory();

	/**
	 * coption取得
	 *
	 * @return coption
	 */
	public String getCoption();

	/**
	 * cattach取得
	 *
	 * @return cattach
	 */
	public String getCattach();

	/**
	 * esyscoding取得
	 *
	 * @return esyscoding
	 */
	public String getEsyscoding();
	
	/**
	 * corder取得
	 * @return corder
	 */
	public String getCorder();

}