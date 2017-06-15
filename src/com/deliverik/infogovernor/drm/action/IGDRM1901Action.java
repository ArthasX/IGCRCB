/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.drm.bl.IGDRM19BL;
import com.deliverik.infogovernor.drm.dto.IGDRM19DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1901Form;
import com.deliverik.infogovernor.drm.vo.IGDRM19011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ͨ�ò�ѯAction
 * </p>
 * <p>
 * ����Ĭ�ϲ�ѯ���������ã�Ĭ����ʾ���̱��⣬�����������ţ������ˣ�����ʱ�䣬�ر�ʱ�䣬�����ˣ�״̬����Ϣ
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
public class IGDRM1901Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDRM1901Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ��־����ȡ��
		// ʵ����FORM
		IGDRM1901Form form = (IGDRM1901Form) actionForm;
		// ��ȡBL�ӿ�ʵ��
		IGDRM19BL ctlBL = (IGDRM19BL) getBean("igdrm19BL");
		IGDRM19DTO dto = new IGDRM19DTO();
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setPrtype(form.getPrtype());
		// ����ѯ���ͱ�ʶ�Ž�dto��
		dto.setType(form.getType());
		// ������ѯ
		if ("SEARCH".equals(mapping.getParameter())
				|| "SEARCH1".equals(mapping.getParameter())) {
			log.debug("========������ѯ����ʼ========");
			// ��ȡ��ҳBean
			getPaginDTO(request, "IGWKM0101");
			PagingDTO pDto;
			pDto = (PagingDTO) request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())) {
				// ����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM1901Form) request.getSession().getAttribute(
						"IGDRM1901Form");
				if (form == null) {
					form = new IGDRM1901Form();
				} else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {

				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGDRM1901Form) request.getSession().getAttribute(
							"IGDRM1901Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGDRM1901");
			form.setUserid_q(user.getUserid());
			dto.setUser(user);
			IG500SearchCondImpl cond = new IG500SearchCondImpl();
			try {
				BeanUtils.copyProperties(cond, form);
			} catch (Exception e) {
				log.error("", e);
			}
			dto.setPrSearchCond(cond);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			// ����BL��ѯ
			dto = ctlBL.getProcessRecords(dto);
			// ����VO
			IGDRM19011VO vo = new IGDRM19011VO(dto.getProcessList());
			super.<IGDRM19011VO> setVO(request, vo);
			log.debug("========������ѯ��������========");
		}
		

		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
			return mapping.findForward("DISP");
	}
}
