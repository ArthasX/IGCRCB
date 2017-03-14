/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

import java.util.List;

/**
  * 概述: 预案章节信息检索条件接口
  * 功能描述: 预案章节信息检索条件接口
  * 创建记录: 2016/07/07
  * 修改记录: 
  */
public interface SOC0509SearchCond {
	public String getEsyscoding_like();
	public List<String> getEsyscodingList();
	public String getEid() ;
	public String getCname();
	public String getPcid();
	//按层次码查询
	public String getEsyscoding();
}