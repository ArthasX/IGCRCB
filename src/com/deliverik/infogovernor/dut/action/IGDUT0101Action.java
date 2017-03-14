/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dut.bl.IGDUT01BL;
import com.deliverik.infogovernor.dut.bl.task.DutyAuditTimeBL;
import com.deliverik.infogovernor.dut.dto.IGDUT01DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0101Form;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditTimeSearchCondImpl;



/**
 * 值班检查设定处理Action
 * 
 */
public class IGDUT0101Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDUT0101Action.class);

	/**
	 * 值班检查设定处理
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORM取得
		IGDUT0101Form form = (IGDUT0101Form) actionForm;
		// BL取得
		IGDUT01BL ctlBL = (IGDUT01BL) getBean("igdut01BL");
		// DTO生成
		IGDUT01DTO dto = new IGDUT01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if ("DISP".equals(mapping.getParameter())) {
			// 值班检查设定初期显示处理
			log.debug("========值班检查设定画面初期显示处理开始========");
			form.setDadtype("");
			form.setDadname("");
			form.setDattimes(null);
			form.setDadlimtime("");
			form.setDadcontent("");
			form.setDadinfo("");
			form.setDadorderby(null);

			req.getSession().setAttribute("ADtimelist", new ArrayList<LabelValueBean>());
			addMessage(req, new ActionMessage("IGCO10000.I001", "值班检查设定基本信息"));
			log.debug("========值班检查设定画面初期显示处理终了========");
			saveToken(req);
			return mapping.findForward("DISP");
		} 
		
		String forward = "";
		//机构新增
		if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				// 类型登记处理
				log.debug("========值班检查设定处理开始========");
				// DTO输入参数设定
				dto.setDutyAuditDef(form);
				dto.setIgDUT0101Form(form);

				if (isTokenValid(req, true)) {
					// 类型信息登记逻辑调用
					dto = ctlBL.insertDutyAuditDefAction(dto);
				} else {
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========值班检查设定处理终了========");

				forward = "DISP";
				
			}else {
				//值班检查信息变更处理
				log.debug("========值班检查信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setDutyAuditDef(form);
				dto.setIgDUT0101Form(form);
				
				//值班检查信息变更逻辑调用
				dto = ctlBL.updateDutyAuditDefAction(dto);
				
				log.debug("========值班检查信息变更处理终了========");
				
				forward = "DISP1";

			}
		}
		//变更页面初始化
		if("EDIT".equals(mapping.getParameter())){
			log.debug("========值班检查信息变更初期显示处理开始========");
			form.setMode("1");
			//初始化检查时间
			DutyAuditTimeBL dutyAuditTimeBL = (DutyAuditTimeBL) getBean("dutyAuditTimeBL");
			DutyAuditTimeSearchCondImpl cond  = new DutyAuditTimeSearchCondImpl();
			cond.setDadid(form.getDadid());
			List<DutyAuditTime> ret = dutyAuditTimeBL.searchDutyAuditTime(cond, 0, 0);
			List<LabelValueBean> list = new ArrayList<LabelValueBean>();
			for(DutyAuditTime dat : ret){
				list.add(new LabelValueBean(dat.getDattime(), dat.getDattime()));
			}       
			
			req.getSession().setAttribute("ADtimelist", list);
			
			dto.setIgDUT0101Form(form);
					
			dto = ctlBL.initDutyAuditDef(dto);
			
			forward = "DISP";
			log.debug("========值班检查信息变更初期显示处理终了========");
		
		}

		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}

		}

		return mapping.findForward(forward);
	}
}
