/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.smr.bl.IGSMR03BL;
import com.deliverik.infogovernor.smr.dto.IGSMR03DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0301Form;
import com.deliverik.infogovernor.smr.form.IGSMR0302Form;
import com.deliverik.infogovernor.smr.vo.IGSMR03011VO;
import com.deliverik.infogovernor.smr.vo.IGSMR03021VO;

/**
 * 概述:我的填报（年报）查询 
 * 功能描述：我的填报（年报）查询 
 * 创建人：赵梓廷
 * 创建记录： 2013-07-25
 * 修改记录：
 */
public class IGSMR0302Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSMR0302Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORM取得
		IGSMR0302Form form = (IGSMR0302Form)actionForm;
						
		//BL取得
		IGSMR03BL ctlBL = (IGSMR03BL) getBean("igSMR03BL");
						
		//DTO生成
		IGSMR03DTO dto = new IGSMR03DTO();
				
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
				
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========填报查询页面显示处理开始========");
			//得到当前年，form中年份为空则将当前年放进form中
			if(form.getYear()==null){				
				form.setYear(IGStringUtils.getCurrentYear());
			}
			//将form放进dto中
			dto.setIgSMR0302Form(form);
			//查询当前登录者需要处理的年报
			dto = ctlBL.seeFillInAction(dto);
			//实例化vo
			IGSMR03021VO vo = new IGSMR03021VO();
			vo.setMap_see(dto.getMap_see());
			super.<IGSMR03021VO>setVO(request, vo);
			saveToken(request);
			log.debug("========填报审批查询页面显示处理结束========");
		}
		if("STOP".equals(mapping.getParameter())){
			if (isTokenValid(request, true)){
				//将form放进dto中
				dto.setIgSMR0302Form(form);
				//中止流程
				dto = ctlBL.stopFillInAction(dto);
				if(StringUtils.isNotEmpty(request.getParameter("type"))){
					forward ="STOP1";
				}else{
					forward = "STOP";
				}
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}			
		}
		if("Modal".equals(mapping.getParameter())){
			log.debug("========模态页显示处理开始 ========");
			//将form中的prid重新放进form中
			form.setPrid(form.getPrid());
			log.debug("========模态页显示处理结束========");
			forward = "Modal";
		}
		if("Message".equals(mapping.getParameter())){
			log.debug("========模态页显示处理开始 ========");
			//将form中的prid重新放进form中
			form.setPrid(form.getPrid());
			log.debug("========模态页显示处理结束========");
			forward = "Message";
		}
		if("Insert".equals(mapping.getParameter())){
			log.debug("========催办工作处理开始 ========");
			//将form放进dto中
			dto.setIgSMR0302Form(form);
			//调用处理方法
			dto = ctlBL.pressAction(dto);
			request.setAttribute("flag", "1");
			forward = "Insert";
			log.debug("========催办工作处理结束 ========");
		}
		return mapping.findForward(forward);
	}

}
