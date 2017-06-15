package com.deliverik.infogovernor.ram.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.infogovernor.ram.bl.task.AssessmentScoreVWBL;
import com.deliverik.infogovernor.ram.dto.IGRAM02DTO;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;
import com.deliverik.infogovernor.ram.model.condition.AssessmentScoreVWSearchCondImpl;
import com.deliverik.infogovernor.ram.model.entity.AssessmentScoreVW;

/**
 * ���ռ��ҵ���߼�ʵ��
 *
 */

public class IGRAM02BLImpl extends BaseBLImpl implements IGRAM02BL {

	static Log log = LogFactory.getLog(IGRAM02BLImpl.class);

	/** ���ռ����ϢBL */
	protected AssessmentScoreVWBL assessmentScoreVWBL;
	
	/** ����BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** ����BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/**
	 * assessmentScoreBL�趨
	 */
	public void setAssessmentScoreVWBL(AssessmentScoreVWBL assessmentScoreVWBL) {
		this.assessmentScoreVWBL = assessmentScoreVWBL;
	}
	
	/**
	 * workFlowOperationBL�趨
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * workFlowDefinitionBL�趨
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * ����������ʷ���ֲ�ѯ
	 * 
	 * @param dto ��������
	 * @return ��������б�
	 */
	public IGRAM02DTO searchAssessmentScoreHistory(IGRAM02DTO dto)
			throws BLException {
		//������Ŀ����map
		Map<String,List<IG007Info>> prjMap = new LinkedHashMap<String,List<IG007Info>>();
		
		log.debug("================�������������ͷ����ѯ����ʼ===================");
		//��ȡ������
		List<IG007Info> prjList = new ArrayList<IG007Info>();
		IG007SearchCondImpl ig007SearchCond = new IG007SearchCondImpl();
		ig007SearchCond.setPdid(dto.getPdid());
		prjList = workFlowDefinitionBL.searchProcessInfoDef(ig007SearchCond);
				//searchProcessInfoDefByCond(ig007SearchCond);
		//��ѯ���е����ַ���
		List <String> typePrjList = new ArrayList<String>();
		for (IG007Info info : prjList){
			if(info.getPidunit() != null && !typePrjList.contains(info.getPidunit())){
				typePrjList.add(info.getPidunit());
			}
		}
		//��װprjMap
		
		for(String info : typePrjList){
			List <IG007Info> typePrjsList = new ArrayList<IG007Info>();
			for(IG007Info prjinfo :prjList){
				if( info.equals(prjinfo.getPidunit())){
					typePrjsList.add(prjinfo);
				}
			}
			prjMap.put(info,typePrjsList );
		}
		log.debug("================�������������ͷ����ѯ�������===================");
		log.debug("================������ֲ����˲�ѯ����ʼ===================");
		//���ֲ�����Ա��ѯ
		IG337SearchCondImpl ig337Cond = new IG337SearchCondImpl();
		ig337Cond.setPrid(Integer.parseInt(dto.getPrid()));
		//�������״̬
		ig337Cond.setPpstatus("X");
		List<IG337Info> ig337List = workFlowOperationBL.searchProcessParticipants(ig337Cond);
		 //ig337BL.searchIG337InfoRun(ig337Cond);
		log.debug("================������ֲ����˲�ѯ�������===================");
		
		List<AssessmentScoreVWInfo> scoreList=new ArrayList<AssessmentScoreVWInfo>();
		//��δ��ֵ���һ��Ĭ��ֵ 0
		List<IG007Info> removeList = new ArrayList<IG007Info>();
		for (IG007Info info : prjList){
			if(info.getPidunit() == null){
				removeList.add(info);
			}
		}
		prjList.removeAll(removeList);
		
		for (IG337Info info :ig337List){
			AssessmentScoreVWSearchCondImpl cond = new AssessmentScoreVWSearchCondImpl();
			cond.setPrid(Integer.parseInt(dto.getPrid()));
			cond.setUserid(info.getPpuserid());
			//��ѯָ�����̵����ּ�¼
			List<AssessmentScoreVWInfo> list = assessmentScoreVWBL.searchAssessmentScore(cond);
			if(list.size()>0){
				for(AssessmentScoreVWInfo as:list){
					scoreList.add(as);
				}
			}else{
				for(IG007Info cd:prjList){
					//����û�������������ٶ���
					AssessmentScoreVW as1 = new AssessmentScoreVW();
					as1.setPidid(cd.getPidid());
					as1.setPiid(cd.getPiid());
					as1.setPivarlabel(cd.getPidlabel());
					as1.setUserid(info.getPpuserid());
					as1.setPpivalue("0");
					as1.setPpicommect("");
					scoreList.add(as1);
				}
			}
		}
		dto.setPrjMap(prjMap);
		dto.setPpList(ig337List);
		dto.setHistoryScoreList(scoreList);
		return dto;
	}



}
