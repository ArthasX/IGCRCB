/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_服务水平信息MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface SdlInfo  extends BaseModel {

	/**
	 * 获取主键
	 * @return 主键
	 */
	public abstract Integer getSiid();

	/**
	 * 获取类别
	 * @return 类别
	 */
	public abstract String getSitype();

	/**
	 * 获取说明
	 * @return 说明
	 */
	public abstract String getSidesc();

	/**
	 * 获取开始时间
	 * @return 开始时间
	 */
	public abstract String getSibegin();

	/**
	 * 获取结束时间
	 * @return 结束时间
	 */
	public abstract String getSiend();

	/**
	 * 获取评分
	 * @return 评分
	 */
	public abstract Integer getSimark();

	/**
	 * 获取相关资产ID
	 * @return 相关资产ID
	 */
	public abstract Integer getSieiid();

	/**
	 * 获取相关资产名称
	 * @return 相关资产名称
	 */
	public abstract String getSieiname();

	/**
	 * 获取相关流程ID
	 * @return 相关流程ID
	 */
	public abstract Integer getSiprid();

	/**
	 * 获取相关流程名称
	 * @return 相关流程名称
	 */
	public abstract String getSiprtitle();
	
	/**
	 * 获取附件
	 * @return 附件
	 */
	public abstract String getSiattkey();
	
	/**
	 * 获取登记日期
	 * @return 登记日期
	 */
	public abstract String getSidate();
	
	/**
	 * 获取实际时间
	 * @return 实际时间
	 */
	public abstract Integer getSifacttime();

}