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
import com.deliverik.infogovernor.dbm.bl.IGDBM02BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM02DTO;

/**
 * ��          ��:  ������ҳDashBoard ����Action
 * ���������� 1.�¼�����������
 *           2.�����¼���������������
 *           3.������
 *           4.����¼�������ƽ�������������
 *           5.������������������
 *           6.��ȱ���������ɹ���
 *           7.��ͼ
 *           8.��ע����
 * ������¼���κ��� 2010/10/26
 * �޸ļ�¼��n/a
 */
public class IGDBM0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0102Action.class);

	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM02BL ctlBL = (IGDBM02BL) getBean("igDBM02BL");
		IGDBM02DTO dto = new IGDBM02DTO();
		
		//������ת�趨
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			//���̶���Ǽǻ��������ʾ����
			log.debug("========���̶���Ǽǻ��������ʾ����ʼ========");
			
			//������ҳ�����¼�����ȡ�ô���
			ctlBL.getCurrentMouthEventCount(dto);
			
			//������ҳ������������ȡ�ô���
			ctlBL.getCurrentMouthProblemCount(dto);
			
			//������ҳ�����Ĺ�������ȡ�ô���
			ctlBL.getWorkCount(dto);
			
			//���ɴ�����ҳ����¼�������ƽ�����ʱ��xml
			dto = ctlBL.setEventAvgCost(dto);
			
			req.setAttribute("lfy1", dto.getResultXML());
			
			//���ɴ�����ҳ�������������ƽ�������xml
			dto = ctlBL.setproProblemAvgSolute(dto);
			req.setAttribute("lfy2", dto.getResultXML());
			
			//���ɴ�����ҳ�������������ƽ�������xml
			dto = ctlBL.setproChangeAvgSuccess(dto);
			req.setAttribute("lfy3", dto.getResultXML());
			//���ɴ�����ҳ����ƻ�����xml
			ctlBL.setChangePlan(dto);
			
			//���ɴ�����ҳ����ƻ�����xml
			//dto.setValueOfDate("20101114|true");
			//ctlBL.setChangePlan(dto);
			
			//���ɴ�����ҳ����ƻ�����xml
			//dto.setValueOfDate("20101108|false");
			//ctlBL.setChangePlan(dto);
			req.setAttribute("eventcount", dto.getCurrentMouthEventCount());
			
			req.setAttribute("problemcount", dto.getCurrentMouthProblemCount());
			String[] workResult = dto.getWorkCount().split(",");
			req.setAttribute("workcount", workResult[0]);
			req.setAttribute("workCenter", workResult[1]);
			
			req.setAttribute("jsptype", req.getParameter("type"));
			
			log.debug("========���̶���Ǽǻ��������ʾ��������========");
			
			return mapping.findForward("DISP");
		}
		
		

		return mapping.findForward(forward);
	}
}
