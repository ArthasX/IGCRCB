/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR13BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR13DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1301Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR13011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����Դ����Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1301Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGVIR1301Action.class);
		//BLȡ��
		IGVIR13BL ctlBL = (IGVIR13BL) getBean("igvir13BL");
		//ʵ����dto
		IGVIR13DTO dto = new IGVIR13DTO();
		//formȡ��
		IGVIR1301Form form = (IGVIR1301Form) actionForm;
		//dto�����趨
		dto.setHostname(form.getHostname());
		dto.setVcid(form.getVcid());
		//��ʼ����ѯ����
		dto = ctlBL.searchVCenterAction(dto);
		request.setAttribute("AD_vCenterList", dto.getLabelValueBeanList());
		//ҳ���ʼ��������ʼ
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============�����Դ����ҳ���ʼ��������ʼ=============");
			log.debug("==============�����Դ����ҳ���ʼ����������=============");
		}
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("=============�����Դ��ѯ������ʼ============");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGVIR1301");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGVIR1301Form) request.getSession().getAttribute("IGVIR1301Form");
				if ( form == null){
					form = new IGVIR1301Form();
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
						form = (IGVIR1301Form) request.getSession().getAttribute("IGVIR1301Form");
						if (form != null) {
							form.setFromCount(0);
						}
					}
			}
			int maxCnt = getMaxDataCount("IGVIR1301");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto = ctlBL.searchVMInfoAction(dto);
			//ʵ����vo
			IGVIR13011VO vo = new IGVIR13011VO();
			vo.setVim03List(dto.getVim03List());
			super.<IGVIR13011VO>setVO(request, vo);
			log.debug("=============�����Դ��ѯ��������============");
		}
		//��ȡhost
		if("GETHOSTS".equals(mapping.getParameter())){
			log.debug("==========��ȡhost������ʼ==========");
			dto = ctlBL.getHostsAction(dto);
			PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                out.print(dto.getJsonResult());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			log.debug("==========��ȡhost��������==========");
			return null;
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
