
package com.deliverik.infogovernor.drm.action;

import java.io.OutputStreamWriter;
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
import com.deliverik.infogovernor.drm.bl.IGDRM20BL;
import com.deliverik.infogovernor.drm.dto.IGDRM20DTO;
import com.deliverik.infogovernor.drm.vo.IGDRM20011VO;
import com.deliverik.infogovernor.drm.vo.IGDRM20021VO;
import com.google.gson.Gson;

/**
 * ���ͻ�����Ϣ�༭����Action����
 *
 */
public class IGDRM2002Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM2002Action.class);

	/**
	 * �¼�����
	 *
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		// BLȡ��
		IGDRM20BL ctlBL = (IGDRM20BL) getBean("igdrm20BL");

		// DTO����
		IGDRM20DTO dto = new IGDRM20DTO();

		// ������ת�趨
		String forward = null;
		IGDRM20011VO igdrm20011VO = (IGDRM20011VO) req.getSession().getAttribute("IGDRM20011VO");
		dto.setEntity(igdrm20011VO.getEntityData());
		if ("DISP".equals(mapping.getParameter())) {
			// ���͵Ǽǻ��������ʾ����
			log.debug("========���͵Ǽǻ��������ʾ����ʼ========");
			ctlBL.getPlanSectionTree(dto);
			Gson gson = new Gson();
			String json = gson.toJson(dto.getPlanSectionTree());
			IGDRM20021VO vo = new IGDRM20021VO();
			vo.setPlanSectionTreeJson(json);
			super.<IGDRM20021VO> setVO(req, vo);
			log.debug("========���͵Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if ("AJAXTREE".equals(mapping.getParameter())) {
			// ���͵Ǽǻ�������ʾ����
			log.debug("========���͵Ǽǻ�������ʾ����ʼ========");
			PrintWriter out =  new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
            try {
            	ctlBL.getPlanSectionTree(dto);
    			Gson gson = new Gson();
				gson.toJson(dto.getPlanSectionTree(), out);
            } catch (Exception e) {
                out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			log.debug("========���͵Ǽǻ�������ʾ��������========");
			return null;
		}
		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}

		return mapping.findForward(forward);
	}
}
