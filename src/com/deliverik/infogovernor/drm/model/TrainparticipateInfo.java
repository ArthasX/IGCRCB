/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 培训参与人接口
  * 功能描述: 培训参与人接口
  * 创建记录: 2015/04/13
  * 修改记录: 
  */
public interface TrainparticipateInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getTpaid();

	/**
	 * 培训人姓名取得
	 *
	 * @return 培训人姓名
	 */
	public String getTpaname();

	/**
	 * 培训人联系电话取得
	 *
	 * @return 培训人联系电话
	 */
	public String getTpatel();

	/**
	 * 培训记录id取得
	 *
	 * @return 培训记录id
	 */
	public Integer getTrid();

}