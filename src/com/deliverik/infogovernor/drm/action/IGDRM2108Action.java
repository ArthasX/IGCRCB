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
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.IGDRM21BL;
import com.deliverik.infogovernor.drm.dto.IGDRM21DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2108Form;

/**
 * Ԥ���鿴�͵���Action
 * 
 * @author zhangjian
 *
 */
public class IGDRM2108Action extends BaseAction {
	
	private static Log log = LogFactory.getLog(IGDRM2108Action.class);
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm aform,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		// FORMȡ��
		IGDRM2108Form form = (IGDRM2108Form) aform;
		// BLȡ��
		IGDRM21BL ctlBL = (IGDRM21BL) getBean("igdrm21BL");

		// DTO����
		IGDRM21DTO dto = new IGDRM21DTO();
		
		dto.setForm(form);
		
		if ("AJAX".equals(mapping.getParameter())) {

			log.info("===========ajax��ѯԤ��Ŀ¼���ݿ�ʼ=============");
			res.setCharacterEncoding("UTF-8");

			res.setContentType("text/html; charset=utf-8");

			PrintWriter writer = res.getWriter();

			try {

				if (IGDRMCONSTANTS.PLAN_DIR_TYPE_TEXT.equals(form.getCtype())) {
					// ����Ǹ��ı�����ֱ�Ӳ�ѯ���ݿ�

					dto = ctlBL.loadPlanTextContent(dto);

					if (dto.getSoc0507Info() != null) {
						dto.setResultHTML(dto.getSoc0507Info().getCivalue());
					}


				} else if (IGDRMCONSTANTS.PLAN_DIR_TYPE_SCENE.equals(form.getCtype())) {
					// ����

					dto = ctlBL.loadPlanScenceHtml(dto);

				} else if (IGDRMCONSTANTS.PLAN_DIR_TYPE_RESOURCE.equals(form.getCtype())) {
					// Ӧ����Դ

				} else if (IGDRMCONSTANTS.PLAN_DIR_TYPE_ORG.equals(form.getCtype())) {
					// ��֯�ܹ�

					ctlBL.loadPlanOrgHTML(dto);
				}

				writer.write(dto.getResultHTML() == null ? "" : dto.getResultHTML());

			} catch (Exception e) {
				writer.write("������Ϣ����!");
				e.printStackTrace();
			}

			log.info("===========ajax��ѯԤ��Ŀ¼�������=============");

			return null;

		}

		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		
		return mapping.findForward("DISP");
	}

}
