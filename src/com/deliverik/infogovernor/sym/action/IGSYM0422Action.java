/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import org.hyperic.hq.hqapi1.GroupApi;
import org.hyperic.hq.hqapi1.HQApi;
import org.hyperic.hq.hqapi1.RoleApi;
import org.hyperic.hq.hqapi1.types.Group;
import org.hyperic.hq.hqapi1.types.Role;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0422Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04221VO;
import com.deliverik.infogovernor.util.StringEncrypt;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_资源组授权授权
 * </p>
 * 
 * @author lujiayuan 2012/11/15
 * @version 1.0
 */

public class IGSYM0422Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0422Action.class);
	
	/**
	 * <p>
	 * Description: 资源组授权action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author lujiayuan
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		IGSYM0422Form form = (IGSYM0422Form)actionForm;
		
		//实例化DTO
		IGSYM04DTO dto = new IGSYM04DTO(); 
		
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		//提取相应的配置信息
		String HQServerIP = codeListUtils.getCodeValue("160", null, null, "1");
		Integer HQServerPort = new Integer(codeListUtils.getCodeValue("160", null, null, "2"));
		String HQServerUsername = codeListUtils.getCodeValue("160", null, null, "3");
		String HQServerPassword = StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4"));
		String useFlg = codeListUtils.getCodeValue("160", null, null, "5");
		
		HQApi api = new HQApi(HQServerIP, HQServerPort, false, HQServerUsername, HQServerPassword);
		RoleApi roleApi = api.getRoleApi();
		GroupApi groupApi = api.getGroupApi();

		if("DISP".equals(mapping.getParameter())){
			log.debug("========资源组授权授权画面初期显示处理开始========");
			saveToken(request);
			
			String hqRoleid = request.getParameter("roleid");
			
			Role role = roleApi.getRole(Integer.parseInt(hqRoleid)).getRole();
				
			form.setRoleid(role.getId().toString());
			form.setRolename(role.getName());
			
			List<Group> groupList = groupApi.getGroups().getGroup();
			//所有该角色相关的资源组关系
			List<Group> groupRoleList = groupApi.getGroups(role).getGroup();
			//未授权的资源组默认是所有资源组
			List<Group> groupUnList = groupList;
			if(groupRoleList.size() > 0){//remove已授权的资源组
				for(int i = 0;i<groupRoleList.size();i++){
					for(int j=0;j<groupUnList.size();j++){
						if(groupUnList.get(j).getId().equals(groupRoleList.get(i).getId())){
							groupUnList.remove(j);
							break;
						}
					}
				}
			}
			//构造VO
			IGSYM04221VO vo = new IGSYM04221VO(groupRoleList,groupUnList);
			super.<IGSYM04221VO>setVO(request, vo);
			
			log.debug("========资源组授权授权画面初期显示处理终了========");
		}
		//资源组授权授权
		if ("GRANT".equals(mapping.getParameter())){
			if("0".equals(useFlg)||StringUtils.isEmpty(useFlg)){
				addMessage(request, new ActionMessage("IGCO10000.E029","资源组角色关系"));
				return mapping.findForward("DISP");
			}
			String mode = request.getParameter("mode");
			String hqRoleid = form.getRoleid();
			//删除用户角色
			if("0".equals(mode)){
				log.debug("========资源组删除授权处理开始========");
				
				String[] ids_del = form.getIds_del();
				for(String id : ids_del){//循环删除组与角色的关系
					Group group = groupApi.getGroup(Integer.parseInt(id)).getGroup();
					
					for(int i=0;i<group.getRole().size();i++){
						if(group.getRole().get(i).getId().equals(Integer.parseInt(hqRoleid))){
							group.getRole().remove(i);
						}
					}
					groupApi.updateGroup(group);
				}
				addMessage(request, new ActionMessage("IGSYM0422.I001","删除"));
				
				log.debug("========资源组删除授权处理终了========");
			}else{//添加用户角色
				log.debug("========资源组添加授权处理开始========");
				
				if (isTokenValid(request, true)){
					Role role = roleApi.getRole(Integer.parseInt(hqRoleid)).getRole();//获取当前角色
					
					String[] ids_add = form.getIds_add();
					for(String id : ids_add){//循环添加组与角色的关系
						Group group = groupApi.getGroup(Integer.parseInt(id)).getGroup();
						
						group.getRole().add(role);
						groupApi.updateGroup(group);
					}
					addMessage(request, new ActionMessage("IGSYM0422.I001","添加"));
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				log.debug("========资源组添加授权处理终了========");
			}
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