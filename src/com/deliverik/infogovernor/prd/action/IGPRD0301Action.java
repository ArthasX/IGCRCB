/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prd.bl.IGPRD03BL;
import com.deliverik.infogovernor.prd.dto.IGPRD03DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0301Form;
import com.deliverik.infogovernor.prd.vo.IGPRD03011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����鶨�������ʾAction
 * </p>
 * 
 * @version 1.0
 */
public class IGPRD0301Action extends BaseAction{
	static Log log = LogFactory.getLog(IGPRD0301Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse response) throws Exception {
		//BLȡ��
		IGPRD03BL ctlBL = (IGPRD03BL) getBean("igprd03BL");
		//ʵ����dto
		IGPRD03DTO dto = new IGPRD03DTO();
		//formȡ��
		IGPRD0301Form form = (IGPRD0301Form) actionForm;
		//dto�����趨
		//ҳ���ʼ������
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//���̶����ѯ����
			log.debug("========�����鶨���ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGPRD0301");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGPRD0301Form) req.getSession().getAttribute("IGPRD0301Form");
				if ( form == null ) {
					form = new IGPRD0301Form();
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
//					form = (IGPRD0301Form) req.getSession().getAttribute("IGPRD0301Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGPRD0301");
			
			
			dto.setIgprd0301Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			

			//���̶�����Ϣ�����߼�����
			dto = ctlBL.searchProcessGroupDefinition(dto);
			
			//�����̶�����Ϣ��������趨��VO��
			IGPRD03011VO vo = new IGPRD03011VO(dto.getProcessGroupDefinitionList());
			
			super.<IGPRD03011VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========�����鶨���ѯ��������========");
		}
		if("CHANGE".equals(mapping.getParameter())){
			log.debug("================��ʼ�ı�����״̬================");
			dto.setIgprd0301Form(form);
			
			if (isTokenValid(req, true)){
				//������״̬�޸�
				ctlBL.changeStatus(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("===============�ı�����״̬����==========");
		}
		if("UPGRADE".equals(mapping.getParameter())){
			log.debug("==========���������濪ʼ============");
			
			dto.setIgprd0301Form(form);
			
			
			log.debug("==========�������������============");
		}
		if("LANUCH".equals(mapping.getParameter())){
			log.debug("==========�����鷢��ʼ============");
			
			dto.setIgprd0301Form(form);

			dto.setUser((User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER));
			if (isTokenValid(req, true)){
				//�����鷢��
				ctlBL.LaunchAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("==========�����鷢�����============");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		
		return mapping.findForward("DISP");
	}

}