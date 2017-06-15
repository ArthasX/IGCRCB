package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM05BL;
import com.deliverik.infogovernor.drm.dto.IGDRM05DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0506Form;
import com.deliverik.infogovernor.drm.vo.IGDRM05061VO;

/**
 * 专项预案关系管理画面Action处理
 *
 */
public class IGDRM0506Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0506Action.class);

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
		IGDRM0506Form form = (IGDRM0506Form)actionForm;
		
		//BL取得
		IGDRM05BL ctlBL = (IGDRM05BL) getBean("igdrm05BL");
		
		//DTO生成
		IGDRM05DTO dto = new IGDRM05DTO();
		
		//画面跳转设定
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//专项预案关系管理画面初期显示处理
			log.debug("========专项预案关系管理画面初期显示处理开始========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGDRM0506Form) req.getSession().getAttribute("IGDRM0506Form");
			}

			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDRM0506");

			//DTO输入参数设定
			dto.setIgdrm0506Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//专项预案关系管理画面初期显示逻辑调用
			dto = ctlBL.initIGDRM0506Action(dto);
			
			//将类型关系管理信息检索结果设定到VO中
			IGDRM05061VO vo = new IGDRM05061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.isFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGDRM05061VO>setVO(req.getSession(), vo);
			saveToken(req);
			log.debug("========专项预案关系管理画面初期显示处理终了========");
			
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
			//专项预案关系删除处理
			log.debug("========专项预案关系删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//专项预案关系删除逻辑调用
			ctlBL.deleteEntityItemRelationAction(dto);
			
			log.debug("========专项预案关系删除处理终了========");
			
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
