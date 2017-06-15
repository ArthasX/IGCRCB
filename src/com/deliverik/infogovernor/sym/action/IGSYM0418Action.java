/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0418Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04181VO;

/**
 * @Description:  根据角色类型查询用户Action
 * @Author  masai
 * @History 2010-6-22     新建 
 * @Version V2.0
 */
 
public class IGSYM0418Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0418Action.class);
	
	/**
	 * <p>
	 * Description: 根据角色类型查询用户action处理
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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//实例化FORM
		IGSYM0418Form form = (IGSYM0418Form)actionForm;
		//获取BL接口实例
		IGSYM04BL ctlBL = (IGSYM04BL)getBean("igsym04BL");
		//实例化DTO
		IGSYM04DTO dto = new IGSYM04DTO();

		if( "DISP".equals(mapping.getParameter())){
			
			log.debug("========角色负责人查询画面初期显示处理开始========");
			
			addMessage(request, new ActionMessage("IGCO10000.I003"));

			dto.setUserRoleVWSearchCond(form);
			dto.setRoleid(form.getRoleid());
			dto.setUserInfoSearchCond(form);

			//调用BL查询
			dto = ctlBL.searchUserByRoleTypeNoPage(dto);
			//构造VO
			IGSYM04181VO vo = new IGSYM04181VO(dto.getUserInfoList() , dto.getRole());	
			
			super.<IGSYM04181VO>setVO(request, vo);
			
			log.debug("========角色负责人查询画面初期显示处理终了========");
			
		} else if ("DELETE".equals(mapping.getParameter())) {

			log.debug("========根据角色类型删除用户开始========");
			
			dto.setRoleid(form.getRoleid());
			dto.setUrid(form.getUrids());
			
			//调用BL查询
			ctlBL.deleteRoleUser(dto);

			log.debug("========根据角色类型删除用户结束========");
			
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
