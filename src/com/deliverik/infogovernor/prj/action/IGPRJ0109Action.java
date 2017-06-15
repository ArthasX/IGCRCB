/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prj.bl.IGPRJ01BL;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;
import com.deliverik.infogovernor.prj.form.IGPRJ0109Form;
import com.deliverik.infogovernor.prj.vo.IGPRJ01091VO;


/**
 * 概述: 
 * 功能描述：
 * 创建人：赵敏
 * 创建记录： 2012-4-25
 * 修改记录：
 */
public class IGPRJ0109Action extends BaseAction {

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		// BL取得
		IGPRJ01BL prjBL = (IGPRJ01BL) getBean("igprj01BL");
		IGPRJ01DTO dto = new IGPRJ01DTO();
		IGPRJ0109Form form = (IGPRJ0109Form)actionForm;
		 if ("EDIT".equals(mapping.getParameter())) {
				//项目编辑处理开始
				String projectId = req.getParameter("pid");
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				dto.setProjectId(projectId);
				dto.setUser(user);
				dto.setIgPrj0109Form(form);
				dto = prjBL.selectProject(dto);
				IGPRJ01091VO vo = new IGPRJ01091VO();
				vo.setPbsummaryList(dto.getPbsummaryList());
				super.<IGPRJ01091VO>setVO(req, vo);
				//项目编辑处理结束
			}else if ("UPDATE".equals(mapping.getParameter())) {
				//项目更新处理开始
				
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				dto.setIgPrj0109Form(form);
				dto.setUser(user);
				dto = prjBL.updateProject(dto);
				
				//项目更新处理结束
			}
		 	//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
		 return mapping.findForward("DISP");
	}

}
