/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_统计DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSDL05DTO extends BaseDTO implements Serializable {
	
	/**统计查询Bean */
	protected SdlSummarySearchCond sdlSummarySearchCond;
	
	/**统计查询Bean */
	protected SdlYearSummarySearchCond sdlYearSummarySearchCond;
	
	/**统计信息List*/
	protected List<SdlSummary> sdlSummaryList;
	
	/**统计信息List*/
	protected List<SdlYearSummary> sdlYearSummaryList;
	
	/**标准信息*/
	protected SdlDefineInfo sdlDefineInfo;
	
	/**登记信息*/
	protected List<SdlInfo> sdlInfoList;
	
	/**登记信息*/
	protected SdlInfo sdlInfo;
	
	/**附件*/
	protected List<Attachment> attachmentList;
	
	/**信息查询Bean */
	protected SdlInfoSearchCond sdlInfoSearchCond;
	
	/**允许查询的最大记录数*/
	protected int maxSearchCount;

	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	/**信息ID*/
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
	 * 获取统计查询Bean
	 * @return SdlSummarySearchCond
	 */
	
	public SdlSummarySearchCond getSdlSummarySearchCond() {
		return sdlSummarySearchCond;
	}

	/**
	 * 设置统计查询Bean
	 * @param sdlSummarySearchCond SdlSummarySearchCond
	 */
	
	public void setSdlSummarySearchCond(
			SdlSummarySearchCond sdlSummarySearchCond) {
		this.sdlSummarySearchCond = sdlSummarySearchCond;
	}

	/**
	 * 获取统计信息List
	 * @return List<SdlSummary>
	 */
	
	public List<SdlSummary> getSdlSummaryList() {
		return sdlSummaryList;
	}

	/**
	 * 设置统计信息List
	 * @param sdlSummaryList List<SdlSummary>
	 */
	
	public void setSdlSummaryList(List<SdlSummary> sdlSummaryList) {
		this.sdlSummaryList = sdlSummaryList;
	}
	
	/**
	 * 获取标准信息
	 * @return SdlDefineInfo
	 */
	
	public SdlDefineInfo getSdlDefineInfo() {
		return sdlDefineInfo;
	}

	/**
	 * 设置标准信息
	 * @param sdlDefineInfo SdlDefineInfo
	 */
	
	public void setSdlDefineInfo(SdlDefineInfo sdlDefineInfo) {
		this.sdlDefineInfo = sdlDefineInfo;
	}

}
