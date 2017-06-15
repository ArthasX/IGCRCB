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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.rpt.bl.IGRPT02BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT02DTO;
import com.deliverik.infogovernor.rpt.form.IGRPT0204Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0205Form;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;
import com.deliverik.infogovernor.rpt.vo.IGRPT02041VO;
import com.deliverik.infogovernor.rpt.vo.IGRPT02051VO;

/**
 * 概述: 报告管理Action
 * 功能描述: 报告管理Action
 * 创建记录: 2012/06/12
 * 修改记录: 
 */
public class IGRPT0204Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGRPT0204Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//取得控制BL
		IGRPT02BL ctlBL =(IGRPT02BL) getBean("IGRPT02BL");
		//dto
		IGRPT02DTO dto=new IGRPT02DTO();
		User user = (User) req.getSession().getAttribute(
				SESSION_KEY_LOGIN_USER);
		dto.setCurUser(user);
		//查询初始化 IGRPT0104_Disp.do
		if("DISP".equals(mapping.getParameter())){
			log.debug("===报表管理查询初始化显示开始===");
			log.debug("===报表管理查询初始化显示结束===");
		}
		
		//新增初始化 IGRPT0105_Disp.do
		if("INSERT_DISP".equals(mapping.getParameter())){
			log.debug("===报表管理新增显示开始===");
			//取得05Form
			IGRPT0205Form form=(IGRPT0205Form)actionForm;
			form.setMode("0");
			dto.setIgrpt0205Form(form);
			dto=ctlBL.insertReportManageInitAction(dto);
			IGRPT02051VO vo=new IGRPT02051VO();
			List<SOC0207Info> reportTemplateList=dto.getReportTemplateList();
			vo.setReportTemplateList(reportTemplateList);
			vo.setReportAnnexationList(dto.getRaInfoList());
			req.getSession().setAttribute("reportTemplateList", reportTemplateList);
			if(reportTemplateList!=null&&reportTemplateList.size()>0){
				vo.setRtDateType(reportTemplateList.get(0).getRtDateType());
			}
			super.<IGRPT02051VO>setVO(req, vo);
			log.debug("===报表管理新增显示结束===");
		}
		
		
		//点击查询事件 IGRPT0104.do
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("===报表管理查询开始===");
			//取得04Form
			IGRPT0204Form form=(IGRPT0204Form)actionForm;
			//分页用DTO取得
			getPaginDTO(req,"IGRPT0204");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//设备查询处理
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRPT0204Form) req.getSession().getAttribute("IGRPT0204Form");
				if (form == null){
					form=new IGRPT0204Form();
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
					form = (IGRPT0204Form) req.getSession().getAttribute("IGRPT0204Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRPT0204Form");
			//DTO输入参数设定
			dto.setIGRPT0204Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//查询方法
			dto = ctlBL.searchReportManageByCond(dto);
			IGRPT02041VO vo=new IGRPT02041VO();
			vo.setReportManageList(dto.getSoc0205List());
			super.<IGRPT02041VO>setVO(req, vo);
			
			log.debug("===报表管理查询终了===");
		}
		
		//批量删除 IGRPT0104_Delete.do
		if("DELETE".equals(mapping.getParameter())){
			log.debug("===报表管理删除处理开始===");
			//取得04Form
			IGRPT0204Form form=(IGRPT0204Form)actionForm;
			dto.setIGRPT0204Form(form);
			ctlBL.deleteReportManageInstance(dto);
//			dto=ctlBL.searchReportManageByCond(dto);
//			IGRPT01041VO vo=new IGRPT01041VO();
//			vo.setReportManageList(dto.getReportManageList());
//			super.<IGRPT01041VO>setVO(req, vo);
			log.debug("===报表管理删除处理终了===");
		}
		//批量删除 IGRPT0104_Delete.do
		if("RADELETE".equals(mapping.getParameter())){
			log.debug("===报表管理删除处理开始===");
			//取得04Form
			IGRPT0205Form form=(IGRPT0205Form)actionForm;
			dto.setIgrpt0205Form(form);
			ctlBL.deleteReportAnnexationInstance(dto);
			log.debug("===报表管理删除处理终了===");
			if("1".equals(form.getMode())){
				//逻辑处理过程中的信息显示
				List<ActionMessage> messageList = dto.getMessageList();
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
				}
				return mapping.findForward("UDISP");
			}
		}
		
		//新增处理 IGRPT0105_Insert.do
		if("INSERT".equals(mapping.getParameter())){
			log.debug("===报表管理新增处理开始===");
			//取得05Form
			IGRPT0205Form form=(IGRPT0205Form)actionForm;
			dto.setIgrpt0205Form(form);
			dto=ctlBL.insertReportManageInstance(dto);
			log.debug("===报表管理新增处理结束===");
		}
		
		//更新处理初始化
		if("UPDATEDISP".equals(mapping.getParameter())){
			log.debug("===报表修改初始化处理开始===");
			//取得05Form
			IGRPT0205Form form=(IGRPT0205Form)actionForm;
			dto.setIgrpt0205Form(form);
			ctlBL.initUpdateReportManageInstance(dto);
			IGRPT02051VO vo=new IGRPT02051VO();
			List<SOC0207Info> reportTemplateList=dto.getReportTemplateList();
			vo.setReportTemplateList(reportTemplateList);
			vo.setReportAnnexationList(dto.getRaInfoList());
			req.getSession().setAttribute("reportTemplateList", reportTemplateList);
			vo.setRtDateType(form.getRmDateType());
			super.<IGRPT02051VO>setVO(req, vo);
			log.debug("===报表修改初始化处理结束===");
		}
		//更新处理
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("===报表修改处理开始===");
			//取得05Form
			IGRPT0205Form form=(IGRPT0205Form)actionForm;
			dto.setIgrpt0205Form(form);
			ctlBL.updateReportManageInstance(dto);
			form.setMode("1");
			log.debug("===报表修改处理结束===");
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
