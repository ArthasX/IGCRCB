package com.deliverik.infogovernor.risk.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.risk.bl.IGRIS02BL;
import com.deliverik.infogovernor.risk.bl.IGRISCONSTANTS;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0202Form;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckTB;
import com.deliverik.infogovernor.risk.vo.IGRIS02012VO;
import com.deliverik.infogovernor.risk.vo.IGRIS02013VO;
import com.deliverik.infogovernor.risk.vo.IGRIS02021VO;

/**
 * 风险检查登记画面Action处理
 *
 */
public class IGRIS0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0202Action.class);

	/**
	 * 风险检查登记处理
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
		IGRIS0202Form form = (IGRIS0202Form)actionForm;
		
		//BL取得
		IGRIS02BL ctlBL = (IGRIS02BL) getBean("igris02BL");
		//附件
		AttachmentBL attachmentBL = (AttachmentBL)getBean("attachmentBL");
		//DTO生成
		IGRIS02DTO dto = new IGRIS02DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========风险检查新增画面初期显示处理开始========");
			dto = ctlBL.dispRiskCheckAction(dto);
			IGRIS02021VO vo = new IGRIS02021VO();
			Map<String, List<RiskCheck>> map = new LinkedHashMap<String, List<RiskCheck>>();
			Map<Integer,String> mapType = new LinkedHashMap<Integer,String>();
			
			vo.setWeekList(dto.getWeekList());
			vo.setMonthList(dto.getMonthList());
			vo.setRiskCheckmap(map);
			vo.setMapType(mapType);
			
			super.<IGRIS02021VO>setVO(req, vo);
			form.setRcfrequencymonthlastday(null);
			
			//form.setRcstartdate(IGStringUtils.getCurrentDateTime());//设置开始时间为当前时间
			//form.setRcenddate("2020/12/31 00:00");//设置结束时间
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001","风险检查基本信息"));
			log.debug("========风险检查新增画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if("INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				log.debug("========风险检查新增处理开始========");
			
//				//初始化为关闭状态
//				form.setRcstatus("0");
				dto.setIgRIS0202Form(form);
				
				dto.setRiskCheck(form);
				String[] eiids = form.getEiids().split(",");
				String[] eiversions = form.getEiversions().split(",");
				List<String> eiidList = new ArrayList<String>();
				List<String> eiversionList = new ArrayList<String>();
				for(int i=0;i<eiids.length;i++){
					eiidList.add(eiids[i]);
					if(eiversions[i] == null || eiversions[i].equals("") || eiversions[i].equals("null")){
						eiversions[i] = "1";
					}
					eiversionList.add(eiversions[i]);
				}
//				List<String> eiidList = new ArrayList<String>(Arrays.asList(eiids));
// 				List<String> eiversionList = new ArrayList<String>(Arrays.asList(eiversions));
/*				if(req.getSession().getAttribute("eiidWindow")!=null && !(req.getSession().getAttribute("eiidWindow").equals("")) ){
					eiidList.add(req.getSession().getAttribute("eiidWindow").toString());
					req.getSession().removeAttribute("eiidWindow");
					eiversionList.add("1");
//					eiversions[eiversions.length] = "1";
				}*/
				dto.setEiids(eiidList);
				dto.setEiversions(eiversionList);
				//调用BL新增
//				if (isTokenValid(req, true)){
//					dto = ctlBL.insertRiskCheckAction(dto);
					dto = ctlBL.insertCheckStrategAction(dto);
					dto.getIgRIS0202Form().setRcstatus(IGRISCONSTANTS.RISKCHECK_STATUS_ENABLE);
					//改变其状态，让其自动检查工作
