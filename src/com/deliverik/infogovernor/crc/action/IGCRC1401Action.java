/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.crc.bl.IGCRC04ExcelBL;
import com.deliverik.infogovernor.crc.bl.IGCRC14BL;
import com.deliverik.infogovernor.crc.dto.IGCRC04ExcelDTO;
import com.deliverik.infogovernor.crc.dto.IGCRC14DTO;
import com.deliverik.infogovernor.crc.form.IGCRC1401Form;
import com.deliverik.infogovernor.crc.model.vo.IGCRC14011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������������ѯAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC1401Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse response) throws Exception {
		
		IGCRC1401Form form = (IGCRC1401Form)actionForm;
		//��־����ȡ��
		Log log = LogFactory.getLog(IGCRC1401Action.class);
		//BLȡ��
		IGCRC14BL ctlBL = (IGCRC14BL) getBean("igCRC14BL");
		//ʵ����dto
		IGCRC14DTO dto = new IGCRC14DTO();
		//������ת�趨
		String forward = "";
		//��¼�û�ȡ��
		User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto�����趨
		dto.setUser(user);
		//����form
		dto.setForm(actionForm);
		/*//�жϱ���ѯ�����Ƿ��Ѿ�����
		if(request.getSession().getAttribute("AD_ProcessInfoQueryMap")==null){
			ctlBL.getPivarQueryInfoAction(dto);
			request.getSession().setAttribute("AD_ProcessInfoQueryMap", dto.getProcessInfoQueryMap());
		}*/
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��ѯ������̴���ʼ========");
			forward = "DISP";
			log.debug("========��ѯ������̴�������========");
		}else if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			getPaginDTO(req,"IGCRC1401");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//�ĵ���ѯ����
			log.debug("========��ѯ������̴���ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCRC1401Form) req.getSession().getAttribute("IGCRC1401Form");
				if ( form== null){
					form = new IGCRC1401Form();
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
					form = (IGCRC1401Form) req.getSession().getAttribute("IGCRC1401Form");
					if (form !=null) {
						form.setFromCount(0);
					}else{
						form = new IGCRC1401Form();
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCRC1401");
			dto.setForm(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//�������״̬�����б�
			dto = ctlBL.searchPdid7BitAction(dto);
			List<LabelValueBean> statusBeanList = new ArrayList<LabelValueBean>();
			if (dto.getIg333InfoList() != null && dto.getIg333InfoList().size() > 0) {
				List<IG333Info> statusList = dto.getIg333InfoList();
				statusBeanList.add(new LabelValueBean());
				for (int i = 0; i < statusList.size(); i++) {
					statusBeanList.add(new LabelValueBean(statusList.get(i).getPsdname(), statusList.get(i).getPsdcode()));
				}
			}
			req.setAttribute("statusBeanList", statusBeanList);
			//�ĵ������߼�����
			dto = ctlBL.searchEntityItemAction(dto);
			
			//���ĵ���Ϣ��������趨��VO��
			IGCRC14011VO vo = dto.getIgcrc14011VO();
			if(vo == null){
				vo = new IGCRC14011VO();
			}
			vo.setChangeProcessVWInfos(dto.getChangeProcessVWInfos());
			super.<IGCRC14011VO>setVO(req, vo);
			req.setAttribute("showFlag", form.getShowFlag());
			forward = "SUCCESS";	
			log.debug("========��ѯ������̴�������========");
		}else if("EXCEL".equals(mapping.getParameter())){
			int maxCnt = getMaxDataCount("IGCRC1401");
			//��ȡ��ҳDTO
			PagingDTO pDto = getPaginDTO(req, "IGCRC1401");
			//�޸ķ�ҳDTO,��ѯȫ����������
			pDto.setFromCount(0);
			pDto.setPageDispCount(maxCnt);
			
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto = ctlBL.searchEntityItemAction(dto);
			dto = ctlBL.getExcelDataList(dto);
			//����excel DTO
			IGCRC04ExcelDTO excelDTO = new IGCRC04ExcelDTO();
			if(dto.getIgcrc14011VO() == null){
				dto.setIgcrc14011VO(new IGCRC14011VO());
			}
			excelDTO.setVoLists(dto.getIgcrc14011VO().getIgcrc14012vos());
			// ȡ��Excel����BL
			IGCRC04ExcelBL excelBL = (IGCRC04ExcelBL) getBean("igcrc04ExcelBL");
			// �������˼���
			excelDTO.setProcessParticipantList(dto.getProcessParticipantList());
			
			excelDTO.setProcessStatusDefList(dto.getProcessStatusDefList());
			// ���ģ����
			excelDTO.setFileid("CRC0404");
			excelDTO.setResponse(response);
			//excelBL.initExcel(excelDTO);
			excelBL.initExcel(excelDTO);
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward(forward);
	}

}
