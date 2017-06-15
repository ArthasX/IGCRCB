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
import com.deliverik.infogovernor.sdl.bl.IGSDL07BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL07DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0701Form;
import com.deliverik.infogovernor.sdl.vo.IGSDL07011VO;

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

public class IGSDL0701Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0701Action.class);
	
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
		IGSDL0701Form form = (IGSDL0701Form)actionForm;
		String forward = "DISP";
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========���KPIͳ�Ʋ�ѯ���������ʾ����ʼ========");
			form.setKpiYear(IGStringUtils.getCurrentYear());
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			form.setRadioValue("A");
			log.debug("========���KPIͳ�Ʋ�ѯ���������ʾ��������========");
			return mapping.findForward(forward);
		}	
		//��ȡBL�ӿ�ʵ��
		IGSDL07BL ctlBL = (IGSDL07BL) getBean("igSDL07BL");
		//ʵ����DTO
		IGSDL07DTO dto = new IGSDL07DTO();
		//ͳ�Ʋ�ѯ
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========���KPIͳ�Ʋ�ѯ����ʼ========");
			
			dto.setIncidentKpiSearchCond(form);
			
			//����VO
			IGSDL07011VO vo = new IGSDL07011VO();
			String radioValue = form.getRadioValue();
			if("B".equals(radioValue)){
				//�����̶�
				forward = "URGENCY";
				dto = ctlBL.searchIncidentKpiListAction(dto);
				vo.setIncidentKpiList(dto.getIncidentKpiList());
			}else if("C".equals(radioValue)){
				//�¼����+�����̶�
				forward = "TYPEANDURGENCY";
				dto = ctlBL.searchTypeMapAction(dto);
				vo.setIncidentKpiMap(dto.getIncidentKpiMap());
			}else if("D".equals(radioValue)){
				//�����̶�+�¼����
				forward = "URGENCYANDTYPE";
				dto = ctlBL.searchUrgencyMapAction(dto);
				vo.setIncidentKpiMap(dto.getIncidentKpiMap());
			}else{
				dto = ctlBL.searchIncidentKpiListAction(dto);
				vo.setIncidentKpiList(dto.getIncidentKpiList());
			}
			
			super.<IGSDL07011VO>setVO(request, vo);
			
			log.debug("========���KPIͳ�Ʋ�ѯ��������========");
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
