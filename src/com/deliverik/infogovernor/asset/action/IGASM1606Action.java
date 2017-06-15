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
import com.deliverik.infogovernor.asset.bl.IGASM16BL;
import com.deliverik.infogovernor.asset.dto.IGASM16DTO;
import com.deliverik.infogovernor.asset.form.IGASM1606Form;
import com.deliverik.infogovernor.asset.vo.IGASM16061VO;

/**
 * 数据关系管理画面Action处理
 *
 */
public class IGASM1606Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1606Action.class);

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
		IGASM1606Form form = (IGASM1606Form)actionForm;
		
		//BL取得
		IGASM16BL ctlBL = (IGASM16BL) getBean("igasm16BL");
		
		//DTO生成
		IGASM16DTO dto = new IGASM16DTO();
		
		//画面跳转设定
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//数据关系管理画面初期显示处理
			log.debug("========数据关系管理画面初期显示处理开始========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGASM1606Form) req.getSession().getAttribute("IGASM1606Form");
			}

			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1606");

			//DTO输入参数设定
			dto.setIgasm1606Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//数据关系管理画面初期显示逻辑调用
			dto = ctlBL.initIGASM1606Action(dto);
			
			//将类型关系管理信息检索结果设定到VO中
			IGASM16061VO vo = new IGASM16061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGASM16061VO>setVO(req.getSession(), vo);
			saveToken(req);
			
			log.debug("========数据关系管理画面初期显示处理终了========");
			
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
			//数据关系删除处理
			log.debug("========数据关系删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//数据关系删除逻辑调用
			ctlBL.deleteEntityItemRelationAction(dto);
			
			log.debug("========数据关系删除处理终了========");
			
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
