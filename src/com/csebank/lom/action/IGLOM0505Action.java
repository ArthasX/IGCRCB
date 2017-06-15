/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0505Form;
import com.csebank.lom.vo.IGLOM05051VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_����������ͳ�ƹ���_ͳ�Ʋ�ѯACTION
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0505Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0505Action.class);
	
	/**
	 * <p>
	 * Description:����������ͳ�Ʋ�ѯACTION����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author wuzhenqiu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGLOM0505Form form = (IGLOM0505Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========����������ͳ�Ʋ�ѯ���������ʾ����ʼ========");
			form.setYear(IGStringUtils.getCurrentYear());
			form.setMonth(IGStringUtils.getCurrentDate().substring(5,7));
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========����������ͳ�Ʋ�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		//ʵ����DTO
		IGLOM05DTO dto = new IGLOM05DTO();
		//ͳ�Ʋ�ѯ
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========����������ͳ�Ʋ�ѯ����ʼ========");
			
			dto.setWorkLunchEaterySearchCond(form);
			dto.setIglom0505Form(form);
			form.setDetail("");
			//����BL��ѯ
			dto = ctlBL.searchWorkLunchEateryAction(dto);
			
			//����VO
			IGLOM05051VO vo = new IGLOM05051VO();
			vo.setMap(dto.getMapel());
			super.<IGLOM05051VO>setVO(request, vo);
			log.debug("========����������ͳ�Ʋ�ѯ��������========");
			
		}else if( "REPORT".equals(mapping.getParameter())){
			log.debug("========����������ͳ�Ʋ�ѯ����ʼ========");
			dto.setWorkLunchEaterySearchCond(form);
			dto.setIglom0505Form(form);
			if("D".equals(form.getDetail())){
				form.setSearchtype("D");
			}
			//����BL��ѯ
			dto = ctlBL.searchWorkLunchEateryAction(dto);
			if("D".equals(form.getDetail())){
				IGLOM05051VO vo = new IGLOM05051VO();
				vo.setWorkLunchEateryList(dto.getWorkLunchEateryList());
				super.<IGLOM05051VO>setVO(request, vo);
				form.setYearD(request.getSession().getAttribute("ADedate").toString().substring(0,4));
				form.setMonthD(request.getSession().getAttribute("ADedate").toString().substring(5,7));
				request.setAttribute("form", form);
				request.setAttribute("IGLOM05051VO", vo);
			}else{
				//����VO
				IGLOM05051VO vo = new IGLOM05051VO();
				vo.setMap(dto.getMapel());
				super.<IGLOM05051VO>setVO(request, vo);
				
				request.setAttribute("form", form);
				request.setAttribute("IGLOM05051VO", vo);
			}
			
			log.debug("========����������ͳ�Ʋ�ѯ��������========");
			return mapping.findForward("REPORT");

		}else if( "DETAIL".equals(mapping.getParameter())){
			log.debug("========����������ͳ����ϸ��ѯ����ʼ========");
			form.setSearchtype("D");
			dto.setWorkLunchEaterySearchCond(form);
			dto.setIglom0505Form(form);
			form.setDetail("D");
			//����BL��ѯ
			dto = ctlBL.searchWorkLunchEateryAction(dto);
			
			//����VO
			IGLOM05051VO vo = new IGLOM05051VO();
			vo.setWorkLunchEateryList(dto.getWorkLunchEateryList());
			request.setAttribute("edate", form.getEdate());
			request.getSession().setAttribute("ADedate", form.getEdate());
			super.<IGLOM05051VO>setVO(request, vo);
			
			log.debug("========����������ͳ����ϸ��ѯ��������========");
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
