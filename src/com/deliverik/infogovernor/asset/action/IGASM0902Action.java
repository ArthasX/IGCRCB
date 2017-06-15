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
import com.deliverik.infogovernor.asset.bl.IGASM09BL;
import com.deliverik.infogovernor.asset.dto.IGASM09DTO;
import com.deliverik.infogovernor.asset.form.IGASM0902Form;
import com.deliverik.infogovernor.asset.vo.IGASM09021VO;

/**
 * �����̱༭����Action����
 *
 * @author
 */
public class IGASM0902Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0902Action.class);

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
		IGASM0902Form form = (IGASM0902Form)actionForm;
		
		//BLȡ��
		IGASM09BL ctlBL = (IGASM09BL) getBean("igasm09BL");
		
		//DTO����
		IGASM09DTO dto = new IGASM09DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//�����̵Ǽǻ��������ʾ����
			log.debug("========�����̵Ǽǻ��������ʾ����ʼ========");
			form = new IGASM0902Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);				
			
			dto.setIgasm0902Form(form);
			
			dto = ctlBL.searchEntityItemLableAction(dto);		
			
			req.setAttribute("IGASM0902Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","�����̻�����Ϣ"));
			log.debug("========�����̵Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//�����̵Ǽǻ�������ʾ����
			log.debug("========�����̵Ǽǻ�������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�����̵Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//�����̱༭����
			if (form.getMode().equals("0")){
				//�����̵ǼǴ���
				log.debug("========�����̵ǼǴ���ʼ========");
				
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiuserid(user.getUserid());
				
				form.setEiusername(user.getUsername());
				
				//DTO��������趨
				dto.setIgasm0902Form(form);
				
				//��������Ϣ�Ǽ��߼�����
				dto = ctlBL.insertEntityItemAction(dto);
				
				//���Ǽ����˵ķ�������Ϣ�趨��VO��
				IGASM09021VO vo = new IGASM09021VO(dto.getIgasm0902Form());
				
				super.<IGASM09021VO>setVO(req.getSession(), vo);
				
				log.debug("========�����̵ǼǴ�������========");
				
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
