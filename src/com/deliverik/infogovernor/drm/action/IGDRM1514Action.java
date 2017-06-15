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
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.drm.bl.IGDRM15BL;
import com.deliverik.infogovernor.drm.dto.IGDRM15DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1501Form;
import com.deliverik.infogovernor.drm.form.IGDRM1514Form;
import com.deliverik.infogovernor.drm.vo.IGDRM15141VO;



/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:培训计划查询 弹出窗
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1514Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1514Action.class);

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
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse res) throws Exception {
		// 获得form
		IGDRM1514Form form = (IGDRM1514Form) actionForm;
		// BL取得
		IGDRM15BL ctlBL = (IGDRM15BL) getBean("igdrm15BL");
		// DTO生成
		IGDRM15DTO dto = new IGDRM15DTO();
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("==============培训计划查询开始=====================");
			//获取分页bean
			getPaginDTO(request,"IGDRM1514");
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("IGDRM1514");			
			//设置查询最大条数
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//条件查询
			
			IGDRM1501Form drm1501Form = new IGDRM1501Form();
			
			BeanUtils.copyProperties(form, drm1501Form);
			
			dto.setIgdrm1514Form(form);
			
			dto.setIgdrm1501Form(drm1501Form);
			//调用bl执行查询方法
			dto=ctlBL.searchTrainplanList(dto);
			//将查到的结果放到vo
			IGDRM15141VO vo = new IGDRM15141VO();
			vo.setTrainplanInfoList(dto.getTrainplanInfoList());
			super.<IGDRM15141VO>setVO(request, vo);
			log.debug("==============培训计划查询结束=====================");
		}
		
		
		return mapping.findForward("DISP");
	}
}
