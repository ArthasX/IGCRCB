package com.deliverik.infogovernor.soc.cim.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0157Form;

/**
 * Ӧ�ò�ѯ����Action����
 *
 */
public class IGCIM0157Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0157Action.class);

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
		IGCIM0157Form form = (IGCIM0157Form)actionForm;
		
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		if( "DISP".equals(mapping.getParameter())){
			//Ӧ�ò�ѯ���������ʾ����
			log.debug("========Ӧ�ò�ѯ���������ʾ����ʼ========");
			//��ȡ�˵�Ȩ��
//			UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
//			//���ø����˵�
//			if(perm != null) {
//				//��ȡָ���˵�ID��ACTSORTID
//				String actsortid =perm.getActsortid("ACT15BUS01");
//				if(req.getParameter("actname")!=null){
//					actsortid = perm.getActsortid(req.getParameter("actname"));
//				}
//				if(StringUtils.isNotEmpty(actsortid)){
//					setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
//					if(actsortid.length()==4){
//						setSessionAttribute(req, "secondactid", actsortid.substring(0,4));
//					}else if(actsortid.length()==8){
//						setSessionAttribute(req, "secondactid", actsortid.substring(0,6));
//					}
//				}
//			}
			User user = (User)getSessionAttribute(req, SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			//��ϵ��xml��ѯ
			dto = ctlBL.getBusinessTree(dto);
			String eiid=req.getParameter("eiid");
			String treeXml = dto.getTreeXml();
			req.setAttribute("treeXml", treeXml);
			if(StringUtils.isNotEmpty(eiid)){
				
				req.setAttribute("eiid", eiid);
			}else{
				
				if(null!=req.getAttribute("eiid")){
					req.setAttribute("eiid",req.getAttribute("eiid"));
				}else{
					req.setAttribute("eiid", dto.getEiid());
				}
			}
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========Ӧ�ò�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
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
