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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM20BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM20DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2005Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM20051VO;

/**
 * 应用关系管理画面Action处理
 *
 */
public class IGCIM2005Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM2005Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGCIM2005Form form = (IGCIM2005Form)actionForm;
		
		//BL取得
		IGCIM20BL ctlBL = (IGCIM20BL) getBean("igcim20BL");
		
		//DTO生成
		IGCIM20DTO dto = new IGCIM20DTO();
		dto.setLocale(this.getLocale(req));
		//画面跳转设定
		String forword = null;
		req.setAttribute("backurl", req.getParameter("backurl"));
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//应用关系管理画面初期显示处理
			log.debug("========应用关系管理画面初期显示处理开始========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGCIM2005Form) req.getSession().getAttribute("IGCIM2005Form");
			}

			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM2005");

			//DTO输入参数设定
			dto.setIgcim2005Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//应用关系管理画面初期显示逻辑调用
			dto = ctlBL.initIGCIM2005Action(dto);
			
			//将类型关系管理信息检索结果设定到VO中
			IGCIM20051VO vo = new IGCIM20051VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			vo.setParEntityRelationMap(dto.getParEntityRelationMap());
			vo.setCldEntityRelationMap(dto.getCldEntityRelationMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGCIM20051VO>setVO(req.getSession(), vo);
			saveToken(req);
			log.debug("========应用关系管理画面初期显示处理终了========");
			
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
			//应用关系删除处理
			log.debug("========应用关系删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//应用关系删除逻辑调用
			ctlBL.deleteEntityItemRelationActionApp(dto);
			
			log.debug("========应用关系删除处理终了========");
			
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
