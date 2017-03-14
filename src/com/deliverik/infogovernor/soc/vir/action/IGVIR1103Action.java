/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.action;


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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR11BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR11DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1103Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR11031VO;

/**
 * ����: ������Դͳ�ƣ����û���
 * ��������: ������Դͳ�ƣ����û���
 * ������¼: 2014/02/12
 * �޸ļ�¼: 
 */
public class IGVIR1103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR1103Action.class);

	/**
	 * ���ð�����ϵ��ʾ����
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		IGVIR1103Form form = (IGVIR1103Form)actionForm;
		//BLȡ��
		IGVIR11BL ctlBL = (IGVIR11BL) getBean("igvir11BL");
		
		//DTO����
		IGVIR11DTO dto = new IGVIR11DTO();
		
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========������Դͳ����ʾ��ʼ�����û���========");
			form.setPname_like(null);
			IGVIR11031VO vo = new IGVIR11031VO();
			super.<IGVIR11031VO>setVO(req, vo);
			log.debug("========������Դͳ����ʾ���ˣ����û���========");
		}else if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========������Դͳ�Ʋ�ѯ��ʼ�����û���========");
			getPaginDTO(req,"IGVIR1103");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGVIR1103Form) req.getSession().getAttribute("IGVIR1103Form");
				if ( form== null){
					form = new IGVIR1103Form();
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
					form = (IGVIR1103Form) req.getSession().getAttribute("IGVIR1103Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGVIR1103");
			dto.setIgVIR1103Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			ctlBL.getVim03CountByProj(dto);
			IGVIR11031VO vo = new IGVIR11031VO();
			vo.setVim03pList(dto.getVim03pList());
			
			super.<IGVIR11031VO>setVO(req.getSession(), vo);
			log.debug("========������Դͳ�Ʋ�ѯ���ˣ����û���========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward(forward);
	}
}
