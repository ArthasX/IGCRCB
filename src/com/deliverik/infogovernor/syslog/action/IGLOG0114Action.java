/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.syslog.action;

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
import com.deliverik.infogovernor.syslog.bl.IGLOG01BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG01DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0114Form;
import com.deliverik.infogovernor.syslog.vo.IGLOG0114VO;

/**
 * 
 * 
 *
 */
public class IGLOG0114Action extends BaseAction {
	static Log log = LogFactory.getLog(IGLOG0114Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IGLOG0114Form form = (IGLOG0114Form) actionForm;
		IGLOG01BL ctrBL = (IGLOG01BL) getBean("iglog01BL");
		IGLOG01DTO dto = new IGLOG01DTO();

		// 设置国际化
		dto.setLocale(this.getLocale(request));

		if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("========屏蔽信息日志信息查询处理开始========");
			// 查询记录最大数值
			int maxCnt = getMaxDataCount("IGLOG0114");
			form.setId(null);
			dto.setMaxSearchCount(maxCnt);
			getPaginDTO(request, "IGLOG0114");
			PagingDTO pDto;
			pDto = (PagingDTO) request.getAttribute("PagingDTO");
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGLOG0114Form) request.getSession().getAttribute(
						"IGLOG0114Form");
				if (form != null) {
					form.setFromCount(0);
				}
			}
			dto.setIglog0114Form(form);
			pDto.setPageDispCount(18);
			dto.setPagingDto(pDto);
			
			dto = ctrBL.echoData(dto);
			dto = ctrBL.getCodeList(dto);

			IGLOG0114VO vo = new IGLOG0114VO();
			vo.setRuleli(dto.getRuleli());
			vo.setLi(dto.getLi());
			form.setCvalue(null);
			super.<IGLOG0114VO> setVO(request, vo);
			log.debug("========设备日志信息查询处理终了========");
		}
		if ("DELETE".equals(mapping.getParameter())) {
			form = (IGLOG0114Form) request.getSession().getAttribute(
					"IGLOG0114Form");
			dto.setIglog0114Form(form);
			if (ctrBL.SearchCount(dto)) 
			{
				ctrBL.deleteData(dto);
			}
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
