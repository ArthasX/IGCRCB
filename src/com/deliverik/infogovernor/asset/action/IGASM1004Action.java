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
import com.deliverik.infogovernor.asset.bl.IGASM10BL;
import com.deliverik.infogovernor.asset.dto.IGASM10DTO;
import com.deliverik.infogovernor.asset.form.IGASM1004Form;
import com.deliverik.infogovernor.asset.vo.IGASM10041VO;

/**
 * ������������Ϣ��ϸ����Action����
 *
 */
public class IGASM1004Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1004Action.class);

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
		IGASM1004Form form = (IGASM1004Form)actionForm;
		
		//BLȡ��
		IGASM10BL ctlBL = (IGASM10BL) getBean("igasm10BL");
		
		//DTO����
		IGASM10DTO dto = new IGASM10DTO();
		String operType=req.getParameter("operType");
		if( "DISP".equals(mapping.getParameter())){
			//������������Ϣ�Ǽǻ��������ʾ����
			log.debug("========������������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1004");

			//DTO��������趨
			dto.setIgasm1004Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGASM1004Action(dto);
			
			//��������������Ϣ��������趨��VO��
			IGASM10041VO vo = new IGASM10041VO();
			
			vo.setSocConfigItemVWInfoMap(dto.getSocConfigItemVWInfoMap());
			vo.setSocEntityItemVWInfo(dto.getSocEntityItemVWInfo());
			super.<IGASM10041VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","������������Ϣ"));
			log.debug("========������������Ϣ�Ǽǻ��������ʾ��������========");
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			if(operType!=null){
				if(operType.equals("wb")){
					return mapping.findForward("WBDISP");
				}
			}
			return mapping.findForward("DISP");
		} 

		if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
			//������������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
			//�����������ѯ����
			return mapping.findForward("BACK1");
		}

		return mapping.findForward("null");
	}
}
