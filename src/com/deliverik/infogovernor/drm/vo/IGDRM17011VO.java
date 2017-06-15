/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.drm.model.TrainrecordInfo;

/**
 * <p>
 * Title : InfoGovernor ģ������
 * </p>
 * <p>
 * Description:��ѵ��¼��ѯVO
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM17011VO extends BaseVO implements Serializable {
	
	/** ��ѵ��¼���� */
	protected List<TrainrecordInfo> trainrecordList;

	/**  
	 * ��ȡ��ѵ��¼����  
	 * @return trainrecordList ��ѵ��¼����  
	 */
	
	public List<TrainrecordInfo> getTrainrecordList() {
		return trainrecordList;
	}

	/**  
	 * ������ѵ��¼����  
	 * @param trainrecordList ��ѵ��¼����  
	 */
	
	public void setTrainrecordList(List<TrainrecordInfo> trainrecordList) {
		this.trainrecordList = trainrecordList;
	}
}
