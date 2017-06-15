/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.dev.crc.igflow.event.status.bl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.resultset.UserInfo;
	
/***
	 * 风险管理信息提醒，发送给同角色下的所有人。 
	 * 	 (1)短信提醒
	 *   (2)邮件提醒 
	 * @time 2014/06/11
	 * @author zq
	 * @email zhangq@deliverik.com
	 * @version 1.0
	 */
public class IGFXKDataSendBLImpl implements IGFXKDataSendBL {

	/**配置日志*/
	private static Log log = LogFactory.getLog(IGFXKDataSendBLImpl.class);
	/** 短信BL */
	protected SendMessageBL sendMessageBL;

	/** 邮件BL */
	protected SendMailBL sendMailBL;

	/** 查询BL */
	protected SysManageBL sysManageBL;

	/** 风险管理岗的角色ID*/
	protected static final Integer ROLE_ID = 1224;

	/***
	 * 短信BL设定
	 * 
	 * @param sendMessageBL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * 邮件BL 设定
	 * 
	 * @param sendMailBL
	 */
	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
	}

	/***
	 * 搜索BL 设定
	 * 
	 * @param sysManageBL
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}
	
	/**
	 * 风险管理发送提醒
	 * @param bTime 计划开始时间
	 * @param eTime 计划结束时间
	 * @param title 计划标题
	 */
	public void dataSend(Object bTime, Object eTime, Object title)
			throws BLException {
		log.debug("============================风险管理发送提醒开始=========================");
		
		// 根据角色ID 查询 人员信息
		List<UserInfo> userlist = this.sysManageBL.searchUserInfo(ROLE_ID, null);
	
		// 创建发送的内容
		StringBuffer messageContent = new StringBuffer();
		messageContent.append("计划时间在");
		messageContent.append(bTime);
		messageContent.append(" - ");
		messageContent.append(eTime);
		messageContent.append("的风险计划");
		messageContent.append(title);
		messageContent.append("需要您执行检查。");

		// 创建发送邮件的标题
		StringBuffer mailTitle = new StringBuffer();
		mailTitle.append("关于");
		mailTitle.append(title);
		mailTitle.append("的风险计划通知。");
		//定义空的邮箱地址数组	
		String address[]; 
		for (UserInfo info : userlist) {
			// 如果用户邮箱存在
			if(StringUtils.isNotEmpty(info.getUseremail())){
				//初始化长度为1的String类型数组
				address=new String[1];
				//获取用户邮箱地址加入到数组
				address[0]=info.getUseremail();
				// 发送邮件提醒
				this.sendMailBL	.sendMail((String) mailTitle.toString(), messageContent.toString(), address);

			}
			// 发送短信提醒
			this.sendMessageBL.sendSmsToUser(info.getUserid(),messageContent.toString());

		}
		log.debug("============================风险管理发送提醒结束=========================");
	}
}
