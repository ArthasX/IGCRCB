/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
import com.deliverik.infogovernor.drm.form.IGDRM1002Form;
import com.deliverik.infogovernor.drm.vo.IGDRM10021VO;
import com.deliverik.infogovernor.drm.vo.IGDRM10022VO;

/**
 * 概述：组织架构角色关系Action
 * 功能描述：组织架构角色关系Action
 * 创建人：WYW
 * 创建记录：2014/06/25
 * 修改记录：
 */
public class IGDRM1002Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGDRM1002Action.class);
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse respons) throws Exception {
		//初始化DTO
		IGDRM10DTO dto = new IGDRM10DTO();
		//初始化form
		IGDRM1002Form form = (IGDRM1002Form)actionForm;

		
		//获取BL接口实例
		IGDRM10BL ctlBL = (IGDRM10BL) getBean("igdrm10BL");
		//跳转页面
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
		}
		//初始化兼查询
		else if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("==========组织架构角色关系查询处理开始==========");
			dto.setForm(form);
			//获取组织架构角色关系初始化信息
			dto = ctlBL.initIGDRM1002Action(dto);
		     //初始化vo
	        IGDRM10021VO vo = new IGDRM10021VO();
			vo.setRelationlist(dto.getRelationlist());
			vo.setCodeDetailDef(dto.getCodDetailDef());
			super.<IGDRM10021VO>setVO(request, vo);
			log.debug("==========组织架构角色关系查询处理结束==========");
		}
		//编辑
		else if("EDIT".equals(mapping.getParameter())){
			log.debug("==========组织架构角色关系编辑新增处理开始==========");
			dto.setForm(form);
			dto = ctlBL.editIGDRM1002Action(dto);
			addMessage(request, new ActionMessage("IGDRM0601.I001","组织架构关联角色新增成功！"));
			request.setAttribute("sign", "1");
			log.debug("==========组织架构角色关系编辑新增处理结束==========");
		}
		//更新或插入方法
		else if("DELETE".equals(mapping.getParameter())){
			log.debug("==========组织架构角色关系删除处理开始==========");
			dto.setForm(form);
			dto = ctlBL.deleteRoleRelation(dto);
			addMessage(request, new ActionMessage("IGDRM0601.I001","组织架构关联角色删除成功！"));
			log.debug("==========组织架构角色关系删除处理结束==========");
		}
		//用户查询
		else if("ROLESEARCH".equals(mapping.getParameter())){
            //流程定义查询处理
            log.debug("========角色查询开始========");
            //分页用DTO取得
            getPaginDTO(request,"IGDRM1001");
            PagingDTO pDto;
            
            pDto = (PagingDTO)request.getAttribute("PagingDTO");
            if ("SEARCH1".equals(mapping.getParameter())){
                //由详细画面，编辑画面返回查询画面时的再检索处理
                form = (IGDRM1002Form) request.getSession().getAttribute("IGDRM1002Form");
                if ( form == null ) {
                    form = new IGDRM1002Form();
                }else {
                    if (request.getParameter("PAGING") == null) {
                        pDto.setFromCount(form.getFromCount());
                    } else {
                        form.setFromCount(pDto.getFromCount());
                    }
                }
            } else {
                if (request.getParameter("PAGING") == null) {
                    pDto.setFromCount(0);
//                  form = (IGPRD0301Form) req.getSession().getAttribute("IGPRD0301Form");
                    if (form !=null) {
                        form.setFromCount(0);
                    }
                }
            }
            
            //查询记录最大件数取得
            int maxCnt = getMaxDataCount("IGDRM1002");
            dto.setMaxSearchCount(maxCnt);
            dto.setPagingDto(pDto);
            dto.setForm(form);
            //查询
            dto = ctlBL.searchRole(dto);
            IGDRM10022VO vo = new IGDRM10022VO();
            vo.setRolelist(dto.getRolelist());
            super.<IGDRM10022VO>setVO(request, vo);
            log.debug("========角色查询终了========");
        }
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		
	      //过滤处理
        String ccid = request.getParameter("ccid");
        request.setAttribute("ccid", ccid);
        String cid = request.getParameter("cid");
        request.setAttribute("cid", cid);
        String clevel = request.getParameter("clevel");
        request.setAttribute("clevel", clevel);
		return mapping.findForward(forward);
	}
}