/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
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
import com.deliverik.infogovernor.form.IGCOM0319Form;
import com.deliverik.infogovernor.vo.IGCOM03191VO;

/**
 * ����: �豸��ϵ��ϢAction����
 * ��������: �豸��ϵ��ϢAction����
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public class IGCOM0319Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0319Action.class);

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
		IGCOM0319Form form = (IGCOM0319Form)actionForm;
		
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

			//DTO��������趨			
			dto.setIGCOM0319Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������ϸ��Ϣ���������ʾ�߼�����
			dto = ctlBL.initIGCOM0319RelationAction(dto);
		
			//���豸������Ϣ��������趨��VO��
			IGCOM03191VO vo = new IGCOM03191VO(dto.getFsLvVgInfoList(),dto.getVgPvMetaInfoList());
			
			vo.setSoc0118Info(dto.getSoc0118Info());//�ʲ���Ϣ
			
			vo.setEname(dto.getEname());//�ʲ�ģ������
			
			vo.setEiorgname(dto.getEiorgname());//�豸������������
			
			req.setAttribute("IGCOM0319Form", form);
			
			super.<IGCOM03191VO>setVO(req, vo);

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
