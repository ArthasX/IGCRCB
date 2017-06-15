/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * @Description: ���̴���Action
 * @Author  
 * @History 2010-9-13     �½� 
 * 			2012-3-29	  �޸�	process00003�� ѡ��ִ�����Ƚ��и��´���
 * @Version V1.0
 */
public class IGWKM0104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGWKM0104Action.class);

	/**
	 * ���̴���
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
		//��ܱ����ã����÷������ʵ��ID
		req.setAttribute("instanceID", req.getParameter("instanceID"));
		//FORMȡ��
		IGPRR0102Form form = (IGPRR0102Form)actionForm;
		//BLȡ��
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		String forward = "DISP";
		IGPRR01021VO vo = new IGPRR01021VO();
		//DTO����
		IGPRR01DTO dto = new IGPRR01DTO();
		//��ʼ��ʱ��ձ��������
		if("DISP".equals(mapping.getParameter())) {
			String ppidstr = req.getParameter("ppidstr");
			form.clear();
			form.setPpidstr(StringUtils.isNotEmpty(ppidstr) ? ppidstr : "");
			String alarmFlag = req.getParameter("alarmFlag");
			req.setAttribute("alarmFlag", alarmFlag);
			//�趨��ǰ״̬
			if(StringUtils.isNotEmpty(req.getParameter("prstatus"))) {
				form.setPrstatus(req.getParameter("prstatus"));
			}
		}
		//���ɲ����߰����������趨
		dto.setAssign_orgsyscoding(form.getAssign_orgsyscoding());
		dto.setPsdid(form.getPsdid());
		dto.setRoleid(form.getRoleid());
		dto.setPpidstr(form.getPpidstr());
		dto.setPdid(form.getPdid());
		//�ж��Ƿ�Ϊ��ݷ���
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
			log.debug("========���̴����������ʾ����ʼ========");
			dto.setPrid(form.getPrid());
			//���̶���ID������ҳ��ʹ��
			dto.setPdid(form.getPdid());
			//����ͼ��ѯ
			dto = ctlBL.searchFlowChartXmlAction(dto);
			vo.setFlowChartXml(dto.getFlowChartXml());
			vo.setXmlheight(dto.getXmlheight());
			//Session���
			req.getSession().removeAttribute("IGPRR01021VO");
			dto.setPrid(form.getPrid());
			req.setAttribute("prid", form.getPrid());
			//����
			dto = ctlBL.initIGPRR0102Action(dto);
			//�����ƹ���  // 20130804 wangtingzhi
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
			
			//���������Ƿ񹫿�
			vo.setIsOpen(dto.getIsOpen());
			vo.setTextAreaMap(dto.getTextAreaMap());
			//����ǽ�ɫ������
			if(dto.isRoleManager()){
				vo.setIsRoleManager("true");
			}else{
				vo.setIsRoleManager("false");
			}
			if(dto.getProcessParticipant()!=null){
				//��������첿��
				if("1".equals(dto.getProcessParticipant().getPpsuper())){
					vo.setIsHost("true");
				}else{
					vo.setIsHost("false");
				}
			}
			
			//�������̴���ʱ��
			vo.setDealtime(dto.getDealtime());
			//��Ȩģʽ�£�����������Ϣ����ӵ�������
            if(authorizeuser != null){
            	String personinfo = dto.getStatus();
            	personinfo = personinfo.replace(authorizeuser.getUsername(), authorizeuser.getUsername() + " ��ǰ�Ĵ����ˡ�" +user.getUsername()+"��" );
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
			vo.setSuperFlag(dto.getSuperFlag());//SUPER���ɱ�ʶ
			vo.setHasDutyPerson(dto.isHasDutyPerson());//�Ƿ����δ��Ȩֵ���˱�ʶ
			vo.setIsMoreRelevantProcess(dto.getIsMoreRelevantProcess());//��ط����Ƿ�ɷ������������ͱ�ʶ
			vo.setRelevantPdid(dto.getRelevantPdid());//��ط�����ֻ��һ�����������򱣴�������̵�pdid
			vo.setOrgid(dto.getOrgid());
			vo.setPieMap(dto.getPieMap());  //�����������ʲ���Ϣ
			vo.setProcessInfoFormValueMap(dto.getProcessInfoFormValueMap()); //�������ֵmap
			vo.setParticipantFormValueMap(dto.getParticipantFormValueMap()); //��Ա���ֵmap
			//�����ɫ������ֻ��һ����ɫ���治��ʾ������
			if(dto.getLabelList() != null && dto.getLabelList().size() == 1 ) {
				vo.setDisp("1");
				form.setRolename(dto.getLabelList().get(0).getLabel());
				form.setPpidstr(dto.getLabelList().get(0).getValue());
			}else{
				vo.setDisp("0");
			}
			req.getSession().setAttribute("ADroleList", sortLabel(dto.getLabelList(), user.getUserid()));
			if(dto.getLst_status() != null) {
				req.getSession().setAttribute("ADlst_status", dto.getLst_status());//���̵�ǰ״̬��ʶ����
			}
			
			//�������̣�����ʱ����
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
			vo.setProcessInfoDefmap(dto.getVarmap());//ҳ���������
			vo.setProcessTitleDefTB(dto.getPtdTB());
			vo.setLst_ParticipantVisibleButtonVWInfo(dto.getLst_ParticipantVisibleButtonVWInfo());//ҳ�水ť
			vo.setHid(dto.getHid());//��չ��Ϣ�Ƿ���ʾ
			vo.setProcessStatusDef(dto.getProcessStatusDef());//����״̬��Ϣ
			vo.setIg715InfoList(dto.getIg715InfoList());//��ط��񹤵�
			vo.setIG512InfoList(dto.getLst_IG512Info());//�������
			if(req.getAttribute("nodetype")!=null){
				vo.setNodetype(String.valueOf(req.getAttribute("nodetype")));
			}
			//���û�иýڵ�Ĵ����ɫ,ֻ�ܲ鿴�ı�־.
			List<LabelValueBean>  roleList = dto.getLabelList();
			if(roleList != null) {
				if((roleList.size()==1 && "".equals(roleList.get(0).getValue())) || roleList.size()==0){
					if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(dto.getPsdcode())){
						req.setAttribute("disp", "none");
					}
				}
			}
			//���̽���ʱֻ�ܿ���������Ϣ
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
			/**�Ƿ�Ϊ���̹���Ա*/
			vo.setIsAdmin(String.valueOf(dto.isAdminRole()));
			vo.setProcessInfolist(dto.getProcessInfo());
			vo.setProcessInfoEntityList(dto.getProcessInfoEntityList());
			super.<IGPRR01021VO>setVO(req.getSession(), vo);
			//��ȡ��תJSP
			dto.setPjdtype(IGPRDCONSTANTS.DEALJSP);//����ҳ��
			dto = ctlBL.searchForwardJsp(dto);
			if(StringUtils.isNotEmpty(dto.getForwardJsp())) {
				forward = dto.getForwardJsp();
			}
			
			//��ȡ������̵�Includeҳ
			dto.setPjdtype(IGPRDCONSTANTS.RELEVANTPROCESSJSP);//�������Includeҳ
			dto.setForwardJsp("");
            dto = ctlBL.searchForwardJsp(dto);
            if(StringUtils.isNotEmpty(dto.getForwardJsp())) {
                //���ö��Ƶ�����ҳ��
                vo.setRelevantProcessJsp(dto.getForwardJsp());
            } else {
                //����Ĭ�ϵ�����ҳ��
                vo.setRelevantProcessJsp("/prr/IGPRR01021.jsp");
            }
			saveToken(req);
			//����ҳ�漰�鿴ҳ�����ת��ʶ,0Ϊ��ҳ��1Ϊ��һҳ����Ϊ������
