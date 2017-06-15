/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 模块：后勤管理-食堂管理
 * 说明：食堂出库明细查询接口
 * 作者：唐晓娜
 */
public interface GoutDetailSearchCond {
	
	/** 查询开始月 */
	public String getMonth_from();
	/** 查询结束月 */
	public String getMonth_to();
	/** 查询年 */
	public String getYear();
	/** 使用类型是普通消耗还是招待消耗 */
	public String getUseType();
	/** 领用人 */
	public String getGuser();
}
