/** 北京递蓝科软件技术有限公司版权所有，保留所有权利。*/

package com.deliverik.infogovernor.aim.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0125BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0125Info;
import com.deliverik.infogovernor.soc.bl.task.SOC0114VW_FXBL;
import com.deliverik.infogovernor.soc.model.condition.SOC0114VW_FXSearchCondImpl;

/**
 * @Busstopo map
 * @version 1.0
 */

public class IGAIM0148Action extends BaseAction {

	static Log log = LogFactory.getLog(IGAIM0148Action.class);
	
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//画面跳转设定
		String forward = "DISP";
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========Buss topo map Fuxin初期显示处理开始========");
//			//1、双击页面可得到eiid查询soc0118获得eiversiion、eismallversion;
//			//2、查询soc0125视图得到域ID、域版本；
//			SOC0118BL soc0118BL = (SOC0118BL)getBean("soc0118BL");
//			SOC0125BL soc0125BL = (SOC0125BL)getBean("soc0125BL");
//			Integer eiid=Integer.parseInt(req.getParameter("EIID"));
			req.setAttribute("RESP_EIID", req.getParameter("EIID"));
//			SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(eiid);
//			Integer eiversion=soc0118Info.getEiversion();
//			Integer eismallversion=soc0118Info.getEismallversion();
//			SOC0125Info soc0125Info = soc0125BL.searchEiDomainDefVW("1");
//			Integer domainid=soc0125Info.getEiddid();
//			Integer domainversion=soc0125Info.getVersion();
//			//3、根据eiid、eiversiion、eismallversion、域ID、域版本、fingerprint六个条件查询soc0114表中该业务系统的所在所有链路；
//			SOC0114VW_FXBL soc0114VW_FXBL = (SOC0114VW_FXBL) getBean("soc0114VW_FXBL");
//			SOC0114VW_FXSearchCondImpl cond = new SOC0114VW_FXSearchCondImpl();
//			cond.setEiid(eiid);
//			cond.setEiversion(eiversion);
//			cond.setEismallversion(eismallversion);
//			cond.setDomainid(domainid);
//			cond.setDomainversion(domainversion);
//			log.debug("========查询业务链路关系开始========");
//			String[] xmlStr=soc0114VW_FXBL.searchSOC0114VW_FXByCond(cond).split("@");//查询链路关系开始
//			log.debug("========查询业务链路关系结束========");
//			log.debug("========Buss topo map Fuxin初期显示处理终了========");
//			if(xmlStr!=null&&xmlStr.length>1){
//				req.setAttribute("TOPOMAP_XMLSTR", xmlStr[0].replace("\\", "\\\\"));
//				req.setAttribute("LEGEND_XMLSTR", xmlStr[1]);
//			}else{
//				req.setAttribute("TOPOMAP_XMLSTR", "");
//				req.setAttribute("LEGEND_XMLSTR", "");
//			}
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
