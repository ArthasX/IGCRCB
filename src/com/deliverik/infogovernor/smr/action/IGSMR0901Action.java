/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
 * 概述:季报dashboard(电银业务分析) 功能描述：季报dashboard 创建记录： 2013-09 修改记录：
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

			log.debug("========季报初期显示处理开始========");
			log.debug("========季报初期显示处理结束========");

		} else if ("SEARCH".equals(mapping.getParameter())) {

			String type = request.getParameter("searchType");

			if ("ElecTransTotal".equals(type)) {// ElecTransTotal
				log.debug("========电子交易笔数合计查询处理开始========");

				dto = ctlBL.getElecTransTotal(dto);

				log.debug("========电子交易笔数合计查询处理结束========");
			} else if ("MultiBankTransCount".equals(type)) {
				log.debug("========跨行交易分析（笔数）查询处理开始========");

				dto = ctlBL.getMultiBankTransCount(dto);

				log.debug("========跨行交易分析（笔数）查询处理结束========");
			} else if ("MultiBankTransMoney".equals(type)) {
				log.debug("========跨行交易分析（金额）查询处理开始========");

				dto = ctlBL.getMultiBankTransMoney(dto);

				log.debug("========跨行交易分析（金额）查询处理结束========");
			} else if ("MultiBankTransCountTrend".equals(type)) {
				log.debug("========交易笔数趋势分析查询处理开始========");

				dto = ctlBL.getMultiBankTransCountTrend(dto);

				log.debug("========交易笔数趋势分析查询处理结束========");
			} else if ("MultiBankTransMoneyTrend".equals(type)) {
				log.debug("========交易金额趋势分析查询处理开始========");

				dto = ctlBL.getMultiBankTransMoneyTrend(dto);

				log.debug("========交易金额趋势分析查询处理结束========");
			} else if ("ElecWorkScale".equals(type)) {
				log.debug("========电子银行业务规模查询处理开始========");

				dto = ctlBL.getElecWorkScale(dto);

				log.debug("========电子银行业务规模查询处理结束========");
			}

			String result = dto.getResult();
			if (StringUtils.isEmpty(result))
				result = "";
			out.print(result);
			out.flush();
			return null;
		}

		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}

}
