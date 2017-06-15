/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѵ�ƻ���ѯ������
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM15141VO extends BaseVO implements Serializable{
	
	/**ȡ����ѵ�ƻ���������*/
	private  List<TrainplanInfo> trainplanInfoList; 
	
	/**ȡ����ѵ������������*/
	private  List<TrainmissionInfo> trainmissionInfoList; 
	
	/**ȡ����ѵ�ƻ�һ������*/
	private TrainplanInfo trainplanInfo; 

	/**ȡ����ѵ�ƻ�����ѵ������������Map*/
	private Map<String,List<TrainmissionInfo>> trainPlanMissionMap;
	
	/**
	 * ��ѵ�ƻ�List ȡ��
	 * 
	 * @return trainplanInfoList ��ѵ�ƻ�List
	 */
	public List<TrainplanInfo> getTrainplanInfoList() {
		return trainplanInfoList;
	}

	/**
	 * ��ѵ�ƻ�List �趨
	 * 
	 * @return trainplanInfoList ��ѵ�ƻ�List
	 */
	public void setTrainplanInfoList(List<TrainplanInfo> trainplanInfoList) {
		this.trainplanInfoList = trainplanInfoList;
	}

	/**
	 * ��ѵ����List ȡ��
	 * 
	 * @return trainmissionInfoList ��ѵ����List
	 */
	public List<TrainmissionInfo> getTrainmissionInfoList() {
		return trainmissionInfoList;
	}

	/**
	 * ��ѵ����List �趨
	 * 
	 * @return trainmissionInfoList ��ѵ����List
	 */
	public void setTrainmissionInfoList(List<TrainmissionInfo> trainmissionInfoList) {
		this.trainmissionInfoList = trainmissionInfoList;
	}

	/**
	 * ��ѵ�ƻ�Info ȡ��
	 * 
	 * @return trainplanInfo ��ѵ�ƻ�Info
	 */
	public TrainplanInfo getTrainplanInfo() {
		return trainplanInfo;
	}

	/**
	 * ��ѵ�ƻ�Info �趨
	 * 
	 * @return trainplanInfo ��ѵ�ƻ�Info
	 */
	public void setTrainplanInfo(TrainplanInfo trainplanInfo) {
		this.trainplanInfo = trainplanInfo;
	}

	/**
	 * ��ѵ�ƻ�����ѵ����Map ȡ��
	 * 
	 * @return trainPlanMissionMap ��ѵ�ƻ�����ѵ����Map
	 */
	public Map<String, List<TrainmissionInfo>> getTrainPlanMissionMap() {
		return trainPlanMissionMap;
	}

	/**
	 * ��ѵ�ƻ�����ѵ����Map ȡ��
	 * 
	 * @return trainPlanMissionMap ��ѵ�ƻ�����ѵ����Map
	 */
	public void setTrainPlanMissionMap(
			Map<String, List<TrainmissionInfo>> trainPlanMissionMap) {
		this.trainPlanMissionMap = trainPlanMissionMap;
	}
	
	/**
	 * �����
	 */
	private List<Map<String, Object>> resultList;


	/**
	 * �����ȡ��
	 * @return resultList �����
	 */
	public List<Map<String, Object>> getResultList() {
		return resultList;
	}

	/**
	 * ������趨
	 * @param resultList �����
	 */
	public void setResultList(List<Map<String, Object>> resultList) {
		this.resultList = resultList;
	}
}
