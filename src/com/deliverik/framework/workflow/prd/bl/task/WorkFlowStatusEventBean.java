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
public class WorkFlowStatusEventBean implements WorkFlowStatusEventBeanInfo {
	
		/** ���̶���ID�������汾��Ϣ�� */
		protected String pdid;
		
		/** ����ťID */
		protected String pbdid;
		
		/** ԾǨǰ״̬��ʶ */
		protected String bfstatus;
		
		/** ԾǨ��״̬��ʶ */
		protected String afstatus;
		
		/** ԾǨǰ״̬��ʶ��� */
		protected String bfstatusnum;
		
		/** ԾǨ��״̬��ʶ��� */
		protected String afstatusnum;
		
		/** ���̷�����ID */
		protected String crtuserid;
		
		/** ���̷����ɫID */
		protected Integer crtroleid;
		
		/** ��̬��֧��� */
		protected Integer psdnum;
		
		/** ��־������Ϣ */
		protected WorkFlowLogInfo logInfo;

		/**
		 * ���̶���ID�������汾��Ϣ��ȡ��
		 * @return ���̶���ID�������汾��Ϣ��
		 */
		public String getPdid() {
			return pdid;
		}

		/**
		 * ���̶���ID�������汾��Ϣ���趨
		 * 
		 * @param pdid ���̶���ID�������汾��Ϣ��
		 */
		public void setPdid(String pdid) {
			this.pdid = pdid;
		}

		/**
		 * ����ťIDȡ��
		 * @return ����ťID
		 */
		public String getPbdid() {
			return pbdid;
		}

		/**
		 * ����ťID�趨
		 * 
		 * @param pbdid ����ťID
		 */
		public void setPbdid(String pbdid) {
			this.pbdid = pbdid;
		}

		/**
		 * ԾǨǰ״̬��ʶȡ��
		 * @return ԾǨǰ״̬��ʶ
		 */
		public String getBfstatus() {
			return bfstatus;
		}

		/**
		 * ԾǨǰ״̬��ʶ�趨
		 * 
		 * @param bfstatus ԾǨǰ״̬��ʶ
		 */
		public void setBfstatus(String bfstatus) {
			this.bfstatus = bfstatus;
		}

		/**
		 * ԾǨ��״̬��ʶȡ��
		 * @return ԾǨ��״̬��ʶ
		 */
		public String getAfstatus() {
			return afstatus;
		}

		/**
		 * ԾǨ��״̬��ʶ�趨
		 * 
		 * @param afstatus ԾǨ��״̬��ʶ
		 */
		public void setAfstatus(String afstatus) {
			this.afstatus = afstatus;
		}
		
		/**
		 * ԾǨǰ״̬��ʶ���ȡ��
		 * @return ԾǨǰ״̬��ʶ���
		 */
		public String getBfstatusnum() {
			return bfstatusnum;
		}
		
		/**
		 * ԾǨǰ״̬��ʶ����趨
		 * 
		 * @param bfstatus ԾǨǰ״̬��ʶ���
		 */
		public void setBfstatusnum(String bfstatusnum) {
			this.bfstatusnum = bfstatusnum;
		}
		
		/**
		 * ԾǨ��״̬��ʶ���ȡ��
		 * @return ԾǨ��״̬��ʶ���
		 */
		public String getAfstatusnum() {
			return afstatusnum;
		}
		
		/**
		 * ԾǨ��״̬��ʶ����趨
		 * 
		 * @param afstatus ԾǨ��״̬��ʶ���
		 */
		public void setAfstatusnum(String afstatusnum) {
			this.afstatusnum = afstatusnum;
		}

		/**
		 * ���̷�����IDȡ��
		 * @return ���̷�����ID
		 */
		public String getCrtuserid() {
			return crtuserid;
		}

		/**
		 * ���̷�����ID�趨
		 * 
		 * @param crtuserid ���̷�����ID
		 */
		public void setCrtuserid(String crtuserid) {
			this.crtuserid = crtuserid;
		}

		/**
		 * ���̷����ɫIDȡ��
		 * @return ���̷����ɫID
		 */
		public Integer getCrtroleid() {
			return crtroleid;
		}

		/**
		 * ���̷����ɫID�趨
		 * 
		 * @param crtroleid ���̷����ɫID
		 */
		public void setCrtroleid(Integer crtroleid) {
			this.crtroleid = crtroleid;
		}

		/**
		 * ��̬��֧���ȡ��
		 * @return psdnum ��̬��֧���
		 */
		public Integer getPsdnum() {
			return psdnum;
		}

		/**
		 * ��̬��֧����趨
		 * @param psdnum ��̬��֧���
		 */
		public void setPsdnum(Integer psdnum) {
			this.psdnum = psdnum;
		}

		/**
		 * ��־������Ϣȡ��
		 * 
		 * @return ��־������Ϣ
		 */
		public WorkFlowLogInfo getLogInfo() {
			return logInfo;
		}

		/**
		 * ��־������Ϣ�趨
		 * 
		 * @param logInfo ��־������Ϣ
		 */
		public void setLogInfo(WorkFlowLogInfo logInfo) {
			this.logInfo = logInfo;
		}
		
}
