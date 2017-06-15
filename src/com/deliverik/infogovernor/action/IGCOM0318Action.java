package com.deliverik.infogovernor.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.form.IGCOM0318Form;

/**
 * 配置详细信息画面Action处理
 *
 */
public class IGCOM0318Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0318Action.class);

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
		IGCOM0318Form form = (IGCOM0318Form)actionForm;		
		//BL取得
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");	
		//DTO生成
		IGCOM03DTO dto = new IGCOM03DTO();		
		req.getSession().setAttribute("ADcount", 0);	
		req.getSession().setAttribute("ADmapcount", 0);		

	     //配置详细信息画面初期显示处理
		log.debug("========关系图查看关系画面初期显示处理开始========");
        //取得要查询的资产
		if(form.getSrpareiid_eq()!=null)
		{  dto.setEiid(Integer.parseInt(form.getSrpareiid_eq()));
			};			
        ctlBL.searchEntityItemByEiid(dto);			
        SOC0118Info  ei = dto.getSoc0118Info();	    
        req.setAttribute("forword", "");	
        //主机跳转页
		if (ei!=null&& ei.getEsyscoding().startsWith("999001001")) {
			req.setAttribute("forword", "host");			
		}
		//交换机跳转页
		else if (ei!=null&& ei.getEsyscoding().startsWith("999001006")) {
			req.setAttribute("forword", "switch");			
		}
		//存储跳转页
		else if (ei!=null&& ei.getEsyscoding().startsWith("999001009")) {
			req.setAttribute("forword", "storage");			
		}	
		req.setAttribute("srpareiid_eq", form.getSrpareiid_eq());
		req.setAttribute("srdomainid_eq", form.getSrdomainid_eq());
		req.setAttribute("srdomainversion_eq", form.getSrdomainversion_eq());
		req.setAttribute("srparversion_eq", form.getSrparversion_eq());
		req.setAttribute("srparsmallversion_eq", form.getSrparsmallversion_eq());
		req.setAttribute("srcreatetime_eq", form.getSrcreatetime_eq());
		return mapping.findForward("DISP");
	}
}
