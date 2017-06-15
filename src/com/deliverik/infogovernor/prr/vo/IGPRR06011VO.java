/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程通用查询VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR06011VO extends BaseVO{

	/** 流程查询结果 */
	protected List<Map<String, Object>> result;

	/**
	 * 流程查询结果取得
	 * @return result 流程查询结果
	 */
	public List<Map<String, Object>> getResult() {
		return result;
	}

	/**
	 * 流程查询结果设定
	 * @param result 流程查询结果
	 */
	public void setResult(List<Map<String, Object>> result) {
		this.result = result;
	}
}
