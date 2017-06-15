package com.deliverik.infogovernor.soc.cim.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.soc.asset.model.Timer01Info;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM13BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM13DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0806Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM13011VO;

/**
 * 概述: 定时采集 创建记录：2013/7/3 修改记录：
 */
public class IGCIM0806Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGCIM0806Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		String uuid = null;
		String forward = null;
		String periodType = null;
		String serverName = null;
		
		IGCIM13DTO dto = new IGCIM13DTO();
		IGCIM13011VO vo = new IGCIM13011VO();
		IGCIM13BL ctrBL= (IGCIM13BL) getBean("igcim13BL");
		IGCIM0806Form igcim0806Form =(IGCIM0806Form)actionForm;
		dto.setMessageList(new ArrayList<ActionMessage>());
		
		if( "INIT".equals(mapping.getParameter())){

			uuid = req.getParameter("uuid");
			serverName = req.getParameter("servername");
			Timer01Info timer01Info = ctrBL.getTimer01ByUuid(uuid);
			
			if(timer01Info==null){
				log.warn("uuid ="+uuid+"在timer01中不存在");
				forward = "INIT";
			}else{
				
				igcim0806Form.setUuid(uuid);
				igcim0806Form.setName(serverName);
				igcim0806Form.setTypename(timer01Info.getTypename());
				igcim0806Form.setExecutstatus(timer01Info.getExecutstatus());
				//igcim0806Form.setStarttime(timer01Info.getStarttime());
				//igcim0806Form.setStoptime(timer01Info.getStoptime());

				if(timer01Info.getPeriodtype() == null || "".equals(timer01Info.getPeriodtype())){
					igcim0806Form.setPeriodtype("1");
				}else{
					igcim0806Form.setPeriodtype(timer01Info.getPeriodtype());
				}

				if(timer01Info.getStartrule()!= null && !"".equals(timer01Info.getStartrule())){
					String startTime[] = timer01Info.getStarttime().split(" ");
					String startHourMinute[] = startTime[1].split(":");
					igcim0806Form.setStarttime(startTime[0]);
					igcim0806Form.setStarthour(startHourMinute[0]);
					igcim0806Form.setStartminute(startHourMinute[1]);
				}else{
					igcim0806Form.setStarttime(null);
					igcim0806Form.setStarthour(null);
					igcim0806Form.setStartminute(null);
				}
				
				if(timer01Info.getStoprule()!=null && !"".equals(timer01Info.getStoprule())){
					String stopTime[] = timer01Info.getStoptime().split(" ");
					String stopHourMinute[] = stopTime[1].split(":");
					igcim0806Form.setStoptime(stopTime[0]);
					igcim0806Form.setStophour(stopHourMinute[0]);
					igcim0806Form.setStopminute(stopHourMinute[1]);
				}else{
					igcim0806Form.setStoptime(null);
					igcim0806Form.setStophour(null);
					igcim0806Form.setStopminute(null);
				}

			}

			forward = "INIT";

		}else if( "EDIT".equals(mapping.getParameter())){
			Timer01Info timer01Info = null;
			periodType = req.getParameter("periodtype");
			
			timer01Info = ctrBL.getTimer01ByUuid(igcim0806Form.getUuid());
			
			if(timer01Info!=null){
				
				igcim0806Form.setPeriodtype(periodType);
				igcim0806Form.setName(timer01Info.getName());
				igcim0806Form.setTypename(timer01Info.getTypename());
				igcim0806Form.setResourceId(timer01Info.getResourceid());
				igcim0806Form.setNewstarttime(timer01Info.getNewstarttime());
				igcim0806Form.setNewstoptime(timer01Info.getNewstoptime());
				igcim0806Form.setTypename(timer01Info.getTypename());
				igcim0806Form.setResourceId(timer01Info.getResourceid());

				ctrBL.editCollect(igcim0806Form);
				req.setAttribute("IGCIM0806_EDIT", "true");
					
			}else{
				log.warn("uuid="+igcim0806Form.getUuid()+"在timer01中没数据");
			}

			forward = "EDIT";
		}

		super.<IGCIM13011VO>setVO(req, vo);
		return mapping.findForward(forward);
	}
}
