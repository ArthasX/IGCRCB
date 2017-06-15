/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_ͳ��VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL05011VO extends BaseVO implements Serializable {
	
	/**ͳ����ϢList*/
	protected List<SdlSummary> sdlSummaryList;
	
	/**��׼��Ϣ*/
	protected SdlDefineInfo sdlDefineInfo;
	
	/**�Ǽ���Ϣ*/
	protected List<SdlInfo> sdlInfoList;
	
	/**�Ǽ���Ϣ*/
	protected SdlInfo sdlInfo;
	
	/**����*/
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
	 * ��ȡͳ����ϢList
	 * @return List<SdlSummary>
	 */
	
	public List<SdlSummary> getSdlSummaryList() {
		return sdlSummaryList;
	}
	
	/**
	 * ��ȡ��׼��ϢList
	 * @return SdlDefineInfo
	 */
	
	public SdlDefineInfo getSdlDefineInfo() {
		return sdlDefineInfo;
	}
	
	/**
	 * ���캯��
	 * @param 
	 * @param 
	 */
	public IGSDL05011VO() {
		
	}

	/**
	 * ���캯��
	 * @param sdlSummaryList List<SdlSummary>
	 * @param sdlDefineInfo SdlDefineInfo
	 */
	public IGSDL05011VO(List<SdlSummary> sdlSummaryList , SdlDefineInfo sdlDefineInfo) {
		this.sdlSummaryList = sdlSummaryList;
		this.sdlDefineInfo = sdlDefineInfo;
	}
}
