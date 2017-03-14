/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.action;

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
import com.deliverik.infogovernor.dut.bl.IGDUT03BL;
import com.deliverik.infogovernor.dut.dto.IGDUT03DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0305Form;
import com.deliverik.infogovernor.dut.vo.IGDUT03051VO;

/**
 * ����: �ճ�ά�ޱ��ѯ&ɾ��action 
 * ��������: �ճ�ά�ޱ��ѯ&ɾ��action 
 * ������¼: 2012/04/01 
 * �޸ļ�¼:
 */

public class IGDUT0305Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0305Action.class);

	/**
	 * �ճ�ά�ޱ��ѯ&ɾ��action
	 * 
	 * @param mapping
	 *            ActionMapping
	 * @param form
	 *            ActionForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ʵ����FORM
		IGDUT0305Form form = (IGDUT0305Form) actionForm;
		// ��ȡBL�ӿ�ʵ��
		IGDUT03BL ctlBL = (IGDUT03BL) getBean("igdut03BL");
		// ʵ����DTO
		IGDUT03DTO dto = new IGDUT03DTO();

		// ɾ��
		if ("DELETE".equals(mapping.getParameter())) {
			log.debug("========����ɾ����ʼ========");
			// ��ֵ
			dto.setIgDUT0305Form(form);
			dto.setOnDutyPersonRecordSearchCond(form);
			// ����ɾ������
			ctlBL.deleteOnDutyPersonRecordAction(dto);
			log.debug("========����ɾ������========");
		}

		// ��ѯ
		if ("SEARCH".equals(mapping.getParameter())
				|| "SEARCH1".equals(mapping.getParameter())) {
			log.debug("========֪ͨ��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())) {
				form = (IGDUT0305Form) request.getSession().getAttribute(
						"IGDUT0305Form");
			}
			// ��ȡ��ҳBean
			getPaginDTO(request, "IGDUT0305");

			PagingDTO pDto;

			pDto = (PagingDTO) request.getAttribute("PagingDTO");

			if ("SEARCH1".equals(mapping.getParameter())) {
				// ����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDUT0305Form) request.getSession().getAttribute(
						"IGDUT0305Form");
				if (form == null) {
					form = new IGDUT0305Form();
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
					form = (IGDUT0305Form) request.getSession().getAttribute(
							"IGDUT0305Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}

			int maxCnt = getMaxDataCount("IGDUT0305");

			dto.setOnDutyPersonRecordSearchCond(form);

			dto.setMaxSearchCount(maxCnt);

			dto.setPagingDto(pDto);
			// ����BL��ѯ
			dto = ctlBL.searchODPRAction(dto);

			// ����BL��ѯ����������List
			// dto= ctlBL.searchOnDutyPersonRecordArea(dto);//codeDetailListȡ��

			// ����VO
			IGDUT03051VO vo = new IGDUT03051VO();
			// �����¼�б�
			vo.setOnDutyPersonRecordInfoList(dto.getOnDutyPersonRecordList());
			// ������������б�
			vo.setCodeDetailList(dto.getCodeDetailList());
			// ����request
			super.<IGDUT03051VO> setVO(request, vo);
			log.debug("========֪ͨ��ѯ��������========");
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
