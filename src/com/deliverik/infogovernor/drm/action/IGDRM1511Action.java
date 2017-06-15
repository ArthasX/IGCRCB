/*
\ * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

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
 * Description:培训计划管理Action
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1511Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1511Action.class);

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
		IGDRM1501Form form = (IGDRM1501Form) actionForm;
		// BL取得
		IGDRM15BL ctlBL = (IGDRM15BL) getBean("igdrm15BL");
		// DTO生成
		IGDRM15DTO dto = new IGDRM15DTO();
		//条件查询
		dto.setIgdrm1501Form(form);
		  if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())) {
			log.debug("==============培训计划查询开始=====================");
			//获取分页bean
			getPaginDTO(request,"IGDRM1511");
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
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
			int maxCnt = getMaxDataCount("IGDRM1511");			
			//设置查询最大条数
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//调用bl执行查询方法
			dto=ctlBL.searchTrainplanList(dto);
			//将查到的结果放到vo
			IGDRM15011VO vo = new IGDRM15011VO();
			vo.setTrainplanInfoList(dto.getTrainplanInfoList());
			super.<IGDRM15011VO>setVO(request, vo);
			log.debug("==============培训计划查询结束=====================");
		}
		
		if( "DELETE".equals(mapping.getParameter())){
			log.debug("==============培训计划删除开始=====================");
//			dto.setIgdrm1501Form(form);
			dto.setDeleteEntityItem(form.getDeleteTpid());
			ctlBL.deleteEntityItemAction(dto);
			log.debug("==============培训计划删除结束=====================");
		}
		List<ActionMessage> messageList = dto.getMessageList();
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(request, message);
            } 
        } 
		return mapping.findForward("DISP");
	}
}
