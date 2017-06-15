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
import com.deliverik.infogovernor.asset.bl.IGASM02BL;
import com.deliverik.infogovernor.asset.dto.IGASM02DTO;
import com.deliverik.infogovernor.asset.form.IGASM0206Form;
import com.deliverik.infogovernor.asset.vo.IGASM02061VO;

/**
 * 配置项关系管理画面Action处理
 *
 */
public class IGASM0206Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0206Action.class);

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
		IGASM0206Form form = (IGASM0206Form)actionForm;
		
		//BL取得
		IGASM02BL ctlBL = (IGASM02BL) getBean("igasm02BL");
		
		//DTO生成
		IGASM02DTO dto = new IGASM02DTO();
		
		//画面跳转设定
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//配置项关系管理画面初期显示处理
			log.debug("========配置项关系管理画面初期显示处理开始========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGASM0206Form) req.getSession().getAttribute("IGASM0206Form");
			}

			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0206");

			//DTO输入参数设定
			dto.setIgasm0206Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//配置项关系管理画面初期显示逻辑调用
			dto = ctlBL.initIGASM0206Action(dto);
			
			//将类型关系管理信息检索结果设定到VO中
			IGASM02061VO vo = new IGASM02061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			super.<IGASM02061VO>setVO(req.getSession(), vo);
			
			log.debug("========配置项关系管理画面初期显示处理终了========");
			
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
			//配置项关系删除处理
			log.debug("========配置项关系删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//配置项关系删除逻辑调用
			ctlBL.deleteEntityItemRelationAction(dto);
			
			log.debug("========配置项关系删除处理终了========");
			
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
