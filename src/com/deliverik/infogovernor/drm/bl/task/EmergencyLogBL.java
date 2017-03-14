/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;

/**
 * 概述：应急日志信息表业务逻辑接口
 * 功能描述：应急日志信息表业务逻辑接口
 * 创建记录：2014/05/19
 * 修改记录：
 */
public interface EmergencyLogBL extends BaseBL {
	/**
	 * 应急人员就位表实例取得
	 * 
	 * @return 应急人员就位表实例
	 */
	public EmergencyLogTB getEmergencyLogTBInstance();
	
	/**
	 * 全件检索处理
	 * 
	 * @return 检索结果列表
	 * @throws BLException
	 */
	public List<EmergencyLogInfo> searchEmergencyLog() throws BLException;
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 * @throws BLException
	 */
	public int getSearchCount(EmergencyLogSearchCond cond) throws BLException;

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 * @throws BLException
	 */
	public List<EmergencyLogInfo> searchEmergencyLogByCond(EmergencyLogSearchCond cond) throws BLException;

	/**
	 * 条件检索处理(分页查询)
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 * @throws BLException
	 */
	public List<EmergencyLogInfo> searchEmergencyLogByCondForPage(EmergencyLogSearchCond cond, int start, int count) throws BLException;
	
	/**
	 * 新增应急人员就位信息处理
	 * 
	 * @param 应急人员就位信息
	 * @return 应急人员就位信息
	 * @throws BLException
	 */
	public EmergencyLogInfo registEmergencyLog(EmergencyLogInfo emergencyLog) throws BLException;

	/**
	 * 删除应急人员就位信息处理
	 * 
	 * @param entityItem 应急人员就位信息
	 * @throws BLException
	 */
	public void deleteEmergencyLog(EmergencyLogInfo emergencyLog) throws BLException;
	
	/**
	 * 根据应急人员就位信息主键删除应急人员就位信息处理
	 * 
	 * @param ecid 删除应急人员就位信息的主键
	 * @throws BLException
	 */
	public void deleteEmergencyLogByPK(Integer ecid) throws BLException;

	/**
	 * 变更应急人员就位信息处理
	 * 
	 * @param entityItem 应急人员就位信息
	 * @return 应急人员就位信息
	 * @throws BLException
	 */
	public EmergencyLogInfo updateEmergencyLog(EmergencyLogInfo emergencyLog) throws BLException;
	
	/**
	 * 应急人员就位信息存在检查
	 * 
	 * @param ecid 应急人员就位信息的主键
	 * @throws BLException 
	 */
	public EmergencyLogInfo checkExistEmergencyLog(Integer ecid) throws BLException;
	
	/**
	 * 终止流程查询表中最大的时间
	 * 
	 * @param prid 应急人员就位信息的主键
	 * @throws BLException 
	 */
	public EmergencyLogInfo findMaxTimeEmergencyLog(String prid) throws BLException;
}