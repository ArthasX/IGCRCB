/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.workflow.prd.model.IG299Info;

/**
 * 概述: 流程状态可分派机构定义VO
 * 功能描述: 流程状态可分派机构定义VO
 * 创建记录: 2012/04/11
 * 修改记录: 2013/02/25		130225	流程机构相关修改(状态可分派机构配置)
 */
@SuppressWarnings("serial")
public class IGPRD01431VO extends BaseVO implements Serializable {

	/** 可选机构列表 */
	protected List<Organization> lst_Org;
	
	/** 已选机构列表  */
	protected List<IG299Info> lst_ProcessStatusOrgDef;

	/**
	 * 可选机构列表取得
	 *
	 * @return lst_Org 可选机构列表
	 */
	public List<Organization> getLst_Org() {
		return lst_Org;
	}

	/**
	 * 可选机构列表设定
	 *
	 * @param lst_Org 可选机构列表
	 */
	public void setLst_Org(List<Organization> lst_Org) {
		this.lst_Org = lst_Org;
	}

	/**
	 * 已选机构列表取得
	 *
	 * @return lst_ProcessStatusOrgDef 已选机构列表
	 */
	public List<IG299Info> getLst_ProcessStatusOrgDef() {
		return lst_ProcessStatusOrgDef;
	}

	/**
	 * 已选机构列表设定
	 *
	 * @param lst_ProcessStatusOrgDef 已选机构列表
	 */
	public void setLst_ProcessStatusOrgDef(List<IG299Info> lst_ProcessStatusOrgDef) {
		this.lst_ProcessStatusOrgDef = lst_ProcessStatusOrgDef;
	}

	
}
