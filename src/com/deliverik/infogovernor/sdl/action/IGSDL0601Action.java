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
import com.deliverik.infogovernor.sdl.bl.IGSDL06BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL06DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0601Form;
import com.deliverik.infogovernor.sdl.vo.IGSDL06011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_ͳ�Ʋ�ѯACTION
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0601Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0601Action.class);
	
	/**
	 * <p>
	 * Description:���KPIͳ�Ʋ�ѯACTION����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author maozhipeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGSDL0601Form form = (IGSDL0601Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========���KPIͳ�Ʋ�ѯ���������ʾ����ʼ========");
			form.setKpiYear(IGStringUtils.getCurrentYear());
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========���KPIͳ�Ʋ�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGSDL06BL ctlBL = (IGSDL06BL) getBean("igSDL06BL");
		//ʵ����DTO
		IGSDL06DTO dto = new IGSDL06DTO();
		//ͳ�Ʋ�ѯ
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========���KPIͳ�Ʋ�ѯ����ʼ========");
			
			dto.setChangeKpiSearchCond(form);
			
			//����BL��ѯ
			dto = ctlBL.searchChangeKpiAction(dto);
			
			//����VO
			IGSDL06011VO vo = new IGSDL06011VO(dto.getChangeKpiList());
			
			super.<IGSDL06011VO>setVO(request, vo);
			
			log.debug("========���KPIͳ�Ʋ�ѯ��������========");
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
