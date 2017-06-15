package com.deliverik.infogovernor.risk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.bl.IGRIS02BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0201Form;
import com.deliverik.infogovernor.risk.form.IGRIS0202Form;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.vo.IGRIS02011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0402Form;

/**
 * ���ռ���ѯ����Action����
 *
 */
public class IGRIS0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0201Action.class);

	/**
	 * ���ռ���ѯ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//BLȡ��
		IGRIS02BL ctlBL = (IGRIS02BL) getBean("igris02BL");
		
		//DTO����
		IGRIS02DTO dto = new IGRIS02DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		
		String flag = "0";
		
		if( "DISP".equals(mapping.getParameter())){
			//���Ͳ�ѯ���������ʾ����
			log.debug("========���ռ���ѯ���������ʾ����ʼ========");
			
			//FORMȡ��
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//��ȡBL�ӿ�ʵ��
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//ʵ����DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//��ɫ��Ȩ��ѯ
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//����BL��ѯ
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// �����Թ����Ȩ�޿��ƣ�ֻ����Ϣ��ȫ������������
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���ռ���ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//���Ͳ�ѯ����
			log.debug("========���ռ���ѯ����ʼ========");

			//FORMȡ��
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//��ȡBL�ӿ�ʵ��
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//ʵ����DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//��ɫ��Ȩ��ѯ
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//����BL��ѯ
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// �����Թ����Ȩ�޿��ƣ�ֻ����Ϣ��ȫ������������
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0201");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if(StringUtils.isEmpty(form.getRcstatus_q())){
				form.setRcstatus_q("0");//����״̬
			}
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGRIS0201Form) req.getSession().getAttribute("IGRIS0201Form");
				if ( form == null ) {
					form = new IGRIS0201Form();
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
					form = (IGRIS0201Form) req.getSession().getAttribute("IGRIS0201Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRIS0201");
			
			//DTO��������趨
			dto.setIgRIS0201Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//������Ϣ�����߼�����
			dto = ctlBL.searchRiskCheckAction(dto);
				
			//��������Ϣ��������趨��VO��
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setCheckStrategyList(dto.getCheckStrategyList());

			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========���ռ���ѯ��������========");
		}else if ("CHANGE".equals(mapping.getParameter())){
			//�޸�״̬1���� 0ͣ��
			log.debug("========���ռ��״̬�仯����ʼ========");

			//FORMȡ��
			IGRIS0202Form form = (IGRIS0202Form)actionForm;

			dto.setIgRIS0202Form(form);
//			dto = ctlBL.changeRiskCheckStatusAction(dto);
			dto = ctlBL.changeCheckStrategyStatusOnlyAction(dto);
			
			log.debug("========���ռ��״̬�仯��������========");
		}else if ("READ".equals(mapping.getParameter())){
			log.debug("========���ռ��鿴����ʼ========");

			//FORMȡ��
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//��ȡBL�ӿ�ʵ��
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//ʵ����DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//��ɫ��Ȩ��ѯ
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//����BL��ѯ
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// �����Թ����Ȩ�޿��ƣ�ֻ����Ϣ��ȫ������������
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			dto.setIgRIS0201Form(form);
			dto = ctlBL.readRiskCheckAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheck(dto.getRiskCheck());
			vo.setAttachmentDataList(dto.getAttachmentList());
			vo.setCronInfo(dto.getCronInfo());
			super.<IGRIS02011VO>setVO(req, vo);
			flag = req.getParameter("flag");
			
			if(flag!=null && "1".equals(flag)){
				return mapping.findForward("DISP2");
			}

			log.debug("========���ռ��鿴��������========");
		}else if( "RESULT".equals(mapping.getParameter())||"RESULT1".equals(mapping.getParameter())){
			//���Ͳ�ѯ����
			log.debug("========���ռ���ѯ����ʼ========");

			//FORMȡ��
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//��ȡBL�ӿ�ʵ��
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//ʵ����DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//��ɫ��Ȩ��ѯ
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//����BL��ѯ
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// �����Թ����Ȩ�޿��ƣ�ֻ����Ϣ��ȫ������������
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0201");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("RESULT1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGRIS0201Form) req.getSession().getAttribute("IGRIS0201Form");
				if ( form == null ) {
					form = new IGRIS0201Form();
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
					form = (IGRIS0201Form) req.getSession().getAttribute("IGRIS0201Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRIS0201");
			
			//DTO��������趨
			dto.setIgRIS0201Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//������Ϣ�����߼�����
			dto = ctlBL.searchRiskCheckAction(dto);
			
			
			//req.setAttribute("pageNum", pDto.getFromCount());
			//req.setAttribute("pageCount", pDto.getPageDispCount());
	
			//��������Ϣ��������趨��VO��
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckDataList(dto.getRiskCheckDataList());

			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========���ռ���ѯ��������========");
		}else if ("RESULTREAD".equals(mapping.getParameter())){
			log.debug("========���ռ��鿴����ʼ========");

			//FORMȡ��
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//��ȡBL�ӿ�ʵ��
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//ʵ����DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//��ɫ��Ȩ��ѯ
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//����BL��ѯ
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// �����Թ����Ȩ�޿��ƣ�ֻ����Ϣ��ȫ������������
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			dto.setIgRIS0201Form(form);
			dto = ctlBL.readRiskCheckAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheck(dto.getRiskCheck());
			vo.setAttachmentDataList(dto.getAttachmentList());
			vo.setCronInfo(dto.getCronInfo());
			super.<IGRIS02011VO>setVO(req, vo);
			log.debug("========���ռ��鿴��������========");
		}else if ( "RELEVANCEDISP".equals(mapping.getParameter())){
			log.debug("========����������ʼ������ʼ========");

			//FORMȡ��
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//��ȡBL�ӿ�ʵ��
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//ʵ����DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//��ɫ��Ȩ��ѯ
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//����BL��ѯ
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// �����Թ����Ȩ�޿��ƣ�ֻ����Ϣ��ȫ������������
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			req.setAttribute("rcid", form.getRcid());
			//��ȡ�汾���������б�
			//BLȡ��
			IGRIS01BL ctlBL1 = (IGRIS01BL) getBean("igRIS01BL");
			//DTO����
			IGRIS01DTO dto1 = new IGRIS01DTO();
			dto1 = ctlBL1.searchRiskAuditLabelInUse(dto1);
			req.setAttribute("labelList", dto1.getLabelList());
			
			log.debug("========����������ʼ����������========");
		} else if ( "RELEVANCE".equals(mapping.getParameter())){
			log.debug("========����������ѯ����ʼ========");

			//FORMȡ��
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//��ȡBL�ӿ�ʵ��
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//ʵ����DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//��ɫ��Ȩ��ѯ
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//����BL��ѯ
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// �����Թ����Ȩ�޿��ƣ�ֻ����Ϣ��ȫ������������
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			//BLȡ��
			IGRIS01BL ctlBL1 = (IGRIS01BL) getBean("igRIS01BL");
			//DTO����
			IGRIS01DTO dto1 = new IGRIS01DTO();
			dto1 = ctlBL1.searchRiskAuditLabelInUse(dto1);
			req.setAttribute("labelList", dto1.getLabelList());
			
			req.setAttribute("rcid", form.getRcid());
			dto.setIgRIS0201Form(form);
			
			dto = ctlBL.searchRiskAuditDefAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			
			vo.setRadMaxLevel(dto.getRadMaxLevel());
			vo.setRadMaxLevelList(dto.getRadMaxLevelList());
			vo.setRiskAuditDefList(dto.getRiskAuditDefList());
			
			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========����������ѯ��������========");
		} else if("POINT".equals(mapping.getParameter())){
			//���Ͳ�ѯ����
			log.debug("========���ռ���ѯ����ʼ========");

			//FORMȡ��
			IGRIS0201Form form = (IGRIS0201Form)actionForm;
			
			if(form.getCsid()!=null && !(form.getCsid().equals(""))){
				dto.setCsid(Integer.parseInt(form.getCsid()));				
			}
			//��ȡBL�ӿ�ʵ��
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//ʵ����DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//��ɫ��Ȩ��ѯ
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//����BL��ѯ
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// �����Թ����Ȩ�޿��ƣ�ֻ����Ϣ��ȫ������������
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0201");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if(StringUtils.isEmpty(form.getRcstatus_q())){
				form.setRcstatus_q("0");//����״̬
			}
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGRIS0201Form) req.getSession().getAttribute("IGRIS0201Form");
				if ( form == null ) {
					form = new IGRIS0201Form();
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
					//form = (IGRIS0201Form) req.getSession().getAttribute("IGRIS0201Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRIS0201");
			
			//DTO��������趨
			dto.setIgRIS0201Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//������Ϣ�����߼�����
			dto = ctlBL.selPoint(dto);
				
			//��������Ϣ��������趨��VO��
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckDataList(dto.getRiskCheckDataList());

			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========���ռ���ѯ��������========");
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
