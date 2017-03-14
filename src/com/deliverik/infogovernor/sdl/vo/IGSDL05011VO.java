/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;
import com.deliverik.infogovernor.sdl.model.SdlInfo;
import com.deliverik.infogovernor.sdl.model.SdlSummary;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_统计VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL05011VO extends BaseVO implements Serializable {
	
	/**统计信息List*/
	protected List<SdlSummary> sdlSummaryList;
	
	/**标准信息*/
	protected SdlDefineInfo sdlDefineInfo;
	
	/**登记信息*/
	protected List<SdlInfo> sdlInfoList;
	
	/**登记信息*/
	protected SdlInfo sdlInfo;
	
	/**附件*/
	protected List<Attachment> attachmentList;
	
	public List<SdlInfo> getSdlInfoList() {
		return sdlInfoList;
	}

	public void setSdlInfoList(List<SdlInfo> sdlInfoList) {
		this.sdlInfoList = sdlInfoList;
	}

	public SdlInfo getSdlInfo() {
		return sdlInfo;
	}

	public void setSdlInfo(SdlInfo sdlInfo) {
		this.sdlInfo = sdlInfo;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	/**
	 * 获取统计信息List
	 * @return List<SdlSummary>
	 */
	
	public List<SdlSummary> getSdlSummaryList() {
		return sdlSummaryList;
	}
	
	/**
	 * 获取标准信息List
	 * @return SdlDefineInfo
	 */
	
	public SdlDefineInfo getSdlDefineInfo() {
		return sdlDefineInfo;
	}
	
	/**
	 * 构造函数
	 * @param 
	 * @param 
	 */
	public IGSDL05011VO() {
		
	}

	/**
	 * 构造函数
	 * @param sdlSummaryList List<SdlSummary>
	 * @param sdlDefineInfo SdlDefineInfo
	 */
	public IGSDL05011VO(List<SdlSummary> sdlSummaryList , SdlDefineInfo sdlDefineInfo) {
		this.sdlSummaryList = sdlSummaryList;
		this.sdlDefineInfo = sdlDefineInfo;
	}
}
