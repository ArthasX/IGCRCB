/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM04BL;
import com.deliverik.infogovernor.asset.dto.IGASM04DTO;
import com.deliverik.infogovernor.asset.form.IGASM0421Form;
import com.deliverik.infogovernor.asset.vo.IGASM04211VO;

/**
 * ����: ��ͬ����Ǽ�Action
 * ��������: ��ͬ����Ǽ�Action
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
public class IGASM0421Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGASM0421Action.class);
	
	/**
	 * ����ǼǴ���
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGASM0421Form form = (IGASM0421Form)actionForm;
		
		//BLȡ��
		IGASM04BL ctlBL = (IGASM04BL) getBean("igasm04BL");
		
		//DTO����
		IGASM04DTO dto = new IGASM04DTO();
		
		String forward = "null";
		if( "DISP".equals(mapping.getParameter())){
			//��ͬ����Ǽǻ��������ʾ����
			log.debug("========��ͬ����Ǽǻ��������ʾ����ʼ========");
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0421");
			
			//DTO��������趨
			dto.setIgasm0421Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//��ͬ����Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGASM0421Action(dto);
			
			//����ͬ������Ϣ��������趨��VO��
			IGASM04211VO vo = new IGASM04211VO();
			
			vo.setEntityItemCompactVWInfo(dto.getEntityItemCompactVWInfo());
			//�Ƿ���ʾͼ��ť
			vo.setImage_flag(dto.getImage_flag());
			if(!dto.getImage_flag()){
				vo.setPicsXml(dto.getPicsXml());
				vo.setPicuXml(dto.getPicuXml());
			}
			
			vo.setKaihuhang(dto.getKaihuhang());//������
			vo.setKaihuzhanghao(dto.getKaihuzhanghao());//�����˺�
			vo.setKaihumingcheng(dto.getKaihumingcheng());//��������
			
			req.setAttribute("IGASM0421Form", dto.getIgasm0421Form());
			super.<IGASM04211VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","��ͬ������Ϣ"));
			log.debug("========��ͬ����Ǽǻ��������ʾ��������========");
			saveToken(req);
			forward = "DISP";
		} else if("EDIT".equals(mapping.getParameter())){
			//��ͬ������Ϣ�༭
			log.debug("========��ͬ������Ϣ�༭����ʼ========");

			//DTO��������趨
			dto.setIgasm0421Form(form);
			
			if (isTokenValid(req, true)){
				//��ͬ������Ϣ�༭�߼�����
				dto = ctlBL.editIGASM0421Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========��ͬ������Ϣ�༭��������========");
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
