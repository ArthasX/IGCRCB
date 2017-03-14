/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.action;

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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR12BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR12DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1202Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR12021VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Դʹ�����չʾAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1202Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGVIR1202Action.class);
		//BLȡ��
		IGVIR12BL ctlBL = (IGVIR12BL) getBean("igvir12BL");
		//ʵ����dto
		IGVIR12DTO dto = new IGVIR12DTO();
		//formȡ��
		IGVIR1202Form form = (IGVIR1202Form) actionForm;
		//dto�����趨
		dto.setVcid(form.getVcid());
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============��Դʹ�����չʾҳ���ʼ��������ʼ==============");
			//��ѯvcenter������Ϣ
			dto = ctlBL.initIGVIR1202Action(dto);
			//ʵ����vo
			IGVIR12021VO vo = new IGVIR12021VO();
			vo.setVcid(dto.getVcid());
			vo.setVim01List(dto.getVim01List());
			vo.setHostList(dto.getHostList());
			super.<IGVIR12021VO>setVO(request, vo);
			log.debug("==============��Դʹ�����չʾҳ���ʼ����������==============");
		}
		
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=============ָ��vCenter��Host��Դʹ�������ѯ������ʼ============");
			dto = ctlBL.searchHostUsedAction(dto);
			//ʵ����vo
			IGVIR12021VO vo = new IGVIR12021VO();
			vo.setVcid(dto.getVcid());
			vo.setVim01List(dto.getVim01List());
			vo.setHostList(dto.getHostList());
			super.<IGVIR12021VO>setVO(request, vo);
			log.debug("=============ָ��vCenter��Host��Դʹ�������ѯ��������============");
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
