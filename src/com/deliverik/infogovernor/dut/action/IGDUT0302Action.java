/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
import com.deliverik.infogovernor.dut.bl.IGDUT03BL;
import com.deliverik.infogovernor.dut.dto.IGDUT03DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0302Form;
import com.deliverik.infogovernor.dut.vo.IGDUT03021VO;

/**
 * 值班情况汇总Action
 */
public class IGDUT0302Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0302Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGDUT0302Form form = (IGDUT0302Form)actionForm;
		
		//BL取得
		IGDUT03BL ctlBL = (IGDUT03BL) getBean("igdut03BL");
		
		//DTO生成
		IGDUT03DTO dto = new IGDUT03DTO();
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//值班查询画面初期显示处理
			log.debug("========值班查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========值班查询画面初期显示处理终了========");
			
			forward = "DISP";
			
			
		} else if("REDISP".equals(mapping.getParameter())){
			
			//值班查询画面再显示处理
			log.debug("========值班查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========值班查询画面再显示处理终了========");
			
			forward = "DISP";
			
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//值班查询处理
			log.debug("========值班查询处理开始========");
			
			//DTO输入参数设定
			dto.setDutyResultSearchCond(form);
			
			//值班信息检索逻辑调用
			dto = ctlBL.searchAllDutyResultAction(dto);
			
			//将值班信息检索结果设定到VO中
			IGDUT03021VO vo = new IGDUT03021VO();
			vo.setDutyResultList(dto.getDutyResultList());
			vo.setDutyPlanAM(dto.getDutyPlanAM());
			vo.setDutyPlanPM(dto.getDutyPlanPM());
			
			super.<IGDUT03021VO>setVO(req, vo);
			
			log.debug("========值班查询处理终了========");
			
			forward = "DISP";
		}else if("UPDATE".equals(mapping.getParameter())){
			
			//值班结果说明修改处理
			log.debug("========值班结果说明修改处理开始========");
			
			//DTO输入参数设定
			dto.setIgDUT0302Form(form);
			
			//值班信息检索逻辑调用
			dto = ctlBL.changeDrresultAction(dto);
			
			log.debug("========值班结果说明修改处理终了========");
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
