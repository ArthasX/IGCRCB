/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.action;

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
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.dbm.bl.IGDBM11BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM11DTO;
import com.deliverik.infogovernor.dbm.form.IGDBM0201Form;
import com.deliverik.infogovernor.dbm.vo.IGDBM02011VO;

/**
 * ȫ��IP���˴���Action
 * @version 1.0
 */

public class IGDBM0201Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDBM0201Action.class);
	
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
	    //FORMȡ��
	    IGDBM0201Form form = (IGDBM0201Form)actionForm;
	    
	    IGDBM11BL ctlBL = (IGDBM11BL) getBean("igdbm11BL");
	    
	    IGDBM11DTO dto = new IGDBM11DTO();
		//������ת�趨
		String forward = "DISP";
		
		if("DISP".equals(mapping.getParameter())){
		    log.debug("========ȫ��IP���˳�����ʾ����ʼ========");
		    form.setIp("");
		    ctlBL.searchIp_FilterInfo(dto);
		    
		    IGDBM02011VO vo = new IGDBM02011VO();
		    
		    vo.setIpFilterInfoList(dto.getIpFilterInfoList());
		    saveToken(req);
		    super.<IGDBM02011VO>setVO(req, vo);
			log.debug("========ȫ��IP���˳�����ʾ�������========");
		}
		
		if("INSERT".equals(mapping.getParameter())){
		    log.debug("========ȫ��IP������������ʼ==========");
		    if (isTokenValid(req, true)){
		        form.setAddtime(IGStringUtils.getCurrentDateTime());
	            dto.setIgdbm0201Form(form);
	            ctlBL.addIpFilterInfo(dto);
            }else{
                addMessage(req, new ActionMessage("IGCO00000.E007"));
                return mapping.findForward("/error1");
            }
		    log.debug("========ȫ��IP���������������==========");
		}
		
		if("DEL".equals(mapping.getParameter())){
		    log.debug("========ȫ��IP����ɾ������ʼ==========");
		    if (isTokenValid(req, true)){
		        String id = req.getParameter("delId");
	            dto.setId(id);
	            ctlBL.delIpFilterInfo(dto);
            }else{
                addMessage(req, new ActionMessage("IGCO00000.E007"));
                return mapping.findForward("/error1");
            }
		    log.debug("========ȫ��IP����ɾ���������==========");
		}
		if("BatchDEL".equals(mapping.getParameter())){
			log.debug("========ȫ��IP��������ɾ������ʼ==========");
		    if (isTokenValid(req, true)){
		        form.setAddtime(IGStringUtils.getCurrentDateTime());
	            dto.setIgdbm0201Form(form);
	            ctlBL.BatchdelIpFilterInfo(dto);
            }else{
                addMessage(req, new ActionMessage("IGCO00000.E007"));
                return mapping.findForward("/error1");
            }
			log.debug("========ȫ��IP��������ɾ���������==========");
		}
		
		//�߼���������е���Ϣ��ʾ
        List<ActionMessage> messageList = dto.getMessageList();
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(req, message);
            }
        }
		return mapping.findForward(forward);
	}
}
