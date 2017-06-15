/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.model.condition;

import java.util.List;

/**
 * 
 * 资产相关流程查询接口
 *
 */
public interface IG500VWSearchCond {
	/**
	 * 资产id取得
	 * @return eiid 资产id
	 */
	public String getEiid();

	/**
	 * 流程类型集合取得
	 * @return prpdid_in 流程类型集合
	 */
	public List<String> getPrpdid_in();

	/**
	 * 流程类型取得
	 * @return prpdid_eq 流程类型
	 */
	public String getPrpdid_eq();
}
