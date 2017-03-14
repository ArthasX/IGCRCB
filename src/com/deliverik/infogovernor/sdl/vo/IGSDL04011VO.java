/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��ϢVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL04011VO extends BaseVO implements Serializable {
	
	/**��ϢList*/
	protected List<SdlInfo> sdlInfoList;
	
	/**��Ϣ*/
	protected SdlInfo sdlInfo;
	
	/**����*/
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
	 * ��ȡ��ϢList
	 * @return List<SdlInfo>
	 */
	
	public List<SdlInfo> getSdlInfoList() {
		return sdlInfoList;
	}
	/**
	 * ���캯��
	 * @param  
	 */
	public IGSDL04011VO() {
		
	}
	/**
	 * ���캯��
	 * @param sdlInfoList List<SdlInfo>
	 */
	public IGSDL04011VO(List<SdlInfo> sdlInfoList) {
		this.sdlInfoList = sdlInfoList;
	}
}
