package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM13BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM13DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0805Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM13011VO;

/**
 * ����: ��ʱ�ɼ� ������¼��2013/7/3 �޸ļ�¼��
 */
public class IGCIM0805Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0805Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		IGCIM0805Form form=(IGCIM0805Form)actionForm;
		
		IGCIM13DTO dto = new IGCIM13DTO();
		
		IGCIM13BL ctrBL= (IGCIM13BL) getBean("igcim13BL");
		
		IGCIM13011VO vo = new IGCIM13011VO();
		
		getPaginDTO(req,"IGCIM0805");
		
		PagingDTO pDto;
		
		pDto = (PagingDTO)req.getAttribute("PagingDTO");
		
		String forward = "DISP";
		
		if("Search".equals(mapping.getParameter()) || "Search1".equals(mapping.getParameter())){
			log.info("========�Զ���¼��ʱ�ɼ������������ʾ����ʼ========");
			if ("Search1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCIM0805Form) req.getSession().getAttribute("IGCIM0805Form");
				if ( form == null ) {
					form = new IGCIM0805Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				
				if(req.getParameter("EDIT") != null && "true".equals(req.getParameter("EDIT"))){
					pDto.setFromCount(0);
					form = new IGCIM0805Form();
					req.getSession().removeAttribute("IGCIM0805Form");
					
				} else if (req.getParameter("PAGING") == null ) {
					pDto.setFromCount(0);
					form = (IGCIM0805Form) req.getSession().getAttribute("IGCIM0805Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
				
				
			}
			int maxCnt = getMaxDataCount("IGCIM0805");
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto.setIgcim0805Form(form);
			
			dto = ctrBL.getCICollectTimerTaskList(dto);
			
			List<String> typeNames = ctrBL.getRealtimeTypeNames();
			
			vo.setTypeNames(typeNames);
			
			vo.setTimerTaskList(dto.getTimerTaskList());
			
			vo.setXmlFlag("yes");
			
			super.<IGCIM13011VO>setVO(req, vo);
			// ������ת�趨
			log.info("========�Զ���¼��ʱ�ɼ������������ʾ�������========");
		}
		if( "DISP".equals(mapping.getParameter())){
			log.info("========�Զ���¼��ʱ�ɼ������������ʾ����ʼ========");
			
			String xmlFlag = ctrBL.init();
			if("no".equals(xmlFlag)){
				addMessage(req, new ActionMessage("IGCIM0805.E001"));
			}else{
				List<String> typeNames = ctrBL.getRealtimeTypeNames();
				vo.setTypeNames(typeNames);
			}
			vo.setXmlFlag(xmlFlag);
			super.<IGCIM13011VO>setVO(req, vo);
			
			log.info("========�Զ���¼��ʱ�ɼ������������ʾ�������========");
		}

		return mapping.findForward(forward);
	}
}
