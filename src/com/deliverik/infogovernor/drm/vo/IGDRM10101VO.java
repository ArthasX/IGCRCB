/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 应急工作台VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM10101VO extends BaseVO{

	/** 工作台信息 */
	protected Map<String, String> workbenchMap;

	/**
	 * 工作台信息取得
	 * @return workbenchMap 工作台信息
	 */
	public Map<String, String> getWorkbenchMap() {
		return workbenchMap;
	}

	/**
	 * 工作台信息设定
	 * @param workbenchMap 工作台信息
	 */
	public void setWorkbenchMap(Map<String, String> workbenchMap) {
		this.workbenchMap = workbenchMap;
	}
}
