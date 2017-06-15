/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
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
import com.deliverik.infogovernor.drm.bl.IGDRM10BL;
import com.deliverik.infogovernor.drm.dto.IGDRM10DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1003Form;
import com.deliverik.infogovernor.drm.vo.IGDRM10031VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 组织架构Action处理
 * </p>
 * 
 * @author zyl
 */

public class IGDRM1003Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1003Action.class);

	/**
	 * 数据分类列表画面Action处理
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
		IGDRM1003Form form = (IGDRM1003Form)actionForm;
		//BL取得
		IGDRM10BL ctlBL = (IGDRM10BL) getBean("igdrm10BL");
		
		//DTO生成
		IGDRM10DTO dto = new IGDRM10DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//数据分类列表画面初期显示处理
			log.debug("========数据分类列表画面初期显示处理开始========");
			
			getPaginDTO(req,"IGDRM1003");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGDRM1003");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);

			//过滤处理
			String orgFlag = req.getParameter("orgFlag");
			dto.setOrgFlag(orgFlag);
			
			dto = ctlBL.initIGDRM1003Action(dto);
			
			IGDRM10031VO vo = new IGDRM10031VO(dto.getCodeCategoryDefInfoList());
			
			saveToken(req);	
			req.setAttribute("orgFlag", orgFlag);
			super.<IGDRM10031VO>setVO(req, vo);
			
			log.debug("========数据分类列表画面初期显示处理终了========");
		}else if("INSERTDISP".equals(mapping.getParameter())){
			log.debug("========数据分类登记画面初期显示处理开始========");
			saveToken(req);	
			log.debug("========数据分类登记画面初期显示处理终了========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========数据分类登记处理开始========");
			dto.setIgdrm1003Form(form);
			if (isTokenValid(req, true)){
				//调用BL新增
				dto = ctlBL.saveIGDRM1003Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========数据分类登记处理终了========");
		}else if ("DEL".equals(mapping.getParameter())){
			//数据分类删除处理
			log.debug("========数据分类删除处理开始========");

			//DTO输入参数设定
			dto.setIgdrm1003Form(form);
			
			if (isTokenValid(req, true)){
				//数据分类删除逻辑调用
				ctlBL.deleteIGDRM1003Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========数据分类删除处理终了========");
		}else if("VIEW".equals(mapping.getParameter())){
			//数据分类列表画面初期显示处理
			log.debug("========数据分类列表画面初期显示处理开始========");
			dto.setSyscoding(req.getParameter("syscoding"));
			dto = ctlBL.initIGDRM1007Action(dto);
			dto = ctlBL.searchCodeDetailDef(dto);
			dto = ctlBL.searchRoleAndUser(dto);
			IGDRM10031VO vo = new IGDRM10031VO(dto.getCodeCategoryDefInfoList());
			vo.setCodeCategoryDefInfo(dto.getCodeCategoryDefInfo());
			vo.setCodeDetailDefInfoList(dto.getCodeDetailDefList());
			vo.setStructureRoleList(dto.getStructureRoleList());
			vo.setUserRoleMap(dto.getUserRoleMap());
			vo.setOrgArr(dto.getOrgArr());
			saveToken(req);	
			super.<IGDRM10031VO>setVO(req, vo);
			log.debug("========数据分类列表画面初期显示处理终了========");
		} else if ("EXPORT".equals(mapping.getParameter())) {
			log.info("=============导出组织架构列表开始===============");
			dto = ctlBL.searchRoleAndUser(dto);
			res.reset();// 清空输出流

			res.setHeader("Content-disposition", "attachment; filename=" + new String("应急组织机构".getBytes("gb2312"), "8859_1") + ".xls");// 设定输出文件头
			res.setContentType("application/msexcel");
			dto.setOps(res.getOutputStream());

			ctlBL.exportOrgTree(dto);

			log.info("=============导出组织架构列表完成===============");
			return null;
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
