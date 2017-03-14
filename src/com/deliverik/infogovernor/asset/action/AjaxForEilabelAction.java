/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * @Description: 资产新编号获取方式
 * @Author       zhangqiang
 * @History      @2014-7-23新建 
 * 			
 * @Version V1.0
 */
public class AjaxForEilabelAction extends BaseAction {
	
	/** Ajax处理LOG */
	static Log log = LogFactory.getLog(AjaxForEilabelAction.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("===================新编号获取方式开始====================");
		//编号头
		String ecategorykey = req.getParameter("ecategorykey");
		PrintWriter out = null;
		try {
			out = new PrintWriter( new OutputStreamWriter(res.getOutputStream(), "utf-8"));
			SOC0118BL bl = (SOC0118BL) getBean("soc0118BL");
			SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
			// 设置cond检索条件
			cond.setEilabel(ecategorykey );
			String ret = bl.searchNewNextEntityItemLable(cond);
			
			if(StringUtils.isEmpty(ret)) {
				ret = "";
			}
			
			log.debug("资产分类：" + ecategorykey + ",当前可用编号:" + ret);
//			System.out.println("资产分类：" + ecategorykey + ",当前可用编号:" + ret);
			
			out.print(ret);
		}catch (Exception e) {
			out.print("");
			log.error("AjaxForEilabelAction Exception", e);
		}finally{
			if(out != null)
				out.close();
		}

		log.debug("===================新编号获取方式结束====================");
		return null;
	}

}
