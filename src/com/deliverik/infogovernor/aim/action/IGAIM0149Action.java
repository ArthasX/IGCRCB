/** ��������������������޹�˾��Ȩ���У���������Ȩ����*/

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

public class IGAIM0149Action extends BaseAction {

	static Log log = LogFactory.getLog(IGAIM0149Action.class);
	
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//������ת�趨
		String forward = "DISP";
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========Buss topo map Fuxin������ʾ����ʼ========");
			//1��˫��ҳ��ɵõ�eiid��ѯsoc0118���eiversiion��eismallversion;
			//2����ѯsoc0125��ͼ�õ���ID����汾��
			SOC0118BL soc0118BL = (SOC0118BL)getBean("soc0118BL");
			SOC0125BL soc0125BL = (SOC0125BL)getBean("soc0125BL");
			Integer eiid=Integer.parseInt(req.getParameter("EIID"));
			SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(eiid);
			Integer eiversion=soc0118Info.getEiversion();
			Integer eismallversion=soc0118Info.getEismallversion();
			SOC0125Info soc0125Info = soc0125BL.searchEiDomainDefVW("1");
			Integer domainid=soc0125Info.getEiddid();
			Integer domainversion=soc0125Info.getVersion();
			//3������eiid��eiversiion��eismallversion����ID����汾��fingerprint����������ѯsoc0114���и�ҵ��ϵͳ������������·��
			SOC0114VW_FXBL soc0114VW_FXBL = (SOC0114VW_FXBL) getBean("soc0114VW_FXBL");
			SOC0114VW_FXSearchCondImpl cond = new SOC0114VW_FXSearchCondImpl();
			cond.setEiid(eiid);
			cond.setEiversion(eiversion);
			cond.setEismallversion(eismallversion);
			cond.setDomainid(domainid);
			cond.setDomainversion(domainversion);
			log.debug("========��ѯҵ����·��ϵ��ʼ========");
			String[] xmlStr=soc0114VW_FXBL.searchSOC0114VW_BJByCond(cond).split("@");//��ѯ��·��ϵ��ʼ
			log.debug("========��ѯҵ����·��ϵ����========");
			log.debug("========Buss topo map Fuxin������ʾ��������========");
			if(xmlStr!=null&&xmlStr.length>1){
				req.setAttribute("TOPOMAP_XMLSTR", xmlStr[0].replace("\\", "\\\\"));
				req.setAttribute("LEGEND_XMLSTR", xmlStr[1]);
			}else{
				req.setAttribute("TOPOMAP_XMLSTR", "");
				req.setAttribute("LEGEND_XMLSTR", "");
			}
			req.setAttribute("eiid", eiid);
			req.setAttribute("eiversion", eiversion);
			req.setAttribute("eismallversion", eismallversion);
			req.setAttribute("domainid", domainid);
			req.setAttribute("domainversion", domainversion);
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
