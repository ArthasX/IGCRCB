/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM04BL;
import com.deliverik.infogovernor.asset.dto.IGASM04DTO;
import com.deliverik.infogovernor.asset.form.IGASM0404Form;
import com.deliverik.infogovernor.asset.vo.IGASM04041VO;

/**
 * 概述: 合同应付款查询显示详细2
 * 功能描述: 合同应付款查询显示详细2
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
public class IGASM0423Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGASM0423Action.class);
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
		//FORM取得
		IGASM0404Form form = (IGASM0404Form)actionForm;
		
		//BL取得
		IGASM04BL ctlBL = (IGASM04BL) getBean("igasm04BL");
		
		//DTO生成
		IGASM04DTO dto = new IGASM04DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
	
		if( "DISP".equals(mapping.getParameter())){
		//合同配置信息登记画面初期显示处理
		log.debug("========合同配置信息登记画面初期显示处理开始========");
		
		//查询记录最大件数取得
		int maxCnt = getMaxDataCount("IGASM0404");

		//DTO输入参数设定
		dto.setIgasm0404Form(form);
		
		dto.setMaxSearchCount(maxCnt);
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		//合同配置信息登记画面初期显示逻辑调用
		dto = ctlBL.initIGASM0404Action(dto);
		
		//将合同配置信息检索结果设定到VO中
		IGASM04041VO vo = new IGASM04041VO(dto.getEntityItemVWInfo(),
				dto.getConfigItemVWInfoMap());
		//返回查看资产配置信息权限标识
		vo.setFlag(dto.getFlag());
		vo.setEiorgname(dto.getEiorgname());
		Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
		Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
		for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
			Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
			req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
		}
		vo.setDismap(dto.getDismap());
		super.<IGASM04041VO>setVO(req.getSession(), vo);
		
		addMessage(req, new ActionMessage("IGCO10000.I001","合同配置信息"));
		log.debug("========合同配置信息登记画面初期显示处理终了========");
		saveToken(req);
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
	
