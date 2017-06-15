/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.action;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0112Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01121VO;

/**
 * ����: �ɼ���ѯ֮��������ϸ��ѯ
 * ��������: �ɼ���ѯ֮��������ϸ��ѯ
 * ������¼: yanglongquan 2013/05/31
 * �޸ļ�¼: 
 */
public class IGCIM0112Action extends BaseAction{

	//��־����ȡ��
	Log log = LogFactory.getLog(IGCIM0112Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		//ʵ����dto
		IGCIM01DTO dto = new IGCIM01DTO();
		//formȡ��
		IGCIM0112Form form = (IGCIM0112Form) actionForm;
		
		//dto�����趨
		dto.setIgcim0112Form(form);
		//ҳ���ʼ����ʾ����
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=============����ԭ������ʾҳ���ʼ��������ʼ==============");
			
			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGCIM0112");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//�������ò�ѯ����
			log.debug("========�������ò�ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCIM0112Form) request.getSession().getAttribute("IGCIM0112Form");
				if ( form== null){
					form = new IGCIM0112Form();
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
					form = (IGCIM0112Form) request.getSession().getAttribute("IGCIM0112Form");
					if (form !=null) { 
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0112");
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//ȡ�òɼ����
			dto = ctlBL.getCR01InfoListByCommand(dto);
			log.debug("=============����ԭ������ʾҳ���ʼ����������==============");
		}
		
		//ʵ����vo
		IGCIM01121VO vo = new IGCIM01121VO();
		vo.setCr01List(dto.getCr01List());
		String collecttime = form.getCollecttime();
//		if(StringUtils.isNotEmpty(collecttime)){
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
//			Date time = sdf.parse(collecttime);
//			sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//			collecttime = sdf.format(time);
//		}
		vo.setCollecttime(collecttime);
		vo.setHost(form.getHost());
		vo.setKeys(form.getKeys());
		vo.setTablename(form.getTablename());
		super.<IGCIM01121VO>setVO(request, vo);
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
