/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG113TB;

/**
 * <p>
 *  表单日志信息业务逻辑
 * </p>
 */

public interface IG113BL extends BaseBL {


	/**
	 * 保存表单日志
	 * @param 表单日志集合
	 * @throws BLException
	 */
	public IG113Info registIG113Info(IG113Info ig113Info) throws BLException;
	
	/**
	 * 保存表单日志
	 * @param 表单日志集合
	 * @throws BLException
	 */
	public void UpdateIG113Info(List<IG113Info> ig113InfoList) throws BLException;

	/**
	 * 根据流程记录ID获取表单日志信息集合
	 * @param 表单日志信息集合
	 * @throws BLException
	 */
	public List<IG113Info> searchIG113InfoByIG036Info(Integer rlid);
	
	/**
	 * 根据流程变量ID获取表单日志信息集合
	 * @param piid 流程变量ID
	 * @throws BLException 
	 */
	public IG113Info searchIG113InfoByRlvid(Integer rlvid) throws BLException;
	
	/**
	 * 获取表单日志实例
	 * 
	 * @return RecordLogVarInfoTB
	 * @throws BLException
	 */
	
	public IG113TB getIG113TBInstance();
	
	/**
	 * 保存表单日志
	 * @param 表单日志集合
	 * @throws BLException
	 */
	public void saveOrUpdIG113Info(List<IG113Info> ig113InfoList) throws BLException;
	
	/**
	 * 根据查询条件获取表单日志信息集合
	 * @param 表单日志信息集合
	 * @throws BLException
	 */
	public List<IG113Info> searchIG113InfoByCond(IG113SearchCond cond);
}
