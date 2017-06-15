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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0106Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01061VO;

/**
 * 设备关系管理画面Action处理
 *
 */
public class IGCIM0904Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0904Action.class);

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
		IGCIM0106Form form = (IGCIM0106Form)actionForm;
		
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO生成
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		//画面跳转设定
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//设备关系管理画面初期显示处理
			log.debug("========设备关系管理画面初期显示处理开始========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGCIM0106Form) req.getSession().getAttribute("IGCIM0106Form");
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0306");
			
			//DTO输入参数设定
			dto.setIgcim0106Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			if("1".equals(form.getRelationType())){//依赖关系
				dto = ctlBL.initIGASM0306BelongAction(dto);
			}else{//资产原有关系
				//设备关系管理画面初期显示逻辑调用
				dto = ctlBL.initIGASM0306Action(dto);
			}
			
			//将类型关系管理信息检索结果设定到VO中
			IGCIM01061VO vo = new IGCIM01061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//设置依赖关系列表
			vo.setEiBelongRelationList(dto.getEiBelongRelationList());
			vo.setRlnmap(dto.getRlnmap());
			super.<IGCIM01061VO>setVO(req.getSession(), vo);
			saveToken(req);
			log.debug("========设备关系管理画面初期显示处理终了========");
			
			forword = "DISP";
		}
		
		if( "DISP_NOTOKEN".equals(mapping.getParameter())){
			//设备关系管理画面初期显示处理
			log.debug("========设备关系管理画面初期显示处理开始========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGCIM0106Form) req.getSession().getAttribute("IGCIM0106Form");
			}

			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0106");

			//DTO输入参数设定
			dto.setIgcim0106Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			if("1".equals(form.getRelationType())){//依赖关系
				dto = ctlBL.initIGASM0306BelongAction(dto);
			}else{//资产原有关系
				//设备关系管理画面初期显示逻辑调用
				dto = ctlBL.initIGASM0306Action(dto);
			}
			
			//将类型关系管理信息检索结果设定到VO中
			IGCIM01061VO vo = new IGCIM01061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//设置依赖关系列表
			vo.setEiBelongRelationList(dto.getEiBelongRelationList());
			super.<IGCIM01061VO>setVO(req.getSession(), vo);
			log.debug("========设备关系管理画面初期显示处理终了========");
			
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
