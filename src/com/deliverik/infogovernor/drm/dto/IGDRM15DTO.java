/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.drm.form.IGDRM1501Form;
import com.deliverik.infogovernor.drm.form.IGDRM1502Form;
import com.deliverik.infogovernor.drm.form.IGDRM1503Form;
import com.deliverik.infogovernor.drm.form.IGDRM1511Form;
import com.deliverik.infogovernor.drm.form.IGDRM1512Form;
import com.deliverik.infogovernor.drm.form.IGDRM1514Form;
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
public class IGDRM15DTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	/**取得培训计划所有数据*/
	private  List<TrainplanInfo> trainplanInfoList; 
	
	/**取得培训任务所有数据*/
	private  List<TrainmissionInfo> trainmissionInfoList; 
	
	/**取得培训计划一条数据*/
	private TrainplanInfo trainplanInfo; 

	/**取得培训计划和培训任务所有数据Map*/
	private Map<String,List<TrainmissionInfo>> trainPlanMissionMap;
	
	/** 培训计划Form */
	protected IGDRM1501Form igdrm1501Form;
	
	/** 培训任务Form*/
	protected IGDRM1502Form igdrm1502Form;
	
	/** 培训计划管理Form*/
	protected IGDRM1511Form igdrm1511Form;
	
	/** 培训计划更新Form*/
	protected IGDRM1512Form igdrm1512Form;
	
	/** 培训计划form */
	protected IGDRM1503Form igdrm1503Form;
	
	/** 培训计划对象 */
	protected String[] deleteEntityItem;
	
	/**
	 * 培训删除计划对象取得
	 * @return 培训计划对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 培训删除计划对象设定
	 * @param deleteEntityItem 培训计划对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	
	/**
	 * @return the igdrm1503Form
	 */
	public IGDRM1503Form getIgdrm1503Form() {
		return igdrm1503Form;
	}

	/**
	 * @param igdrm1503Form the igdrm1503Form to set
	 */
	public void setIgdrm1503Form(IGDRM1503Form igdrm1503Form) {
		this.igdrm1503Form = igdrm1503Form;
	}
	
	public IGDRM1514Form getIgdrm1514Form() {
		return igdrm1514Form;
	}

	public void setIgdrm1514Form(IGDRM1514Form igdrm1514Form) {
		this.igdrm1514Form = igdrm1514Form;
	}
	protected IGDRM1514Form igdrm1514Form;
	
	/** 允许查询的最大记录数 */
	protected int maxSearchCount;
	
	/** 保留字段 */
	protected String fingerprint;

	/** 分页用DTO */
	protected PagingDTO pagingDto;
	
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
	 * 培训计划Form取得
	 * 
	 * @return igdrm1501Form 培训计划Form
	 */
	public IGDRM1501Form getIgdrm1501Form() {
		return igdrm1501Form;
	}

	/**
	 * 培训计划Form設定
	 * 
	 * @return igdrm1501Form 培训计划Form
	 */
	public void setIgdrm1501Form(IGDRM1501Form igdrm1501Form) {
		this.igdrm1501Form = igdrm1501Form;
	}

	/**
	 * 培训任务Form取得
	 * 
	 * @return igdrm1502Form 培训任务Form
	 */
	public IGDRM1502Form getIgdrm1502Form() {
		return igdrm1502Form;
	}

	/**
	 * 培训任务Form设定
	 * 
	 * @return igdrm1502Form 培训任务Form
	 */
	public void setIgdrm1502Form(IGDRM1502Form igdrm1502Form) {
		this.igdrm1502Form = igdrm1502Form;
	}

	/**
	 * maxSearchCount 取得
	 * 
	 * @return maxSearchCount maxSearchCount
	 */

	public int getMaxSearchCount() {
		return maxSearchCount;
	}
	
	/**
	 * maxSearchCount 设定
	 * 
	 * @return maxSearchCount maxSearchCount
	 */


	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	
	/**
	 * fingerprint 取得
	 * 
	 * @return fingerprint fingerprint
	 */
	public String getFingerprint() {
		return fingerprint;
	}
	
	/**
	 * fingerprint 设定
	 * 
	 * @return fingerprint fingerprint
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	
	/**
	 * pagingDto 取得
	 * 
	 * @return pagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	
	/**
	 * pagingDto 设定
	 * 
	 * @return pagingDto pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 培训计划管理Form取得
	 * 
	 * @return igdrm1511Form 培训计划管理Form
	 */
	public IGDRM1511Form getIgdrm1511Form() {
		return igdrm1511Form;
	}

	/**
	 * 培训计划管理Form设定
	 * 
	 * @return igdrm1511Form 培训计划管理Form
	 */
	public void setIgdrm1511Form(IGDRM1511Form igdrm1511Form) {
		this.igdrm1511Form = igdrm1511Form;
	}

	/**
	 * 培训计划更新Form取得
	 * 
	 * @return igdrm1512Form 培训计划更新Form
	 */
	public IGDRM1512Form getIgdrm1512Form() {
		return igdrm1512Form;
	}

	/**
	 * 培训计划更新Form设定
	 * 
	 * @return igdrm1512Form 培训计划更新Form
	 */
	public void setIgdrm1512Form(IGDRM1512Form igdrm1512Form) {
		this.igdrm1512Form = igdrm1512Form;
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
