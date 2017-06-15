/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
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

	
	/**ȡ����ѵ�ƻ���������*/
	private  List<TrainplanInfo> trainplanInfoList; 
	
	/**ȡ����ѵ������������*/
	private  List<TrainmissionInfo> trainmissionInfoList; 
	
	/**ȡ����ѵ�ƻ�һ������*/
	private TrainplanInfo trainplanInfo; 

	/**ȡ����ѵ�ƻ�����ѵ������������Map*/
	private Map<String,List<TrainmissionInfo>> trainPlanMissionMap;
	
	/** ��ѵ�ƻ�Form */
	protected IGDRM1501Form igdrm1501Form;
	
	/** ��ѵ����Form*/
	protected IGDRM1502Form igdrm1502Form;
	
	/** ��ѵ�ƻ�����Form*/
	protected IGDRM1511Form igdrm1511Form;
	
	/** ��ѵ�ƻ�����Form*/
	protected IGDRM1512Form igdrm1512Form;
	
	/** ��ѵ�ƻ�form */
	protected IGDRM1503Form igdrm1503Form;
	
	/** ��ѵ�ƻ����� */
	protected String[] deleteEntityItem;
	
	/**
	 * ��ѵɾ���ƻ�����ȡ��
	 * @return ��ѵ�ƻ�����
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ��ѵɾ���ƻ������趨
	 * @param deleteEntityItem ��ѵ�ƻ�����
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
	
	/** �����ѯ������¼�� */
	protected int maxSearchCount;
	
	/** �����ֶ� */
	protected String fingerprint;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
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
	 * ��ѵ�ƻ�Formȡ��
	 * 
	 * @return igdrm1501Form ��ѵ�ƻ�Form
	 */
	public IGDRM1501Form getIgdrm1501Form() {
		return igdrm1501Form;
	}

	/**
	 * ��ѵ�ƻ�Form�O��
	 * 
	 * @return igdrm1501Form ��ѵ�ƻ�Form
	 */
	public void setIgdrm1501Form(IGDRM1501Form igdrm1501Form) {
		this.igdrm1501Form = igdrm1501Form;
	}

	/**
	 * ��ѵ����Formȡ��
	 * 
	 * @return igdrm1502Form ��ѵ����Form
	 */
	public IGDRM1502Form getIgdrm1502Form() {
		return igdrm1502Form;
	}

	/**
	 * ��ѵ����Form�趨
	 * 
	 * @return igdrm1502Form ��ѵ����Form
	 */
	public void setIgdrm1502Form(IGDRM1502Form igdrm1502Form) {
		this.igdrm1502Form = igdrm1502Form;
	}

	/**
	 * maxSearchCount ȡ��
	 * 
	 * @return maxSearchCount maxSearchCount
	 */

	public int getMaxSearchCount() {
		return maxSearchCount;
	}
	
	/**
	 * maxSearchCount �趨
	 * 
	 * @return maxSearchCount maxSearchCount
	 */


	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	
	/**
	 * fingerprint ȡ��
	 * 
	 * @return fingerprint fingerprint
	 */
	public String getFingerprint() {
		return fingerprint;
	}
	
	/**
	 * fingerprint �趨
	 * 
	 * @return fingerprint fingerprint
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	
	/**
	 * pagingDto ȡ��
	 * 
	 * @return pagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	
	/**
	 * pagingDto �趨
	 * 
	 * @return pagingDto pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ��ѵ�ƻ�����Formȡ��
	 * 
	 * @return igdrm1511Form ��ѵ�ƻ�����Form
	 */
	public IGDRM1511Form getIgdrm1511Form() {
		return igdrm1511Form;
	}

	/**
	 * ��ѵ�ƻ�����Form�趨
	 * 
	 * @return igdrm1511Form ��ѵ�ƻ�����Form
	 */
	public void setIgdrm1511Form(IGDRM1511Form igdrm1511Form) {
		this.igdrm1511Form = igdrm1511Form;
	}

	/**
	 * ��ѵ�ƻ�����Formȡ��
	 * 
	 * @return igdrm1512Form ��ѵ�ƻ�����Form
	 */
	public IGDRM1512Form getIgdrm1512Form() {
		return igdrm1512Form;
	}

	/**
	 * ��ѵ�ƻ�����Form�趨
	 * 
	 * @return igdrm1512Form ��ѵ�ƻ�����Form
	 */
	public void setIgdrm1512Form(IGDRM1512Form igdrm1512Form) {
		this.igdrm1512Form = igdrm1512Form;
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
