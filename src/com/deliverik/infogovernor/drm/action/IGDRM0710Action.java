/**
 * 
 */
package com.deliverik.infogovernor.drm.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.entity.UserInfoVW;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.IGDRM07BL;
import com.deliverik.infogovernor.drm.bl.task.EvaluationContentBL;
import com.deliverik.infogovernor.drm.dto.IGDRM07DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0710Form;
import com.deliverik.infogovernor.drm.model.EvaluationContentInfo;
import com.deliverik.infogovernor.drm.model.condition.EvaluationContentSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.EvaluationContentTB;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.deliverik.infogovernor.drm.util.StepUtil;
import com.deliverik.infogovernor.drm.vo.IGDRM0710VO;
import com.google.gson.Gson;

/**
 * @author Administrator
 *
 */
public class IGDRM0710Action  extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0710Action.class);
	
	@Override
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDRM0710Form form = (IGDRM0710Form) actionForm;
		//BLȡ��
	    IGDRM07BL ctlBL = (IGDRM07BL) getBean("igdrm07BL");
		//DTO����
		IGDRM07DTO dto = new IGDRM07DTO();
		if( "DISP".equals(mapping.getParameter())||"DISP1".equals(mapping.getParameter())){
			log.debug("========�������̻�����Ϣ����ʼ========");
			dto.setIgdrm0710Form(form);
			
			String prid = req.getParameter("prid");
			IG599BL ig599BL = (IG599BL) WebApplicationSupport.getBean("ig599BL");
			IG599SearchCondImpl cond = new IG599SearchCondImpl();
			String emprid ="";
			//������ص�Ӧ��ָ�Ӻʹ���
			if("DISP".equals(mapping.getParameter())){
				//Ӧ��ָ��
				cond.setPrid(Integer.parseInt(prid));
				cond.setPivarname("ָ������prid");
				IG599Info ig599Info = ig599BL.searchIG599InfosByCond(cond).get(0);
				emprid = ig599Info.getPivarvalue();
				if(emprid.isEmpty()){
					//����
					cond.setPrid(Integer.parseInt(prid));
					cond.setPivarname("�����������prid");
				}else{
					//����
					cond.setPrid(Integer.parseInt(emprid));
					cond.setPivarname("����prid");
				}
				dto = ctlBL.searchDrillDetail(dto,"all");
			}else{
				//Ӧ��ָ�ӵ�PRID
				emprid = prid;
				cond.setPrid(Integer.parseInt(emprid));
				cond.setPivarname("����prid");
				dto = ctlBL.searchDrillDetail(dto,"em");
			}
			
			IG599Info senceIG599Info = ig599BL.searchIG599InfosByCond(cond).get(0);
			String seprid = senceIG599Info.getPivarvalue();
			//�˿ںź�IP
			CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
			String port = codeListUtils.getCodeValue("174",null, null, "1");//�˿ں�
			String ip = codeListUtils.getCodeValue("174",null, null, "2");//IP
			//����req����
			req.setAttribute("prid", prid);
			req.setAttribute("emprid", emprid);
			req.setAttribute("seprid", seprid);
			req.setAttribute("port", port);
			req.setAttribute("ip", ip);
			//Ӧ��ָ����������
			EvaluationContentBL ecBL = (EvaluationContentBL) getBean("evaluationContentBL");
			EvaluationContentSearchCondImpl ecCond = new EvaluationContentSearchCondImpl();
			List<EvaluationContentInfo> evaluationContentList = new ArrayList<EvaluationContentInfo>();
			if(!emprid.isEmpty()){
				ecCond.setPrid(Integer.parseInt(emprid));
				ecCond.setFlowType("em");
				evaluationContentList = ecBL.searchEvaluationContent(ecCond, 0, 0);
			}
		
			//Ӧ������
			ecCond = new EvaluationContentSearchCondImpl();
			ecCond.setPrid(Integer.parseInt(seprid));
			List<EvaluationContentInfo> senceContentList = ecBL.searchEvaluationContent(ecCond, 0, 0);
			IGDRM0710VO vo = new IGDRM0710VO();
			if(evaluationContentList!=null &&evaluationContentList.size()>0){
				EvaluationContentInfo emEvaluationContent = evaluationContentList.get(0);
				if(emEvaluationContent.getSortId()==0){
					vo.setEmEvaluationContent(emEvaluationContent);
				}
				
			}
			if(senceContentList!=null && senceContentList.size()!=0 ){
				EvaluationContentInfo seEvaluationContent = senceContentList.get(0);
				if(seEvaluationContent.getSortId()==0){
					vo.setSeEvaluationContent(seEvaluationContent);
				}
			}
			//��������
			ecCond = new EvaluationContentSearchCondImpl();
			ecCond.setPrid(Integer.parseInt(prid));
			ecCond.setFlowType("all");
			List<EvaluationContentInfo> evaluationList = ecBL.searchEvaluationContent(ecCond, 0, 0);
			if(evaluationList!=null && evaluationList.size()>0){
				vo.setEvaluationInfo(evaluationList.get(0));
			}
			vo.setDrillDetailMap(dto.getDrillDetailMap());
			if(!emprid.isEmpty()){
				vo.setEvaluationContentList(evaluationContentList);
				vo.setEvaluationList(evaluationContentList);
			}else{
				vo.setEvaluationList(senceContentList);
			}
			vo.setSenceContentList(senceContentList);
			super.<IGDRM0710VO>setVO(req, vo);
			log.debug("========�������̻�����Ϣ�������========");
		}else if("JSON".equals(mapping.getParameter())){
			String prid="";
			String ylPrid = req.getParameter("prid");
			String flexType = req.getParameter("flexType");
			String emprid = req.getParameter("emprid");
			IG599BL ig599BL = (IG599BL) WebApplicationSupport.getBean("ig599BL");
			IG599SearchCondImpl cond = new IG599SearchCondImpl();
			//�ж�ָ��ID�Ƿ��pridһ����һ����ΪӦ��ָ����������
			if(!emprid.equals(ylPrid)){
				//Ӧ������
				cond.setPrid(Integer.parseInt(ylPrid));
				cond.setPivarname("ָ������prid");
				IG599Info ig599Info = ig599BL.searchIG599InfosByCond(cond).get(0);
				if(flexType.equals("em")){
					prid = ig599Info.getPivarvalue();
				}else{
					if(!ig599Info.getPivarvalue().isEmpty()){
						cond.setPrid(Integer.parseInt(ig599Info.getPivarvalue()));
						cond.setPivarname("����prid");
					}else{
						cond.setPivarname("�����������prid");
					}
					IG599Info senceIG599Info = ig599BL.searchIG599InfosByCond(cond).get(0);
					prid = senceIG599Info.getPivarvalue();
				}
			}else{
				//Ӧ������
				if(flexType.equals("em")){
					prid = emprid;
				}else{
					cond.setPrid(Integer.parseInt(emprid));
					cond.setPivarname("����prid");
					IG599Info senceIG599Info = ig599BL.searchIG599InfosByCond(cond).get(0);
					prid = senceIG599Info.getPivarvalue();
				}
			}
			String type = req.getParameter("type");
			PrintWriter out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(),"UTF-8")); 
			//�ܵ�Map��֪��value��ȷ������������Object
			Map<String, Object> map = new HashMap<String, Object>();
			//�������״̬��Ϣ��ȡ
			try {
				if(type.equals(IGDRMCONSTANTS.DB_TYPE_MESSAGE)){
					map = IGDRMEmergencyTools.getMessageInfo(prid);//6��ȡ��������Ϣ,type=3ok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_PROCESS_START)){
					map = IGDRMEmergencyTools.getProcessStartTime(Integer.parseInt(prid));//8���̿�ʼʱ��ok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_USED_TIME)){
					map = IGDRMEmergencyTools.getProcessUsedTime(Integer.parseInt(prid));//9��������ʱok
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_STOP_TIME)){
					map = IGDRMEmergencyTools.getStopTime(Integer.parseInt(prid));//stopTime ����ʱ��
				} else if(type.equals(IGDRMCONSTANTS.DB_TYPE_BASE_MSG)){
					map = IGDRMEmergencyTools.getBaseMessage(Integer.parseInt(prid));//baseMsg ������Ϣ
				}else if(type.equals(IGDRMCONSTANTS.DB_TYPE_FLOW_MSG)){
					map = IGDRMEmergencyTools.getFlow(Integer.parseInt(prid));//flowMsg ����ͼ
				}else if(type.equals("logMsg")){
					map = IGDRMEmergencyTools.getLogMessage(Integer.parseInt(prid));//logMsg ������־
				}else if(type.equals("overTime")){
					map = IGDRMEmergencyTools.getOverTime(Integer.parseInt(prid));//overTime ֹͣʱ��
				}else if(type.equals("emergencyFlow")){
					map = IGDRMEmergencyTools.getEmergencyFlow(Integer.parseInt(prid));//emergencyFlow ����ͼ
				}
				//ת����Json
				Gson gson = new Gson();
				out.print(gson.toJson(map));
			} catch (NumberFormatException e) {
				log.debug("===============prid�޷�ת��������===============");
				map.put("emsg", "����id����ȷ!");
			} catch (BLException e) {
				log.debug("===============��ȡ��Ϣ�������ִ���===============");
				map.put("emsg", "��ȡ���ݳ���!");
			}finally {
				if (out != null)
					out.close();
			}
			return null;
			
		}else if("DETAIL".equals(mapping.getParameter())){
			req.setAttribute("psdid", req.getParameter("psdid"));
			String flexType =req.getParameter("flexType");
			req.setAttribute("flexType", req.getParameter("flexType"));
			StepUtil stepUtil = new StepUtil();
			
			stepUtil.setPsdname(URLDecoder.decode(req.getParameter("psdname"),"utf-8"));
			if(StringUtils.isNotEmpty(req.getParameter("factUseTime"))){
				stepUtil.setFactUseTime(URLDecoder.decode(req.getParameter("factUseTime"),"UTF-8"));
			}
			if(flexType.equals("se")){
				stepUtil.setPeople(URLDecoder.decode(req.getParameter("people"),"UTF-8"));
				if(URLDecoder.decode(req.getParameter("nodeStep"),"UTF-8").isEmpty()){
					stepUtil.setNodeStep("");
				}else{
					stepUtil.setNodeStep(URLDecoder.decode(req.getParameter("nodeStep"),"UTF-8"));
				}
				stepUtil.setExpectStartTime(URLDecoder.decode(req.getParameter("expectStartTime"),"UTF-8"));
				stepUtil.setExpectUseTime(URLDecoder.decode(req.getParameter("expectUseTime"),"UTF-8"));
				stepUtil.setExpectOverTime(URLDecoder.decode(req.getParameter("expectOverTime"),"UTF-8"));
				stepUtil.setFactStartTime(URLDecoder.decode(req.getParameter("factStartTime"),"UTF-8"));
				stepUtil.setFactOverTime(URLDecoder.decode(req.getParameter("factOverTime"),"UTF-8"));
			}else{
				//��ѯӦ��ָ�ӽڵ����ϸ��Ϣ
				IG224BL ig224BL = (IG224BL) WebApplicationSupport.getBean("ig224BL");
				IG224SearchCondImpl ig224Cond = new IG224SearchCondImpl();
				//Ӧ��ָ��PRID
				String emprid = req.getParameter("emprid");
				String psdid = req.getParameter("psdid");
				ig224Cond.setPrid(Integer.parseInt(emprid));
				ig224Cond.setPsdid(psdid);
				List<IG224Info> ig224InfoList = ig224BL.searchIG224Info(ig224Cond, 0, 0);
				//��ȡ�ڵ���־��ʵ��
				IG224Info ig224Info = ig224InfoList.get(0);
				IG222BL ig222BL = (IG222BL) WebApplicationSupport.getBean("ig222BL");
				UserBL userBL = (UserBL) WebApplicationSupport.getBean("userBL");
				Map<String, UserInfo> userMap = new HashMap<String, UserInfo>();
				IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
				UserInfoSearchCondImpl userCond = new UserInfoSearchCondImpl();
				ig222Cond.setPsdid(psdid);
				List<IG222Info> ig222List = ig222BL.searchIG222Info(ig222Cond);
				if (ig222List != null && ig222List.size() > 0) {
					for (IG222Info ig222Info : ig222List) {
						if (StringUtils.isNotEmpty(ig222Info.getUserid())) {
							userCond.setUserida(ig222Info.getUserid());
							List<UserInfo> userList = userBL.searchUserInfo(userCond);
							if (userList != null && userList.size() > 0) {
								UserInfo user = (UserInfo) userList.get(0);
								userMap.put(user.getUserida(), user);
							}
						} else {
							List<UserInfo> userInfoList = userBL.searchUserByRoleId(ig222Info.getRoleid());
							if (userInfoList != null&& userInfoList.size() > 0) {
								for (int i = 0; i < userInfoList.size(); i++) {
									UserInfoVW user = new UserInfoVW();
									BeanUtils.copyProperties(userInfoList.get(i), user);
									user.setUserida(((UserTB) userInfoList.get(i)).getUserid());
									userMap.put(user.getUserida(), user);
								}
							}
						}
					}
				}
				
				StringBuffer peopleStr = new StringBuffer();
				StringBuffer userids = new StringBuffer();
				for (String peopleKey : userMap.keySet()) {
					peopleStr.append(userMap.get(peopleKey).getUsername()+ "��");
					userids.append(peopleKey + ",");
				}
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				stepUtil.setFactStartTime(format.format(ig224Info.getRslOpenTime()));
				stepUtil.setFactOverTime(format.format(ig224Info.getRslCloseTime()));
				stepUtil.setPeople(peopleStr.toString().substring(0, peopleStr.toString().length()-1));
			}
			IGDRM0710VO vo = new IGDRM0710VO();
			vo.setStep(stepUtil);
			super.<IGDRM0710VO>setVO(req, vo);
		}else if("SAVEDETAIL".equals(mapping.getParameter())){
			String psdid = req.getParameter("psdid");
			String flexType = req.getParameter("flexType");
			String prid = req.getParameter("prid");
			String suggestionValue = req.getParameter("suggestionValue");
			String userid = req.getParameter("userid");
			String index = req.getParameter("index");
			EvaluationContentTB ecTB = new EvaluationContentTB();
			ecTB.setEvpeople(userid);
			ecTB.setPrid(Integer.parseInt(prid));
			ecTB.setSuggestion(suggestionValue);
			ecTB.setPsdid(psdid);
			ecTB.setFlowType(flexType);
			ecTB.setSortId(Integer.parseInt(index));
			EvaluationContentBL ecBL = (EvaluationContentBL) getBean("evaluationContentBL");
			List<EvaluationContentInfo> ecList= ecBL.saveEvaluationContent(ecTB);
			PrintWriter out = null;
			try{
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				Gson gson = new Gson();
				String jsonStr = gson.toJson(ecList);
				out.print(jsonStr);
			} catch (Exception e) {
				log.error("Ajax SEND Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			return null;
		}else if("SAVESUGGESTION".equals(mapping.getParameter())){
			String prid = req.getParameter("prid");
			String suggestionContent = req.getParameter("suggestionContent");
			String flexType = req.getParameter("flowType");
			EvaluationContentTB ecTB = new EvaluationContentTB();
			ecTB.setSortId(0);
			ecTB.setPrid(Integer.parseInt(prid));
			ecTB.setSuggestion(suggestionContent);
			ecTB.setFlowType(flexType);
			EvaluationContentBL ecBL = (EvaluationContentBL) getBean("evaluationContentBL");
			EvaluationContentSearchCondImpl cond = new EvaluationContentSearchCondImpl();
			cond.setPrid(Integer.parseInt(prid));
			cond.setSortId(0);
			List<EvaluationContentInfo> ecList = ecBL.searchEvaluationContent(cond);
			if(ecList!=null && ecList.size()>0){
				ecTB.setEvid(ecList.get(0).getEvid());
				ecBL.updateEvaluationContent(ecTB);
			}else{
				ecBL.registEvaluationContent(ecTB);
			}
			PrintWriter out = null;
			try{
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				Gson gson = new Gson();
				String jsonStr = gson.toJson(ecList);
				out.print(jsonStr);
			} catch (Exception e) {
				log.error("Ajax SEND Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			return null;
		}else if("CHANGE".equals(mapping.getParameter())){
			String prid = req.getParameter("evprid").split("_")[0];
			String flowType = req.getParameter("evprid").split("_")[1];
			//Ӧ��ָ����������
			EvaluationContentBL ecBL = (EvaluationContentBL) getBean("evaluationContentBL");
			EvaluationContentSearchCondImpl ecCond = new EvaluationContentSearchCondImpl();
			ecCond.setPrid(Integer.parseInt(prid));
			ecCond.setFlowType(flowType);
			List<EvaluationContentInfo> evaluationContentList = ecBL.searchEvaluationContent(ecCond, 0, 0);
			PrintWriter out = null;
			try{
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				Gson gson = new Gson();
				String jsonStr = gson.toJson(evaluationContentList);
				out.print(jsonStr);
			} catch (Exception e) {
				log.error("Ajax SEND Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			return null;
		}else if("SAVEALL".equals(mapping.getParameter())){
			String prid = req.getParameter("prid");
			String stepName = req.getParameter("stepName");
			String evpeople = req.getParameter("evpeople");
			String peoples = req.getParameter("peoples");
			String suggestion = req.getParameter("suggestion");
			String fingerprint = req.getParameter("fingerprint");
			String flowType = req.getParameter("flexType");
			EvaluationContentSearchCondImpl ecCond = new EvaluationContentSearchCondImpl();
			EvaluationContentBL ecBL = (EvaluationContentBL) getBean("evaluationContentBL");
			ecCond.setPrid(Integer.parseInt(prid));
			ecCond.setFlowType(flowType);
			List<EvaluationContentInfo> ecList = ecBL.searchEvaluationContent(ecCond);
			EvaluationContentTB evaluationContentTB = new EvaluationContentTB();
			evaluationContentTB.setPrid(Integer.parseInt(prid));
			evaluationContentTB.setStepName(stepName);
			evaluationContentTB.setEvpeople(evpeople);
			evaluationContentTB.setPeoples(peoples);
			evaluationContentTB.setSuggestion(suggestion);
			evaluationContentTB.setFlowType(flowType);
			evaluationContentTB.setFingerPrint(fingerprint);
			if(ecList!=null && ecList.size()>0){
				evaluationContentTB.setEvid(ecList.get(0).getEvid());
				ecBL.updateEvaluationContent(evaluationContentTB);
			}else{
				ecBL.registEvaluationContent(evaluationContentTB);
			}
			PrintWriter out = null;
			try{
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				Gson gson = new Gson();
				String jsonStr = gson.toJson(evaluationContentTB);
				out.print(jsonStr);
			} catch (Exception e) {
				log.error("Ajax SEND Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			return null;
		}else if("EXIST".equals(mapping.getParameter())){
			//����ID
			String prid = req.getParameter("prid");
			//�ڵ�ID
			String psdid = req.getParameter("psdid");
			//��������
			String flexType = req.getParameter("flexType");
			EvaluationContentSearchCondImpl ecCond = new EvaluationContentSearchCondImpl();
			EvaluationContentBL ecBL = (EvaluationContentBL) getBean("evaluationContentBL");
			ecCond.setPrid(Integer.parseInt(prid));
			ecCond.setPsdid(psdid);
			ecCond.setFlowType(flexType);
			List<EvaluationContentInfo> evaluationContentList = ecBL.searchEvaluationContent(ecCond);
			String exist = "false";
			if(evaluationContentList!=null && evaluationContentList.size()>0){
				exist = "false";
			}else{
				exist = "true";
			}
			
			PrintWriter out = null;
			try{
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				Gson gson = new Gson();
				String jsonStr = gson.toJson(exist);
				out.print(jsonStr);
			} catch (Exception e) {
				log.error("Ajax SEND Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			return null;
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
