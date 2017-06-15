/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wkm.action;

import java.util.ArrayList;
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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.bl.IGPRR01BLType;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0102Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01021VO;
import com.deliverik.infogovernor.prr.vo.IGPRR01033VO;

/**
 * @Description: 流程处理Action
 * @Author  
 * @History 2010-9-13     新建 
 * 			2012-3-29	  修改	process00003： 选择执行人先进行更新处理
 * @Version V1.0
 */
public class IGWKM0104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGWKM0104Action.class);

	/**
	 * 流程处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//监管报表用，设置返回用填报实例ID
		req.setAttribute("instanceID", req.getParameter("instanceID"));
		//FORM取得
		IGPRR0102Form form = (IGPRR0102Form)actionForm;
		//BL取得
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		String forward = "DISP";
		IGPRR01021VO vo = new IGPRR01021VO();
		//DTO生成
		IGPRR01DTO dto = new IGPRR01DTO();
		//初始化时清空表单相关数组
		if("DISP".equals(mapping.getParameter())) {
			String ppidstr = req.getParameter("ppidstr");
			form.clear();
			form.setPpidstr(StringUtils.isNotEmpty(ppidstr) ? ppidstr : "");
			String alarmFlag = req.getParameter("alarmFlag");
			req.setAttribute("alarmFlag", alarmFlag);
			//设定当前状态
			if(StringUtils.isNotEmpty(req.getParameter("prstatus"))) {
				form.setPrstatus(req.getParameter("prstatus"));
			}
		}
		//分派参与者按机构过滤设定
		dto.setAssign_orgsyscoding(form.getAssign_orgsyscoding());
		dto.setPsdid(form.getPsdid());
		dto.setRoleid(form.getRoleid());
		dto.setPpidstr(form.getPpidstr());
		dto.setPdid(form.getPdid());
		//判断是否为快捷发起
		if(req.getParameter("isServiceStart")==null){
			req.setAttribute("isServiceStart", "");
		}else{
			req.setAttribute("isServiceStart",req.getParameter("isServiceStart"));
		}

		dto.setPsdcode(form.getPsdcode());
		dto.setIgPRR0102Form(form);
		dto.setWorkFlowParameterInfo(form);
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		dto = ctlBL.getAuthorizeuser(dto);
		User authorizeuser = dto.getAuthorizeuser();
		
		if( "DISP".equals(mapping.getParameter()) || "COPY".equals(mapping.getParameter())){
			log.debug("========流程处理画面初期显示处理开始========");
			dto.setPrid(form.getPrid());
			//流程定义ID，发起页面使用
			dto.setPdid(form.getPdid());
			//流程图查询
			dto = ctlBL.searchFlowChartXmlAction(dto);
			vo.setFlowChartXml(dto.getFlowChartXml());
			vo.setXmlheight(dto.getXmlheight());
			//Session清除
			req.getSession().removeAttribute("IGPRR01021VO");
			dto.setPrid(form.getPrid());
			req.setAttribute("prid", form.getPrid());
			//处理
			dto = ctlBL.initIGPRR0102Action(dto);
			//表单复制功能  // 20130804 wangtingzhi
			if("COPY".equals(mapping.getParameter())){
				dto = ctlBL.copyProcessInfoValueAction(dto);
			}
			req.setAttribute("processOrgSelectedOptions", dto.getProcessOrgSelectedOptions());
			req.getSession().setAttribute("AD_columnInfoMap", dto.getColumnInfoMap());
			req.getSession().setAttribute("AD_tableColumnValueMap", dto.getTableColumnValueMap());
			vo.setTableAttMap(dto.getTableAttMap());
			//====>130225Begin
			form.setPsdassign(dto.getPsdassign());
			form.setPporgid(dto.getPporgid());
			//====>130225End
			
			//发文流程是否公开
			vo.setIsOpen(dto.getIsOpen());
			vo.setTextAreaMap(dto.getTextAreaMap());
			//如果是角色负责人
			if(dto.isRoleManager()){
				vo.setIsRoleManager("true");
			}else{
				vo.setIsRoleManager("false");
			}
			if(dto.getProcessParticipant()!=null){
				//如果是主办部门
				if("1".equals(dto.getProcessParticipant().getPpsuper())){
					vo.setIsHost("true");
				}else{
					vo.setIsHost("false");
				}
			}
			
			//设置流程处理时间
			vo.setDealtime(dto.getDealtime());
			//授权模式下，将代理人信息，添加到画面上
            if(authorizeuser != null){
            	String personinfo = dto.getStatus();
            	personinfo = personinfo.replace(authorizeuser.getUsername(), authorizeuser.getUsername() + " 当前的代理人【" +user.getUsername()+"】" );
            	req.setAttribute("personinfo", personinfo);
            }else{
            	req.setAttribute("personinfo", dto.getStatus());
            }
			vo.setRecordLogMap(dto.getRecordLogMap());
			vo.setHasCLRecord("1".equalsIgnoreCase(dto.getHasCLRecord())?"1":"0");
			//vo.setRecordLog_map(dto.getRecordLog_map());
			//vo.setNameList(dto.getNameList());
			vo.setPrList(dto.getPrList());
			vo.setProcess(dto.getProcess());
			vo.setStatus(dto.getPsdcode());
			vo.setDutyPerson(dto.isDutyPerson());
			vo.setSuperFlag(dto.getSuperFlag());//SUPER分派标识
			vo.setHasDutyPerson(dto.isHasDutyPerson());//是否存在未授权值班人标识
			vo.setIsMoreRelevantProcess(dto.getIsMoreRelevantProcess());//相关发起是否可发起多个流程类型标识
			vo.setRelevantPdid(dto.getRelevantPdid());//相关发起若只有一个流程类型则保存这个流程的pdid
			vo.setOrgid(dto.getOrgid());
			vo.setPieMap(dto.getPieMap());  //表格类表单关联资产信息
			vo.setProcessInfoFormValueMap(dto.getProcessInfoFormValueMap()); //流程类表单值map
			vo.setParticipantFormValueMap(dto.getParticipantFormValueMap()); //人员类表单值map
			//如果角色下拉框只有一个角色则画面不显示下拉框
			if(dto.getLabelList() != null && dto.getLabelList().size() == 1 ) {
				vo.setDisp("1");
				form.setRolename(dto.getLabelList().get(0).getLabel());
				form.setPpidstr(dto.getLabelList().get(0).getValue());
			}else{
				vo.setDisp("0");
			}
			req.getSession().setAttribute("ADroleList", sortLabel(dto.getLabelList(), user.getUserid()));
			if(dto.getLst_status() != null) {
				req.getSession().setAttribute("ADlst_status", dto.getLst_status());//流程当前状态标识集合
			}
			
			//区分流程，返回时调用
			if(req.getParameter("prtype")!=null){
				form.setPts(String.valueOf(req.getParameter("prtype")));
				req.setAttribute("prtype", String.valueOf(req.getParameter("prtype")));
			}else{
				if(StringUtils.isEmpty(form.getPts())){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD);
					req.setAttribute("prtype", IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD);
				}
			}
			if(req.getParameter("ptid")!=null){
				if(String.valueOf(IGPRDCONSTANTS.PROCESS_DEFINITION_ID).equals(String.valueOf(req.getParameter("ptid")))){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_ID);
				}else if(String.valueOf(IGPRDCONSTANTS.PROCESS_DEFINITION_PD).equals(String.valueOf(req.getParameter("ptid")))){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_PD);
				}else if(String.valueOf(IGPRDCONSTANTS.PROCESS_DEFINITION_CD).equals(String.valueOf(req.getParameter("ptid")))){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_CD);
				}else if(String.valueOf(IGPRDCONSTANTS.PROCESS_DEFINITION_DD).equals(String.valueOf(req.getParameter("ptid")))){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_DD);
				}else if(String.valueOf(IGPRDCONSTANTS.PROCESS_DEFINITION_SD).equals(String.valueOf(req.getParameter("ptid")))){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_SD);
				}else if(String.valueOf(IGPRDCONSTANTS.PROCESS_DEFINITION_COMMON_TEMPLATE_ID).equals(String.valueOf(req.getParameter("ptid")))){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD);
				}
			}
			vo.setUserid(dto.getUser().getUserid());
			vo.setRoleid(dto.getRoleid() == null? 0 : dto.getRoleid());
			vo.setProcessInfoDefmap(dto.getVarmap());//页面变量集合
			vo.setProcessTitleDefTB(dto.getPtdTB());
			vo.setLst_ParticipantVisibleButtonVWInfo(dto.getLst_ParticipantVisibleButtonVWInfo());//页面按钮
			vo.setHid(dto.getHid());//扩展信息是否显示
			vo.setProcessStatusDef(dto.getProcessStatusDef());//流程状态信息
			vo.setIg715InfoList(dto.getIg715InfoList());//相关服务工单
			vo.setIG512InfoList(dto.getLst_IG512Info());//相关流程
			if(req.getAttribute("nodetype")!=null){
				vo.setNodetype(String.valueOf(req.getAttribute("nodetype")));
			}
			//如果没有该节点的处理角色,只能查看的标志.
			List<LabelValueBean>  roleList = dto.getLabelList();
			if(roleList != null) {
				if((roleList.size()==1 && "".equals(roleList.get(0).getValue())) || roleList.size()==0){
					if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(dto.getPsdcode())){
						req.setAttribute("disp", "none");
					}
				}
			}
			//流程结束时只能看到基本信息
			if(vo.getActionlist()==null){
				if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(dto.getPsdcode())){
					req.setAttribute("disp", "none");
				}
			}
			
			// process0001_begin
			if(dto.getProcess() != null){
				if(dto.getProcess().getPruserid().equals(user.getUserid())){
					vo.setIsInitiator("1");
				}else{
					vo.setIsInitiator("0");
				}
			}
			
			
			// process0001_end
			/**是否为流程管理员*/
			vo.setIsAdmin(String.valueOf(dto.isAdminRole()));
			vo.setProcessInfolist(dto.getProcessInfo());
			vo.setProcessInfoEntityList(dto.getProcessInfoEntityList());
			super.<IGPRR01021VO>setVO(req.getSession(), vo);
			//获取跳转JSP
			dto.setPjdtype(IGPRDCONSTANTS.DEALJSP);//处理页面
			dto = ctlBL.searchForwardJsp(dto);
			if(StringUtils.isNotEmpty(dto.getForwardJsp())) {
				forward = dto.getForwardJsp();
			}
			
			//获取相关流程的Include页
			dto.setPjdtype(IGPRDCONSTANTS.RELEVANTPROCESSJSP);//相关流程Include页
			dto.setForwardJsp("");
            dto = ctlBL.searchForwardJsp(dto);
            if(StringUtils.isNotEmpty(dto.getForwardJsp())) {
                //设置定制的引入页面
                vo.setRelevantProcessJsp(dto.getForwardJsp());
            } else {
                //设置默认的引入页面
                vo.setRelevantProcessJsp("/prr/IGPRR01021.jsp");
            }
			saveToken(req);
			//与首页面及查看页间的跳转标识,0为首页，1为上一页，空为其它。
