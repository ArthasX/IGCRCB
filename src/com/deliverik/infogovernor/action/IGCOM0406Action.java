/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.bl.IGCOM04BL;
import com.deliverik.infogovernor.dto.IGCOM04DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �쵼�Ǳ�����ҳAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCOM0406Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGCOM0406Action.class);
		//BLȡ��
		IGCOM04BL ctlBL = (IGCOM04BL) getBean("igcom04BL");
		//ʵ����dto
		IGCOM04DTO dto = new IGCOM04DTO();
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============�쵼�Ǳ��̳�ʼ��������ʼ===============");
			//�������Ȿ���¼�����ȡ�ô���
			ctlBL.getCurrentMouthEventCount(dto);
			
			//�������Ȿ����������ȡ�ô���
			ctlBL.getCurrentMouthProblemCount(dto);
			
			// TODO Ѳ��
			//����������ҳ�����Ĺ�������ȡ�ô���
			ctlBL.getAllTypeWorkCount(dto);
			
			//��������������ҳ����¼�������ƽ�����ʱ��xml
			ctlBL.setEventAvgCost(dto);
			request.setAttribute("lfy1", dto.getResultXML());

//			//��������������ҳ��ȱ��������ƽ�������xml
//			ctlBL.setproChangeAvgSuccess(dto);
//			req.setAttribute("lfy3", dto.getResultXML());
			//����ÿ���µ��������������������XML
//			ctlBL.statisticsZhenggaiTotal(dto);
			ctlBL.searchProblemAvgSuccess(dto);
			request.setAttribute("lfy3", dto.getResultXML());
			
			ctlBL.searchProblemTotalByMonth(dto);
			request.setAttribute("chartxml", dto.getResultXML());
			
			//��������xml
			ctlBL.setproincidentInfo(dto);
			request.setAttribute("incidentPie", dto.getResultXML());
			
			//����һ��xml
//			ctlBL.setKnowledgeInfo(dto);
			request.setAttribute("knowPie", dto.getResultXML());
			
			//��������������ҳ����ƻ�����xml
//			ctlBL.setChangePlan(dto);
			
			request.setAttribute("eventcount", dto.getCurrentMouthEventCount());
			
			request.setAttribute("problemcount", dto.getCurrentMouthProblemCount());
			String[] workResult = dto.getAllTypeWorkCount().split(",");
			request.setAttribute("workcount", workResult[0]);
			request.setAttribute("worktype", workResult[1]);
			
			request.setAttribute("jsptype", request.getParameter("type"));
			log.debug("===============�쵼�Ǳ��̳�ʼ����������===============");
		}
		return mapping.findForward("DISP");
	}

}
