/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * @Description: 查看表单日志VO
 * @Author  
 * @History 2010-9-17     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01061VO extends BaseVO implements Serializable {

	/**表单日志集合*/
	protected List<IG113Info> varLogList;

	/** 查看按键附件显示 */
	protected Map<String,List<Attachment>> attachmentMap;

	/**
	 * 构造方法
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
