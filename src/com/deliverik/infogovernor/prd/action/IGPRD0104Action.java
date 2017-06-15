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
import com.deliverik.infogovernor.prd.form.IGPRD0104Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01041VO;

/**
 * ����״̬��ѯAction����
 *
 * @author liupeng@deliverik.com
 */
public class IGPRD0104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0104Action.class);

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
		IGPRD0104Form form = (IGPRD0104Form)actionForm;
		
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//��ѯ���������ʾ����
			log.debug("========����״̬��ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����״̬��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if ( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ѯ����
			log.debug("========����״̬��ѯ����ʼ========");
			//��ҳ��DTOȡ��
			//getPaginDTO(req,"IGPRD0101");
			
			//PagingDTO pDto;
			
//			pDto = (PagingDTO)req.getAttribute("PagingDTO");
//			if ("SEARCH1".equals(mapping.getParameter())){
//				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
//				form = (IGPRD0104Form) req.getSession().getAttribute("IGPRD0104Form");
//				if ( form == null ) {
//					form = new IGPRD0104Form();
//				}else {
//					if (req.getParameter("PAGING") == null) {
//						pDto.setFromCount(form.getFromCount());
//					} else {
//						form.setFromCount(pDto.getFromCount());
//					}
//				}
//			} else {
//				if (req.getParameter("PAGING") == null) {
//					pDto.setFromCount(0);
//					form = (IGPRD0104Form) req.getSession().getAttribute("IGPRD0104Form");
//					if (form !=null) {
//						form.setFromCount(0);
//					}
//				}
//			}
			
			//��ѯ��¼������ȡ��
			//int maxCnt = getMaxDataCount("IGPRD0104");
			
			//dto.setProcessStatusDefSearchCond(form);
			
			if (req.getAttribute("psdid") != null) {
				form.setPsdid((String)req.getAttribute("psdid"));
			}
			
			dto.setIgPRD0104Form(form);
			
			//dto.setMaxSearchCount(maxCnt);
			
			//dto.setPagingDto(pDto);
			
			//ͨ��ģ��ID
			//form.setPtid(IGPRDCONSTANTS.PROCESS_DEFINITION_COMMON_TEMPLATE_ID);
			
			//��Ϣ�����߼�����
			dto.setPdid(form.getPdid());
			dto.setPsdid(form.getPpsdid());
			dto = ctlBL.searchProcessStatusDefAction(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			dto = ctlBL.initVmlAction(dto);
			//����Ϣ��������趨��VO��
			IGPRD01041VO vo = new IGPRD01041VO();
			vo.setProcessStatusDefList(dto.getProcessStatusDefList());
			vo.setImgxml(dto.getImgxml());
			req.setAttribute("pdid", form.getPdid());
			req.setAttribute("ppsdid", form.getPpsdid());
			//����ʱ���ϼ�ID���ϼ�ID
			if (dto.getProcessStatusDef() != null && StringUtils.isNotEmpty(dto.getProcessStatusDef().getPpsdid())) {
				req.setAttribute("backUrl", "IGPRD0104_Back.do?pdid="+form.getPdid()+"&ppsdid="+dto.getProcessStatusDef().getPpsdid());
			} else {
				if(StringUtils.isEmpty(form.getPpsdid())) {
					req.setAttribute("backUrl", "IGPRD0101_Back.do");
				} else {
					req.setAttribute("backUrl", "IGPRD0104_Back.do?pdid="+form.getPdid());
				}
			}
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01041VO>setVO(req, vo);
			
			log.debug("========����״̬��ѯ��������========");
		} else if ( "DEL".equals(mapping.getParameter())){
			log.debug("========����״̬ɾ������ʼ========");
			String psdid = req.getParameter("psdid");
			String ppsdid = req.getParameter("ppsdid");
			if(StringUtils.isNotEmpty(psdid)) {
				form.setPsdid(psdid);
			}
			dto.setIgPRD0104Form(form);
			
			dto = ctlBL.deleteProcessStatusDefAction(dto);
			
			req.setAttribute("psdid", ppsdid);
			
			log.debug("========����״̬ɾ����������========");
		} else if ( "SAVEXML".equals(mapping.getParameter())){
			log.debug("========����ͼ���洦��ʼ========");
			String pdid = req.getParameter("pdid");
			String ppsdid = req.getParameter("ppsdid");
			if(StringUtils.isNotEmpty(pdid)) {
				form.setPdid(pdid);
			}
			if(StringUtils.isNotEmpty(ppsdid)) {
				form.setPsdid(ppsdid);
			}
			dto.setIgPRD0104Form(form);
			
			dto = ctlBL.savePdXmlAction(dto);
			
			log.debug("========����ͼ���洦������========");
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
		}
		return mapping.findForward("DISP");
	}
}
