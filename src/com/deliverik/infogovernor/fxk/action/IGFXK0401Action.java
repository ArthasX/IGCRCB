/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.action;

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
import com.deliverik.infogovernor.fxk.bl.IGFXK04BL;
import com.deliverik.infogovernor.fxk.dto.IGFXK04DTO;
import com.deliverik.infogovernor.fxk.vo.IGFXK04011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ģ������ѯAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGFXK0401Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGFXK0401Action.class);
		//BLȡ��
		IGFXK04BL ctlBL = (IGFXK04BL) getBean("igfxk04BL");
		//ʵ����dto
		IGFXK04DTO dto = new IGFXK04DTO();
		//dto�����趨
		dto.setForm(actionForm);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("============ģ������ʾ������ʼ===========");
			dto = ctlBL.searchAsmModelTree(dto);
			//ʵ����vo
			IGFXK04011VO vo = new IGFXK04011VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGFXK04011VO>setVO(request, vo);
			log.debug("============ģ������ʾ��������===========");
		}
		if ("ZTREE".equals(mapping.getParameter())){
            //start================================>SYS0103
			log.debug("============ģ������ʾ������ʼ===========");
            String json = "";
            json = ctlBL.searchAsmModelZTree(dto);
            IGFXK04011VO vo = new IGFXK04011VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGFXK04011VO>setVO(request, vo);
            vo.setTreejson(json);
            log.debug("============ģ������ʾ��������===========");
        } 
		
		//��ȡ���յ�
		if("GETASM013".equals(mapping.getParameter())){
			log.debug("============��ȡ���յ������ʼ=============");
			dto = ctlBL.searchAsm013Action(dto);
			PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                out.print(dto.getAjaxResult());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			log.debug("============��ȡ���յ��������=============");
			return null;
		}
		//��ȡ�����
		if("GETASM014".equals(mapping.getParameter())){
			log.debug("============��ȡ����������ʼ=============");
			dto = ctlBL.searchAsm014Action(dto);
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null){
					out.close();
				}
			}
			log.debug("============��ȡ������������=============");
			return null;
		}
		//��ط����嵥��ѯ
		if("GETRELATIONPROCESS".equals(mapping.getParameter())){
			log.debug("===============���������嵥��ѯ������ʼ==============");
			dto = ctlBL.getRelationProcess(dto);
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null){
					out.close();
				}
			}
			log.debug("===============���������嵥��ѯ��������==============");
		}
		return mapping.findForward("DISP");
	}

}
