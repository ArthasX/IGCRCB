/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.asset.bl.IGASM0422ExcelBL;
import com.deliverik.infogovernor.asset.bl.IGASM04BL;
import com.deliverik.infogovernor.asset.dto.IGASM0422ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM04DTO;
import com.deliverik.infogovernor.asset.form.IGASM0401Form;
import com.deliverik.infogovernor.asset.form.IGASM0422Form;
import com.deliverik.infogovernor.asset.vo.IGASM04221VO;

/**
 * ����: ��ͬӦ�����ѯAction
 * ��������: ��ͬӦ�����ѯAction
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
public class IGASM0422Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGASM0422Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm ActionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//���form
		IGASM0422Form form=(IGASM0422Form)ActionForm;
		
		//��ÿ���BL
		IGASM04BL ctlBL= (IGASM04BL) getBean("igasm04BL");
		
		//DTO����
		IGASM04DTO dto = new IGASM04DTO();
		
		//�˵���ʾ
		if("DISP".equals(mapping.getParameter())){
			log.debug("========��ͬӦ����Ǽǲ˵���ʾ��ʼ========");
			//��ǰʱ���ȡ��
			form.setDatetime(IGStringUtils.getCurrentDate());
			
			//��ͬ���������˵�ȡ��
			IGASM0401Form new_form = new IGASM0401Form();
			//���ͷ���(��ͬ)�趨
			new_form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT);
			request.setAttribute("IGASM0401Form", form);
			
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto = ctlBL.checkEntityItemDomain(dto);
			request.getSession().setAttribute("ADselectList", dto.getSelectList());
			
			log.debug("========��ͬӦ����Ǽǲ˵���ʾ����========");
		}
		
		//��ҳ��ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========��ͬӦ����Ǽǲ�ѯ��ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGASM0422");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//��ͬ��ѯ����
			log.debug("========��ͬӦ����Ǽǲ�ѯ��ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM0422Form) request.getSession().getAttribute("IGASM0422Form");
				if ( form== null){
					form = new IGASM0422Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGASM0422Form) request.getSession().getAttribute("IGASM0422Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0422");
			
			//DTO��������趨
			dto.setEntityItemCompactVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
		//Ӧ����Ǽǲ�ѯ����2(��ӦӦ�����ѯ)
		ctlBL.searchEntityItemCompactVW2Action(dto);
		IGASM04221VO vo=new IGASM04221VO();
		vo.setEntityItemCompactVWList(dto.getEntityItemCompactVWInfoList());
		super.<IGASM04221VO>setVO(request, vo);
		log.debug("========��ͬӦ����Ǽǲ�ѯ����========");
		
	}
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("==============��ͬӦ�����������ʼ====================");
			//���ò�ѯ����
			dto.setEntityItemCompactVWSearchCond(form);
			//��ѯ��ʼ����������
			dto=ctlBL.intiIGASM0422Action(dto);

			IGASM0422ExcelDTO excelDto = new IGASM0422ExcelDTO();
			IGASM0422ExcelBL excelBL = (IGASM0422ExcelBL) getBean("igasm0422excelBL");
			//��������
			excelDto.setReportDataList(dto.getReportDataList());
			excelDto.setFileid("ASM0422");
			excelDto.setResponse(response);
			excelBL.initExcel(excelDto);
			log.debug("==============��ͬӦ�������������====================");
			return null;
		}
		
		
		
		
		
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
			
		}
		return mapping.findForward("DISP");
	}
}
