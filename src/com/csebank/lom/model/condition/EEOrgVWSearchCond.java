/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 模块：后勤管理-食堂管理
 * 说明：部门接待汇总查询接口
 * 作者：唐晓娜
 */
public interface EEOrgVWSearchCond {
	
	/** 年度查询 */
	public String getYear();
	
	/** 查询开始月 */
	public String getMonth_from();
	
	/** 查询结束月 */
	public String getMonth_to();
	
	/** 部门层次码 */
	public String getRapporgid();
	
	/** 部门层次码 */
	public String getRapporgid_org();

}
