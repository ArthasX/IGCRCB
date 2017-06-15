package com.deliverik.infogovernor.asset.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.infogovernor.asset.bl.IGASM13BL;
import com.deliverik.infogovernor.asset.dto.IGASM13DTO;
import com.deliverik.infogovernor.asset.form.IGASM1301Form;
import com.deliverik.infogovernor.asset.vo.IGASM13011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM01BL;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0101Form;
/**
 * 设备统计分析信息Action处理
 *
 */
public class IGASM1301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1301Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//BL取得
		IGASM13BL asmBL = (IGASM13BL) getBean("igasm13BL");
		IGASM1301Form form = (IGASM1301Form)actionForm;
		IGASM13DTO dto = new IGASM13DTO();
		
		
		if( "FROM".equals(mapping.getParameter())){
			log.debug("========设备存量统计分析画面初期显示处理开始========");	
			
			//SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			//form.setCiupdtime_to(df.format(Calendar.getInstance().getTime()));
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========设备存量统计分析画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if("TO".equals(mapping.getParameter())){
			log.debug("========新进设备统计分析画面初期显示处理开始========");	
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			Calendar c = Calendar.getInstance();
			c.set(Calendar.DATE, 1);
			form.setCiupdtime_from(df.format(c.getTime()));
			form.setCiupdtime_to(df.format(Calendar.getInstance().getTime()));
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========新进设备统计分析画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} 
		
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========设备统计分析处理开始========");
			
			dto.setEntityCountSearchCond(form);
			
			//获取分页Bean
			getPaginDTO(req,"IGASM1301");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM1301Form) req.getSession().getAttribute("IGASM1301Form");
				if ( form== null){
					form = new IGASM1301Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGASM1301Form) req.getSession().getAttribute("IGASM1301Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			int maxCnt = getMaxDataCount("DEFAULT");
			
			dto.setPagingDto(pDto);
			dto.setMaxSearchCount(maxCnt);
			
			dto = asmBL.getEntityCount(dto);
			//构造VO
			IGASM13011VO vo = new IGASM13011VO(dto.getEcList(),dto.getTotal());
			
			super.<IGASM13011VO>setVO(req, vo);
			
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			//zb add
			req.setAttribute("vo", vo);
			req.setAttribute("form", form);
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				//设备存量
				IGSYM01BL symBL = (IGSYM01BL) getBean("igsym01BL");
				IGSYM0101Form form1 = new IGSYM0101Form();
				IGSYM01DTO dto1 = new IGSYM01DTO();
				form1.setOrgsyscoding(form.getEiorgsyscoding_q());
				dto1.setOrganizationSearchCond(form1);
				
				dto1 = symBL.searchOrganizationForIGASM1303Action(dto1);
				Organization org = dto1.getOrganization();
				if(org!=null && dto1.getCompletenameMap()!=null){
					form.setOrgname(dto1.getCompletenameMap().get(org.getOrgid()));
				}else{
					form.setOrgname("");
				}
				req.setAttribute("form", form);
				return mapping.findForward("REPORT");
			}
			//REPORT1
			if(StringUtils.isNotEmpty(req.getParameter("report1"))) {
				//新进设备
				IGSYM01BL symBL = (IGSYM01BL) getBean("igsym01BL");
				IGSYM0101Form form1 = new IGSYM0101Form();
				IGSYM01DTO dto1 = new IGSYM01DTO();
				form1.setOrgsyscoding(form.getEiorgsyscoding_q());
				dto1.setOrganizationSearchCond(form1);
				
				dto1 = symBL.searchOrganizationForIGASM1303Action(dto1);
				Organization org = dto1.getOrganization();
				if(org!=null && dto1.getCompletenameMap()!=null){
					form.setOrgname(dto1.getCompletenameMap().get(org.getOrgid()));
				}else{
					form.setOrgname("");
				}
				req.setAttribute("form", form);
				return mapping.findForward("REPORT1");
			}
			log.debug("========设备统计分析处理终了========");
		}
		
		return mapping.findForward("DISP");
	}

}
