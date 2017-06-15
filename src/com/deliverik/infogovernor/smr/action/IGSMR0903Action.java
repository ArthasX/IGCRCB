/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * ����:�Ƽ���Ŀ����DashBoard
 * ������������Ϣ�Ƽ���Ŀ����DashBoard
 * ������¼�� 2013-09-16
 * �޸ļ�¼��
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
				log.debug("========��Ϣ�Ƽ���Ŀ����DashBoard��ѯ����ʼ(PieGraph)========");
				dto = ctlBL.getQuarAnalysePieGraph(dto);
				log.debug("========��Ϣ�Ƽ���Ŀ����DashBoard��ѯ�������(PieGraph)========");
			}else if("TrendGraph".equals(type)){
				log.debug("========��Ϣ�Ƽ���Ŀ����DashBoard��ѯ����ʼ(TrendGraph)========");
				dto = ctlBL.getQuarAnalyseTrendGraph(dto);
				log.debug("========��Ϣ�Ƽ���Ŀ����DashBoard��ѯ�������(TrendGraph)========");
			}else if("GridGraph".equals(type)){
				log.debug("========��Ϣ�Ƽ���Ŀ����DashBoard��ѯ����ʼ(GridGraph)========");
				dto = ctlBL.getQuarAnalyseGridGraph(dto);
				log.debug("========��Ϣ�Ƽ���Ŀ����DashBoard��ѯ�������(GridGraph)========");
			}
			String result = dto.getResult();
			if(StringUtils.isEmpty(result)) result = "";
			out.print(result);
			out.flush();
			return null;
			
		}else if("DISP".equals(mapping.getParameter())){
			log.debug("========��Ϣ�Ƽ���Ŀ����DashBoard������ʾ����ʼ========");
			log.debug("========��Ϣ�Ƽ���Ŀ����DashBoard������ʾ�������========");
		}
		
        //�߼���������е���Ϣ��ʾ
        List<ActionMessage> messageList = dto.getMessageList();
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(request, message);
            }
        }
		return mapping.findForward(forward);
	}

}
