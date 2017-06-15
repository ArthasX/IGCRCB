/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.action;

import java.util.ArrayList;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0103Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01033VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̷���action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0103Action extends BaseAction {

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRR0103Action.class);
		//BLȡ��
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		//ʵ����dto
		IGPRR01DTO dto = new IGPRR01DTO();
		//formȡ��
		IGPRR0103Form form = (IGPRR0103Form) actionForm;
		//user����ȡ��
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto�����趨
		dto.setUser(user);
		dto.setAction(form.getAction());
		String prid = request.getAttribute("prid") == null ? null : request.getAttribute("prid").toString();
		if(StringUtils.isNotEmpty(prid)){
			dto.setPrid(Integer.valueOf(prid));
			form.setPrid(Integer.valueOf(prid));
		}else{
			dto.setPrid(form.getPrid());
		}
		dto.setPsdid(form.getPsdid());
		dto.setPdid(form.getPdid());
		String forward = null;
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("=============����ҳ���ʼ��������ʼ==============");
			dto = ctlBL.searchAssignParticipantAction(dto);
			 //ȡ�÷��ɵ���תҳ��
		    dto = ctlBL.getAssignPageAction(dto);
            forward = dto.getAssignPage();
			if(dto.getLst_participant() != null && !dto.getLst_participant().isEmpty()) {
				form.setParticipants(dto.getLst_participant().toArray(new String[0]));
				form.setParticipants_(dto.getLst_participant().toArray(new String[0]));
			} else {
				form.setParticipants(new String[]{""});
				form.setParticipants_(new String[]{""});
			}
			if(dto.getLst_ppsuper() != null && !dto.getLst_ppsuper().isEmpty()) {
				String[] ppuserList = dto.getLst_ppsuper().toArray(new String[0]);
				List<String> urList = new ArrayList<String>();
				
				for(String pu:ppuserList){
					if(StringUtils.isNotEmpty(pu)){
						urList.add(pu);
					}
				}
				if(urList.size()>0){
					form.setPpsupers(urList.toArray(new String[0]));
				}else{
					form.setPpsupers(new String[]{""});
				}
			} else {
				form.setPpsupers(new String[]{""});
			}
			String[] ppusers = form.getParticipants_();
			if(ppusers!=null){
				for(int i=0;i<ppusers.length;i++){
					String ppuser = ppusers[i];
					if(StringUtils.isNotEmpty(ppuser)){
						ppusers[i] = ppuser.split("_")[0]+"_"+ppuser.split("_")[1]+"_";
					}
				}
			}
			form.setParticipants_(ppusers);
			//����VO
			IGPRR01033VO vo = new IGPRR01033VO(dto.getMap_AssignParticipant());
			super.<IGPRR01033VO>setVO(request.getSession(), vo);
			saveToken(request);
			log.debug("=============����ҳ���ʼ����������==============");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		if(StringUtils.isNotEmpty(forward) && StringUtils.isNotEmpty(forward.trim())){
			return new ActionForward(forward);
		}else{
			return mapping.findForward("DISP");
		}
	}
}
