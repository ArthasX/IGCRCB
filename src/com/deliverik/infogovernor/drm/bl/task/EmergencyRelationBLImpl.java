/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyRelationSearchCond;
import com.deliverik.infogovernor.drm.model.dao.EmergencyRelationDAO;
import com.deliverik.infogovernor.drm.model.entity.EmergencyRelationTB;

/**
 * 流程关系业务逻辑实现
 * 
 */
public class EmergencyRelationBLImpl extends BaseBLImpl implements EmergencyRelationBL{
	
	/** 比较器，按建立时间*/
	protected static final ProcessRecordRelationComparator processRecordRelationComparator = new ProcessRecordRelationComparator();
	
	
	/** EmergencyRelation DAO */
	protected EmergencyRelationDAO emergencyRelationDao;
	
	public void setEmergencyRelationDao(
			EmergencyRelationDAO EmergencyRelationDao) {
		this.emergencyRelationDao = EmergencyRelationDao;
	}
	
	/**
	 * 获取流程关系实例
	 * @return EmergencyRelationTB
	 */
	public EmergencyRelationTB getEmergencyRelationTBInstance(){
		return new EmergencyRelationTB();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(EmergencyRelationSearchCond cond){
		
		return emergencyRelationDao.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param erid 流程关系ID
	 * @return 流程关系
	 */
	public EmergencyRelationInfo searchEmergencyRelationInfoByKey(Integer erid) throws BLException{
		
		return checkExistProcessRecordRelation(erid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部流程关系信息
	 */
	public List<EmergencyRelationInfo> searchEmergencyRelationInfoAll(){
		
		return emergencyRelationDao.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EmergencyRelationInfo> searchEmergencyRelationInfo(EmergencyRelationSearchCond cond, int start, int count){
		
		return emergencyRelationDao.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param EmergencyRelationInfo 登录数据
	 * @return 流程关系
	 */
	public EmergencyRelationInfo registEmergencyRelationInfo(EmergencyRelationInfo emergencyRelationInfo) throws BLException{
		
		return emergencyRelationDao.save(emergencyRelationInfo);
	}

	/**
	 * 删除处理
	 * 
	 * @param erid 流程关系ID
	 * @return
	 */
	public void deleteEmergencyRelationInfo(Integer erid) throws BLException{
		
		EmergencyRelationInfo processRecordRelation = checkExistProcessRecordRelation(erid);
		
		emergencyRelationDao.delete(processRecordRelation);
	}

	/**
	 * 变更处理
	 * 
	 * @param EmergencyRelationInfo 变更数据
	 * @return 流程关系
	 */
	public EmergencyRelationInfo updateEmergencyRelationInfo(EmergencyRelationInfo emergencyRelationInfo) throws BLException{
		
		checkExistProcessRecordRelation(emergencyRelationInfo.getErid());
		return emergencyRelationDao.save(emergencyRelationInfo);
	}

	/**
	 * 流程关系存在检查
	 * 
	 * @param erid 流程关系ID
	 * @return 流程关系
	 * @throws BLException 
	 */
	protected EmergencyRelationInfo checkExistProcessRecordRelation(Integer erid) throws BLException{
		EmergencyRelationInfo info = emergencyRelationDao.findByPK(erid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程关系基本");
		}
		return info;
	}
	
	/**
	 * 流程关系按建立时间排序（升序）
	 * 
	 * @param emergencyRelationInfoList 流程关系列表
	 * 
	 */
	public void orderByTimeAsc(List<EmergencyRelationInfo> emergencyRelationInfoList) {
		if(emergencyRelationInfoList != null && emergencyRelationInfoList.size() > 0) {
			Collections.sort(emergencyRelationInfoList, processRecordRelationComparator);
		}
	}
	
}

	/**
	 * 比较器，按建立时间（升序）
	 * 
	 * */
	class ProcessRecordRelationComparator implements Comparator<EmergencyRelationInfo> {
	
		public int compare(EmergencyRelationInfo arg0, EmergencyRelationInfo arg1) {
			int flag = arg0.getErid().compareTo(arg1.getErid());
			return flag;
		}
	
	}
