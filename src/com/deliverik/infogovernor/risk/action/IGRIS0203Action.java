package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.vo.IGCRC04021VO;
import com.deliverik.infogovernor.crc.vo.IGCRC04031VO;
import com.deliverik.infogovernor.risk.bl.IGRIS02BL;
import com.deliverik.infogovernor.risk.bl.IGRISCONSTANTS;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0201Form;
import com.deliverik.infogovernor.risk.form.IGRIS0203Form;
import com.deliverik.infogovernor.risk.vo.IGRIS02011VO;

/**
 * ���ռ������ѯ����Action����
 *
 */
public class IGRIS0203Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0203Action.class);

	/**
	 * ���ռ������ѯ����
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
		IGRIS0203Form form = (IGRIS0203Form)actionForm;
		
		//BLȡ��
		IGRIS02BL ctlBL = (IGRIS02BL) getBean("igris02BL");
		
		//DTO����
		IGRIS02DTO dto = new IGRIS02DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		if( "DISP".equals(mapping.getParameter())){
			//���Ͳ�ѯ���������ʾ����
			log.debug("========���ռ������ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���ռ������ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//���Ͳ�ѯ����
			log.debug("========���ռ������ѯ����ʼ========");
			
			// ���
			if(StringUtils.isNotEmpty(form.getRcrresult())){
				form.setRcrresult(null);
			}
			// ˵��
			if(StringUtils.isNotEmpty(form.getRcrcomment())){
				form.setRcrcomment(null);
			}
			dto.setIgRIS0203Form(form);
			
			dto.setUser(user);
			
			//��Ϣ�����߼�����
			dto = ctlBL.searchRiskCheckResultAction(dto);
			
			//��������Ϣ��������趨��VO��
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());

			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========���ռ������ѯ��������========");
		}else if ("READ".equals(mapping.getParameter())){
			log.debug("========���ռ��鿴����ʼ========");
			IGRIS0201Form form1 = new IGRIS0201Form();
			form1.setRcid(form.getRcid());
			dto.setIgRIS0201Form(form1);
			dto = ctlBL.readRiskCheckAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheck(dto.getRiskCheck());
			vo.setAttachmentDataList(dto.getAttachmentList());
			vo.setCronInfo(dto.getCronInfo());
			super.<IGRIS02011VO>setVO(req, vo);
			log.debug("========���ռ��鿴��������========");
		}else if ("INSERT".equals(mapping.getParameter())){
			log.debug("========���ռ�������洦��ʼ========");
			
			dto.setIgRIS0203Form(form);
			dto.setUser(user);
			dto = ctlBL.insertRiskCheckResultAction(dto);
			
			if(IGRISCONSTANTS.RISKCHECKRESULT_SUBMIT_ERROR.equals(dto.getGoToError())){
				//ҳ���ύ�ļ�¼�Ѿ��������û��ύ��
				return mapping.findForward("ERROR");//���ش�����ʾ��Ϣҳ
			}		
			
			req.setAttribute("cwrid", form.getCwrid());
			log.debug("========���ռ�������洦������========");
		}else if("BATCH".equals(mapping.getParameter())){
			
			log.debug("========��鹤��ָ������������ʼ========");
			dto.setIgRIS0203Form(form);
			dto.setUser(user);
			//if(isTokenValid(req,true)){
				dto = ctlBL.batchFlowAction(dto);
			//}else{
			//	addMessage(req, new ActionMessage("IGCO00000.E007"));
			//	return mapping.findForward("/error1");
			//}
			
			log.debug("========��鹤��ָ����������������========");
			return mapping.findForward("ASSIGN");
		}else if("BATCH_DISP".equals(mapping.getParameter())){
			log.debug("===========��鹤��ָ������ҳ���ʼ��������ʼ===============");
			dto.setIgRIS0203Form(form);
			dto.setUser(user);
			dto = ctlBL.initIGRIS0402Action(dto);
			
			//ʵ����vo
			IGCRC04031VO vo = new IGCRC04031VO();
			vo.setAssignInfo(dto.getAssignInfo());
			vo.setPrids(dto.getIgRIS0203Form().getPrids());
			req.getSession().setAttribute("prids", dto.getIgRIS0203Form().getPrids());
			req.setAttribute("prids", dto.getIgRIS0203Form().getPrids());
			super.<IGCRC04031VO>setVO(req, vo);
			saveToken(req);
			log.debug("===========��鹤��ָ����������ҳ���ʼ����������===============");
		}else if("ASSIGN".equals(mapping.getParameter())){
			dto.setIgRIS0203Form(form);
			dto.setUser(user);
			log.debug("=============��鹤��ָ���������ɲ�����ʼ===============");
			if (isTokenValid(req, true)){
				dto = ctlBL.assignAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("=============��鹤��ָ���������ɲ�������===============");
			
			
			
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
