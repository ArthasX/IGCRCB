package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM08BL;
import com.deliverik.infogovernor.asset.dto.IGASM08DTO;
import com.deliverik.infogovernor.asset.form.IGASM0802Form;
import com.deliverik.infogovernor.asset.vo.IGASM08021VO;

/**
 * Ӧ�ñ༭����Action����
 *
 * @author
 */
public class IGASM0802Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0802Action.class);

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
		IGASM0802Form form = (IGASM0802Form)actionForm;
		
		//BLȡ��
		IGASM08BL ctlBL = (IGASM08BL) getBean("igasm08BL");
		
		//DTO����
		IGASM08DTO dto = new IGASM08DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//Ӧ�õǼǻ��������ʾ����
			log.debug("========Ӧ�õǼǻ��������ʾ����ʼ========");
			form = new IGASM0802Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);			
			
			dto.setIgasm0802Form(form);
			
			dto = ctlBL.searchEntityItemLableAction(dto);			
			
			req.setAttribute("IGASM0802Form", form);
			
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
				dto = ctlBL.insertEntityItemAction(dto);
				
				//���Ǽ����˵�Ӧ����Ϣ�趨��VO��
				IGASM08021VO vo = new IGASM08021VO(dto.getIgasm0802Form());
				
				super.<IGASM08021VO>setVO(req.getSession(), vo);
				
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
