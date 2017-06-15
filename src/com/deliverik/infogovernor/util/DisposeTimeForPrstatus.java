 /*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.util;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;

/**
 * ��������״̬�д����˵Ĵ���ʱ��
 * 
 */
public class DisposeTimeForPrstatus {

	static Log log = LogFactory.getLog(DisposeTimeForPrstatus.class);

	/**
	 * ����״̬�����˵Ĵ���ʱ��
	 * 
	 * @param prid ����ID
	 * @param psdcode ����״̬
	 * @param confirm_flag �����Ƿ���ȷ�϶���ID
	 * @return Integer
	 */
	public static Integer getCountTime(Integer prid, String psdid, boolean confirm_flag) {
		//����״̬��Ϣ��ѯBL
		IG224BL ig224BL = (IG224BL)WebApplicationSupport.getBean("ig224BL");
		
		//��ѯ����״̬�����еĴ���ʱ��
		IG224SearchCondImpl cond224 = new IG224SearchCondImpl();
		//����ID
		cond224.setPrid(prid);
		//��ǰ״̬��ʶ
		cond224.setPsdid(psdid);
		//��ǰ������
		List<IG224Info> lstStatusLog = ig224BL.searchIG224Info(cond224, 0, 0);
		
		//���̴�����ʱ��
		long sumTime = 0;
		//��ȡ���̴�����ʱ��
		for (int i = 0; i < lstStatusLog.size(); i++) {
			//���̴���ʼʱ��
			Date openTime = lstStatusLog.get(i).getRslOpenTime();
			//���̴������ʱ��
			Date closeTime = lstStatusLog.get(i).getRslCloseTime();
			//�������ʱ��Ϊ�ռ�δ������� ����ǰϵͳʱ�����
			if (closeTime == null) {
				closeTime = new Date();
			}
			//���㴦����ʱ��ĺ�����
			sumTime += (closeTime.getTime() - openTime.getTime());
		}
		//��ȡ������ʱ�� ��λ�����ӣ�
		Integer minute = (int) (sumTime / (1000 * 60));
		return minute;
	}
}
