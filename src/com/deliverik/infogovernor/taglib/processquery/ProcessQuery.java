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
 * Description: 流程查询条件标签接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ProcessQuery {
	
	/** 值 */
	public static final String PARAM_VALUE = "value";
	
	/** 查询条件定义对象 */
	public static final String PARAM_DEFINITION_OBJECT = "object";
	
	/** 状态定义信息 */
	public static final String PARAM_STATUS_DEFINITION = "statusDefinition";
	
	/**
	 * 查询条件定义对象设定
	 * @param queryObj 查询条件定义对象
	 */
	public void setQueryObj(IG111Info queryObj);
	
	/**
	 * 值设定
	 * @param value 值
	 */
	public void setValue(String value) ;
	
	/**
	 * 状态信息设定
	 * @param psdList 状态信息
	 */
	public void setPsdList(List<IG333Info> psdList);

	/**
	 * 生成标签
	 * @param param 参数
	 * @return 生成后的标签字符串
	 */
	public String generatedTag();
}
