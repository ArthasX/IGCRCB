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
import com.deliverik.infogovernor.asset.form.IGASM1105Form;
import com.deliverik.infogovernor.asset.vo.IGASM11051VO;

/**
 * ����ѡ����Action����
 *
 */
public class IGASM1105Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1105Action.class);

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
		IGASM1105Form form = (IGASM1105Form)actionForm;

		//BLȡ��
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO����
		IGASM11DTO dto = new IGASM11DTO();
		
		//������ת����
		String forward = null;
		
		if( "DISP".equals(mapping.getParameter())){
			//����ѡ���������ʾ����
			log.debug("========����ѡ���������ʾ����ʼ========");
			dto.setIgasm1105Form(form);
			ctlBL.getRoomNameByEiid(dto);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����ѡ���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if("SEARCH".equals(mapping.getParameter())){
			//����ѡ���������ʾ����
			log.debug("========����ѡ���������ʾ����ʼ========");
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM1105");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGASM1105Form) req.getSession().getAttribute("IGASM1105Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}else{
				pDto.setFromCount(form.getFromCount());
			}
//			if ("SEARCH".equals(mapping.getParameter())){
//				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
//				form = (IGASM1105Form) req.getSession().getAttribute("IGASM1105Form");
//				if ( form== null){
//					form = new IGASM1105Form();
//				}else {
//					if (req.getParameter("PAGING") == null) {
//						pDto.setFromCount(form.getFromCount());
//					} else {
//						form.setFromCount(pDto.getFromCount());
//					}
//				}
//			} else {
//				if (req.getParameter("PAGING") == null) {
//					pDto.setFromCount(0);
//				}
//			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1105");
			
			//DTO��������趨
			dto.setIgasm1105Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//���������߼�����
			dto = ctlBL.initIGASM1105Action(dto);
			
			//��������Ϣ��������趨��VO��
			IGASM11051VO vo = new IGASM11051VO(
					dto.getComputerContainerVWInfoList());
			
			super.<IGASM11051VO>setVO(req, vo);
			
			form.setSuccess("0");

			forward = "DISP";
			
			log.debug("========����ƽ��ͼ���������ʾ��������========");
		}
		
		if ("ADD".equals(mapping.getParameter())) {
			//����ѡ���������ʾ����
			log.debug("========�����趨����ʼ========");
			//DTO��������趨
			dto.setIgasm1105Form(form);
			
			dto = ctlBL.setComputerContainerAction(dto);
			
			form.setSuccess("1");
			
			forward = "DISP";
			
			log.debug("========�����趨��������========");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}
