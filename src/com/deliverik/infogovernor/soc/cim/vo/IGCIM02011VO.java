/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0115Info;
import com.deliverik.infogovernor.soc.model.CR03Info;

/**
 * 概述: 控制台显示VO
 * 功能描述: 控制台显示VO
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM02011VO extends BaseVO implements Serializable{
	
	/** 配置导入任务列表 */
	protected List<SOC0115Info> soc0115List;
	
	/** 配置导入任务列表-ci2 */
	protected List<CR03Info> cr03InfoList;
	
	/**
	 * 构造函数
	 * @param eiWaitTaskList 配置导入任务列表
	 */
	public IGCIM02011VO(List<SOC0115Info> soc0115List) {
		this.soc0115List = soc0115List;
	}
	
	/**
	 * 无差构造函数
	 */
	public IGCIM02011VO() {

	}
	/**
	 * 配置导入任务列表取得-ci2
	 * @return 配置导入任务列表-ci2
	 */
	public List<CR03Info> getCr03InfoList() {
		return cr03InfoList;
	}
	/**
	 * 配置导入任务列表赋予-ci2
	 * @return 配置导入任务列表-ci2
	 */
	public void setCr03InfoList(List<CR03Info> cr03InfoList) {
		this.cr03InfoList = cr03InfoList;
	}

	/**
	 * 配置导入任务列表取得
	 * @return 配置导入任务列表
	 */
	public List<SOC0115Info> getSoc0115List() {
		return soc0115List;
	}
	
	
	
}


