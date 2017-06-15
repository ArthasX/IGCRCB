/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.model.condition;

import java.util.List;

import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程通用查询查询条件实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ProcessSearchCondImpl implements ProcessSearchCond{

	/** 流程定义ID */
	protected String pdid;
	
	/** 查询条件标识 */
	protected String[] queryKey;
	
	/** 查询条件值 */
	protected String[] queryValue;
	
	/** 显示列集合 */
	protected List<IG110Info> showColumnList;
	
	/** 查询条件定义集合 */
	protected List<IG111Info> queryList;

	/**
	 * 流程记录紧急程度
	 */
	protected String prurgency;

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 查询条件标识取得
	 * @return queryKey 查询条件标识
	 */
	public String[] getQueryKey() {
		return queryKey;
	}

	/**
	 * 查询条件标识设定
	 * @param queryKey 查询条件标识
	 */
	public void setQueryKey(String[] queryKey) {
		this.queryKey = queryKey;
	}

	/**
	 * 查询条件值取得
	 * @return queryValue 查询条件值
	 */
	public String[] getQueryValue() {
		return queryValue;
	}

	/**
	 * 查询条件值设定
	 * @param queryValue 查询条件值
	 */
	public void setQueryValue(String[] queryValue) {
		this.queryValue = queryValue;
	}

	/**
	 * 显示列集合取得
	 * @return showColumnList 显示列集合
	 */
	public List<IG110Info> getShowColumnList() {
		return showColumnList;
	}

	/**
	 * 显示列集合设定
	 * @param showColumnList 显示列集合
	 */
	public void setShowColumnList(List<IG110Info> showColumnList) {
		this.showColumnList = showColumnList;
	}

	/**
	 * 查询条件定义集合取得
	 * @return queryList 查询条件定义集合
	 */
	public List<IG111Info> getQueryList() {
		return queryList;
	}

	/**
	 * 查询条件定义集合设定
	 * @param queryList 查询条件定义集合
	 */
	public void setQueryList(List<IG111Info> queryList) {
		this.queryList = queryList;
	}

	public String getPrurgency() {
		return prurgency;
	}

	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}
}
