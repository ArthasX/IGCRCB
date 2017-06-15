/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.mnt.action;

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
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT02BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT02DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0112Form;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT01121VO;

/**
 * ����: ������ع���Action
 * ��������: ������ع���Action
 * ������¼: 2012-8-2
 * �޸ļ�¼: 
 */
public class IGMNT0112Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGMNT0104Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//��ȡ��ѯform
		IGMNT0112Form form=(IGMNT0112Form)actionForm;
		//BLȡ��
		IGMNT02BL ctlBL = (IGMNT02BL) getBean("igmnt02BL");
		//DTO����
		IGMNT02DTO dto=new IGMNT02DTO();
		//��ѯ����select
		ctlBL.initHostListSelectAction(dto);
		//��ŵ�session
		req.getSession().setAttribute("ADHostList", dto.getLabelValueBeanList());
		
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("==============������ع����ѯ��ʼ===============");
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGMNT0112");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGMNT0112Form) req.getSession().getAttribute("IGMNT0112Form");
				if ( form== null){
					form = new IGMNT0112Form();
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
					form = (IGMNT0112Form) req.getSession().getAttribute("IGMNT0112Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGMNT0112");
			
			//DTO��������趨
			dto.setIgmnt0112Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto = ctlBL.searchSOC0423Action(dto);
			IGMNT01121VO vo=new IGMNT01121VO();
			vo.setSoc0423List(dto.getSoc0423List());
		
			super.<IGMNT01121VO>setVO(req, vo);
			log.debug("==============������ع����ѯ����===============");
		}
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("==============������ع����ѯ���¿�ʼ===============");
			dto.setIgmnt0112Form(form);
			ctlBL.updateSOC0423Action(dto);
			log.debug("==============������ع����ѯ���½���===============");
			
		}
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============������ع����ѯҳ����ʾ��ʼ===============");
			log.debug("==============������ع����ѯҳ����ʾ����===============");
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
