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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR02BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR02DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0202Form;

/**
 * ����: ��Դ����<br/> 
 * ��������: ���⻯������ʾAction<br/> 
 * ������¼: 2013/12/25<br/> 
 * �޸ļ�¼:<br/>
 */
public class IGVIR0202Action extends BaseAction {

    static Log log = LogFactory.getLog(IGVIR0202Action.class);

    /**
     * ���ð�����ϵ��ʾ����
     * 
     * @param mapping
     *            ActionMapping
     * @param actionForm
     *            ActionForm
     * @param req
     *            HttpServletRequest
     * @param res
     *            HttpServletResponse
     * @return ActionForward
     * @throws Exception
     */
    @Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
            HttpServletResponse res) throws Exception {
        // BLȡ��
        IGVIR02BL ctlBL = (IGVIR02BL) getBean("igvir02BL");

        IGVIR0202Form form = (IGVIR0202Form) actionForm;
        
        // DTO����
        IGVIR02DTO dto = new IGVIR02DTO();

        if ("GETVM".equals(mapping.getParameter())) {
            log.debug("======== ��Դ����������Ϣ��ѯ��ʼ========");
            dto.setPid(form.getPid());
            dto.setPrid(form.getPrid());
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                dto = ctlBL.getApplyVMInf(dto);
                out.print(dto.getVmInfo_json());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("======== ��Դ����������Ϣ��ѯ����========");
            return null;
        } 
        else if ("SAVEVM".equals(mapping.getParameter())) {
            log.debug("============= �������������Ϣ����ʼ ===========");
            dto.setIgvir0202Form(form);
            System.out.println(form);
            dto = ctlBL.saveVMInfo4Approve(dto);
//            PrintWriter out = null;
//            try {
//                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
//            } catch (Exception e) {
//                log.error("AjaxAction Exception", e);
//            } finally {
//                if (out != null){
//                    out.close();
//                }
//            }
            log.debug("============= �������������Ϣ������� ===========");
            return null;
        }
        // ����vCenter��ѯ�����б�
        else if ("GETHOSTLIST".equals(mapping.getParameter())) {
            log.debug("============= ����vCenter��ѯ�����б�ʼ ===========");
            dto.setVcid(form.getVcid());
            dto = ctlBL.searchHostByVcid(dto);
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(dto.getHostlist_json());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("============= ����vCenter��ѯ�����б���� ===========");
            return null;
        }
        // ��������IP��ѯ�����б�
        else if ("GETNETLIST".equals(mapping.getParameter())) {
            log.debug("============= ��������IP��ѯ�����б�ʼ ===========");
            dto.setVcid(form.getVcid());
            dto.setDcname(form.getDcname());
            dto = ctlBL.searchNetLabelByDatacenter(dto);
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(dto.getNetLabel_json());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("============= ��������IP��ѯ�����б���� ===========");
            return null;
        }
        // ��ѯ��������
        else if ("GETDATACENTER".equals(mapping.getParameter())) {
            log.debug("============= ����vCenter��ѯ���������б�ʼ ===========");
            dto.setVcid(form.getVcid());
            dto = ctlBL.searchDatacenterByVcid(dto);
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(dto.getDatacenter_json());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("============= ����vCenter��ѯ���������б���� ===========");
            return null;
        }
        // ��ѯ��Դ��
        else if ("GETRESOURCEPOOL".equals(mapping.getParameter())) {
            log.debug("============= ����vCenter��ѯ��Դ���б�ʼ ===========");
            dto.setVcid(form.getVcid());
            dto = ctlBL.searchResourcePoolByVcid(dto);
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(dto.getResourcePool_json());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("============= ����vCenter��ѯ��Դ���б���� ===========");
            return null;
        }
        // ��ѯ������־
        else if ("GETDEPLOYLOG".equals(mapping.getParameter())) {
            log.debug("============= ��ѯ������־�б�ʼ ===========");
            dto.setPid(form.getPid());
            dto = ctlBL.searchDeployLog(dto);
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(dto.getDeployLog_json());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("============= ��ѯ������־�б���� ===========");
            return null;
        }
        
        return mapping.findForward("DISP");
    }
}
