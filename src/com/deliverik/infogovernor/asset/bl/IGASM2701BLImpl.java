package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCondImpl;
import com.deliverik.infogovernor.asset.bl.task.RiskPointVMBL;
import com.deliverik.infogovernor.asset.dto.IGASM2701DTO;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskPointVMSearchCondImpl;

public class IGASM2701BLImpl extends BaseBLImpl implements IGASM2701BL {

	/** 日志配置 */
	private static Log log = LogFactory.getLog(IGASM2701BLImpl.class);
	
	/**风险sysconding默认值*/
	
	protected final String SYSCODE="999017";	
	/** 风险点查询TaskBl接口 */
	protected RiskPointVMBL riskPointVMBL;

	/**资产属性取值范围查询soc0151BL*/
	protected SOC0151BL soc0151BL;
	
	/**
	 * 风险点查询TaskBl接口设定
	 * @param riskPointVMBL 风险点查询TaskBl接口
	 */
	public void setRiskPointVMBL(RiskPointVMBL riskPointVMBL) {
		this.riskPointVMBL = riskPointVMBL;
	}
	
	public void setSoc0151BL(SOC0151BL soc0151bl) {
		soc0151BL = soc0151bl;
	}



	public IGASM2701DTO searchRiskPointManagerAction(IGASM2701DTO dto)
			throws BLException {
		
		
		/**风险查询条件设定*/
		RiskPointVMSearchCondImpl cond = new RiskPointVMSearchCondImpl();
		/*cond.setEIINSDATE(dto.getIgasm2713form().getEIINSDATE());
		cond.setEiname(dto.getIgasm2713form().getEiname());
		cond.setGrad(dto.getIgasm2713form().getGrad());
		cond.setLevels(dto.getIgasm2713form().getLevels());
		cond.setManagername(dto.getIgasm2713form().getManagername());
		*/
		/**设定风险分类*/
		if(null==cond.getSyscoding()||"".equals(cond.getSyscoding())){
			cond.setSyscoding(SYSCODE);
		}else{
			cond.setSyscoding(dto.getIgasm2713form().getSyscoding());
		}
		// 分页用信息取得
				PagingDTO pDto = dto.getPagingDto();
				pDto.getPageDispCount();
				/**分页条数*/
				int totalCount = riskPointVMBL.searchRiskPointVM(cond,0,0).size();
				System.out.println(totalCount);
				if (totalCount == 0) {

					log.debug("========用户数据检索数据不存在========");
					// 知识服务检索数据不存在
					dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));

					return dto;
				}

				if (totalCount > dto.getMaxSearchCount()) {

					log.debug("========用户检索数据件数过多========");
					// 用户检索数据件数过多
					dto.addMessage(new ActionMessage("IGBCM0101.E005", dto
							.getMaxSearchCount(), totalCount));

					return dto;
				}
		
		
		
		
		/**调用taskBL查询*/
		List<RiskPointVMInfo> riskList = riskPointVMBL.searchRiskPointVM(cond, pDto.getFromCount(),
				pDto.getPageDispCount());
		
		dto.setRiskList(riskList);
		pDto.setTotalCount(totalCount);
		return dto;
	}

	/**查询风险级别  风险严重*/
	public IGASM2701DTO searchRiskPropertyActioin(IGASM2701DTO dto)
			throws BLException {

		/**风险级别 取值 查询*/
		SOC0151SearchCondImpl levelCond=new SOC0151SearchCondImpl();
		/**设定查询条件*/
		levelCond.setCcdtype("A");
		levelCond.setCcdcategory("137");
		levelCond.setCcdstatus("1");
		/**风险级别集合获取*/
		List<SOC0151Info> levelList = soc0151BL.searchConfigurationCodeDetail(levelCond);
		
		/**风险严重等级 取值 查询*/
		SOC0151SearchCondImpl gradeCond = new SOC0151SearchCondImpl();
		/**设定查询条件*/
		gradeCond.setCcdtype("A");
		gradeCond.setCcdcategory("138");
		gradeCond.setCcdstatus("1");
		/**风险严重等级集合获取*/
		List<SOC0151Info> gradeList = soc0151BL.searchConfigurationCodeDetail(gradeCond);
		
		/**条件设定*/
		dto.setGradeList(gradeList);
		dto.setLevelList(levelList);
		return dto;
	}

}
