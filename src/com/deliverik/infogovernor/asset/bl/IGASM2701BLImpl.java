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

	/** ��־���� */
	private static Log log = LogFactory.getLog(IGASM2701BLImpl.class);
	
	/**����syscondingĬ��ֵ*/
	
	protected final String SYSCODE="999017";	
	/** ���յ��ѯTaskBl�ӿ� */
	protected RiskPointVMBL riskPointVMBL;

	/**�ʲ�����ȡֵ��Χ��ѯsoc0151BL*/
	protected SOC0151BL soc0151BL;
	
	/**
	 * ���յ��ѯTaskBl�ӿ��趨
	 * @param riskPointVMBL ���յ��ѯTaskBl�ӿ�
	 */
	public void setRiskPointVMBL(RiskPointVMBL riskPointVMBL) {
		this.riskPointVMBL = riskPointVMBL;
	}
	
	public void setSoc0151BL(SOC0151BL soc0151bl) {
		soc0151BL = soc0151bl;
	}



	public IGASM2701DTO searchRiskPointManagerAction(IGASM2701DTO dto)
			throws BLException {
		
		
		/**���ղ�ѯ�����趨*/
		RiskPointVMSearchCondImpl cond = new RiskPointVMSearchCondImpl();
		/*cond.setEIINSDATE(dto.getIgasm2713form().getEIINSDATE());
		cond.setEiname(dto.getIgasm2713form().getEiname());
		cond.setGrad(dto.getIgasm2713form().getGrad());
		cond.setLevels(dto.getIgasm2713form().getLevels());
		cond.setManagername(dto.getIgasm2713form().getManagername());
		*/
		/**�趨���շ���*/
		if(null==cond.getSyscoding()||"".equals(cond.getSyscoding())){
			cond.setSyscoding(SYSCODE);
		}else{
			cond.setSyscoding(dto.getIgasm2713form().getSyscoding());
		}
		// ��ҳ����Ϣȡ��
				PagingDTO pDto = dto.getPagingDto();
				pDto.getPageDispCount();
				/**��ҳ����*/
				int totalCount = riskPointVMBL.searchRiskPointVM(cond,0,0).size();
				System.out.println(totalCount);
				if (totalCount == 0) {

					log.debug("========�û����ݼ������ݲ�����========");
					// ֪ʶ����������ݲ�����
					dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));

					return dto;
				}

				if (totalCount > dto.getMaxSearchCount()) {

					log.debug("========�û��������ݼ�������========");
					// �û��������ݼ�������
					dto.addMessage(new ActionMessage("IGBCM0101.E005", dto
							.getMaxSearchCount(), totalCount));

					return dto;
				}
		
		
		
		
		/**����taskBL��ѯ*/
		List<RiskPointVMInfo> riskList = riskPointVMBL.searchRiskPointVM(cond, pDto.getFromCount(),
				pDto.getPageDispCount());
		
		dto.setRiskList(riskList);
		pDto.setTotalCount(totalCount);
		return dto;
	}

	/**��ѯ���ռ���  ��������*/
	public IGASM2701DTO searchRiskPropertyActioin(IGASM2701DTO dto)
			throws BLException {

		/**���ռ��� ȡֵ ��ѯ*/
		SOC0151SearchCondImpl levelCond=new SOC0151SearchCondImpl();
		/**�趨��ѯ����*/
		levelCond.setCcdtype("A");
		levelCond.setCcdcategory("137");
		levelCond.setCcdstatus("1");
		/**���ռ��𼯺ϻ�ȡ*/
		List<SOC0151Info> levelList = soc0151BL.searchConfigurationCodeDetail(levelCond);
		
		/**�������صȼ� ȡֵ ��ѯ*/
		SOC0151SearchCondImpl gradeCond = new SOC0151SearchCondImpl();
		/**�趨��ѯ����*/
		gradeCond.setCcdtype("A");
		gradeCond.setCcdcategory("138");
		gradeCond.setCcdstatus("1");
		/**�������صȼ����ϻ�ȡ*/
		List<SOC0151Info> gradeList = soc0151BL.searchConfigurationCodeDetail(gradeCond);
		
		/**�����趨*/
		dto.setGradeList(gradeList);
		dto.setLevelList(levelList);
		return dto;
	}

}
