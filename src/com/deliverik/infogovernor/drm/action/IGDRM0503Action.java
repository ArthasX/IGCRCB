package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM05BL;
import com.deliverik.infogovernor.drm.dto.IGDRM05DTO;
import com.deliverik.infogovernor.drm.form.IGDRM05031Form;
import com.deliverik.infogovernor.drm.form.IGDRM0503Form;
import com.deliverik.infogovernor.drm.vo.IGDRM05031VO;
import com.deliverik.infogovernor.drm.vo.IGDRM05032VO;

/**
 * ר��Ԥ��������Ϣ��ʷ��¼����Action����
 *
 */
public class IGDRM0503Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0503Action.class);

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

		//BLȡ��
		IGDRM05BL ctlBL = (IGDRM05BL) getBean("igdrm05BL");
		//DTO����
		IGDRM05DTO dto = new IGDRM05DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//ר��Ԥ��������Ϣ��ʷ��¼���������ʾ����
			log.debug("========ר��Ԥ��������Ϣ��ʷ��¼���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDRM0503");
			IGDRM0503Form form = (IGDRM0503Form)actionForm;

			//DTO��������趨
			dto.setIgdrm0503Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//ר��Ԥ��������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGDRM0503Action(dto);
			
			//��ר��Ԥ��������Ϣ��ʷ��¼��������趨��VO��
			IGDRM05031VO vo = new IGDRM05031VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.isFlag());
			vo.setEiorgname(dto.getEiorgname());
			//��ȡ��ʷ�汾����ʱ��
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			//��ʷ��Ϣ������ʾ,AssetsName=1����ר��Ԥ��2������
			form.setAssetsName("1");
			super.<IGDRM05031VO>setVO(req.getSession(), vo);
			log.debug("========ר��Ԥ��������Ϣ��ʷ��¼���������ʾ��������========");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//ר��Ԥ��������Ϣ��ʷ��¼���淵�ذ�ť����ʱ�ķ��ش���
			return mapping.findForward("DISP");
		}
		if( "VERSION".equals(mapping.getParameter())){
			//������Ϣ��ʷ��¼���������ʾ����
			log.debug("========������Ϣ��ʷ��¼���������ʾ����ʼ========");
			IGDRM0503Form form = (IGDRM0503Form)actionForm;

			//DTO��������趨
			dto.setIgdrm0503Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.ClickVersionShow(dto);
			
			//��������Ϣ��ʷ��¼��������趨��VO��
			IGDRM05031VO vo = new IGDRM05031VO(dto.getEntityItemVWInfo(), dto.getConfigItemMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.isFlag());
			super.<IGDRM05031VO>setVO(req, vo);
			log.debug("========������Ϣ��ʷ��¼���������ʾ��������========");
		}
		if( "SEARCH".equals(mapping.getParameter())){
			//�ʲ���������Ϣ�汾�Ƚϻ��������ʾ����
			log.debug("========�ʲ���������Ϣ�汾�Ƚϻ��������ʾ����ʼ========");
			IGDRM05031Form form1 = (IGDRM05031Form)actionForm;
			//DTO��������趨
			dto.setIgdrm05031Form(form1);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�ʲ���������Ϣ�汾�Ƚϻ��������ʾ�߼�����
			dto = ctlBL.versionCompare(dto);
			
			//���ʲ���������Ϣ�汾�Ƚϼ�������趨��VO��
			IGDRM05032VO vo = new IGDRM05032VO(dto.getEntityItemVW(), dto.getEntityItemConfigurations());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.isFlag());
			super.<IGDRM05032VO>setVO(req, vo);
			
			log.debug("========�ʲ���������Ϣ�汾�Ƚϻ��������ʾ��������========");
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
