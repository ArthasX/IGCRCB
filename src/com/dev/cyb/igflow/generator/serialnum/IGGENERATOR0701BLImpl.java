package com.dev.cyb.igflow.generator.serialnum;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowSerialnumGeneratorBL;

public class IGGENERATOR0701BLImpl extends BaseBLImpl implements
		WorkFlowSerialnumGeneratorBL {

	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	/**
	 * ע��flowSearchBL
	 * @param flowSearchBL
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
	    // ���幤�������ʼ�ַ�-ָ�ɹ���
        String processType = "AW";
        
        // ��ȡ��ǰ����
        Calendar date = Calendar.getInstance();
        String sermonth = StringUtils.leftPad(String.valueOf(date.get(Calendar.MONTH) + 1), 2, "0");        //��
        String serday = StringUtils.leftPad(String.valueOf(date.get(Calendar.DAY_OF_MONTH)), 2, "0");   //��
        
        // ������Ź���I + �꣨����λ�� + �£���λ�� + �գ���λ�� + ��λ˳�����
        StringBuffer serialNum = new StringBuffer();
        serialNum.append(processType);
        serialNum.append(String.valueOf(date.get(Calendar.YEAR)));
        serialNum.append(sermonth);
        serialNum.append(serday);
        
        String maxSerialNum = flowSearchBL.searchMaxSerialnum(String.valueOf(serialNum));
        if (null == maxSerialNum) {
            return serialNum + StringUtils.leftPad("1", 2, "0");
        }
        String num = "";
        num = maxSerialNum.substring(10);
        
        int maxNumber = Integer.valueOf(num) + 1;
        serialNum.append(StringUtils.leftPad(String.valueOf(maxNumber), 2, "0"));
        
        return String.valueOf(serialNum);
	}

}