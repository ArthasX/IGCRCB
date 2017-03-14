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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM04BL;
import com.deliverik.infogovernor.asset.dto.IGASM04DTO;
import com.deliverik.infogovernor.asset.form.IGASM0421Form;
import com.deliverik.infogovernor.asset.vo.IGASM04211VO;

/**
 * 概述: 合同付款登记Action
 * 功能描述: 合同付款登记Action
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
public class IGASM0421Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGASM0421Action.class);
	
	/**
	 * 付款登记处理
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
		IGASM0421Form form = (IGASM0421Form)actionForm;
		
		//BL取得
		IGASM04BL ctlBL = (IGASM04BL) getBean("igasm04BL");
		
		//DTO生成
		IGASM04DTO dto = new IGASM04DTO();
		
		String forward = "null";
		if( "DISP".equals(mapping.getParameter())){
			//合同付款登记画面初期显示处理
			log.debug("========合同付款登记画面初期显示处理开始========");
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0421");
			
			//DTO输入参数设定
			dto.setIgasm0421Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//合同付款登记画面初期显示逻辑调用
			dto = ctlBL.initIGASM0421Action(dto);
			
			//将合同付款信息检索结果设定到VO中
			IGASM04211VO vo = new IGASM04211VO();
			
			vo.setEntityItemCompactVWInfo(dto.getEntityItemCompactVWInfo());
			//是否显示图像按钮
			vo.setImage_flag(dto.getImage_flag());
			if(!dto.getImage_flag()){
				vo.setPicsXml(dto.getPicsXml());
				vo.setPicuXml(dto.getPicuXml());
			}
			
			vo.setKaihuhang(dto.getKaihuhang());//开户行
			vo.setKaihuzhanghao(dto.getKaihuzhanghao());//开户账号
			vo.setKaihumingcheng(dto.getKaihumingcheng());//开户名称
			
			req.setAttribute("IGASM0421Form", dto.getIgasm0421Form());
			super.<IGASM04211VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","合同付款信息"));
			log.debug("========合同付款登记画面初期显示处理终了========");
			saveToken(req);
			forward = "DISP";
		} else if("EDIT".equals(mapping.getParameter())){
			//合同付款信息编辑
			log.debug("========合同付款信息编辑处理开始========");

			//DTO输入参数设定
			dto.setIgasm0421Form(form);
			
			if (isTokenValid(req, true)){
				//合同付款信息编辑逻辑调用
				dto = ctlBL.editIGASM0421Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========合同付款信息编辑处理终了========");
			forward = "DISP";
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
