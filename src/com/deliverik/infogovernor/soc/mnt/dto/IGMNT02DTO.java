/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.mnt.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCond;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0112Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0206Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0207Form;
import com.deliverik.infogovernor.soc.mnt.model.SOC0306Info;
/**
 * ����:������ع���DTO
 * ����������
 * ������¼��
 */

@SuppressWarnings("serial")
public class IGMNT02DTO extends BaseDTO implements Serializable{
	/** ���ʻ���Ϣ */
	protected Locale locale;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** �������ݱ���form */
	protected IGMNT0112Form igmnt0112Form;
	
	protected IGMNT0206Form igmnt0206Form;
	
	protected IGMNT0207Form igmnt0207Form;
	
	/** �������ݱ���list */
	protected List<SOC0306Info> soc0306List;
	/**
	 * ������ع���list
	 */
	protected List<SOC0423Info> soc0423List;
	/**
	 * host list
	 */
	protected List<LabelValueBean> labelValueBeanList;
	
	/** ������־���� */
	protected SOC0305Info soc0305Info;
	
	/** ������־��ѯ�����ӿ�Bean	 */
	protected SOC0305SearchCond soc0305SearchCond;
	
	/**������־����List	 */
	protected List<SOC0305Info> soc0305List;
	
	protected List<SOC0307Info> soc0307List;
	
	/**��ѡ��澯id���� */
	protected String[] ids;
	
	/**�澯�ȼ����� */
	protected List<LabelValueBean> alarmSeverityList;
	
	/**CI���� */
	protected List<LabelValueBean> ciList;
	
	/**
	 * ����������Ϣ
	 */
	protected List<LabelValueBean> impTypeList;

	/**
	 * ���ʻ���Ϣȡ��
	 *
	 * @return locale ���ʻ���Ϣ
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * ���ʻ���Ϣ�趨
	 *
	 * @param locale ���ʻ���Ϣ
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return maxSearchCount ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����������趨
	 *
	 * @param maxSearchCount ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳ��DTOȡ��
	 *
	 * @return pagingDto ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 *
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}





	/**
	 * hostlistȡ��
	 *
	 * @return labelValueBeanList hostlist
	 */
	public List<LabelValueBean> getLabelValueBeanList() {
		return labelValueBeanList;
	}

	/**
	 * hostlist�趨
	 *
	 * @param labelValueBeanList hostlist
	 */
	public void setLabelValueBeanList(List<LabelValueBean> labelValueBeanList) {
		this.labelValueBeanList = labelValueBeanList;
	}

	/**
	 * ������־����ȡ��
	 *
	 * @return soc0305Info ������־����
	 */
	public SOC0305Info getSoc0305Info() {
		return soc0305Info;
	}

	/**
	 * ������־�����趨
	 *
	 * @param soc0305Info ������־����
	 */
	public void setSoc0305Info(SOC0305Info soc0305Info) {
		this.soc0305Info = soc0305Info;
	}

	/**
	 * ������־��ѯ�����ӿ�Beanȡ��
	 *
	 * @return soc0305SearchCond ������־��ѯ�����ӿ�Bean
	 */
	public SOC0305SearchCond getSoc0305SearchCond() {
		return soc0305SearchCond;
	}

	/**
	 * ������־��ѯ�����ӿ�Bean�趨
	 *
	 * @param soc0305SearchCond ������־��ѯ�����ӿ�Bean
	 */
	public void setSoc0305SearchCond(SOC0305SearchCond soc0305SearchCond) {
		this.soc0305SearchCond = soc0305SearchCond;
	}

	/**
	 * ������־����Listȡ��
	 *
	 * @return soc0305List ������־����List
	 */
	public List<SOC0305Info> getSoc0305List() {
		return soc0305List;
	}

	/**
	 * ������־����List�趨
	 *
	 * @param soc0305List ������־����List
	 */
	public void setSoc0305List(List<SOC0305Info> soc0305List) {
		this.soc0305List = soc0305List;
	}

	/**
	 * soc0307Listȡ��
	 *
	 * @return soc0307List soc0307List
	 */
	public List<SOC0307Info> getSoc0307List() {
		return soc0307List;
	}

