/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dbm.action;

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
import com.deliverik.infogovernor.dbm.bl.IGDBM12BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM12DTO;

/**
 * @���� ��Ϣ��ȫ�ۺ��Է���DashBoard
 * @�������� ��Ϣ��ȫ�ۺ��Է���DashBoard 
 * @������¼ �ﶫ��  2014/07/17
 * @version 1.0
 */
public class IGDBM1203Action extends BaseAction{
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//��־����
		Log log = LogFactory.getLog(IGDBM1203Action.class);
		//BLȡ��
		IGDBM12BL ctlBL = (IGDBM12BL) getBean("igdbm12BL");
		//ʵ����dto
		IGDBM12DTO dto=new IGDBM12DTO();
		//dto����ȡ��
		dto.setForm(actionForm);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("========��Ϣ��ȫ�ۺϷ������������ʾ����ʼ========");
			
			log.debug("========��Ϣ��ȫ�ۺϷ������������ʾ�������========");
			return mapping.findForward("DISP");
		}
		if("rcclass".equals(mapping.getParameter())){
			log.debug("===========���������ͳ������ȡ�ò�����ʼ===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRcclass(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========���������ͳ������ȡ�ò�����ʼ===========");
		}
		if("rcclassbymonth".equals(mapping.getParameter())){
			log.debug("=================�������⼰����ռ������ȡ�ò�����ʼ==============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRcclassByMonth(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("=================�������⼰����ռ������ȡ�ò�������==============");
			
		}
		
		if("rctestmode".equals(mapping.getParameter())){
			log.debug("=============��ȹ�����������ȡ�ò�����ʼ=============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRcTestMode(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("=============��ȹ�����������ȡ�ò�������=============");
		}
		if("riskcheckresult".equals(mapping.getParameter())){
			log.debug("============��Ϣ��ȫ����������������ȡ�ò�����ʼ============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRiskCheckResult(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("============��Ϣ��ȫ����������������ȡ�ò�������============");
		}
		
		if("questions".equals(mapping.getParameter())){
			log.debug("===========���⼰�����������ȡ�ò�����ʼ=============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getQuestions(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========���⼰�����������ȡ�ò�������=============");
		}
		
		return null;
	}

}
