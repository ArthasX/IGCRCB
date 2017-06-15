package com.deliverik.infogovernor.asset.action;

import java.util.HashMap;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM32BL;
import com.deliverik.infogovernor.asset.dto.IGASM32DTO;
import com.deliverik.infogovernor.asset.form.IGASM3202Form;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCondImpl;
import com.deliverik.infogovernor.asset.vo.IGASM32021VO;
import com.deliverik.infogovernor.svc.bl.IGSVC01BL;
import com.deliverik.infogovernor.svc.dto.IGSVC01DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0100Form;

/**
 * 文档编辑画面Action处理
 *
 * @author
 */
public class IGASM3202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM3202Action.class);

	/**
	 * 事件处理
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
		IGASM3202Form form = (IGASM3202Form)actionForm;
		
		//BL取得
		IGASM32BL ctlBL = (IGASM32BL) getBean("IGASM32BL");
		
		//DTO生成
		IGASM32DTO dto = new IGASM32DTO();
		
		
		//存放最高版本
		Integer highVersion = null;
		
		//存放所拥有的版本
		Map<Integer,Integer> checkVersionMap = new HashMap<Integer, Integer>();
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			log.debug("========风险事件登记画面初期显示处理开始========");
			forward = "DISP";
			log.debug("========风险事件登记画面初期显示处理结束========");
		}else if( "INSERT".equals(mapping.getParameter())){
			log.debug("========风险事件登记处理开始========");
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			form.setEiorgsyscoding(user.getOrgid());
			form.setEiuserid(user.getUserid());
			form.setEiusername(user.getUsername());
			
			dto.setIgasm3202Form(form);
			
			dto = ctlBL.insertEntityItemAction(dto);
			
			
			IGASM32021VO vo = new IGASM32021VO(dto.getEiid());
			if(form.getRiskid()!=null && !(form.getRiskid().equals(""))){
				vo.setRiskid(Integer.parseInt(form.getRiskid()));	
			}
			
			vo.setRiskjobid(form.getRiskjobid());
			super.<IGASM32021VO>setVO(req.getSession(), vo);
			if(form!=null && form.getFlag()!=null && form.getFlag().equals("1")){
				forward = "SUCCESS2";
			}else{
				forward = "SUCCESS";				
			}
			log.debug("========风险事件登记处理终了========");
		}else if( "EDIT_DISP".equals(mapping.getParameter())){
			log.debug("========风险事件处理初始化开始========");
			getPaginDTO(req,"IGASM3202");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			dto.setIgasm3202Form(form);
			
			int maxCnt = getMaxDataCount("IGASM3202");
			
			//查询最新版本
			dto.setEiid(form.getEiid());
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			RiskcaseVWSearchCondImpl cond = new RiskcaseVWSearchCondImpl();
			cond.setEiid(form.getEiid());
			cond.setVersion("0");
			dto.setRiskcaseVWSearchCond(cond);
			dto = ctlBL.searchEntityItemAction(dto);
			copyArgu(dto);
			Map<Integer,Integer> maps = dto.getIgasm3202Form().getCheckVersionMap();
			for(int i=0;i<maps.size();i++){
				highVersion = maps.get(i);
			}
			
			//查询相关工作名称
			String riskjobid = dto.getIgasm3202Form().getRiskjobid();
			String riskEiid = dto.getIgasm3202Form().getRiskid();
			if(riskjobid==null || riskjobid.equals("")){
				riskjobid = req.getParameter("riskjobid");
			}
			if(riskEiid == null || riskEiid.equals("")){
				riskEiid = req.getParameter("riskEiid");
			}
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			//记录相关评估工作的名称
			String name = "";
			//判断相关工作的名称流程ID是否为空
			if(riskjobid !=null && !(riskjobid.equals(""))){
				IGSVC0100Form form1 = new IGSVC0100Form();
				form1.setPrpdid("01001");
				IGSVC01BL ctlBL1 = (IGSVC01BL) getBean("igsvc01BL");
				IGSVC01DTO dto01 = new IGSVC01DTO();
				getPaginDTO(req,"IGSVC0106");
				PagingDTO pDto2;
				pDto2 = (PagingDTO)req.getAttribute("PagingDTO");
				
				dto01.setMaxSearchCount(100000);
				dto01.setPagingDto(pDto2);
				form1.setUserid_q(user.getUserid());
				form1.setSing("DESC");
				form1.setOrder("prclosetime desc , propentime ");
				dto01.setPrSearchCond(form1);
				//调用BL查询
				dto01 = ctlBL1.getProcessRecords(dto01);
				
				if(dto01.getProcessList() !=null && dto01.getProcessList().size()>0  ){
					name = dto01.getProcessList().get(0).getPrtitle();
				}
			}
			dto.getIgasm3202Form().setEiversion(highVersion.toString());
			dto.getIgasm3202Form().setFcriskname(dto.getRiskcaseVWList().get(0).getFcriskname());
			dto.getIgasm3202Form().setFccheckjob(name);
			dto.getIgasm3202Form().setFctypename(dto.getRiskcaseVWList().get(0).getRisktype());
			dto.getIgasm3202Form().setFcseveritylevel(dto.getRiskcaseVWList().get(0).getFcseveritylevel());
			dto.getIgasm3202Form().setFcpossibility(dto.getRiskcaseVWList().get(0).getFcpossibility());
			dto.getIgasm3202Form().setFclevel(dto.getRiskcaseVWList().get(0).getFclevel());
			req.setAttribute("IGASM3202Form", dto.getIgasm3202Form());
			req.setAttribute("highVersion", highVersion);
			forward = "DISP";
			log.debug("========风险事件处理初始化终了========");
		}else if( "UPDATE".equals(mapping.getParameter())){
			log.debug("========风险事件处理开始========");
			dto.setIgasm3202Form(form);	
			dto = ctlBL.updateEntityItem(dto);
			IGASM32021VO vo = new IGASM32021VO(form.getEiid());
			super.<IGASM32021VO>setVO(req.getSession(), vo);
			forward = "SUCCESS";
			req.setAttribute("flag", "1");
			log.debug("========风险事件处理终了========");
		}else if( "VERSION".equals(mapping.getParameter())){
			log.debug("========风险事件处理开始========");
			dto.setIgasm3202Form(form);
			//查询最新版本
			dto.setEiid(form.getEiid());
			RiskcaseVWSearchCondImpl cond = new RiskcaseVWSearchCondImpl();
			cond.setEiid(form.getEiid());
			cond.setVersion(form.getEiversion());
			dto.setRiskcaseVWSearchCond(cond);
			dto = ctlBL.searchEntityItemByVersion(dto);
			copyArgu(dto);
			
			highVersion = Integer.parseInt(req.getParameter("highVersion"));
			
			for(int i=0;highVersion!=null && i<highVersion;i++){
				checkVersionMap.put(i, i+1);
			}
			dto.getIgasm3202Form().setCheckVersionMap(checkVersionMap);
			dto.getIgasm3202Form().setFcriskname(dto.getRiskcaseVWList().get(0).getFcriskname());
			dto.getIgasm3202Form().setFctypename(dto.getRiskcaseVWList().get(0).getRisktype());
			dto.getIgasm3202Form().setFcseveritylevel(dto.getRiskcaseVWList().get(0).getFcseveritylevel());
			dto.getIgasm3202Form().setFcpossibility(dto.getRiskcaseVWList().get(0).getFcpossibility());
			dto.getIgasm3202Form().setFclevel(dto.getRiskcaseVWList().get(0).getFclevel());
			req.setAttribute("IGASM3202Form", dto.getIgasm3202Form());
			req.setAttribute("highVersion", highVersion);
			forward = "SUCCESS";
			log.debug("========风险事件处理终了========");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		
		return mapping.findForward(forward);
	}
	
	private void copyArgu(IGASM32DTO dto){
		List<RiskcaseVWInfo> list = dto.getRiskcaseVWList();
		IGASM3202Form form = dto.getIgasm3202Form();
		if(list!=null && list.size()==1){
			RiskcaseVWInfo ri = list.get(0);
			form.setEiid(ri.getEIID());
			form.setEistatus(ri.getEISTATUS());
			form.setFcname(ri.getFcname());
			form.setFcdesc(ri.getFcdesc());
			form.setFcorigin(ri.getFcorigin());
			form.setFccategory(ri.getFccategory());
			//相关评估工作名称
			
			form.setRiskjobid(ri.getRiskjobid());
			//风险点名称
			
			form.setRiskid(ri.getRiskid());
			//风险点分类名称
			
			form.setRisktype(ri.getRisktype());
			form.setFcseveritylevel(ri.getFcseveritylevel());
			form.setFcpossibility(ri.getFcpossibility());
			form.setFclevel(ri.getFclevel());
			form.setRiskcatchtime(ri.getRiskcatchtime());
			form.setRisktype(ri.getRisktype());
			form.setFcrisktask(ri.getFcrisktask());
			form.setFcrisktaskdesc(ri.getFcrisktaskdesc());
			form.setFcpolicy(ri.getFcpolicy());
			form.setFcoperatoraim(ri.getFcoperatoraim());
			form.setFcoperatordept(ri.getFcoperatordept());
			form.setRiskoperatordept(ri.getRiskoperatordept());
			form.setFcoperator(ri.getFcoperator());
			form.setRiskoperator(ri.getRiskoperator());
			form.setFcccoperator(ri.getFcccoperator());
			form.setRiskccoperator(ri.getRiskccoperator());
			form.setRiskreviewresult(ri.getRiskreviewresult());
			form.setRiskdealid(ri.getRiskdealid());
			/**
			 * 设置版本选择下拉框
			 */
			Map<Integer,Integer> checkVersionMap = new LinkedHashMap<Integer, Integer>();
			for (int i=0;i<Integer.parseInt(ri.getFingerPrint());i++){
				checkVersionMap.put(i,i+1);
			}
			form.setCheckVersionMap(checkVersionMap);
			dto.setIgasm3202Form(form);
		}
	}
}
