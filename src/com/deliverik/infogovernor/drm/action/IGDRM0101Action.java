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
import com.deliverik.infogovernor.drm.bl.IGDRM01BL;
import com.deliverik.infogovernor.drm.dto.IGDRM01DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0101Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:场景定义Action处理
 * </p>
 * 
 * @author wym@deliverik.com
 * @version 1.0
 */
public class IGDRM0101Action extends BaseAction {

    static Log log = LogFactory.getLog(IGDRM0101Action.class);

    /**
     * 场景定义Action处理
     *
     * @param mapping 
     * @param actionForm 
     * @param req 
     * @param res 
     * @return 
     * @throws Exception 
     */
    @Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm
			, HttpServletRequest req, HttpServletResponse res) throws Exception {
        //
        IGDRM0101Form form = (IGDRM0101Form)actionForm;
        IGDRM01DTO dto = new IGDRM01DTO();
        IGDRM01BL ctlBL =(IGDRM01BL)getBean("igdrm01BL");
        dto.setIgdrm0101Form(form);
        if("DISP".equals(mapping.getParameter())){
        //AJAX 场景审批节点-场景流程定义状态节点信息查询
        }else if("STAUTSINFO".equals(mapping.getParameter())){
        	log.debug("==========节点信息取得操作开始==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				//查询节点状态信息
				String josn = ctlBL.getStautsInfo(dto);
				//节点信息list-josn字符串
				out.print(josn);
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========节点信息取得操作结束==========");
        }else if("STAUTSLOG".equals(mapping.getParameter())){
        	log.debug("==========场景实例已填节点表单信息取得操作开始==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				//查询节点状态信息
				String josn = ctlBL.getStautsFormLog(dto);
				//节点信息list-josn字符串
				out.print(josn);
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========场景实例已填节点表单信息取得操作结束==========");
        }else if("ORGINFO".equals(mapping.getParameter())){
        	log.debug("==========节点信息取得操作开始==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				//查询节点状态信息
				dto = ctlBL.getOrgInfo(dto);
				//节点信息list-josn字符串
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========节点信息取得操作结束==========");
        }else if("ATTKEY".equals(mapping.getParameter())){
        	log.debug("==========节点信息取得操作开始==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				//查询节点状态信息
				String attKeyXml  = ctlBL.getAttKey(dto);
				//状态级附件 - 信息xml字符串
				out.print(attKeyXml);
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========节点信息取得操作结束==========");
        }else if("STATEFORM".equals(mapping.getParameter())){
        	log.debug("==========节点-状态表单信息取得操作开始==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				//查询节点状态信息
				String stateFormXml  = ctlBL.getStateForm(dto);
				//状态级表单 - 信息xml字符串
				out.print(stateFormXml);
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========节点-状态表单信息取得操作结束==========");
        }else if("SWITCHMASTER".equals(mapping.getParameter())){
        	log.debug("==========节点-切换主备按钮操作开始==========");
        	PrintWriter out = null;
        	try {
        		out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
        		dto.setPrid(Integer.parseInt(req.getParameter("prid")));
        		ctlBL.switchMaster(dto);
        		String result = dto.getResult();
        		if(StringUtils.isNotEmpty(result)){
        			out.print(result);
        		}else{
        			out.print("切换主备失败");
        		}
        		
        	}catch (Exception e) {
				out.print("切换主备失败");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
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
