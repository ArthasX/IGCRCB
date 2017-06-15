/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.infogovernor.crc.model.ChangeProcessVWInfo;
import com.deliverik.infogovernor.crc.model.vo.IGCRC14011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更流程查询DTO
 * </p>
 * 
 * @author shikailong@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC14DTO extends BaseDTO{

	/** 允许查询的最大记录数 */
	protected int maxSearchCount;

	/** 分页Bean */
	protected PagingDTO pagingDto;
	
	/** 当前用户*/
	protected User user;
	
	/** 变更流程集合*/
	protected List<ChangeProcessVWInfo> changeProcessVWInfos;

	/** 变更查询VO*/
	protected IGCRC14011VO igcrc14011VO;
	
	/** 流程名称ID*/
	protected String pdid;
	
	/** 状态集合*/
	private List<IG333Info> ig333InfoList;
	
	/** 参与人*/
	protected List<IG337Info> processParticipantList;
	
	/** 状态定义*/
	protected List<IG333Info> processStatusDefList;
	
	/**
	 * 允许查询的最大记录数取得
	 * @return the maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 允许查询的最大记录数设定
	 * @param maxSearchCount the 允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页Bean取得
	 * @return the pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页Bean设定
	 * @param pagingDto the 分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 当前用户取得
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 当前用户设定
	 * @param user the 当前用户
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 变更流程集合取得
	 * @return the changeProcessVWInfos
	 */
	public List<ChangeProcessVWInfo> getChangeProcessVWInfos() {
		return changeProcessVWInfos;
	}

	/**
	 * 变更流程集合设定
	 * @param changeProcessVWInfos the 变更流程集合
	 */
	public void setChangeProcessVWInfos(
			List<ChangeProcessVWInfo> changeProcessVWInfos) {
		this.changeProcessVWInfos = changeProcessVWInfos;
	}

	/**
	 * 变更查询VO取得
	 * @return the igcrc14011VO
	 */
	public IGCRC14011VO getIgcrc14011VO() {
		return igcrc14011VO;
	}

	/**
	 * 变更查询VO设定
	 * @param igcrc14011vo the igcrc14011VO
	 */
	public void setIgcrc14011VO(IGCRC14011VO igcrc14011vo) {
		igcrc14011VO = igcrc14011vo;
	}

	/**
	 * 流程名称ID取得
	 * @return the pdid
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程名称ID设定
	 * @param pdid the 流程名称ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 状态集合取得
	 * @return the ig333InfoList
	 */
	public List<IG333Info> getIg333InfoList() {
		return ig333InfoList;
	}

	/**
	 * 状态集合设定
	 * @param ig333InfoList the 状态集合
	 */
	public void setIg333InfoList(List<IG333Info> ig333InfoList) {
		this.ig333InfoList = ig333InfoList;
	}

	/**
	 * 参与人取得
	 * @return the processParticipantList
	 */
	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	/**
	 * 参与人设定
	 * @param processParticipantList the 参与人
	 */
	public void setProcessParticipantList(List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	/**
	 * 状态定义取得
	 * @return the processStatusDefList
	 */
	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	/**
	 * 状态定义设定
	 * @param processStatusDefList the 状态定义
	 */
	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}
	
}
