/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 演练VO
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM07011VO extends BaseVO{
	/**演练方案定义阶段流程*/
	protected List<IG500Info> ig500InfoList;

	public List<IG500Info> getIg500InfoList() {
		return ig500InfoList;
	}

	public void setIg500InfoList(List<IG500Info> ig500InfoList) {
		this.ig500InfoList = ig500InfoList;
	}
	
	
}
