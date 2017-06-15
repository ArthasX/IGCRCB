/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 模块：后勤管理-食堂管理
 * 说明：食堂管理部门接待汇总查询接口
 * 作者：唐晓娜
 */
public interface EESearchCond {
	
	
	/**
	 * 部门接待统计申请部门层次码
	 */
	public String getRapporgid_org();
	
	/**
	 * 部门接待统计年份
	 */
	public String getYear_org();
	
	/**
	 * 部门接待统计开始月份
	 */
	public String getMonth_from_org();
	
	/**
	 * 部门接待统计结束月份
	 */
	public String getMonth_to_org();
	
	
}
