/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;
import com.deliverik.infogovernor.prr.form.IGPRR0702Form;

@SuppressWarnings("serial")
public class IGPRR0702DTO extends BaseDTO implements Serializable{

	/** Json字符串 */
	private String json;
	/** 资产模型属性信息检索条件 */
	private SOC0109SearchCond soc0109SearchCond;
	/** 资产属性信息检索条件 */
	private SOC0107SearchCond soc0107SearchCond;
	/** 资产模型属性信息结果集 */
	private List<SOC0109Info> soc0109Infos;
	/** 资产属性信息结果集 */
	private List<SOC0107Info> soc0107Infos;

	protected IGPRR0702Form igprr0702Form;

	public IGPRR0702Form getIgprr0702Form() {
		return igprr0702Form;
	}

	public void setIgprr0702Form(IGPRR0702Form igprr0702Form) {
		this.igprr0702Form = igprr0702Form;
	}
     //循环的次数
	  protected  String tn;
//		//设备型号 
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
	// 登记资产信息设定 
	 protected	SOC0117Info entity;
		/** 资产信息最大检索件数 */
		protected int maxSearchCount;
		 protected  String  pvalnum;
		 protected  String einum;
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
		/** Json字符串 */

	public String getJson() {
			return json;
		}
	/** Json字符串 */
		public void setJson(String json) {
			this.json = json;
		}
		/** 资产模型属性信息检索条件 */
		public SOC0109SearchCond getSoc0109SearchCond() {
			return soc0109SearchCond;
		}
		/** 资产模型属性信息检索条件 */
		public void setSoc0109SearchCond(SOC0109SearchCond soc0109SearchCond) {
			this.soc0109SearchCond = soc0109SearchCond;
		}
		/** 资产属性信息检索条件 */
		public SOC0107SearchCond getSoc0107SearchCond() {
			return soc0107SearchCond;
		}
		/** 资产属性信息检索条件 */
		public void setSoc0107SearchCond(SOC0107SearchCond soc0107SearchCond) {
			this.soc0107SearchCond = soc0107SearchCond;
		}
		/** 资产模型属性信息结果集 */
		public List<SOC0109Info> getSoc0109Infos() {
			return soc0109Infos;
		}
		/** 资产模型属性信息结果集 */
		public void setSoc0109Infos(List<SOC0109Info> soc0109Infos) {
			this.soc0109Infos = soc0109Infos;
		}
		/** 资产属性信息结果集 */
		public List<SOC0107Info> getSoc0107Infos() {
			return soc0107Infos;
		}
		/** 资产属性信息结果集 */
		public void setSoc0107Infos(List<SOC0107Info> soc0107Infos) {
			this.soc0107Infos = soc0107Infos;
		}

	public String getTn() {
			return tn;
		}

		public void setTn(String tn) {
			this.tn = tn;
		}

	public int getMaxSearchCount() {
			return maxSearchCount;
		}

		public void setMaxSearchCount(int maxSearchCount) {
			this.maxSearchCount = maxSearchCount;
		}

	public String getPvcatt() {
		return pvcatt;
	}

	public SOC0117Info getEntity() {
		return entity;
	}

	public void setEntity(SOC0117Info entity) {
		this.entity = entity;
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



	
	 
	
}