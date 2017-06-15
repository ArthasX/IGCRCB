/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0168Form;
import com.deliverik.infogovernor.prd.form.IGPRD0169Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01681VO;

/**
 * 概述: 自定义流程页面设置 查询/新增Action
 * 功能描述: 自定义流程页面设置 查询/新增Action
 * 创建记录: 20121113
 * 修改记录: 
 */
public class IGPRD0168Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0168Action.class);

	/**
	 * 查询/新增/Action 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		// DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		if ("DISP".equals(mapping.getParameter())) {
			// FORM取得
			IGPRD0168Form form = (IGPRD0168Form) actionForm;
			String pdname=req.getParameter("pdname");
			String pddesc = req.getParameter("pddesc");
//			if(pddesc!=null){
//				pddesc = new String(pddesc.getBytes("iso-8859-1"),"UTF-8"); 
//				form.setPddesc(pddesc);
//			}
//			if(pdname!=null){
//				pdname = new String(pdname.getBytes("iso-8859-1"),"UTF-8"); 
//				form.setPdname(pdname);
//			}

			dto.setIgPRD0168Form(form);
			log.debug("========自定义流程页面设置初始化处理开始========");
			//查询ig126的数据
			dto = ctlBL.searchProcessJspInfoAction(dto);
     		IGPRD01681VO vo = new IGPRD01681VO(dto.getProcessJspInfoList());
     		vo.setIg380info(dto.getIg380info());
            super.<IGPRD01681VO>setVO(req, vo);
            /** 2013-3-11 wanglei 页面设置流程名称及流程说明文字乱码*/
            // 流程说明
            form.setPddesc(dto.getIg380info().getPddesc());
            // 流程名称
            form.setPdname(dto.getIg380info().getPdname());
			addMessage(req, new ActionMessage("IGCO10000.I003"));			
			log.debug("========自定义流程页面设置初始化处理结束========");
		} if ("INSERT".equals(mapping.getParameter())) {
			log.debug("========自定义流程页面设置新增处理开始========");
			IGPRD0169Form form = (IGPRD0169Form) actionForm;
			dto.setIgPRD0169Form(form);
			if (isTokenValid(req, true)){
				dto = ctlBL.insertProcessJspAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========自定义流程页面设置新增处理结束========");
		} else if ("INIT".equals(mapping.getParameter())) {
			log.debug("========自定义流程页面设置新增初始化处理开始========");
			// FORM取得
			IGPRD0168Form form = (IGPRD0168Form) actionForm;
			dto.setIgPRD0168Form(form);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========自定义流程页面设置新增初始化处理结束========");
		}
		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
