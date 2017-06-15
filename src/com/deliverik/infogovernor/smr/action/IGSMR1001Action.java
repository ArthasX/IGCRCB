/**
 * 
 */
package com.deliverik.infogovernor.smr.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.google.gson.Gson;

/**
 * @author Administrator
 * 
 */
public class IGSMR1001Action extends BaseAction {
	private static String  FIRSTQUARTER = "一季度（2014-T-Q-01 电子银行业务统计表）";
	private static String  SECONDQUARTER = "二季度（2014-T-Q-01 电子银行业务统计表）";
	private static String  THIRDQUARTER = "三季度（2014-T-Q-01 电子银行业务统计表）";
	private static String  FOURTHQUARTER = "四季度（2014-T-Q-01 电子银行业务统计表）";
	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 日志对象取得
		Log log = LogFactory.getLog(IGSMR1001Action.class);
		// 通过当前的流程查找上一期的流程
		IG500BL ig500BL = (IG500BL) WebApplicationSupport.getBean("ig500BL");
		IG898BL ig898BL = (IG898BL) WebApplicationSupport.getBean("ig898BL");
		IG500SearchCondImpl ig500Cond = new IG500SearchCondImpl();
		IG898SearchCondImpl ig898Cond = new IG898SearchCondImpl();
		//获取当前流程的prid
		String requestPrid = request.getParameter("prid");
		Integer behindPrid = Integer.parseInt(requestPrid);
		log.debug("==============查询当前TQ1流程开始=================");
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(behindPrid);
		log.debug("==============查询当前TQ1流程结束=================");
		if (ig500Info != null) {
			// 获取当期流程的名称
			String[] prtitle = ig500Info.getPrtitle().split("_");
			String year = prtitle[0];
			String quater = prtitle[1].split("（")[0];
			Integer prid = 0;
			ig500Cond = new IG500SearchCondImpl();
			// 判断是哪个季度，如果是第一季度则取前一年的第四季度
			if ("一季度".equals(quater)) {
				Integer preYear = Integer.parseInt(year) - 1;
				ig500Cond.setPrtitle(preYear + "_" + FOURTHQUARTER);
			} else if ("二季度".equals(quater)) {
				ig500Cond.setPrtitle(year + "_" + FIRSTQUARTER);
			} else if ("三季度".equals(quater)) {
				ig500Cond.setPrtitle(year + "_" + SECONDQUARTER);
			} else {
				ig500Cond.setPrtitle(year + "_" + THIRDQUARTER);
			}
			ig500Cond.setPrstatus("C");
			log.debug("==============查询上期TQ1流程开始=================");
			// 获取上一期的流程prid
			List<IG500Info> ig500List = ig500BL.searchIG500Info(ig500Cond);
			if (ig500List != null && ig500List.size() > 0) {
				prid = ig500List.get(0).getPrid();
			}
			ig898Cond.setPvcolname("数量");
			List<IG898Info> ig898List = null;
			if (prid != 0) {
				ig898Cond.setPrid(prid);
				ig898List = ig898BL.searchIG898(ig898Cond);
			}
			
			Map<String,String> ig898Map = new HashMap<String,String>();
			PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
			if (ig898List != null && ig898List.size() > 0) {
				for(int i = 0;i<ig898List.size();i++){
					IG898Info ig898Info = ig898List.get(i);
					ig898Map.put(ig898Info.getPvcolpidid()+"_"+ig898Info.getPvrownumber(), ig898Info.getPvalue());
				}
			}
			log.debug("==============查询上期TQ1流程结束=================");
			try{
				Gson gson = new Gson();
				String jsonStr = gson.toJson(ig898Map);
				out.print(jsonStr);
			} catch (Exception e) {
				log.error("Ajax SEND Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
		}
		return null;
	}

}
