/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.action;

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
import com.deliverik.infogovernor.bl.IGCOM02BL;
import com.deliverik.infogovernor.dto.IGCOM02DTO;
import com.deliverik.infogovernor.form.IGCOM0215Form;
import com.deliverik.infogovernor.vo.IGCOM02151VO;

/**
 * 统计分析-报表列表画面用Action处理
 *
 */
public class IGCOM0215Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0215Action.class);
	
	/**
	 * 统计分析-报表列表画面用Action处理
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

		//Session清除
		clearSessionFormData(req);
		
		//FORM取得
		IGCOM0215Form form = (IGCOM0215Form)actionForm;
		
		//BL取得
		IGCOM02BL ctlBL = (IGCOM02BL) getBean("igcom02BL");
		
		//DTO生成
		IGCOM02DTO dto = new IGCOM02DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			//Session清除
			clearSessionFormData(req);
			
			
			dto.setReportFileDefinitionSearchCond(form);
			
			//获取User信息
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//报表分类树查询处理
			dto = ctlBL.searchReportFileDefinitionAction(dto);
			
			IGCOM02151VO vo = new IGCOM02151VO(dto.getReportFileDefinitionList(), dto.getCompleteNodeName());
			
			super.<IGCOM02151VO>setVO(req, vo);
			
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
		}
		
		
		return mapping.findForward("DISP");
		
	}

}
