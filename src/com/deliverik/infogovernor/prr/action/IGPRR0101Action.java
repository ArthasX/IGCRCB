/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.action;

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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0101Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01011VO;

/**
 * @Description: ���̷���Action
 * @Author  
 * @History 2010-9-13     �½� 
 * @Version V1.0
 */
public class IGPRR0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRR0101Action.class);

	/**
	 * ���̷���
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGPRR0101Form form = (IGPRR0101Form)actionForm;
		
		//BLȡ��
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		
		String forward = "DISP";
		
		//DTO����
		IGPRR01DTO dto = new IGPRR01DTO();
		
		//���ɲ����߰����������趨
		dto.setAssign_orgsyscoding(form.getAssign_orgsyscoding());
		
		dto.setIgPRR0101Form(form);
		
		dto.setWorkFlowParameterInfo(form);
		
		dto.setPdid(form.getPdid());//5λ��PDID
		
		//��ȡ�����ɫ�б�
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		if(form.getRoleid()!=null && !"".equals(form.getRoleid())){
			dto.setRoleid(form.getRoleid());
			form.setPrroleid(form.getRoleid());
		}else{
			dto.setRoleid(form.getPrroleid());
		}
		if( "DISP".equals(mapping.getParameter()) || "BACK".equals(mapping.getParameter())){
			Integer ptid = form.getPtid();
			if(IGPRDCONSTANTS.PROCESS_DEFINITION_ID.equals(ptid)){
				form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_ID);
			}else if(IGPRDCONSTANTS.PROCESS_DEFINITION_PD.equals(ptid)){
				form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_PD);
			}else if(IGPRDCONSTANTS.PROCESS_DEFINITION_CD.equals(ptid)){
				form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_CD);
			}else if(IGPRDCONSTANTS.PROCESS_DEFINITION_DD.equals(ptid)){
				form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_DD);
			}else if(IGPRDCONSTANTS.PROCESS_DEFINITION_SD.equals(ptid)){
				form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_SD);
			}else if(IGPRDCONSTANTS.PROCESS_DEFINITION_DRM.equals(ptid)){
				form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_DRM);
			}else if(IGPRDCONSTANTS.PROCESS_DEFINITION_WDP.equals(ptid)){
				form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WDP);
			}else if(IGPRDCONSTANTS.PROCESS_DEFINITION_WDC.equals(ptid)){
				form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WDC);
			}else if(IGPRDCONSTANTS.PROCESS_DEFINITION_COMMON_TEMPLATE_ID.equals(ptid)){
				form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD);
			}
			
			log.debug("========�����������ʾ����ʼ========");
			form.setColumn_pidid(null);
			form.setColumn_rownumber(null);
			form.setColumn_value(null);
			String iWantToTest = req.getParameter("iWantToTest");
			if (StringUtils.isEmpty(iWantToTest) || dto.getPdid().length() < 7) {
			    //��ȡ����״̬������PDID(7λ)
			    dto = ctlBL.searchPdid7BitAction(dto);
			    form.setPdid(dto.getPdid());
			} else {
			    //�������״̬������ʱ��form�е�pdid�Ѿ���7λ�ģ����Բ������»�ȡ��
			}
			req.setAttribute("iWantToTest", iWantToTest);
	        //���̷���ҳ���ʼ��
			dto = ctlBL.initIGPRR0101Action(dto);
			if("DISP".equals(mapping.getParameter())){
				//��ʼ��ҳ���
				int length = dto.getProcessInfoDefmap().size();
				form.setPivarvalue(new String[length]);
				form.setPivarassetname(new String[length]);
				form.setPivarprname(new String[length]);
				form.setPivarprjname(new String[length]);
				form.setPrpdid(form.getPdid());
				form.setPivarrolename(new String[length]);
				form.setPidmode(new String[length]);
				form.setPivartreename(new String[length]);
				form.setPivarradio(new String[length]);
				form.setPivarcheckbox(new String[length]);
				form.setPidcomment(new String[length]);
				form.setPiddesc(new String[length]);
				form.setPivarlabel(new String[length]);
				form.setPivarname(new String[length]);
				form.setPivartype(new String[length]);
				form.setPrivatescope(new String[length]);
			}
			req.setAttribute("processOrgSelectedOptions", dto.getProcessOrgSelectedOptions());
			req.getSession().setAttribute("AD_columnInfoMap", dto.getColumnInfoMap());
			req.getSession().setAttribute("ADroleList", dto.getLabelList());
			req.getSession().setAttribute("AD_tableColumnValueMap", dto.getTableColumnValueMap());
			IGPRR01011VO vo = new IGPRR01011VO();
			vo.setProcessTitleDefTB(dto.getPtdTB());
			vo.setProcessInfoDefmap(dto.getProcessInfoDefmap());//ҳ���������
			vo.setLst_ParticipantVisibleButtonVWInfo(dto.getLst_ParticipantVisibleButtonVWInfo());//ҳ�水ť
			vo.setProcessStatusDef(dto.getProcessStatusDef()); //״̬������Ϣ
			//ҳ�洫�ݹ̶�����ֵ
			vo.setPdidOrgid(dto.getPdidOrgid());
			//�����ɫ������ֻ��һ����ɫ���治��ʾ������
			if(dto.getLabelList() != null && dto.getLabelList().size() == 1 ) {
				vo.setDisp("1");
				form.setPrrolename(dto.getLabelList().get(0).getLabel());
				form.setPrroleid(Integer.parseInt(dto.getLabelList().get(0).getValue()));
			}else if(dto.getLabelList() != null && dto.getLabelList().size() > 1){
				if(form.getRoleid() == null || form.getRoleid() == 0){
					form.setPrrolename(dto.getLabelList().get(0).getLabel());
					form.setPrroleid(Integer.parseInt(dto.getLabelList().get(0).getValue()));
				}else{
					for(LabelValueBean bean : dto.getLabelList()){
						if(bean.getValue().equals(form.getRoleid() + "")){
							form.setPrroleid(Integer.valueOf(bean.getValue()));
							form.setPrrolename(bean.getLabel());
						}
					}
				}
				vo.setDisp("0");
			}else{
				vo.setDisp("0");
			}
			if(dto.getTextAreaMap()!=null){
				vo.setTextAreaMap(dto.getTextAreaMap());
			}
			vo.setProcess(form);
			super.<IGPRR01011VO>setVO(req.getSession(), vo);
			//��ȡ��תJSP
			if(form!=null && form.getPjdtype()!=null && !(form.getPjdtype().equals(""))){
				dto.setPjdtype(IGPRDCONSTANTS.RELEVANTPROCESSJSP);//����ҳ��
			}else{
				dto.setPjdtype(IGPRDCONSTANTS.CREATEJSP);//����ҳ��				
			}
			dto = ctlBL.searchForwardJsp(dto);
			if(StringUtils.isNotEmpty(dto.getForwardJsp())) {
				forward = dto.getForwardJsp();
			}
			saveToken(req);
			super.<IGPRR01011VO>setVO(req.getSession(), vo);
			log.debug("========�����������ʾ��������========");
		}else if("INIT".equals(mapping.getParameter())){
			log.debug("========���̷�����ʼ========");
			if (isTokenValid(req, true)){
				dto = ctlBL.createProcessAction(dto);//����
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			if(!dto.isAssignParticipant()) {
				forward = "ASSIGN";
				req.setAttribute("prid", dto.getProcess().getPrid());
			}
			if("DISP".equals(forward)) {
				req.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// ������
				req.setAttribute("prid",dto.getProcess().getPrid());
				req.setAttribute("pdid",dto.getProcess().getPrpdid());
				req.setAttribute("pts",form.getPts());
			}

			log.debug("========���̷���������========");
			//����������޶����� Խ��������ҳ��
			if(dto.getProcess().getPrpdid().startsWith("01305")||dto.getProcess().getPrpdid().startsWith("01441")){
				
				 return new ActionForward("/IGPRR0102_Disp.do?prid=" +
				 dto.getProcess().getPrid(), true);
			}
		} 
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		//��ת������JSP
		if(!"DISP".equals(forward) && !"ASSIGN".equals(forward)){
			return new ActionForward(forward);
		} else {
			return mapping.findForward(forward);
		}
		
	}
	

}
