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
import com.deliverik.infogovernor.smr.form.IGSMR0903Form;

/**
 * 概述:科技项目分析DashBoard
 * 功能描述：信息科技项目分析DashBoard
 * 创建记录： 2013-09-16
 * 修改记录：
 */
public class IGSMR0903Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0903Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		IGSMR0903Form form = (IGSMR0903Form)actionForm;
		IGSMR09BL ctlBL = (IGSMR09BL) getBean("igSMR09BL");
		IGSMR09DTO dto = new IGSMR09DTO();
		String forward = "DISP";
		dto.setIgsmr0903Form(form);
		PrintWriter out = response.getWriter();

		if("SEARCH".equals(mapping.getParameter())){
			
			String type = request.getParameter("searchType");
			if("PieGraph".equals(type)){
				log.debug("========信息科技项目分析DashBoard查询处理开始(PieGraph)========");
				dto = ctlBL.getQuarAnalysePieGraph(dto);
				log.debug("========信息科技项目分析DashBoard查询处理结束(PieGraph)========");
			}else if("TrendGraph".equals(type)){
				log.debug("========信息科技项目分析DashBoard查询处理开始(TrendGraph)========");
				dto = ctlBL.getQuarAnalyseTrendGraph(dto);
				log.debug("========信息科技项目分析DashBoard查询处理结束(TrendGraph)========");
			}else if("GridGraph".equals(type)){
				log.debug("========信息科技项目分析DashBoard查询处理开始(GridGraph)========");
				dto = ctlBL.getQuarAnalyseGridGraph(dto);
				log.debug("========信息科技项目分析DashBoard查询处理结束(GridGraph)========");
			}
			String result = dto.getResult();
			if(StringUtils.isEmpty(result)) result = "";
			out.print(result);
			out.flush();
			return null;
			
		}else if("DISP".equals(mapping.getParameter())){
			log.debug("========信息科技项目分析DashBoard初期显示处理开始========");
			log.debug("========信息科技项目分析DashBoard初期显示处理结束========");
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
