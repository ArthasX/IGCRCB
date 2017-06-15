package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM20BL;
import com.deliverik.infogovernor.drm.dto.IGDRM20DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2001Form;
import com.deliverik.infogovernor.drm.vo.IGDRM20011VO;

/**
 * Ԥ��������������Action
 *
 */
public class IGDRM2001Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM2001Action.class);

	/**
	 * Ԥ����������
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
		IGDRM2001Form form = (IGDRM2001Form)actionForm;
		
		//BLȡ��
		IGDRM20BL ctlBL = (IGDRM20BL) getBean("igdrm20BL");
		
		//DTO����
		IGDRM20DTO dto = new IGDRM20DTO();
		
		//������ת�趨
		String forward = null;
		
		dto.setForm(form);

		if( "DISP".equals(mapping.getParameter())){
			//���͵Ǽǻ��������ʾ����
			log.debug("========���͵Ǽǻ��������ʾ����ʼ========");
			saveToken(req);
			log.debug("========���͵Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========���ͻ�����Ϣ���������ʾ����ʼ========");
			
			dto = ctlBL.initS0C0117EditInfo(dto);

			log.debug("========���ͻ�����Ϣ���������ʾ��������========");

			forward = "DISP";
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
				
				if (isTokenValid(req, true)){
				//������Ϣ�Ǽ��߼�����
					dto = ctlBL.insertEntityAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//���Ǽ����˵�������Ϣ�趨��VO��
				IGDRM20011VO vo = new IGDRM20011VO(dto.getEntity());
				
				super.<IGDRM20011VO>setVO(req.getSession(), vo);
				
				log.debug("========���͵ǼǴ�������========");
				req.setAttribute("btn1Val", "����ģ����");
				req.setAttribute("btn1Url", "IGDRM2002_Disp.do");
				req.setAttribute("btn2Val", "����");
				req.setAttribute("btn2Url", "IGDRM2001_Disp.do");
				
				forward = "DISP";
				
			} else {
				//���ͱ������
				log.debug("========���ͻ�����Ϣ�������ʼ========");
				
				//������Ϣ����߼�����
				dto = ctlBL.updateEntityAction(dto);
				
				log.debug("========���ͻ�����Ϣ�����������========");
				
				forward = "BACK";
			}
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
