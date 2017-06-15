/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 查看流程组相关流程
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM09061VO extends BaseVO implements Serializable {

	public IGDRM09061VO() {

	}

	protected IG483Info groupProcessRecord;
	
	protected List<IG484Info> groupProcessRecordMembers;
	
	protected String groupProcessRecordXML;
	
	protected List<IG500Info> processList;
	
	protected String xmlHeight;
	
	protected List<IG036Info> noticeList;
	

	public String getXmlHeight() {
		return xmlHeight;
	}

	public void setXmlHeight(String xmlHeight) {
		this.xmlHeight = xmlHeight;
	}

	public IG483Info getGroupProcessRecord() {
		return groupProcessRecord;
	}

	public void setGroupProcessRecord(IG483Info groupProcessRecord) {
		this.groupProcessRecord = groupProcessRecord;
	}

	public List<IG484Info> getGroupProcessRecordMembers() {
		return groupProcessRecordMembers;
	}

	public void setGroupProcessRecordMembers(
			List<IG484Info> groupProcessRecordMembers) {
		this.groupProcessRecordMembers = groupProcessRecordMembers;
	}

	public String getGroupProcessRecordXML() {
		return groupProcessRecordXML;
	}

	public void setGroupProcessRecordXML(String groupProcessRecordXML) {
		this.groupProcessRecordXML = groupProcessRecordXML;
	}

	public List<IG500Info> getProcessList() {
		return processList;
	}

	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}

	public List<IG036Info> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<IG036Info> noticeList) {
		this.noticeList = noticeList;
	}
	
	

}
