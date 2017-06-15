/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 流程处理Form
 * @Author  
 * @History 2010-9-13     新建 
 * 			2013-02-27	  修改	130225	流程支持分派机构相关修改
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0702Form extends BaseForm  {
	 protected 	String pvaltype;
	//设备型号 
	 protected  String  pvcatt;
	//	//到货设备时间
	 protected  String pvtime;
	//验收人
	 protected  String pvname;
	//验收设备时间
	 protected  String pvltime;
	//维保年限
	protected  String  pvlye;
	//保修开始时间
	 protected  String pvltimet;
		//保修结束时间
	 protected  String pvltimets;
	 protected  String  pvalnum;
	 protected  String einum;
	 
	 /** 设备ID */
		protected Integer eiid;
		
		/** 设备ID（文字） */
		protected String eiidStr;

		/** 资产模型ID */
		protected String eid;
		
		/** 资产模型ID（文字） */
		protected String eidStr;
		
		/** 资产模型编码 */
		protected String elabel;

		/** 资产模型名称 */
		protected String ename;

		/** 设备名称 */
		protected String einame;
		
		/** 设备编码 */
		protected String eilabel;

		/** 设备说明 */
		protected String eidesc;

		/** 设备状态 */
		protected String eistatus;

		/** 设备变更时间 */
		protected String eiupdtime;
		
		/** 设备版本号 */
		protected Integer eiversion;

		/** 设备登记日 */
		protected String eiinsdate;
		
		/** 编辑模式（登记/变更） */
		protected String mode = "0";
		
		/** 资产项所属机构*/
		protected String eiorgsyscoding;
		
		/** 资产项所属机构名称*/
		protected String eiorgname;
		
		/** 资产项所属模型*/
		protected String esyscoding;
		
		/** 资产管理人*/
		protected String eiuserid;
		
		/** 资产管理人姓名*/
		protected String eiusername;
		
		protected String fingerPrint;
		
		/** 资产小版本*/
		protected Integer eismallversion;

		
		/** 设备序列号*/
		
		public  String getPvalnum() {
			return pvalnum;
		}
		/** 设备序列号*/
		public  void setPvalnum(String pvalnum) {
			this.pvalnum = pvalnum;
		}
		/** 资产编码*/
		public  String getEinum() {
			return einum;
		}
		/** 资产编码*/
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
