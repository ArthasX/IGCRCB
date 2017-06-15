/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import com.deliverik.infogovernor.prr.form.IGPRR0122Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程参与人信息Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0122Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志信息取得
		Log log = LogFactory.getLog(IGPRR0122Action.class);
		//BL取得
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		//实例化dto
		IGPRR01DTO dto = new IGPRR01DTO();
		//form取得
		IGPRR0122Form form = (IGPRR0122Form) actionForm;
		//页面信息初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============流程参与人信息初始化操作开始=================");
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto.setPrid(form.getPrid());
			dto = ctlBL.searchParticipantInfoActon(dto);
			User authorizeuser = dto.getAuthorizeuser();
			//授权模式下，将代理人信息，添加到画面上
            if(authorizeuser != null){
            	String personinfo = dto.getStatus();
            	personinfo = personinfo.replace(authorizeuser.getUsername(), authorizeuser.getUsername() + " 当前的代理人【" +user.getUsername()+"】" );
            	request.setAttribute("personinfo", personinfo);
            }else{
            	request.setAttribute("personinfo", dto.getStatus());
            }
			log.debug("==============流程参与人信息初始化操作结束=================");
		}
		
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		} 
		return mapping.findForward("DISP");
	}

}
