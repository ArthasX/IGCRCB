/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: �������յ��ϵģ�ͼ�������ʵ��
  * ��������: �������յ��ϵģ�ͼ�������ʵ��
  * ������¼: 2014/07/23
  * �޸ļ�¼: 
  */
public class CheckToRiskRelateVWSearchCondImpl implements
		CheckToRiskRelateVWSearchCond {

		/**�����ID*/
		protected String eiid;

		/**
		 * �����IDȡ��
		 * @return eiid �����ID
		 */
		public String getEiid() {
			return eiid;
		}

		/**
		 * �����ID�趨
		 * @param eiid �����ID
		 */
		public void setEiid(String eiid) {
			this.eiid = eiid;
		}
}