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
import com.deliverik.infogovernor.drm.bl.IGDRM02BL;
import com.deliverik.infogovernor.drm.dto.IGDRM02DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0201Form;
import com.deliverik.infogovernor.drm.vo.IGDRM02011VO;

/**
 * 
 * 组合场景定义Action处理
 * 
 * @author zyl
 */
public class IGDRM0201Action extends BaseAction {

    static Log log = LogFactory.getLog(IGDRM0201Action.class);

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
        IGDRM0201Form form = (IGDRM0201Form)actionForm;
        IGDRM02DTO dto = new IGDRM02DTO();
        IGDRM02BL ctlBL =(IGDRM02BL)getBean("igdrm02BL");
        dto.setIgdrm0201Form(form);
        //流程编辑器中场景选择弹出窗初始化
        if("SDISP".equals(mapping.getParameter())){
        	req.setAttribute("eiids", form.getEiids());
        }
        //组合场景流程xml初始化
        else if("DISP".equals(mapping.getParameter())){
        	//初始化
			log.debug("==========查询场景初始化操作开始==========");
			String pgdid = req.getParameter("pgdid");
			String isMask = req.getParameter("isMask");
			String isUpdate = req.getParameter("isUpdate");
			String oldpdid = req.getParameter("oldpdid");
			dto.setPgdid(pgdid);
			//升版标识
			dto.setIsUpdate(isUpdate);
			//原场景pgdid
			dto.setOldpdid(oldpdid);
			// 组合场景初始化xml
			String initJsonXML = ctlBL.getSceneInitXMLInfo(dto);
			form.setXml(initJsonXML);
			form.setIsMask(isMask);
			log.debug("==========查询场景初始化操作开始==========");
        }
        //查询场景信息操作
		else if ("SEARCHSCENE".equals(mapping.getParameter())) {
			log.debug("==========查询场景信息操作开始==========");
			String ename = form.getEname();
			if(StringUtils.isNotEmpty(ename)){
				form.setEname(ename);
			}
			dto = ctlBL.searchSceneProcessInfo(dto);
			// 将资产项信息检索结果设定到VO中
			IGDRM02011VO vo = new IGDRM02011VO();
			vo.setEntityItemVWInfoList(dto.getSoc0124List());
			super.<IGDRM02011VO> setVO(req, vo);
			log.debug("==========查询场景信息操作结束==========");
		}
        //添加场景信息操作
        else if("ADDSCENE".equals(mapping.getParameter())){
        	log.debug("==========添加场景操作开始==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				String addEiids[] = req.getParameterValues("addEiids[]");
		        dto.setAddEiids(addEiids);	
		        //得到场景流程xml
		        String sceneJsonXML =  ctlBL.getSceneProcessXMLInfo(dto);
				//节点信息list-josn字符串
				out.print(sceneJsonXML);
			
			} catch (Exception e) {
				log.error("Ajax ADD Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========添加场景操作结束==========");
			return null;
            }        
        //保存组合场景信息
        else if("SAVE".equals(mapping.getParameter())){
			log.debug("===========流程组合场景定义信息保存操作============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				String prid = req.getParameter("prid");
				String pdid = req.getParameter("pdid");
				dto.setPrid(Integer.parseInt(prid));
				String xml = req.getParameter("xmlValue");
				if(StringUtils.isNotEmpty(xml)){
					//单引号替换双引号
					xml = xml.replaceAll("\'","\"" );
				}
				dto.setPdidStr(pdid);
				dto.setXmlValue(xml);
		        //保存场景流程xml
		    	ctlBL.saveSceneProcessAction(dto);
				//节点信息list-josn字符串
			} catch (Exception e) {
				log.error("Ajax SAVE Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			
			log.debug("===========流程组合场景定义信息保存结束============");
			return null;
		}
        //获取状态表单
        else if("STATEFORM".equals(mapping.getParameter())){
        	log.debug("==========组合场景节点-状态表单信息取得操作开始==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				String pgdid = req.getParameter("pgdid");
				String pdidStr = req.getParameter("pdidStr");
				dto.setPdidStr(pdidStr);
				dto.setPgdid(pgdid);
				//查询节点状态信息
				String stateFormXml  = ctlBL.getStateFormXML(dto);
				//状态级表单 - 信息xml字符串
				out.print(stateFormXml);
			} catch (Exception e) {
				out.print("");
				log.error("Ajax STATEFORM Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========组合场景节点-状态表单信息取得操作结束==========");
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
