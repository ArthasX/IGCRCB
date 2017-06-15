/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.bl;

/**
 * 概述: 知识管理相关常量类
 * 功能描述：知识管理相关常量类
 * 创建记录：刘鹏 2010/12/07
 * 修改记录：
 */
public class IGKGMCONSTANTS {
	//-----------------------------------------------------------宋海洋----------------------------------------------------------------------
	/** 知识状态:未审核 */
	public static final String KNOWLEDGE_UN_APPROVE = "0";
	/** 知识状态:审核通过 */
	public static final String KNOWLEDGE_APPROVEED = "1";
	/** 知识状态:驳回 */
	public static final String KNOWLEDGE_REJECT = "2";
	
	/** 知识状态:停用 */
	public static final String KNOWLEDGE_STOP = "3";
	
	/** 知识状态:删除 */
	public static final String KNOWLEDGE_DELETE = "4";
	
	/** 知识状态:"草稿 */
	public static final String KNOWLEDGE_INIT = "5";
	
	//-----------------------------------------------------------刘鹏----------------------------------------------------------------------
		
	/** 知识关系类型：流程关联知识 */
	public static final String PROCESS_RELATE_KNOWLEDGE = "0";
	
	/** 知识关系类型：知识关联流程 */
	public static final String KNOWLEDGE_RELATE_PROCESS = "1";
	
	/** 知识关系类型：工单关联知识 */
	public static final String SERVICE_RELATE_KNOWLEDGE = "2";
	
	/** 知识关系类型：知识关联工单 */
	public static final String KNOWLEDGE_RELATE_SERVICE = "3";
	
	/** 流程处理中查看的知识是否有效标识：1是0否 */
	public static final String KPEFFECT_YES = "1";
	
	/** 流程处理中查看的知识是否有效标识：1是0否 */
	public static final String KPEFFECT_NO = "0";
		
	//-----------------------------------------------------------王晓强----------------------------------------------------------------------
		
		
	//-----------------------------------------------------------崔东东----------------------------------------------------------------------
	public static final String KNOWLOG_INSERT = "登记知识";
	public static final String KNOWLOG_UPDATE = "更新知识信息";
	public static final String KNOWLOG_PINGFEN = "知识评分处理";
	public static final String KNOWLOG_EDIT = "变更知识处理";
	public static final String KNOWLOG_RJECT = "知识被驳回";
	public static final String KNOWLOG_APPROCE = "知识审批通过,并已入库";
	public static final String KNOWLOG_WAIT = "知识等待审批";
}
