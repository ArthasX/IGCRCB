/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG224TB;

/**
 * 流程状态日志业务逻辑接口
 * 
 */
public interface IG224BL extends BaseBL{
	
	/**
	 * 获取流程状态日志实例
	 * @return RecordStatusLogTB
	 */
	public IG224TB getIG224TBInstance();
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG224SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param pprid 流程状态日志ID
	 * @return 流程状态日志
	 */
	public IG224Info searchIG224InfoByKey(Integer pprid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部流程状态日志信息
	 */
	public List<IG224Info> searchIG224InfoAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG224Info> searchIG224Info(IG224SearchCond cond, int start, int count);
	
	/**
	 * 当前流程状态日志信息取得
	 * 
	 * @param prid 流程ID
	 * @param prstatus 流程状态
	 * @return 当前流程状态日志信息
	 * @throws BLException 
	 */
	public List<IG224Info> searchCurrentIG224Info(Integer prid, String prstatus) throws BLException;
	
	/**
	 * 当前流程状态日志信息取得
	 * 
	 * @param prid 流程ID
	 * @param prstatus 流程状态
	 * @return 当前流程状态日志信息
	 * @throws BLException 
	 */
	public List<IG224Info> searchCurrentIG224InfoByPsdid(Integer prid, String psdid) throws BLException;
	
	/**
	 * 登录处理
	 * 
	 * @param ig224Info 登录数据
	 * @return 流程状态日志
	 */
	public IG224Info registIG224Info(IG224Info ig224Info) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param pprid 流程状态日志ID
	 * @return
	 */
	public void deleteIG224Info(Integer pprid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param ig224Info 变更数据
	 * @return 流程状态日志
	 */
	public IG224Info updateIG224Info(IG224Info ig224Info) throws BLException;
	/**
	 * 条件检索处理 dashboard 数据初始化专用
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG224Info> findByCondOrderByRslopentime(final IG224SearchCond cond);
}
