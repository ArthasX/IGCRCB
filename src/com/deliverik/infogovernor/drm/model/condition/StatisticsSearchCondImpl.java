package com.deliverik.infogovernor.drm.model.condition;
/**
 * ����: Ӧ������ģ��-ͳ�Ʒ�����ѯ�����ӿ�
 * ��������: Ӧ������ģ��-ͳ�Ʒ�����ѯ�����ӿ�
 * ������¼: 2015/02/28
 * �޸ļ�¼: 
 */
public class StatisticsSearchCondImpl implements StatisticsSearchCond {
	
	/**�Ǽ�ʱ����ʼ*/
	protected String eiinstimeFrom;
	/**�Ǽ�ʱ����ֹ*/
	protected String eiinstimeTo;
	/**����ͳ��ʱ��������ʼ*/
	protected String drillTimeFrom;
	/**����ͳ��ʱ��������ֹ*/
	protected String drillTimeTo;
	/**ר��Ԥ������*/
	protected String einame;
	/**�ʲ���*/
	protected String esyscoding;
	
	/**
	 *  eiinstimeFrom��ȡ
	 * @return  eiinstimeFrom
	 */
	public String getEiinstimeFrom() {
		return eiinstimeFrom;
	}
	/**
	 * eiinstimeFrom�趨
	 * @param eiinstimeFrom 
	 */
	public void setEiinstimeFrom(String eiinstimeFrom) {
		this.eiinstimeFrom = eiinstimeFrom;
	}
	/**
	 *  eiinstimeTo��ȡ
	 * @return  eiinstimeTo
	 */
	public String getEiinstimeTo() {
		return eiinstimeTo;
	}
	/**
	 * eiinstimeTo�趨
	 * @param eiinstimeTo 
	 */
	public void setEiinstimeTo(String eiinstimeTo) {
		this.eiinstimeTo = eiinstimeTo;
	}
	public String getDrillTimeFrom() {
		return drillTimeFrom;
	}
	public void setDrillTimeFrom(String drillTimeFrom) {
		this.drillTimeFrom = drillTimeFrom;
	}
	public String getDrillTimeTo() {
		return drillTimeTo;
	}
	public void setDrillTimeTo(String drillTimeTo) {
		this.drillTimeTo = drillTimeTo;
	}
	/**
	 * @return the ר��Ԥ������
	 */
	public String getEiname() {
		return einame;
	}
	/**
	 * @param ר��Ԥ������ the einame to set
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	/**
	 * @return the �ʲ���
	 */
	public String getEsyscoding() {
		return esyscoding;
	}
	/**
	 * @param �ʲ��� the esyscoding to set
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

}
