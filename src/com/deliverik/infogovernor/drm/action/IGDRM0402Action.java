/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0402Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04021VO;
import com.google.gson.Gson;


/**
 * 应急资源查询Action
 * @author 张剑
 *
 * 2015-2-12 上午9:51:47
 */
public class IGDRM0402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0402Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		//BL取得
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		IGDRM0402Form form = (IGDRM0402Form)actionForm;
		
		//DTO生成
		IGDRM04DTO dto = new IGDRM04DTO();
		dto.setIgdrm0402Form(form);
		dto.setUser(user);
		dto.setResourceType(form.getResourceType());
		req.setAttribute("resourceType", req.getParameter("resourceType"));
		//预置Gson
		Gson g = new Gson();
		
		//画面跳转设定
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			//页面初始化
			log.debug("========页面初始化开始========");
			dto.setRootEsyscoding("000");
			dto.setResourceType(req.getParameter("resourceType"));
			ctlBL.initNewNodeMap(dto);
			req.setAttribute("ercode", form.getErcode());
			req.setAttribute("erid", form.getErid());
			req.setAttribute("esyscode", form.getEsyscoding());
			
			IGDRM04021VO vo = new IGDRM04021VO();
			
			vo.setNodeMapJson(g.toJson(dto.getNodeMap()));
			
			super.<IGDRM04021VO>setVO(req, vo);
			log.debug("========页面初始化处理终了========");
		}
	
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//流程定义查询处理
			log.debug("========应急资源查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGDRM0401");
			
			
			log.info("canshu >>>"+req.getParameter("resourceType"));
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM0402Form) req.getSession().getAttribute("IGDRM0402Form");
				if ( form == null ) {
					form = new IGDRM0402Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDRM0402");
			
			dto.setIgdrm0402Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);

			dto = ctlBL.searchEmergencyResource(dto);
//			if(StringUtil.isEmpty(form.getEiinsdate())){
//				Calendar cal = Calendar.getInstance();
//				int year = cal.get(Calendar.YEAR);
//				req.setAttribute("eiinsdate", year);
//			}else{
//				req.setAttribute("eiinsdate", form.getEiinsdate());
//			}
			IGDRM04021VO vo = new IGDRM04021VO();
			
			vo.setEntityVWItemList(dto.getEntityVWItemList());
			
			vo.setNodeMapJson(g.toJson(dto.getNodeMap()));
			
			super.<IGDRM04021VO>setVO(req, vo);
			
			if(StringUtils.isNotEmpty(form.getOpenFlag())) forward = "OPEN";
			log.info("========应急资源查询处理终了========");
		}
//		if ("DELETE".equals(mapping.getParameter())){
//			//文档删除处理
//			log.debug("========应急资源删除处理开始========");
//			
//			dto.setIgdrm0402Form(form);
//			
//			//DTO输入参数设定
//			dto.setDeleteEntityItem(form.getDeleteEiid());
//			
//			//文档信息删除逻辑调用
//			ctlBL.deleteEntityItemAction(dto);
//			
//			log.debug("========应急资源删除处理终了========");
//		}
		
		if( "ENTITY_DISP".equals(mapping.getParameter())){
			
			req.setAttribute("erid",form.getErid());
			req.setAttribute("ercode", form.getErcode());
			getPaginDTO(req,"IGDRM0401");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0301");
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			//DTO输入参数设定
			dto.setIgdrm0402Form(form);
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//资产检索逻辑调用
			dto = ctlBL.searchEntityDisp(dto);
			
			//将资产信息检索结果设定到VO中
			IGDRM04021VO vo = new IGDRM04021VO();
			vo.setEntityVWItemList(dto.getEntityItemVWInfoList());
			super.<IGDRM04021VO>setVO(req, vo);
		}
		
		if( "ENTITY_SEARCH".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGDRM0401");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//资产查询处理
			log.debug("========资产查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM0402Form) req.getSession().getAttribute("IGDRM0402Form");
				if ( form == null ) {
					form = new IGDRM0402Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0301");
			
			//DTO输入参数设定
//			dto.setEntityItemVWSearchCond(form);
			dto.setIgdrm0402Form(form);
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//资产检索逻辑调用
			dto = ctlBL.searchEntityItemAction(dto);
			form = dto.getIgdrm0402Form();
			//将资产信息检索结果设定到VO中
			IGDRM04021VO vo = new IGDRM04021VO();
			vo.setEntityVWItemList(dto.getEntityItemVWInfoList());
			super.<IGDRM04021VO>setVO(req, vo);
			
			log.debug("========资产查询处理终了========");
		}
		if ("RELATION".equals(mapping.getParameter())){
			//关联资产
			log.debug("========应急资源关联资产处理开始========");
			
			//DTO输入参数设定
			dto.setIgdrm0402Form(form);
			dto.setRelationEiid(form.getRelationEiid());
			
			//应急资源关联资产逻辑调用
			ctlBL.setRelationAction(dto);
			req.setAttribute("status", "close");
			log.debug("========应急资源关联资产处理终了========");
		}
		if ("DELETE_RELATION".equals(mapping.getParameter())){
			//文档删除处理
			log.debug("========应急资源删除处理开始========");
			
			dto.setIgdrm0402Form(form);
			
			//DTO输入参数设定
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//文档信息删除逻辑调用
			ctlBL.deleteRelationAction(dto);
			
			log.debug("========应急资源删除处理终了========");
		}
		if("AJAX".equals(mapping.getParameter())){
			log.debug("============ajax查看是否有关联的资产开始=============");
			
			//DTO输入参数设定
			Integer erid = form.getErid();
			
			PrintWriter out = null;
			try {
				boolean flag = ctlBL.searchRelationAjaxAction(erid);
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(flag);
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			
			log.debug("==============ajax查看是否有关联的资产结束=============");
			
			return null;
			
		}
		
		if("GETCOUNT".equals(mapping.getParameter())){
			log.debug("===============获取分类数量操作开始===============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "UTF-8"));
				dto = ctlBL.getTreeNodeNameCountAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===============获取分类数量操作结束===============");
			return null;
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}

		return mapping.findForward(forward);
	}
	
}
