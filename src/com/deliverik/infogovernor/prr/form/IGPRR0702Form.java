/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: ���̴���Form
 * @Author  
 * @History 2010-9-13     �½� 
 * 			2013-02-27	  �޸�	130225	����֧�ַ��ɻ�������޸�
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0702Form extends BaseForm  {
	 protected 	String pvaltype;
	//�豸�ͺ� 
	 protected  String  pvcatt;
	//	//�����豸ʱ��
	 protected  String pvtime;
	//������
	 protected  String pvname;
	//�����豸ʱ��
	 protected  String pvltime;
	//ά������
	protected  String  pvlye;
	//���޿�ʼʱ��
	 protected  String pvltimet;
		//���޽���ʱ��
	 protected  String pvltimets;
	 protected  String  pvalnum;
	 protected  String einum;
	 
	 /** �豸ID */
		protected Integer eiid;
		
		/** �豸ID�����֣� */
		protected String eiidStr;

		/** �ʲ�ģ��ID */
		protected String eid;
		
		/** �ʲ�ģ��ID�����֣� */
		protected String eidStr;
		
		/** �ʲ�ģ�ͱ��� */
		protected String elabel;

		/** �ʲ�ģ������ */
		protected String ename;

		/** �豸���� */
		protected String einame;
		
		/** �豸���� */
		protected String eilabel;

		/** �豸˵�� */
		protected String eidesc;

		/** �豸״̬ */
		protected String eistatus;

		/** �豸���ʱ�� */
		protected String eiupdtime;
		
		/** �豸�汾�� */
		protected Integer eiversion;

		/** �豸�Ǽ��� */
		protected String eiinsdate;
		
		/** �༭ģʽ���Ǽ�/����� */
		protected String mode = "0";
		
		/** �ʲ�����������*/
		protected String eiorgsyscoding;
		
		/** �ʲ���������������*/
		protected String eiorgname;
		
		/** �ʲ�������ģ��*/
		protected String esyscoding;
		
		/** �ʲ�������*/
		protected String eiuserid;
		
		/** �ʲ�����������*/
		protected String eiusername;
		
		protected String fingerPrint;
		
		/** �ʲ�С�汾*/
		protected Integer eismallversion;

		
		/** �豸���к�*/
		
		public  String getPvalnum() {
			return pvalnum;
		}
		/** �豸���к�*/
		public  void setPvalnum(String pvalnum) {
			this.pvalnum = pvalnum;
		}
		/** �ʲ�����*/
		public  String getEinum() {
			return einum;
		}
		/** �ʲ�����*/
		public  void setEinum(String einum) {
			this.einum = einum;
		}

		public String getPvaltype() {
			return pvaltype;
		}

		public void setPvaltype(String pvaltype) {
			this.pvaltype = pvaltype;
		}

		public String getPvcatt() {
			return pvcatt;
		}

		public void setPvcatt(String pvcatt) {
			this.pvcatt = pvcatt;
		}

		public String getPvtime() {
			return pvtime;
		}

		public void setPvtime(String pvtime) {
			this.pvtime = pvtime;
		}

		public String getPvname() {
			return pvname;
		}

		public void setPvname(String pvname) {
			this.pvname = pvname;
		}

		public String getPvltime() {
			return pvltime;
		}

		public void setPvltime(String pvltime) {
			this.pvltime = pvltime;
		}

		public String getPvlye() {
			return pvlye;
		}

		public void setPvlye(String pvlye) {
			this.pvlye = pvlye;
		}

		public String getPvltimet() {
			return pvltimet;
		}

		public void setPvltimet(String pvltimet) {
			this.pvltimet = pvltimet;
		}

		public String getPvltimets() {
			return pvltimets;
		}

		public void setPvltimets(String pvltimets) {
			this.pvltimets = pvltimets;
		}

		public Integer getEiid() {
			if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
				return null;
			} else {
				return Integer.valueOf(this.eiidStr);
			}
			
		}

		public void setEiid(Integer eiid) {
			this.eiid = eiid;
		}

		public String getEiidStr() {
			return eiidStr;
		}

		public void setEiidStr(String eiidStr) {
			this.eiidStr = eiidStr;
		}

		public String getEid() {
			return eid;
		}

		public void setEid(String eid) {
			this.eid = eid;
		}

		public String getEidStr() {
			return eidStr;
		}

		public void setEidStr(String eidStr) {
			this.eidStr = eidStr;
		}

		public String getElabel() {
			return elabel;
		}

		public void setElabel(String elabel) {
			this.elabel = elabel;
		}

		public String getEname() {
			return ename;
		}

		public void setEname(String ename) {
			this.ename = ename;
		}

		public String getEiname() {
			return einame;
		}

		public void setEiname(String einame) {
			this.einame = einame;
		}

		public String getEilabel() {
			return eilabel;
		}

		public void setEilabel(String eilabel) {
			this.eilabel = eilabel;
		}

		public String getEidesc() {
			return eidesc;
		}

		public void setEidesc(String eidesc) {
			this.eidesc = eidesc;
		}

		public String getEistatus() {
			return eistatus;
		}

		public void setEistatus(String eistatus) {
			this.eistatus = eistatus;
		}

		public String getEiupdtime() {
			return eiupdtime;
		}

		public void setEiupdtime(String eiupdtime) {
			this.eiupdtime = eiupdtime;
		}

		public Integer getEiversion() {
			return eiversion;
		}

		public void setEiversion(Integer eiversion) {
			this.eiversion = eiversion;
		}

		public String getEiinsdate() {
			return eiinsdate;
		}

		public void setEiinsdate(String eiinsdate) {
			this.eiinsdate = eiinsdate;
		}

		public String getMode() {
			return mode;
		}

		public void setMode(String mode) {
			this.mode = mode;
		}

		public String getEiorgsyscoding() {
			return eiorgsyscoding;
		}

		public void setEiorgsyscoding(String eiorgsyscoding) {
			this.eiorgsyscoding = eiorgsyscoding;
		}

		public String getEiorgname() {
			return eiorgname;
		}

		public void setEiorgname(String eiorgname) {
			this.eiorgname = eiorgname;
		}

		public String getEsyscoding() {
			return esyscoding;
		}

		public void setEsyscoding(String esyscoding) {
			this.esyscoding = esyscoding;
		}

		public String getEiuserid() {
			return eiuserid;
		}

		public void setEiuserid(String eiuserid) {
			this.eiuserid = eiuserid;
		}

		public String getEiusername() {
			return eiusername;
		}

		public void setEiusername(String eiusername) {
			this.eiusername = eiusername;
		}

		public String getFingerPrint() {
			return fingerPrint;
		}

		public void setFingerPrint(String fingerPrint) {
			this.fingerPrint = fingerPrint;
		}

		public Integer getEismallversion() {
			return eismallversion;
		}

		public void setEismallversion(Integer eismallversion) {
			this.eismallversion = eismallversion;
		}
	 

}
