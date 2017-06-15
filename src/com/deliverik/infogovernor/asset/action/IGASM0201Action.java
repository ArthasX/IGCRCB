package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM02BL;
import com.deliverik.infogovernor.asset.dto.IGASM02DTO;
import com.deliverik.infogovernor.asset.form.IGASM0201Form;
import com.deliverik.infogovernor.asset.vo.IGASM02011VO;

/**
 * �������ѯ����Action����
 *
 */
public class IGASM0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0201Action.class);

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
		IGASM0201Form form = (IGASM0201Form)actionForm;
		
		//BLȡ��
		IGASM02BL ctlBL = (IGASM02BL) getBean("igasm02BL");
		
		//DTO����
		IGASM02DTO dto = new IGASM02DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//�������ѯ���������ʾ����
			log.debug("========�������ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�������ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//�������ѯ��������ʾ����
			log.debug("========�������ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�������ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM0201");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//�������ѯ����
			log.debug("========�������ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM0201Form) req.getSession().getAttribute("IGASM0201Form");
				if ( form== null){
					form = new IGASM0201Form();
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
					form = (IGASM0201Form) req.getSession().getAttribute("IGASM0201Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0201");
			
			
			
			//DTO��������趨
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//����������߼�����
			dto = ctlBL.searchEntityItemAction(dto);
			
			//����������Ϣ��������趨��VO��
			IGASM02011VO vo = new IGASM02011VO(dto.getEntityItemVWInfoList());
			
			super.<IGASM02011VO>setVO(req, vo);
			
			log.debug("========�������ѯ��������========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//������ɾ������
			log.debug("========������ɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//��������Ϣɾ���߼�����
			ctlBL.deleteEntityItemAction(dto);
			
			log.debug("========������ɾ����������========");
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