//					for(int i=0;i<dto.getRiskCheckList().size();i++){
//						RiskCheck riskcheck = dto.getRiskCheckList().get(i);
//						dto.getIgRIS0202Form().setRcid(riskcheck.getRcid());
//						dto.setRiskCheck(riskcheck);
//						dto = ctlBL.changeRiskCheckStatusAction(dto);
//					}
//					dto = ctlBL.changeCheckStrategyStatusAction(dto);
//				}else{
//					addMessage(req, new ActionMessage("IGCO00000.E007"));
//					return mapping.findForward("/error1");
//				}
				log.debug("========风险检查新增处理终了========");
			} else {
				//信息变更
				log.debug("========风险检查变更处理开始========");
				dto.setIgRIS0202Form(form);
				dto.setRiskCheck(form);
				//调用BL变更
				dto = ctlBL.updateRiskCheckAction(dto);
				
				log.debug("========风险检查变更处理终了========");
			}
			//req.setAttribute("mode", form.getMode());
		}else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========风险检查变更初期显示处理开始========");
			dto.setIgRIS0202Form(form);
			form.setMode("1");
			
//			dto = ctlBL.initupdateRiskCheckAction(dto);
			dto = ctlBL.searchCheckStrategyByCsid(dto);

			dto = ctlBL.dispRiskCheckAction(dto);
			req.setAttribute("riskcheck",dto.getRiskCheck());
			IGRIS02021VO vo = new IGRIS02021VO();
			vo.setWeekList(dto.getWeekList());
			vo.setMonthList(dto.getMonthList());
			vo.setRiskCheckmap(dto.getRiskCheckmap());
			vo.setMapType(dto.getMapType());
			vo.setIgRIS0202Form(dto.getIgRIS0202Form());
			vo.setRiskCheckList(dto.getRiskCheckList());
			vo.setCheckStrategyInfo(dto.getCheckStrategyInfo());
