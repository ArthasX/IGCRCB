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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM10BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM10DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1001Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM04371VO;

/**
 * ��ֵ�趨����Action����
 *
 */
public class IGCIM1001Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1001Action.class);

	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM1001Form form = (IGCIM1001Form)actionForm;
		
		//BLȡ��
		IGCIM10BL ctlBL = (IGCIM10BL) getBean("igcim10BL");
		
		//DTO����
		IGCIM10DTO dto = new IGCIM10DTO();
		if( "DISP".equals(mapping.getParameter())){
			//��ֵ���������ʾ����
			log.debug("========��ֵ���������ʾ����ʼ========");
			
			//***************************************************************************
			//���ͷ���(�豸)�趨
			form = new IGCIM1001Form();
			req.setAttribute("IGCIM1001Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��ֵ��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		if("SEARCH".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGCIM1001");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//��ֵ��ѯ����
			log.debug("========��ֵ��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCIM1001Form) req.getSession().getAttribute("IGCIM1001Form");
				if ( form== null){
					form = new IGCIM1001Form();
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
					form = (IGCIM1001Form) req.getSession().getAttribute("IGCIM1001Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM1001");
			
			//DTO��������趨			
			dto.setSoc0437SearchCond(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//��ֵ�����߼�����
			dto = ctlBL.searchCutItemAction(dto);
			
			//����ֵ��Ϣ��������趨��VO��
			IGCIM04371VO vo = new IGCIM04371VO(dto.getSoc0437InfoList());		
			super.<IGCIM04371VO>setVO(req, vo);
			log.debug("========��ֵ��ѯ��������========");
		}
		if("UPDATE".equals(mapping.getParameter())){
			//��ֵ�趨����
			form.setEiid(req.getParameter("pdid"));
			dto.setIgcim1001Form(form);
			ctlBL.updateCutValueAction(dto);
			
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
