/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.action;

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
import com.deliverik.infogovernor.dbm.bl.IGDBM11BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM11DTO;
import com.deliverik.infogovernor.dbm.form.IGDBM0201Form;
import com.deliverik.infogovernor.dbm.vo.IGDBM02011VO;

/**
 * 全网IP过滤处理Action
 * @version 1.0
 */

public class IGDBM0201Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDBM0201Action.class);
	
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
	    //FORM取得
	    IGDBM0201Form form = (IGDBM0201Form)actionForm;
	    
	    IGDBM11BL ctlBL = (IGDBM11BL) getBean("igdbm11BL");
	    
	    IGDBM11DTO dto = new IGDBM11DTO();
		//画面跳转设定
		String forward = "DISP";
		
		if("DISP".equals(mapping.getParameter())){
		    log.debug("========全网IP过滤初期显示处理开始========");
		    form.setIp("");
		    ctlBL.searchIp_FilterInfo(dto);
		    
		    IGDBM02011VO vo = new IGDBM02011VO();
		    
		    vo.setIpFilterInfoList(dto.getIpFilterInfoList());
		    saveToken(req);
		    super.<IGDBM02011VO>setVO(req, vo);
			log.debug("========全网IP过滤初期显示处理结束========");
		}
		
		if("INSERT".equals(mapping.getParameter())){
		    log.debug("========全网IP过滤新增处理开始==========");
		    if (isTokenValid(req, true)){
		        form.setAddtime(IGStringUtils.getCurrentDateTime());
	            dto.setIgdbm0201Form(form);
	            ctlBL.addIpFilterInfo(dto);
            }else{
                addMessage(req, new ActionMessage("IGCO00000.E007"));
                return mapping.findForward("/error1");
            }
		    log.debug("========全网IP过滤新增处理结束==========");
		}
		
		if("DEL".equals(mapping.getParameter())){
		    log.debug("========全网IP过滤删除处理开始==========");
		    if (isTokenValid(req, true)){
		        String id = req.getParameter("delId");
	            dto.setId(id);
	            ctlBL.delIpFilterInfo(dto);
            }else{
                addMessage(req, new ActionMessage("IGCO00000.E007"));
                return mapping.findForward("/error1");
            }
		    log.debug("========全网IP过滤删除处理结束==========");
		}
		if("BatchDEL".equals(mapping.getParameter())){
			log.debug("========全网IP过滤批量删除处理开始==========");
		    if (isTokenValid(req, true)){
		        form.setAddtime(IGStringUtils.getCurrentDateTime());
	            dto.setIgdbm0201Form(form);
	            ctlBL.BatchdelIpFilterInfo(dto);
            }else{
                addMessage(req, new ActionMessage("IGCO00000.E007"));
                return mapping.findForward("/error1");
            }
			log.debug("========全网IP过滤批量删除处理结束==========");
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
