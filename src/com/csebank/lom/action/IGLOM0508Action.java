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
import com.csebank.lom.form.IGLOM0508Form;
import com.csebank.lom.vo.IGLOM05071VO;
import com.csebank.lom.vo.IGLOM05081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_�Ӵ�����ͳ�ƹ���_ͳ�Ʋ�ѯACTION
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0508Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0508Action.class);
	
	/**
	 * <p>
	 * Description:�Ӵ�����ͳ�Ʋ�ѯACTION����
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
		IGLOM0508Form form = (IGLOM0508Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�Ӵ�ͳ�Ʋ�ѯ���������ʾ����ʼ========");

			addMessage(request, new ActionMessage("IGCO10000.I003"));
			form.setYearFrom(IGStringUtils.getCurrentYear());
			form.setMonthFrom(IGStringUtils.getCurrentDate().substring(5,7));
			form.setYearTo(IGStringUtils.getCurrentYear());
			form.setMonthTo(IGStringUtils.getCurrentDate().substring(5,7));
			log.debug("========�Ӵ�ͳ�Ʋ�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		//ʵ����DTO
		IGLOM05DTO dto = new IGLOM05DTO();
		//ͳ�Ʋ�ѯ
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========�Ӵ�ͳ�Ʋ�ѯ����ʼ========");
			form.setEtime_from(form.getYearFrom()+"/"+form.getMonthFrom());
			form.setEtime_to(form.getYearTo()+"/"+form.getMonthTo());
			dto.setEentertainmentStatisticsSearchCond(form);
			dto.setIglom0508Form(form);
			//����BL��ѯ
			dto = ctlBL.searchEentertainmentStatisticsAction(dto);
			if(dto.getEentertainmentStatisticsList().size()==1){
				dto.getEentertainmentStatisticsList().clear();
			}
			//����VO
			IGLOM05081VO vo = new IGLOM05081VO();
			vo.setEentertainmentStatisticsList(dto.getEentertainmentStatisticsList());
			
			super.<IGLOM05081VO>setVO(request, vo);
			
			log.debug("========�Ӵ�ͳ�Ʋ�ѯ��������========");
		}else if( "REPORT".equals(mapping.getParameter())){
			log.debug("========�Ӵ�ͳ�Ʋ�ѯ����ʼ========");
			form.setEtime_from(form.getYearFrom()+"/"+form.getMonthFrom());
			form.setEtime_to(form.getYearTo()+"/"+form.getMonthTo());
			dto.setEentertainmentStatisticsSearchCond(form);
			dto.setIglom0508Form(form);
			//����BL��ѯ
			dto = ctlBL.searchEentertainmentStatisticsAction(dto);
			
			//����VO
			IGLOM05081VO vo = new IGLOM05081VO();
			vo.setEentertainmentStatisticsList(dto.getEentertainmentStatisticsList());
			
			super.<IGLOM05081VO>setVO(request, vo);
			
			request.setAttribute("form", form);
			request.setAttribute("IGLOM05081VO", vo);
			
			
			log.debug("========�Ӵ�ͳ�Ʋ�ѯ��������========");
			return mapping.findForward("REPORT");

		}else if( "DETAIL".equals(mapping.getParameter())){
			log.debug("========�Ӵ�ͳ����ϸ��ѯ����ʼ========");
			/*
			form.setSearchtype("D");
			dto.setWorkLunchEaterySearchCond(form);
			dto.setIglom0505Form(form);
			*/
			//����BL��ѯ
			dto = ctlBL.searchEentertainmentAction(dto);
			
			//����VO
			IGLOM05071VO vo = new IGLOM05071VO();
			vo.setEentertainmentList(dto.getEentertainmentList());
			
			super.<IGLOM05071VO>setVO(request, vo);
			
			log.debug("========�Ӵ�ͳ����ϸ��ѯ��������========");
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
