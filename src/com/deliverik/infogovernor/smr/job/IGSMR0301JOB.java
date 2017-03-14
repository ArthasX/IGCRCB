/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.job;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT;
import com.deliverik.infogovernor.smr.bl.task.RemindInfoBL;
import com.deliverik.infogovernor.smr.model.entity.RemindInfoTB;

/**
 * 概述:定时提醒 
 * 功能描述：定时提醒 
 * 创建人：赵梓廷
 * 创建记录： 2013-08-06
 * 修改记录：
 */
public class IGSMR0301JOB implements Job{
	
	
	private static Log log = LogFactory.getLog(IGSMR0301JOB.class);
	
	
	private static SendMessageBL sendMessageBL = (SendMessageBL) WebApplicationSupport.getBean("sendMessageBL");
	
	private static UserRoleBL userRoleBL = (UserRoleBL) WebApplicationSupport.getBean("userRoleBL");
	
	private static RemindInfoBL remindInfoBL = (RemindInfoBL) WebApplicationSupport.getBean("remindInfoBL");
	
	/**
	 * 入口
	 * 
	 * @param context
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.debug("========插入定时提醒信息处理开始========");
        //查看填报发起人角色下的所有人
		//实例化查询条件
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoletype(IGSMRCONSTANT.ROLETYPE_REPORT);
		List<UserRoleInfo> listrole =  userRoleBL.searchUserRoleVW(cond);
		//将这些人放进提醒信息表中，并且给这些人发短信
		for(UserRoleInfo info:listrole){
			//实例化提醒信息表
			RemindInfoTB tb  = new RemindInfoTB();
			tb.setRiuseid(info.getUserid());
			tb.setRistatus(IGSMRJOBCONSTANTS.INFOMATION_NODATED);
			tb.setRitype(IGSMRJOBCONSTANTS.YEARREPORT_TYPE);
			tb.setRiinfo("请发起年报填报");
			//插入到提醒信息表中
			try {
				remindInfoBL.registRemindInfo(tb);
			} catch (BLException e) {
				e.printStackTrace();
			}
			//发送短信提醒
			sendMessageBL.sendSmsToUser(info.getUserid(), "请发起年报填报");
		}
		
		
		log.debug("========插入定时提醒信息处理结束========");
		
	}

}
