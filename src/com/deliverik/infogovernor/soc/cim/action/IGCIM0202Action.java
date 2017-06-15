/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.action;


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
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0202Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02021VO;

/**
 * 概述: 资产域定义Action处理
 * 功能描述: 资产域定义Action处理
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
public class IGCIM0202Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCIM0202Action.class);

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
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORM取得
		IGCIM0202Form form = (IGCIM0202Form) actionForm;
		// BL取得
		 IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		// DTO生成
		IGCIM02DTO dto = new IGCIM02DTO();
		dto.setLocale(this.getLocale(req));
		// 画面跳转设定
		String forward = null;

		if ("DISP".equals(mapping.getParameter())) {
			// 资产域定义登记画面初期显示处理
			log.debug("========资产域定义登记画面初期显示处理========");
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001", "资产域定义基本信息"));
			log.debug("========资产域定义登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if("REDISP".equals(mapping.getParameter())){
			//资产域定义登记画面再显示处理
			log.debug("========资产域定义登记画面再显示处理开始========");
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========资产域定义登记画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	
		if( "INSERT".equals(mapping.getParameter())){
			//资产域定义编辑处理
			if (form.getMode().equals("0")){
				//资产域定义登记处理
				log.debug("========资产域定义登记处理开始========");
				String date = IGStringUtils.getCurrentDateTime();
				form.setCreatetime(date);
				form.setUpdatetime(date);
				//DTO输入参数设定
				dto.setIgcim0202Form(form);
				if (isTokenValid(req, true)){
				//资产域定义信息登记逻辑调用
				dto = ctlBL.insertEiDomainDefAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//将登记完了的资产域定义信息设定到VO中
				IGCIM02021VO vo = new IGCIM02021VO(dto.getIgcim0202Form());
				super.<IGCIM02021VO>setVO(req.getSession(), vo);
				log.debug("========资产域定义登记处理终了========");
				forward = "DISP";
			}else{
				//资产域定义变更处理
				log.debug("========资产域定义修改处理开始========");
				String date=IGStringUtils.getCurrentDateTime();
				form.setUpdatetime(date);
				dto.setIgcim0202Form(form);
				dto = ctlBL.updateEiDomainDefAction(dto);
				log.debug("========资产域定义登记处理终了========");
				forward = "DETAIL";
			}
		}
		//变更页面初始化
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========资产域定义初期显示处理开始========");
			dto.setIgcim0202Form(form);
			dto = ctlBL.initIGCIM0202Action(dto);
			log.debug("========资产域定义初期显示处理终了========");
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
