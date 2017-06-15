/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;
import com.deliverik.infogovernor.sdl.model.SdlInfo;
import com.deliverik.infogovernor.sdl.model.SdlSummary;
import com.deliverik.infogovernor.sdl.model.SdlYearSummary;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCond;
import com.deliverik.infogovernor.sdl.model.condition.SdlSummarySearchCond;
import com.deliverik.infogovernor.sdl.model.condition.SdlYearSummarySearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_ͳ��DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSDL05DTO extends BaseDTO implements Serializable {
	
	/**ͳ�Ʋ�ѯBean */
	protected SdlSummarySearchCond sdlSummarySearchCond;
	
	/**ͳ�Ʋ�ѯBean */
	protected SdlYearSummarySearchCond sdlYearSummarySearchCond;
	
	/**ͳ����ϢList*/
	protected List<SdlSummary> sdlSummaryList;
	
	/**ͳ����ϢList*/
	protected List<SdlYearSummary> sdlYearSummaryList;
	
	/**��׼��Ϣ*/
	protected SdlDefineInfo sdlDefineInfo;
	
	/**�Ǽ���Ϣ*/
	protected List<SdlInfo> sdlInfoList;
	
	/**�Ǽ���Ϣ*/
	protected SdlInfo sdlInfo;
	
	/**����*/
	protected List<Attachment> attachmentList;
	
	/**��Ϣ��ѯBean */
	protected SdlInfoSearchCond sdlInfoSearchCond;
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;

	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	/**��ϢID*/
	protected Integer siid;
	
	public SdlYearSummarySearchCond getSdlYearSummarySearchCond() {
		return sdlYearSummarySearchCond;
	}

	public void setSdlYearSummarySearchCond(
			SdlYearSummarySearchCond sdlYearSummarySearchCond) {
		this.sdlYearSummarySearchCond = sdlYearSummarySearchCond;
	}

	public List<SdlYearSummary> getSdlYearSummaryList() {
		return sdlYearSummaryList;
	}

	public void setSdlYearSummaryList(List<SdlYearSummary> sdlYearSummaryList) {
		this.sdlYearSummaryList = sdlYearSummaryList;
	}

	public Integer getSiid() {
		return siid;
	}

	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	public SdlInfo getSdlInfo() {
		return sdlInfo;
	}

	public void setSdlInfo(SdlInfo sdlInfo) {
		this.sdlInfo = sdlInfo;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public SdlInfoSearchCond getSdlInfoSearchCond() {
		return sdlInfoSearchCond;
	}

	public void setSdlInfoSearchCond(SdlInfoSearchCond sdlInfoSearchCond) {
		this.sdlInfoSearchCond = sdlInfoSearchCond;
	}

	public List<SdlInfo> getSdlInfoList() {
		return sdlInfoList;
	}

	public void setSdlInfoList(List<SdlInfo> sdlInfoList) {
		this.sdlInfoList = sdlInfoList;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	/**
	 * ��ȡͳ�Ʋ�ѯBean
	 * @return SdlSummarySearchCond
	 */
	
	public SdlSummarySearchCond getSdlSummarySearchCond() {
		return sdlSummarySearchCond;
	}

	/**
	 * ����ͳ�Ʋ�ѯBean
	 * @param sdlSummarySearchCond SdlSummarySearchCond
	 */
	
	public void setSdlSummarySearchCond(
			SdlSummarySearchCond sdlSummarySearchCond) {
		this.sdlSummarySearchCond = sdlSummarySearchCond;
	}

	/**
	 * ��ȡͳ����ϢList
	 * @return List<SdlSummary>
	 */
	
	public List<SdlSummary> getSdlSummaryList() {
		return sdlSummaryList;
	}

	/**
	 * ����ͳ����ϢList
	 * @param sdlSummaryList List<SdlSummary>
	 */
	
	public void setSdlSummaryList(List<SdlSummary> sdlSummaryList) {
		this.sdlSummaryList = sdlSummaryList;
	}
	
	/**
	 * ��ȡ��׼��Ϣ
	 * @return SdlDefineInfo
	 */
	
	public SdlDefineInfo getSdlDefineInfo() {
		return sdlDefineInfo;
	}

	/**
	 * ���ñ�׼��Ϣ
	 * @param sdlDefineInfo SdlDefineInfo
	 */
	
	public void setSdlDefineInfo(SdlDefineInfo sdlDefineInfo) {
		this.sdlDefineInfo = sdlDefineInfo;
	}

}
