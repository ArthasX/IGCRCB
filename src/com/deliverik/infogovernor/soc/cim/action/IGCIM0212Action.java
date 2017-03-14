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
import com.deliverik.infogovernor.soc.cim.form.IGCIM0212Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02121VO;

/**
 * 概述: 资产域定义版本查询画面Action处理
 * 功能描述: 资产域定义版本查询画面Action处理
 * 创建记录: 2011/04/26
 * 修改记录: 
 */
public class IGCIM0212Action extends BaseAction{
	static Log log = LogFactory.getLog(IGCIM0203Action.class);
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
		IGCIM0212Form form = (IGCIM0212Form)actionForm;
		
		//BL取得
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		
		//DTO生成
		IGCIM02DTO dto = new IGCIM02DTO();
		
		dto.setLocale(this.getLocale(req));
		
		if ("DISP".equals(mapping.getParameter())){
			//资产域定义历史版本查询处理
			log.debug("========资产域定义历史版本查询开始========");
			
			//DTO输入参数设定
			dto.setIgcim0212Form(form);
			
			//资产域定义历史版本查询逻辑调用
			dto=ctlBL.searchIGCIM0212Action(dto);
			
			//将应用配置信息历史记录检索结果设定到VO中
			IGCIM02121VO vo = new IGCIM02121VO(dto.getEiDomainDefInfo(),dto.getEiDomainDefInfoList());
			
			super.<IGCIM02121VO>setVO(req.getSession(), vo);
			log.debug("========资产域定义历史版本查询处理终了========");
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
