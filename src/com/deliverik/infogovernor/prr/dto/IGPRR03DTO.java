/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.infogovernor.prr.form.IGPRR0301Form;
import com.deliverik.infogovernor.prr.form.IGPRR0302Form;
import com.deliverik.infogovernor.prr.form.IGPRR0303Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 自定义流程辅助功能dto
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR03DTO extends BaseDTO{

	/** 允许查询的最大记录数 */
	protected int maxSearchCount;

	/** 分页Bean */
	protected PagingDTO pagingDto;
	
	/** 角色配置Form */
	protected IGPRR0301Form igprr0301Form;
	
	/** 角色查询form */
	protected IGPRR0302Form igprr0302Form;
	
	/** 人员查询form */
	protected IGPRR0303Form igprr0303Form;
	
	/** 角色信息集合 */
	protected List<Role> roleList;
	
	/** 负责人角色信息集合 */
	protected List<IG001Info> ig001List_A;
	
	/** 值班人角色信息集合 */
	protected List<IG001Info> ig001List_B;
	
	/** 执行人角色信息集合 */
	protected List<IG001Info> ig001List_C;
	
	/** 用户角色Map */
	protected Map<Integer, Map<String,List<UserRoleInfo>>> userRoleInfoMap;

	/**
	 * 允许查询的最大记录数取得
	 * @return 允许查询的最大记录数
	 */
	public final int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 允许查询的最大记录数设定
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public final void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页bean取得
	 * @return 分页bean
	 */
	public final PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页bean设定
	 * @param pagingDto 分页bean
	 */
	public final void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 角色配置form取得
	 * @return 角色配置form
	 */
	public final IGPRR0301Form getIgprr0301Form() {
		return igprr0301Form;
	}

	/**
	 * 角色配置form设定
	 * @param igprr0301Form
	 */
	public final void setIgprr0301Form(IGPRR0301Form igprr0301Form) {
		this.igprr0301Form = igprr0301Form;
	}

	/**
	 * 角色查询form取得
	 * @return 角色查询form
	 */
	public final IGPRR0302Form getIgprr0302Form() {
		return igprr0302Form;
	}

	/**
	 * 角色查询form设定
	 * @param igprr0302Form 角色查询form
	 */
	public final void setIgprr0302Form(IGPRR0302Form igprr0302Form) {
		this.igprr0302Form = igprr0302Form;
	}
	
	/**
	 * 角色信息集合取得
	 * @return 角色信息集合
	 */
	public final List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * 角色信息集合设定
	 * @param roleList 角色信息集合
	 */
	public final void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	/**
	 * 负责人角色信息集合取得
	 * @return 负责人角色信息集合
	 */
	public final List<IG001Info> getIg001List_A() {
		return ig001List_A;
	}

	/**
	 * 负责人角色信息集合设定
	 * @param ig001List_A 负责人角色信息集合
	 */
	public final void setIg001List_A(List<IG001Info> ig001List_A) {
		this.ig001List_A = ig001List_A;
	}

	/**
	 * 值班人角色信息结合取得
	 * @return 值班人角色信息集合
	 */
	public final List<IG001Info> getIg001List_B() {
		return ig001List_B;
	}

	/**
	 * 值班人角色信息集合设定
	 * @param ig001List_B 值班人角色信息集合
	 */
	public final void setIg001List_B(List<IG001Info> ig001List_B) {
		this.ig001List_B = ig001List_B;
	}

	/**
	 * 执行人角色信息集合取得
	 * @return 执行人角色信息集合
	 */
	public final List<IG001Info> getIg001List_C() {
		return ig001List_C;
	}

	/**
	 * 执行人角色信息集合设定
	 * @param ig001List_C 执行人角色信息集合
	 */
	public final void setIg001List_C(List<IG001Info> ig001List_C) {
		this.ig001List_C = ig001List_C;
	}

	/**
	 * 人员查询form取得
	 * @return igprr0303Form 人员查询form
	 */
	public IGPRR0303Form getIgprr0303Form() {
		return igprr0303Form;
	}

	/**
	 * 人员查询form设定
	 * @param igprr0303Form 人员查询form
	 */
	public void setIgprr0303Form(IGPRR0303Form igprr0303Form) {
		this.igprr0303Form = igprr0303Form;
	}

	/**
	 * 用户角色Map取得
	 * @return userRoleInfoMap 用户角色Map
	 */
	public Map<Integer, Map<String, List<UserRoleInfo>>> getUserRoleInfoMap() {
		return userRoleInfoMap;
	}

	/**
	 * 用户角色Map设定
	 * @param userRoleInfoMap 用户角色Map
	 */
	public void setUserRoleInfoMap(
			Map<Integer, Map<String, List<UserRoleInfo>>> userRoleInfoMap) {
		this.userRoleInfoMap = userRoleInfoMap;
	}
}
