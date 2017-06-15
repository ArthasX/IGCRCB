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
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0412Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04121VO;

/**
 * 报表版本列表画面Action处理
 *
 */
public class IGSYM0412Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM0412Action.class);

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
		IGSYM0412Form form = (IGSYM0412Form)actionForm;
		
		//BL取得
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		
		//DTO生成
		IGSYM04DTO dto = new IGSYM04DTO();
		
		//跳转
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			//报表版本列表画面初期显示处理
			log.debug("========报表版本列表画面初期显示处理开始========");
			
			dto.setReportFileVersionSearchCond(form);
			
			ctlBL.searchReportFileVersionAction(dto);
			
			//设定VO
			IGSYM04121VO vo = new IGSYM04121VO(dto.getReportFileDefinition(), dto.getReportFileVersionList());
			
			super.<IGSYM04121VO>setVO(req, vo);
			
			log.debug("========报表版本列表画面初期显示处理终了========");
			
		} else if( "ASSIGN".equals(mapping.getParameter())){
			//报表指定版本处理
//			log.debug("========报表指定版本处理开始========");
//			
//			dto.setRfvid(form.getRfvid());
//			
//			ctlBL.assignCurrentReportFileVersionAction(dto);
//			
//			log.debug("========报表指定版本处理终了========");
			
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
