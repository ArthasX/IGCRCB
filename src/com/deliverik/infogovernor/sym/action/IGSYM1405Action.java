/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM14BL;
import com.deliverik.infogovernor.sym.dto.IGSYM14DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1405Form;
import com.deliverik.infogovernor.sym.vo.IGSYM14051VO;

/**
 * 报表版本列表画面Action处理
 *
 */
public class IGSYM1405Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1405Action.class);

	/**
	 * Action处理
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
		IGSYM1405Form form = (IGSYM1405Form)actionForm;
		
		//BL取得
		IGSYM14BL ctlBL = (IGSYM14BL) getBean("igSYM14BL");
		
		//DTO生成
		IGSYM14DTO dto = new IGSYM14DTO();
		
		//跳转
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			//报表版本列表画面初期显示处理
			log.debug("========报表版本列表画面初期显示处理开始========");
			
			dto.setReportFileVersionSearchCond(form);
			
			ctlBL.searchReportFileVersionAction(dto);
			
			//设定VO
			IGSYM14051VO vo = new IGSYM14051VO(dto.getReportFileDefinition(), dto.getReportFileVersionList());
			
			super.<IGSYM14051VO>setVO(req, vo);
			
			log.debug("========报表版本列表画面初期显示处理终了========");
			
		} else if( "ASSIGN".equals(mapping.getParameter())){
			//报表指定版本处理
			log.debug("========报表指定版本处理开始========");
			
			dto.setRfvid(form.getRfvid());
			
			ctlBL.assignCurrentReportFileVersionAction(dto);
			
			log.debug("========报表指定版本处理终了========");
			
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
