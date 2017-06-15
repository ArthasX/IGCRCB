/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.processquery;

import java.util.List;

import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 默认标签生成
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public abstract class DefaultProcessQuery implements ProcessQuery{
	
	/** 查询条件定义对象 */
	protected IG111Info queryObj;
	
	/** 值 */
	protected String value;
	
	/** 状态信息 */
	protected List<IG333Info> psdList;

	/**
	 * 查询条件定义对象设定
	 * @param queryObj 查询条件定义对象
	 */
	public void setQueryObj(IG111Info queryObj) {
		this.queryObj = queryObj;
	}

	/**
	 * 值设定
	 * @param value 值
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 状态信息设定
	 * @param psdList 状态信息
	 */
	public void setPsdList(List<IG333Info> psdList) {
		this.psdList = psdList;
	}
}
