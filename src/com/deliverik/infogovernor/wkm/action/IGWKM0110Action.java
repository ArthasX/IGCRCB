/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wkm.action;

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
import com.deliverik.infogovernor.wkm.bl.IGWKM01BL;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0110Form;
import com.deliverik.infogovernor.wkm.vo.IGWKM01101VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Զ�������ͨ�ò�ѯaction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGWKM0110Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGWKM0110Action.class);
		//BLȡ��
		IGWKM01BL ctlBL = (IGWKM01BL) getBean("igwkm01BL");
		//ʵ����dto
		IGWKM01DTO dto = new IGWKM01DTO();
		//formȡ��
		IGWKM0110Form form = (IGWKM0110Form) actionForm;
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("==========���̲�ѯ������ʼ===========");
			log.debug("==========���̲�ѯ��������===========");
		}
		//���̲�ѯ����
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){

			//��ȡ��ҳBean
			getPaginDTO(request,"IGWKM0110");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGWKM0110Form) request.getSession().getAttribute("IGWKM0110Form");
				if ( form == null ) {
					form = new IGWKM0110Form();
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
					form = (IGWKM0110Form) request.getSession().getAttribute("IGWKM0110Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			int maxCnt = getMaxDataCount("IGWKM0110");
			//�����ʶȡ��
			String orderVal = request.getParameter("orderVal");		
			//��ҳʱ���������ʶ
			if(StringUtils.isNotEmpty(orderVal)){
				form.setOrder(orderVal);
			}

			//�趨����ʽ
			if(StringUtils.isNotEmpty(form.getOrder())){
				if(StringUtils.isNotEmpty(orderVal)){
					if(orderVal.equals(form.getOrder())){
						if("DESC".equals(form.getSing())){
							form.setSing("ASC");
						}else{
							form.setSing("DESC");
						}
					}else{
						form.setSing("ASC");
					}
				}
			}else {//�����ʶΪ��ʱĬ�ϰ�ʱ������
				form.setOrder("propentime");
				form.setSing("DESC");
			}
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setIgwkm0110Form(form);
			//����BL��ѯ
			dto = ctlBL.searchProcessRecordAction(dto);
			IGWKM01101VO vo = new IGWKM01101VO();
			vo.setProcessList(dto.getProcessList());
			super.<IGWKM01101VO>setVO(request, vo);
		
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
