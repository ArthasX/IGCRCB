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
import com.deliverik.infogovernor.asset.form.IGASM1005Form;
import com.deliverik.infogovernor.asset.vo.IGASM10051VO;

/**
 * ������������Ϣ��ʷ��¼����Action����
 *
 */
public class IGASM1005Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1005Action.class);

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
		IGASM1005Form form = (IGASM1005Form)actionForm;
		
		//BLȡ��
		IGASM10BL ctlBL = (IGASM10BL) getBean("igasm10BL");
		//DTO����
		IGASM10DTO dto = new IGASM10DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//������������Ϣ��ʷ��¼���������ʾ����
			log.debug("========������������Ϣ��ʷ��¼���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1005");

			//DTO��������趨
			dto.setIgasm1005Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGASM1005Action(dto);
			
			//��������������Ϣ��ʷ��¼��������趨��VO��
			IGASM10051VO vo = new IGASM10051VO(dto.getSocEntityItemVWInfo(),
					dto.getConfigItemMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(true);
			//��ȡ��ʷ�汾����ʱ��
			vo.setConfigItemVersionTime(dto.getSocConfigItemVersionTime());
			
			super.<IGASM10051VO>setVO(req.getSession(), vo);
			
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			
			log.debug("========������������Ϣ��ʷ��¼���������ʾ��������========");
			String operType=req.getParameter("operType");
			if("tongji".equals(operType)){
				return mapping.findForward("TONGJIDISP");
			}else
			return mapping.findForward("DISP");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//������������Ϣ��ʷ��¼���淵�ذ�ť����ʱ�ķ��ش���
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
}
