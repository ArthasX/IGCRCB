/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0302Form;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlDefineInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_标准DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSDL03DTO extends BaseDTO implements Serializable {
	
	/**标准信息*/
	protected SdlDefineInfo sdlDefineInfo;
	
	/**标准查询Bean */
	protected SdlDefineInfoSearchCond sdlDefineInfoSearchCond;
	
	/**标准信息List*/
	protected List<SdlDefineInfo> sdlDefineInfoList;

	/**允许查询的最大记录数*/
	protected int maxSearchCount;

	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	/**标准删除主键*/
	protected String[] deleteSdlDefineInfoid;
	
	/**标准新增Form*/
	protected IGSDL0302Form igsdl0302Form;
	
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

	/**
	 * 获取标准查询Bean
	 * @return SdlDefineInfoSearchCond
	 */
	
	public SdlDefineInfoSearchCond getSdlDefineInfoSearchCond() {
		return sdlDefineInfoSearchCond;
	}

	/**
	 * 设置标准查询Bean
	 * @param sdlDefineInfoSearchCond SdlDefineInfoSearchCond
	 */
	
	public void setSdlDefineInfoSearchCond(
			SdlDefineInfoSearchCond sdlDefineInfoSearchCond) {
		this.sdlDefineInfoSearchCond = sdlDefineInfoSearchCond;
	}

	/**
	 * 获取标准信息List
	 * @return List<SdlDefineInfo>
	 */
	
	public List<SdlDefineInfo> getSdlDefineInfoList() {
		return sdlDefineInfoList;
	}

	/**
	 * 设置标准信息List
	 * @param sdlDefineInfoList List<SdlDefineInfo>
	 */
	
	public void setSdlDefineInfoList(List<SdlDefineInfo> sdlDefineInfoList) {
		this.sdlDefineInfoList = sdlDefineInfoList;
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
	 * 获取标准删除主键
	 * @return String[]
	 */
	
	public String[] getDeleteSdlDefineInfoid() {
		return deleteSdlDefineInfoid;
	}

	/**
	 * 设置标准删除主键
	 * @param deleteSdlDefineInfoid String[]
	 */
	
	public void setDeleteSdlDefineInfoid(String[] deleteSdlDefineInfoid) {
		this.deleteSdlDefineInfoid = deleteSdlDefineInfoid;
	}

	/**
	 * 获取标准新增Form
	 * @return IGSDL0302Form
	 */
	public IGSDL0302Form getIgsdl0302Form() {
		return igsdl0302Form;
	}

	/**
	 * 设置标准新增Form
	 * @param igsdl0302Form IGSDL0302Form
	 */
	public void setIgsdl0302Form(IGSDL0302Form igsdl0302Form) {
		this.igsdl0302Form = igsdl0302Form;
	}

}