//			String jump = (String)req.getAttribute("jump");
			req.setAttribute("jump", form.getJump());
			super.<IGPRR01021VO>setVO(req.getSession(), vo);
			log.debug("========流程处理画面初期显示处理终了========");
		}else if( "DISPE".equals(mapping.getParameter())){
			log.debug("========日志导出========");
			//Session清除
			req.getSession().removeAttribute("IGPRR01021VO");
			dto.setPrid(form.getPrid());

			//处理
			//dto = ctlBL.getRecordLogs(dto);
 			dto = ctlBL.initIGPRR0102Action(dto);
 			//====>130225Begin
			form.setPsdassign(dto.getPsdassign());
			form.setPporgid(dto.getPporgid());
			//====>130225End
			
 			IG500Info pr = dto.getProcess();
			Map<String, List<IG036Info>>  recordLogMap = dto.getRecordLogMap();
			if("docase".equals(req.getParameter("type"))){
				vo.setRecordLogList(recordLogMap.get("系统类日志"));
			}
			if("sys".equals(req.getParameter("type"))){
				vo.setRecordLogList(recordLogMap.get("处理类日志"));
			}
			//设置流程处理时间
			vo.setDealtime(dto.getDealtime());
			vo.setProcessInfoDefmap(dto.getVarmap());//页面变量集合
 			vo.setProcess(pr);
			req.setAttribute("vo", vo);
			//super.<IGPRR01021VO>setVO(req.getSession(), vo);
			log.debug("========日志导出终了========");
			
			return mapping.findForward("DISPE");
		}
		
		else if("INIT".equals(mapping.getParameter())){
			log.debug("========流程处理开始========");
			dto.setRoleid(form.getPrroleid());
			//User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			//授权模式 
			if(authorizeuser != null){
				dto.setAuthorizeuser(authorizeuser);
			}
			dto.setUser(user);
			dto.setPts(form.getPts());
			dto.setIsServiceStart(req.getParameter("isServiceStart"));
			dto.setParprid(req.getParameter("parprid"));
			if(StringUtils.isEmpty(form.getAction())) {
				throw new BLException("IGPRR0102.E003");
			} else {
				dto.setAction(form.getAction());
				dto.setPrid(form.getPrid());
				
				if (isTokenValid(req, true)){
					if(IGPRDCONSTANTS.BUTTON_TERMINATE.equals(form.getAction())){//中止流程
						log.debug("========管理员中止处理开始========");
						dto.setIgPRR0102Form(form);
						//调用BL中止
						dto = ctlBL.terminate(dto);
						req.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// 工单号
						req.setAttribute("prid",dto.getProcess().getPrid());
						log.debug("========管理员中止处理终了========");
					}else{
						dto = ctlBL.flow(dto);//跃迁
						form.setRlcomment(null);//清空处理记录
					}
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//如果是可分派节点转至设定执行人页面
				if("assign".equals(form.getIsInit())) {
					forward = "ASSIGN";
				}
				//点击执行人按钮进入调整执行人页面
				if(IGPRDCONSTANTS.BUTTON_EXECUTOR.equals(form.getAction())) {
				    //取得改派的跳转页面
                    dto = ctlBL.getAssignPageAction(dto);
                    forward = dto.getAssignChangePage();
//					forward = "EXECUTOR";
					if(dto.getLst_participant() != null && !dto.getLst_participant().isEmpty()) {
						form.setParticipants(dto.getLst_participant().toArray(new String[0]));
						form.setParticipants_(dto.getLst_participant().toArray(new String[0]));
					} else {
						form.setParticipants(new String[]{""});
						form.setParticipants_(new String[]{""});
					}
					if(dto.getLst_ppsuper() != null && !dto.getLst_ppsuper().isEmpty()) {
						form.setPpsupers(dto.getLst_ppsuper().toArray(new String[0]));
					} else {
						form.setPpsupers(new String[]{""});
					}
					//构造VO
					IGPRR01033VO voD = new IGPRR01033VO(dto.getMap_AssignParticipant());
					voD.setMap_ParticipantDoneFlag(dto.getMap_ParticipantDoneFlag());
					
					super.<IGPRR01033VO>setVO(req.getSession(), voD);
					saveToken(req);
					return new ActionForward(forward);
				}
				
			}
			// process00003_begin
			//${IGPRR01021VO.processStatusDef.psdmode == '2'}
			if(IGPRR01BLType.PROCESS_PEOPLE.equals(form.getPeople_code())){
				form.setPeople_code(null);
				ActionForward actionForward = new ActionForward();
				if(IGPRDCONSTANTS.MODE_OA.equals(form.getPsdmode_code())){
					actionForward.setPath("/IGPRR0109_Disp.do?prid=" + dto.getProcess().getPrid() +
							"&roleid=" + form.getPrroleid() + "&pdid=" + dto.getProcess().getPrpdid());
				}else{

					actionForward.setPath("/IGPRR0104_Disp.do?prid=" + dto.getProcess().getPrid() +
							"&roleid=" + form.getPrroleid() + "&pdid=" + dto.getProcess().getPrpdid());
				}
				
				return actionForward;
			}
			// process00003_end
			if("DISP".equals(forward)) {
				req.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// 工单号
				req.setAttribute("prid",dto.getProcess().getPrid());
				req.setAttribute("pts",dto.getPts());
				req.setAttribute("pdid", form.getPdid());
				if(form.getPiid() != null) {
					req.setAttribute("piidLen",form.getPiid().length);
				} else {
					req.setAttribute("piidLen",0);
				}
				req.setAttribute("form",form);
			}
			log.debug("========流程处理终了========");
		} else if("ASSIGN".equals(mapping.getParameter())){
			log.debug("========分派参与者处理开始========");
			dto.setRoleid(form.getPrroleid());
			dto.setIgPRR0102Form(form);
			if(StringUtils.isEmpty(form.getAction())) {
				throw new BLException("IGPRR0102.E003");
			} else {
				dto.setAction(form.getAction());
				dto.setPrid(form.getPrid());
				dto.setNodetype(IGPRDCONSTANTS.PROCESS_NODE_TYPE_ASSIGN);
				dto.setAssignParticipant(false);
				if (isTokenValid(req, true)){
					int i = 0;
					int j = 0;
					int k = 0;
					if(form.getParticipants() != null) {
						i = form.getParticipants().length;
						k = i;
					}
					if(form.getParticipants_() != null) {
						j = form.getParticipants_().length;
						k = i+ j;
					}
					if(k > 0) {
						String[] arr = new String[k];
						if(i > 0) {
							System.arraycopy(form.getParticipants(), 0, arr, 0, i);
						}
						if(j > 0) {
							System.arraycopy(form.getParticipants_(), 0, arr, i, j);
						}
						form.setParticipants(arr);
					}
					dto = ctlBL.flow(dto);//跃迁
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}
			//快捷发起后的分派跳转至成功页
			if(StringUtils.isNotEmpty(form.getIsServiceStart())){
				forward = "/prr/IGPRR0117.jsp";
			}
			req.setAttribute("pts",form.getPrtype());
			req.setAttribute("pdid", form.getPdid());
			if("DISP".equals(forward)) {
				req.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// 工单号
				req.setAttribute("prid",dto.getProcess().getPrid());
			}
			log.debug("========分派参与者处理终了========");
		}  else if("ADJUSTEXECUTOR".equals(mapping.getParameter())){
			log.debug("========调整参与者处理开始========");
			dto.setUser(user);
			dto.setRoleid(form.getPrroleid());
			//分派参与人不存在上传附件问题，未避免上一步上传附件重复，将附件清空  wangtingzhi 20130125
			form.setFileMap(null);
			dto.setIgPRR0102Form(form);
			if(StringUtils.isEmpty(form.getAction())) {
				throw new BLException("IGPRR0102.E003");
			} else {
				dto.setAction(form.getAction());
				dto.setPrid(form.getPrid());
				if (isTokenValid(req, true)){
					int i = 0;
					int j = 0;
					int k = 0;
					if(form.getParticipants() != null) {
						i = form.getParticipants().length;
						k = i;
					}
					if(form.getParticipants_() != null) {
						j = form.getParticipants_().length;
						k = i+ j;
					}
					if(k > 0) {
						String[] arr = new String[k];
						if(i > 0) {
							System.arraycopy(form.getParticipants(), 0, arr, 0, i);
						}
						if(j > 0) {
							System.arraycopy(form.getParticipants_(), 0, arr, i, j);
						}
						form.setParticipants(arr);
					}
					dto = ctlBL.adjustExecutorsForNormalUserAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}
			req.setAttribute("pts",form.getPrtype());
			req.setAttribute("pdid", form.getPdid());
			if("DISP".equals(forward)) {
				req.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// 工单号
				req.setAttribute("prid",dto.getProcess().getPrid());
			}
			log.debug("========调整参与者处理终了========");
		} else if("SAVEEXECUTOR".equals(mapping.getParameter())){
			log.debug("========保存参与者处理开始========");
			dto.setUser(user);
			dto.setRoleid(form.getPrroleid());
			dto.setIgPRR0102Form(form);
			dto.setPrid(form.getPrid());
			if (isTokenValid(req, true)){
				int i = 0;
				int j = 0;
				int k = 0;
				if(form.getParticipants() != null) {
					i = form.getParticipants().length;
					k = i;
				}
				if(form.getParticipants_() != null) {
					j = form.getParticipants_().length;
					k = i+ j;
				}
				if(k > 0) {
					String[] arr = new String[k];
					if(i > 0) {
						System.arraycopy(form.getParticipants(), 0, arr, 0, i);
					}
					if(j > 0) {
						System.arraycopy(form.getParticipants_(), 0, arr, i, j);
					}
					form.setParticipants(arr);
				}
				dto = ctlBL.saveExecutorsAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			req.setAttribute("pts",form.getPrtype());
			req.setAttribute("pdid", form.getPdid());
			if("DISP".equals(forward)) {
				req.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// 工单号
				req.setAttribute("prid",dto.getProcess().getPrid());
			}
			log.debug("========保存参与者处理终了========");
			
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		} 
		//跳转到定制JSP
		if(!"DISP".equals(forward) && !"ASSIGN".equals(forward) && !"EXECUTOR".equals(forward)){ 
			return new ActionForward(forward);
		} else {
			if(!"DISP".equals(mapping.getParameter()) && "DISP".equals(forward)){
				//act表示保持高亮菜单不变,prstatus=空为的是清除上一次提交时的值
				String url = "/IGPRR0102_Disp.do?act=0&prstatus=&prid=" + form.getPrid() + "&jump=" + form.getJump();
				req.getSession().removeAttribute("AD_columnInfoMap");
				req.getSession().removeAttribute("ADroleList");
				req.getSession().removeAttribute("ADlst_status");
				req.getSession().removeAttribute("AD_tableColumnValueMap");
				req.getSession().removeAttribute("IGPRR01021VO");
				return new ActionForward(url);
			}
			return mapping.findForward(forward);
		}
	}
	
	/**
	 * 按登录用户ID排序
	 */
	private List<LabelValueBean> sortLabel(List<LabelValueBean> lst_Label, String userid) {
		if(lst_Label == null) return null;
		List<LabelValueBean> lst_ValueBeans1 = new ArrayList<LabelValueBean>();
		List<LabelValueBean> lst_ValueBeans2 = new ArrayList<LabelValueBean>();
		for(LabelValueBean label : lst_Label) {
			//匹配userid,并且不是管理员
			if(userid.equals(label.getValue().split("_")[2]) && !"0".equals(label.getValue().split("_")[0])) {
				lst_ValueBeans1.add(label);
			} else {
				lst_ValueBeans2.add(label);
			}
		}
		lst_ValueBeans1.addAll(lst_ValueBeans2);
		return lst_ValueBeans1;
	}
}