/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.emo.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.emo.bl.IGEMO01BL;
import com.deliverik.infogovernor.emo.dto.IGEMO01DTO;
import com.deliverik.infogovernor.emo.vo.IGEMO0101VO;
import com.google.gson.Gson;



/**
 * oracle性能监控Action
 * 
 */
public class IGEMO0101Action extends BaseAction {
	static Log log = LogFactory.getLog(IGEMO0101Action.class);

	/**
	 * oracle性能监控
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// BL取得
		IGEMO01BL ctlBL = (IGEMO01BL) getBean("igemo01BL");
		String eiid = req.getParameter("eiid");
		if ("DISP".equals(mapping.getParameter())) {
            log.debug("========oracle性能监控数据获取开始========");
            try {
        		IGEMO01DTO dto1 = new IGEMO01DTO();
        		IGEMO01DTO dto2 = new IGEMO01DTO();
        		dto1.setEm_type("1");
        		dto2.setEm_type("2");
        		dto1.setEiid(eiid);
        		dto2.setEiid(eiid);
        		ctlBL.getEmData(dto1);
        		ctlBL.getEmData(dto2);
        		Map<String,Object> emData = new HashMap<String, Object>();
        		emData.put("emddata1", dto1.getEmData());
        		emData.put("emddata2", dto2.getEmData());
    			Gson gson = new Gson();
    			IGEMO0101VO vo = new IGEMO0101VO();
				String emddata1 = gson.toJson(dto1.getEmData());
				String emddata2 = gson.toJson(dto2.getEmData());
				vo.setInitSQLStr(emddata1);
				vo.setInitSessionStr(emddata2);
				super.<IGEMO0101VO>setVO(req, vo);
            } catch (Exception e) {
                log.error("oracle性能监控数据	 Exception", e);
            }
            log.debug("========oracle性能监控数据获取终了========");
		}
		return mapping.findForward("DISP");

	}
}
