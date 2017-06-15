/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.condition.IG715SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG715TB;

/**
 * 
 * 服务工单关联流程业务逻辑接口
 *
 */
public interface IG715BL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG715SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param raid 服务工单关联流程ID
	 * @return 服务工单关联流程
	 */
	public IG715Info searchIG715InfoByKey(Integer raid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部服务服务工单关联流程
	 */
	public List<IG715Info> searchIG715InfoAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG715Info> searchIG715Info(IG715SearchCond cond, int start, int count);

	/**
	 * 保存处理
	 * 
	 * @param IG715Info 保存数据
	 * @return 服务工单关联流程
	 */
	public IG715Info registIG715Info(IG715Info ig715Info) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param IG715Info 变更数据
	 * @return 服务工单关联流程
	 */
	public IG715Info updateIG715Info(IG715Info ig715Info) throws BLException;

	/**
	 * 获取实体对象
	 * @return 实体对象
	 */
	public IG715TB getIG715TBInstance();
}
