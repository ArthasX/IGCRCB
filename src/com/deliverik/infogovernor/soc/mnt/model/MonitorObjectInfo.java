/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Symmetrix_InfoTB;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTypeTB;

/**
  * 概述: 监控对象信息接口
  * 功能描述: 监控对象信息接口
  * 创建记录: 2012/02/07
  * 修改记录: 
  */
public interface MonitorObjectInfo extends BaseModel {

	/**
	 * 主键Id取得
	 *
	 * @return 主键Id
	 */
	public Integer getMoId();

	/**
	 * 监控对象名称取得
	 *
	 * @return 监控对象名称
	 */
	public String getMoName();

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getMoCreateTime();

	/**
	 * 监控类型层次码取得
	 *
	 * @return 监控类型层次码
	 */
	public String getMtSyscoding();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getDeleteFlag();
	
	/**
	 * ip地址取得
	 * @return
	 */
	public String getIp();
	
	/**
	 * MonitorTypeTB 实体获取
	 * @return
	 */
	public MonitorTypeTB getMonitorTypeTB();
	
	/**
	 * Collect_Symmetrix_InfoTB 实体取得
	 * @return
	 */
	public Collect_Symmetrix_InfoTB getCollect_Symmetrix_InfoTB();

}