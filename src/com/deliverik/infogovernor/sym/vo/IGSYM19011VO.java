/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeTemplateInfo;
/**
 * 概述:作息日期模板画面VO
 * 创建记录：张楠    2011/10/18
 * 功能描述：SOC原作息时间设定
 * 修改时间：LuJiayuan 2013/01/29 代码合并将原IGSYM17011VO更名IGSYM19011VO
 */
@SuppressWarnings("serial")
public class IGSYM19011VO extends BaseVO implements Serializable{
	
	/**
	 * 作息日期模板结果集
	 */
	protected List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList;

	/**
	 * 作息日期模板结果集获取
	 * @return
	 */
	public List<ProcessWorkTimeTemplateInfo> getProcessWorkTimeTemplateInfoList() {
		return processWorkTimeTemplateInfoList;
	}

	/**
	 * 作息日期模板结果集设定
	 * @param processWorkTimeTemplateInfoList
	 */
	public void setProcessWorkTimeTemplateInfoList(
			List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList) {
		this.processWorkTimeTemplateInfoList = processWorkTimeTemplateInfoList;
	}

}
