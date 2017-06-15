/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM20BL;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
import com.deliverik.infogovernor.asset.form.IGASM2006Form;
import com.deliverik.infogovernor.asset.vo.IGASM20061VO;

/**
 * 概述: 导入对象Action处理
 * 功能描述: 导入对象Action处理
 * 创建记录: 2011/05/03
 * 修改记录: 
 */
public class IGASM2006Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2006Action.class);
	
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
		IGASM2006Form form = (IGASM2006Form) actionForm;
		// BL取得
		 IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		// DTO生成
		IGASM20DTO dto = new IGASM20DTO();
		
		// 画面跳转设定
		String forward = null;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========导入对象信息登记初期显示处理开始========");
			dto = ctlBL.getEiImportProgrammeAction(dto);
			req.getSession().setAttribute("ADImpTypeList", dto.getImpTypeList());
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001",resources.getMessage(this.getLocale(req),"message.IGASM2006.001")));
			log.debug("========导入对象信息登记初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		if( "INSERT".equals(mapping.getParameter())){
			//导入对象信息编辑处理
			if (form.getMode().equals("0")){
				//导入对象信息登记处理
				log.debug("========导入对象信息登记处理开始========");
				//DTO输入参数设定
				dto.setIgasm2006Form(form);
				if (isTokenValid(req, true)){
				//导入对象信息登记逻辑调用
				dto = ctlBL.insertImportVersionAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//将登记完了的导入对象信息设定到VO中
				IGASM20061VO vo = new IGASM20061VO(dto.getIgasm2006Form());
				super.<IGASM20061VO>setVO(req.getSession(), vo);
				log.debug("========导入对象信息登记处理终了========");
				forward = "DISP";
			}
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
