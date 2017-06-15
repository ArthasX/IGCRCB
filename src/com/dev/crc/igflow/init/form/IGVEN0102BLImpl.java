/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.init.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;
import com.deliverik.infogovernor.asset.bl.task.RiskIndexSearchVWBL;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCondImpl;
import com.deliverik.infogovernor.ven.bl.task.MonitoringWorkBL;
import com.deliverik.infogovernor.ven.bl.task.RiskMonitoringBL;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;

/***
 * ���ָ�ɹ���������ڵ�ı���ʼ��
 * @time 2014/06/19
 * @author shikailong
 * @version 1.0
 * @mail shikailong@deliverik.com
 */
public class IGVEN0102BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGVEN0102BLImpl.class);
	
	/** ���ռ��BL*/
	private MonitoringWorkBL monitoringWorkBL;
	
	/** ���ռ������BL*/
	private RiskMonitoringBL riskMonitoringBL;
	
	/** ����ָ����ͼBL*/
	private RiskIndexSearchVWBL riskIndexSearchVWBL;
	
	/**
	 * ���ռ��BL�趨
	 * @param monitoringWorkBL the ���ռ��BL
	 */
	public void setMonitoringWorkBL(MonitoringWorkBL monitoringWorkBL) {
		this.monitoringWorkBL = monitoringWorkBL;
	}

	/**
	 * ����ָ����ͼBL�趨
	 * @param riskIndexSearchVWBL the ����ָ����ͼBL
	 */
	public void setRiskIndexSearchVWBL(RiskIndexSearchVWBL riskIndexSearchVWBL) {
		this.riskIndexSearchVWBL = riskIndexSearchVWBL;
	}

	/**
	 * ���ռ������BL�趨
	 * @param riskMonitoringBL the ���ռ������BL
	 */
	public void setRiskMonitoringBL(RiskMonitoringBL riskMonitoringBL) {
		this.riskMonitoringBL = riskMonitoringBL;
	}

	/**
	 * ���ռ��ָ�ɹ�������ڵ�ı���ʼ��
	 * @param param ���̴�������ӿ�
	 * @return ��ֵ���ϣ�<����-ֵ>��
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param)
			throws BLException {		
		log.debug("======== ���ռ��ָ�ɹ�����ʼ������ʼ   ========");
		//��ֵ���Ϸ��ض���
		Map<String, Object> map = new HashMap<String, Object>();
		//���������id��Ϊ�գ�˵�����������������Ǵӱ�����̷����
		String str =  param.getParameters();
		Pattern pattern = Pattern.compile("[0-9]*"); 
		if(StringUtils.isNotBlank(str) && pattern.matcher(str).matches()){
			Integer mtid = Integer.parseInt(str);
			MonitoringWorkInfo info = monitoringWorkBL.searchMonitoringWorkByPK(mtid);
			Integer eiid = info.getRiid();
			if(eiid!=null && !(eiid.equals("0"))){
				RiskIndexSearchVWSearchCondImpl cond = new RiskIndexSearchVWSearchCondImpl();
				cond.setEiid(eiid.toString());
				cond.setSyscoding("999019");
				List<RiskIndexSearchVWInfo> vwInfo = riskIndexSearchVWBL.searchRiskIndexSearchVW(cond);
				if(vwInfo!=null&& vwInfo.size()>0){
					map.put("ָ����", vwInfo.get(0).getEilabel());
					map.put("��������", vwInfo.get(0).getRiskly());
					map.put("������", vwInfo.get(0).getRiskitem());
					map.put("��������", vwInfo.get(0).getRiskarea());
					map.put("��Ա", vwInfo.get(0).getRiskarea());
				}
			}
			map.put("���ռ����������", riskMonitoringBL.searchRiskMonitoringByPK(info.getRmid()).getRmname());
		}
		log.debug("======== ���ռ��ָ�ɹ�������ʼ���������   ========");
		return map;
	}
}
