package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0106Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01061VO;

/**
 * �豸��ϵ������Action����
 *
 */
public class IGCIM0904Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0904Action.class);

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
		IGCIM0106Form form = (IGCIM0106Form)actionForm;
		
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		//������ת�趨
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//�豸��ϵ�����������ʾ����
			log.debug("========�豸��ϵ�����������ʾ����ʼ========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGCIM0106Form) req.getSession().getAttribute("IGCIM0106Form");
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0306");
			
			//DTO��������趨
			dto.setIgcim0106Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			if("1".equals(form.getRelationType())){//������ϵ
				dto = ctlBL.initIGASM0306BelongAction(dto);
			}else{//�ʲ�ԭ�й�ϵ
				//�豸��ϵ�����������ʾ�߼�����
				dto = ctlBL.initIGASM0306Action(dto);
			}
			
			//�����͹�ϵ������Ϣ��������趨��VO��
			IGCIM01061VO vo = new IGCIM01061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//����������ϵ�б�
			vo.setEiBelongRelationList(dto.getEiBelongRelationList());
			vo.setRlnmap(dto.getRlnmap());
			super.<IGCIM01061VO>setVO(req.getSession(), vo);
			saveToken(req);
			log.debug("========�豸��ϵ�����������ʾ��������========");
			
			forword = "DISP";
		}
		
		if( "DISP_NOTOKEN".equals(mapping.getParameter())){
			//�豸��ϵ�����������ʾ����
			log.debug("========�豸��ϵ�����������ʾ����ʼ========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGCIM0106Form) req.getSession().getAttribute("IGCIM0106Form");
			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0106");

			//DTO��������趨
			dto.setIgcim0106Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			if("1".equals(form.getRelationType())){//������ϵ
				dto = ctlBL.initIGASM0306BelongAction(dto);
			}else{//�ʲ�ԭ�й�ϵ
				//�豸��ϵ�����������ʾ�߼�����
				dto = ctlBL.initIGASM0306Action(dto);
			}
			
			//�����͹�ϵ������Ϣ��������趨��VO��
			IGCIM01061VO vo = new IGCIM01061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//����������ϵ�б�
			vo.setEiBelongRelationList(dto.getEiBelongRelationList());
			super.<IGCIM01061VO>setVO(req.getSession(), vo);
			log.debug("========�豸��ϵ�����������ʾ��������========");
			
			forword = "DISP";
		}
		
		if ("EDIT".equals(mapping.getParameter())) {
			if (req.getParameter("btn_back")!=null) {
				//���ذ�ť����ʱ�ķ��ش���
				forword = "BACK";
			}
			if (req.getParameter("btn_add")!=null) {
				//���Ӱ�ť����ʱ�Ĵ���
				forword = "ADD";
			}
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forword);
	}
}
