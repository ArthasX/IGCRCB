package com.deliverik.infogovernor.dbm.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dbm.bl.IGDBM13BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM13DTO;
import com.deliverik.infogovernor.dbm.form.IGDBM1301Form;
import com.deliverik.infogovernor.dbm.vo.IGDBM13011VO;
import com.deliverik.infogovernor.xls.svc.bl.IGSVC1301ExcelBL;
import com.deliverik.infogovernor.xls.svc.dto.IGSVC1301ExcelDTO;

/**
 * ���������ѯ����Action����
 *
 */
public class IGDBM1301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM1301Action.class);

	/**
	 * ���������ѯ����
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
		IGDBM1301Form form = (IGDBM1301Form)actionForm;
		
		//BLȡ��
		IGDBM13BL ctlBL = (IGDBM13BL) getBean("igdbm13BL");
		//����
//		AttachmentBL attachmentBL = (AttachmentBL)getBean("attachmentBL");
		//DTO����
		IGDBM13DTO dto = new IGDBM13DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========���ռ���������������ʾ����ʼ========");
//			addMessage(req, new ActionMessage("IGCO10000.I001","���ռ�������Ϣ"));
			log.debug("========���ռ���������������ʾ��������========");
			return mapping.findForward("DISP");
		}else if("SEARCH".equals(mapping.getParameter())){
			log.debug("========���������ѯ��ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDBM1301");
			
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			log.debug("========�ĵ���ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDBM1301Form) req.getSession().getAttribute("IGDBM1301Form");
				if ( form== null){
					form = new IGDBM1301Form();
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
			int maxCnt = getMaxDataCount("IGDBM1301");
			//DTO��������趨
			dto.setIgdbm1301Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setIgdbm1301Form(form);
			dto = ctlBL.searchWorkmanagerInfos(dto);
			
			IGDBM13011VO vo = new IGDBM13011VO();
			vo.setWmList(dto.getWmList());
			super.<IGDBM13011VO>setVO(req, vo);
			log.debug("========���������ѯ����========");
			return mapping.findForward("DISP");
		}else if("FINISH".equals(mapping.getParameter())){
			log.debug("=======������Ϣ��ɴ���ʼ========");
			
			dto.setIgdbm1301Form(form);
			dto.setUser(user);
			//����BL����
			dto = ctlBL.updateWorkmanagerInfo(dto);
			
			log.debug("========������Ϣ��ɴ�������========");
		}else if ("EXPORT".equals(mapping.getParameter())) {
			log.debug("==========������Ϣ������ʼ ==========");
			
			dto.setIgdbm1301Form(form);
			dto = ctlBL.exportWorkmanagerInfos(dto);
			IGSVC1301ExcelDTO excelDTO = new IGSVC1301ExcelDTO();
			//��ѯģ��
			excelDTO.setFileid("SVC1302");
			excelDTO.setResponse(res);
			excelDTO.setIgdbm1301Form(form);
			excelDTO.setWmList(dto.getWmList());
			IGSVC1301ExcelBL excelBL = (IGSVC1301ExcelBL) getBean("igsvc1301excelBL");
			excelBL.initExcel(excelDTO);

			log.debug("========������Ϣ��������========");
			return null;
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
