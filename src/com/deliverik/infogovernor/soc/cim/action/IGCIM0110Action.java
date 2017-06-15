/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0110Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01101VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ԭ������ʾaction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCIM0110Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGCIM0110Action.class);
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		//ʵ����dto
		IGCIM01DTO dto = new IGCIM01DTO();
		//formȡ��
		IGCIM0110Form form = (IGCIM0110Form) actionForm;
		
		String otherFlag ="";
		//dto�����趨
		dto.setIgcim0110Form(form);
		//ҳ���ʼ����ʾ����
		if("DISP".equals(mapping.getParameter())){
			log.debug("=============����ԭ������ʾҳ���ʼ��������ʼ==============");
			//�ж��Ƿ�Ϊ��һ�η���
			if(StringUtils.isNotEmpty(form.getFirstAccess())){
				otherFlag = form.getFirstAccess();
				form.reset(mapping, request);
			}
			//��ʼ���汾��Ϣ
			dto = ctlBL.getRciVersionsAction(dto);
			//��ǰ���°汾��Ϣȡ��
			dto = ctlBL.getCurrentNewCriVersionAction(dto);
			//ȡ�òɼ����
			dto = ctlBL.getCR01InfoList(dto);
			log.debug("=============����ԭ������ʾҳ���ʼ����������==============");
		}
		//��ʾ��Ӧ�汾��Ϣ����
		if("HISTORY".equals(mapping.getParameter())){
			log.debug("===============��Ӧ�汾��Ϣ��ʾ������ʼ================");
			//��ʼ���汾��Ϣ
			dto = ctlBL.getRciVersionsAction(dto);
			//��ʷ�汾��Ϣȡ��
			dto = ctlBL.getHostoryVersions(dto);
			//ȡ�òɼ����
			dto = ctlBL.getCR01InfoList(dto);
			log.debug("===============��Ӧ�汾��Ϣ��ʾ��������================");
		}
		//ʵ����vo
		IGCIM01101VO vo = new IGCIM01101VO();
		vo.setCr03VWList(dto.getCr03VWList());
//		vo.setEntityItem(dto.getEntityItem());
		vo.setHost(form.getHost());
//		vo.setCr03(dto.getCr03());
		vo.setCr03VW(dto.getCr03VW());
		vo.setCr01List(dto.getCr01List());
		vo.setShowFlag(dto.getShowFlag());
		vo.setOtherFlag(otherFlag);
		super.<IGCIM01101VO>setVO(request, vo);
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
