/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.svc.action;

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
import com.deliverik.infogovernor.svc.bl.IGSVC01BL;
import com.deliverik.infogovernor.svc.dto.IGSVC01DTO;
import com.deliverik.infogovernor.svc.vo.IGSVC01011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_工作监督_查询ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSVC0105Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSVC0105Action.class);

	/**
	 * <p>
	 * Description: 工作监督action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 获取BL接口实例
		IGSVC01BL ctlBL = (IGSVC01BL) getBean("igsvc01BL");
		// 实例化DTO
		IGSVC01DTO dto = new IGSVC01DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUserid_q(user.getUserid());
		// 工作监督查询
		log.debug("========工作监督查询处理开始========");
		// 调用BL查询
		dto = ctlBL.getAllActiveProcessRecords(dto);
		// 构造VO
		IGSVC01011VO vo = new IGSVC01011VO();
		vo.setProcessRecordMap(dto.getProcessRecordMap());
		vo.setTemplateNames(dto.getTemplateNames());
		vo.setDetailPgs(dto.getDetailPgs());

		super.<IGSVC01011VO> setVO(request, vo);

		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		log.debug("========工作监督查询处理终了========");
		return mapping.findForward("DISP");
	}

}
