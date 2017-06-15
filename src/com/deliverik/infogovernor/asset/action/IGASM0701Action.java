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
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM07BL;
import com.deliverik.infogovernor.asset.dto.IGASM07DTO;
import com.deliverik.infogovernor.asset.form.IGASM0701Form;
import com.deliverik.infogovernor.asset.vo.IGASM07011VO;

/**
 * ������ѯ����Action����
 *
 */
public class IGASM0701Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0701Action.class);

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
		IGASM0701Form form = (IGASM0701Form)actionForm;
		
		//BLȡ��
		IGASM07BL ctlBL = (IGASM07BL) getBean("igasm07BL");
		
		//DTO����
		IGASM07DTO dto = new IGASM07DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//������ѯ���������ʾ����
			log.debug("========������ѯ���������ʾ����ʼ========");
			
			//***************************************************************************
			//���ͷ���(����)�趨
			form = new IGASM0701Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			req.setAttribute("IGASM0701Form", form);
			//***************************************************************************
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========������ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//������ѯ��������ʾ����
			log.debug("========������ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========������ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM0701");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//������ѯ����
			log.debug("========������ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM0701Form) req.getSession().getAttribute("IGASM0701Form");
				if ( form== null){
					form = new IGASM0701Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
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
					form = (IGASM0701Form) req.getSession().getAttribute("IGASM0701Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0701");
			
			//DTO��������趨
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//���������߼�����
			dto = ctlBL.searchEntityItemAction(dto);
			
			//��������Ϣ��������趨��VO��
			IGASM07011VO vo = new IGASM07011VO(dto.getEntityItemVWInfoList());
			
			super.<IGASM07011VO>setVO(req, vo);
			
			log.debug("========������ѯ��������========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//����ɾ������
			log.debug("========����ɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//������Ϣɾ���߼�����
			ctlBL.deleteEntityItemAction(dto);
			
			log.debug("========����ɾ����������========");
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
