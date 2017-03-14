/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.prr.form.IGPRR0402Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程服务目录dto
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR04DTO extends BaseDTO {

	/** 服务目录显示form */
	protected IGPRR0402Form igprr0402Form;
	
	/** 服务目录显示数据 */
	protected Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> serviceCatalogMap;
	
	/** 服务目录一级分类 */
	protected List<CodeDetailDef> serviceCatalogFirstClassify;
	
	/** 用户信息 */
	protected User user;
	
	/** 可发起流程集合  */
	protected List<IG380Info> pdList;

	/**
	 * 服务目录显示form取得
	 * @return igprr0402Form 服务目录显示form
	 */
	public IGPRR0402Form getIgprr0402Form() {
		return igprr0402Form;
	}

	/**
	 * 服务目录显示form设定
	 * @param igprr0402Form 服务目录显示form
	 */
	public void setIgprr0402Form(IGPRR0402Form igprr0402Form) {
		this.igprr0402Form = igprr0402Form;
	}

	/**
	 * 服务目录显示数据取得
	 * @return serviceCatalogMap 服务目录显示数据
	 */
	public Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> getServiceCatalogMap() {
		return serviceCatalogMap;
	}

	/**
	 * 服务目录显示数据设定
	 * @param serviceCatalogMap 服务目录显示数据
	 */
	public void setServiceCatalogMap(
			Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> serviceCatalogMap) {
		this.serviceCatalogMap = serviceCatalogMap;
	}

	/**
	 * 服务目录一级分类取得
	 * @return serviceCatalogFirstClassify 服务目录一级分类
	 */
	public List<CodeDetailDef> getServiceCatalogFirstClassify() {
		return serviceCatalogFirstClassify;
	}

	/**
	 * 服务目录一级分类设定
	 * @param serviceCatalogFirstClassify 服务目录一级分类
	 */
	public void setServiceCatalogFirstClassify(
			List<CodeDetailDef> serviceCatalogFirstClassify) {
		this.serviceCatalogFirstClassify = serviceCatalogFirstClassify;
	}

	/**
	 * 用户信息取得
	 * @return user 用户信息
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户信息设定
	 * @param user 用户信息
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 可发起流程集合取得
	 * @return pdList 可发起流程集合
	 */
	public List<IG380Info> getPdList() {
		return pdList;
	}

	/**
	 * 可发起流程集合设定
	 * @param pdList 可发起流程集合
	 */
	public void setPdList(List<IG380Info> pdList) {
		this.pdList = pdList;
	}
}
