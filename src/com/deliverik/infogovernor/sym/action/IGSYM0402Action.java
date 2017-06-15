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
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0402Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04021VO;
import com.deliverik.infogovernor.util.PRJHelper;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_角色授权ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0402Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0402Action.class);
	
	/**
	 * <p>
	 * Description: 角色授权action处理
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
		IGSYM0402Form form = (IGSYM0402Form)actionForm;
		//获取BL接口实例
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//实例化DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		if ("SEARCH".equals(mapping.getParameter())){
			//角色授权查询
			log.debug("========角色授权查询处理开始========");
			saveToken(request);
			String flag = request.getParameter("flag");
			if(flag == null){
				//String orgname = new String(request.getParameter("orgname").getBytes("iso-8859-1"),"UTF-8");
				//String username = new String(request.getParameter("username").getBytes("iso-8859-1"),"UTF-8");
				//form.setOrgname(orgname);
				//form.setUsername(username);
				dto.setUserid(request.getParameter("userid"));
				dto.setOrgid(request.getParameter("orgid"));
			}
		
			
			dto.setUserRoleVWSearchCond(form);
			//调用BL查询
			dto = ctlBL.searchUserRoleAction(dto);
			//过滤已授权角色，暂时这样处理
			if(flag == null){
				form.setOrgname(dto.getOrgname());
				form.setUsername(dto.getUsername());
			}
			
			List<Role> roleList = dto.getRoleList();
			List<UserRoleInfo> ownRoleList = dto.getOwnRoleList();
			for(int i=0;i<ownRoleList.size();i++){
				for(int j=0;j<roleList.size();j++){
					if(ownRoleList.get(i).getRoleid().equals(roleList.get(j).getRoleid())){
						roleList.remove(j);
						break;
					}
				}
			}
			//构造VO
			IGSYM04021VO vo = new IGSYM04021VO(roleList,ownRoleList);
			vo.setRoleMap(PRJHelper.getRoleMap(roleList));
			super.<IGSYM04021VO>setVO(request, vo);

			log.debug("========角色授权查询处理终了========");
			return mapping.findForward("DISP");
		}
		//角色授权
		if ("GRANT".equals(mapping.getParameter())){
			log.debug("========角色授权处理开始========");
			//删除用户角色
			if("0".equals(form.getMode())){
				dto.setUrid(form.getUrid());
				ctlBL.revokeUserRoleAction(dto);
			}else{//添加用户角色
				if (isTokenValid(request, true)){
					dto.setRoleids(form.getRoleids());
					dto.setUserid(form.getUserid());
					dto.setOrgid(form.getOrgid());
					ctlBL.grantUserRoleAction(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}

			log.debug("========角色授权处理终了========");
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
