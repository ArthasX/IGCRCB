/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;


import java.util.ArrayList;
import java.util.HashMap;
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
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0410Form;
import com.deliverik.infogovernor.sym.model.RoleReport;
import com.deliverik.infogovernor.sym.vo.IGSYM04101VO;

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

public class IGSYM0410Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0410Action.class);
	
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
		IGSYM0410Form form = (IGSYM0410Form)actionForm;
		//获取BL接口实例
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//实例化DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		if ("SEARCH".equals(mapping.getParameter())){
			//报表授权查询
			log.debug("========报表授权查询处理开始========");
			saveToken(request);				
			
			dto.setIgSYM0410Form(form);
			dto = ctlBL.roleReportFileDefinitionAction(dto);
			//调用BL查询
			dto = ctlBL.searchRoleReportAction(dto);
			//过滤已授权角色，暂时这样处理
			
			List<Role> roleList = dto.getRoleList();
			List<Role> yroleList = new ArrayList<Role>();
			List<RoleReport> ownRoleList = dto.getRoleReportList();

			for(int i=0;i<ownRoleList.size();i++){
				for(int j=0;j<roleList.size();j++){
					if(ownRoleList.get(i).getRoleid().equals(roleList.get(j).getRoleid())){
						yroleList.add(roleList.get(j));
						roleList.remove(j);
						break;
					}
				}
			}

			//构造VO
			IGSYM04101VO vo = new IGSYM04101VO(roleList,yroleList);
			vo.setRoleMap(this.getRoleMap(roleList));
			super.<IGSYM04101VO>setVO(request, vo);

			log.debug("========报表授权查询处理终了========");
			return mapping.findForward("DISP");
		}
		//角色授权
		if ("GRANT".equals(mapping.getParameter())){
			log.debug("========报表授权处理开始========");
			//删除报表角色
			if("0".equals(form.getMode())){
				dto.setRoleids(form.getRoleidy());
				dto.setRfdid(form.getRfdid());
				ctlBL.revokeRoleReportAction(dto);
				addMessage(request, new ActionMessage("IGSYM0410.I002"));
			}else{//添加报表角色
				dto.setRoleids(form.getRoleids());
				dto.setRfdid(form.getRfdid());
				ctlBL.grantRoleReportAction(dto);
				addMessage(request, new ActionMessage("IGSYM0410.I001"));		
			}

			log.debug("========报表授权处理终了========");
		}
		return mapping.findForward("DISP");
	}

	public  Map<String,List<Role>> getRoleMap(List<Role> roleList){
    	if(roleList.size() == 0){
    		return null;
    	}
    	Map<String,List<Role>> retMap = new HashMap<String, List<Role>>();
    	for (Role role : roleList) {
    		String roleType = role.getRoletype();
    		if(!retMap.containsKey(roleType)){
    			retMap.put(roleType, new ArrayList<Role>());
    		}
    		retMap.get(roleType).add(role);
		}
    	return retMap;
    }

}
