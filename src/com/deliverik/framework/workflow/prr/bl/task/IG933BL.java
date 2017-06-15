/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG933SearchCond;

/**
 * 
 * 服务工单业务逻辑接口
 *
 */
public interface IG933BL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG933SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param raid 服务工单ID
	 * @return 服务工单
	 */
	public IG933Info searchIG933InfoByKey(Integer raid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部服务工单信息
	 */
	public List<IG933Info> searchIG933InfoAll();
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部服务工单信息时间升序
	 */
	public List<IG933Info> searchIG933InfoAllAsc();
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG933Info> searchIG933Info(IG933SearchCond cond, int start, int count);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表时间升序
	 */
	public List<IG933Info> searchIG933InfoAsc(IG933SearchCond cond, int start, int count);
	
	/**
	 * 登记处理
	 * 
	 * @param IG933Info 登记数据
	 * @return 服务工单
	 */
	public IG933Info registIG933Info(IG933Info ig933Info) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param IG933Info 变更数据
	 * @return 服务工单
	 */
	public IG933Info updateIG933Info(IG933Info ig933Info) throws BLException;
	
	 /**
	 * 获取服务工单编号最大值
	 * 
	 * @return 服务工单编号最大值
	 */
	public String searchMaxID(String code) throws BLException;
}
