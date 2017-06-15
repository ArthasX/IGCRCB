/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.action;


import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR12BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR12DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1201Form;
import com.google.gson.Gson;

/**
 * ����: ��Դռ�����
 * ��������: ��Դռ�����
 * ������¼: 2014/02/12
 * �޸ļ�¼: 
 */
public class IGVIR1201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR1201Action.class);

	/**
	 * ���ð�����ϵ��ʾ����
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
	    IGVIR1201Form form = (IGVIR1201Form)actionForm;
		//BLȡ��
		IGVIR12BL ctlBL = (IGVIR12BL) getBean("igvir12BL");

		//DTO����
		IGVIR12DTO dto = new IGVIR12DTO();
		
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
		    log.debug("============= ��Դ���������ʼ����ʼ ==============");
			log.debug("---- ��ʾ��������" + form.getHostname() + "-------------");
			form.setHostname(form.getHostname());
		    log.debug("============= ��Դ���������ʼ������ ==============");
		}else if("TREEDATA".equals(mapping.getParameter())){
            log.debug("========��ʼ========");
			PrintWriter out = null;
            try {
            	out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
            	ctlBL.getvCenterList(dto);
    			Gson gson = new Gson();
				gson.toJson(dto.getTreeData(), out);
            } catch (Exception e) {
                out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("========����========");
            return null;
		}else if("PAGEDATA".equals(mapping.getParameter())){
            log.debug("========��ʼ========");
			PrintWriter out = null;
            try {
            	out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
            	String treeId = req.getParameter("treeId");
            	dto.setTreeId(treeId);
            	ctlBL.getHostInfo(dto);
    			Gson gson = new Gson();
				gson.toJson(dto.getHost(), out);
            } catch (Exception e) {
                out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("========����========");
            return null;
        //�������߹ر����
		}else if("OPRATE".equals(mapping.getParameter())){
			log.debug("========���������ʼ========");
			String treeId = req.getParameter("treeId");
			String vmname = req.getParameter("vmName");
			String type = req.getParameter("type");
			dto.setTreeId(treeId);
			dto.setVmName(vmname);
			dto.setOprateType(type);
			ctlBL.startOrStopPowerOfVM(dto);
			log.debug("========�����������========");
		}
//		List<ActionMessage> messageList = dto.getMessageList();
//		if( messageList != null && messageList.size() > 0 ) {
//			for (ActionMessage message : messageList) {	
//				addMessage(req, message);
//			}
//		}
		return mapping.findForward(forward);
	}
}