//			String jump = (String)req.getAttribute("jump");
			req.setAttribute("jump", form.getJump());
			super.<IGPRR01021VO>setVO(req.getSession(), vo);
			log.debug("========���̴����������ʾ��������========");
		}else if( "DISPE".equals(mapping.getParameter())){
			log.debug("========��־����========");
			//Session���
			req.getSession().removeAttribute("IGPRR01021VO");
			dto.setPrid(form.getPrid());

			//����
			//dto = ctlBL.getRecordLogs(dto);
 			dto = ctlBL.initIGPRR0102Action(dto);
 			//====>130225Begin
			form.setPsdassign(dto.getPsdassign());
			form.setPporgid(dto.getPporgid());
			//====>130225End
			
 			IG500Info pr = dto.getProcess();
			Map<String, List<IG036Info>>  recordLogMap = dto.getRecordLogMap();
			if("docase".equals(req.getParameter("type"))){
				vo.setRecordLogList(recordLogMap.get("ϵͳ����־"));
			}
			if("sys".equals(req.getParameter("type"))){
				vo.setRecordLogList(recordLogMap.get("��������־"));
			}
			//�������̴���ʱ��
			vo.setDealtime(dto.getDealtime());
			vo.setProcessInfoDefmap(dto.getVarmap());//ҳ���������
 			vo.setProcess(pr);
			req.setAttribute("vo", vo);
			//super.<IGPRR01021VO>setVO(req.getSession(), vo);
			log.debug("========��־��������========");
			
			return mapping.findForward("DISPE");
		}
		
		else if("INIT".equals(mapping.getParameter())){
			log.debug("========���̴���ʼ========");
			dto.setRoleid(form.getPrroleid());
			//User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			//��Ȩģʽ 
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
					if(IGPRDCONSTANTS.BUTTON_TERMINATE.equals(form.getAction())){//��ֹ����
						log.debug("========����Ա��ֹ����ʼ========");
						dto.setIgPRR0102Form(form);
						//����BL��ֹ
						dto = ctlBL.terminate(dto);
						req.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// ������
						req.setAttribute("prid",dto.getProcess().getPrid());
						log.debug("========����Ա��ֹ��������========");
					}else{
						dto = ctlBL.flow(dto);//ԾǨ
						form.setRlcomment(null);//��մ����¼
					}
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//����ǿɷ��ɽڵ�ת���趨ִ����ҳ��
				if("assign".equals(form.getIsInit())) {
					forward = "ASSIGN";
				}
				//���ִ���˰�ť�������ִ����ҳ��
				if(IGPRDCONSTANTS.BUTTON_EXECUTOR.equals(form.getAction())) {
				    //ȡ�ø��ɵ���תҳ��
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
					//����VO
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
				req.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// ������
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
			log.debug("========���̴�������========");
		} else if("ASSIGN".equals(mapping.getParameter())){
			log.debug("========���ɲ����ߴ���ʼ========");
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
					dto = ctlBL.flow(dto);//ԾǨ
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}
			//��ݷ����ķ�����ת���ɹ�ҳ
			if(StringUtils.isNotEmpty(form.getIsServiceStart())){
				forward = "/prr/IGPRR0117.jsp";
			}
			req.setAttribute("pts",form.getPrtype());
			req.setAttribute("pdid", form.getPdid());
			if("DISP".equals(forward)) {
				req.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// ������
				req.setAttribute("prid",dto.getProcess().getPrid());
			}
			log.debug("========���ɲ����ߴ�������========");
		}  else if("ADJUSTEXECUTOR".equals(mapping.getParameter())){
			log.debug("========���������ߴ���ʼ========");
			dto.setUser(user);
			dto.setRoleid(form.getPrroleid());
			//���ɲ����˲������ϴ��������⣬δ������һ���ϴ������ظ������������  wangtingzhi 20130125
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
				req.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// ������
				req.setAttribute("prid",dto.getProcess().getPrid());
			}
			log.debug("========���������ߴ�������========");
		} else if("SAVEEXECUTOR".equals(mapping.getParameter())){
			log.debug("========��������ߴ���ʼ========");
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
				req.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// ������
				req.setAttribute("prid",dto.getProcess().getPrid());
			}
			log.debug("========��������ߴ�������========");
			
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		} 
		//��ת������JSP
		if(!"DISP".equals(forward) && !"ASSIGN".equals(forward) && !"EXECUTOR".equals(forward)){ 
			return new ActionForward(forward);
		} else {
			if(!"DISP".equals(mapping.getParameter()) && "DISP".equals(forward)){
				//act��ʾ���ָ����˵�����,prstatus=��Ϊ���������һ���ύʱ��ֵ
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
	 * ����¼�û�ID����
	 */
	private List<LabelValueBean> sortLabel(List<LabelValueBean> lst_Label, String userid) {
		if(lst_Label == null) return null;
		List<LabelValueBean> lst_ValueBeans1 = new ArrayList<LabelValueBean>();
		List<LabelValueBean> lst_ValueBeans2 = new ArrayList<LabelValueBean>();
		for(LabelValueBean label : lst_Label) {
			//ƥ��userid,���Ҳ��ǹ���Ա
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