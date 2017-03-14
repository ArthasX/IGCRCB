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
import com.deliverik.infogovernor.smr.bl.IGSMR06BL;
import com.deliverik.infogovernor.smr.dto.IGSMR06DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0602Form;
import com.deliverik.infogovernor.smr.vo.IGSMR06021VO;

/**
 * 概述:季报催办
 * 功能描述：季报催办
 * 创建人：赵梓廷
 * 创建记录： 2013-08-08
 * 修改记录：
 */
public class IGSMR0603Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0603Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORM取得
		IGSMR0602Form form = (IGSMR0602Form)actionForm;
								
		//BL取得
		IGSMR06BL ctlBL = (IGSMR06BL) getBean("igSMR06BL");
								
		//DTO生成
		IGSMR06DTO dto = new IGSMR06DTO();
						
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);						
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========填报查询页面显示处理开始========");
			//得到当前季度，form中季度为空则将当前季度放进form中
			if(StringUtils.isEmpty(form.getQuarter())){
				if(IGStringUtils.getCurrentDate().substring(5, 7).equals("02")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("03")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("04")){
					form.setQuarter("1");
				}
				if(IGStringUtils.getCurrentDate().substring(5, 7).equals("05")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("06")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("07")){
					form.setQuarter("2");
				}
				if(IGStringUtils.getCurrentDate().substring(5, 7).equals("08")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("09")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("10")){
					form.setQuarter("3");
				}
				if(IGStringUtils.getCurrentDate().substring(5, 7).equals("11")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("12")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("01")){
					form.setQuarter("4");
				}
				
			}
			//如果当前年为空，则将当前年放进form中
			if(StringUtils.isEmpty(form.getYear())){
				form.setYear(IGStringUtils.getCurrentYear());
			}
			//将form放进dto中
			dto.setIgSMR0602Form(form);
			//查询当前登录者需要处理的年报
			dto = ctlBL.seeFillInAction(dto);
			//实例化vo
			IGSMR06021VO vo = new IGSMR06021VO();
			vo.setMap_see(dto.getMap_see());
			super.<IGSMR06021VO>setVO(request, vo);
			saveToken(request);
			log.debug("========填报审批查询页面显示处理结束========");
		}
		if("STOP".equals(mapping.getParameter())){
			if (isTokenValid(request, true)){
				//将form放进dto中
				dto.setIgSMR0602Form(form);
				//中止流程
				dto = ctlBL.stopFillInAction(dto);
				forward = "STOP";
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
			dto.setIgSMR0602Form(form);
			//调用处理方法
			dto = ctlBL.pressAction(dto);
			request.setAttribute("flag", "1");
			forward = "Insert";
			log.debug("========催办工作处理结束 ========");
		}
		return mapping.findForward(forward);
	}

}
