/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyRelationSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EmergencyRelationTB;

/**
 * 流程关系业务逻辑接口
 * 
 */
public interface EmergencyRelationBL extends BaseBL{
	
	/**
	 * 获取流程关系实例
	 * @return EmergencyRelationTB
	 */
	public EmergencyRelationTB getEmergencyRelationTBInstance();
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(EmergencyRelationSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param pprid 流程关系ID
	 * @return 流程关系
	 */
	public EmergencyRelationInfo searchEmergencyRelationInfoByKey(Integer erid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部流程关系信息
	 */
	public List<EmergencyRelationInfo> searchEmergencyRelationInfoAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EmergencyRelationInfo> searchEmergencyRelationInfo(EmergencyRelationSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param EmergencyRelationInfo 登录数据
	 * @return 流程关系
	 */
	public EmergencyRelationInfo registEmergencyRelationInfo(EmergencyRelationInfo emergencyRelationInfo) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param pprid 流程关系ID
	 * @return
	 */
	public void deleteEmergencyRelationInfo(Integer pprid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param EmergencyRelationInfo 变更数据
	 * @return 流程关系
	 */
	public EmergencyRelationInfo updateEmergencyRelationInfo(EmergencyRelationInfo emergencyRelationInfo) throws BLException;
	
	/**
	 * 流程关系按建立时间排序（升序）
	 * 
	 * @param EmergencyRelationInfoList 流程关系列表
	 * 
	 */
	public void orderByTimeAsc(List<EmergencyRelationInfo> emergencyRelationInfoList);
	
}
