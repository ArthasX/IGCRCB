/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.iam.action;

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
import com.deliverik.infogovernor.iam.bl.IGIAM03BL;
import com.deliverik.infogovernor.iam.dto.IGIAM03DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0303Form;
import com.deliverik.infogovernor.iam.vo.IGIAM01011VO;
import com.deliverik.infogovernor.iam.vo.IGIAM03011VO;

/**
 * 概述:提供对审计报告信息的增删改查
 * 功能描述：提供对审计报告信息的增删改查
 * 创建人：惠涌智
 * 创建记录： 2012-8-10
 * 修改记录：
 */
public class IGIAM0303Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0303Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取Form类
		IGIAM0303Form igiamForm = (IGIAM0303Form)form ;
		// 获取业务逻辑BL
		IGIAM03BL iam03BL = (IGIAM03BL) getBean("igiam03bl");
		// 声明DTO
		IGIAM03DTO igiam03DTO = new IGIAM03DTO();
		// 获取当前登录用户
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if("TOUPDATE".equals(mapping.getParameter())){
			log.debug("========跳转到审计报告查看页面========");
			//将form封装到dto中
			igiam03DTO.setIgiam0303Form(igiamForm);
			//调用业务方法执行主键查询操作
			igiam03DTO = iam03BL.dsearchIAMAction(igiam03DTO);
			//form重新赋值
			igiamForm = igiam03DTO.getIgiam0303Form();
			//初始化VO
			IGIAM03011VO vo = new IGIAM03011VO();
			//将附件List封装到VO中
			vo.setAttkeyList(igiam03DTO.getAttkeyList());
			//返回VO
			super.<IGIAM03011VO>setVO(request, vo);
			log.debug("========跳转到审计报告查看页面结束========");
		}
		//内审项目修改
		if ("UPDATE".equals(mapping.getParameter())) {
			log.debug("========审计报告保存修改========");
			//将form封装到dto中
			igiam03DTO.setIgiam0303Form(igiamForm);
			//调用业务方法进行更新操作
			igiam03DTO = iam03BL.updateIAMAction(igiam03DTO);
			log.debug("========审计报告保存修改结束========");
		}
		if("DELETE".equals(mapping.getParameter())){
			//执行删除操作
			log.debug("========审计报告删除处理开始========");
			//获取要删除审计报告信息的主键
			String apids = request.getParameter("apids");
			igiam03DTO.setApids(apids);
			//调用删除业务逻辑方法
			iam03BL.deleteIAMAction(igiam03DTO);
			log.debug("========审计报告删除处理结束========");
		}
		List<ActionMessage> messageList = igiam03DTO.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
