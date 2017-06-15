/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.workflow.prr.model.IG113Info;

/**
 * @Description: �鿴����־VO
 * @Author  
 * @History 2010-9-17     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01061VO extends BaseVO implements Serializable {

	/**����־����*/
	protected List<IG113Info> varLogList;

	/** �鿴����������ʾ */
	protected Map<String,List<Attachment>> attachmentMap;

	/**
	 * ���췽��
	 * @param processParticipantList List<ProcessParticipant>
	 */
	
	public IGPRR01061VO() {
	}

	public List<IG113Info> getVarLogList() {
		return varLogList;
	}

	public void setVarLogList(List<IG113Info> varLogList) {
		this.varLogList = varLogList;
	}

	public Map<String, List<Attachment>> getAttachmentMap() {
		return attachmentMap;
	}

	public void setAttachmentMap(Map<String, List<Attachment>> attachmentMap) {
		this.attachmentMap = attachmentMap;
	}
	
	
	
}
