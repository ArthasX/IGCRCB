/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 检查工作统计报表接口
  * 功能描述: 检查工作统计报表接口
  * 创建记录: 2014/07/09
  * 修改记录: 
  */
public interface CheckWorkConutVWInfo extends BaseModel {

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId();
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRcid();

	/**
	 * 检查项名称取得
	 *
	 * @return 检查项名称
	 */
	public String getRcname();
	
	/**
	 * 检查项说明取得
	 * @return the rcdesc
	 */
	public String getRcdesc();

	/**
	 * 检查频率取得
	 *
	 * @return 检查频率
	 */
	public String getRcfrequency();

	/**
	 * 责任人取得
	 *
	 * @return 责任人
	 */
	public String getRcusername();

	/**
	 * 检查项分类取得
	 *
	 * @return 检查项分类
	 */
	public String getRccategoryname();

	/**
	 * 问题名称取得
	 *
	 * @return 问题名称
	 */
	public String getPrtitle();

	/**
	 * 检查方式取得
	 *
	 * @return 检查方式
	 */
	public String getRcrtestmode();

	/**
	 * 检查结果取得
	 *
	 * @return 检查结果
	 */
	public String getRcstatus();

	/**
	 * 实际检查时间取得
	 *
	 * @return 实际检查时间
	 */
	public String getRccreatetime();

	/**
	 * 结果说明取得
	 *
	 * @return 结果说明
	 */
	public String getRcrcomment();

	/**
	 * 检查程度取得
	 *
	 * @return 检查程度
	 */
	public String getRcrresult();

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getRcrattch();

	/**
	 * 检查计划时间取得
	 *
	 * @return 检查计划时间
	 */
	public String getRcrplandate();
	
	/**检查开始时间*/
	public String getRcstartdate();
	
	/**
	 * 风险检查类型取得
	 * @return rcclass 风险检查类型
	 */
	public String getRcclass();
	/**
	 * 附件id取得
	 * @return attachid 附件id
	 */
	public String getAttachid();

}