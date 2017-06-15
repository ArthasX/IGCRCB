/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR03BL;
import com.deliverik.infogovernor.prr.dto.IGPRR03DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0302Form;
import com.deliverik.infogovernor.prr.vo.IGPRR03021VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:��ɫ��ѯAction 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0302Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRR0302Action.class);
		//BLȡ��
		IGPRR03BL ctlBL = (IGPRR03BL) getBean("igprr03BL");
		//ʵ����dto
		IGPRR03DTO dto = new IGPRR03DTO();
		//form����ȡ��
		IGPRR0302Form form = (IGPRR0302Form) actionForm;
		if("DISP".equals(mapping.getParameter())){
			log.debug("================��ɫ��ѯ������ʼ===============");
			String roletype = request.getParameter("roletype");
			String roleids = request.getParameter("roleids");
			String roleidin = request.getParameter("roleidin");
			form.reset();
			if(StringUtils.isNotEmpty(roletype)){
				form.setDisabled("1");
				form.setRoletype(roletype);
			}else{
				form.setDisabled("0");
			}
			if(StringUtils.isNotEmpty(roleids)){
				form.setRoleids(roleids);
			}
			if(StringUtils.isNotEmpty(roleidin)){
				form.setRoleidin(roleidin);
			}
			log.debug("================��ɫ��ѯ��������===============");
		}
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("===========��ɫ��ѯ������ʼ==========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGPRR0302");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGPRR0302Form) request.getSession().getAttribute("IGPRR0302Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			//����ҳ���ѯ������¼����ȡ��
			int maxCnt = getMaxDataCount("IGPRR0302");
			//����ҳ���ѯ������¼�����趨
			dto.setMaxSearchCount(maxCnt);
			//��ҳdto�趨
			dto.setPagingDto(pDto);
			//form�趨
			dto.setIgprr0302Form(form);
			//����BL��ѯ
			dto = ctlBL.searchRoleListAction(dto);
			//ʵ����vo
			IGPRR03021VO vo = new IGPRR03021VO();
			vo.setRoleList(dto.getRoleList());
			super.<IGPRR03021VO>setVO(request, vo);
			log.debug("===========��ɫ��ѯ��������==========");
		}
		if("ADD".equals(mapping.getParameter())){
			log.debug("============���ý�ɫ��Ӳ�����ʼ===========");
			//ҳ������趨
			dto.setIgprr0302Form(form);
			dto = ctlBL.addIG001InfoAction(dto);
			response.getWriter().write("<script>window.opener.refresh();window.close();</script>");
			log.debug("============���ý�ɫ��Ӳ�������===========");
			return null;
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
