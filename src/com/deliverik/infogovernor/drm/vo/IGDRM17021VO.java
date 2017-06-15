/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.infogovernor.drm.model.TrainparticipateInfo;

/**
 * <p>
 * Title : InfoGovernor ģ������
 * </p>
 * <p>
 * Description:��ѵ��¼�޸�VO
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM17021VO extends BaseVO{

	/** ���� */
	protected List<AttachmentTB> attachmentList;
	
	/** ��ѵ��Ա��Ϣ���� */
	protected List<TrainparticipateInfo> trainparticipantList;

	/**  
	 * ��ȡ����  
	 * @return attachmentList ����  
	 */
	
	public List<AttachmentTB> getAttachmentList() {
		return attachmentList;
	}

	/**  
	 * ���ø���  
	 * @param attachmentList ����  
	 */
	
	public void setAttachmentList(List<AttachmentTB> attachmentList) {
		this.attachmentList = attachmentList;
	}

	/**  
	 * ��ȡ��ѵ��Ա��Ϣ����  
	 * @return trainparticipantList ��ѵ��Ա��Ϣ����  
	 */
	
	public List<TrainparticipateInfo> getTrainparticipantList() {
		return trainparticipantList;
	}

	/**  
	 * ������ѵ��Ա��Ϣ����  
	 * @param trainparticipantList ��ѵ��Ա��Ϣ����  
	 */
	
	public void setTrainparticipantList(
			List<TrainparticipateInfo> trainparticipantList) {
		this.trainparticipantList = trainparticipantList;
	}
}
