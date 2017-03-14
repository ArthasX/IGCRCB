package com.deliverik.infogovernor.asset.action;

import java.util.List;

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
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM2714ExcelBL;
import com.deliverik.infogovernor.asset.bl.IGASM27BL;
import com.deliverik.infogovernor.asset.dto.IGASM2714ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;
import com.deliverik.infogovernor.asset.form.IGASM2713Form;
import com.deliverik.infogovernor.asset.vo.IGASM27071VO;

/**
 * ���յ��ѯ����Action����
 *
 */
public class IGASM2714Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2714Action.class);

	/**
	 * ���յ��ʲ���ѯ
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
		IGASM2713Form igasm2713form = (IGASM2713Form)actionForm;
		
		//BLȡ��
		IGASM27BL ctlBL = (IGASM27BL) getBean("igasm27BL");
		
		UserBL userbl = (UserBL)getBean("userBL");
		//DTO����
		IGASM27DTO dto = new IGASM27DTO();
		dto.setIgasm2713Form(igasm2713form);
		
		if ("DISP".equals(mapping.getParameter())){
			//���յ��޸Ĵ�����ʾ
			log.debug("========���յ��ѯ��ʼ����ʾ��ʼ========");
			/**��ʼ�����ݲ�ѯ*/
			ctlBL.searchRiskPropertyActioin(dto);
			IGASM27071VO vo=new IGASM27071VO();
			vo.setGradeList(dto.getGradeList());
			vo.setLevelList(dto.getLevelList());
			vo.setPossibleList(dto.getPossibleList());
			vo.setSignList(dto.getSignList());
			super.<IGASM27071VO>setVO(req, vo);
			log.debug("========���յ��ѯ��ʼ����ʾ����========");
		}//��ʼ��ҳ��
		if("SEARCH".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM2714");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			int maxCnt = getMaxDataCount("IGASM2714");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setForm(igasm2713form);
			/**��ʼ�����ݲ�ѯ*/
			ctlBL.searchRiskPropertyActioin(dto);
			
			//����bl �������ݴ���
			dto=ctlBL.searchRiskPointManagerAction(dto);
			
			
			IGASM27071VO vo=new IGASM27071VO();
			vo.setGradeList(dto.getGradeList());
			vo.setLevelList(dto.getLevelList());
			vo.setPossibleList(dto.getPossibleList());
			vo.setSignList(dto.getSignList());
			vo.setRiskList(dto.getRiskList());
			req.getSession().setAttribute("IGASM2713Form", dto.getIgasm2713Form());
			super.<IGASM27071VO>setVO(req, vo);
			//ʵ����vo
			log.debug("=======���ղ�ѯ�������========");
			
		}
		
		if("EXCEL".equals(mapping.getParameter())){
			log.debug("=====================���յ��ѯ������ʼ=======================");

			dto.setForm(igasm2713form);
			
			// ȡ��Excel����BL
			IGASM2714ExcelBL excelBL = (IGASM2714ExcelBL) getBean("igasm2714ExcelBL");
			
			/**��ʼ�����ݲ�ѯ*/
			ctlBL.searchRiskPropertyActioin(dto);
			//����bl �������ݴ���
			dto=excelBL.searchRiskPointManagerAction(dto);
			
			// ʵ��ExeclDTO
			IGASM2714ExcelDTO excelDTO = new IGASM2714ExcelDTO();
			excelDTO.setProcessList(dto.getRiskList());
			// ���ģ����
			excelDTO.setFileid("ASM2714");
			excelDTO.setResponse(res);
			excelBL.initExcel(excelDTO);
			
			log.debug("=====================���յ��ѯ��������=======================");
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
