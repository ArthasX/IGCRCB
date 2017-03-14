/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR03BL;
import com.deliverik.infogovernor.prr.dto.IGPRR03DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0301Form;
import com.deliverik.infogovernor.prr.vo.IGPRR03011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 自定义流程OA模式对应角色全局配置Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0301Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRR0301Action.class);
		//bl取得
		IGPRR03BL ctlBL = (IGPRR03BL) getBean("igprr03BL");
		//dto实例化
		IGPRR03DTO dto = new IGPRR03DTO();
		//form取得
		IGPRR0301Form form = (IGPRR0301Form) actionForm;
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========OA角色配置页面初始化操作开始===========");
			//查询历史配置信息
			dto = ctlBL.searchIG001InfoListAction(dto);
			//实例化vo
			IGPRR03011VO vo = new IGPRR03011VO();
			vo.setIg001List_A(dto.getIg001List_A());
			vo.setIg001List_B(dto.getIg001List_B());
			vo.setIg001List_C(dto.getIg001List_C());
			super.<IGPRR03011VO>setVO(request, vo);
			saveToken(request);
			log.debug("===========OA角色配置页面初始化操作结束===========");
		}
		if("DELETE".equals(mapping.getParameter())){
			log.debug("==========删除配置角色信息开始===========");
			if(isTokenValid(request,true)){
				dto.setIgprr0301Form(form);
				dto = ctlBL.deleteIG001Action(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("==========删除配置角色信息结束===========");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
