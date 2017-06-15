/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM07TB;

/**
  * 概述: CRM08接口
  * 功能描述: CRM08接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM08Info extends BaseModel {

	/**
	 * RULETEMPID取得
	 *
	 * @return RULETEMPID
	 */
	public Integer getRuletempid();

	/**
	 * RULETEMPNAME取得
	 *
	 * @return RULETEMPNAME
	 */
	public String getRuletempname();

	/**
	 * CATEGORYCCID取得
	 *
	 * @return CATEGORYCCID
	 */
	public String getCategoryccid();

	/**
	 * RULECONDITION取得
	 *
	 * @return RULECONDITION
	 */
	public Integer getRulecondition();

	/**
	 * TEMPSTATE取得
	 *
	 * @return TEMPSTATE
	 */
	public Integer getTempstate();
	
	public Integer getAlarmlevel();

	public String getCategorycid();

	public String getDetail();

	public String getCreatetime();
	
	public List<CRM07TB> getCrm07TBList();
	
	public String getTypecid();
	
	public String getTypeccid();
	
}