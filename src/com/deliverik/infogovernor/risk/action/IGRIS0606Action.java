package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.infogovernor.risk.bl.IGRIS06BL;
import com.deliverik.infogovernor.risk.dto.IGRIS06DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0606Form;
import com.deliverik.infogovernor.risk.vo.IGRIS06061VO;

/**
 * 检查项关系管理画面Action处理
 *
 */
public class IGRIS0606Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0606Action.class);

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
		IGRIS0606Form form = (IGRIS0606Form)actionForm;
		
		//BL取得
		IGRIS06BL ctlBL = (IGRIS06BL) getBean("igris06BL");
		
		//DTO生成
		IGRIS06DTO dto = new IGRIS06DTO();
		
		//画面跳转设定
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//检查项关系管理画面初期显示处理
			log.debug("========检查项关系管理画面初期显示处理开始========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGRIS0606Form) req.getSession().getAttribute("IGRIS0606Form");
			}

			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRIS0606");

			//DTO输入参数设定
			dto.setIgris0606Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//检查项关系管理画面初期显示逻辑调用
			dto = ctlBL.initIGRIS0606Action(dto);
			
			//将类型关系管理信息检索结果设定到VO中
			IGRIS06061VO vo = new IGRIS06061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGRIS06061VO>setVO(req.getSession(), vo);
			saveToken(req);
			log.debug("========检查项关系管理画面初期显示处理终了========");
			
			forword = "DISP";
		}
		
		if ("EDIT".equals(mapping.getParameter())) {
			if (req.getParameter("btn_back")!=null) {
				//返回按钮按下时的返回处理
				forword = "BACK";
			}
			if (req.getParameter("btn_add")!=null) {
				//增加按钮按下时的处理
				forword = "ADD";
			}
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//检查项关系删除处理
			log.debug("========检查项关系删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//检查项关系删除逻辑调用
			ctlBL.deleteEntityItemRelationAction(dto);
			
			log.debug("========检查项关系删除处理终了========");
			
			forword = "DISP";
		}

		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forword);
	}
}
