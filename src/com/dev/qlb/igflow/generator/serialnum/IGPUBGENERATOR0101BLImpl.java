/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.qlb.igflow.generator.serialnum;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowSerialnumGeneratorBL;


/**
 * ͨ�ù�����������
 *
 * 2015-4-16
 */
public class IGPUBGENERATOR0101BLImpl extends BaseBLImpl implements
		WorkFlowSerialnumGeneratorBL {
	
	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	/**
	 * ��ѯ�๦��API���趨
	 * @param flowSearchBL ��ѯ�๦��API��
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * ���̹��������ɴ���
	 * 
	 * @param ����ID
	 * @return ���̹�����
	 * @throws BLException
	 */
	public String serialnumGenerator(Integer prid) throws BLException {
		
		//��������ID��ѯ���̻�����Ϣ
		List<ProcessRecordInfo> lst_ProcessInfo = this.flowSearchBL.searchProcessInfo(prid, null);
		String prpdid = lst_ProcessInfo.get(0).getPrpdid();
	   
		// ���幤�������ʼ�ַ�
        String processType = "WD";
        if(IGPUBGENERATORType.SERIALNUM_MAP.get(prpdid.substring(0,5)) != null){
        	processType = IGPUBGENERATORType.SERIALNUM_MAP.get(prpdid.substring(0,5));
        }
        
        // ��ȡ��ǰ����
        String date = IGStringUtils.getCurrentDate();
        // ������Ź��򣬱�� + YYYYMMDD + ��λ˳�����
        StringBuffer serialNum = new StringBuffer();
        serialNum.append(processType);
        serialNum.append(date.replaceAll("/", ""));
        
        String maxSerialNum = flowSearchBL.searchMaxSerialnum(String.valueOf(serialNum));
        //��󹤵���Ϊ��ʱ��˳���Ĭ��Ϊ01
        if (null == maxSerialNum) {
            return serialNum + StringUtils.leftPad("1", 2, "0");
        }
        
       //��󹤵��Ų�Ϊ��ʱ��˳��ż�1
        String num = "";
        num = maxSerialNum.substring(maxSerialNum.length()-2);
        
        int maxNumber = Integer.valueOf(num) + 1;
        serialNum.append(StringUtils.leftPad(String.valueOf(maxNumber), 2, "0"));
        
        return String.valueOf(serialNum);
	}
}
