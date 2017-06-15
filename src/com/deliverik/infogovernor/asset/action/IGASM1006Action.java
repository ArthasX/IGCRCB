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
import com.deliverik.infogovernor.asset.form.IGASM1006Form;
import com.deliverik.infogovernor.asset.vo.IGASM10061VO;

/**
 * �������ϵ������Action����
 *
 */
public class IGASM1006Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1006Action.class);

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
		IGASM1006Form form = (IGASM1006Form)actionForm;
		
		//BLȡ��
		IGASM10BL ctlBL = (IGASM10BL) getBean("igasm10BL");
		
		//DTO����
		IGASM10DTO dto = new IGASM10DTO();
		
		//������ת�趨
		String forword = null;
		String operType=req.getParameter("operType");
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//�������ϵ�����������ʾ����
			log.debug("========�������ϵ�����������ʾ����ʼ========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGASM1006Form) req.getSession().getAttribute("IGASM1006Form");
			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1006");

			//DTO��������趨
			dto.setIgasm1006Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�������ϵ�����������ʾ�߼�����
			dto = ctlBL.initIGASM1006Action(dto);
			
			//�����ù�ϵ������Ϣ��������趨��VO��
			IGASM10061VO vo = new IGASM10061VO(dto.getSocEntityItemVWInfo(),
					dto.getSocParEntityItemRelationMap(),
					dto.getSocCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			super.<IGASM10061VO>setVO(req.getSession(), vo);
			
			log.debug("========�������ϵ�����������ʾ��������========");
			
			forword = "DISP";
		}
		
		if ("EDIT".equals(mapping.getParameter())) {
			if (req.getParameter("btn_back")!=null) {
				//���ذ�ť����ʱ�ķ��ش���
				forword = "BACK";
			}
		}
		
		
		//�߼���������е���Ϣ��ʾ
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
		return mapping.findForward(forword);
	}
}
