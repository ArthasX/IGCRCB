/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.drm.model.TrainmissionInfo;
import com.deliverik.infogovernor.drm.model.TrainplanInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM15011VO extends BaseVO implements Serializable{
	
	/**取得培训计划所有数据*/
	private  List<TrainplanInfo> trainplanInfoList; 
	
	/**取得培训任务所有数据*/
	private  List<TrainmissionInfo> trainmissionInfoList; 
	
	/**取得培训计划一条数据*/
	private TrainplanInfo trainplanInfo; 

	/**取得培训计划和培训任务所有数据Map*/
	private Map<String,List<TrainmissionInfo>> trainPlanMissionMap;
	
	/**
	 * 培训计划List 取得
	 * 
	 * @return trainplanInfoList 培训计划List
	 */
	public List<TrainplanInfo> getTrainplanInfoList() {
		return trainplanInfoList;
	}

	/**
	 * 培训计划List 设定
	 * 
	 * @return trainplanInfoList 培训计划List
	 */
	public void setTrainplanInfoList(List<TrainplanInfo> trainplanInfoList) {
		this.trainplanInfoList = trainplanInfoList;
	}

	/**
	 * 培训任务List 取得
	 * 
	 * @return trainmissionInfoList 培训任务List
	 */
	public List<TrainmissionInfo> getTrainmissionInfoList() {
		return trainmissionInfoList;
	}

	/**
	 * 培训任务List 设定
	 * 
	 * @return trainmissionInfoList 培训任务List
	 */
	public void setTrainmissionInfoList(List<TrainmissionInfo> trainmissionInfoList) {
		this.trainmissionInfoList = trainmissionInfoList;
	}

	/**
	 * 培训计划Info 取得
	 * 
	 * @return trainplanInfo 培训计划Info
	 */
	public TrainplanInfo getTrainplanInfo() {
		return trainplanInfo;
	}

	/**
	 * 培训计划Info 设定
	 * 
	 * @return trainplanInfo 培训计划Info
	 */
	public void setTrainplanInfo(TrainplanInfo trainplanInfo) {
		this.trainplanInfo = trainplanInfo;
	}

	/**
	 * 培训计划和培训任务Map 取得
	 * 
	 * @return trainPlanMissionMap 培训计划和培训任务Map
	 */
	public Map<String, List<TrainmissionInfo>> getTrainPlanMissionMap() {
		return trainPlanMissionMap;
	}

	/**
	 * 培训计划和培训任务Map 取得
	 * 
	 * @return trainPlanMissionMap 培训计划和培训任务Map
	 */
	public void setTrainPlanMissionMap(
			Map<String, List<TrainmissionInfo>> trainPlanMissionMap) {
		this.trainPlanMissionMap = trainPlanMissionMap;
	}
	
	/**
	 * 结果集
	 */
	private List<Map<String, Object>> resultList;


	/**
	 * 结果集取得
	 * @return resultList 结果集
	 */
	public List<Map<String, Object>> getResultList() {
		return resultList;
	}

	/**
	 * 结果集设定
	 * @param resultList 结果集
	 */
	public void setResultList(List<Map<String, Object>> resultList) {
		this.resultList = resultList;
	}
}
