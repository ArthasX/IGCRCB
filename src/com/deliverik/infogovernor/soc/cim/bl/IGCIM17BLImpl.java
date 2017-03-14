package com.deliverik.infogovernor.soc.cim.bl;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0113BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0153BL;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.SOC0153Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0113SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0153SearchCondImpl;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM17DTO;

public class IGCIM17BLImpl extends BaseBLImpl implements IGCIM17BL {
	
	static Log log = LogFactory.getLog(IGCIM17BLImpl.class);
	
	/**日志信息BL*/
	private SOC0153BL soc0153BL;

	public void setSoc0153BL(SOC0153BL soc0153bl) {
		soc0153BL = soc0153bl;
	}
	/**导入设备信息BL*/
	private SOC0113BL soc0113BL;
	
	
	public void setSoc0113BL(SOC0113BL soc0113bl) {
		soc0113BL = soc0113bl;
	}
	
	/**
	 * 查找
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM17DTO searchSoc0153List(IGCIM17DTO dto)throws BLException{
		
		
		log.debug("========日志信息查询处理开始========");
		
		SOC0153SearchCondImpl cond = new SOC0153SearchCondImpl();
		if("IGCIM1701Form".equals(dto.getFormName())){
			BeanUtils.copyProperties(dto.getIgcim1701Form(), cond);
		}else if("IGCIM1702Form".equals(dto.getFormName())){
			BeanUtils.copyProperties(dto.getIgcim1702Form(), cond);
		}else if("IGCIM1703Form".equals(dto.getFormName())){
			BeanUtils.copyProperties(dto.getIgcim1703Form(), cond);
		}
		
		dto = this.searchSoc0113Info(dto);
		
		int totalCount = soc0153BL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========日志查询数据不存在========");
			//查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========日志信息查询数据件数过多========");
			//查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//分页用信息取得
			PagingDTO pDto = dto.getPagingDto();
			
			//当前页应用信息取得
			List<SOC0153Info> soc0153List = soc0153BL.searchSoc0153(cond, pDto.getFromCount(), pDto.getPageDispCount());
			
			pDto.setTotalCount(totalCount);
			
			dto.setSoc0153List(soc0153List);
			
			dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

			log.debug("========日志信息查询处理结束========");
		return dto;
		
		
	}
	/**
	 * 查询导入信息
	 * @param dto
	 * @return
	 */
	public IGCIM17DTO searchSoc0113Info(IGCIM17DTO dto){
		List<SOC0113Info> list = soc0113BL.searchEiImportProgramme();
		List<SOC0113Info> newList = new ArrayList<SOC0113Info>();
		String esyscoding = dto.getEsyscoding();
		if (StringUtils.isNotEmpty(esyscoding)) {
			if (list != null && list.size() > 0) {
				for (SOC0113Info info : list) {
					String fingerPrint = info.getFingerPrint();
					if (StringUtils.isNotEmpty(fingerPrint)) {
						if (fingerPrint.startsWith(esyscoding)) {
							newList.add(info);
						}
					}
				}
			}
		}
		
		dto.setSoc0113List(newList);
		return dto;
	}
	
}
