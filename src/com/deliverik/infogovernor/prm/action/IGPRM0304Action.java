/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prm.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.infogovernor.prm.bl.IGPRM01BL;
import com.deliverik.infogovernor.prm.dto.IGPRM01DTO;
import com.deliverik.infogovernor.prm.form.IGPRM0304Form;
import com.deliverik.infogovernor.prm.vo.IGPRM03041VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程类型_缺省审批人ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGPRM0304Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRM0304Action.class);
	
	/**
	 * <p>
	 * Description: 缺省审批人action
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
		//实例化FORM
		IGPRM0304Form form = (IGPRM0304Form)actionForm;
		//获取BL接口实例
		IGPRM01BL ctlBL = (IGPRM01BL) getBean("IGPRM01BL");
		//实例化DTO
		IGPRM01DTO dto = new IGPRM01DTO();
		dto.setIgprm0304Form(form);
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========缺省审批人查询开始========");
			//调用BL查询
			dto = ctlBL.initApprovors(dto);
			//构造VO
			IGPRM03041VO vo = new IGPRM03041VO();
			Map<String,List<Role>> roleMap = dto.getApproveRolesMap();
			Map<String,List<IG337Info>> approvorsMap = dto.getApprovorsMap();
			if(roleMap != null) {
				vo.setRoleList_one(roleMap.get(WorkFlowConstDefine.DEFAULT_APPROVOR_ONE));
				vo.setRoleList_two(roleMap.get(WorkFlowConstDefine.DEFAULT_APPROVOR_TWO));
				vo.setRoleList_three(roleMap.get(WorkFlowConstDefine.DEFAULT_APPROVOR_THREE));
			}
			if(approvorsMap != null) {
				vo.setApprovorsList_one(approvorsMap.get(WorkFlowConstDefine.DEFAULT_APPROVOR_ONE));
				vo.setApprovorsList_two(approvorsMap.get(WorkFlowConstDefine.DEFAULT_APPROVOR_TWO));
				vo.setApprovorsList_three(approvorsMap.get(WorkFlowConstDefine.DEFAULT_APPROVOR_THREE));
			}
			saveToken(request);
			super.<IGPRM03041VO>setVO(request, vo);
			log.debug("========缺省审批人查询终了========");
		}
		//缺省审批人
		if ("APPROVORS".equals(mapping.getParameter())){
			log.debug("========缺省审批人设置开始========");
			dto.setIgprm0304Form(form);
			//删除角色
			if("0".equals(form.getMode())){
				if (isTokenValid(request, true)){
					//调用BL发起
					ctlBL.removeApprovors(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}else{//添加角色
				if (isTokenValid(request, true)){
					//调用BL发起
					ctlBL.addApprovors(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}
			log.debug("========缺省审批人设置终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
}
