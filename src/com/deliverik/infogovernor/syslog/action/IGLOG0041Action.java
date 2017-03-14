/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.syslog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.syslog.bl.IGLOG004BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0041DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0041Form;
import com.deliverik.infogovernor.syslog.vo.IGLOG0041VO;

/**
 * <p>
 * Title : InfoGovernor 日志规则模板管理
 * </p>
 * <p>
 * Description: 查询ACTION
 * </p>
 * 
 * @author wangrongguagn@deliverik.com
 * @version 1.0
 */

public class IGLOG0041Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOG0041Action.class);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param mapping
	 *            ActionMapping
	 * @param form
	 *            ActionForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//实例化DTO
		IGLOG0041DTO dto = new IGLOG0041DTO();
		
		//实例化form表单
		IGLOG0041Form form = (IGLOG0041Form) actionForm;
		
		//实例化ctrolBL
		IGLOG004BL ctlBL = (IGLOG004BL) getBean("iglog004BL");
		
		
		//管理查询页
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("====日志规则模板管理查询处理开始====");
			
			//将form存放在dto载体中
			dto.setIgLog0041Form(form);
			
			//分页用DTO取得
			getPaginDTO(request,"IGLOG0041");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//判断是否是第一页
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGLOG0041Form) request.getSession().getAttribute("IGLOG0041Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			
			//设置分页条数
			int maxCnt = getMaxDataCount("IGLOG0041");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			
			//按搜索条件查询规则模板
			dto = ctlBL.searchMss00004(dto);
			
			//实例化载体vo
			IGLOG0041VO vo = new IGLOG0041VO(dto.getMss00004InfoList());
			
			super.<IGLOG0041VO> setVO(request, vo);
			
			log.debug("====日志规则模板管理查询处理结束====");
		}
		
		if( "CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========改变规则模板状态开始========");
			//DTO输入参数设定
			dto.setIgLog0041Form(form);
			
			//更改模板状态
			dto = ctlBL.changeTempstate(dto);
			
			log.debug("========改变规则模板状态结束========");
		}

		return mapping.findForward("DISP");
	}

}
