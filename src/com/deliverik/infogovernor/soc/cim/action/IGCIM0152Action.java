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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0152Form;

/**
 * ����: �������ˣ���ϵ�Ǽ�Action
 * ��������: �������ˣ���ϵ�Ǽ�Action
 * ������¼: 2013/10/25
 * �޸ļ�¼: 
 */
public class IGCIM0152Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0152Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM0152Form form = (IGCIM0152Form)actionForm;
		
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setIgcim0152Form(form);
		dto.setLocale(this.getLocale(req));
		dto = ctlBL.initIGCIM0152Action(dto);
		//���ӹ�������
		List<LabelValueBean> ADrelationList = dto.getRelationList();
		
		req.getSession().setAttribute("ADrelationList", ADrelationList);
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//Ӧ�ù�ϵ�Ǽǻ��������ʾ����
			log.debug("========Ӧ�ù�ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","Ӧ�ù�ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGCIM0152Form", form);
			
			log.debug("========Ӧ�ù�ϵ�Ǽǻ��������ʾ��������========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "INSERT".equals(mapping.getParameter())){
			log.debug("========Ӧ�ù�ϵ�ǼǴ���ʼ========");
			if (form.getMode().equals("0")){
				//DTO��������趨
				dto.setIgcim0152Form(form);
				if (isTokenValid(req, true)){
					//Ӧ�ù�ϵ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemRelationActionApp2(dto);
					req.setAttribute("eiid", form.getPareiid());
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				forward = "BACK";
			}
			log.debug("========Ӧ�ù�ϵ�ǼǴ�������========");
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
