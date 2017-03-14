/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.rpt.bl.IGRPT02BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT02DTO;
import com.deliverik.infogovernor.rpt.form.IGRPT0201Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0202Form;
import com.deliverik.infogovernor.rpt.vo.IGRPT02011VO;

/**
 * 概述: 模板管理Action
 * 功能描述: 模板管理Action
 * 创建记录: 2012/06/07
 * 修改记录: 
 */
public class IGRPT0201Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGRPT0201Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {	
		//取得控制BL
		IGRPT02BL ctlBL =(IGRPT02BL) getBean("IGRPT02BL");
		//dto
		IGRPT02DTO dto=new IGRPT02DTO();
		//查询处理
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){//点击查询事件
			//取得02Form
			IGRPT0202Form form=(IGRPT0202Form)actionForm;
			log.debug("===自动报告模板管理查询开始===");
			//分页用DTO取得
			getPaginDTO(req,"IGRPT0201");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//设备查询处理
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRPT0202Form) req.getSession().getAttribute("IGRPT0202Form");
				if (form == null){
					form=new IGRPT0202Form();
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
					form = (IGRPT0202Form) req.getSession().getAttribute("IGRPT0202Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRPT0202Form");
			//DTO输入参数设定
			
			dto.setIGRPT0202Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto = ctlBL.searchReportTemplateByCond(dto);//查询ReportTemplate表
			IGRPT02011VO vo=new IGRPT02011VO();
			vo.setReportTemplateList(dto.getReportTemplateList());
			super.<IGRPT02011VO>setVO(req, vo);
			
			log.debug("===自动报告模板管理查询终了===");
		}
		//删除处理
		if("DELETE".equals(mapping.getParameter())){
			//取得02Form
			IGRPT0202Form form=(IGRPT0202Form)actionForm;
			log.debug("===自动报告模板删除处理开始===");
			int maxCnt = getMaxDataCount("IGRPT0202Form");
			getPaginDTO(req,"IGRPT0201");
			PagingDTO pDto;
			dto.setMaxSearchCount(maxCnt);
			dto.setIGRPT0202Form(form);
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			dto.setPagingDto(pDto);
			//删除方法
			ctlBL.deleteReportTemplateInstance(dto);
			//重新查询
			dto=ctlBL.searchReportTemplateByCond(dto);
			IGRPT02011VO vo=new IGRPT02011VO();
			vo.setReportTemplateList(dto.getReportTemplateList());
			super.<IGRPT02011VO>setVO(req, vo);
			log.debug("===自动报告模板删除处理终了===");
		}
		//新增处理
		if("INSERT".equals(mapping.getParameter())){//点击相应菜单
			//取得01Form
			IGRPT0201Form form=(IGRPT0201Form)actionForm;
			log.debug("===自动报告模板新增处理开始===");
			dto.setIGRPT0201Form(form);
			ctlBL.insertReportTemplateInstance(dto);
			form.setInsertFlag("yes");
			req.getSession().setAttribute("ADmonitorObjectList", dto.getMonitorObjectList());
			req.getSession().setAttribute("ADDMX_KPI_List", dto.getDmx_list());
			req.getSession().setAttribute("ADIBM_KPI_List", dto.getIbm_list());
			req.getSession().setAttribute("ADCX_KPI_List", dto.getCx_list());
			IGRPT02011VO vo=new IGRPT02011VO();
			vo.setReportTemplateMappingList(dto.getSoc0206List());
			super.<IGRPT02011VO>setVO(req, vo);
			log.debug("===自动报告模板新增处理终了===");
		}
		
		
		//查询显示
		if("DISP".equals(mapping.getParameter())){//点击相应菜单
			log.debug("===自动报告模板管理页面初始化开始===");
			log.debug("===自动报告模板管理页面初始化终了===");
		}
		//新增显示
		if("INSERT_DISP".equals(mapping.getParameter())){
			//取得01Form
			IGRPT0201Form form=(IGRPT0201Form)actionForm;
			log.debug("===自动报告模板新增显示开始===");
			form.setMode("0");//新增标示
//			dto.setIGRPT0101Form(form);
//			dto=ctlBL.initInsertAction(dto);
//			req.getSession().setAttribute("ADmonitorObjectList", dto.getMonitorObjectList());
//			req.getSession().setAttribute("ADDMX_KPI_List", dto.getDmx_list());
//			req.getSession().setAttribute("ADIBM_KPI_List", dto.getIbm_list());
//			req.getSession().setAttribute("ADCX_KPI_List", dto.getCx_list());
			log.debug("===自动报告模板新增显示终了===");
		}
		//修改处理
		if("UPDATE".equals(mapping.getParameter())){
			//取得01Form
			IGRPT0201Form form=(IGRPT0201Form)actionForm;
			log.debug("===自动报告模板更新显示开始===");
			dto.setIGRPT0201Form(form);
			ctlBL.updateReportTemplateInstance(dto);
			log.debug("===自动报告模板更新显示终了===");
		}
		//修改显示
		if("UPDATE_DISP".equals(mapping.getParameter())){
			//取得01Form
			IGRPT0201Form form=(IGRPT0201Form)actionForm;
			form.setInsertFlag("yes");
			log.debug("===自动报告模板更新显示开始===");
			form.setMode("1");//更新标示
			if(req.getParameter("rtId")!=null){
				Integer rtId=Integer.parseInt(req.getParameter("rtId"));
				form.setRtId(rtId);
			}
			dto.setIGRPT0201Form(form);
			dto=ctlBL.initUpdateReportTemplateAction(dto);
			req.getSession().setAttribute("ADmonitorObjectList", dto.getMonitorObjectList());
			req.getSession().setAttribute("ADDMX_KPI_List", dto.getDmx_list());
			req.getSession().setAttribute("ADIBM_KPI_List", dto.getIbm_list());
			req.getSession().setAttribute("ADCX_KPI_List", dto.getCx_list());
			IGRPT02011VO vo=new IGRPT02011VO();
			vo.setReportTemplateMappingList(dto.getSoc0206List());
			super.<IGRPT02011VO>setVO(req, vo);
			log.debug("===自动报告模板更新显示终了===");
		}
		if("MAPPINGINSERT".equals(mapping.getParameter())){
			//取得01Form
			log.debug("===自动报告模板更新显示开始===");
			IGRPT0201Form form=(IGRPT0201Form)actionForm;
			dto.setIGRPT0201Form(form);
			ctlBL.updateSOC0206(dto);
			log.debug("===自动报告模板更新显示终了===");
		}
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		return mapping.findForward("DISP");
	}

}
