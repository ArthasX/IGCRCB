/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.igflow.parameter.WorkFlowLogInfo;

/**
 * 概述: 前后处理参数定义接口
 * 功能描述: 前后处理参数定义接口
 * 创建记录: 2012/04/13
 * 修改记录: 
 */
public class WorkFlowStatusEventBean implements WorkFlowStatusEventBeanInfo {
	
		/** 流程定义ID（包括版本信息） */
		protected String pdid;
		
		/** 处理按钮ID */
		protected String pbdid;
		
		/** 跃迁前状态标识 */
		protected String bfstatus;
		
		/** 跃迁后状态标识 */
		protected String afstatus;
		
		/** 跃迁前状态标识编号 */
		protected String bfstatusnum;
		
		/** 跃迁后状态标识编号 */
		protected String afstatusnum;
		
		/** 流程发起者ID */
		protected String crtuserid;
		
		/** 流程发起角色ID */
		protected Integer crtroleid;
		
		/** 动态分支编号 */
		protected Integer psdnum;
		
		/** 日志参数信息 */
		protected WorkFlowLogInfo logInfo;

		/**
		 * 流程定义ID（包括版本信息）取得
		 * @return 流程定义ID（包括版本信息）
		 */
		public String getPdid() {
			return pdid;
		}

		/**
		 * 流程定义ID（包括版本信息）设定
		 * 
		 * @param pdid 流程定义ID（包括版本信息）
		 */
		public void setPdid(String pdid) {
			this.pdid = pdid;
		}

		/**
		 * 处理按钮ID取得
		 * @return 处理按钮ID
		 */
		public String getPbdid() {
			return pbdid;
		}

		/**
		 * 处理按钮ID设定
		 * 
		 * @param pbdid 处理按钮ID
		 */
		public void setPbdid(String pbdid) {
			this.pbdid = pbdid;
		}

		/**
		 * 跃迁前状态标识取得
		 * @return 跃迁前状态标识
		 */
		public String getBfstatus() {
			return bfstatus;
		}

		/**
		 * 跃迁前状态标识设定
		 * 
		 * @param bfstatus 跃迁前状态标识
		 */
		public void setBfstatus(String bfstatus) {
			this.bfstatus = bfstatus;
		}

		/**
		 * 跃迁后状态标识取得
		 * @return 跃迁后状态标识
		 */
		public String getAfstatus() {
			return afstatus;
		}

		/**
		 * 跃迁后状态标识设定
		 * 
		 * @param afstatus 跃迁后状态标识
		 */
		public void setAfstatus(String afstatus) {
			this.afstatus = afstatus;
		}
		
		/**
		 * 跃迁前状态标识编号取得
		 * @return 跃迁前状态标识编号
		 */
		public String getBfstatusnum() {
			return bfstatusnum;
		}
		
		/**
		 * 跃迁前状态标识编号设定
		 * 
		 * @param bfstatus 跃迁前状态标识编号
		 */
		public void setBfstatusnum(String bfstatusnum) {
			this.bfstatusnum = bfstatusnum;
		}
		
		/**
		 * 跃迁后状态标识编号取得
		 * @return 跃迁后状态标识编号
		 */
		public String getAfstatusnum() {
			return afstatusnum;
		}
		
		/**
		 * 跃迁后状态标识编号设定
		 * 
		 * @param afstatus 跃迁后状态标识编号
		 */
		public void setAfstatusnum(String afstatusnum) {
			this.afstatusnum = afstatusnum;
		}

		/**
		 * 流程发起者ID取得
		 * @return 流程发起者ID
		 */
		public String getCrtuserid() {
			return crtuserid;
		}

		/**
		 * 流程发起者ID设定
		 * 
		 * @param crtuserid 流程发起者ID
		 */
		public void setCrtuserid(String crtuserid) {
			this.crtuserid = crtuserid;
		}

		/**
		 * 流程发起角色ID取得
		 * @return 流程发起角色ID
		 */
		public Integer getCrtroleid() {
			return crtroleid;
		}

		/**
		 * 流程发起角色ID设定
		 * 
		 * @param crtroleid 流程发起角色ID
		 */
		public void setCrtroleid(Integer crtroleid) {
			this.crtroleid = crtroleid;
		}

		/**
		 * 动态分支编号取得
		 * @return psdnum 动态分支编号
		 */
		public Integer getPsdnum() {
			return psdnum;
		}

		/**
		 * 动态分支编号设定
		 * @param psdnum 动态分支编号
		 */
		public void setPsdnum(Integer psdnum) {
			this.psdnum = psdnum;
		}

		/**
		 * 日志参数信息取得
		 * 
		 * @return 日志参数信息
		 */
		public WorkFlowLogInfo getLogInfo() {
			return logInfo;
		}

		/**
		 * 日志参数信息设定
		 * 
		 * @param logInfo 日志参数信息
		 */
		public void setLogInfo(WorkFlowLogInfo logInfo) {
			this.logInfo = logInfo;
		}
		
}
