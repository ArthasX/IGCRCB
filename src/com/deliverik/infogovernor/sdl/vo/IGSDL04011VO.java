/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.sdl.model.SdlInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_信息VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL04011VO extends BaseVO implements Serializable {
	
	/**信息List*/
	protected List<SdlInfo> sdlInfoList;
	
	/**信息*/
	protected SdlInfo sdlInfo;
	
	/**附件*/
	protected List<Attachment> attachmentList;
	
	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
	public void setSdlInfo(SdlInfo sdlInfo) {
		this.sdlInfo = sdlInfo;
	}

	public SdlInfo getSdlInfo() {
		return sdlInfo;
	}
	/**
	 * 获取信息List
	 * @return List<SdlInfo>
	 */
	
	public List<SdlInfo> getSdlInfoList() {
		return sdlInfoList;
	}
	/**
	 * 构造函数
	 * @param  
	 */
	public IGSDL04011VO() {
		
	}
	/**
	 * 构造函数
	 * @param sdlInfoList List<SdlInfo>
	 */
	public IGSDL04011VO(List<SdlInfo> sdlInfoList) {
		this.sdlInfoList = sdlInfoList;
	}
}
