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
import com.deliverik.infogovernor.asset.bl.IGASM23BL;
import com.deliverik.infogovernor.asset.dto.IGASM23DTO;
import com.deliverik.infogovernor.asset.form.IGASM2301Form;
import com.deliverik.infogovernor.asset.vo.IGASM23011VO;

/**
 * 概述: 采集控制台信息查询画面Action处理
 * 功能描述: 采集控制台信息查询画面Action处理
 * 创建记录: 2311/05/04
 * 修改记录: 
 */
public class IGASM2301Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2301Action.class);
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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM2301Form form = (IGASM2301Form)actionForm;
		
		//BL取得
		IGASM23BL ctlBL = (IGASM23BL) getBean("igasm23BL");
		
		//DTO生成
		IGASM23DTO dto = new IGASM23DTO();
		
		if( "SEARCH".equals(mapping.getParameter())){
			//采集控制台查询处理
			log.debug("========采集控制台查询处理开始========");
			//DTO输入参数设定
			dto.setImportVersionSearchCond(form);
			
			//采集控制台检索逻辑调用
			dto = ctlBL.initIGASM2301Action(dto);
			
			//将采集控制台信息检索结果设定到VO中
			IGASM23011VO vo = new IGASM23011VO(dto.getImportVersionInfoList());
			
			super.<IGASM23011VO>setVO(req,vo);
			
			saveToken(req);
			
			log.debug("========采集控制台查询处理终了========");
		} else if("COLLECT".equals(mapping.getParameter())){
			
			log.debug("========采集处理开始========");
			
			if (isTokenValid(req, true)){
				dto.setCollectIds(form.getCollectIds());
				dto = ctlBL.collectIGASM2301Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			Thread.sleep(1500);
			log.debug("========采集处理终了========");
			
		}
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		
		
		return mapping.findForward("DISP");
	}

}
