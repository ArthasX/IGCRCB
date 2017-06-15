package com.deliverik.infogovernor.fxk.action;

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
import com.deliverik.infogovernor.fxk.bl.IGFXK03BL;
import com.deliverik.infogovernor.fxk.dto.IGFXK03DTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0301Form;
import com.deliverik.infogovernor.fxk.vo.IGFXK03011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险计划查询Action
 * </p>
 * 
 * @author fenghuan@deliverik.com
 * @version 1.0
 */
public class IGFXK0301Action  extends BaseAction{
    /**日志参数*/
    private static Log log = LogFactory.getLog(IGFXK0301Action.class);
    
    @Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.debug("=======================风险提醒管理开始=======================");
        
        IGFXK0301Form form = (IGFXK0301Form)actionForm;
        IGFXK03DTO dto=new IGFXK03DTO();
        dto.setForm(actionForm);
        //获取BL接口实例
        IGFXK03BL ctrlBL = (IGFXK03BL) getBean("igFXK03BL");
        //跳转页面
        String forward = "DISP"; 
        dto=ctrlBL.searchLableValueAction(dto);
        request.setAttribute("lvFXTYPEList", dto.getLst_LabelValueBean());
        dto=ctrlBL.searchUserLabelValueBean(dto);
        request.setAttribute("userLabelLst", dto.getPeo_LabelValueBean());
        
        //初始化页面
        if("DISP".equals(mapping.getParameter())){
            
        }
        //初始化页面
        if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
            //分页用DTO取得
            getPaginDTO(request,"IGFXK0301");
            PagingDTO pDto;
            pDto = (PagingDTO)request.getAttribute("PagingDTO");
            if ("SEARCH1".equals(mapping.getParameter())){
                //由详细画面，编辑画面返回查询画面时的再检索处理
                form = (IGFXK0301Form) request.getSession().getAttribute("IGFXK0301Form");
                if ( form == null ) {
                    form = new IGFXK0301Form();
                }else {
                    if (request.getParameter("PAGING") == null) {
                        pDto.setFromCount(form.getFromCount());
                    } else {
                        form.setFromCount(pDto.getFromCount());
                    }
                }
            } 
            int maxCnt = getMaxDataCount("IGFXK0301");
            dto.setMaxSearchCount(maxCnt);
            dto.setPagingDto(pDto);
            
            //DTO输入参数设定
            dto.setMaxSearchCount(maxCnt);
            
            dto.setPagingDto(pDto);
            //调用bl 进行数据处理
            dto=ctrlBL.searchRiskproAction(dto);
            //实例化vo
            IGFXK03011VO vo = new IGFXK03011VO();
            
            //数据返回给页面
            vo.setInfomap(dto.getInfomap());
            super.<IGFXK03011VO>setVO(request, vo);
            log.debug("=======风险提示管理查询处理结束========");
            
        }
        List<ActionMessage> messageList = dto.getMessageList();
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(request, message);
            }
        }
        return mapping.findForward(forward);

	}

	
}
