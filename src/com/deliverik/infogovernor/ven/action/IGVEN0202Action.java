package com.deliverik.infogovernor.ven.action;

import java.util.ArrayList;
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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.ven.bl.IGVEN02BL;
import com.deliverik.infogovernor.ven.dto.IGVEN02DTO;
import com.deliverik.infogovernor.ven.form.IGVEN0202Form;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.vo.IGVEN02012VO;
import com.deliverik.infogovernor.ven.vo.IGVEN02013VO;

/**	
 * ����: ��⹤��ACTION
 * ������¼��yukexin    2014-12-2 ����2:28:15	
 * �޸ļ�¼��null
 */	
public class IGVEN0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVEN0202Action.class);

	/**
	 * ���ռ��ǼǴ���
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
		IGVEN0202Form form = (IGVEN0202Form)actionForm;
		//BLȡ��
		IGVEN02BL ctlBL = (IGVEN02BL) getBean("IGVEN02BL");
		//����
		AttachmentBL attachmentBL = (AttachmentBL)getBean("attachmentBL");
		//DTO����
		IGVEN02DTO dto = new IGVEN02DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========��鹤��ִ�в�ѯ��ʼ========");
			// ��ҳ��DTOȡ��
			getPaginDTO(req, "IGVEN0202");
			PagingDTO pDto;
			pDto = (PagingDTO) req.getAttribute("PagingDTO");
			log.debug("========�ĵ���ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGVEN0202Form) req.getSession().getAttribute("IGVEN0202Form");
				if ( form== null){
					form = new IGVEN0202Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGVEN0202Form) req.getSession().getAttribute("IGVEN0202Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//�������������뵽session��
			req.getSession().setAttribute("rmid", form.getRmid());
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGVEN0202");
			//DTO��������趨
			dto.setIgVEN0202Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto = ctlBL.initIGVEN0202Action(dto);
			
			IGVEN02013VO vo = new IGVEN02013VO();
			List<IGVEN02012VO> voList = new ArrayList<IGVEN02012VO>();
			IGVEN02012VO igven02012vo = null;
			if (dto.getMonitoringWorkInfos() != null) {
				for (MonitoringWorkInfo bean : dto.getMonitoringWorkInfos()) {
					igven02012vo = new IGVEN02012VO();
					igven02012vo.setMonitoringWorkInfo(bean);
					if (bean.getMwattachkey() != null) {
						List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(bean.getMwattachkey());
						if (null != attachmentList && attachmentList.size() > 0) {
							igven02012vo.setAttid(attachmentList.get(0).getAttid());
							igven02012vo.setAttname(attachmentList.get(0).getAttname().split("_")[1]);
						}
					}
					voList.add(igven02012vo);
				}
			}
			
			vo.setIgven02012voList(voList);
			req.setAttribute("rmid", form.getRmid());
			super.<IGVEN02013VO>setVO(req, vo);
			return mapping.findForward("DISP");
		}else if("LOADFILE".equals(mapping.getParameter())){
			//��������
			log.debug("========֪ͨ�������ش���ʼ========");
			String attId = req.getParameter("attid");	
			String type = "svc";
			req.setAttribute("type", type);
			req.setAttribute("attId", attId);

			log.debug("========֪ͨ�������ش������========");
			return mapping.findForward("LOADFILE");
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
