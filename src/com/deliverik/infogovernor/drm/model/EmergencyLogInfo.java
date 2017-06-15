/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 概述：应急日志信息表接口
 * 功能描述：应急日志信息表接口
 * 创建记录：2014/05/19
 * 修改记录：
 */
public interface EmergencyLogInfo extends BaseModel {
	/**
	 * 主键ID取得
	 * @return elid
	 */
	public Integer getElid();
    /**
	 * 应急启动流程ID取得
	 * @return elprid
	 */
	public Integer getElprid();
	/**
	 * 日志信息类型取得
	 * (目前ProcessLog和NoticeLog两种)
	 * @return ellitype
	 */
	public String getEllitype();
	/**
	 * 日志信息发布时间取得
	 * @return ellidtime
	 */
	public String getEllidtime();
	/**
	 * 日志信息发布人用户ID取得
	 * @return eluserid
	 */
	public String getEluserid();
	/**
	 * 日志信息发布人用户名称取得
	 * @return elusername
	 */
	public String getElusername();
	/**
	 * 日志信息内容取得
	 * @return elliinfo
	 */
	public String getElliinfo();
	
	/**
	 * 日志状态ID取得
	 * @return elliinfo
	 */
	public String getElpsdid();
	
	/**
	 * 日志状态名称取得
	 * @return elliinfo
	 */
	public String getElpsdname();
	/**  
	 * 获取operate  
	 * @return operate 
	 */
	public String getOperate() ;
}