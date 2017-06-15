/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG463Info;
import com.deliverik.framework.workflow.prr.model.condition.IG463SearchCond;

/**
 * <p>概述:代理工作业务逻辑接口</p>
 * <p>功能描述：1.授权工作插入处理</p>
 * <p>          2.变更处理</p>
 * <p>          3.授权工作查询处理</p>
 * <p>          4.授权工作按主键查询处理</p>
 * <p>创建记录：</p>
 */
public interface IG463BL extends BaseBL{
	
	/**
	 * 功能：授权工作插入处理
	 * 
	 * @param IG463Info
	 * @return ProcessProxyWork
	 * @throws BLException
	 */
	public IG463Info insertIG463Info(IG463Info ig463Info) throws BLException;
	
	/**
	 * 功能：变更处理
	 * 
	 * @param IG463Info 变更数据
	 * @return 代理工作
	 * @throws BLException
	 */
	public IG463Info updateIG463Info(IG463Info ig463Info) throws BLException;
	
	/**
	 * 功能：授权工作查询处理
	 * 
	 * @param cond 代理工作查询条件
	 * @param start 检索记录起始号
	 * @param count 检索记录件数
	 * @return List<ProcessProxyWork> 授权工作列表
	 * @throws BLException
	 */
	public List<IG463Info> searchIG463Info(IG463SearchCond cond, final int start, final int count) throws BLException;
	
	/**
	 * 功能：授权工作按主键查询处理
	 * 
	 * @param ppwid 主键
	 * @return ProcessProxyWork 授权工作信息
	 * @throws BLException
	 */
	public IG463Info findIG463InfoByPk(Integer ppwid) throws BLException;
}
