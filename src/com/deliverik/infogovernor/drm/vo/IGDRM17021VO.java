/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.infogovernor.drm.model.TrainparticipateInfo;

/**
 * <p>
 * Title : InfoGovernor 模块名称
 * </p>
 * <p>
 * Description:培训记录修改VO
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM17021VO extends BaseVO{

	/** 附件 */
	protected List<AttachmentTB> attachmentList;
	
	/** 培训人员信息集合 */
	protected List<TrainparticipateInfo> trainparticipantList;

	/**  
	 * 获取附件  
	 * @return attachmentList 附件  
	 */
	
	public List<AttachmentTB> getAttachmentList() {
		return attachmentList;
	}

	/**  
	 * 设置附件  
	 * @param attachmentList 附件  
	 */
	
	public void setAttachmentList(List<AttachmentTB> attachmentList) {
		this.attachmentList = attachmentList;
	}

	/**  
	 * 获取培训人员信息集合  
	 * @return trainparticipantList 培训人员信息集合  
	 */
	
	public List<TrainparticipateInfo> getTrainparticipantList() {
		return trainparticipantList;
	}

	/**  
	 * 设置培训人员信息集合  
	 * @param trainparticipantList 培训人员信息集合  
	 */
	
	public void setTrainparticipantList(
			List<TrainparticipateInfo> trainparticipantList) {
		this.trainparticipantList = trainparticipantList;
	}
}
