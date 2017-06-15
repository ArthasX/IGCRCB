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
import com.deliverik.infogovernor.asset.form.IGASM1115Form;
import com.deliverik.infogovernor.asset.vo.IGASM11151VO;

/**
 * �豸ѡ����Action����
 *
 */
public class IGASM1115Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1115Action.class);

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
		IGASM1115Form form = (IGASM1115Form)actionForm;

		//BLȡ��
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO����
		IGASM11DTO dto = new IGASM11DTO();
		
		//������ת����
		String forward = null;
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�豸ѡ���������ʾ����ʼ========");
			dto.setIgasm1115Form(form);
			ctlBL.getContainerNameByEiid(dto);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�豸ѡ���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if("SEARCH".equals(mapping.getParameter())){
			//�豸ѡ���������ʾ����
			log.debug("========�豸ѡ���������ʾ����ʼ========");
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM1115");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGASM1115Form) req.getSession().getAttribute("IGASM1115Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}else{
				pDto.setFromCount(form.getFromCount());
			}
			
//			if ("SEARCH".equals(mapping.getParameter())){
//				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
//				form = (IGASM1115Form) req.getSession().getAttribute("IGASM1115Form");
//				if ( form== null){
//					form = new IGASM1115Form();
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
			int maxCnt = getMaxDataCount("IGASM1115");
			
			//DTO��������趨
			dto.setIgasm1115Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//���������߼�����
			dto = ctlBL.initIGASM1115Action(dto);
			
			//��������Ϣ��������趨��VO��
			IGASM11151VO vo = new IGASM11151VO(
					dto.getComputerDeviceVWInfoList());
			
			super.<IGASM11151VO>setVO(req, vo);
			
			form.setSuccess("0");

			forward = "DISP";
			
			log.debug("========�豸ѡ���������ʾ��������========");
		}
		
		if ("ADD".equals(mapping.getParameter())) {
			//�豸ѡ���������ʾ����
			log.debug("========�豸�趨����ʼ========");
			//DTO��������趨
			dto.setIgasm1115Form(form);
			
			dto = ctlBL.setComputerDeviceAction(dto);
			
			form.setSuccess("1");
			
			forward = "DISP";
			
			log.debug("========�豸�趨��������========");
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
