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
import com.deliverik.infogovernor.asset.bl.IGASM01BL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.form.IGASM0102Form;
import com.deliverik.infogovernor.asset.vo.IGASM01021VO;

/**
 * ���ͻ�����Ϣ�༭����Action����
 *
 */
public class IGASM0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0102Action.class);

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
		IGASM0102Form form = (IGASM0102Form)actionForm;
		
		//BLȡ��
		IGASM01BL ctlBL = (IGASM01BL) getBean("igasm01BL");
		
		//DTO����
		IGASM01DTO dto = new IGASM01DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//���͵Ǽǻ��������ʾ����
			log.debug("========���͵Ǽǻ��������ʾ����ʼ========");
			req.setAttribute("IGASM0102Form", new IGASM0102Form());
			
			addMessage(req, new ActionMessage("IGCO10000.I001","ģ�ͻ�����Ϣ"));
			log.debug("========���͵Ǽǻ��������ʾ��������========");
			saveToken(req);
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//���͵Ǽǻ�������ʾ����
			log.debug("========���͵Ǽǻ�������ʾ����ʼ========");
			
			dto.setIgasm0102Form(form);
			saveToken(req);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���͵Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//���ͱ༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//���͵Ǽǻ��水�·��ذ�ťʱ�ķ��ش���
				if (form.getMode().equals("1")){
					//�������Ͳ�ѯ����
					return mapping.findForward("BACK");
				}
			}
			
			if (form.getMode().equals("0")){
				//���͵ǼǴ���
				log.debug("========���͵ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setEntity(form);
				dto.setIgasm0102Form(form);
				
				if (isTokenValid(req, true)){
				//������Ϣ�Ǽ��߼�����
					dto = ctlBL.insertEntityAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//���Ǽ����˵�������Ϣ�趨��VO��
				IGASM01021VO vo = new IGASM01021VO(dto.getEntity());
				
				super.<IGASM01021VO>setVO(req.getSession(), vo);
				
				log.debug("========���͵ǼǴ�������========");
				
				forward = "DISP";
				
			} else {
				//���ͱ������
				log.debug("========���ͻ�����Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setEntity(form);
				dto.setIgasm0102Form(form);
				
				//������Ϣ����߼�����
				dto = ctlBL.updateEntityAction(dto);
				
				log.debug("========���ͻ�����Ϣ�����������========");
				
				forward = "BACK";
			}
		}
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========���ͻ�����Ϣ���������ʾ����ʼ========");
			dto.setIgasm0102Form(form);
			
			dto = ctlBL.initIGASM0102Action(dto);
			
			log.debug("========���ͻ�����Ϣ���������ʾ��������========");

			forward = "DISP";
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