	/**
	 * soc0307List�趨
	 *
	 * @param soc0307List soc0307List
	 */
	public void setSoc0307List(List<SOC0307Info> soc0307List) {
		this.soc0307List = soc0307List;
	}

	/**
	 * ��ѡ��澯id����ȡ��
	 *
	 * @return ids ��ѡ��澯id����
	 */
	public String[] getIds() {
		return ids;
	}

	/**
	 * ��ѡ��澯id�����趨
	 *
	 * @param ids ��ѡ��澯id����
	 */
	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
	 * �澯�ȼ�����ȡ��
	 *
	 * @return alarmSeverityList �澯�ȼ�����
	 */
	public List<LabelValueBean> getAlarmSeverityList() {
		return alarmSeverityList;
	}

	/**
	 * �澯�ȼ������趨
	 *
	 * @param alarmSeverityList �澯�ȼ�����
	 */
	public void setAlarmSeverityList(List<LabelValueBean> alarmSeverityList) {
		this.alarmSeverityList = alarmSeverityList;
	}

	/**
	 * CI����ȡ��
	 *
	 * @return ciList CI����
	 */
	public List<LabelValueBean> getCiList() {
		return ciList;
	}

	/**
	 * CI�����趨
	 *
	 * @param ciList CI����
	 */
	public void setCiList(List<LabelValueBean> ciList) {
		this.ciList = ciList;
	}

	/**
	 * ����������Ϣȡ��
	 *
	 * @return impTypeList ����������Ϣ
	 */
	public List<LabelValueBean> getImpTypeList() {
		return impTypeList;
	}

	/**
	 * ����������Ϣ�趨
	 *
	 * @param impTypeList ����������Ϣ
	 */
	public void setImpTypeList(List<LabelValueBean> impTypeList) {
		this.impTypeList = impTypeList;
	}

	/**
	 * �������ݱ���formȡ��
	 *
	 * @return igmnt0112Form �������ݱ���form
	 */
	public IGMNT0112Form getIgmnt0112Form() {
		return igmnt0112Form;
	}

	/**
	 * �������ݱ���form�趨
	 *
	 * @param igmnt0112Form �������ݱ���form
	 */
	public void setIgmnt0112Form(IGMNT0112Form igmnt0112Form) {
		this.igmnt0112Form = igmnt0112Form;
	}

	/**
	 * igmnt0206Formȡ��
	 *
	 * @return igmnt0206Form igmnt0206Form
	 */
	public IGMNT0206Form getIgmnt0206Form() {
		return igmnt0206Form;
	}

	/**
	 * igmnt0206Form�趨
	 *
	 * @param igmnt0206Form igmnt0206Form
	 */
	public void setIgmnt0206Form(IGMNT0206Form igmnt0206Form) {
		this.igmnt0206Form = igmnt0206Form;
	}

	/**
	 * igmnt0207Formȡ��
	 *
	 * @return igmnt0207Form igmnt0207Form
	 */
	public IGMNT0207Form getIgmnt0207Form() {
		return igmnt0207Form;
	}

	/**
	 * igmnt0207Form�趨
	 *
	 * @param igmnt0207Form igmnt0207Form
	 */
	public void setIgmnt0207Form(IGMNT0207Form igmnt0207Form) {
		this.igmnt0207Form = igmnt0207Form;
	}

	/**
	 * soc0423Listȡ��
	 *
	 * @return soc0423List soc0423List
	 */
	public List<SOC0423Info> getSoc0423List() {
		return soc0423List;
	}

	/**
	 * soc0423List�趨
	 *
	 * @param soc0423List soc0423List
	 */
	public void setSoc0423List(List<SOC0423Info> soc0423List) {
		this.soc0423List = soc0423List;
	}

	/**
	 * �������ݱ���listȡ��
	 *
	 * @return soc0306List �������ݱ���list
	 */
	public List<SOC0306Info> getSoc0306List() {
		return soc0306List;
	}

	/**
	 * �������ݱ���list�趨
	 *
	 * @param soc0306List �������ݱ���list
	 */
	public void setSoc0306List(List<SOC0306Info> soc0306List) {
		this.soc0306List = soc0306List;
	}


	
	
}
