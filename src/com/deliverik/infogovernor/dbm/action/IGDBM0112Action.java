/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.dbm.bl.IGDBM03BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM03DTO;

/**
 * ������ҳdashborad
 * @version 1.0
 */

public class IGDBM0112Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDBM0110Action.class);
	
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM03BL ctlBL = (IGDBM03BL) getBean("igDBM03BL");
		IGDBM03DTO dto = new IGDBM03DTO();
		
		//������ת�趨
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========������ҳ������ʾ����ʼ========");
			
			//�������Ȿ���¼�����ȡ�ô���
			ctlBL.getCurrentMouthEventCount(dto);
			
			//�������Ȿ����������ȡ�ô���
			ctlBL.getCurrentMouthProblemCount(dto);
			
			//����������ҳ�����Ĺ�������ȡ�ô���
			ctlBL.getAllTypeWorkCount(dto);
			
			//��������������ҳ����¼�������ƽ�����ʱ��xml
			ctlBL.setEventAvgCost(dto);
			req.setAttribute("lfy1", dto.getResultXML());

			//��������������ҳ��ȱ��������ƽ�������xml
			ctlBL.setproChangeAvgSuccess(dto);
			req.setAttribute("lfy3", dto.getResultXML());
			
			//��������������ҳ����ƻ�����xml
			ctlBL.setChangePlan(dto);
			
			req.setAttribute("eventcount", dto.getCurrentMouthEventCount());
			
			req.setAttribute("problemcount", dto.getCurrentMouthProblemCount());
			String[] workResult = dto.getAllTypeWorkCount().split(",");
			req.setAttribute("workcount", workResult[0]);
			req.setAttribute("worktype", workResult[1]);
			
			req.setAttribute("jsptype", req.getParameter("type"));
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
