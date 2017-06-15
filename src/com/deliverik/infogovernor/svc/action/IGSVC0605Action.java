/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.svc.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.svc.bl.IGSVC07BL;
import com.deliverik.infogovernor.svc.dto.IGSVC07DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0604Form;
import com.deliverik.infogovernor.svc.vo.IGSVC05131VO;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�¼�����_�鿴ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSVC0605Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSVC0605Action.class);
	
	/**
	 * <p>
	 * Description: �¼�action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGSVC0604Form form = (IGSVC0604Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSVC07BL ctlBL = (IGSVC07BL) getBean("igsvc07BL");
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		IGSVC07DTO dto = new IGSVC07DTO();
		form.setPpuserid(user.getUserid());
		dto.setUserid(user.getUserid());
		dto.setUsername(user.getUsername());
		String prtype = request.getParameter("type");
		form.setPrtype(prtype);
		//ʵ����DTO
		dto.setPrid(form.getPrid());
		//�¼��鿴ҳ���ʼ��
		log.debug("========�¼��鿴������ʾ����ʼ========");
		dto.setPrSearchCond(form);
		String forward = "DISP";
		dto = ctlBL.getOperationById(dto);
		IGSVC05131VO vo = new IGSVC05131VO();
		vo.setProcess(dto.getProcess());
		vo.setExpectProcessTime(dto.getExpectProcessTime());
		vo.setExpectStatusTime(dto.getExpectStatusTime());
		vo.setInitStatusTime(dto.getInitStatusTime());
		vo.setProcessInfo(dto.getProcessInfo());
		vo.setProcessRecordRelationList(dto.getProcessRecordRelationList());
		if(IGPROCESSType.INCIDENT_PRTYPE.equals(form.getPrtype())){
			Map<String,String> map = new LinkedHashMap<String, String>();
			List<IG599Info> retList = new ArrayList<IG599Info>();
			vo.setPerMap(map);
			vo.setProcessInfo(retList);
			forward = "INCIDENT";
		}else if(IGPROCESSType.PROBLEM_PRTYPE.equals(form.getPrtype())){
			forward = "PROBLEM";
		}else if(IGPROCESSType.CHANGE_PRTYPE.equals(form.getPrtype())){
			forward = "CHANGE";
		}else if(IGPROCESSType.DEPLOYMENT_PRTYPE.equals(form.getPrtype())){
			forward = "DEPLOYMENT";
		}else if(IGPROCESSType.SERVICE_PRTYPE.equals(form.getPrtype())){
			forward = "SERVICE";
		}else if("WA".equals(form.getPrtype())){
			forward = "WA";
		}else if("WB".equals(form.getPrtype())){
			forward = "WB";
		}else if("WS".equals(form.getPrtype())){
			Map<String,String> map = new LinkedHashMap<String, String>();
			List<IG599Info> retList = new ArrayList<IG599Info>();
			vo.setPerMap(map);
			vo.setProcessInfo(retList);
			forward = "WS";
		}
		super.<IGSVC05131VO>setVO(request, vo);
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		log.debug("========�¼��鿴������ʾ��������========");
		return mapping.findForward(forward);
	}
	
}
