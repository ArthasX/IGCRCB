/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.action;

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
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.fxk.form.IGFXK0601Form;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������Ĺ����ʲ���Ϣȡ��Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGFXK0601Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGFXK0601Action.class);
		//ȡ���ʲ�BL
		SOC0118BL ctlBL = (SOC0118BL) getBean("soc0118BL");
		//formȡ��
		IGFXK0601Form form = (IGFXK0601Form) actionForm;
		//ȡ�÷����¼���Ϣ
		if("GETENTITYINFO".equals(mapping.getParameter())){
			log.debug("===============�����¼�ȡ�ò�����ʼ================");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				SOC0118Info info = ctlBL.searchEntityItemByKey(form.getEiid());
				if(info != null){
					Gson gson = new Gson();
					out.print(gson.toJson(info));
				}
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===============�����¼�ȡ�ò�������================");
		}
		return null;
	}

}
