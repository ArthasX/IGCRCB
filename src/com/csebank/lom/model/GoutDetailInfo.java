/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;
import com.deliverik.framework.base.BaseModel;

/**
 * 模块：后勤管理-食堂管理
 * 说明：食堂物品消耗明细实体接口
 * 作者：唐晓娜
 */
public interface GoutDetailInfo extends BaseModel {
     public String getGoid();
	/** 时间 */
	public String getGotime();
	/** 领用者 */
	public String getGorequsername();
	/** 物品名称 */
	public String getGoname();
	/** 物品编号 */
	public String getGocode();
	/** 招待名称 */
	public String getRname();
	/** 消耗类型 */
	public String getRid();
	//出库数量
	public String getGoinnum();

}
