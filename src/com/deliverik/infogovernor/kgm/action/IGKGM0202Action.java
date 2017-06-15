package com.deliverik.infogovernor.kgm.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.bl.IGKGMCONSTANTS;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0202Form;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCondImpl;
import com.deliverik.infogovernor.kgm.vo.IGKGM02011VO;

public class IGKGM0202Action extends BaseAction{

	static Log log = LogFactory.getLog(IGKGM0201Action.class);
	
	/**
	 * ֪ʶ��ѯ
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
		IGKGM0202Form form = (IGKGM0202Form)actionForm;
		
		//BLȡ��
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//DTO����
		IGKGM03DTO dto = new IGKGM03DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);

		if("DISP".equals(mapping.getParameter())){
			//֪ʶ��ѯ��������ʾ����
			log.debug("========֪ʶ��ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========֪ʶ��ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
	    }else if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
	    	

			//֪ʶ��ѯ����
			log.debug("========֪ʶ��ѯ����ʼ========");
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGKGM0202");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGKGM0202Form) req.getSession().getAttribute("IGKGM0202Form");
				if ( form == null ) {
					form = new IGKGM0202Form();
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
					form = (IGKGM0202Form) req.getSession().getAttribute("IGKGM0202Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGKGM0202");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);

			//֪ʶ��ѯ����
			KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
			cond.setKnproffer(user.getUserid());
			cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_REJECT + "," + IGKGMCONSTANTS.KNOWLEDGE_INIT+ "," + IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);
            dto.setKnowledgeSearchCond(cond);
            
			//DTO��������趨
			dto.setIgkgm0202Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//֪ʶ��Ϣ�����߼�����
			dto = ctlBL.searchMyKnowLedgeAction(dto);
			
			//��֪ʶ������Ϣ��������趨��VO��
			IGKGM02011VO vo = new IGKGM02011VO();
			vo.setKnowledgeList(dto.getKnowledgeList());
			super.<IGKGM02011VO>setVO(req, vo);
			
			log.debug("========֪ʶ��ѯ��������========");
			
	    }  else if( "DELETE".equals(mapping.getParameter())){
			log.debug("========֪ʶɾ������ʼ========");
			dto.setIgkgm0202Form(form);
			ctlBL.deleteKnowLedgeAction(dto);
			log.debug("========֪ʶɾ���������========");
			return mapping.findForward("DELETE");
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
