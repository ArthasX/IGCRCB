/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.action;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.deliverik.infogovernor.soc.alarm.bl.IGALM07BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM07DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0501Form;
import com.deliverik.infogovernor.soc.alarm.vo.IGALM05011VO;


public class IGALM0501Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0102Action.class);

	/**
	 * ���ܲ�ѯҳ��
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGALM0501Form form = (IGALM0501Form)actionForm;
		String collecttime="";
		//��ȡ���������ת�����ַ���
		//BLȡ��
		IGALM07BL ctlBL = (IGALM07BL) getBean("igalm07BL");
		//DTO����
		IGALM07DTO dto = new IGALM07DTO();
	   
		if( "DISP".equals(mapping.getParameter())){
			if ("DISP".equals(mapping.getParameter())){
				form = (IGALM0501Form) request.getSession().getAttribute("IGALM0501Form");
			}
			//��ȡ��ҳBean���������ݵ�dto��
			getPaginDTO(request,"IGALM0501");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//�ж��Ƿ�����ϸ���棬�༭���淵�ز�ѯ����
			if ( "DISP".equals(mapping.getParameter())){
				
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGALM0501Form) request.getSession().getAttribute("IGALM0501Form");
				if ( form== null){
					form = new IGALM0501Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} 
			else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGALM0501Form) request.getSession().getAttribute("IGALM0501Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			collecttime= sdf.format(date);
			form.setCollecttime(collecttime);
			form.setNowCollecttime(collecttime);
			//�����ѯ���ڵ��ڽ���  ��CR02�� �ҵ����µı�����ʵʱ��   �������ʷ��

			form.setTablename(ctlBL.searchTable(form));
			//��ѯ��¼�����ֵ
			int maxCnt = getMaxDataCount("IGALM0501");
			//������������
			dto.setCrm10SearchCond(form);
			//��ѯ������¼������
			dto.setMaxSearchCount(maxCnt);
			//��ҳBean����
			pDto.setPageDispCount(12);
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchALM0501VWAction(dto);
			//����VO
			IGALM05011VO vo = new IGALM05011VO();
			vo.setIgalm0501VWList(dto.getIgalm0501VWList());
			super.<IGALM05011VO>setVO(request, vo);
		}
		//Server Xml�ϴ���ʷ��ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGALM0501Form) request.getSession().getAttribute("IGALM0501Form");
			}
			//��ȡ��ҳBean���������ݵ�dto��
			getPaginDTO(request,"IGALM0501");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//�ж��Ƿ�����ϸ���棬�༭���淵�ز�ѯ����
			if ( "SEARCH1".equals(mapping.getParameter())){
				
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGALM0501Form) request.getSession().getAttribute("IGALM0501Form");
				if ( form== null){
					form = new IGALM0501Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} 
			else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGALM0501Form) request.getSession().getAttribute("IGALM0501Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			collecttime= sdf.format(date);
			form.setCollecttime(collecttime);
			form.setNowCollecttime(collecttime);
			//�����ѯ���ڵ��ڽ���  ��CRM02�� �ҵ����µı�����ʵʱ��   �������ʷ��
			boolean Isflag=true;
			if(!form.getGet_EndTime().isEmpty()&&Isflag){
				if(form.getGet_EndTime().substring(0, 10).replace("/", "").trim().equals(collecttime)&&form.getGet_StartTime().isEmpty()){
					form.setTablename(ctlBL.searchTable(form));
				}
				else if(form.getGet_EndTime().substring(0, 10).replace("/", "").trim().equals(collecttime)&&!form.getGet_StartTime().isEmpty())
				   {
					if(form.getGet_StartTime().substring(0, 10).replace("/", "").trim().equals(collecttime))
					{
						form.setTablename(ctlBL.searchTable(form));
					}
					else
					{
						form.setTablename("crm10");
					}
					
				    }
				else
				{
					form.setTablename("crm10");
				}
				Isflag=false;
				
		    }
			
			else if (!form.getGet_StartTime().isEmpty()&&Isflag){
				if(form.getGet_StartTime().substring(0, 10).replace("/", "").trim().equals(collecttime)&&form.getGet_EndTime().isEmpty()){
					form.setTablename(ctlBL.searchTable(form));
					}
				  else if(form.getGet_StartTime().substring(0, 10).replace("/", "").trim().equals(collecttime)&&!form.getGet_EndTime().isEmpty())
				  {
					if(form.getGet_EndTime().substring(0, 10).replace("/", "").trim().equals(collecttime))
					{
						form.setTablename(ctlBL.searchTable(form));
					}
					else
					{
						form.setTablename("crm10");
					}
				  }
				
				else{
						form.setTablename("crm10");
						}
				}
			else{
					form.setTablename("crm10");
					}		
			
			//��ѯ��¼�����ֵ
			int maxCnt = getMaxDataCount("IGALM0501");
			//������������
			form.setSymType(String.valueOf(form.getServertype()));
			dto.setCrm10SearchCond(form);
			//��ѯ������¼������
			dto.setMaxSearchCount(maxCnt);
			//��ҳBean����
			pDto.setPageDispCount(12);
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchALM0501VWAction(dto);
			//����VO
			IGALM05011VO vo = new IGALM05011VO();
			vo.setIgalm0501VWList(dto.getIgalm0501VWList());
			super.<IGALM05011VO>setVO(request, vo);
			
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
