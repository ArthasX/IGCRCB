/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.igflow.parameter.WorkFlowLogInfo;

/**
 * ����: ǰ�����������ӿ�
 * ��������: ǰ�����������ӿ�
 * ������¼: 2012/04/13
 * �޸ļ�¼: 
 */
public interface WorkFlowStatusEventBeanInfo {
	
		/**
		 * ���̶���ID�������汾��Ϣ��ȡ��
		 * @return ���̶���ID�������汾��Ϣ��
		 */
		public String getPdid();
		
		/**
		 * ����ťIDȡ��
		 * @return ����ťID
		 */
		public String getPbdid();
		
		/**
		 * ԾǨǰ״̬��ʶȡ��
		 * @return ԾǨǰ״̬��ʶ
		 */
		public String getBfstatus();
		
		/**
		 * ԾǨ��״̬��ʶȡ��
		 * @return ԾǨ��״̬��ʶ
		 */
		public String getAfstatus();
		
		/**
		 * ���̷�����IDȡ��
		 * @return ���̷�����ID
		 */
		public String getCrtuserid();
		
		/**
		 * ���̷����ɫIDȡ��
		 * @return ���̷����ɫID
		 */
		public Integer getCrtroleid();
		
		/**
		 * ��̬��֧���ȡ��
		 * @return psdnum ��̬��֧���
		 */
		public Integer getPsdnum();
		
		/**
		 * ��־������Ϣȡ��
		 * 
		 * @return ��־������Ϣ
		 */
		public WorkFlowLogInfo getLogInfo();

}
