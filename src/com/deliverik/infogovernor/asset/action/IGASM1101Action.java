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
import com.deliverik.infogovernor.asset.bl.IGASM11BL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;
import com.deliverik.infogovernor.asset.form.IGASM1101Form;
import com.deliverik.infogovernor.asset.vo.IGASM11011VO;

/**
 * �����б���Action����
 *
 */
public class IGASM1101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1101Action.class);

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
		IGASM1101Form form = (IGASM1101Form)actionForm;

		//BLȡ��
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO����
		IGASM11DTO dto = new IGASM11DTO();
		
		if( "DISP".equals(mapping.getParameter())||"SEARCH".equals(mapping.getParameter())){
			//������ѯ���������ʾ����
			log.debug("========������ѯ���������ʾ����ʼ========");
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM1101");

			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM1101Form) req.getSession().getAttribute("IGASM1101Form");
				if ( form== null){
					form = new IGASM1101Form();
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
					form = (IGASM1101Form) req.getSession().getAttribute("IGASM1101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1101");
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//���������߼�����
			dto = ctlBL.initIGASM1101Action(dto);
			
			//��������Ϣ��������趨��VO��
			IGASM11011VO vo = new IGASM11011VO(dto.getComputerRoomVWInfoList());
			
			super.<IGASM11011VO>setVO(req, vo);
			
			log.debug("========������ѯ���������ʾ��������========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//����ɾ������
			log.debug("========����ɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//������Ϣɾ���߼�����
			ctlBL.deleteComputerRoomInfoAction(dto);
			
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
