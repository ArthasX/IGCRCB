/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.action;

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
import com.deliverik.infogovernor.dwp.bl.IGDWP01BL;
import com.deliverik.infogovernor.dwp.dto.IGDWP01DTO;
import com.deliverik.infogovernor.dwp.form.IGDWP0105Form;
import com.deliverik.infogovernor.dwp.util.IGDWPUtils;
import com.deliverik.infogovernor.dwp.vo.IGDWP01051VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 保存流程信息Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0105Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGDWP0105Action.class);
		//BL取得
		IGDWP01BL ctlBL = (IGDWP01BL) getBean("igdwp01BL");
		//实例化dto
		IGDWP01DTO dto = new IGDWP01DTO();
		//登录用户取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//Form取得
		IGDWP0105Form form = (IGDWP0105Form) actionForm;
		//dto参数设定
		dto.setUser(user);
		dto.setForm(actionForm);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============保存流程信息页面初始化操作开始=================");
			dto = ctlBL.initProcessDefinitionAction(dto);
			//实例化vo
			IGDWP01051VO vo = new IGDWP01051VO();
			vo.setPlan(dto.getPlan());
			vo.setProcessDefinition(dto.getProcessDefinition());
			vo.setLabelValueBeanList(dto.getLabelValueBeanList());
			vo.setPtdInfo(dto.getPtdInfo());
			vo.setProcessInfoList(dto.getProcessInfoList());
			vo.setProcessStatusDef(dto.getProcessStatusDef());
			super.setVO(request, vo);
			saveToken(request);
			log.debug("==============保存流程信息页面初始化操作结束=================");
		}
		//策略流程登记操作
		if("INSERT".equals(mapping.getParameter())){
			log.debug("=============策略流程登记操作开始===============");
			if (isTokenValid(request, true)){
				dto = ctlBL.craeteProcessAction(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("=============策略流程登记操作结束===============");
			//如果需要分派，调整到分派页面
			if(IGDWPUtils.ASSIGN_FLAG_YES.equals(dto.getAssignFlag())){
				return new ActionForward("/IGDWP0106_Disp.do?planid=" + form.getId() + "&prid=" + dto.getProcess().getId(),true);
			}
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