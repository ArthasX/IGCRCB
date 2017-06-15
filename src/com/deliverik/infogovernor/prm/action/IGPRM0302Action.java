/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.prm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.prm.bl.IGPRM01BL;
import com.deliverik.infogovernor.prm.dto.IGPRM01DTO;
import com.deliverik.infogovernor.prm.form.IGPRM0302Form;
import com.deliverik.infogovernor.prm.vo.IGPRM03011VO;

public class IGPRM0302Action extends BaseAction {

	/**
	 * <p>
	 * Title : InfoGovernor ��Ϣ�������ƽ̨
	 * </p>
	 * <p>
	 * Description: ϵͳ����_ģ�����_��ѯACTION
	 * </p>
	 * 
	 * @author sunkaiyu@deliverik.com
	 * @version 1.0
	 */
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		IGPRM01DTO dto = new IGPRM01DTO();
		IGPRM0302Form form = (IGPRM0302Form)actionForm;
		if("INSERT".equals(mapping.getParameter())){
			IGPRM01BL igprm01BL = (IGPRM01BL)this.getBean("IGPRM01BL");
			dto.setIgPRM0302Form(form);
			dto.setProcessInfoDef(form);
			if (isTokenValid(req, true)){
				//����BL����
				dto = igprm01BL.insertProcessInfoDef(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			IGPRM03011VO vo = new IGPRM03011VO();
			vo.setProcessInfoDef(dto.getProcessInfoDef());
			req.setAttribute("vo", vo);
		} else {//ҳ��DISP
			boolean flag = false;//������������������ڴ����е�����ʱ�������ӱ���ȱʡ�����ˡ�
			StringBuffer mesg = new StringBuffer("");
			IG500BL ig500BL = (IG500BL)getBean("ig500BL");
			IG500SearchCondImpl cond = new IG500SearchCondImpl();
			cond.setPrpdid(form.getPdid());
			List<IG500Info> list = ig500BL.searchIG500Info(cond);
			for(IG500Info pr:list){
				if(!"C".equals(pr.getPrstatus())){
					if(!flag){
						flag = true;
					}
					mesg=mesg.append(pr.getPrserialnum()+",");
				}
			}
			if(flag){
				dto.addMessage(new ActionMessage("IGPRM0302.E001",mesg.toString().substring(0,mesg.toString().length()-1)));
				List<ActionMessage> messageList = dto.getMessageList();
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
				}
				return mapping.findForward("ERROR");
			}
			
			
			saveToken(req);
		}
		return mapping.findForward("DISP");
	}
	
}
