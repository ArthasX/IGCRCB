package com.deliverik.infogovernor.action;

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
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.form.IGCOM0320Form;
import com.deliverik.infogovernor.vo.IGCOM03201VO;

/**
 * ������ϸ��Ϣ����Action����
 *
 */
public class IGCOM0320Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0320Action.class);

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
		
		String forword = "DISP";
		//FORMȡ��
		IGCOM0320Form form = (IGCOM0320Form)actionForm;
		
		//BLȡ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		//DTO����
		IGCOM03DTO dto = new IGCOM03DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
	     if( "RELATION".equals(mapping.getParameter())){
			//������ϸ��Ϣ���������ʾ����
			log.debug("========��ϵͼ�鿴��ϵ���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCOM0303");

			//dto.setSrname("�߼���");;			
			dto.setIGCOM0320Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������ϸ��Ϣ���������ʾ�߼�����
			dto = ctlBL.initIGCOM0320RelationAction(dto);
		
			//���豸������Ϣ��������趨��VO��
			IGCOM03201VO vo = new IGCOM03201VO();
			vo.setPortList(dto.getPortList());
			vo.setSwitchConfigItem(dto.getSwitchConfigItem());
			vo.setZoneList(dto.getZoneList());			
			req.setAttribute("IGCOM0320Form", form);
			super.<IGCOM03201VO>setVO(req, vo);

			addMessage(req, new ActionMessage("IGCO10000.I001","�ʲ�������Ϣ"));
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			log.debug("========��ϵͼ�鿴��ϵ���������ʾ��������========");
			return mapping.findForward(forword);
		}		
		return mapping.findForward(null);
	}
}
