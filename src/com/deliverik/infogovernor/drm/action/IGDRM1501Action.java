/*
\ * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.drm.bl.IGDRM15BL;
import com.deliverik.infogovernor.drm.dto.IGDRM15DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1501Form;
import com.deliverik.infogovernor.drm.vo.IGDRM15011VO;




/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:培训计划查询Action
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1501Action extends BaseAction {

	

	/**
	 * 
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param res
	 * @return
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			//日志对象取得 
			Log log = LogFactory.getLog(IGDRM1501Action.class);
				
			//BL取得
			IGDRM15BL ctlBL = (IGDRM15BL) getBean("igdrm15BL");
				
			//实例化DTO
			IGDRM15DTO dto = new IGDRM15DTO();
				
			//form取得 
		   	IGDRM1501Form form = (IGDRM1501Form)actionForm;
		   		
		   	//dto参数设定 
		   	dto.setIgdrm1501Form(form);
		   	if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())) {
		   		log.debug("========用户查询处理开始========");
				//获取分页Bean
				getPaginDTO(request,"IGDRM1501");
				PagingDTO pDto;
				pDto = (PagingDTO)request.getAttribute("PagingDTO");
				if ("SEARCH1".equals(mapping.getParameter())){
					//由详细画面，编辑画面返回查询画面时的再检索处理
					form = (IGDRM1501Form) request.getSession().getAttribute("IGDRM1501Form");
					if (form == null) {
						form = new IGDRM1501Form();
					} else {
						if (request.getParameter("PAGING") == null) {
							pDto.setFromCount(form.getFromCount());
						} else {
							form.setFromCount(pDto.getFromCount());
						}
					}
				} else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(0);
						form = (IGDRM1501Form) request.getSession().getAttribute("IGDRM1501Form");
						if (form !=null) {
							form.setFromCount(0);
						}
					}
				}
				int maxCnt = getMaxDataCount("IGDRM1501");
				dto.setMaxSearchCount(maxCnt);
				dto.setPagingDto(pDto);
				dto = ctlBL.searchTrainplanList(dto);
				IGDRM15011VO vo = new IGDRM15011VO();
				vo.setTrainplanInfoList(dto.getTrainplanInfoList());
				super.<IGDRM15011VO>setVO(request, vo);
				log.debug("========用户查询处理终了========");
		   	}else if("SEARCH_DETAIL".equals(mapping.getParameter())){
		   		log.debug("========培训计划、培训任务更新取值处理开始========");
				dto = ctlBL.searchTrainPlanMissionAction(dto);
				// 将查到的结果放到vo
				IGDRM15011VO vo = new IGDRM15011VO();
				vo.setTrainmissionInfoList(dto.getTrainmissionInfoList());
				vo.setTrainplanInfo(dto.getTrainplanInfo());
				vo.setResultList(dto.getResultList());
				super.setVO(request, vo);
				log.debug("========培训计划、培训任务更新取值处理结束========");
		   	}
		   	return mapping.findForward("DISP");
	}
}
