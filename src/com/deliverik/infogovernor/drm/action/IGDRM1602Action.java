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
import com.deliverik.infogovernor.drm.bl.IGDRM16BL;
import com.deliverik.infogovernor.drm.dto.IGDRM16DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1602Form;
import com.deliverik.infogovernor.drm.vo.IGDRM16021VO;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1602Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1602Action.class);

	/**
	 * 
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse res) throws Exception {
		// 获得form
		IGDRM1602Form form = (IGDRM1602Form) actionForm;
		// BL取得
		IGDRM16BL ctlBL = (IGDRM16BL) getBean("igdrm16BL");
		// DTO生成
		IGDRM16DTO dto = new IGDRM16DTO();
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("==============事件查询开始=====================");
			//获取分页bean
			getPaginDTO(request,"IGDRM1602");
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("IGDRM1602");			
			//设置查询最大条数
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//条件查询
			dto.setIgdrm1602Form(form);
			//调用bl执行查询方法
			dto=ctlBL.getEventssList(dto);
			//将查到的结果放到vo
			IGDRM16021VO vo = new IGDRM16021VO();
			vo.setEventssInfoList(dto.getEventssInfoList());
			super.<IGDRM16021VO>setVO(request, vo);
			log.debug("==============事件查询结束=====================");
		}
		
		if( "DELETE".equals(mapping.getParameter())){
			log.debug("==============事件删除开始=====================");
			dto.setIgdrm1602Form(form);
			ctlBL.deleteEventssAction(dto);
			log.debug("==============事件删除结束=====================");
		}
		return mapping.findForward("DISP");
	}
}
