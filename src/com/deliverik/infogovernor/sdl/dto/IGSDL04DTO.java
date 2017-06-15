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
import com.deliverik.infogovernor.sdl.form.IGSDL0402Form;
import com.deliverik.infogovernor.sdl.model.SdlInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_信息DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSDL04DTO extends BaseDTO implements Serializable {
	
	/**信息*/
	protected SdlInfo sdlInfo;
	
	/**信息查询Bean */
	protected SdlInfoSearchCond sdlInfoSearchCond;
	
	/**信息List*/
	protected List<SdlInfo> sdlInfoList;

	/**允许查询的最大记录数*/
	protected int maxSearchCount;

	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	/**信息删除主键*/
	protected String[] deleteSdlInfoid;
	
	/**信息新增Form*/
	protected IGSDL0402Form igsdl0402Form;
	
	/**信息ID*/
	protected Integer siid;
	
	/**附件*/
	protected List<Attachment> attachmentList;
	
	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public Integer getSiid() {
		return siid;
	}

	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	/**
	 * 获取信息
	 * @return SdlInfo
	 */
	
	public SdlInfo getSdlInfo() {
		return sdlInfo;
	}

	/**
	 * 设置信息
	 * @param sdlInfo SdlInfo
	 */
	
	public void setSdlInfo(SdlInfo sdlInfo) {
		this.sdlInfo = sdlInfo;
	}

	/**
	 * 获取信息查询Bean
	 * @return SdlInfoSearchCond
	 */
	
	public SdlInfoSearchCond getSdlInfoSearchCond() {
		return sdlInfoSearchCond;
	}

	/**
	 * 设置信息查询Bean
	 * @param sdlInfoSearchCond SdlInfoSearchCond
	 */
	
	public void setSdlInfoSearchCond(
			SdlInfoSearchCond sdlInfoSearchCond) {
		this.sdlInfoSearchCond = sdlInfoSearchCond;
	}

	/**
	 * 获取信息List
	 * @return List<SdlInfo>
	 */
	
	public List<SdlInfo> getSdlInfoList() {
		return sdlInfoList;
	}

	/**
	 * 设置信息List
	 * @param sdlInfoList List<SdlInfo>
	 */
	
	public void setSdlInfoList(List<SdlInfo> sdlInfoList) {
		this.sdlInfoList = sdlInfoList;
	}
	
	/**
	 * 获取允许查询的最大记录数
	 * @return int
	 */
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 设置允许查询的最大记录数
	 * @param maxSearchCount int
	 */
	
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 获取分页Bean
	 * @return PagingDTO
	 */
	
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 设置分页Bean
	 * @param pagingDto PagingDTO
	 */
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 获取信息删除主键
	 * @return String[]
	 */
	
	public String[] getDeleteSdlInfoid() {
		return deleteSdlInfoid;
	}

	/**
	 * 设置信息删除主键
	 * @param deleteSdlInfoid String[]
	 */
	
	public void setDeleteSdlInfoid(String[] deleteSdlInfoid) {
		this.deleteSdlInfoid = deleteSdlInfoid;
	}

	/**
	 * 获取信息新增Form
	 * @return IGSDL0402Form
	 */
	public IGSDL0402Form getIgsdl0402Form() {
		return igsdl0402Form;
	}

	/**
	 * 设置信息新增Form
	 * @param igsdl0402Form IGSDL0402Form
	 */
	public void setIgsdl0402Form(IGSDL0402Form igsdl0402Form) {
		this.igsdl0402Form = igsdl0402Form;
	}

}
