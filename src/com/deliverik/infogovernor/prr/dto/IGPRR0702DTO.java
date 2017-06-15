/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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

	/** Json�ַ��� */
	private String json;
	/** �ʲ�ģ��������Ϣ�������� */
	private SOC0109SearchCond soc0109SearchCond;
	/** �ʲ�������Ϣ�������� */
	private SOC0107SearchCond soc0107SearchCond;
	/** �ʲ�ģ��������Ϣ����� */
	private List<SOC0109Info> soc0109Infos;
	/** �ʲ�������Ϣ����� */
	private List<SOC0107Info> soc0107Infos;

	protected IGPRR0702Form igprr0702Form;

	public IGPRR0702Form getIgprr0702Form() {
		return igprr0702Form;
	}

	public void setIgprr0702Form(IGPRR0702Form igprr0702Form) {
		this.igprr0702Form = igprr0702Form;
	}
     //ѭ���Ĵ���
	  protected  String tn;
//		//�豸�ͺ� 
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
	// �Ǽ��ʲ���Ϣ�趨 
	 protected	SOC0117Info entity;
		/** �ʲ���Ϣ���������� */
		protected int maxSearchCount;
		 protected  String  pvalnum;
		 protected  String einum;
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
		/** Json�ַ��� */

	public String getJson() {
			return json;
		}
	/** Json�ַ��� */
		public void setJson(String json) {
			this.json = json;
		}
		/** �ʲ�ģ��������Ϣ�������� */
		public SOC0109SearchCond getSoc0109SearchCond() {
			return soc0109SearchCond;
		}
		/** �ʲ�ģ��������Ϣ�������� */
		public void setSoc0109SearchCond(SOC0109SearchCond soc0109SearchCond) {
			this.soc0109SearchCond = soc0109SearchCond;
		}
		/** �ʲ�������Ϣ�������� */
		public SOC0107SearchCond getSoc0107SearchCond() {
			return soc0107SearchCond;
		}
		/** �ʲ�������Ϣ�������� */
		public void setSoc0107SearchCond(SOC0107SearchCond soc0107SearchCond) {
			this.soc0107SearchCond = soc0107SearchCond;
		}
		/** �ʲ�ģ��������Ϣ����� */
		public List<SOC0109Info> getSoc0109Infos() {
			return soc0109Infos;
		}
		/** �ʲ�ģ��������Ϣ����� */
		public void setSoc0109Infos(List<SOC0109Info> soc0109Infos) {
			this.soc0109Infos = soc0109Infos;
		}
		/** �ʲ�������Ϣ����� */
		public List<SOC0107Info> getSoc0107Infos() {
			return soc0107Infos;
		}
		/** �ʲ�������Ϣ����� */
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