//			vo.setWeekList(dto.getWeekList());
//			vo.setMonthList(dto.getMonthList());
//			vo.setAttachmentDataList(dto.getAttachmentList());
			super.<IGRIS02021VO>setVO(req, vo);
			log.debug("========风险检查变更初期显示处理终了========");
		}else if("sel".equals(mapping.getParameter())){
			log.debug("========检查工作执行查询开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGRIS0206");
			
			PagingDTO pDto;
			form.setIsNull("1");
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if(form.getCsid()!=null && !(form.getCsid().equals(""))){
				dto.setCsid(form.getCsid());
			}
			log.debug("========文档查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRIS0202Form) req.getSession().getAttribute("IGRIS0202Form");
				if ( form== null){
					form = new IGRIS0202Form();
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
					form = (IGRIS0202Form) req.getSession().getAttribute("IGRIS0202Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRIS0206");
			
			//查询最新版本
			
			//DTO输入参数设定
			dto.setIgRIS0202Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			Integer cwrid = (Integer) req.getAttribute("cwrid");
			if(cwrid!=null && !(cwrid.equals(""))){
				dto.getIgRIS0202Form().setCwrid(cwrid);
			}
			if(req.getSession().getAttribute("rcclass")!=null){
				dto.getIgRIS0202Form().setRcclass((String)req.getSession().getAttribute("rcclass"));
			}
			if(req.getSession().getAttribute("rcrplandate_from")!=null){
				dto.getIgRIS0202Form().setRcrplandate_from((String)req.getSession().getAttribute("rcrplandate_from"));
			}
			if(req.getSession().getAttribute("rcrplandate_to")!=null){
				dto.getIgRIS0202Form().setRcrplandate_to((String)req.getSession().getAttribute("rcrplandate_to"));
			}
			if(req.getSession().getAttribute("rcusername")!=null){
				dto.getIgRIS0202Form().setRcusername((String)req.getSession().getAttribute("rcusername"));
			}
			if(dto.getCsid()!=null && !(dto.getCsid().equals(""))){
				form.setCsid(dto.getCsid());
			}
			dto = ctlBL.sel(dto);
			
			//将类型信息检索结果设定到VO中
			/*IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());*/
			//检查工作执行，计划结束时间不是策略结束时间，而应该是检查工作发起时间与工作执行期限之和
			IGRIS02013VO vo = new IGRIS02013VO();
			List<IGRIS02012VO> voList = new ArrayList<IGRIS02012VO>();
			IGRIS02012VO igris02012vo = null;
			if(dto.getRiskCheckResultDataList()!=null){
				for(RiskCheckResult riskCheckResult:dto.getRiskCheckResultDataList()){
					igris02012vo = new IGRIS02012VO();
					igris02012vo.setRiskCheckResult(riskCheckResult);
					RiskCheckTB risk = riskCheckResult.getRiskCheck();
					String rcstartdate = riskCheckResult.getRcrplandate();
					SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm");
					Date date=null;
					try {
						date = sdf.parse(rcstartdate);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					//Integer wtip = risk.getWtip();
					/*if(wtip==null){
						wtip=0;
					}
					calendar.add(Calendar.HOUR_OF_DAY, wtip);*/
					String endDate = new  SimpleDateFormat( "yyyy/MM/dd HH:mm" ).format(calendar.getTime());//获取到完整的时间
					igris02012vo.setEndDate(endDate);
					List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(riskCheckResult.getRcrattch());
					if(null != attachmentList && attachmentList.size() > 0){
						igris02012vo.setAttid(attachmentList.get(0).getAttid());
						igris02012vo.setAttname(attachmentList.get(0).getAttname().split("_")[1]);
					}
					voList.add(igris02012vo);
				}
			}
			vo.setIgris02012voList(voList);
			req.setAttribute("cwrid", form.getCwrid());
			super.<IGRIS02013VO>setVO(req, vo);
			return mapping.findForward("DISP");
		}else if("sell".equals(mapping.getParameter())){
			log.debug("========检查工作执行查询开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGRIS0223");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			log.debug("========文档查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRIS0202Form) req.getSession().getAttribute("IGRIS0202Form");
				if ( form== null){
					form = new IGRIS0202Form();
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
//					form = (IGRIS0202Form) req.getSession().getAttribute("IGRIS0202Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRIS0223");
			
			//查询最新版本
			
			//DTO输入参数设定
			dto.setIgRIS0202Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setIgRIS0202Form(form);
			dto = ctlBL.sel(dto);
			
			//将类型信息检索结果设定到VO中
			/*IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());*/
			//检查工作执行，计划结束时间不是策略结束时间，而应该是检查工作发起时间与工作执行期限之和
			IGRIS02013VO vo = new IGRIS02013VO();
			List<IGRIS02012VO> voList = new ArrayList<IGRIS02012VO>();
			IGRIS02012VO igris02012vo = null;
			if(dto.getRiskCheckResultDataList()!=null){
				for(RiskCheckResult riskCheckResult:dto.getRiskCheckResultDataList()){
					igris02012vo = new IGRIS02012VO();
					igris02012vo.setRiskCheckResult(riskCheckResult);
					RiskCheckTB risk = riskCheckResult.getRiskCheck();
					String rcstartdate = riskCheckResult.getRcrplandate();
					SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm");
					Date date=null;
					try {
						date = sdf.parse(rcstartdate);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					Integer wtip = risk.getWtip();
					if(wtip==null){
						wtip=0;
					}
					calendar.set(Calendar. HOUR , Calendar. HOUR + wtip ) ;
					String endDate = new  SimpleDateFormat( "yyyy/MM/dd HH:mm" ).format(calendar.getTime());//获取到完整的时间
					igris02012vo.setEndDate(endDate);
					voList.add(igris02012vo);
				}
			}
			vo.setIgris02012voList(voList);
			super.<IGRIS02013VO>setVO(req, vo);
			return mapping.findForward("DISP");
		}else if("COPY".equals(mapping.getParameter())){
			//复制
			log.debug("========风险检查策略复制开始========");
			
			dto.setIgRIS0202Form(form);
			
			dto.setRiskCheck(form);
//			dto = ctlBL.changeRiskCheckStatusAction(dto);
			dto = ctlBL.copyCheckStrategyStatusAction(dto);
			log.debug("========风险检查策略复制终了========");
		}else if("DETAIL".equals(mapping.getParameter())){
			
		}else if("LOADFILE".equals(mapping.getParameter())){
			//附件下载
			log.debug("========通知附件下载处理开始========");
			String attId = req.getParameter("attid");	
			String type = "svc";
			req.setAttribute("type", type);
			req.setAttribute("attId", attId);

			log.debug("========通知附件下载处理结束========");
			return mapping.findForward("LOADFILE");
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
