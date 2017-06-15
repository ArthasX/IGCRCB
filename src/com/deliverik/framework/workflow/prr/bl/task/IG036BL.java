/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;

/**
 * <p>
 * 日志信息业务逻辑
 * </p>
 */
public interface IG036BL extends BaseBL{
	
	/**
	 * <p>
	 * 添加日志信息
	 * </p>
	 * 
	 * @param ig036Info 日志信息
	 * @return 日志信息
	 * @throws BLException
	 */
	
	public IG036Info registIG036Info(IG036Info ig036Info) throws BLException;

	/**
	 * <p>
	 * 修改日志信息
	 * </p>
	 * 
	 * @param ig036Info 日志信息
	 * @return 日志信息
	 * @throws BLException
	 */
	
	public IG036Info updateG036Info(IG036Info ig036Info) throws BLException;
	
	/**
	 * <p>
	 * 获取指定流程记录的所有日志信息
	 * </p>
	 * 
	 * @param processId 流程记录ID
	 * @return 日志信息集合
	 * @throws BLException
	 */
	
	public List<IG036Info> searchIG036InfoByPrid(Integer processId);
	
	/**
	 * 根据主键查询日志信息
	 * 
	 * @param pk 主键值
	 * @return 日志信息
	 * @throws BLException
	 */
	
	public IG036Info searchIG036InfoByPK(Integer pk) throws BLException;
	
	/**
	 * 获取日志信息实例
	 * 
	 * @return 日志信息实体
	 * @throws BLException
	 */
	
	public IG036TB getIG036TBInstance();
	
	/**
	 * 根据查询条件获取日志信息集合
	 * @param 日志参数值信息集合
	 * @throws BLException
	 */
	public List<IG036Info> searchIG036InfoByCond(IG036SearchCond cond);
}
