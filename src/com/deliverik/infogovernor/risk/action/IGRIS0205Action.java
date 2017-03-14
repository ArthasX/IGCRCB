package com.deliverik.infogovernor.risk.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.risk.bl.IGRIS02BL;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0204Form;
import com.deliverik.infogovernor.risk.form.IGRIS0205Form;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckTB;
import com.deliverik.infogovernor.risk.vo.IGRIS02011VO;
import com.deliverik.infogovernor.risk.vo.IGRIS02012VO;
import com.deliverik.infogovernor.risk.vo.IGRIS02013VO;

/**
 * ���ռ���������ѯ����Action����
 *
 */
public class IGRIS0205Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0205Action.class);

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
		IGRIS0205Form form = (IGRIS0205Form)actionForm;
		
		//BLȡ��
		IGRIS02BL ctlBL = (IGRIS02BL) getBean("igris02BL");
		
		//DTO����
		IGRIS02DTO dto = new IGRIS02DTO();
		
		//��ȡ�����ɫ�б�
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
		dto.setUser(user);
		
		String forward = req.getParameter("return");
		if( "LASTDISP".equals(mapping.getParameter())){
			//���Ͳ�ѯ���������ʾ����
			log.debug("========���һ�η��ռ������ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���һ�η��ռ������ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}else if( "SUPERVISE_DISP".equals(mapping.getParameter())){
			log.debug("========��鹤���ල��ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��鹤���ල��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}else if( "POPDISP".equals(mapping.getParameter())){
			log.debug("========���һ�η��ռ������ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���һ�η��ռ������ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}else if( "POPSEARCH".equals(mapping.getParameter())||"POPSEARCH1".equals(mapping.getParameter())){
			//���Ͳ�ѯ����
			log.debug("========���һ�η��ռ������ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0205");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("LASTSEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGRIS0205Form) req.getSession().getAttribute("IGRIS0205Form");
				if ( form == null ) {
					form = new IGRIS0205Form();
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
					form = (IGRIS0205Form) req.getSession().getAttribute("IGRIS0205Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRIS0205");
			
			//DTO��������趨
			
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto.setIgRIS0205Form(form);
			
			//dto.setUser(user);
			
			//��Ϣ�����߼�����
			dto = ctlBL.searchLastRiskCheckResultReportAction(dto);
			
			
			//req.setAttribute("pageNum", pDto.getFromCount());
			//req.setAttribute("pageCount", pDto.getPageDispCount());
	
			//��������Ϣ��������趨��VO��
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());

			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========���һ�η��ռ������ѯ��������========");
		}else if( "LASTSEARCH".equals(mapping.getParameter())||"LASTSEARCH1".equals(mapping.getParameter())){
			//���Ͳ�ѯ����
			log.debug("========���һ�η��ռ������ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0205");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("LASTSEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGRIS0205Form) req.getSession().getAttribute("IGRIS0205Form");
				if ( form == null ) {
					form = new IGRIS0205Form();
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
					form = (IGRIS0205Form) req.getSession().getAttribute("IGRIS0205Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRIS0205");
			
			//DTO��������趨
			
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			// �����Dashboardҳ����,��Ҫ��ѯδ��鹤��paicode=V
			if("V".equals(req.getParameter("paicode"))){
				// 2Ϊδ����ѯ��ʶ
				form.setRcrstatic("2");
			}
			
			dto.setIgRIS0205Form(form);
			
			//dto.setUser(user);
			
			//��Ϣ�����߼�����
			dto = ctlBL.searchCheckWorkResulReportAction(dto);
			
			
			//req.setAttribute("pageNum", pDto.getFromCount());
			//req.setAttribute("pageCount", pDto.getPageDispCount());
	
			//��������Ϣ��������趨��VO��
			/*IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());

			super.<IGRIS02011VO>setVO(req, vo);*/
			//��鹤��ִ�У��ƻ�����ʱ�䲻�ǲ��Խ���ʱ�䣬��Ӧ���Ǽ�鹤������ʱ���빤��ִ������֮��
			IGRIS02013VO vo = new IGRIS02013VO();
			List<IGRIS02012VO> voList = new ArrayList<IGRIS02012VO>();
			IGRIS02012VO igris02012vo = null;
			if(dto.getCheckWorkResultInfos()!=null){
				for(CheckWorkResultInfo riskCheckResult:dto.getCheckWorkResultInfos()){
					igris02012vo = new IGRIS02012VO();
					igris02012vo.setCheckWorkResultInfo(riskCheckResult);
					
					voList.add(igris02012vo);
				}
			}
			vo.setIgris02012voList(voList);
			super.<IGRIS02013VO>setVO(req, vo);
			
			log.debug("========���һ�η��ռ������ѯ��������========");
		}else if( "SUPERVISE".equals(mapping.getParameter())||"SUPERVISE1".equals(mapping.getParameter())){
			//���Ͳ�ѯ����
			log.debug("========��鹤���ල�����ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0205");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SUPERVISE1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGRIS0205Form) req.getSession().getAttribute("IGRIS0205Form");
				if ( form == null ) {
					form = new IGRIS0205Form();
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
					form = (IGRIS0205Form) req.getSession().getAttribute("IGRIS0205Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRIS0205");
			
			//DTO��������趨
			
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
//			// �����Dashboardҳ����,��Ҫ��ѯδ��鹤��paicode=V
//			if("V".equals(req.getParameter("paicode"))){
//				// 2Ϊδ����ѯ��ʶ
//				form.setRcrstatic("2");
//			}
//			
			dto.setIgRIS0205Form(form);
			
			//dto.setUser(user);
			
			//��Ϣ�����߼�����
//			dto = ctlBL.searchSuperviseRiskCheckResultReportAction(dto);
			dto = ctlBL.searchCheckWorkResulReportAction(dto);
			
			//req.setAttribute("pageNum", pDto.getFromCount());
			//req.setAttribute("pageCount", pDto.getPageDispCount());
			
			/*//��������Ϣ��������趨��VO��
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());
			
			super.<IGRIS02011VO>setVO(req, vo);*/
			
			IGRIS02013VO vo = new IGRIS02013VO();
			List<IGRIS02012VO> voList = new ArrayList<IGRIS02012VO>();
			IGRIS02012VO igris02012vo = null;
			if(dto.getCheckWorkResultInfos()!=null){
				for(CheckWorkResultInfo riskCheckResult:dto.getCheckWorkResultInfos()){
					igris02012vo = new IGRIS02012VO();
					igris02012vo.setCheckWorkResultInfo(riskCheckResult);
					
					voList.add(igris02012vo);
				}
			}
			vo.setIgris02012voList(voList);
			super.<IGRIS02013VO>setVO(req, vo);
			
			log.debug("========��鹤���ල�����ѯ��������========");
		}else if ("LASTREAD".equals(mapping.getParameter())){
			log.debug("========���һ�η��ռ�����鿴����ʼ========");
			
			IGRIS0204Form form1 = new IGRIS0204Form();
			form1.setRcrid(form.getRcrid());
			dto.setIgRIS0204Form(form1);
			dto = ctlBL.readRiskCheckResultReportAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResult(dto.getRiskCheckResult());
			vo.setAttachmentDataList(dto.getAttachmentList());
			//���ر�ʶ��1�����ؼ�鹤���ල��ѯҳ
			vo.setMode(form.getMode());
			super.<IGRIS02011VO>setVO(req, vo);
			log.debug("========���һ�η��ռ�����鿴��������========");
			
		}else if ("POPREAD".equals(mapping.getParameter())){
			log.debug("========���һ�η��ռ�����鿴����ʼ========");
			IGRIS0204Form form1 = new IGRIS0204Form();
			form1.setRcrid(form.getRcrid());
			dto.setIgRIS0204Form(form1);
			dto = ctlBL.readRiskCheckResultReportAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResult(dto.getRiskCheckResult());
			vo.setAttachmentDataList(dto.getAttachmentList());
			super.<IGRIS02011VO>setVO(req, vo);
			log.debug("========���һ�η��ռ�����鿴��������========");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		if(StringUtils.isNotEmpty(forward)){
			return mapping.findForward("READ");
		}else{
			return mapping.findForward("DISP");
		}
	}
}
