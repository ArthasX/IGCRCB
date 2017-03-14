/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.bl.IGDRM06BL;
import com.deliverik.infogovernor.drm.dto.IGDRM06DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0601Form;
import com.deliverik.infogovernor.drm.vo.IGDRM06031VO;


/**
 * �����ƻ��Ǽ�/�޸�Action
 * @author wyw
 * 
 * 2015-2-12 ����9:51:47
 */
public class IGDRM0601Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0601Action.class);

	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		//BLȡ��
		IGDRM06BL ctlBL = (IGDRM06BL) getBean("igdrm06BL");
		
		IGDRM0601Form form = (IGDRM0601Form)actionForm;
		//DTO����
		IGDRM06DTO dto = new IGDRM06DTO();
		dto.setUser(user);
		dto.setForm(form);
		//������ת�趨
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			//�����
			dto=ctlBL.initIGDRM0601Action(dto);
			saveToken(req);
			//�����̶�����Ϣ��������趨��VO��
	        IGDRM06031VO vo = new IGDRM06031VO();
	        vo.setDrillItemList(dto.getDrillItemList());
	        super.<IGDRM06031VO>setVO(req.getSession(), vo);
		    return mapping.findForward(forward);
		}
		if( "INSERT".equals(mapping.getParameter())){
           if (isTokenValid(req, true)){
                    //����BL����
              dto = ctlBL.insertDrillplanAction(dto);
              addMessage(req, new ActionMessage("IGDRM0601.I001", "�����ƻ������ɹ�����ţ�"+dto.getDrillplanInfo().getDserial()));
           }else{
               addMessage(req, new ActionMessage("IGCO00000.E007"));
                    return mapping.findForward("/error1");
           }
           log.debug("========����������������========");
		}
		
		if( "EDIT".equals(mapping.getParameter())){
		    if (isTokenValid(req, true)){
		        //����BL����
		        dto = ctlBL.insertDrillplanAction(dto);
		        addMessage(req, new ActionMessage("IGDRM0601.I001", "�����ƻ��޸ĳɹ���"));
		    }else{
		        addMessage(req, new ActionMessage("IGCO00000.E007"));
		        return mapping.findForward("/error1");
		    }
		    log.debug("========����������������========");
		}
		
        List<ActionMessage> messageList = dto.getMessageList();
        if (messageList != null && messageList.size() > 0) {
            for (ActionMessage message : messageList) {
                addMessage(req, message);
            }
        }
		return mapping.findForward(forward);
	}
}
