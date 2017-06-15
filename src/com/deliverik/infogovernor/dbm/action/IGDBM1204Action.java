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
public class IGDBM1204Action extends BaseAction{
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//��־����
		Log log = LogFactory.getLog(IGDBM1204Action.class);
		//BLȡ��
		IGDBM12BL ctlBL = (IGDBM12BL) getBean("igdbm12BL");
		//ʵ����dto
		IGDBM12DTO dto=new IGDBM12DTO();
		//dto����ȡ��
		dto.setForm(actionForm);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("========�Ƽ������ۺϷ��� ���������ʾ����ʼ========");
			
			log.debug("========�Ƽ������ۺϷ��� ���������ʾ�������========");
			return mapping.findForward("DISP");
		}
		if("getCounter".equals(mapping.getParameter())){
			log.debug("===========���ղ��Ź����������ȡ�ò�����ʼ===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getCounterValue(dto);
				out.print(dto.getRiskCounter());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========���ղ��Ź����������ȡ�ò�����ʼ===========");
		}
		if("getRiskCheck".equals(mapping.getParameter())){
			log.debug("===========����ȷ��չ��������������ȡ�ò�����ʼ===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRiskCheck(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========����ȷ��չ��������������ȡ�ò�����ʼ===========");
		}
		if("getRiskProblem".equals(mapping.getParameter())){
			log.debug("===========����ȷ������⼰����ռ�� ����ȡ�ò�����ʼ===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRiskProblem(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========����ȷ������⼰����ռ������ȡ�ò�����ʼ===========");
		}
		if("getRiskRepository".equals(mapping.getParameter())){
			log.debug("===========���տ�ֲ��������ȡ�ò�����ʼ===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRiskRepository(dto);
				out.print(dto.getAjaxResult());
				log.debug(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========���տ�ֲ��������ȡ�ò�������===========");
		}
		if("getRiskRectification".equals(mapping.getParameter())){
			log.debug("===========�������������������-��ͼ ����ȡ�ò�����ʼ===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRiskRectification(dto);
				out.print(dto.getAjaxResult());
				log.debug(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========�������������������-��ͼ ����ȡ�ò�������===========");
		}
		if("getRiskAssess".equals(mapping.getParameter())){
			log.debug("===========�������������������-��ͼ ����ȡ�ò�����ʼ===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRiskAssess(dto);
				out.print(dto.getAjaxResult());
				log.debug(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========�������������������-��ͼ ����ȡ�ò�������===========");
		}
		
		return null;
	}

}
