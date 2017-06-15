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
	private static String  FIRSTQUARTER = "һ���ȣ�2014-T-Q-01 ��������ҵ��ͳ�Ʊ�";
	private static String  SECONDQUARTER = "�����ȣ�2014-T-Q-01 ��������ҵ��ͳ�Ʊ�";
	private static String  THIRDQUARTER = "�����ȣ�2014-T-Q-01 ��������ҵ��ͳ�Ʊ�";
	private static String  FOURTHQUARTER = "�ļ��ȣ�2014-T-Q-01 ��������ҵ��ͳ�Ʊ�";
	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ��־����ȡ��
		Log log = LogFactory.getLog(IGSMR1001Action.class);
		// ͨ����ǰ�����̲�����һ�ڵ�����
		IG500BL ig500BL = (IG500BL) WebApplicationSupport.getBean("ig500BL");
		IG898BL ig898BL = (IG898BL) WebApplicationSupport.getBean("ig898BL");
		IG500SearchCondImpl ig500Cond = new IG500SearchCondImpl();
		IG898SearchCondImpl ig898Cond = new IG898SearchCondImpl();
		//��ȡ��ǰ���̵�prid
		String requestPrid = request.getParameter("prid");
		Integer behindPrid = Integer.parseInt(requestPrid);
		log.debug("==============��ѯ��ǰTQ1���̿�ʼ=================");
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(behindPrid);
		log.debug("==============��ѯ��ǰTQ1���̽���=================");
		if (ig500Info != null) {
			// ��ȡ�������̵�����
			String[] prtitle = ig500Info.getPrtitle().split("_");
			String year = prtitle[0];
			String quater = prtitle[1].split("��")[0];
			Integer prid = 0;
			ig500Cond = new IG500SearchCondImpl();
			// �ж����ĸ����ȣ�����ǵ�һ������ȡǰһ��ĵ��ļ���
			if ("һ����".equals(quater)) {
				Integer preYear = Integer.parseInt(year) - 1;
				ig500Cond.setPrtitle(preYear + "_" + FOURTHQUARTER);
			} else if ("������".equals(quater)) {
				ig500Cond.setPrtitle(year + "_" + FIRSTQUARTER);
			} else if ("������".equals(quater)) {
				ig500Cond.setPrtitle(year + "_" + SECONDQUARTER);
			} else {
				ig500Cond.setPrtitle(year + "_" + THIRDQUARTER);
			}
			ig500Cond.setPrstatus("C");
			log.debug("==============��ѯ����TQ1���̿�ʼ=================");
			// ��ȡ��һ�ڵ�����prid
			List<IG500Info> ig500List = ig500BL.searchIG500Info(ig500Cond);
			if (ig500List != null && ig500List.size() > 0) {
				prid = ig500List.get(0).getPrid();
			}
			ig898Cond.setPvcolname("����");
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
			log.debug("==============��ѯ����TQ1���̽���=================");
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
