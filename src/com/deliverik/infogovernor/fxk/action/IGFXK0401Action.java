/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fxk.action;

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
import com.deliverik.infogovernor.fxk.bl.IGFXK04BL;
import com.deliverik.infogovernor.fxk.dto.IGFXK04DTO;
import com.deliverik.infogovernor.fxk.vo.IGFXK04011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 模型树查询Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGFXK0401Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGFXK0401Action.class);
		//BL取得
		IGFXK04BL ctlBL = (IGFXK04BL) getBean("igfxk04BL");
		//实例化dto
		IGFXK04DTO dto = new IGFXK04DTO();
		//dto参数设定
		dto.setForm(actionForm);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("============模型树显示操作开始===========");
			dto = ctlBL.searchAsmModelTree(dto);
			//实例化vo
			IGFXK04011VO vo = new IGFXK04011VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGFXK04011VO>setVO(request, vo);
			log.debug("============模型树显示操作结束===========");
		}
		if ("ZTREE".equals(mapping.getParameter())){
            //start================================>SYS0103
			log.debug("============模型树显示操作开始===========");
            String json = "";
            json = ctlBL.searchAsmModelZTree(dto);
            IGFXK04011VO vo = new IGFXK04011VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGFXK04011VO>setVO(request, vo);
            vo.setTreejson(json);
            log.debug("============模型树显示操作结束===========");
        } 
		
		//获取风险点
		if("GETASM013".equals(mapping.getParameter())){
			log.debug("============获取风险点操作开始=============");
			dto = ctlBL.searchAsm013Action(dto);
			PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                out.print(dto.getAjaxResult());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			log.debug("============获取风险点操作结束=============");
			return null;
		}
		//获取检查项
		if("GETASM014".equals(mapping.getParameter())){
			log.debug("============获取检查项操作开始=============");
			dto = ctlBL.searchAsm014Action(dto);
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null){
					out.close();
				}
			}
			log.debug("============获取检查项操作结束=============");
			return null;
		}
		//相关风险清单查询
		if("GETRELATIONPROCESS".equals(mapping.getParameter())){
			log.debug("===============关联风险清单查询操作开始==============");
			dto = ctlBL.getRelationProcess(dto);
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null){
					out.close();
				}
			}
			log.debug("===============关联风险清单查询操作结束==============");
		}
		return mapping.findForward("DISP");
	}

}
