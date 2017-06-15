/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.bl.IGKGMCONSTANTS;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0215Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02051VO;

/**
 * ����:֪ʶ���Action
 * �޸ļ�¼��
 */
public class IGKGM0222Action extends BaseAction {

	static Log log = LogFactory.getLog(IGKGM0222Action.class);

	/**
	 * ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		IGKGM0215Form form = (IGKGM0215Form)actionForm;
		//DTO����
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//DTO����
		IGKGM03DTO dto = new IGKGM03DTO();
        User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if ("DISP".equals(mapping.getParameter())){
			//֪ʶ��Ϣ�鿴
			log.debug("========֪ʶ��ϸ��Ϣ�鿴����ʼ========");
			
			dto.setKnid(form.getKnid());//֪ʶID
			
			dto.setPrid(form.getPrid());//��֪ʶ��ϸҳ�������ID
			
			dto.setSfid(form.getSfid());//��֪ʶ��ϸҳ��ķ��񹤵�ID
			
			dto.setKnversion(form.getKnversion());//֪ʶ�汾
			
			IGKGM02BL igkgm02BL = (IGKGM02BL) getBean("igkgm02BL");

			dto = igkgm02BL.searchKnowLedgeDetailActionbyPK(dto);
			
			dto = igkgm02BL.getKnowledgeAppImpact(dto);
			
			//������ʾ��Ϣ
			IGKGM02051VO vo = new IGKGM02051VO();
			vo.setIgkgm0215form(form);
			vo.setKnowledge(dto.getKnowledge());
			vo.setKnowledgeAppImpactList(dto.getKnowledgeAppImpactList());
			if(dto.getKnowledgeProcessList()!=null && dto.getKnowledgeProcessList().size()>0){
				vo.setKnowledgeProcessList(dto.getKnowledgeProcessList());				
			}
			super.<IGKGM02051VO> setVO(req.getSession(), vo);		
			log.debug("========֪ʶ��ϸ��Ϣ�鿴��������========");
		}else if ("ACTION".equals(mapping.getParameter())){
			log.debug("========֪ʶ���ͨ������ʼ========");
			dto.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
			dto.setKnid(form.getKnid());
			dto.setKnversion(form.getKnversion());
			ctlBL.updateOneKnowLedgeStatus(dto);
			addMessage(req, new ActionMessage("IGKGM0208.I001"));
			log.debug("========֪ʶ���ͨ���������========");	
			return mapping.findForward("DISP");
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
