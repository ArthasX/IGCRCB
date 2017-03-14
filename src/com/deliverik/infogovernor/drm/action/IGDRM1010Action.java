/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.action;

import java.io.PrintWriter;
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
import com.deliverik.infogovernor.drm.bl.IGDRM10BL;
import com.deliverik.infogovernor.drm.dto.IGDRM10DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1010Form;
import com.deliverik.infogovernor.drm.vo.IGDRM10101VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: Ӧ������̨Action
 * </p>
 * 
 * @author zhangjian@deliverik.com
 */

public class IGDRM1010Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1010Action.class);

	/**
	 * Ӧ������̨Action����
	 *
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//BLȡ��
		IGDRM10BL ctlBL = (IGDRM10BL) getBean("igdrm10BL");
		
		//DTO����
		IGDRM10DTO dto = new IGDRM10DTO();
		
		//��¼�û�ȡ��
		User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		//dto�����趨
		dto.setForm(actionForm);
		dto.setUser(user);
		
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		if( "DISP".equals(mapping.getParameter())){
			// Ӧ������̨���������ʾ����
			log.debug("========Ӧ������̨���������ʾ����ʼ========");
			dto = ctlBL.initWorkbenchAction(dto);
			IGDRM10101VO vo = new IGDRM10101VO();
			vo.setWorkbenchMap(dto.getWorkbenchMap());
			setVO(req, vo);
			log.debug("========Ӧ������̨���������ʾ��������========");
		} else if ("AJAX".equals(mapping.getParameter())) {
			try {
				dto = ctlBL.initWorkFlowAction(dto);
				out.print(dto.getJsonResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			return null;
		}else if("COMMIT".equals(mapping.getParameter())){
			log.info("===========�ύ������ʼ============");
			try { 

				dto = ctlBL.doFlowAction(dto);
				out.print("success");
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.info("===========�ύ��������============");
			return null;
		} else if ("SMS".equals(mapping.getParameter())) {

			log.debug("===========���Ͷ��ſ�ʼ============");
			try {
				ctlBL.sendSMS(dto);
				out.print("{\"msg\":\"success\"}");
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}

			log.debug("===========���Ͷ��Ž���============");
			return null;

		} else if ("NOTICE".equals(mapping.getParameter())) {
			log.debug("===========����֪ͨ��ʼ============");
			try {
				IGDRM1010Form form = (IGDRM1010Form) actionForm;
				form.setSendUserid(user.getUserid());
				form.setSendUserName(user.getUsername());

				dto.setForm(form);

				ctlBL.sendNotice(dto);
				out.print("{\"msg\":\"success\"}");
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}

			log.debug("===========����֪ͨ����============");
			return null;
		} else if ("LOG".equals(mapping.getParameter())) {
			log.debug("==============��ѯ��־��ʼ==================");
			try {
				ctlBL.searchLog(dto);
				out.print(dto.getJsonResult());
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}

			log.debug("==============��ѯ��־���==================");
			return null;
		} else if ("UPLOAD".equals(mapping.getParameter())) {
			log.info("============�����ϴ���ʼ===============");
			try {
				ctlBL.uploadAtt(dto);
				out.print(dto.getJsonResult());
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.info("============�����ϴ����===============");
			return null;
		} else if ("TIMES".equals(mapping.getParameter())) {
			log.info("=========��ѯ����Ԥ�ƻָ�ʱ����ʼ==========");
			try {
				ctlBL.searchSenceTimes(dto);
				out.print(dto.getJsonResult());
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.info("=========��ѯ����Ԥ�ƻָ�ʱ�����==========");
			return null;
		} else if ("GETDESC".equals(mapping.getParameter())) {
			log.info("=========��ѯ���ڵ㴦��˵����ʼ==========");
			try {
				ctlBL.searchDesc(dto);
				out.print(dto.getJsonResult());
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.info("=========��ѯ���ڵ㴦��˵�����==========");
			return null;
		} else if ("SAVEDESC".equals(mapping.getParameter())) {
			log.info("=========���浥�ڵ㴦��˵����ʼ==========");
			try {
				ctlBL.saveDesc(dto);
				out.print(dto.getJsonResult());
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.info("=========���浥�ڵ㴦��˵�����==========");
			return null;
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
