/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;

/**
 * @Description: �ʲ��±�Ż�ȡ��ʽ
 * @Author       zhangqiang
 * @History      @2014-7-23�½� 
 * 			
 * @Version V1.0
 */
public class AjaxForEilabelAction extends BaseAction {
	
	/** Ajax����LOG */
	static Log log = LogFactory.getLog(AjaxForEilabelAction.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("===================�±�Ż�ȡ��ʽ��ʼ====================");
		//���ͷ
		String ecategorykey = req.getParameter("ecategorykey");
		PrintWriter out = null;
		try {
			out = new PrintWriter( new OutputStreamWriter(res.getOutputStream(), "utf-8"));
			SOC0118BL bl = (SOC0118BL) getBean("soc0118BL");
			SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
			// ����cond��������
			cond.setEilabel(ecategorykey );
			String ret = bl.searchNewNextEntityItemLable(cond);
			
			if(StringUtils.isEmpty(ret)) {
				ret = "";
			}
			
			log.debug("�ʲ����ࣺ" + ecategorykey + ",��ǰ���ñ��:" + ret);
//			System.out.println("�ʲ����ࣺ" + ecategorykey + ",��ǰ���ñ��:" + ret);
			
			out.print(ret);
		}catch (Exception e) {
			out.print("");
			log.error("AjaxForEilabelAction Exception", e);
		}finally{
			if(out != null)
				out.close();
		}

		log.debug("===================�±�Ż�ȡ��ʽ����====================");
		return null;
	}

}
