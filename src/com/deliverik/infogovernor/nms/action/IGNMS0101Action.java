/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.nms.bl.IGNMS01BL;
import com.deliverik.infogovernor.nms.bl.task.NMSBaseBLImpl;
import com.deliverik.infogovernor.nms.dto.IGNMS01DTO;
import com.deliverik.infogovernor.nms.event.IGNMS0101Pushlet;
import com.deliverik.infogovernor.nms.form.IGNMS0101Form;

/**
 * ����: �Զ�����Action
 * ��������: �Զ�����Action
 * ������¼: 2013/12/20
 * �޸ļ�¼:
 */
public class IGNMS0101Action extends BaseAction {
    static Log log = LogFactory.getLog(IGNMS0101Action.class);

    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		IGNMS0101Form form = (IGNMS0101Form) actionForm;
        IGNMS01BL ctlBL = (IGNMS01BL) getBean("ignms01BL");
        IGNMS01DTO dto = new IGNMS01DTO();
        User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
        if(form.getGid() == null || form.getGid() == 0) {
        	form.setGid(NMSBaseBLImpl.GROUPID_DEFAULT);//Ĭ����ID
        }
        dto.setGroupId(form.getGid());
        dto.setShowType(form.getShowtype());
        String parameter = mapping.getParameter();
        if("DISP".equals(parameter)){
            log.debug("=========== ��ʾ���˿�ʼ ==========");
            //��汾
            form.setGversion(ctlBL.searchGroupVersionAction(dto).getGroupVersion());
            log.debug("=========== ��ʾ���˿�ʼ ==========");
        } if("ManualScan".equals(parameter)){
            log.debug("=========== ��������ɨ�迪ʼ ==========");
            PrintWriter out = null;
            int flag = 0;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                flag = ctlBL.execCommandAction(dto).getFlag();
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
            	if(flag == 1) {
            		out.print("ɨ����������ɹ���");
            	} else if(flag == -1) {
            		out.print("ɨ�����ִ���ļ������ڣ�");
            	} else {
            		out.print("ɨ���������ʧ�ܣ�");
            	}
                if (out != null)
                    out.close();
            }
            log.debug("=========== ��������ɨ����� ==========");
            return null;
        } else if ("GET_TOPOXML".equals(parameter)) {
            log.debug("=========== ��ʾ���˿�ʼ ==========");
            Integer gversion_int = form.getGversion();
            String topotype = form.getTopotype();
            PrintWriter out = null;
            try {
                dto.setGroupVersion(gversion_int);
                dto.setTopoType(topotype);
            	// ��ʾ����
            	dto.setUserid(user.getUserid());
            	dto = ctlBL.searchTopoXML(dto);
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                out.print(dto.getXml());
            } catch (Exception e) {
            	if (out != null)
            		out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("=========== ��ʾ���˽��� ==========");
            return null;
        } else if ("SAVE".equals(parameter)) {
            PrintWriter out = null;
            try {
                // ��ʾ����
                ctlBL.saveTopoXML(dto);
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                out.print("��������ͼ�ɹ�");
            } catch (Exception e) {
                if (out != null)
                    out.print("��������ͼʧ��");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            return null;
        }
        // ��������
        else if ("UPDATE_AIXS".equals(parameter)) {
            log.debug("=========== ���������豸���꿪ʼ ==========");
            Integer gversion_int = form.getGversion();
            String topotype = form.getTopotype();
            String updateDevice = form.getUpdateDevice();
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                // ��ʾ����
                dto.setGroupVersion(gversion_int);
                dto.setTopoType(topotype);
                dto.setUserid(user.getUserid());
                dto.setUpdateDevice(updateDevice);
                dto.setAddDevice(form.getAddDevice());
                dto.setDelDevice(form.getDelDevice());
                dto.setAddRela(form.getAddRela());
                dto.setDelRela(form.getDelRela());
                dto.setRenameDevice(form.getRenameDevice());
                dto.setSubNetRegion(form.getRegionStr());
                dto.setUpdateRegionStr(form.getUpdateRegionStr());
                dto.setDelRegionStr(form.getDelRegionStr());
                dto = ctlBL.saveTopoInfo(dto);
//                out.print(dto.getXml());
                out.print("��������ͼ�ɹ���");
            } catch (Exception e) {
                if (out != null) {
                    out.print("��������ͼʧ�ܣ�");
                }
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("=========== ���������豸������� ==========");
            return null;

        }
        // ��ȡ����С
        else if ("GET_PANELSIZE".equals(parameter)) {
            log.debug("=========== ��ȡ����С��ʼ ==========");
            Integer gversion_int = form.getGversion();
            String topotype = form.getTopotype();
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                // ��ʾ����
                dto.setGroupVersion(gversion_int);
                dto.setTopoType(topotype);
                dto.setUserid(user.getUserid());
                dto = ctlBL.getPanelSize(dto);
                out.print(dto.getPanelSizeInfoXml());
            } catch (Exception e) {
                out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("=========== ��ȡ����С���� ==========");
            return null;
        }
        // �������
        else if ("UPDATE_PANELSIZE".equals(parameter)) {
            log.debug("=========== ��������С��ʼ ==========");
            Integer gversion_int = form.getGversion();
            String topotype = form.getTopotype();
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                // ��ʾ����
                dto.setGroupVersion(gversion_int);
                dto.setTopoType(topotype);
                dto.setUserid(user.getUserid());
                dto.setPanelSize(form.getPanelSize());
                dto = ctlBL.updatePanelSize(dto);
                out.print("��������С�ɹ�");
            } catch (Exception e) {
                out.print("��������Сʧ�ܣ�");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("=========== ��������С���� ==========");
            return null;
            
        }

        return mapping.findForward("DISP");
    }

}
