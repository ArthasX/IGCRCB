/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM11BL;
import com.deliverik.infogovernor.sym.dto.IGSYM11DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1102Form;
import com.deliverik.infogovernor.sym.vo.IGSYM11021VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_���ݷ�����Ϣ�༭����Action����
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM1102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1102Action.class);

	/**
	 * ���ݷ�����Ϣ�༭����Action����
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
		IGSYM1102Form form = (IGSYM1102Form)actionForm;
		
		//BLȡ��
		IGSYM11BL ctlBL = (IGSYM11BL) getBean("igsym11BL");
		
		//DTO����
		IGSYM11DTO dto = new IGSYM11DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//���ݷ���Ǽǻ��������ʾ����
			log.debug("========���ݷ���Ǽǻ��������ʾ����ʼ========");
			req.setAttribute("IGSYM1102Form", new IGSYM1102Form());
			addMessage(req, new ActionMessage("IGCO10000.I001","���ݷ�����Ϣ"));
			log.debug("========���ݷ���Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			//���ݷ���༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//���ݷ���Ǽǻ��水�·��ذ�ťʱ�ķ��ش���
				if (form.getMode().equals("1")){
					//�������Ͳ�ѯ����
					return mapping.findForward("BACK");
				}
			}
			
			if (form.getMode().equals("0")){
				//���ݷ���ǼǴ���
				log.debug("========���ݷ���ǼǴ���ʼ========");
				//DTO��������趨
				dto.setIgsym1102Form(form);
				
				//���ݷ�����Ϣ�Ǽ��߼�����
				dto = ctlBL.insertCodeCategoryAction(dto);
				
				//���Ǽ����˵�������Ϣ�趨��VO��
				IGSYM11021VO vo = new IGSYM11021VO(form);
				
				super.<IGSYM11021VO>setVO(req.getSession(), vo);
				
				log.debug("========���ݷ���ǼǴ�������========");
				
				if (form.getMode().equals("2")) {
					//���ز���б���
					forward = "BACK1";
				} else {
					forward = "DISP";
				}
			} else {
				//���ͱ������
				log.debug("========���ݷ���������ʼ========");
				
				dto.setIgsym1102Form(form);
				
				//������Ϣ����߼�����
				dto = ctlBL.updateCodeCategoryAction(dto);
				
				log.debug("========���ݷ�������������========");
				
				forward = "BACK";
			}
		}
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========���ݷ�����������ʾ����ʼ========");
			dto.setIgsym1102Form(form);
			
			dto = ctlBL.initIGSYM1102Action(dto);
			
			log.debug("========���ݷ�����������ʾ��������========");

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
