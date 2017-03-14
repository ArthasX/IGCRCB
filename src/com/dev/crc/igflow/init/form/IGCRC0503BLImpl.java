/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.init.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;

/**
 * <p>
 * ��������    ����״̬��ֵ��ʼ��
 * </p>
 */
public class IGCRC0503BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGCRC0503BLImpl.class);
	
	/** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;
    
    /** ϵͳ�๦��API�� */
    private SysManageBL sysManageBL;
    
    /**
     * @param ��ѯ�๦��API�� the flowSearchBL to set
     */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }
    
    /**
     * @param ϵͳ�๦��API�� the flowSearchBL to set
     */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * ����״̬��ֵ��ʼ��
	 * 
	 * @param param ���̴�������ӿ�
	 * @return ��ֵ���ϣ�<����-ֵ>��
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param) throws BLException {
		log.debug("======== �����������̴�����ڵ��ʼ������ʼ========");
		Map<String, Object> map = new HashMap<String, Object>();
		if(param.getParprid() != null){
			List<ProcessRecordInfo> process = flowSearchBL.searchProcessInfo(param.getParprid(), null);
			for (ProcessRecordInfo prInfo : process) {
				map.put("������������", prInfo.getPrdesc());
			}
		}
		
//		String userid = param.getPruserid();
//		
//		List<Integer> roleList = sysManageBL.searchRoleListByUserid(userid);
//		
//		String isCentreRole = "��";
//		
//		for (Integer roleid : roleList) {
//			String rolename = sysManageBL.searchRoleInfo(roleid).getRolename();
//			if ("���ĸ�����".equals(rolename)) {
//				isCentreRole = "��";
//			}
//		}
//		
//		map.put("�Ƿ����ĸ�����", isCentreRole);
		
		log.debug("======== �����������̴�����ڵ��ʼ���������========");
		return map;
		
	}

}
