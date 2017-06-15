/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.drm.model.TrainrecordInfo;

/**
 * <p>
 * Title : InfoGovernor 模块名称
 * </p>
 * <p>
 * Description:培训记录查询VO
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM17011VO extends BaseVO implements Serializable {
	
	/** 培训记录集合 */
	protected List<TrainrecordInfo> trainrecordList;

	/**  
	 * 获取培训记录集合  
	 * @return trainrecordList 培训记录集合  
	 */
	
	public List<TrainrecordInfo> getTrainrecordList() {
		return trainrecordList;
	}

	/**  
	 * 设置培训记录集合  
	 * @param trainrecordList 培训记录集合  
	 */
	
	public void setTrainrecordList(List<TrainrecordInfo> trainrecordList) {
		this.trainrecordList = trainrecordList;
	}
}
