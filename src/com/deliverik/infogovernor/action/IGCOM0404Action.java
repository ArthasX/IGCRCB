/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.action;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.form.IGCOM0404Form;
import com.deliverik.infogovernor.prm.bl.IGPRMCONSTANTS;

/**
 * @Description: 服务工单快捷发起流程Action处理
 * @Author masai
 * @History 
 * @Version 1.0
 */
public class IGCOM0404Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0404Action.class);

	/**
	 * 事件处理
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		log.debug("========流程快捷发起处理开始 ========");
		
		//Session清除
		clearSessionFormData(req);
		
		IGCOM0404Form form = (IGCOM0404Form) actionForm;
		
		if(StringUtils.isEmpty(form.getPrtype())) {
			
			throw new BLException("IGCO10000.E004","可发起流程类型");
			
		} else {
			
			//自定义事件发起url
			if(form.getPtid().equals("9") || form.getPtid().equals("10") || form.getPtid().equals("11") || form.getPtid().equals("12") || form.getPtid().equals("13")){
				Field type = IGPRMCONSTANTS.class.getDeclaredField("QUICK_PROCESS_INIT_PAGE_SF_W");
				String url = (String) type.get(IGPRMCONSTANTS.class);
				form.setUrl(url + "?psdcode=Z&isServiceStart=S&parprid="+form.getParprid()+"&pdid=" + form.getPrpdid() + "&ptid=" + form.getPtid());
			}else{
				//获取快捷发起页面URL if 服务工单快捷发起流程
				Field type = IGPRMCONSTANTS.class.getDeclaredField("QUICK_PROCESS_INIT_PAGE_SF_" + form.getPrtype());
				String url = (String) type.get(IGPRMCONSTANTS.class);
				form.setUrl(url + "?isServiceStart=S&parprid=" + form.getParprid() + "&prpdid=" + form.getPrpdid() + "&flag=" + form.getFlag());
			}
		
		}
		
		log.debug("========流程快捷发起处理终了========");
		
		return mapping.findForward("DISP");
		
	}
}
