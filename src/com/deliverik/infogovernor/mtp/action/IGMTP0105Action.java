/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.mtp.action;


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
import com.deliverik.infogovernor.mtp.bl.IGMTP01BL;
import com.deliverik.infogovernor.mtp.dto.IGMTP04DTO;
import com.deliverik.infogovernor.mtp.form.IGMTP0104Form;
import com.deliverik.infogovernor.mtp.vo.IGMTP01051VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 工作计划修改ACTION
 * </p>
 * 
 * @author zhaoyunli@deliverik.com
 * @version 1.0
 */

public class IGMTP0105Action extends BaseAction {

	static Log log = LogFactory.getLog(IGMTP0105Action.class);

	/**
	 * <p>
	 * Description: 工作计划修改ACTION
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		
		IGMTP0104Form form = (IGMTP0104Form)actionForm;
		// 获取BL接口实例
		IGMTP01BL ctlBL = (IGMTP01BL) getBean("igmtp01BL");

		// 实例化DTO
		IGMTP04DTO dto = new IGMTP04DTO();
		
		//User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);

		
		log.debug("========工作计划修改处理开始========");
		if ("MODIFY_DISP".equals(mapping.getParameter())) {
			dto.setQjid(form.getQjid());
			dto = ctlBL.getQuartzJobs(dto);
			IGMTP01051VO vo = new IGMTP01051VO();
			vo.setQuartzJobs(dto.getQuartzJobs());
			request.setAttribute("vo", vo);
			addMessage(request, new ActionMessage("IGCO10000.I001", "修改信息"));
			if (null == dto.getQuartzJobs().getQjendtime().trim()
					|| "".equals(dto.getQuartzJobs().getQjendtime().trim())) {
				return mapping.findForward("MODIFY_ONCE");
			}
		}
		log.debug("========工作计划修改处理结束========");
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
}
