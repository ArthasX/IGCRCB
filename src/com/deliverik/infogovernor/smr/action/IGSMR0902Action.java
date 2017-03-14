/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.action;

import java.io.PrintWriter;
import java.util.List;

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
import com.deliverik.infogovernor.smr.bl.IGSMR09BL;
import com.deliverik.infogovernor.smr.dto.IGSMR09DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0902Form;

/**
 * 概述:年度科技仪表盘dashboard
 * 功能描述：年报dashboard
 * 创建记录： 2013-09
 * 修改记录：
 */
public class IGSMR0902Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0902Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		IGSMR0902Form form = (IGSMR0902Form)actionForm;
		IGSMR09BL ctlBL = (IGSMR09BL) getBean("igSMR09BL");
		IGSMR09DTO dto = new IGSMR09DTO();
		String forward = "DISP";
		dto.setIgsmr0902Form(form);
		PrintWriter out = response.getWriter();

		if("SEARCH".equals(mapping.getParameter())){
			
			String type = request.getParameter("searchType");
			System.out.println(type);
			if("TechnologyInfo".equals(type)){
				log.debug("========年报查询处理开始========");
				
				dto = ctlBL.getTechnologyInfo(dto);
				
				log.debug("========年报查询处理结束========");
			}else if("Personnel".equals(type)){
				log.debug("========年报查询处理开始========");
				
				dto = ctlBL.getPersonnel(dto);
				
				log.debug("========年报查询处理结束========");
			}else if("TechnologyNumber".equals(type)){
				log.debug("========年报查询处理开始========");
				
				dto = ctlBL.getTechnologyNumber(dto);
				
				log.debug("========年报查询处理结束========");
			}else if("PieGraph".equals(type)){
				log.debug("========年报查询处理开始========");
				
				dto = ctlBL.getPieGraph(dto);
				
				log.debug("========年报查询处理结束========");
			}else if("BarGraph".equals(type)){
				log.debug("========年报查询处理开始========");
				
				dto = ctlBL.getBarGraph(dto);
				
				log.debug("========年报查询处理结束========");
			}else if("TechnologySort".equals(type)){
				log.debug("========年报查询处理开始========");
				
				dto = ctlBL.getPieGraph1(dto);
				
				log.debug("========年报查询处理结束========");
			}else if("TechnologyAudit".equals(type)){
				log.debug("========年报查询处理开始========");
				
				dto = ctlBL.getTechnologyAudit(dto);
				
				log.debug("========年报查询处理结束========");
			}
			String result = dto.getResult();
			if(StringUtils.isEmpty(result)) result = "";
			out.print(result);
			out.flush();
			return null;
			
		}else if("DISP".equals(mapping.getParameter())){
			log.debug("========年报初期显示处理开始========");
			log.debug("========年报初期显示处理结束========");
		}
		
        //逻辑处理过程中的信息显示
        List<ActionMessage> messageList = dto.getMessageList();
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(request, message);
            }
        }
		return mapping.findForward(forward);
	}

}
