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
import com.deliverik.infogovernor.risk.bl.IGRIS02BL;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0204Form;
import com.deliverik.infogovernor.risk.vo.IGRIS02011VO;

/**
 * ���ռ���������ѯ����Action����
 *
 */
public class IGRIS0204Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0204Action.class);

	/**
	 * ���ռ���������ѯ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGRIS0204Form form = (IGRIS0204Form)actionForm;
		
		//BLȡ��
		IGRIS02BL ctlBL = (IGRIS02BL) getBean("igris02BL");
		
		//DTO����
		IGRIS02DTO dto = new IGRIS02DTO();
		
		//User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		if( "DAYDISP".equals(mapping.getParameter())){
			//���Ͳ�ѯ���������ʾ����
			log.debug("========���ռ������ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���ռ������ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}else if( "POPDISP".equals(mapping.getParameter())){
			log.debug("========���ռ������ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���ռ������ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}else if( "POPSEARCH".equals(mapping.getParameter())||"POPSEARCH1".equals(mapping.getParameter())){
			//���Ͳ�ѯ����
			log.debug("========���ռ�����ձ���ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0204");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("DAYSEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGRIS0204Form) req.getSession().getAttribute("IGRIS0204Form");
				if ( form == null ) {
					form = new IGRIS0204Form();
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
					form = (IGRIS0204Form) req.getSession().getAttribute("IGRIS0204Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRIS0204");
			
			//DTO��������趨
			
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto.setIgRIS0204Form(form);
			
			//dto.setUser(user);
			
			//��Ϣ�����߼�����
			dto = ctlBL.searchRiskCheckResultReportByDayAction(dto);
			
			
			//req.setAttribute("pageNum", pDto.getFromCount());
			//req.setAttribute("pageCount", pDto.getPageDispCount());
	
			//��������Ϣ��������趨��VO��
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());

			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========���ռ�����ձ���ѯ��������========");
		}else if( "DAYSEARCH".equals(mapping.getParameter())||"DAYSEARCH1".equals(mapping.getParameter())){
			//���Ͳ�ѯ����
			log.debug("========���ռ�����ձ���ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0204");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("DAYSEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGRIS0204Form) req.getSession().getAttribute("IGRIS0204Form");
				if ( form == null ) {
					form = new IGRIS0204Form();
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
					form = (IGRIS0204Form) req.getSession().getAttribute("IGRIS0204Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRIS0204");
			
			//DTO��������趨
			
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto.setIgRIS0204Form(form);
			
			//dto.setUser(user);
			
			//��Ϣ�����߼�����
			dto = ctlBL.searchRiskCheckResultReportByDayAction(dto);
			
			
			//req.setAttribute("pageNum", pDto.getFromCount());
			//req.setAttribute("pageCount", pDto.getPageDispCount());
	
			//��������Ϣ��������趨��VO��
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());

			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========���ռ�����ձ���ѯ��������========");
		}else if ("POPREAD".equals(mapping.getParameter())){
			log.debug("========���ռ���ձ��鿴����ʼ========");
			dto.setIgRIS0204Form(form);
			dto = ctlBL.readRiskCheckResultReportAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResult(dto.getRiskCheckResult());
			vo.setAttachmentDataList(dto.getAttachmentList());
			super.<IGRIS02011VO>setVO(req, vo);
			log.debug("========���ռ���ձ��鿴��������========");
		}else if ("DAYREAD".equals(mapping.getParameter())){
			log.debug("========���ռ���ձ��鿴����ʼ========");
			dto.setIgRIS0204Form(form);
			dto = ctlBL.readRiskCheckResultReportAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResult(dto.getRiskCheckResult());
			vo.setAttachmentDataList(dto.getAttachmentList());
			super.<IGRIS02011VO>setVO(req, vo);
			log.debug("========���ռ���ձ��鿴��������========");
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
