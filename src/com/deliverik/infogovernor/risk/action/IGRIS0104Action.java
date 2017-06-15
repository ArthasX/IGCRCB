/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0104Form;
import com.deliverik.infogovernor.risk.vo.IGRIS01051VO;

/**
 * ������ѯAction����
 *
 */
public class IGRIS0104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0104Action.class);

	/**
	 * �ɹ�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ʵ����FORM
		IGRIS0104Form form = (IGRIS0104Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		//ʵ����DTO
		IGRIS01DTO dto = new IGRIS01DTO();
		//��ȡ�汾�������б�
		dto = ctlBL.searchRiskAuditLabelInUse(dto);
		req.setAttribute("labelList", dto.getLabelList());
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========���������������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���������������ʾ��������========");
			return mapping.findForward("DISP");
		}
		if( "BUTTON".equals(mapping.getParameter())){
			log.debug("========���������������ʾ����ʼ========");
			if (req.getParameter("btn_next")!=null) {
				//������ѯ��һ��������ת
				log.debug("========�������Ϣ���========");
				return mapping.findForward("NEXT");
			}
			if (req.getParameter("btn_all")!=null) {
				//������ѯȫ���¼�������ת
				log.debug("========������б�========");
				return mapping.findForward("ALL");
			}	
			log.debug("========���������������ʾ��������========");
			return mapping.findForward(null);
		} 
		if( "NEXT".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){	//�������һ����ѯ
			log.debug("========������ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(req,"IGRIS0104");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGRIS0104Form) req.getSession().getAttribute("IGRIS0104Form");
				if ( form== null){
					form = new IGRIS0104Form();
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
					form = (IGRIS0104Form) req.getSession().getAttribute("IGRIS0104Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGRIS0104");
			
			dto.setIgRIS0104Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchRiskAuditDefNextAction(dto);
			//����VO
			IGRIS01051VO vo = new IGRIS01051VO(dto.getRiskAuditDefList());
			super.<IGRIS01051VO>setVO(req, vo);
			log.debug("========������ѯ��������========");
		}
		if( "ALL".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){	//�����ȫ���¼���ѯ
			log.debug("========������ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(req,"IGRIS0104");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGRIS0104Form) req.getSession().getAttribute("IGRIS0104Form");
				if ( form== null){
					form = new IGRIS0104Form();
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
					form = (IGRIS0104Form) req.getSession().getAttribute("IGRIS0104Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGRIS0104");
			
			dto.setIgRIS0104Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchRiskAuditDefAllAction(dto);
			//����VO
			IGRIS01051VO vo = new IGRIS01051VO(dto.getRiskAuditDefList());
			super.<IGRIS01051VO>setVO(req, vo);
			log.debug("========������ѯ��������========");
		}
		if("TREE".equals(mapping.getParameter())){
			dto.setIgRIS0104Form(form);
			dto = ctlBL.searchAuditTreeAction(dto);
			//����VO
			IGRIS01051VO vo = new IGRIS01051VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGRIS01051VO>setVO(req, vo);
		}
		if ("CHANGE".equals(mapping.getParameter())){
			log.debug("========�����ͣ��/���ô���ʼ========");
			//DTO��������趨
			dto.setIgRIS0104Form(form);
			
			ctlBL.changeRiskAuditDefAction(dto);
			
			log.debug("========�����ͣ��/���ô�������========");
	}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
