/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR30BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR30DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR3003Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR30031VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�Զ����������ʾAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR3003Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGVIR3003Action.class);
		//BLȡ��
		IGVIR30BL ctlBL = (IGVIR30BL) getBean("igvir30BL");
		//ʵ����dto
		IGVIR30DTO dto = new IGVIR30DTO();
		//formȡ��
		IGVIR3003Form form = (IGVIR3003Form) actionForm;
		//��½�û�ȡ��
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto�����趨
		dto.setIgvir3003Form(form);
		dto.setUser(user);
		//�Զ��������ҳ����ʾ
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========�Զ��������ҳ���ʼ��������ʼ============");
			dto = ctlBL.getApplyVMListAction(dto);
			//ʵ����vo
			IGVIR30031VO vo = new IGVIR30031VO();
			vo.setVcd03List(dto.getVcd03List());
			vo.setPid(dto.getPid());
			super.<IGVIR30031VO>setVO(request, vo);
			log.debug("===========�Զ��������ҳ���ʼ����������============");
		}
		//�Զ��������
		if("GETPROGRESS".equals(mapping.getParameter())){
			log.debug("========�Զ�����������ݲ�ѯ������ʼ=======");
			PrintWriter out = null;
            try {
            	out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
	        	dto = ctlBL.getApplyVMDataListAction(dto);
	        	out.print(dto.getJsonResult());
            } catch (Exception e) {
                out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
			log.debug("========�Զ�����������ݲ�ѯ��������=======");
		}
		return mapping.findForward("DISP");
	}

}
