/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
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
 * �� ��: �Ƽ������ۺϷ���DashBoard ����Action ���������� 1.ҵ���źͿƼ����Ź������ 2.ҵ���źͿƼ����Ź��������Ա�
 * 3.�����Ŵ������������Ʒ���
 * 
 * ������¼�������� 2014/07/16
 * 
 */
public class IGDBM1201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM1201Action.class);

	/**
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		// ��ȡBL�ӿ�ʵ��
		IGDBM12BL ctlBL = (IGDBM12BL) getBean("igdbm12BL");
		// ʵ����DTO
		IGDBM12DTO dto = new IGDBM12DTO();
		dto.setForm(actionForm);
		// ������ת�趨
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========�Ƽ������ۺϷ������������ʾ����ʼ========");

			log.debug("========�Ƽ������ۺϷ������������ʾ��������========");
			return mapping.findForward("DISP");
		}
		if("ProcessCountYW".equals(mapping.getParameter())){
			log.debug("===========ҵ���Ź������ȡ�ò�����ʼ===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getPieValue(dto);
				out.print(dto.getProcessCountYW());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========ҵ���Ź������ȡ�ò�������===========");
		}
		if("ProcessCountKJ".equals(mapping.getParameter())){
			log.debug("===========�Ƽ����Ź������ȡ�ò�����ʼ===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getPieValue(dto);
				out.print(dto.getProcessCountKJ());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========�Ƽ����Ź������ȡ�ò�������===========");
		}
		if("businessdepart".equals(mapping.getParameter())){
			log.debug("===========ҵ���Ÿ��๤��ռ��ȡ�ò�����ʼ===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getBusinessDepart(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========ҵ���Ÿ��๤��ռ��ȡ�ò�������===========");
		}
		if("sciencedepart".equals(mapping.getParameter())){
			log.debug("===========�Ƽ����Ÿ��๤��ռ��ȡ�ò�����ʼ===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getScienceDepart(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========�Ƽ����Ÿ��๤��ռ��ȡ�ò�������===========");
		}
		if("Line".equals(mapping.getParameter())){
			log.debug("===========�����Ŵ������������Ʒ���������ʼ===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.setEventAvgCost(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========�����Ŵ������������Ʒ�����������===========");
		}
		return mapping.findForward(forward);
	}

}
