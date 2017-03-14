/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.smr.bl.IGSMR09BL;
import com.deliverik.infogovernor.smr.dto.IGSMR09DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0901Form;

/**
 * ����:����dashboard(����ҵ�����) ��������������dashboard ������¼�� 2013-09 �޸ļ�¼��
 */
public class IGSMR0901Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0901Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		IGSMR0901Form form = (IGSMR0901Form) actionForm;
		IGSMR09BL ctlBL = (IGSMR09BL) getBean("igSMR09BL");
		IGSMR09DTO dto = new IGSMR09DTO();
		String forward = "DISP";
		dto.setIgsmr0901Form(form);
		PrintWriter out = response.getWriter();

		if ("DISP".equals(mapping.getParameter())) {

			log.debug("========����������ʾ����ʼ========");
			log.debug("========����������ʾ�������========");

		} else if ("SEARCH".equals(mapping.getParameter())) {

			String type = request.getParameter("searchType");

			if ("ElecTransTotal".equals(type)) {// ElecTransTotal
				log.debug("========���ӽ��ױ����ϼƲ�ѯ����ʼ========");

				dto = ctlBL.getElecTransTotal(dto);

				log.debug("========���ӽ��ױ����ϼƲ�ѯ�������========");
			} else if ("MultiBankTransCount".equals(type)) {
				log.debug("========���н��׷�������������ѯ����ʼ========");

				dto = ctlBL.getMultiBankTransCount(dto);

				log.debug("========���н��׷�������������ѯ�������========");
			} else if ("MultiBankTransMoney".equals(type)) {
				log.debug("========���н��׷���������ѯ����ʼ========");

				dto = ctlBL.getMultiBankTransMoney(dto);

				log.debug("========���н��׷���������ѯ�������========");
			} else if ("MultiBankTransCountTrend".equals(type)) {
				log.debug("========���ױ������Ʒ�����ѯ����ʼ========");

				dto = ctlBL.getMultiBankTransCountTrend(dto);

				log.debug("========���ױ������Ʒ�����ѯ�������========");
			} else if ("MultiBankTransMoneyTrend".equals(type)) {
				log.debug("========���׽�����Ʒ�����ѯ����ʼ========");

				dto = ctlBL.getMultiBankTransMoneyTrend(dto);

				log.debug("========���׽�����Ʒ�����ѯ�������========");
			} else if ("ElecWorkScale".equals(type)) {
				log.debug("========��������ҵ���ģ��ѯ����ʼ========");

				dto = ctlBL.getElecWorkScale(dto);

				log.debug("========��������ҵ���ģ��ѯ�������========");
			}

			String result = dto.getResult();
			if (StringUtils.isEmpty(result))
				result = "";
			out.print(result);
			out.flush();
			return null;
		}

		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}

}
