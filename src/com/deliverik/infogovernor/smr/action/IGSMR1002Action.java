/**
 * 
 */
package com.deliverik.infogovernor.smr.action;

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
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.platform.WebApplicationSupport;

/**
 * @author Administrator
 *
 */
public class IGSMR1002Action extends BaseAction{
	// 日志对象取得
			Log log = LogFactory.getLog(IGSMR1002Action.class);
	/* (non-Javadoc)
	 * @see com.deliverik.framework.base.BaseAction#doProcess(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("==============删除监管报表流程附件开始=================");
		String attid = req.getParameter("attid");
		log.debug("==============删除监管报表的attid："+attid+"=================");
		AttachmentBL attachmentBL = (AttachmentBL) WebApplicationSupport.getBean("attachmentBL");
		AttachmentTB attachment = new AttachmentTB();
		attachment.setAttid(Integer.parseInt(attid));
		attachmentBL.deleteAttachment(attachment);
		log.debug("==============删除监管报表流程附件结束=================");
		PrintWriter out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
		try{
			out.print("success");
		} catch (Exception e) {
			log.error("监管报表流程附件Ajax SEND Exception", e);
		} finally {
			if (out != null)
				out.close();
		}
		return null;
	}

}
