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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0206Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02061VO;

/**
 * 概述: 导入对象Action处理
 * 功能描述: 导入对象Action处理
 * 创建记录: 2011/05/03
 * 修改记录: 
 */
public class IGCIM0206Action extends BaseAction{
	static Log log = LogFactory.getLog(IGCIM0206Action.class);
	
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
		IGCIM0206Form form = (IGCIM0206Form) actionForm;
		// BL取得
		 IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		// DTO生成
		IGCIM02DTO dto = new IGCIM02DTO();
		dto.setLocale(this.getLocale(req));
		// 画面跳转设定
		String forward = null;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========导入对象信息登记初期显示处理开始========");
			dto = ctlBL.getEiImportProgrammeAction(dto);
			req.getSession().setAttribute("ADImpTypeList", dto.getImpTypeList());
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001",resources.getMessage(this.getLocale(req),"message.IGCIM0206.001")));
			log.debug("========导入对象信息登记初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		if( "INSERT".equals(mapping.getParameter())){
			//导入对象信息编辑处理
			if (form.getMode().equals("0")){
				//导入对象信息登记处理
				log.debug("========导入对象信息登记处理开始========");
				//DTO输入参数设定
				dto.setIgcim0206Form(form);
				if (isTokenValid(req, true)){
				//导入对象信息登记逻辑调用
				dto = ctlBL.insertImportVersionAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//将登记完了的导入对象信息设定到VO中
				IGCIM02061VO vo = new IGCIM02061VO(dto.getIgcim0206Form());
				super.<IGCIM02061VO>setVO(req.getSession(), vo);
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
