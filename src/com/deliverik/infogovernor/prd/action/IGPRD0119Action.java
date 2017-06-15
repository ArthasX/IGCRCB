/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0119Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01101VO;

/**
 * ����Ϣ��ѯAction����
 *
 * @author liupeng@deliverik.com
 */
public class IGPRD0119Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0119Action.class);

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
		IGPRD0119Form form = (IGPRD0119Form)actionForm;
		
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
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGPRD0117");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGPRD0119Form) req.getSession().getAttribute("IGPRD0119Form");
				if ( form == null ) {
					form = new IGPRD0119Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGPRD0119Form) req.getSession().getAttribute("IGPRD0119Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGPRD0117");
			
			if(form == null){
				form = new IGPRD0119Form();
			}
			dto.setProcessInfoDefGeneralSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//dto.setPdid(form.getPdid());
			//����Ϣ��Ϣ�����߼�����
			dto = ctlBL.searchProcessInfoDefGeneralActionFor0119(dto);
			
			//dto = ctlBL.isProcessDefinitionInUse(dto);
			//������Ϣ��Ϣ��������趨��VO��
			IGPRD01101VO vo = new IGPRD01101VO();
			vo.setProcessInfoDefGeneralList(dto.getProcessInfoDefGeneralList());
			//req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01101VO>setVO(req, vo);
			
			log.debug("========����Ϣ��ѯ��������========");
			if("ok".equals(req.getParameter("gtbl"))){
				req.setAttribute("pdid", req.getParameter("pdid"));
				return mapping.findForward("GTBL");
			}
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		
		return mapping.findForward("DISP");
	}
}
