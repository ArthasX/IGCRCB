/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG110Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:流程查询显示列宽度定义VO 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD01461VO extends BaseVO{

	/** 已设定流程查询显示列集合 */
    protected List<IG110Info> queryShowColumnList;

	/**
	 * 已设定流程查询显示列集合取得
	 * @return queryShowColumnList 已设定流程查询显示列集合
	 */
	public List<IG110Info> getQueryShowColumnList() {
		return queryShowColumnList;
	}

	/**
	 * 已设定流程查询显示列集合设定
	 * @param queryShowColumnList 已设定流程查询显示列集合
	 */
	public void setQueryShowColumnList(List<IG110Info> queryShowColumnList) {
		this.queryShowColumnList = queryShowColumnList;
	}
}
