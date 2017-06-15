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
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Ƽ������ۺϷ�����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDBM1202Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGDBM1202Action.class);
		//BLȡ��
		IGDBM12BL ctlBL = (IGDBM12BL) getBean("igdbm12BL");
		//ʵ����dto
		IGDBM12DTO dto = new IGDBM12DTO();
		//dto�����趨
		dto.setForm(actionForm);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("=============�Ƽ������ۺϷ�����ҳ���ʼ��������ʼ===============");
			log.debug("=============�Ƽ������ۺϷ�����ҳ���ʼ����������===============");
			return mapping.findForward("DISP");
		}
		//�������������ռ��
		if("GETWORKORDER".equals(mapping.getParameter())){
			log.debug("================�������������ռ������ȡ�ò�����ʼ===============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.getWorkOrderAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("================�������������ռ������ȡ�ò�������===============");
		}
		//������ռ��
		if("CHANGERESULT".equals(mapping.getParameter())){
			log.debug("=============������ռ��ͳ������ȡ�ò�����ʼ==============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.getChangeResultAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("=============������ռ��ͳ������ȡ�ò�������==============");
		}
		
		//ʱ�����Ʒ���
		if("EVENTTREND".equals(mapping.getParameter())){
			log.debug("============ʱ�����Ʒ�������ȡ�ò�����ʼ============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.getEventTrendAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("============ʱ�����Ʒ�������ȡ�ò�������============");
		}
		
		//�����������Ա�
		if("QOTN".equals(mapping.getParameter())){
			log.debug("================������������������ȡ�ò�����ʼ==================");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.getQotnDataAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("================������������������ȡ�ò�������==================");
		}
		//����ƻ�
		if("SETCALENDAR".equals(mapping.getParameter())){
			log.debug("===============����ƻ�����ȡ�ò�����ʼ================");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.setChangePlan(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===============����ƻ�����ȡ�ò�������================");
		}
		return null;
	}

}
