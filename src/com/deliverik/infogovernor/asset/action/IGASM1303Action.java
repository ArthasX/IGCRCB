package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.form.IGASM1303Form;
import com.deliverik.infogovernor.asset.vo.IGASM13031VO;
import com.deliverik.infogovernor.sym.bl.IGSYM01BL;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0101Form;
/**
 * 设备分布式统计分析信息Action处理
 *
 */
public class IGASM1303Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1303Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//BL取得
		IGASM13BL asmBL = (IGASM13BL) getBean("igasm13BL");
		IGASM1303Form form = (IGASM1303Form)actionForm;
		IGASM13DTO dto = new IGASM13DTO();
		
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========设备分布式统计分析处理开始========");
			
			
			if("1".equals(req.getParameter("type"))){
				//新进设备统计
				req.setAttribute("searchType", "1");
			}else{
				//设备存量统计
				req.setAttribute("searchType", "0");
			}
			
			//获取分页Bean
			getPaginDTO(req,"IGASM1301");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM1303Form) req.getSession().getAttribute("IGASM1303Form");
				if ( form== null){
					form = new IGASM1303Form();
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
					form = (IGASM1303Form) req.getSession().getAttribute("IGASM1303Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			int maxCnt = getMaxDataCount("DEFAULT");
			
			dto.setPagingDto(pDto);
			dto.setMaxSearchCount(maxCnt);
			dto.setEquDistributingCountSearchCond(form);
			dto = asmBL.getEquDistributingCount(dto);
			//构造VO
			IGASM13031VO vo = new IGASM13031VO();
			
			vo.setEquDistributingCountList(dto.getEdList());
			vo.setTotal(dto.getTotal());
			super.<IGASM13031VO>setVO(req, vo);
			
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			//zb add
			req.setAttribute("vo", vo);
			
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				IGSYM01BL symBL = (IGSYM01BL) getBean("igsym01BL");
				IGSYM0101Form form1 = new IGSYM0101Form();
				IGSYM01DTO dto1 = new IGSYM01DTO();
				form1.setOrgsyscoding(form.getOrgcode());
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
			}else if(StringUtils.isNotEmpty(req.getParameter("report1"))){
				IGSYM01BL symBL = (IGSYM01BL) getBean("igsym01BL");
				IGSYM0101Form form1 = new IGSYM0101Form();
				IGSYM01DTO dto1 = new IGSYM01DTO();
				form1.setOrgsyscoding(form.getOrgcode());
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
			
			log.debug("========设备分布式统计分析处理终了========");
		}
		
		return mapping.findForward("DISP");
	}

}
