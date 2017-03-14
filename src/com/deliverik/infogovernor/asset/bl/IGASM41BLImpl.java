/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.bl.task.CheckVWBL;
import com.deliverik.infogovernor.asset.bl.task.RiskVWBL;
import com.deliverik.infogovernor.asset.dto.IGASM41DTO;
import com.deliverik.infogovernor.asset.model.CheckVWInfo;
import com.deliverik.infogovernor.asset.model.RiskVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckVWCondImpl;
import com.deliverik.infogovernor.asset.model.condition.RiskVWCondImpl;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ռ��ͳ��ҵ���߼�ʵ��
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class IGASM41BLImpl extends BaseBLImpl implements IGASM41BL {
	
	static Log log = LogFactory.getLog(IGASM41BLImpl.class);
	
	/** ���ռ��ͳ��(����)BL */
	protected CheckVWBL checkVWBL;
	
	/** ���ռ��ͳ��(���)BL */
	protected RiskVWBL riskVWBL;

	/**
	 * ���ռ��ͳ��(����)BL�趨
	 * @param checkVWBL ���ռ��ͳ��(����)BL
	 */
	public void setCheckVWBL(CheckVWBL checkVWBL) {
		this.checkVWBL = checkVWBL;
	}

	/**
	 * ���ռ��ͳ��(���)BL�趨
	 * @param riskVWBL ���ռ��ͳ��(���)BL
	 */
	public void setRiskVWBL(RiskVWBL riskVWBL) {
		this.riskVWBL = riskVWBL;
	}

	public IGASM41DTO searchEntityItemAction(IGASM41DTO dto) throws BLException {
		log.debug("========���ռ��ͳ�Ʋ�ѯ����ʼ========");
		//���ղ�ѯ����
		RiskVWCondImpl riskCond = new RiskVWCondImpl();
		//��ѯ������Ϣ�б�
		List<RiskVWInfo> riskList = riskVWBL.findByCond(riskCond);
		if(!riskList.isEmpty()){
			//��riskListװ��Map
			TreeMap<String,List<RiskVWInfo>> riskMap = new TreeMap<String,List<RiskVWInfo>>();
			for(RiskVWInfo risk:riskList ){
				if(riskMap.containsKey(risk.getSyscoding())){
					List<RiskVWInfo> list = riskMap.get(risk.getSyscoding());
					list.add(risk);
					riskMap.put(risk.getSyscoding(), list);
				}else{
					List<RiskVWInfo> list = new ArrayList<RiskVWInfo>();
					list.add(risk);
					riskMap.put(risk.getSyscoding(), list);
				}
			}
			//ƴ�Ӷ��syscoding
			StringBuffer sb = new StringBuffer();
			for(String key:riskMap.keySet()){
				sb.append(key).append(",");
			}
			//��checkListװ��Map
			TreeMap<String,List<CheckVWInfo>> checkMap = new TreeMap<String,List<CheckVWInfo>>();
			if(StringUtils.isNotEmpty(sb.toString())){
				//����ѯ����
				CheckVWCondImpl checkCond = new CheckVWCondImpl();
				checkCond.setSyscoding(sb.toString().substring(0, sb.length()-1));
				//��ѯ�����Ϣ�б�
				List<CheckVWInfo> checkList = checkVWBL.findByCond(checkCond);
				for(CheckVWInfo check:checkList ){
					if(checkMap.containsKey(check.getSyscoding())){
						List<CheckVWInfo> list = checkMap.get(check.getSyscoding());
						list.add(check);
						checkMap.put(check.getSyscoding(), list);
					}else{
						List<CheckVWInfo> list = new ArrayList<CheckVWInfo>();
						list.add(check);
						checkMap.put(check.getSyscoding(), list);
					}
				}
			}
			//��riskMap��checkMap��Ӧװ��riskCheckMap
			LinkedHashMap<List<RiskVWInfo>,List<CheckVWInfo>> riskCheckMap = new LinkedHashMap<List<RiskVWInfo>,List<CheckVWInfo>>();
			for(String key:riskMap.keySet()){
				if(checkMap.containsKey(key)){
					riskCheckMap.put(riskMap.get(key), checkMap.get(key));
				}else{
					riskCheckMap.put(riskMap.get(key), null);
				}
			}
			dto.setRiskCheckMap(riskCheckMap);
		}
		log.debug("========���ռ��ͳ�Ʋ�ѯ��������========");
		return dto;
	}

}
