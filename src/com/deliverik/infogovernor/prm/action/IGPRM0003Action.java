/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prm.action;

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
import com.deliverik.infogovernor.prm.bl.IGPRM00BL;
import com.deliverik.infogovernor.prm.dto.IGPRM00DTO;
import com.deliverik.infogovernor.prm.form.IGPRM0003Form;
import com.deliverik.infogovernor.prm.vo.IGPRM00001VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_流程发起_选择流程类型ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGPRM0003Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRM0003Action.class);
	
	/**
	 * <p>
	 * Description:选择流程类型ACTION处理
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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("========流程类型查询处理开始========");
		IGPRM0003Form form = (IGPRM0003Form)actionForm;
		//获取BL接口实例
		IGPRM00BL ctlBL = (IGPRM00BL) getBean("igprm00BL");
		//实例化DTO
		IGPRM00DTO dto = new IGPRM00DTO();
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUserid(user.getUserid());
		
		dto.setProcessType(form.getPrtype());
		//选择流程类型查询
		if ("RelevantProcess".equals(mapping.getParameter())) {
		    dto.setPdid(request.getParameter("pdid"));
		    dto.setPsdid(request.getParameter("psdid"));
		    dto.setRoleid(Integer.valueOf(request.getParameter("roleid")));
		    dto = ctlBL.searchRelevantProcessAction(dto);
		} else {
		    dto = ctlBL.searchQuickProcessDefinitionAction(dto);
		}
		//构造VO
		IGPRM00001VO vo = new IGPRM00001VO();
		vo.setTemplateDefinitionMap(dto.getTemplateDefinitionMap());
		super.<IGPRM00001VO>setVO(request, vo);
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		log.debug("========流程类型查询处理终了========");
		return mapping.findForward("DISP");
	}

}
