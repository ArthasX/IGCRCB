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
import com.deliverik.infogovernor.drm.bl.IGDRM20BL;
import com.deliverik.infogovernor.drm.dto.IGDRM20DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2003Form;
import com.deliverik.infogovernor.drm.vo.IGDRM20042VO;
import com.google.gson.Gson;

/**
 * @Description:
 * @Author
 * @History
 * @History
 * @Version
 */
public class IGDRM2003Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM2003Action.class);

	/**
	 * 
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
		// FORMȡ��
		IGDRM2003Form form = (IGDRM2003Form) actionForm;

		// BLȡ��
		 IGDRM20BL ctlBL = (IGDRM20BL) getBean("igdrm20BL");

		// DTO����
		IGDRM20DTO dto = new IGDRM20DTO();
		
		dto.setForm(form);

		if ("DISP".equals(mapping.getParameter())) {
			// ����������Ϣ�Ǽǻ��������ʾ����
			log.debug("========����������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			form.setPcid(req.getParameter("pcid"));
			form.setEid(req.getParameter("eid"));
			
			ctlBL.initModelAction(dto);
			
			IGDRM20042VO vo = new IGDRM20042VO(dto);
			super.<IGDRM20042VO>setVO(req, vo);
			
			log.debug("========����������Ϣ�Ǽǻ��������ʾ��������========");
			saveToken(req);
		} else if("SORT_AJAX".equals(mapping.getParameter())){
			log.debug("========����ʼ========");
			try{
				dto = ctlBL.sortSoc0509Action(dto);
				success(res);
			}catch(Exception ex){
				failed(res);
				log.debug("===========�������==========");
			}
			log.debug("========�������========");
			return null;
		}
		if (null != form.getBtn_save()) {
			log.debug("========�����û���ӵĽڵ���Ϣ��ʼ========");
			ctlBL.insertSoc0509Info(dto);
			IGDRM20042VO vo = new IGDRM20042VO(dto);
			super.<IGDRM20042VO>setVO(req, vo);
			log.debug("========�����û���ӵĽڵ���Ϣ����========");
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

	/**
	 * ����ַ���success����ҳ�棬��ʶ�ɹ�
	 * @param res
	 */
	private void success(HttpServletResponse res){
		out("success", res);
	}
	
	/**
	 * ����ַ���failed����ҳ�棬��ʶʧ��
	 * @param res
	 */
	private void failed(HttpServletResponse res){
		out("failed", res);
	}
	
	/**
	 * ����ַ���ҳ��
	 * @param msg
	 * @param res
	 */
	private void out(String msg, HttpServletResponse res){
		try {
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
	        PrintWriter out = res.getWriter();
	        Gson gson = new Gson();
        	out.print(gson.toJson(msg));
        	out.flush();
        	out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
