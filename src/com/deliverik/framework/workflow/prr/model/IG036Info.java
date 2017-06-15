package com.deliverik.framework.workflow.prr.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.model.Attachment;

/**
 * <p>
 * 日志信息
 * </p>
 */

public interface IG036Info  extends BaseModel,Comparable<IG036Info> {

	/**
	 * 日志ID取得
	 * @return 日志ID
	 */
	public Integer getRlid();

	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid();

	/**
	 * 日志记录时间取得
	 * @return 日志记录时间
	 */
	public String getRltime();

	/**
	 * 日志处理人角色ID取得
	 * @return 日志处理人角色ID
	 */
	public Integer getRoleid();

	/**
	 * 日志处理人角色名称取得
	 * @return 日志处理人角色名称
	 */
	public String getRlrolename();

	/**
	 * 日志处理人ID取得
	 * @return 日志处理人ID
	 */
	public String getRluserid();

	/**
	 * 日志处理人姓名取得
	 * @return 附件ID
	 */
	public String getRlusername();

	/**
	 * 日志描述取得
	 * @return 日志描述
	 */
	public String getRldesc();

	/**
	 * 日志处理人填写的信息取得
	 * @return  日志处理人填写的信息
	 */
	public String getRlcomment();

	/**
	 * 附件索引取得
	 * @return 附近索引
	 */
	public String getRlattkey();
	
	/**
	 * 附件类型取得
	 * @return 附件类型
	 */
	public String getRltype();
	
	/**
	 * 日志处理人机构层次码取得
	 * @return 附件ID
	 */
	public String getRlorgid();
	
	/**
	 * 日志处理人机构名称取得
	 * @return 日志处理人机构名称
	 */
	public String getRlorgname();
	
	/**
	 * 附件取得
	 * @return 附件
	 */
	public List<Attachment> getAttachmentList();
	
	/**
	 * 流程状态名称取得
	 * @return 流程状态名称
	 */
	public String getPsname();
	
	/**
	 * 流程状态编码取得
	 * @return 流程状态编码
	 */
	public String getPsdcode();
	
	/**
	 * 角色负责人标识取得
	 * @return 角色负责人标识
	 */
	public String getRolemanger();
	
	/**
	 * 按钮ID设定
	 * 
	 * @return 按钮ID
	 */
	public String getPbdid();

	/**
	 * 流程状态定义ID取得
	 * @return 流程状态定义ID
	 */
	public String getPsdid();

	/**
	 * 动态分支编号取得
	 * @return 动态分支编号
	 */
	public Integer getPsdnum();

}