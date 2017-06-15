/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.entity.IG499VW;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.asset.bl.IGASM04BL;
import com.deliverik.infogovernor.asset.dto.IGASM04DTO;
import com.deliverik.infogovernor.asset.form.IGASM0424Form;
import com.deliverik.infogovernor.asset.vo.IGASM04241VO;

/**
 * ����: ��ͬͳ��Action
 * ��������: ��ͬͳ��Action
 * ������¼: 2013/06/22
 * �޸ļ�¼: 
 */
public class IGASM0424Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGASM0424Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm ActionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//���form
		IGASM0424Form form=(IGASM0424Form)ActionForm;
		
		//��ÿ���BL
		IGASM04BL ctlBL= (IGASM04BL) getBean("igasm04BL");
		
		//DTO����
		IGASM04DTO dto = new IGASM04DTO();
		
		//�˵���ʾ
		if("DISP".equals(mapping.getParameter())){
			log.debug("========��ͬͳ����ʾ��ʼ========");
		
			log.debug("========��ͬͳ����ʾ����========");
		}
		
		//��ҳ��ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========��ͬͳ�Ʋ�ѯ��ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGASM0424");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//��ͬ��ѯ����
			log.debug("========��ͬӦ����Ǽǲ�ѯ��ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM0424Form) request.getSession().getAttribute("IGASM0424Form");
				if ( form== null){
					form = new IGASM0424Form();
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
					form = (IGASM0424Form) request.getSession().getAttribute("IGASM0424Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0401");
			
			//DTO��������趨
			dto.setEntityItemCompactVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//���ò�ѯ����
			ctlBL.searchStatics(dto);
			
			IGASM04241VO vo=new IGASM04241VO();
			//��ͬͳ��list��jsp
			List<IG499Info> entityItemCompactVWInfoList = dto.getEntityItemCompactVWInfoList();
			List<IG499Info> dataList = new ArrayList<IG499Info>();
			if(entityItemCompactVWInfoList!=null&&entityItemCompactVWInfoList.size()>0){
				for(IG499Info ei:entityItemCompactVWInfoList){
					IG499VW eivw = (IG499VW) SerializationUtils.clone(ei);
					if(StringUtils.isNotEmpty(eivw.getFacilitator())){
						int temp = eivw.getFacilitator().indexOf("(");
						if(temp<0){
							temp = eivw.getFacilitator().length();
						}
						eivw.setFacilitator(eivw.getFacilitator().substring(0,temp));
					}
					dataList.add(eivw);
				}
			}
			vo.setEntityItemCompactVWList(dataList);
			super.<IGASM04241VO>setVO(request, vo);
			log.debug("========��ͬӦ����Ǽǲ�ѯ����========");
			
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
