package com.deliverik.infogovernor.wki.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dbm.vo.IGDBM13011VO;
import com.deliverik.infogovernor.wki.bl.IGWKI01BL;
import com.deliverik.infogovernor.wki.dto.IGWKI01DTO;
import com.deliverik.infogovernor.wki.form.IGWKI0101Form;
import com.deliverik.infogovernor.wki.vo.IGWKI01011VO;

public class IGWKI0101Action extends BaseAction {
	static Log log = LogFactory.getLog(IGWKI0101Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// ���FORM
		IGWKI0101Form form = (IGWKI0101Form) actionForm;
		// ���BL
		IGWKI01BL ctlBL = (IGWKI01BL) getBean("igwki01BL");
		// dto
		IGWKI01DTO dto = new IGWKI01DTO();

		User user = (User) req.getSession()
				.getAttribute(SESSION_KEY_LOGIN_USER);

		dto.setUser(user);

		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========������Ϣ�������������ʾ����ʼ========");
			// ����
			log.debug("========������Ϣ�������������ʾ��������========");
			return mapping.findForward("DISP");
		} else if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("========������Ϣ��ѯ��ʼ========");
			// ��ȡ��ҳDTO ���û�ж�Ӧ��IGWKI0101������default
			getPagingDTO(req, "IGWKI0101");
			PagingDTO pDto;
			pDto = (PagingDTO) req.getAttribute("PagingDTO");

			if ("SEARCH1".equals(mapping.getParameter())) {
				// ����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGWKI0101Form) req.getSession().getAttribute(
						"IGWKI0101Form");
				if (form == null) {// �����ڵĻ��ʹӿ�ͷ��ʼ��ѯ
					form = new IGWKI0101Form();
				} else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				// �����������ҳ�����������߼������ص�paging����ֵ
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			// �������¼�����Ƶ�������Ϣ
			int maxCnt = getMaxDataCount("IGWKI0101");

			dto.setIgwki01Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			// ��ȡ������Ϣlist
			dto = ctlBL.searchWorkInfos(dto);
			IGWKI01011VO vo = new IGWKI01011VO();
			vo.setWkiList(dto.getWkiList());
			super.<IGWKI01011VO> setVO(req, vo);
			log.debug("=========������Ϣ��ѯ����==========");
			return mapping.findForward("DISP");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}

		return mapping.findForward("DISP");
	}

}
