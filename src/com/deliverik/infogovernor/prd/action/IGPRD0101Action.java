/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0101Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01011VO;
import com.deliverik.infogovernor.prd.vo.IGPRD01012VO;

/**
 * ���̶����ѯAction����
 *
 */
public class IGPRD0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0101Action.class);

	/**
	 * ���̶����ѯ����
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
		IGPRD0101Form form = (IGPRD0101Form)actionForm;
		
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//���̶����ѯ���������ʾ����
			log.debug("========���̶����ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========���̶����ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if ( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//���̶����ѯ����
			log.debug("========���̶����ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGPRD0101");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGPRD0101Form) req.getSession().getAttribute("IGPRD0101Form");
				if ( form == null ) {
					form = new IGPRD0101Form();
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
					form = (IGPRD0101Form) req.getSession().getAttribute("IGPRD0101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGPRD0101");
			
			dto.setProcessDefinitionSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//ͨ��ģ��ID
			
			if(StringUtils.isEmpty(form.getPttype())){
				form.setPttype(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD);
			}
			dto.setPttype(form.getPttype());
			dto = ctlBL.searchProcessTemplateAction(dto);

			Integer[] ptidForType = new Integer[1];
			if(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD.equals(form.getPttype())){
				ptidForType = new Integer[6];
				ptidForType[0] = IGPRDCONSTANTS.PROCESS_DEFINITION_COMMON_TEMPLATE_ID;
				ptidForType[1] = IGPRDCONSTANTS.PROCESS_DEFINITION_ID;
				ptidForType[2] = IGPRDCONSTANTS.PROCESS_DEFINITION_PD;
				ptidForType[3] = IGPRDCONSTANTS.PROCESS_DEFINITION_CD;
				ptidForType[4] = IGPRDCONSTANTS.PROCESS_DEFINITION_DD;
				ptidForType[5] = IGPRDCONSTANTS.PROCESS_DEFINITION_SD;
			}else{
				ptidForType[0] = dto.getProcessTemplate().getPtid();
			}
			
			form.setPrTypeArray(ptidForType);

			//���̶�����Ϣ�����߼�����
			dto = ctlBL.searchLastProcessDefinitionAction(dto);
			
			//�����̶�����Ϣ��������趨��VO��
			IGPRD01011VO vo = new IGPRD01011VO(dto.getProcessDefinitionList());
			
			super.<IGPRD01011VO>setVO(req.getSession(), vo);
			
			req.setAttribute("tmpmap", dto.getMap());
			
			saveToken(req);
			
			log.debug("========���̶����ѯ��������========");
		} else if("UPGRADE".equals(mapping.getParameter())){
			log.debug("========���̶������洦��ʼ========");
			if (isTokenValid(req, true)){
				dto.setPdid(form.getPdid());
				//����BL����
				dto = ctlBL.upgradeProcessDefAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			form.setPdid(null);//����ղ�ѯ����ʹ
			log.debug("========���̶������洦������========");
		} else if("COPY".equals(mapping.getParameter())){
			log.debug("========���̶��帴�ƴ���ʼ========");
			if (isTokenValid(req, true)){
				dto.setPdid(form.getPdid());
				//����BL����
				dto = ctlBL.copyProcessDefAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			form.setPdid(null);//����ղ�ѯ����ʹ
			log.debug("========���̶��帴�ƴ�������========");
		} else if("IMPORT".equals(mapping.getParameter())){
			log.debug("========���̶��嵼�봦��ʼ========");
			if (isTokenValid(req, true)){
				dto.setIgPRD0101Form(form);
				//����BL
				dto = ctlBL.importProcessDefAction(dto);
				if(dto.getErrorMessages() != null && dto.getErrorMessages().size() > 0){
					IGPRD01012VO vo = new IGPRD01012VO();
					vo.setErrorMessages(dto.getErrorMessages());
					super.<IGPRD01012VO>setVO(req, vo);
					return mapping.findForward("ERROR");
				}
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========���̶��嵼�봦������========");
		} else if("EXPORT".equals(mapping.getParameter())){
			log.debug("========���̶��嵼������ʼ========");
			dto.setIgPRD0101Form(form);
			//����BL
			ctlBL.exportProcessDefAction(dto);
			form.setPdid(null);//����ղ�ѯ����ʹ
			log.debug("========���̶��嵼����������========");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		if("EXPORT".equals(mapping.getParameter())) {
			return new ActionForward("/download.do?type=pd_export&filepath=" + dto.getFilepath_export());
		} else {
			return mapping.findForward("DISP");
		}
	}
}
