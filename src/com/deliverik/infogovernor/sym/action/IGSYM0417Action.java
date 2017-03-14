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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0405Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04051VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_用户管理_根据角色查询用户ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 * @update zhaojun 2010-12-13  原IGSYM0405Action.java 备份文件，对应备份JSP IGSYM0417.jsp
 */
 
public class IGSYM0417Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0405Action.class);
	
	/**
	 * <p>
	 * Description: 用户action处理
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
		IGSYM0405Form form = (IGSYM0405Form)actionForm;
		if(form!=null){
			Integer roleid = form.getRoleida();
			Integer count = form.getFromCount();
			String username = form.getUsername();
			String orgida = form.getOrgida();
			String orgname = form.getOrgname();
			String roletype = form.getRoletype();
			String from_s = form.getFrom_s();
			request.getSession().setAttribute("IGSYM0405Form", null);
			form = new IGSYM0405Form();
			form.setRoleida(roleid);
			form.setFromCount(count);
			form.setUsername(username);
			form.setOrgida(orgida);
			form.setOrgname(orgname);
			form.setRoletype(roletype);
			form.setFrom_s(from_s);
			request.getSession().setAttribute("IGSYM0405Form", form);
			
		}
		//获取BL接口实例
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//实例化DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========用户查询画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========用户查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========用户查询处理开始========");
			//获取分页Bean
			getPaginDTO(request,"IGSYM0405");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
			}else{
				pDto.setFromCount(form.getFromCount());
			}
			
			int maxCnt = getMaxDataCount("IGSYM0405");
			
			dto.setUserInfoSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//调用BL查询
			//====================================================>
			if("Y".equals(form.getFrom_s())){//服务请求选择审批人时的弹出窗口。需要按部门对人员进行过滤
				User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				dto.setOrgid(user.getOrgid());
				dto = ctlBL.searchRoleUserByOrg(dto);
			}else{//其它按正常逻辑处理
				dto = ctlBL.searchRoleUser(dto);
			}
			//<===================================================
			//构造VO
			IGSYM04051VO vo = new IGSYM04051VO(dto.getRoleUserList());	
			super.<IGSYM04051VO>setVO(request, vo);
			log.debug("========用户查询处理终了========");
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
