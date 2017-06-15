/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dbm.model.condition;

import java.util.List;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 科技运行统计分析查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ScienceOperationReportSearchCond {



	/**
	 * 表单名称取得
	 * @return pivarname 表单名称
	 */
	public String getPivarname();

	/**
	 * 表单备选值取得
	 * @return pidoptions 表单备选值
	 */
	public String getPidoptions();

	/**
	 * 流程发起时间取得
	 * @return propentime_like 流程发起时间
	 */
	public String getPropentime_like();
	
	/**
	 * 流程类型范围取得
	 * @return prpdid_in 流程类型范围
	 */
	public List<String> getPrpdid_in();
}
