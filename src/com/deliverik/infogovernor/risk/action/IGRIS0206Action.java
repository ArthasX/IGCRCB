package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.infogovernor.risk.bl.IGRIS02BL;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0204Form;
import com.deliverik.infogovernor.risk.form.IGRIS0206Form;
import com.deliverik.infogovernor.risk.vo.IGRIS02011VO;

/**
 * 风险检查结果报告查询画面Action处理
 *
 */
public class IGRIS0206Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0206Action.class);

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
		IGRIS0206Form form = (IGRIS0206Form)actionForm;
		
		//BL取得
		IGRIS02BL ctlBL = (IGRIS02BL) getBean("igris02BL");
		
		//DTO生成
		IGRIS02DTO dto = new IGRIS02DTO();
		
		//User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		if( "DISP".equals(mapping.getParameter())){
			//类型查询画面初期显示处理
			log.debug("========风险检查结果阶段查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			// 判断计划执行检查开始日期是否存在
			if(StringUtils.isEmpty(form.getStartdate())){
				//时间格式
				java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
                "yyyy/MM/dd");
				Calendar c = Calendar.getInstance();
				c.set(Calendar.DATE, 1);
				//预置执行检查开始日期
				form.setStartdate(df.format(c.getTime()));
				//预置执行检查结束日期
				form.setEnddate(df.format(Calendar.getInstance().getTime()));
			}
			log.debug("========风险检查结果阶段查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if( "POPDISP".equals(mapping.getParameter())){
			//类型查询画面初期显示处理
			log.debug("========风险检查结果阶段查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========风险检查结果阶段查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if( "POPSEARCH".equals(mapping.getParameter())||"POPSEARCH1".equals(mapping.getParameter())){
			//类型查询处理
			log.debug("========风险检查结果阶段查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGRIS0206");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRIS0206Form) req.getSession().getAttribute("IGRIS0206Form");
				if ( form == null ) {
					form = new IGRIS0206Form();
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
					form = (IGRIS0206Form) req.getSession().getAttribute("IGRIS0206Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRIS0206");
			
			//DTO输入参数设定			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto.setIgRIS0206Form(form);
			
			//dto.setUser(user);
			
			//信息检索逻辑调用
			dto = ctlBL.searchRiskCheckResultReportByPeriodAction(dto);
			
			//将类型信息检索结果设定到VO中
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());

			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========风险检查结果阶段查询处理终了========");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//类型查询处理
			log.debug("========风险检查结果阶段查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGRIS0206");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRIS0206Form) req.getSession().getAttribute("IGRIS0206Form");
				if ( form == null ) {
					form = new IGRIS0206Form();
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
					form = (IGRIS0206Form) req.getSession().getAttribute("IGRIS0206Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRIS0206");
			
			//DTO输入参数设定
			
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto.setIgRIS0206Form(form);
			
			//dto.setUser(user);
			
			//信息检索逻辑调用
			dto = ctlBL.searchRiskCheckResultReportByPeriodAction(dto);
			
			//将类型信息检索结果设定到VO中
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());

			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========风险检查结果阶段查询处理终了========");
		}else if ("POPREAD".equals(mapping.getParameter())){
			log.debug("========风险检查阶段结果查看处理开始========");
			// 将form1做为容器，存放风险检查阶段查询条件
			IGRIS0204Form form1 = new IGRIS0204Form();
			// 将风险检查结果ID放入容器
			form1.setRcrid(form.getRcrid());
			dto.setIgRIS0204Form(form1);
			//信息检索逻辑调用
			dto = ctlBL.readRiskCheckResultReportAction(dto);
			//将类型信息检索结果设定到VO中
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResult(dto.getRiskCheckResult());
			vo.setAttachmentDataList(dto.getAttachmentList());
			super.<IGRIS02011VO>setVO(req, vo);
			log.debug("========风险检查阶段结果查看处理终了========");
		}else if ("READ".equals(mapping.getParameter())){
			log.debug("========风险检查阶段结果查看处理开始========");
			// 将form1做为容器，存放风险检查阶段结果查询条件
			IGRIS0204Form form1 = new IGRIS0204Form();
			// 将风险检查结果ID放入容器
			form1.setRcrid(form.getRcrid());
			dto.setIgRIS0204Form(form1);
			//信息检索逻辑调用
			dto = ctlBL.readRiskCheckResultReportAction(dto);
			//将类型信息检索结果设定到VO中
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResult(dto.getRiskCheckResult());
			vo.setAttachmentDataList(dto.getAttachmentList());
			super.<IGRIS02011VO>setVO(req, vo);
			log.debug("========风险检查阶段结果查看处理终了========");
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
