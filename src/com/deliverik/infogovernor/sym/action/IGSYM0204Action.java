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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.adapter.CodeDefinition;
import com.deliverik.infogovernor.sym.bl.IGSYM02BL;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM02DTO;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0202Form;
import com.deliverik.infogovernor.sym.form.IGSYM0402Form;
import com.deliverik.infogovernor.sym.vo.IGSYM02041VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_用户管理_修改ACTION
 * </p>
 * 
 * @author duchong@deliverik.com
 * @version 1.0
 */

public class IGSYM0204Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0204Action.class);
	private boolean flag = true;
	/**
	 * <p>
	 * Description: 用户信息修改action处理
	 * </p>
	 * 
	 * @author duchong@deliverik.com
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		flag = true;
		//实例化FORM
		IGSYM0202Form form = (IGSYM0202Form)actionForm;	
		
		//判断登陆方式
		String loginType = "";//登陆方式
		String localuser = "";//本地登陆用户组
		User nowUser = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		String userid = nowUser.getUserid();
		CodeListUtils codeListUtils = (CodeListUtils)getBean("codeListUtils");
		loginType = codeListUtils.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_AUTHORIZATIONTYPE);
		localuser = codeListUtils.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_LOCALORIZATIONTYPE);
		for(int i=0,j=localuser.split(",").length;i<j;i++){
			String localUserId =  localuser.split(",")[i];
			if(null!=localUserId && userid.equals(localUserId)){
				flag = false;
			}
		}
		if("1".equals(loginType) && flag){
			form.setLoginType(loginType);
		}else{
			form.setLoginType("0");
		}
		
		//form.setLoginType(loginType);
		
		
		//获取BL接口实例
		IGSYM02BL ctlBL = (IGSYM02BL) getBean("igsym02BL");
		//实例化DTO
		IGSYM02DTO dto = new IGSYM02DTO();
		dto = ctlBL.searchOrganizationAll(dto);

		//用户信息初始化
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========用户变更初期显示处理开始========");
			
			//取得当前USER
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			//获取BL接口实例
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//实例化DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			
			//角色授权查询
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//调用BL查询
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			/*List<UserRoleInfo> ownRoleList = dto04.getOwnRoleList();
			String ownRoleName = "";
			for(int i=0,j=ownRoleList.size();i<j;i++){
				if(i>0){
					ownRoleName+=",";
				}
				ownRoleName+=ownRoleList.get(i).getRolename();
			}*/
			
			//List<Organization> list = dto.getOrganizationList();
			//List<LabelValueBean> organizationList = new ArrayList<LabelValueBean>();
			//organizationList.add(new LabelValueBean("", ""));
			//for(Iterator<Organization> iter = list.iterator();iter.hasNext();){
				//Organization organization = iter.next();
				//if(orgid==organization.getOrgid()){
					//orgname=organization.getOrgname();
				//}
				//organizationList.add(new LabelValueBean(organization.getOrgname(), organization.getOrgid().toString()));
			//}
			//request.setAttribute("organizationList", organizationList);
			form.setUserid(user.getUserid());
			form.setOrgname(user.getOrgname());
			//form.setUserrolename(ownRoleName);
			
			dto.setIgsym0202Form(form);
			dto = ctlBL.initIGSYM0202Action(dto);
			//构造VO
			IGSYM02041VO vo = new IGSYM02041VO();
			vo.setManagerMap(dto04.getManagerMap());
			vo.setRoleMap(dto04.getRoleMap());
			vo.setMobileMap(dto04.getMobileMap());
			super.<IGSYM02041VO>setVO(request.getSession(), vo);
			
			if(dto04.getManagerMap()!=null) {
				form.setRolemanager(new String[dto04.getManagerMap().size()]);
				form.setRolemobile(new String[dto04.getManagerMap().size()]);
				form.setMobile(new String[dto04.getManagerMap().size()]);
				form.setRoleid(new String[dto04.getManagerMap().size()]);
			}
			
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			log.debug("========用户变更初期显示处理终了========");
			//request.setAttribute("edit_status","edit");
			return mapping.findForward("DISP");
		}
		
		//用户信息修改
		if( "UPDATE".equals(mapping.getParameter())){
			
			//信息变更
			log.debug("========用户变更修改处理开始========");
			dto.setUser(form);
			dto.setIgsym0202Form(form);
			//调用BL变更
			dto = ctlBL.updateUserManagerAction(dto);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			log.debug("========用户变更修改处理终了========");
			//request.setAttribute("edit_status","success");
			return mapping.findForward("DISP");
			
		}
		
		
		return mapping.findForward("DISP");
	}
	
}
