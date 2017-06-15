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
import com.deliverik.infogovernor.asset.bl.IGASM2814ExcelBL;
import com.deliverik.infogovernor.asset.bl.IGASM28BL;
import com.deliverik.infogovernor.asset.dto.IGASM2814ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;
import com.deliverik.infogovernor.asset.form.IGASM2814Form;
import com.deliverik.infogovernor.asset.vo.IGASM28071VO;

/**
 * ���յ��ѯ����Action����
 *
 */
public class IGASM2814Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2814Action.class);

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
		IGASM2814Form igasm2814form = (IGASM2814Form) actionForm;
		
		//BLȡ��
		IGASM28BL ctrlBL = (IGASM28BL) getBean("igasm28BL");
		
		//DTO����
		IGASM28DTO dto = new IGASM28DTO();
		dto.setIgasm2814form(igasm2814form);
		
		
		if ("DISP".equals(mapping.getParameter())){
			//���յ��޸Ĵ�����ʾ
			log.debug("========���յ��ѯ��ʼ����ʾ��ʼ========");
			//��ȡ������Ƶ��
			ctrlBL.searchRiskPropertyActioin(dto);
			
			IGASM28071VO vo=new IGASM28071VO();
			vo.setCheckfrequencyList(dto.getCheckfrequencyList());
			super.<IGASM28071VO>setVO(req, vo);
			//ʵ����vo
			log.debug("=======������ʲ���ѯ�������========");
			
		}else if("SEARCH".equals(mapping.getParameter())){
			//��ȡ������Ƶ��
			ctrlBL.searchRiskPropertyActioin(dto);
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM2814");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			
			int maxCnt = getMaxDataCount("IGASM2814");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//����bl �������ݴ���
			ctrlBL.searchCheckItemListAction(dto);
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setIgasm2814form(igasm2814form);

			IGASM28071VO vo=new IGASM28071VO();
			vo.setIgasm2814form(igasm2814form);
			vo.setItemList(dto.getItemList());
			vo.setCheckfrequencyList(dto.getCheckfrequencyList());
			super.<IGASM28071VO>setVO(req, vo);
		}
	
		if("EXCEL".equals(mapping.getParameter())){
			log.debug("=====================������ѯ������ʼ=======================");
			
			dto.setIgasm2814form(igasm2814form);
			// ȡ��Excel����BL
			IGASM2814ExcelBL excelBL = (IGASM2814ExcelBL) getBean("igasm2814ExcelBL");
			//����bl �������ݴ���
			dto=excelBL.searchCheckItemListAction(dto);
			// ʵ��ExeclDTO
 			IGASM2814ExcelDTO excelDTO = new IGASM2814ExcelDTO();
			excelDTO.setItemList(dto.getItemList());
			// ���ģ����
			excelDTO.setFileid("ASM2814");
			excelDTO.setResponse(res);
			excelBL.initExcel(excelDTO);
			log.debug("=====================������ѯ��������=======================");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//�����ɾ������
			log.debug("========�����ɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItem(igasm2814form.getDeleteEiid());
			
			//�������Ϣɾ���߼�����
			ctrlBL.deleteEntityItemAction(dto);
			
			log.debug("========�����ɾ����������========");
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
