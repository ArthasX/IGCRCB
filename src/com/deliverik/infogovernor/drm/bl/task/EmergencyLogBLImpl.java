/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCond;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCondImpl;
import com.deliverik.infogovernor.drm.model.dao.EmergencyLogDAO;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;

/**
 * 概述：应急日志信息表业务逻辑实现
 * 功能描述：应急日志信息表业务逻辑实现
 * 创建记录：2014/05/19
 * 修改记录：
 */
public class EmergencyLogBLImpl extends BaseBLImpl implements EmergencyLogBL {
	/**应急日志信息表DAO接口*/
	protected EmergencyLogDAO emergencyLogDAO;
	
	/**
	 * 应急日志信息表DAO设定
	 * @param emergencyLogDAO
	 */
	public void setEmergencyLogDAO(EmergencyLogDAO emergencyLogDAO) {
		this.emergencyLogDAO = emergencyLogDAO;
	}
	
	/**
	 * 应急日志信息表对象实例取得 
	 * @return 应急日志信息表对象实例取得
	 */
	public EmergencyLogTB getEmergencyLogTBInstance() {
		return new EmergencyLogTB();
	}
	
	/**
	 * 全件检索处理
	 * 
	 * @return 检索结果列表
	 * @throws BLException
	 */
	public List<EmergencyLogInfo> searchEmergencyLog() throws BLException {
		return emergencyLogDAO.findAll();
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 * @throws BLException
	 */
	public int getSearchCount(EmergencyLogSearchCond cond) throws BLException {
		return emergencyLogDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 * @throws BLException
	 */
	public List<EmergencyLogInfo> searchEmergencyLogByCond(EmergencyLogSearchCond cond) throws BLException {
		return emergencyLogDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理(分页查询)
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 * @throws BLException
	 */
	public List<EmergencyLogInfo> searchEmergencyLogByCondForPage(EmergencyLogSearchCond cond, int start, int count) throws BLException {
		return emergencyLogDAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增应急日志信息信息处理
	 * 
	 * @param 应急日志信息信息
	 * @return 应急日志信息信息
	 * @throws BLException
	 */
	public EmergencyLogInfo registEmergencyLog(EmergencyLogInfo emergencyLog) throws BLException {
		EmergencyLogInfo result = emergencyLogDAO.save(emergencyLog);
		return result;
	}
	
	/**
	 * 删除应急日志信息信息处理
	 * 
	 * @param emergencyLog 应急日志信息信息
	 * @throws BLException
	 */
	public void deleteEmergencyLog(EmergencyLogInfo emergencyLog)throws BLException {
		checkExistEmergencyLog(emergencyLog.getElid());
		emergencyLogDAO.delete(emergencyLog);
	}
	
	/**
	 * 根据应急日志信息信息主键删除应急人员就位信息处理
	 * 
	 * @param elid 删除应急日志信息信息的主键
	 * @throws BLException
	 */
	public void deleteEmergencyLogByPK(Integer elid) throws BLException {
		EmergencyLogInfo emergencyLogInfo = checkExistEmergencyLog(elid);
		emergencyLogDAO.delete(emergencyLogInfo);
	}
	
	/**
	 * 变更应急日志信息信息处理
	 * 
	 * @param emergencyLog 应急日志信息
	 * @return 应急日志信息
	 * @throws BLException
	 */
	public EmergencyLogInfo updateEmergencyLog(EmergencyLogInfo emergencyLog) throws BLException {
		checkExistEmergencyLog(emergencyLog.getElid());
		EmergencyLogInfo result = emergencyLogDAO.save(emergencyLog);
		return result;
	}
	
	/**
	 *应急日志信息信息存在检查
	 * 
	 * @param elid 应急日志信息信息的主键
	 * @throws BLException 
	 */
	public EmergencyLogInfo checkExistEmergencyLog(Integer elid) throws BLException {
		EmergencyLogInfo info = emergencyLogDAO.findByPK(elid);
		if(info == null) {
			throw new BLException("IGCO10000.E004","应急日志信息");
		}
		return info;
	}
	/**
	 * 终止流程查询表中最大的时间
	 * 
	 * @param elprid是流程实例ID
	 * @throws BLException 
	 */
	public EmergencyLogInfo findMaxTimeEmergencyLog(String elprid)
			throws BLException {
		EmergencyLogSearchCondImpl elCond = new EmergencyLogSearchCondImpl();
		//通过事件来降序排列查处数据
		String[] desc = {"ellidtime"};
		elCond.setDesc(desc);
		elCond.setElprid_eq(elprid);
		List<EmergencyLogInfo> elList = emergencyLogDAO.findByCond(elCond, 0, 0);
		if(elList!= null&&elList.size()>0){
			//取最大时间的实例
			EmergencyLogInfo elInfo = elList.get(0);	
			return elInfo;
		}
		return null;
	}
}