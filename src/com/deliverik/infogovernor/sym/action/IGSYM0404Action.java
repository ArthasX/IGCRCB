/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
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
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0404Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04041VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_菜单授权ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0404Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0404Action.class);
	
	/**
	 * <p>
	 * Description: 菜单授权action处理
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
		IGSYM0404Form form = (IGSYM0404Form)actionForm;
		//获取BL接口实例
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//实例化DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		if ("SEARCH".equals(mapping.getParameter())){
			//菜单授权查询
			log.debug("========菜单授权查询处理开始========");
			
			
			String flag = request.getParameter("flag");
			if(flag == null){
				//String rolename = new String(request.getParameter("rolename").getBytes("iso-8859-1"),"UTF-8");
				//form.setRolename(rolename);
				dto.setRoleid(Integer.valueOf(request.getParameter("roleid")));
			}
			
			if(form.getRoleid() != null && form.getRoleid() != 0) {
				dto.setRoleid(form.getRoleid());
			}
			
			dto.setRoleActionSearchCond(form);
			//调用BL查询
			dto = ctlBL.searchRoleActionAction(dto);
			
			if(flag == null){
				form.setRolename(dto.getRolename());
			}
			//选中已授权菜单
			List<RoleAction> roleActionList = dto.getRoleActionList();
			String[] actidArray = new String[roleActionList.size()];
			for(int i=0;i<roleActionList.size();i++){
				actidArray[i] = roleActionList.get(i).getActname();
			}
			form.setActionids(actidArray);
			saveToken(request);
			//构造VO
			IGSYM04041VO vo = new IGSYM04041VO(dto.getActionList());
			super.<IGSYM04041VO>setVO(request, vo);

			log.debug("========菜单授权查询处理终了========");
		}
		//菜单授权先删除原有的再添加
		if ("GRANT".equals(mapping.getParameter())){
				log.debug("========菜单授权处理开始========");
				dto.setActionids(form.getActionids());
				dto.setRoleid(form.getRoleid());
				
				if (isTokenValid(request, true)){
					//调用BL发起
					ctlBL.roleActionAction(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				log.debug("========菜单授权处理终了========");
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
