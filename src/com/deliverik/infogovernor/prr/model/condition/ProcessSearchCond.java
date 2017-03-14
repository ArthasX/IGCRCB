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
 * Description: 流程通用查询查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ProcessSearchCond {

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid();

	/**
	 * 查询条件标识取得
	 * @return queryKey 查询条件标识
	 */
	public String[] getQueryKey();

	/**
	 * 查询条件值取得
	 * @return queryValue 查询条件值
	 */
	public String[] getQueryValue();
	
	/**
	 * 显示列集合取得
	 * @return showColumnList 显示列集合
	 */
	public List<IG110Info> getShowColumnList();

	/**
	 * 查询条件定义集合取得
	 * @return queryList 查询条件定义集合
	 */
	public List<IG111Info> getQueryList();

	/**
	 * 流程紧急程度取得(在应急中作为应急指挥流程是否是演练发起标识)
	 * 
	 * @return
	 */
	public String getPrurgency();
}
