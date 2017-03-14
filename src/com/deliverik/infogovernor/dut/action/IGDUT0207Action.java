/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.dut.action;

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
import com.deliverik.infogovernor.dut.bl.IGDUT02BL;
import com.deliverik.infogovernor.dut.dto.IGDUT02DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0207Form;
import com.deliverik.infogovernor.dut.vo.IGDUT02071VO;

/**
 * 值班中止详细画面Action处理
 *
 */
public class IGDUT0207Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0207Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGDUT0207Form form = (IGDUT0207Form)actionForm;
		
		//BL取得
		IGDUT02BL ctlBL = (IGDUT02BL) getBean("igdut02BL");
		
		//DTO生成
		IGDUT02DTO dto = new IGDUT02DTO();
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//值班中止详细画面初期显示处理
			log.debug("========值班中止详细画面初期显示处理开始========");
			
			dto.setDutyPlanSearchCond(form);
			dto.setUser((User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER));
			dto.setIgDUT0207Form(form);
			//值班中止详细画面初期显示逻辑调用
			dto = ctlBL.initIGDUT0207Action(dto);
			
			//将值班中止详细结果设定到VO中
			IGDUT02071VO vo = new IGDUT02071VO();
			vo.setDutyResultList(dto.getDutyResultList());
			vo.setDutyPlan(dto.getDutyPlan());
			vo.setUsersinfo(dto.getUsersinfo());
			if(vo.getDutyPlan() != null) {
				form.setDpid_executing(vo.getDutyPlan().getDpid());//交班计划ID
			}
			super.<IGDUT02071VO>setVO(req.getSession(), vo);
			log.debug("========值班中止详细画面初期显示处理终了========");
			saveToken(req);
			forward = "DISP";
		} else if( "TERMINATE".equals(mapping.getParameter())){
			//值班交接确认画面初期显示处理
			log.debug("========值班交接确认处理开始========");
			dto.setIgDUT0207Form(form);
			dto.setUser((User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER));
			if (isTokenValid(req, true)){
					//值班交接确认画面初期显示逻辑调用
					dto = ctlBL.terminateIGDUT0207Action(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			
			log.debug("========值班交接确认处理终了========");
			forward = "DISP";
		}
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		
		return mapping.findForward(forward);
	}
}
