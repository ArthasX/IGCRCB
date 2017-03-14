package com.deliverik.infogovernor.action;

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
import com.deliverik.infogovernor.bl.IGCOM02BL;
import com.deliverik.infogovernor.dto.IGCOM02DTO;
import com.deliverik.infogovernor.vo.IGCOM02111VO;

/**
 * 统计分析画面用Action处理
 *
 */
public class IGCOM0211Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0211Action.class);
	
	/**
	 * 统计分析画面用Action处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		//Session清除
		clearSessionFormData(req);
		
		//BL取得
		IGCOM02BL ctlBL = (IGCOM02BL) getBean("igcom02BL");
		
		//DTO生成
		IGCOM02DTO dto = new IGCOM02DTO();
		
		//获取User信息
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		//报表分类树查询处理
		dto = ctlBL.filterReportTypeTreeAction(dto);
		
		IGCOM02111VO vo = new IGCOM02111VO(dto.getTreeNodeMap());
		
		
		String actname = req.getParameter("actname");
		UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
		//设置高亮菜单
		if(StringUtils.isNotEmpty(actname)&& perm != null) {
			String actsortid = perm.getActsortid(actname);//获取指定菜单ID的ACTSORTID
			if(StringUtils.isNotEmpty(actsortid)){
				if(actsortid.length() == 2) {//点击一级菜单时需清空二级菜单session变量
					setSessionAttribute(req, "firstactid", actsortid);
					setSessionAttribute(req, "secondactid", null);
				} else {//点击二，三级菜单
						setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
						setSessionAttribute(req, "secondactid", actsortid.substring(0, 4));
				}
			}
		}
		
		super.<IGCOM02111VO>setVO(req, vo);
		
		return mapping.findForward("DISP");
		
	}

}
