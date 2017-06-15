/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.action;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM01BL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0115Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BaseAction;



/**
 * 模块：后勤管理-接待管理
 * 说明：外出就餐登记Action
 * 作者：唐晓娜 
 */
public class IGLOM0115Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0115Action.class);
	
	String forward = "";

	/**
	 * 外出就餐登记
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
		// 接待登记FORM取得
		IGLOM0115Form form = (IGLOM0115Form) actionForm;
		//接待管理form去得
		
//		// BL取得
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		// DTO生成
		IGLOM01DTO dto = new IGLOM01DTO();
//		// 下拉菜单
		req.setAttribute("recption_rscale", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSCALE));
		req.setAttribute("recption_status", LOMHelper.getItemsCodes(CodeUtils.RECPTION_STATUS));
		req.setAttribute("recption_rstandard", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSTANDARD));
		// 外出就餐登记画面显示
		if ("deal".equals(mapping.getParameter())) {
			
			
			log.debug("========外出就餐登记初期显示处理开始========");

			addMessage(req, new ActionMessage("IGCO10000.I001", "外出就餐登记基本信息"));
			
			log.debug("========外出就餐登记初期显示处理终了========");
			saveToken(req);
			
			forward = "deal";
			//外出就餐登记信息插入
		}else if( "INSERT".equals(mapping.getParameter())){
			//mode=0是新增信息处理，mode=1是外出就餐登记信息变更处理
			if(form.getMode().equals("0")){
				//将form传递给dto封装
				dto.setDeal(form);
				//设置form
				dto.setIglom0115Form(form);
				if (isTokenValid(req, true)) {
					dto = ctlBL.insetDealInfo(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				forward="insert-over";
			}else {
				//接待信息变更处理
				log.debug("========外出就餐信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setDeal(form);
				dto.setIglom0115Form(form);

				if (isTokenValid(req, true)) {
					
					//接待信息变更逻辑调用
					dto = ctlBL.updateDealAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				log.debug("========外出就餐信息变更处理终了========");
				
				forward = "DISP1";

			}
			
		}
		//外出就餐管理信息跳转初始化
		else if("view-init".equals(mapping.getParameter())){
			addMessage(req, new ActionMessage("IGCO10000.I001", "外出就餐管理信息"));
			saveToken(req);
			forward = "dealmanagerinit";
		}
		//变更页面初始化
		if("EDIT".equals(mapping.getParameter())){
			
			log.debug("========接待信息变更初期显示处理开始========");
			form.setMode("1");
			
			dto.setIglom0115Form(form);

			dto = ctlBL.initDeal(dto);
			forward = "DISP";
			log.debug("========接待信息变更初期显示处理终了========");
		
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
