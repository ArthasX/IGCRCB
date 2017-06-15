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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM14BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM14DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1406Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM14061VO;

/**
 * 人员关系管理画面Action处理
 *
 */
public class IGCIM1406Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1406Action.class);

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
		IGCIM1406Form form = (IGCIM1406Form)actionForm;
		
		//BL取得
		IGCIM14BL ctlBL = (IGCIM14BL) getBean("igcim14BL");
		
		//DTO生成
		IGCIM14DTO dto = new IGCIM14DTO();
		
		//画面跳转设定
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//人员关系管理画面初期显示处理
			log.debug("========人员关系管理画面初期显示处理开始========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGCIM1406Form) req.getSession().getAttribute("IGCIM1406Form");
			}

			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM1406");

			//DTO输入参数设定
			dto.setIgcim1406Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//人员关系管理画面初期显示逻辑调用
			dto = ctlBL.initIGCIM1406Action(dto);
			
			//将类型关系管理信息检索结果设定到VO中
			IGCIM14061VO vo = new IGCIM14061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGCIM14061VO>setVO(req.getSession(), vo);
			saveToken(req);
			
			log.debug("========人员关系管理画面初期显示处理终了========");
			
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
			//人员关系删除处理
			log.debug("========人员关系删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//人员关系删除逻辑调用
			ctlBL.deleteEntityItemRelationAction(dto);
			
			log.debug("========人员关系删除处理终了========");
			
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
