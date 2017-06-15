/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
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
import com.deliverik.infogovernor.prd.form.IGPRD0110Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01101VO;

/**
 * ����Ϣ��ѯAction����
 *
 * @author liupeng@deliverik.com
 */
public class IGPRD0110Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0110Action.class);

	/**
	 * ����Ϣ��ѯ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGPRD0110Form form = (IGPRD0110Form)actionForm;
		
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//����Ϣ��ѯ���������ʾ����
			log.debug("========����Ϣ��ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����Ϣ��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if ( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//����Ϣ��ѯ����
			log.debug("========����Ϣ��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGPRD0110Form) req.getSession().getAttribute("IGPRD0110Form");
				if ( form == null ) {
					form = new IGPRD0110Form();
				}
			} 
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGPRD0110");
			
			dto.setProcessInfoDefSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			
			dto.setPdid(form.getPdid());
			//dto�����趨
			dto.setIgprd0110Form(form);
			//����Ϣ��Ϣ�����߼�����
			dto = ctlBL.searchProcessInfoDefAction(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			dto = ctlBL.searchBackURLAction(dto);
			//������Ϣ��Ϣ��������趨��VO��
			IGPRD01101VO vo = new IGPRD01101VO(dto.getProcessInfoDefList());
			vo.setProcessInfoDef(dto.getProcessInfoDef());
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01101VO>setVO(req, vo);
			log.debug("========����Ϣ��ѯ��������========");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
			//��ʷ�汾�µĲ鿴
			return mapping.findForward("VIEWHISTORY");
		}else{
			return mapping.findForward("DISP");
		}
	}
}
