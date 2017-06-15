package com.deliverik.infogovernor.rdp.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.rdp.bl.IGRDP01BL;
import com.deliverik.infogovernor.rdp.dto.IGRDP01DTO;
import com.deliverik.infogovernor.rdp.form.IGRDP0102Form;
import com.deliverik.infogovernor.rdp.vo.IGRDP01021VO;

/**
 * 执行结果展示
 * @author Wang.xing
 * 2014.04.24
 */
public class IGRDP0102Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGRDP0102Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		IGRDP01BL ctlBL = (IGRDP01BL) getBean("igrdp01BL");
		IGRDP01DTO dto = new IGRDP01DTO();
		IGRDP0102Form igrdp0102Form = (IGRDP0102Form)form;
		
		String forward = "DISP";
		
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			
			dto = ctlBL.searchAllTasks(dto);
			request.getSession().setAttribute("tasks", dto.getTasks() );
			//分页用DTO取得
			getPaginDTO(request,"IGRDP0102");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//应用查询处理
			log.debug("========升级结果查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				igrdp0102Form = (IGRDP0102Form) request.getSession().getAttribute("IGRDP0102Form");
				if ( igrdp0102Form == null){
					igrdp0102Form = new IGRDP0102Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(igrdp0102Form.getFromCount());
					} else {
						igrdp0102Form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					igrdp0102Form = (IGRDP0102Form) request.getSession().getAttribute("IGRDP0102Form");
					if (igrdp0102Form !=null) {
						igrdp0102Form.setFromCount(0);
					}
				}
			}
			
			if("yes".equals(request.getParameter("isquery"))){
				igrdp0102Form.setIsquery("yes");
			}else{
				igrdp0102Form.setIsquery("");
			}
			
			int maxCnt = getMaxDataCount("IGRDP0102");
			
			String taskid = (String) request.getAttribute("taskid");
			if(StringUtils.isNotEmpty(taskid)){
				igrdp0102Form.setTaskid_eq(taskid);
			}
			taskid = request.getParameter("taskid");
			if(StringUtils.isNotEmpty(taskid)){
				igrdp0102Form.setTaskid_eq(taskid);
			}
			
			dto.setIgrdp0102Form(igrdp0102Form);
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto = ctlBL.getExcuteResultByTaskID(dto);
			IGRDP01021VO vo = new IGRDP01021VO();
			vo.setResults(dto.getResults());
			super.<IGRDP01021VO>setVO(request, vo);
			
			log.debug("========升级结果查询处理终了========");
		}else if("LOG".equals(mapping.getParameter())){
			log.debug("========显示程序日志处理开始========");
			
			String hostid = request.getParameter("hostid");
			
			String taskid = request.getParameter("taskid");
			
			String logFlag = request.getParameter("flag");
			
			dto.setLogFlag(logFlag);
			
			dto.setLogPath(hostid + "#" + taskid);
			
			dto = ctlBL.getLogByLogPath(dto);
			
			IGRDP01021VO vo = new IGRDP01021VO();
			
			vo.setLog(dto.getLog());
			super.<IGRDP01021VO>setVO(request, vo);
			
			log.debug("========显示程序日志处理终了========");
		}else if("SearchByAjax".equals(mapping.getParameter())){
			log.debug("========ajax升级结果查询处理开始========");
			PrintWriter out = null;
			try {
				out = new PrintWriter( new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				String taskid = request.getParameter("taskid");
				igrdp0102Form.setTaskid_eq(taskid);
				dto.setIgrdp0102Form(igrdp0102Form);
				dto = ctlBL.getExcuteResultByTaskIDByAjax(dto);
				out.print(dto.getResultsStr());
			} catch(Exception e){
				e.printStackTrace();
			} finally{
				out.flush();
				out.close();
			}
			
			log.debug("========ajax升级结果查询处理结束========");
			return null;
		}else if("SearchRealTimeDetail".equals(mapping.getParameter())){
			dto.setHostip(request.getParameter("hostip"));
			dto.setTaskID(Integer.valueOf(request.getParameter("taskid")));
			ctlBL.searchRealTimeDetail(dto);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(dto.getRealTimeDetailListJson());
			return null;
		}else if("Search1".equals(mapping.getParameter())){
			dto.setTaskID(Integer.valueOf(request.getParameter("taskid")));

			dto.setRtdId(StringUtils.isNotEmpty(request.getParameter("rtdid"))?Integer.valueOf(request.getParameter("rtdid")):null);
			ctlBL.searchLastRealTimeDetail(dto);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(dto.getRealTimeDetailListJson());
			return null;
		}
		
		return mapping.findForward(forward);
	}

}
