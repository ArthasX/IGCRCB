/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.rpt.bl.IGRPT02BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT02DTO;
import com.deliverik.infogovernor.rpt.vo.IGRPT02001VO;

/**
 * 概述: 统计分析首页Action
 * 功能描述: 首页(igcom0218)的显示,自定义报表的查询显示
 * 创建记录: 2012-7-20
 * 修改记录: 
 */
public class IGRPT0200Action extends BaseAction{
	static Log log = LogFactory.getLog(IGRPT0200Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//取得控制BL
		IGRPT02BL ctlBL =(IGRPT02BL)getBean("IGRPT02BL");
		//dto
		IGRPT02DTO dto=new IGRPT02DTO();
		User u=(User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setCurUser(u);
		
		 //获取菜单权限
		UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
		//设置高亮菜单
		if(perm != null) {
			String actsortid = perm.getActsortid("ACT05STA02");//获取指定菜单ID的ACTSORTID
			if(StringUtils.isNotEmpty(actsortid)){
				setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
				setSessionAttribute(req, "secondactid", actsortid.substring(0, 4));
			}
		}
		if("DISP".equals(mapping.getParameter())){
			log.debug("========统计分析首页显示开始========");
			ctlBL.searchSOC0204Action(dto);
			IGRPT02001VO vo=new IGRPT02001VO();
			vo.setReportCustomLinkList_Pref(dto.getReportCustomLinkList_Pref());//取得性能list
			vo.setReportCustomLinkList_Cap(dto.getReportCustomLinkList_Cap());//取得容量list
			super.<IGRPT02001VO>setVO(req, vo);
			log.debug("========统计分析首页显示终了========");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		
		return mapping.findForward("DISP");
	}
	
}
