package com.deliverik.infogovernor.risk.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.risk.bl.IGRIS02BL;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0204Form;
import com.deliverik.infogovernor.risk.form.IGRIS0205Form;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckTB;
import com.deliverik.infogovernor.risk.vo.IGRIS02011VO;
import com.deliverik.infogovernor.risk.vo.IGRIS02012VO;
import com.deliverik.infogovernor.risk.vo.IGRIS02013VO;

/**
 * 风险检查结果报告查询画面Action处理
 *
 */
public class IGRIS0205Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0205Action.class);

	/**
	 * 风险检查结果报告查询处理
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
		IGRIS0205Form form = (IGRIS0205Form)actionForm;
		
		//BL取得
		IGRIS02BL ctlBL = (IGRIS02BL) getBean("igris02BL");
		
		//DTO生成
		IGRIS02DTO dto = new IGRIS02DTO();
		
		//获取发起角色列表
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
		dto.setUser(user);
		
		String forward = req.getParameter("return");
		if( "LASTDISP".equals(mapping.getParameter())){
			//类型查询画面初期显示处理
			log.debug("========最后一次风险检查结果查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========最后一次风险检查结果查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if( "SUPERVISE_DISP".equals(mapping.getParameter())){
			log.debug("========检查工作监督查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========检查工作监督查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if( "POPDISP".equals(mapping.getParameter())){
			log.debug("========最后一次风险检查结果查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========最后一次风险检查结果查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if( "POPSEARCH".equals(mapping.getParameter())||"POPSEARCH1".equals(mapping.getParameter())){
			//类型查询处理
			log.debug("========最后一次风险检查结果查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGRIS0205");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("LASTSEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRIS0205Form) req.getSession().getAttribute("IGRIS0205Form");
				if ( form == null ) {
					form = new IGRIS0205Form();
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
					form = (IGRIS0205Form) req.getSession().getAttribute("IGRIS0205Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRIS0205");
			
			//DTO输入参数设定
			
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto.setIgRIS0205Form(form);
			
			//dto.setUser(user);
			
			//信息检索逻辑调用
			dto = ctlBL.searchLastRiskCheckResultReportAction(dto);
			
			
			//req.setAttribute("pageNum", pDto.getFromCount());
			//req.setAttribute("pageCount", pDto.getPageDispCount());
	
			//将类型信息检索结果设定到VO中
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());

			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========最后一次风险检查结果查询处理终了========");
		}else if( "LASTSEARCH".equals(mapping.getParameter())||"LASTSEARCH1".equals(mapping.getParameter())){
			//类型查询处理
			log.debug("========最后一次风险检查结果查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGRIS0205");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("LASTSEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRIS0205Form) req.getSession().getAttribute("IGRIS0205Form");
				if ( form == null ) {
					form = new IGRIS0205Form();
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
					form = (IGRIS0205Form) req.getSession().getAttribute("IGRIS0205Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRIS0205");
			
			//DTO输入参数设定
			
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			// 如果从Dashboard页进入,需要查询未检查工作paicode=V
			if("V".equals(req.getParameter("paicode"))){
				// 2为未检查查询标识
				form.setRcrstatic("2");
			}
			
			dto.setIgRIS0205Form(form);
			
			//dto.setUser(user);
			
			//信息检索逻辑调用
			dto = ctlBL.searchCheckWorkResulReportAction(dto);
			
			
			//req.setAttribute("pageNum", pDto.getFromCount());
			//req.setAttribute("pageCount", pDto.getPageDispCount());
	
			//将类型信息检索结果设定到VO中
			/*IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());

			super.<IGRIS02011VO>setVO(req, vo);*/
			//检查工作执行，计划结束时间不是策略结束时间，而应该是检查工作发起时间与工作执行期限之和
			IGRIS02013VO vo = new IGRIS02013VO();
			List<IGRIS02012VO> voList = new ArrayList<IGRIS02012VO>();
			IGRIS02012VO igris02012vo = null;
			if(dto.getCheckWorkResultInfos()!=null){
				for(CheckWorkResultInfo riskCheckResult:dto.getCheckWorkResultInfos()){
					igris02012vo = new IGRIS02012VO();
					igris02012vo.setCheckWorkResultInfo(riskCheckResult);
					
					voList.add(igris02012vo);
				}
			}
			vo.setIgris02012voList(voList);
			super.<IGRIS02013VO>setVO(req, vo);
			
			log.debug("========最后一次风险检查结果查询处理终了========");
		}else if( "SUPERVISE".equals(mapping.getParameter())||"SUPERVISE1".equals(mapping.getParameter())){
			//类型查询处理
			log.debug("========检查工作监督结果查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGRIS0205");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SUPERVISE1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRIS0205Form) req.getSession().getAttribute("IGRIS0205Form");
				if ( form == null ) {
					form = new IGRIS0205Form();
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
					form = (IGRIS0205Form) req.getSession().getAttribute("IGRIS0205Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRIS0205");
			
			//DTO输入参数设定
			
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
//			// 如果从Dashboard页进入,需要查询未检查工作paicode=V
//			if("V".equals(req.getParameter("paicode"))){
//				// 2为未检查查询标识
//				form.setRcrstatic("2");
//			}
//			
			dto.setIgRIS0205Form(form);
			
			//dto.setUser(user);
			
			//信息检索逻辑调用
//			dto = ctlBL.searchSuperviseRiskCheckResultReportAction(dto);
			dto = ctlBL.searchCheckWorkResulReportAction(dto);
			
			//req.setAttribute("pageNum", pDto.getFromCount());
			//req.setAttribute("pageCount", pDto.getPageDispCount());
			
			/*//将类型信息检索结果设定到VO中
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());
			
			super.<IGRIS02011VO>setVO(req, vo);*/
			
			IGRIS02013VO vo = new IGRIS02013VO();
			List<IGRIS02012VO> voList = new ArrayList<IGRIS02012VO>();
			IGRIS02012VO igris02012vo = null;
			if(dto.getCheckWorkResultInfos()!=null){
				for(CheckWorkResultInfo riskCheckResult:dto.getCheckWorkResultInfos()){
					igris02012vo = new IGRIS02012VO();
					igris02012vo.setCheckWorkResultInfo(riskCheckResult);
					
					voList.add(igris02012vo);
				}
			}
			vo.setIgris02012voList(voList);
			super.<IGRIS02013VO>setVO(req, vo);
			
			log.debug("========检查工作监督结果查询处理终了========");
		}else if ("LASTREAD".equals(mapping.getParameter())){
			log.debug("========最后一次风险检查结果查看处理开始========");
			
			IGRIS0204Form form1 = new IGRIS0204Form();
			form1.setRcrid(form.getRcrid());
			dto.setIgRIS0204Form(form1);
			dto = ctlBL.readRiskCheckResultReportAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResult(dto.getRiskCheckResult());
			vo.setAttachmentDataList(dto.getAttachmentList());
			//返回标识；1：返回检查工作监督查询页
			vo.setMode(form.getMode());
			super.<IGRIS02011VO>setVO(req, vo);
			log.debug("========最后一次风险检查结果查看处理终了========");
			
		}else if ("POPREAD".equals(mapping.getParameter())){
			log.debug("========最后一次风险检查结果查看处理开始========");
			IGRIS0204Form form1 = new IGRIS0204Form();
			form1.setRcrid(form.getRcrid());
			dto.setIgRIS0204Form(form1);
			dto = ctlBL.readRiskCheckResultReportAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResult(dto.getRiskCheckResult());
			vo.setAttachmentDataList(dto.getAttachmentList());
			super.<IGRIS02011VO>setVO(req, vo);
			log.debug("========最后一次风险检查结果查看处理终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		if(StringUtils.isNotEmpty(forward)){
			return mapping.findForward("READ");
		}else{
			return mapping.findForward("DISP");
		}
	}
}
