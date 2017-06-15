/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fxk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.fxk.bl.IGFXK07BL;
import com.deliverik.infogovernor.fxk.dto.IGFXK07DTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0700Form;
import com.deliverik.infogovernor.fxk.vo.IGFXK07011VO;
import com.deliverik.infogovernor.fxk.vo.IGFXK07012VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 2014-6-16
 * @author zhangq@deliverik.com
 * @version 1.0
 */
public class IGFXK0701Action extends BaseAction {

	/**日志参数*/
	private static Log log = LogFactory.getLog(IGFXK0701Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse res) throws Exception {
		log.debug("=======================风险提醒管理开始=======================");
		
		IGFXK0700Form form = (IGFXK0700Form)actionForm;
		IGFXK07DTO dto=new IGFXK07DTO();
		dto.setForm(form);
		
		//获取BL接口实例
		IGFXK07BL ctrlBL = (IGFXK07BL) getBean("igFXK07BL");
		//跳转页面
		String forward = "DISP"; 
		//初始化页面
		if("DISP".equals(mapping.getParameter())){
			log.debug("========风险提示查询初始化处理开始========");
			
			log.debug("========风险提示查询初始化处理终了========");
		}
		//初始化页面
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(request,"IGFXK0701");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGFXK0700Form) request.getSession().getAttribute("IGFXK0700Form");
				if ( form == null ) {
					form = new IGFXK0700Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} 
			int maxCnt = getMaxDataCount("IGFXK0701");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setForm(form);
			
			//调用bl 进行数据处理
			ctrlBL.searchRiskmanagerwaring(dto);
			//实例化vo
			IGFXK07011VO vo = new IGFXK07011VO();
			//数据返回给页面
			vo.setVoList(dto.getVoList());
			super.<IGFXK07011VO>setVO(request, vo);
			log.debug("=======风险提示管理查询处理结束========");
			
		}else if("EACH".equals(mapping.getParameter())){
			String rwid=request.getParameter("rwid");
			dto.setRwid(Integer.parseInt(rwid));
			dto=ctrlBL.searchRiskmanagerwaringById(dto);
			form.setNorgname(dto.getForm().getNorgname());
			form.setNtel(dto.getForm().getNtel());
			form.setNtime(dto.getForm().getNtime());
			form.setNusername(dto.getForm().getNusername());
			form.setRwcontext(dto.getForm().getRwcontext());
			form.setRwname(dto.getForm().getRwname());
			form.setType(dto.getForm().getType());
			
			if (dto.getForm().getRwkey()!=null &&!dto.getForm().getRwkey().equals("")) {
				AttachmentBL attachmentBL=(AttachmentBL) getBean("attachmentBL");		
				List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(dto.getForm().getRwkey());
				form.setAttachmentList(attachmentList);
			}
//			 /**页面展示VO设定*/
			IGFXK07012VO vo = new IGFXK07012VO();
			vo.setAcceptuserList(dto.getAcceptList());
			super.<IGFXK07012VO>setVO(request, vo);
			log.debug("=======风险提示管理查询处理结束========");
		}
		//附件下载
	if ("LOADFILE".equals(mapping.getParameter())){
		log.debug("========通知附件下载处理开始========");
		String exattkey=request.getParameter("exattkey");
		String attId=request.getParameter("attid");	
		String type="sym";
		request.setAttribute("type", type);
		request.setAttribute("attId", attId);

		log.debug("========通知附件下载处理结束========");
		forward="LOADFILE";
	}

		return mapping.findForward(forward);
	}
}
