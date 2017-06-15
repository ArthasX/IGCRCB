
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prr.bl.IGPRR06BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0102Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01021VO;
import com.deliverik.infogovernor.svc.bl.IGSVC01BL;
import com.deliverik.infogovernor.svc.dto.IGSVC01DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0100Form;
import com.deliverik.infogovernor.svc.vo.IGSVC01061VO;

/**
 * @Description: 流程处理Action
 * @Author  史凯龙
 * @Version V1.0
 */
public class IGPRR0107Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRR0107Action.class);

	/**
	 * 流程处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String prid = req.getParameter("prid");
		Integer riskEiid = Integer.parseInt(req.getParameter("riskEiid"));
		IGSVC0100Form form1 = new IGSVC0100Form();
		IGPRR0102Form form2 = (IGPRR0102Form)actionForm;
		form1.setPrpdid("01001");
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//获取BL接口实例
		IGSVC01BL ctlBL1 = (IGSVC01BL) getBean("igsvc01BL");
		//实例化DTO
		IGSVC01DTO dto = new IGSVC01DTO();

		//获取分页Bean
		getPaginDTO(req,"IGSVC0106");
		PagingDTO pDto;
		pDto = (PagingDTO)req.getAttribute("PagingDTO");
		int maxCnt = getMaxDataCount("IGSVC0106");
		dto.setMaxSearchCount(maxCnt);
		dto.setPagingDto(pDto);
		form1.setUserid_q(user.getUserid());
		form1.setSing("DESC");
		form1.setOrder("prclosetime desc , propentime ");
		dto.setPrSearchCond(form1);
		//调用BL查询
		dto = ctlBL1.getProcessRecords(dto);
		String name = "";
		if(dto.getProcessList() !=null && dto.getProcessList().size()>0  ){
			name = dto.getProcessList().get(0).getPrtitle();
		}
		
		
		//BL取得
		IGPRR06BL ctlBL = (IGPRR06BL) getBean("igPRR06BL");
		IGPRR01021VO vo = new IGPRR01021VO();
		
		//DTO生成
		IGPRR01DTO dto2 = new IGPRR01DTO();
		dto2.setPrtitle(name);
		dto2.setEiid(riskEiid);
		
		if(name.equals("")|| name==null || prid==null || prid.equals("")){
			dto2 = ctlBL.searchAll(dto2);
		}else{
			vo.setRiskjobid(prid);
			Integer id = Integer.parseInt(prid);
			dto2.setPrid(id);
			dto2 = ctlBL.searchByEIID(dto2);
		}
		
		vo.setRiskid(riskEiid);
		vo.setPrtitle(dto2.getPrtitle());
		vo.setListMap(dto2.getListMap());
		if(dto2.getListPointVMs().size()>0){
			vo.setListPointVMs(dto2.getListPointVMs());
			vo.setEiname(dto2.getListPointVMs().get(0).getEiname());
			vo.setRiskitem(dto2.getListPointVMs().get(0).getRiskitem());
			vo.setPoss(dto2.getListPointVMs().get(0).getPoss());
			vo.setLevels(dto2.getListPointVMs().get(0).getLevels());
			vo.setGrad(dto2.getListPointVMs().get(0).getGrad());
		}
		if(dto2.getCheckItemVWs().size()>0){
			vo.setCheckItemVWs(dto2.getCheckItemVWs());
			vo.setEiname(dto2.getCheckItemVWs().get(0).getEiname());
			vo.setRiskitem(dto2.getCheckItemVWs().get(0).getRiskitem());
		}
		
		
		super.<IGPRR01021VO>setVO(req.getSession(), vo);
		//跳转到定制JSP
		return mapping.findForward("DISP");
	}
}