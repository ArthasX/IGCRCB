/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.fin.bl.IGFIN01BL;
import com.deliverik.infogovernor.fin.dto.IGFIN01DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0101Form;


/**
 * 预算登记画面Action处理
 *
 */
public class IGFIN0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0101Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		IGFIN0101Form form = (IGFIN0101Form)actionForm;
		
		//BL取得
		IGFIN01BL ctlBL = (IGFIN01BL) getBean("igfin01BL");
		
		//DTO生成
		IGFIN01DTO dto = new IGFIN01DTO();
		//预算年费列表
		List<LabelValueBean> byearList = new ArrayList<LabelValueBean>();
		if( "DISP".equals(mapping.getParameter())){
			//预算登记画面初期显示处理
			log.debug("========预算登记画面初期显示处理开始========");
			//获取当前年份
			int currentYear = Integer.parseInt(IGStringUtils.getCurrentYear());
			//计算当前年份的前五年及后一年
			for(int i=5;i>0;i--){
				int temp = currentYear - i;
				byearList.add(new LabelValueBean(temp+"",temp+""));
			}
			byearList.add(new LabelValueBean(currentYear+"",currentYear+""));
			byearList.add(new LabelValueBean(currentYear +1+"",currentYear +1+""));
			dto.setByearList(byearList);
			form.setByear(currentYear+"");
			//存储年份列表
			req.setAttribute("byearList", byearList);
			addMessage(req, new ActionMessage("IGCO10000.I001","预算信息"));
			saveToken(req);
			log.debug("========预算登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//预算登记画面再显示处理
			log.debug("========预算登记画面再显示处理开始========");
			//获取当前年份
			int currentYear = Integer.parseInt(IGStringUtils.getCurrentYear());
			//计算当前年份的前五年及后一年
			for(int i=5;i>0;i--){
				int temp = currentYear - i;
				byearList.add(new LabelValueBean(temp+"",temp+""));
			}
			byearList.add(new LabelValueBean(currentYear+"",currentYear+""));
			byearList.add(new LabelValueBean(currentYear +1+"",currentYear +1+""));
			//存储年份列表
			form.setByear_q(currentYear+"");
			req.setAttribute("byearList", byearList);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========预算登记画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//预算编辑处理
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//预算编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回预算登记画面
					return mapping.findForward("BACK1");
				} else {
					//返回预算详细 画面
					return mapping.findForward("BACK2");
				}
			}
			if (form.getBstatus().equals("O")){
				//预算登记处理
				log.debug("========预算登记处理开始========");

				//DTO输入参数设定
				
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setBreqname(user.getUsername());
															
				dto.setBudget(form);
				if (isTokenValid(req, true)){
					//预算登记逻辑调用
					
					dto = ctlBL.insertBudgetTBDAOAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========预算登记处理终了========");

			}
		}
		
		
		if ("DELETE".equals(mapping.getParameter())){
			//预算删除处理
			log.debug("========预算删除处理开始========");
			
			//DTO输入参数设定
			
			dto.setDeleteBudget(form.getBid());
			
			//预算信息删除逻辑调用
			dto = ctlBL.deleteBudgetAction(dto);
			if(null == dto){
				return mapping.findForward("ERROR");
			}
			
			log.debug("========预算删除处理终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		return mapping.findForward("DISP");
	}
}
