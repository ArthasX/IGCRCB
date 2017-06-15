/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 概述: 预算与项目关系表实体接口
 * 功能描述：预算与项目关系表实体接口
 * 创建人：王廷志
 * 创建记录： 2012-5-17
 * 修改记录：
 */
public interface ProjectBudgetRelationInfo extends BaseModel{
	/**
	 * 关系表主键取得
	 * @return pbid 关系表主键
	 */
	public Integer getPbid() ;
	/**
	 * 项目ID取得
	 * @return pid 项目ID
	 */
	public Integer getPid() ;
	/**
	 * 预算ID取得
	 * @return bid 预算ID
	 */
	public Integer getBid();
	/**
	 * 预算资本金开发取得
	 * @return bzdevelop 预算资本金开发
	 */
	public Double getBzdevelop() ;
	/**
	 * 预算资本金硬件取得
	 * @return bzhardware 预算资本金硬件
	 */
	public Double getBzhardware() ;
	/**
	 * 预算资本金软件取得
	 * @return bzsoftware 预算资本金软件
	 */
	public Double getBzsoftware();
	/**
	 * 预算资本金工程取得
	 * @return bzproject 预算资本金工程
	 */
	public Double getBzproject() ;
	/**
	 * 预算资本金其他取得
	 * @return bzelse 预算资本金其他
	 */
	public Double getBzelse();
	/**
	 * 预算成本金实施取得
	 * @return bcimplement 预算成本金实施
	 */
	public Double getBcimplement() ;
	/**
	 * 预算成本金其他取得
	 * @return bcelse 预算成本金其他
	 */
	public Double getBcelse() ;
	/**
	 * 更新时间取得
	 * @return pbdatetime 更新时间
	 */
	public String getPbdatetime() ;
}
