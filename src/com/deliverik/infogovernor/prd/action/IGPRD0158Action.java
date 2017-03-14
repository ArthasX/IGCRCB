/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0158Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01581VO;

/**
 * ����: ����֪ͨ�����趨Action
 * ��������: ����֪ͨ�����趨Action
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
public class IGPRD0158Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0158Action.class);
	
	/**
	 * Action����
	 *
	 * @param mapping ActionMapping
	 * @param actionForm ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @exception Exception
	 * @return ActionForward
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGPRD0158Form form = (IGPRD0158Form)actionForm;
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		String forward = "";
		dto.setIgPRD0158Form(form);
		request.getSession().setAttribute("ADcount", 0);
		request.getSession().setAttribute("ADValueCount", 0);
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========����֪ͨ���Բ�ѯ����ʼ========");
			
			dto = ctlBL.searchRoleByIGBP06Action(dto);
			dto = ctlBL.searchProcessBLByIGBP06Action(dto);
			// ��ѯ��ɫ
			request.setAttribute("lvPsdassignListRO", dto.getLvPsdassignListRO());
			// ״̬��ʱ���Ѵ���Bl����
			request.setAttribute("lvProcessBLList", dto.getProccessBLList());
			// ���峬ʱ���Ѵ���Bl����
			request.setAttribute("lvProcessAllBLList", dto.getProcesstacticsbl_alllist());
			
			//����BL��ѯ
			dto = ctlBL.initIGPRD0158Action(dto);
			form.setPisize(dto.getPisize());
			form.setPssize(dto.getPssize());
			form.setProcessWholeTactic_listSize(dto.getProcessWholeTactic_listSize());
			
			saveToken(request);
			//����VO
			IGPRD01581VO vo = new IGPRD01581VO();
//			vo.setLst_ProcessNoticeStrategyDef(dto.getLst_ProcessNoticeStrategyDef());
			vo.setShowMap(dto.getShowMap());
			vo.setProcessWholeTactic_list(dto.getProcessWholeTactic_list());
			super.<IGPRD01581VO>setVO(request, vo);
			log.debug("========����֪ͨ���Բ�ѯ��������========");
		}  else if ("SET".equals(mapping.getParameter())){
			if (isTokenValid(request, true)){
				//����BL����
				ctlBL.setIGPRD0158Action(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		} else if ("EDIT".equals(mapping.getParameter())){//��Ӳ�����
			log.debug("========����֪ͨ�����趨����ʼ========");
			if (isTokenValid(request, true)){
				//����BL����
				ctlBL.editIGPRD0158Action(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========����֪ͨ�����趨��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		
		if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
			//��ʷ�汾�µĲ鿴
			forward = "VIEWHISTORY";
		}else{
			forward = "DISP";
		}
		return mapping.findForward(forward);
	}
	
}
