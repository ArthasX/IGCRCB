/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCond;

/**
 * 
 * 授权管理逻辑接口
 *
 */
public interface IG711BL extends BaseBL{
	/**
	 * 授权插入处理
	 * 
	 * @param Ig711
	 * @return Ig711
	 */
	public IG711Info insertIG711Info(IG711Info ig711Info) throws BLException;

	/**
	 * 授权查询处理
	 * 
	 * @param List<IG711Info>
	 * @return List<IG711Info>
	 */
	public List<IG711Info> searchIG711Info(IG711SearchCond cond, final int start, final int count) throws BLException;
	
	/**
	 * 授权按主键查询处理
	 * 
	 * @param Ig711
	 * @return Ig711
	 */
	public IG711Info findIG711InfoByPk(Integer paid) throws BLException;
}
