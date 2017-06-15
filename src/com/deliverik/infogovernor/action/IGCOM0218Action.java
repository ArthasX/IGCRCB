/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.bl.IGCOM02BL;
import com.deliverik.infogovernor.dto.IGCOM02DTO;
import com.deliverik.infogovernor.vo.IGCOM02181VO;

/**
 * 概述: 应用管理首页显示Action处理
 * 功能描述: 应用管理首页显示Action处理
 * 创建记录: 2012/03/01
 * 修改记录: 
 */
public class IGCOM0218Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0218Action.class);
	/**
	 * 
	 * 事件处理
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("========应用管理首页显示开始========");
		//BL取得
		IGCOM02BL ctlBL = (IGCOM02BL) getBean("igcom02BL");
		
		//DTO生成
		IGCOM02DTO dto = new IGCOM02DTO();
		
		//检索逻辑调用
		dto = ctlBL.searchIgcom0218Action(dto);
		
		//将信息检索结果设定到VO中
		IGCOM02181VO vo = new IGCOM02181VO();
		//告警信息设定
		vo.setSoc0307List(dto.getSoc0307List());
		//知识信息设定
		vo.setKnowledgeList(dto.getKnowledgeList());
		super.<IGCOM02181VO>setVO(req, vo);

		log.debug("========应用管理首页显示结束========");
		return mapping.findForward("DISP");
	}
	






}
