package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM01BL;
import com.deliverik.infogovernor.drm.dto.IGDRM01DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0108Form;
import com.deliverik.infogovernor.drm.vo.IGDRM01081VO;
import com.google.gson.Gson;

/**
 * Ӧ����������鿴
 * 
 * @author zhangjian
 * 
 *
 */
public class IGDRM0108Action extends BaseAction {

    static Log log = LogFactory.getLog(IGDRM0108Action.class);

    /**
	 * Ӧ���ƶȷ������Action����
	 *
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
    @Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		IGDRM01BL ctlBL = (IGDRM01BL) getBean("igdrm01BL");

		IGDRM0108Form form = (IGDRM0108Form) actionForm;

		IGDRM01DTO dto = new IGDRM01DTO();

		Gson g = new Gson();

		if ("DISP".equals(mapping.getParameter())) {
			log.info("============Ӧ��������ϸ��Ϣ�鿴��ʼ==============");

			dto.setIgdrm0108Form(form);

			ctlBL.getScene(dto);

			IGDRM01081VO vo = new IGDRM01081VO();

			vo.setPlanInfo(dto.getPlanInfo());

			vo.setZyList(dto.getZyList());
			vo.setExpectTime(dto.getMaxTime());
			super.<IGDRM01081VO> setVO(req, vo);

			log.info("============Ӧ��������ϸ��Ϣ�鿴���==============");
		} else if ("DETAIL".equals(mapping.getParameter())) {

			dto.setPdid(req.getParameter("pdid"));
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				dto = ctlBL.searchFlowDetail(dto);
				out.print(dto.getOutPrintStr());
			} catch (Exception e) {
				out.print("��ȡ������Ϣ����!");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			return null;
		}
        return mapping.findForward("DISP");
    }
}
