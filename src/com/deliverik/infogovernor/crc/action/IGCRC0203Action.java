/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.crc.bl.IGCRC0203ExcelBL;
import com.deliverik.infogovernor.crc.bl.IGCRC02BL;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC02ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC0203Form;
import com.deliverik.infogovernor.crc.form.IGCRC0204Form;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;
import com.deliverik.infogovernor.crc.model.vo.IGCRC0203VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 告警信息查询Action
 * </p>
 * 
 * @author changhao@deliverik.com
 * @version 1.0
 */
public class IGCRC0203Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCRC0203Action.class);
	
	/**
	 * <p>
	 * Description: 页面查询action处理
	 * </p>
	 * 
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("================告警信息查询Action开始=============");
		
		//获取BL接口实例
		IGCRC02BL crcBL = (IGCRC02BL)getBean("igcrc02bl");
		//实例化DTO
		IGCRC02DTO dto = new IGCRC02DTO();
		//跳转
		String forward = "";
		//角色授权查询
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========告警信息查询处理开始========");
			//实例化FORM
			IGCRC0203Form form = (IGCRC0203Form)actionForm;
			
			int maxCnt = getMaxDataCount("IGSVC0201");
			//获取分页Bean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC0203");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGCRC0203Form) request.getSession().getAttribute("IGCRC0203Form");
				if ( form == null){
					form = new IGCRC0203Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDTO.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDTO.getFromCount());
					}
				}
			} else {
					if (request.getParameter("PAGING") == null) {
						pDTO.setFromCount(0);
						form = (IGCRC0203Form) request.getSession()
								.getAttribute("IGCRC0203Form");
						if (form != null) {
							form.setFromCount(0);
						}
					}
			}
			// 是否显示标识(0显示，1不显示)
			form.setIsShow("0");
			dto.setForm(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDTO(pDTO);
			//调用BL查询 
			crcBL.serachIgalarmSortList(dto);
			//构造VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			
			//放入排序状态(只能排序一个 不能同时排序多个，其中只有一个有值，其他没有值为null或者"")
			vo.setAppnamestatus(dto.getForm().getAppnamestatus());
			vo.setLasttimestatus(dto.getForm().getLasttimestatus());
			vo.setIpaddrstatus(dto.getForm().getIpaddrstatus());
			vo.setRecoverytimestatus(dto.getForm().getRecoverytimestatus());
			super.<IGCRC0203VO>setVO(request, vo);
			forward = "DISP";
			log.debug("========告警信息查询处理终了========");
		}else if("EDIT".equals(mapping.getParameter())){
			//实例化FORM
			IGCRC0204Form igcrc0204Form = (IGCRC0204Form)actionForm;
			IGCRC02DTO editDto = new IGCRC02DTO();
			editDto.setIgcrc0204Form(igcrc0204Form);
			//查询告警信息
			editDto = crcBL.searchIgalarmByPK(editDto);
			//构造vo
			IGCRC0203VO vo = new IGCRC0203VO();
			//保存信息
			vo.setIgalarmInfo(editDto.getIgalarmInfo());
			super.<IGCRC0203VO>setVO(request, vo);
			forward = "EDIT";
		}else if("UPDATE".equals(mapping.getParameter())){
			//实例化FORM
			IGCRC0204Form igcrc0204Form = (IGCRC0204Form)actionForm;
			IGCRC02DTO updateDto = new IGCRC02DTO();
			updateDto.setIgcrc0204Form(igcrc0204Form);
			//更新
			updateDto = crcBL.updateIgalarmByForm(updateDto);
			
			//获取分页Bean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC0203");
			int maxCnt = getMaxDataCount("IGCRC0203");
			dto.setForm(new IGCRC0203Form());
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDTO(pDTO);
			//调用BL查询 
			crcBL.serachIgalarmList(dto);
			//构造VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			super.<IGCRC0203VO>setVO(request, vo);
			
			forward = "DISP";
		}else if("UPDATE1".equals(mapping.getParameter())){
			//实例化FORM
			IGCRC0204Form igcrc0204Form = (IGCRC0204Form)actionForm;
			IGCRC02DTO updateDto = new IGCRC02DTO();
			updateDto.setIgcrc0204Form(igcrc0204Form);
			//更新
			updateDto = crcBL.updateIgalarmByForm(updateDto);
			IGCRC0203Form form = new IGCRC0203Form();
			form.setPedeventid(igcrc0204Form.getPedeventid());
			dto.setForm(form);
			//调用BL查询 
			crcBL.serachIgalarmList(dto);
			request.setAttribute("IGCRC0203Form", form);
			//构造VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			super.<IGCRC0203VO>setVO(request, vo);
			forward = "DISP";
		}else if("DELETE".equals(mapping.getParameter())){
			//实例化FORM
			IGCRC0204Form igcrc0204Form = (IGCRC0204Form)actionForm;
			dto.setIgcrc0204Form(igcrc0204Form);
			String pk = request.getParameter("pk");
			if(StringUtils.isNotEmpty(pk)){
				//删除指定id告警
				String[] id = pk.split(",");
				for(int i=0;i<id.length;i++){
					if(StringUtils.isNotEmpty(pk)){
						dto.getIgcrc0204Form().setPk(Integer.parseInt(id[i]));
						crcBL.deleteIgalarmByPK(dto);
					}
				}
			}
			//获取分页Bean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC0203");
			int maxCnt = getMaxDataCount("IGCRC0203");
			IGCRC0203Form form = new IGCRC0203Form();
			form.setIsShow("0");
			dto.setForm(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDTO(pDTO);
			//调用BL查询 
			crcBL.serachIgalarmList(dto);
			//构造VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			super.<IGCRC0203VO>setVO(request, vo);
			
			forward = "DISP";
		}else if("DELETE1".equals(mapping.getParameter())){
			//批量删除
			//实例化FORM
			IGCRC0204Form igcrc0204Form = (IGCRC0204Form)actionForm;
			dto.setIgcrc0204Form(igcrc0204Form);
			//删除指定id告警
			crcBL.deleteIgalarmByPK(dto);
			
			//获取分页Bean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC0203");
			int maxCnt = getMaxDataCount("IGCRC0203");
			dto.setForm(new IGCRC0203Form());
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDTO(pDTO);
			//调用BL查询 
			crcBL.serachIgalarmList(dto);
			//构造VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			super.<IGCRC0203VO>setVO(request, vo);
			
			forward = "DISP";
		}else if("RELEVANCE".equals(mapping.getParameter())){
			
			//实例化FORM
			IGCRC0204Form igcrc0204Form = (IGCRC0204Form)actionForm;
			dto.setIgcrc0204Form(igcrc0204Form);
			//查询指定id告警信息
			dto = crcBL.searchIgalarmByPK(dto);
			//克隆告警数据
			IgalarmTB igalarmTB = (IgalarmTB)SerializationUtils.clone(dto.getIgalarmInfo());
			//生成工单
			igalarmTB.setIsCreateOrder("1");
			//隐藏数据
			igalarmTB.setIsShow("1");
			//更新流程id
			igalarmTB.setPedeventid(igcrc0204Form.getPedeventid());
			//重新保存
			dto.setIgalarmInfo(igalarmTB);
			//将流程id更新到告警信息中
			dto = crcBL.updateIgalarmByIgalarm(dto);
			//获取分页Bean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC0203");
			int maxCnt = getMaxDataCount("IGCRC0203");
			IGCRC0203Form igcrc0203Form =  new IGCRC0203Form();
			// 是否显示标识(0显示，1不显示)
			igcrc0203Form.setIsShow("0");
			dto.setForm(igcrc0203Form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDTO(pDTO);
			//调用BL查询 
			crcBL.serachIgalarmList(dto);
			//构造VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			super.<IGCRC0203VO>setVO(request, vo);
			
			forward = "DISP";
		}else if( "Alarm".equals(mapping.getParameter())){
			log.debug("========告警详细信息查询处理开始========");
			//实例化FORM
			IGCRC0203Form form = (IGCRC0203Form)actionForm;
//			form.setPedeventid(request.getParameter("prserialnum"));
			// 查询告警详细时查询全部状态
			form.setStatus("C");
			dto.setForm(form);
			
			//调用BL查询 
			crcBL.serachIgalarmList(dto);
			//构造VO
			IGCRC0203VO vo = new IGCRC0203VO(dto);
			
			super.<IGCRC0203VO>setVO(request, vo);
			forward = "DISP";
			log.debug("========告警信息查询处理终了========");
		}else if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("=====================告警系统导出开始=======================");
			IGCRC0203Form form = (IGCRC0203Form)actionForm;
			// 是否显示标识(0显示，1不显示)
			form.setIsShow("0");
			// DTO参数设定
			dto.setForm(form);
			// 调用BL查询
			crcBL.serachIgalarmList(dto);
			// 取得Excel处理BL
			IGCRC0203ExcelBL excelBL = (IGCRC0203ExcelBL) getBean("igcrc0203ExcelBL");
			// 设置excelDTO
			IGCRC02ExcelDTO excelDTO = new IGCRC02ExcelDTO();
			// 填充要导出的结果
			excelDTO.setIgalarmInfos(dto.getIgalarmInfos());
			// 填充模板编号
			excelDTO.setFileid("CRC0203");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================告警系统导出结束=======================");
			forward = null;
		}
		
		return mapping.findForward(forward);
	}
}
