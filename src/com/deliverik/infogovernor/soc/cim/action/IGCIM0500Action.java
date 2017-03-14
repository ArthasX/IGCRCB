package com.deliverik.infogovernor.soc.cim.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0203Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM05001VO;

/**
 * 概述: 全域拓扑图Action处理
 * 功能描述: 全域拓扑图Action处理
 * 创建记录: yanglongquan 2013/05/22
 * 修改记录: 
 */
public class IGCIM0500Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0500Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		//DTO生成
		IGCIM02DTO dto = new IGCIM02DTO();
		
		//BL取得
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		//先查询默认域信息
		IGCIM0203Form form =new IGCIM0203Form();
		//域名字
		form.setName_like(CommonDefineUtils.DOMAIN_NAME);
		dto.setEiDomainDefSearchCond(form);
		//查询记录最大件数取得
		//设置最大数
		dto=ctlBL.searchEiDomainDefActionNoPage(dto);
		List<SOC0111Info> list=dto.getEiDomainDefInfoList();
		if(list!=null&&list.size()>0){
			//获取参数
			SOC0111Info info=list.get(0);
			String updatetime=info.getUpdatetime();
			Integer version=info.getVersion();
			Integer eiddid=info.getEiddid();
			//传递参数
			IGCIM05001VO vo = new IGCIM05001VO();
			vo.setIsGoTopology("1");
			vo.setEiddid(eiddid);
			vo.setVersion(version);
			vo.setUpdatetime(updatetime);
			super.<IGCIM05001VO>setVO(req, vo);
		}
		return mapping.findForward("DISP");
	}
}
