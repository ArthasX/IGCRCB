package com.deliverik.infogovernor.drm.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.workflow.prd.bl.task.IG731BL;
import com.deliverik.infogovernor.drm.bl.IGDRM01BL;
import com.deliverik.infogovernor.drm.dto.IGDRM01DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0108Form;
import com.deliverik.infogovernor.drm.vo.IGDRM01081VO;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * 应急场景管理查看
 * 
 * @author zhangbo
 * 
 *
 */
public class IGDRM1103Action  extends BaseAction {
	 static Log log = LogFactory.getLog(IGDRM1103Action.class);
	 /**
		 * 应急制度分类管理Action处理
		 *
		 * @param mapping
		 * @param actionForm
		 * @param req
		 * @param res
		 * @return
		 * @throws Exception
		 */
	    @Override
		public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

			IGDRM01BL ctlBL = (IGDRM01BL) getBean("igdrm01BL");
			IGDRM0108Form form = (IGDRM0108Form) actionForm;
			IGDRM01DTO dto = new IGDRM01DTO();
			if ("DISP".equals(mapping.getParameter())) {
				//流程prid
				form.setPrid(Integer.parseInt(req.getParameter("prid")));
				//流程类型
				String flowType = req.getParameter("flowType");
				if("em".equals(flowType)){
					flowType = "应急场景";
				}else if("yl".equals(flowType)){
					flowType = "演练场景";
				}
				form.setFlowType(flowType);
				dto.setIgdrm0108Form(form);
				log.info("============应急场景详细信息查看开始==============");
				ctlBL.getSceneByEiid(dto);
				ctlBL.getScene(dto);
				IGDRM01081VO vo = new IGDRM01081VO();
				vo.setPlanInfo(dto.getPlanInfo());
				vo.setZyList(dto.getZyList());
				vo.setExpectTime(dto.getMaxTime());
				super.<IGDRM01081VO> setVO(req, vo);

				log.info("============应急场景详细信息查看完成==============");
			}else if ("DETAIL".equals(mapping.getParameter())) {

				dto.setPdid(req.getParameter("pdid"));
				Integer prid = Integer.parseInt(req.getParameter("prid"));
				PrintWriter out = null;
				try {
					out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
					dto = ctlBL.searchExportFlowDetail(dto,prid);
					out.print(dto.getOutPrintStr());
				} catch (Exception e) {
					out.print("获取场景信息出错!");
					log.error("AjaxAction Exception", e);
				} finally {
					if (out != null)
						out.close();
				}
				return null;
			}else if("EXPORT".equals(mapping.getParameter())){
				log.info("=============导出场景详细信息开始===============");
				Integer prid = Integer.parseInt(req.getParameter("prid"));
				dto.setPdid(req.getParameter("pdid"));
				form.setEiid(req.getParameter("eiid"));
				dto.setIgdrm0108Form(form);
				ctlBL.getScene(dto);
				dto = ctlBL.searchExportFlowDetail(dto,prid);
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				String nowDateStr = format.format(new Date());
				res.reset();// 清空输出流
				res.setHeader("Content-disposition", "attachment; filename=" + new String((dto.getPlanInfo().getScename()+"场景详细信息"+nowDateStr).getBytes("gb2312"), "8859_1") + ".xls");// 设定输出文件头
				res.setContentType("application/msexcel");
				dto.setOps(res.getOutputStream());
				ctlBL.exportSenceDetail(dto,prid);
				log.info("=============导出场景详细信息完成===============");
				return null;
			}
			
	        return mapping.findForward("DISP");
			
		}
}
