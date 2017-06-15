package com.deliverik.infogovernor.soc.cim.action;

import java.util.Date;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0122Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01221VO;

/**
 * Ӧ�ñ༭����Action����
 *
 * @author
 */
public class IGCIM0122Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0122Action.class);

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
		IGCIM0122Form form = (IGCIM0122Form)actionForm;
		
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//Ӧ�õǼǻ��������ʾ����
			log.debug("========Ӧ�õǼǻ��������ʾ����ʼ========");
			form = new IGCIM0122Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);			
			
			dto.setIgasm0802Form(form);
			
			dto = ctlBL.searchEntityItemLableActionApp(dto);			
			
			req.setAttribute("IGCIM0122Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","Ӧ�û�����Ϣ"));
			log.debug("========Ӧ�õǼǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//Ӧ�õǼǻ�������ʾ����
			log.debug("========Ӧ�õǼǻ�������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========Ӧ�õǼǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//Ӧ�ñ༭����
			if (form.getMode().equals("0")){
				//Ӧ�õǼǴ���
				log.debug("========Ӧ�õǼǴ���ʼ========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiuserid(user.getUserid());
				
				form.setEiusername(user.getUsername());
				
				//DTO��������趨
				dto.setIgasm0802Form(form);
				
				//Ӧ����Ϣ�Ǽ��߼�����
				dto = ctlBL.insertEntityItemActionApp(dto);
				
				//���Ǽ����˵�Ӧ����Ϣ�趨��VO��
				IGCIM01221VO vo = new IGCIM01221VO(dto.getIgasm0802Form());
				
				super.<IGCIM01221VO>setVO(req.getSession(), vo);
				
				log.debug("========Ӧ�õǼǴ�������========");
				
				forward = "DISP";

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
