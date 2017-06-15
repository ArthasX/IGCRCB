/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.iam.model.entity.InternalauditprjTB;

/**
  * 概述: 内置工作表接口
  * 功能描述: 内置工作表接口
  * 创建记录: 2012/07/25
  * 修改记录: 
  */
public interface InternalauditJobInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getIajid();

	/**
	 * 计划年度取得
	 *
	 * @return 计划年度
	 */
	public String getIajyear();

	/**
	 * 内置项目ID取得
	 *
	 * @return 内置项目ID
	 */
	public Integer getIajiapid();

	/**
	 * 工作名称取得
	 *
	 * @return 工作名称
	 */
	public String getIajname();

	/**
	 * 实际工作开始日期取得
	 *
	 * @return 实际工作开始日期
	 */
	public String getIajstarttime();

	/**
	 * 实际工作结束日期取得
	 *
	 * @return 实际工作结束日期
	 */
	public String getIajovertime();

	/**
	 * 工作内容描述取得
	 *
	 * @return 工作内容描述
	 */
	public String getIajdesc();

	/**
	 * 登记时间取得
	 *
	 * @return 登记时间
	 */
	public String getIajinserttime();

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getIajattkey();

	/**
	 * 登记人ID取得
	 *
	 * @return 登记人ID
	 */
	public String getIajuserid();
	
	/**
	 * 获取内审项目信息实体
	 * @return
	 */
	public  InternalauditprjTB getInternalauditprjTB();
}