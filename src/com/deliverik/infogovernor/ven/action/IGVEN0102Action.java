package com.deliverik.infogovernor.ven.action;

import java.util.ArrayList;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.risk.bl.IGRISCONSTANTS;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.ven.bl.IGVEN01BL;
import com.deliverik.infogovernor.ven.dto.IGVEN01DTO;
import com.deliverik.infogovernor.ven.form.IGVEN0102Form;
import com.deliverik.infogovernor.ven.vo.IGVEN01021VO;

/**
 * 风险检查登记画面Action处理
 *
 */
public class IGVEN0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVEN0102Action.class);

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
	@Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGVEN0102Form form = (IGVEN0102Form)actionForm;
		
		//BL取得
		IGVEN01BL ctlBL = (IGVEN01BL) getBean("igven01BL");
		//DTO生成
		IGVEN01DTO dto = new IGVEN01DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========风险检查新增画面初期显示处理开始========");
			dto = ctlBL.dispRiskCheckAction(dto);
			IGVEN01021VO vo = new IGVEN01021VO();
			Map<String, List<RiskCheck>> map = new LinkedHashMap<String, List<RiskCheck>>();
			Map<Integer,String> mapType = new LinkedHashMap<Integer,String>();
			
			vo.setWeekList(dto.getWeekList());
			vo.setMonthList(dto.getMonthList());
			vo.setRiskCheckmap(map);
			vo.setMapType(mapType);
			
			super.<IGVEN01021VO>setVO(req, vo);
			form.setRcfrequencymonthlastday(null);
			
			//form.setRcstartdate(IGStringUtils.getCurrentDateTime());//设置开始时间为当前时间
			//form.setRcenddate("2020/12/31 00:00");//设置结束时间
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001","风险检查基本信息"));
			log.debug("========风险检查新增画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if( "INSERT".equals(mapping.getParameter())){
		if (form.getMode().equals("0")){
			log.debug("========风险检查新增处理开始========");
		
//				//初始化为关闭状态
//				form.setRcstatus("0");
			dto.setIgVEN0102Form(form);
			
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
				dto.getIgVEN0102Form().setRcstatus(IGRISCONSTANTS.RISKS_STRATEGY_ENABLE);
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
		}else {
				//信息变更
				log.debug("========风险检查变更处理开始========");
				dto.setIgVEN0102Form(form);
				//调用BL变更
				dto = ctlBL.updateRiskCheckAction(dto);
				
				log.debug("========风险检查变更处理终了========");
			}
			//req.setAttribute("mode", form.getMode());
		}else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========风险检查变更初期显示处理开始========");
			dto.setIgVEN0102Form(form);
			form.setMode("1");
			
			dto = ctlBL.searchCheckStrategyByCsid(dto);

			dto = ctlBL.dispRiskCheckAction(dto);
			//req.setAttribute("riskcheck",dto.getRiskCheck());
			IGVEN01021VO vo = new IGVEN01021VO();
			vo.setWeekList(dto.getWeekList());
			vo.setMonthList(dto.getMonthList());
			vo.setRiskCheckmap(dto.getRiskCheckmap());
			vo.setMapType(dto.getMapType());
			vo.setIgVEN0102Form(dto.getIgVEN0102Form());
			vo.setRiskCheckList(dto.getRiskCheckList());
			vo.setAttachmentDataList(dto.getAttachmentList());
			super.<IGVEN01021VO>setVO(req, vo);
			log.debug("========风险检查变更初期显示处理终了========");
		}else if("COPY".equals(mapping.getParameter())){
			//复制
			log.debug("========风险检查策略复制开始========");
			
			dto.setIgVEN0102Form(form);
			dto = ctlBL.copyCheckStrategyStatusAction(dto);
			log.debug("========风险检查策略复制终了========");
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
	
