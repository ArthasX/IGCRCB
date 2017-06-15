package com.deliverik.infogovernor.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.form.IGCOM0322Form;

/**
 * 配置详细信息画面Action处理
 *
 */
public class IGCOM0322Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0322Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String forword = "DISP";
		//FORM取得
		IGCOM0322Form form = (IGCOM0322Form)actionForm;
		
		//BL取得
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		//DTO生成
		IGCOM03DTO dto = new IGCOM03DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
	     if( "RELATION".equals(mapping.getParameter())){
		
				log.debug("========EMC存储图显示处理开始========");
				
				//查询记录最大件数取得
				int maxCnt = getMaxDataCount("IGCOM0303");
		
				dto.setIgcom0322Form(form);
				
				dto.setMaxSearchCount(maxCnt);
				
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				dto.setUser(user);
				
				//配置详细信息画面初期显示逻辑调用
				dto = ctlBL.initIGCOM0322RelationAction(dto);
	
				req.getSession().setAttribute("soc_srdomainid_eq", form.getSrdomainid_eq());
				req.getSession().setAttribute("soc_srdomainversion_eq", form.getSrdomainversion_eq());
				req.getSession().setAttribute("soc_srcreatetime_eq", form.getSrcreatetime_eq());
				req.getSession().setAttribute("soc_storage_eq", dto.getStorageEiname());
				req.getSession().setAttribute("soc_storageeiid", dto.getSoc0124Info().getEiid());
				req.getSession().setAttribute("soc_storageversion", dto.getSoc0124Info().getEiversion());
				req.getSession().setAttribute("soc_storagesmallversion", dto.getSoc0124Info().getEismallversion());
				req.setAttribute("strXML",dto.getStrXml());
				log.debug("========设置EMC存储关系图处理终了========");
				return mapping.findForward(forword);
		}		
		return mapping.findForward(null);
	}
}
