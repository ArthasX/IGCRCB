/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;

/**
 * 概述: 阜新拓扑，应用维护显示
 * 功能描述: 应用维护显示Action
 * 创建记录: 2013/10/25
 * 修改记录: 
 */
public class IGCIM0150Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0150Action.class);

	/**
	 * 配置包含关系显示处理
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO生成
		IGCIM01DTO dto = new IGCIM01DTO();
		
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========BussTopoMap_FuXinApp显示开始========");
			//获取菜单权限
			UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
			//设置高亮菜单
			if(perm != null) {
				//获取指定菜单ID的ACTSORTID
				String actsortid =perm.getActsortid("ACT15BUS01");
				if(req.getParameter("actname")!=null){
					actsortid = perm.getActsortid(req.getParameter("actname"));
				}
				if(StringUtils.isNotEmpty(actsortid)){
					setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
					if(actsortid.length()==4){
						setSessionAttribute(req, "secondactid", actsortid.substring(0,4));
					}else if(actsortid.length()==8){
						setSessionAttribute(req, "secondactid", actsortid.substring(0,6));
					}
				}
			}
			User user = (User)getSessionAttribute(req, SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			//关系树xml查询
			dto = ctlBL.getBusinessTree(dto);
			String eiid=req.getParameter("eiid");
			String treeXml = dto.getTreeXml();
			req.setAttribute("treeXml", treeXml);
			if(StringUtils.isNotEmpty(eiid)){
				
				req.setAttribute("eiid", eiid);
			}else{
				
				if(null!=req.getAttribute("eiid")){
					req.setAttribute("eiid",req.getAttribute("eiid"));
				}else{
					req.setAttribute("eiid", dto.getEiid());
				}
			}
			
			log.debug("========BussTopoMap_FuXinApp显示终了========");
		}
		//跳转查看
		if(req.getParameter("readonly") != null){
			return mapping.findForward("DISP1");
		}
		//跳转编辑
		return mapping.findForward("DISP");
	}
}
