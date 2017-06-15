/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 状态级私有表单值记录表接口
  * 功能描述: 状态级私有表单值记录表接口
  * 创建记录: 2015/02/07
  * 修改记录: 
  */
public interface IG561VWInfo extends BaseModel {

	/**
	 * 流水id取得
	 *
	 * @return 流水id
	 */
	public Integer getPvlid();

	/**
	 * 流程id取得
	 *
	 * @return 流程id
	 */
	public Integer getPrid();

	/**
	 * 状态id取得
	 *
	 * @return 状态id
	 */
	public String getPsdid();

	/**
	 * 表单id取得
	 *
	 * @return 表单id
	 */
	public String getPidid();

	/**
	 * 表单名称取得
	 *
	 * @return 表单名称
	 */
	public String getPivarname();

	/**
	 * 表单显示取得
	 *
	 * @return 表单显示
	 */
	public String getPivarlabel();

	/**
	 * 表单类型取得
	 *
	 * @return 表单类型
	 */
	public String getPivartype();

	/**
	 * 表单值取得
	 *
	 * @return 表单值
	 */
	public String getPivarvalue();

	/**
	 * 附件key取得
	 *
	 * @return 附件key
	 */
	public String getPiattkey();

	/**
	 * 权限取得
	 *
	 * @return 权限
	 */
	public String getPidaccess();

	/**
	 * 必填取得
	 *
	 * @return 必填
	 */
	public String getPidrequired();
	/**
     * 用户id
     * @return 用户id
     */
	public void setPiuserid(String piuserid);
	/**
     * 表单id (599) 取得
     * @return 表单id599
     */
	public Integer getPiid();
	
	/**
	 * 节点名称
	 * @return 节点名称
	 */
	public String getPsdname();

}