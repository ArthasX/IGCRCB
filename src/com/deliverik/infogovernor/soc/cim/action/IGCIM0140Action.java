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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0140Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01401VO;

/**
 * ҵ��ϵͳ������ԱȱʧAction IGCIM0140Action
 *
 */
public class IGCIM0140Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0140Action.class);

	/**
	 * �Ƚϴ���
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM0140Form form = (IGCIM0140Form)actionForm;
		
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//ҵ��ϵͳ������Աȱʧ��ѯ���������ʾ����
			log.debug("========ҵ��ϵͳ������Աȱʧ��ѯ���������ʾ����ʼ========");
			
			//***************************************************************************
			form = new IGCIM0140Form();
			req.setAttribute("IGCIM0135Form", form);
			
			//***************************************************************************
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========ҵ��ϵͳ������Աȱʧ��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//��Ա��ѯ��������ʾ����
			log.debug("========ҵ��ϵͳ������Աȱʧ��ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========ҵ��ϵͳ������Աȱʧ��ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGCIM0135");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//��Ա��ѯ����
			log.debug("========ҵ��ϵͳ������Աȱʧ��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCIM0140Form) req.getSession().getAttribute("IGCIM0140Form");
				if ( form== null){
					form = new IGCIM0140Form();
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
					form = (IGCIM0140Form) req.getSession().getAttribute("IGCIM0140Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0140");
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setIgcim0140Form(form);
			
			//ҵ��ϵͳ������Աȱʧ�����߼�����
			dto = ctlBL.searchIGCIM0140Action(dto);
			
			//��ҵ��ϵͳ������Աȱʧ��Ϣ��������趨��VO��
			IGCIM01401VO vo = new IGCIM01401VO();
			vo.setPlatformManagerList(dto.getPlatformManagerList());
			super.<IGCIM01401VO>setVO(req, vo);
			
			log.debug("========ҵ��ϵͳ������Աȱʧ��ѯ��������========");
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
