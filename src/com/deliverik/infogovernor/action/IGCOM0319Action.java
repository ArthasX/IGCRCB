/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.form.IGCOM0319Form;
import com.deliverik.infogovernor.vo.IGCOM03191VO;

/**
 * 概述: 设备关系信息Action处理
 * 功能描述: 设备关系信息Action处理
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public class IGCOM0319Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0319Action.class);

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
		IGCOM0319Form form = (IGCOM0319Form)actionForm;
		
		//BL取得
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		//DTO生成
		IGCOM03DTO dto = new IGCOM03DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
	     if( "RELATION".equals(mapping.getParameter())){
			//配置详细信息画面初期显示处理
			log.debug("========关系图查看关系画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCOM0303");

			//DTO输入参数设定			
			dto.setIGCOM0319Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//配置详细信息画面初期显示逻辑调用
			dto = ctlBL.initIGCOM0319RelationAction(dto);
		
			//将设备配置信息检索结果设定到VO中
			IGCOM03191VO vo = new IGCOM03191VO(dto.getFsLvVgInfoList(),dto.getVgPvMetaInfoList());
			
			vo.setSoc0118Info(dto.getSoc0118Info());//资产信息
			
			vo.setEname(dto.getEname());//资产模型名称
			
			vo.setEiorgname(dto.getEiorgname());//设备所属机构名称
			
			req.setAttribute("IGCOM0319Form", form);
			
			super.<IGCOM03191VO>setVO(req, vo);

			addMessage(req, new ActionMessage("IGCO10000.I001","资产配置信息"));
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			log.debug("========关系图查看关系画面初期显示处理终了========");

			return mapping.findForward(forword);
		}		
		return mapping.findForward(null);
	}
}
