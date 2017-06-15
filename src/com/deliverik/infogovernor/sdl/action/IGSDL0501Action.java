/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.action;

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
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.sdl.bl.IGSDL05BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL05DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0501Form;
import com.deliverik.infogovernor.sdl.vo.IGSDL05011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_ͳ�Ʋ�ѯACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0501Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0501Action.class);
	
	/**
	 * <p>
	 * Description:ͳ�Ʋ�ѯACTION����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author sunkaiyu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGSDL0501Form form = (IGSDL0501Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========ͳ�Ʋ�ѯ���������ʾ����ʼ========");
			form.setYear(IGStringUtils.getCurrentYear());
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========ͳ�Ʋ�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		if( "POPDISP".equals(mapping.getParameter())){
			log.debug("========ͳ�Ʋ�ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========ͳ�Ʋ�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGSDL05BL ctlBL = (IGSDL05BL) getBean("igSDL05BL");
		//ʵ����DTO
		IGSDL05DTO dto = new IGSDL05DTO();
		//ͳ�Ʋ�ѯ
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========ͳ�Ʋ�ѯ����ʼ========");
			
			dto.setSdlSummarySearchCond(form);
			
			//����BL��ѯ
			dto = ctlBL.searchSdlSummaryAction(dto);
			
			//����VO
			IGSDL05011VO vo = new IGSDL05011VO(dto.getSdlSummaryList(),dto.getSdlDefineInfo());
			
			super.<IGSDL05011VO>setVO(request, vo);
			
			log.debug("========ͳ�Ʋ�ѯ��������========");
		}
		if( "POPSEARCH".equals(mapping.getParameter())){
			log.debug("========ͳ�Ʋ�ѯ����ʼ========");
			
			dto.setSdlSummarySearchCond(form);
			
			//����BL��ѯ
			dto = ctlBL.searchSdlSummaryAction(dto);
			
			//����VO
			IGSDL05011VO vo = new IGSDL05011VO(dto.getSdlSummaryList(),dto.getSdlDefineInfo());
			
			super.<IGSDL05011VO>setVO(request, vo);
			
			log.debug("========ͳ�Ʋ�ѯ��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
