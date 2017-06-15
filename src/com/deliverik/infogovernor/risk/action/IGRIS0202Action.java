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
 * ���ռ��Ǽǻ���Action����
 *
 */
public class IGRIS0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0202Action.class);

	/**
	 * ���ռ��ǼǴ���
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGRIS0202Form form = (IGRIS0202Form)actionForm;
		
		//BLȡ��
		IGRIS02BL ctlBL = (IGRIS02BL) getBean("igris02BL");
		//����
		AttachmentBL attachmentBL = (AttachmentBL)getBean("attachmentBL");
		//DTO����
		IGRIS02DTO dto = new IGRIS02DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========���ռ���������������ʾ����ʼ========");
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
			
			//form.setRcstartdate(IGStringUtils.getCurrentDateTime());//���ÿ�ʼʱ��Ϊ��ǰʱ��
			//form.setRcenddate("2020/12/31 00:00");//���ý���ʱ��
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001","���ռ�������Ϣ"));
			log.debug("========���ռ���������������ʾ��������========");
			return mapping.findForward("DISP");
		}else if("INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				log.debug("========���ռ����������ʼ========");
			
//				//��ʼ��Ϊ�ر�״̬
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
				//����BL����
//				if (isTokenValid(req, true)){
//					dto = ctlBL.insertRiskCheckAction(dto);
					dto = ctlBL.insertCheckStrategAction(dto);
					dto.getIgRIS0202Form().setRcstatus(IGRISCONSTANTS.RISKCHECK_STATUS_ENABLE);
					//�ı���״̬�������Զ���鹤��
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
				log.debug("========���ռ��������������========");
			} else {
				//��Ϣ���
				log.debug("========���ռ��������ʼ========");
				dto.setIgRIS0202Form(form);
				dto.setRiskCheck(form);
				//����BL���
				dto = ctlBL.updateRiskCheckAction(dto);
				
				log.debug("========���ռ������������========");
			}
			//req.setAttribute("mode", form.getMode());
		}else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========���ռ����������ʾ����ʼ========");
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
			log.debug("========���ռ����������ʾ��������========");
		}else if("sel".equals(mapping.getParameter())){
			log.debug("========��鹤��ִ�в�ѯ��ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0206");
			
			PagingDTO pDto;
			form.setIsNull("1");
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if(form.getCsid()!=null && !(form.getCsid().equals(""))){
				dto.setCsid(form.getCsid());
			}
			log.debug("========�ĵ���ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
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
			
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRIS0206");
			
			//��ѯ���°汾
			
			//DTO��������趨
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
			
			//��������Ϣ��������趨��VO��
			/*IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());*/
			//��鹤��ִ�У��ƻ�����ʱ�䲻�ǲ��Խ���ʱ�䣬��Ӧ���Ǽ�鹤������ʱ���빤��ִ������֮��
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
					String endDate = new  SimpleDateFormat( "yyyy/MM/dd HH:mm" ).format(calendar.getTime());//��ȡ��������ʱ��
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
			log.debug("========��鹤��ִ�в�ѯ��ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0223");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			log.debug("========�ĵ���ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
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
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRIS0223");
			
			//��ѯ���°汾
			
			//DTO��������趨
			dto.setIgRIS0202Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setIgRIS0202Form(form);
			dto = ctlBL.sel(dto);
			
			//��������Ϣ��������趨��VO��
			/*IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());*/
			//��鹤��ִ�У��ƻ�����ʱ�䲻�ǲ��Խ���ʱ�䣬��Ӧ���Ǽ�鹤������ʱ���빤��ִ������֮��
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
					String endDate = new  SimpleDateFormat( "yyyy/MM/dd HH:mm" ).format(calendar.getTime());//��ȡ��������ʱ��
					igris02012vo.setEndDate(endDate);
					voList.add(igris02012vo);
				}
			}
			vo.setIgris02012voList(voList);
			super.<IGRIS02013VO>setVO(req, vo);
			return mapping.findForward("DISP");
		}else if("COPY".equals(mapping.getParameter())){
			//����
			log.debug("========���ռ����Ը��ƿ�ʼ========");
			
			dto.setIgRIS0202Form(form);
			
			dto.setRiskCheck(form);
//			dto = ctlBL.changeRiskCheckStatusAction(dto);
			dto = ctlBL.copyCheckStrategyStatusAction(dto);
			log.debug("========���ռ����Ը�������========");
		}else if("DETAIL".equals(mapping.getParameter())){
			
		}else if("LOADFILE".equals(mapping.getParameter())){
			//��������
			log.debug("========֪ͨ�������ش���ʼ========");
			String attId = req.getParameter("attid");	
			String type = "svc";
			req.setAttribute("type", type);
			req.setAttribute("attId", attId);

			log.debug("========֪ͨ�������ش������========");
			return mapping.findForward("LOADFILE");
		}
		
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
