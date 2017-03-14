/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.dto;


import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.form.IGDRM1101Form;
import com.deliverik.infogovernor.drm.form.IGDRM1102Form;

/**
 * 演练计划DTO
 *
 */
@SuppressWarnings("serial")
public class IGDRM11DTO extends BaseDTO {
	
	/**签到form*/
	protected IGDRM1101Form igdrm1101Form;
	
	/**代签到form*/
	protected IGDRM1102Form igdrm1102Form;
	
	/**代签到Map*/
	protected List<Map<String,Object>> signinMap ;
	
	/** 最大查询条数 */
	protected int maxSearchCount;

	/** 分页用DTO */
	protected PagingDTO pagingDto;
	
	/** 用户对象 */
	protected User user;

	/**
	 * 签到form取得
	 * @return igdrm1101Form 签到form
	 */
	public IGDRM1101Form getIgdrm1101Form() {
		return igdrm1101Form;
	}

	/**
	 * 签到form设定
	 * @param igdrm1101Form 签到form
	 */
	public void setIgdrm1101Form(IGDRM1101Form igdrm1101Form) {
		this.igdrm1101Form = igdrm1101Form;
	}

	/**
	 * 代签到form取得
	 * @return igdrm1102Form 代签到form
	 */
	public IGDRM1102Form getIgdrm1102Form() {
		return igdrm1102Form;
	}

	/**
	 * 代签到form设定
	 * @param igdrm1102Form 代签到form
	 */
	public void setIgdrm1102Form(IGDRM1102Form igdrm1102Form) {
		this.igdrm1102Form = igdrm1102Form;
	}

	/**
	 * 代签到Map取得
	 * @return signinMap 代签到Map
	 */
	public List<Map<String, Object>> getSigninMap() {
		return signinMap;
	}

	/**
	 * 代签到Map设定
	 * @param signinMap 代签到Map
	 */
	public void setSigninMap(List<Map<String, Object>> signinMap) {
		this.signinMap = signinMap;
	}

	/**
	 * 最大查询条数取得
	 * @return maxSearchCount 最大查询条数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 最大查询条数设定
	 * @param maxSearchCount 最大查询条数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页用DTO取得
	 * @return pagingDto 分页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页用DTO设定
	 * @param pagingDto 分页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 用户对象取得
	 * @return user 用户对象
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户对象设定
	 * @param user 用户对象
	 */
	public void setUser(User user) {
		this.user = user;
	}
}