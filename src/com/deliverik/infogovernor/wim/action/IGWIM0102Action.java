/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wim.bl.IGWIM01BL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;
import com.deliverik.infogovernor.wim.form.IGWIM0102Form;
import com.deliverik.infogovernor.wim.vo.IGWIM01012VO;
import com.google.gson.Gson;

/**
 * 
 * @Description 工作项查询、删除Action
 *
 * @date 2017年6月14日
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public class IGWIM0102Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGWIM0101Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//Form取得
		IGWIM0102Form form = (IGWIM0102Form) actionForm;
		//BL取得
		IGWIM01BL ctlBL  = (IGWIM01BL) getBean("igwim01BL");
		//DTO生成
		IGWIM01DTO dto = new IGWIM01DTO();
		//获取登录用户
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//登陆用户保存
		dto.setUser(user);
		//保存Form
		dto.setIgwim0102Form(form);
		
		if("DISP".equals(mapping.getParameter())){
			
			log.info("==========工作项Action初始化显示开始==========");
			//分页用DTO取得
			getPaginDTO(request,"IGWIM0102");
			//实例化VO
			IGWIM01012VO vo = new IGWIM01012VO();
			
			super.<IGWIM01012VO>setVO(request, vo);
			
			log.info("==========工作项Action初始化显示结束==========");
			
		}else if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			
			log.info("==========工作项查询处理Action开始==========");
			
			//分页用DTO取得
			getPaginDTO(request,"IGWIM0102");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGWIM0102Form) request.getSession().getAttribute("IGWIM0102Form");
				if ( form == null ) {
					
					form = new IGWIM0102Form();
				}else {
					
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			}else {
				if (request.getParameter("PAGING") == null) {
					
					pDto.setFromCount(0);
					form = (IGWIM0102Form) request.getSession().getAttribute("IGWIM0102Form");
					
					if (form !=null) {
						form.setFromCount(0);
					}
				 }
			}
			
			//获取和设置最大件数
			int maxCnt = getMaxDataCount("IGWIM0102");
			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			
			//设置分页DTO
			dto.setPagingDto(pDto);
			
			//调用bl数据检索
			ctlBL.searchWorkDefinition(dto);

			//实例化IGWIM01012VO
			IGWIM01012VO vo = new IGWIM01012VO();
			vo.setIgwim0102Form(form);
			
			//检查项集合
			vo.setDefinitionInfos(dto.getDefinitionInfos());
			
			super.<IGWIM01012VO>setVO(request,vo);
			
			log.info("==========工作项查询处理Action结束==========");
			
		}else if ("DELETE".equals(mapping.getParameter())){
			log.debug("========工作项删除Action处理开始========");
			
			//取得输出流
			PrintWriter out = null;
			try {
				//设置输出格式
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"));
				//DTO输入参数设定
				dto.setDeleteEntityItem(form.getDeleteEiid());
				//工作项信息删除逻辑调用
				ctlBL.deleteWorkDefinitoinAction(dto);
				//实例化Gson
				Gson gson = new Gson();
				//保存提示信息
				out.print(gson.toJson(dto.getMsg()));
				
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
				e.printStackTrace();
			}finally {
				
				if(out!=null){
					out.close();
				}
			}
			log.debug("========工作项删除Action处理结束========");
			
			return null;
		}else if("IMPORT".equals(mapping.getParameter())){
			log.debug("=============工作项数据导入Action开始=================");
			try{
				ctlBL.importData(dto);
			}catch(Exception e){
				
			}
			log.debug("=============工作项数据导入Action结束=================");
		}
		
		return mapping.findForward("DISP");
	}
}
