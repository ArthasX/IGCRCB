package com.deliverik.infogovernor.asset.action;

import java.util.List;
import java.util.Set;

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
import com.deliverik.infogovernor.asset.bl.IGASM03BL;
import com.deliverik.infogovernor.asset.dto.IGASM03DTO;
import com.deliverik.infogovernor.asset.form.IGASM0309Form;

/**
 * �豸�·�����Action����
 *
 */
public class IGASM0309Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0309Action.class);

	/**
	 * �豸�·�
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGASM0309Form form = (IGASM0309Form)actionForm;
		
		//BLȡ��
		IGASM03BL ctlBL = (IGASM03BL) getBean("igasm03BL");
		
		//DTO����
		IGASM03DTO dto = new IGASM03DTO();
		
		if ("ISSUEDISP".equals(mapping.getParameter())){
			if(req.getParameter("eiid")!=null){
				form.setEiid(Integer.valueOf(req.getParameter("eiid")));
			}
			if(req.getParameter("eiversion")!=null){
				form.setEiversion(req.getParameter("eiversion"));
			}
			if(req.getParameter("type")!=null){
				form.setType(req.getParameter("type"));
			}
			//�豸�����·���������ʾ����
			log.debug("========�豸�����·���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========�豸�����·���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if("S".equals(req.getParameter("type"))){
			if(req.getParameter("eiid")!=null){
				form.setEiid(Integer.valueOf(req.getParameter("eiid")));
			}
			if(req.getParameter("eiversion")!=null){
				form.setEiversion(String.valueOf(req.getParameter("eiversion")));
				dto.setEiversion(String.valueOf(req.getParameter("eiversion")));
			}
			if( "INSERT".equals(mapping.getParameter())){
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				dto.setIgasm0309Form(form);
				dto.setUserid(user.getUserid());
				dto.setUsername(user.getUsername());
				if(isTokenValid(req,true)){
					ctlBL.entityIssueAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				req.getSession().removeAttribute("ADSelectEntity");
				req.getSession().removeAttribute("ADSelectedEntity");
			} 
		}
		else
		{
			if( "INSERT".equals(mapping.getParameter())){
			//�豸�����·�����
			log.debug("========�豸�����·�����ʼ========");
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setIgasm0309Form(form);
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			
			//�豸�����·��߼�����
			if(isTokenValid(req,true)){
				//�ʲ�ID����
				Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectedEntity");
				if(set != null && set.size() > 0) {
					//DTO��������趨
					dto.setBatchEntityItem(set.toArray(new String[0]));
				} else {
					dto.setBatchEntityItem(new String[]{});
				}
				ctlBL.entityBatchIssueAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			req.getSession().removeAttribute("ADSelectEntity");
			req.getSession().removeAttribute("ADSelectedEntity");
			
			log.debug("========�豸�����·���������========");
			}
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
