/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0121Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01211VO;

/**
 * @Description: 流程处理_按机构查询执行人
 * @Author  
 * @History 2013-02-28     新建 
 * @Version V1.0
 */
public class IGPRR0121Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRR0121Action.class);
	
	/**
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGPRR0121Form form = (IGPRR0121Form)actionForm;
		//获取BL接口实例
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		//实例化DTO
		IGPRR01DTO dto = new IGPRR01DTO();
		String forward = "DISP";
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		dto.setIgPRR0121Form(form);
		
		//查询指定角色和部门下的执行人
		if ("INIT".equals(mapping.getParameter())){
			log.debug("========执行人查询处理开始========");
			
			dto = ctlBL.searchProcessExecutor(dto);
			IGPRR01211VO vo = new IGPRR01211VO();
			vo.setLst_UserRoleInfo(dto.getLst_UserRoleVW());
			super.<IGPRR01211VO>setVO(request, vo);
			saveToken(request);
			log.debug("========执行人查询处理结束========");
		}
		else if ("ADD".equals(mapping.getParameter())){
			log.debug("========添加执行人处理开始========");
			if(isTokenValid(request,true)){
				ctlBL.addProcessExecutor(dto);
			}else{
				return null;
			}
			
			log.debug("========添加执行人处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}
	
}
