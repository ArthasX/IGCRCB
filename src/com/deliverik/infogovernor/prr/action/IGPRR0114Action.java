/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR02BL;
import com.deliverik.infogovernor.prr.dto.IGPRR02DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0114Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01141VO;

/**
 * ����:��ӳ�����action 
 * ������������ӳ�����
 * �����ˣ�����͢
 * ������¼�� 2013-02-25
 * �޸ļ�¼��
 */
public class IGPRR0114Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRR0114Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGPRR0114Form form = (IGPRR0114Form)actionForm;		
		//BLȡ��
		IGPRR02BL ctlBL = (IGPRR02BL) getBean("igPRR02BL");	
		String forward = "DISP";
		//DTO����
		IGPRR02DTO dto = new IGPRR02DTO();	
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if("SEARCH1".equals(mapping.getParameter())){
			log.debug("========�����˲�ѯҳ���ʼ����ʼ========");
			forward = "SEARCH1";
			log.debug("========�����˲�ѯҳ���ʼ�������========");
			
		}
		if("DISP".equals(mapping.getParameter())){
			log.debug("========��ѯ������ҳ���ʼ����ʼ========");
			dto.setIgprr0114form(form);
			dto = ctlBL.getPeopleUnderRoleAction(dto);
			IGPRR01141VO vo = new IGPRR01141VO();
			vo.setMap_cru(dto.getMap_cru());
			super.<IGPRR01141VO>setVO(request, vo);
			log.debug("========��ѯ������ҳ���ʼ�������========");
		}
		
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========�����˲�ѯҳ�洦��ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGPRR0114");
			PagingDTO pDto;			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGPRR0114");			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);			
			dto.setPagingDto(pDto);
			dto.setIgprr0114form(form);
			dto = ctlBL.getCopyReadInfoByCondAction(dto);
			IGPRR01141VO vo = new IGPRR01141VO();
			vo.setList(dto.getList());
			super.<IGPRR01141VO>setVO(request, vo);
			forward = "SEARCH";
			log.debug("========�����˲�ѯҳ�洦�����========");
		}
		if("SAVE".equals(mapping.getParameter())){
			dto.setIgprr0114form(form);
			dto = ctlBL.saveCopyReadInfoByPkAction(dto);
			request.setAttribute("prserialnum",dto.getIg500().getPrserialnum() );// ������
			request.setAttribute("prid",dto.getIg500().getPrid());
			request.setAttribute("pts",dto.getIg500().getPrtype());
			forward = "SUCCESS";
		}
		if("UPDATE".equals(mapping.getParameter())){
			dto.setIgprr0114form(form);
			dto = ctlBL.updateIsLookAction(dto);
			request.setAttribute("prserialnum",dto.getIg500().getPrserialnum() );// ������
			request.setAttribute("prid",dto.getIg500().getPrid());
			request.setAttribute("pts",dto.getIg500().getPrtype());
			forward = "UPDATE";
		}

		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}

}
