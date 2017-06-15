/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM05BL;
import com.deliverik.infogovernor.asset.dto.IGASM42DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 文档下载Action
 * </p>
 * 
 * @author 史凯龙@deliverik.com
 * @version 1.0
 */
public class IGCRC1307Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC1307Action.class);
	
	/**
	 * <p>
	 * Description: 页面查询action处理
	 * </p>
	 * 
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.debug("================文档存量统计Action开始=============");
				
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		IGASM05BL igasm05BL = (IGASM05BL)getBean("igasm05BL");
		IGASM42DTO igasm42dto = new IGASM42DTO();
		
		if("INSERT".equals(mapping.getParameter())){
			
			igasm42dto.setUserid(user.getUserid());
			
			igasm42dto.setEiid(new Integer(request.getParameter("eiid")));
			
			SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
			igasm42dto.setDowntime(format.format(new Date()));
			igasm42dto.setDownlocation("1");
			igasm05BL.downFileInsertData(igasm42dto);
			
		}
		return mapping.findForward("DISP");
	}
}
