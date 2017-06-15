/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.form.IGSMR0302Form;
import com.deliverik.infogovernor.smr.form.IGSMR0303Form;
import com.deliverik.infogovernor.smr.form.IGSMR0304Form;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;
import com.deliverik.infogovernor.smr.model.ReportHistorySearchVWInfo;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;
import com.deliverik.infogovernor.smr.model.entity.ReportHistorySearchVW;

/**
 * ����:�ҵ�����걨����ѯ 
 * �����������ҵ�����걨����ѯ 
 * �����ˣ�����͢
 * ������¼�� 2013-07-25
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR03DTO extends BaseDTO {

	/** �û���Ϣ */
	protected User user;
	
	/** �걨��ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_arq;
	
	/** �걨һ��������ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_first;
	
	/** �걨����������ѯ���*/
	protected List<RegulatoryReportInstanceInfo> second_list;
	
	/** ��鿴form*/
	protected IGSMR0302Form igSMR0302Form;
	
	/** ��ʱ����form*/
	protected IGSMR0303Form igSMR0303Form;
	
	/** ��鿴��ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_see;
	
	/** �걨��ʱ���Ѳ�ѯ���*/
	protected RemindConfigureInfo rc;
	
	/** һ���ȶ�ʱ���Ѳ�ѯ���*/
	protected RemindConfigureInfo rc1;
	
	/** �����ȶ�ʱ���Ѳ�ѯ���*/
	protected RemindConfigureInfo rc2;
	
	/** �����ȶ�ʱ���Ѳ�ѯ���*/
	protected RemindConfigureInfo rc3;
	
	/** �ļ��ȶ�ʱ���Ѳ�ѯ���*/
	protected RemindConfigureInfo rc4;
	
	/** ��ҳ��������ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_more;
	
	/** ͨ�ò�ѯform*/
	protected IGSMR0304Form igsmr0304Form;
	
	protected int maxSearchCount;
	protected PagingDTO pagingDto;
	
	/** ͨ�ò�ѯ���*/
	protected List<ReportHistorySearchVW> list_rhs;
	/**
	 * �û���Ϣȡ��
	 * 
	 * @return �û���Ϣ
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û���Ϣ�趨
	 * 
	 * @param user �û���Ϣ
	 */
	public void setUser(User user) {
		this.user = user;
	}
		
	
	/**
	 * �걨��ѯ���ȡ��
	 * 
	 * @return �걨��ѯ���
	 */
	public Map<String, List<AnnualReportVW>> getMap_arq() {
		return map_arq;
	}

	
	/**
	 * �걨��ѯ����趨
	 * 
	 * @param arqMap �걨��ѯ���
	 */
	public void setMap_arq(Map<String, List<AnnualReportVW>> map_arq) {
		this.map_arq = map_arq;
	}	

	
	/**
	 * �걨һ��������ѯ���ȡ��
	 * 
	 * @return �걨һ��������ѯ���
	 */
	public Map<String, List<AnnualReportVW>> getMap_first() {
		return map_first;
	}

	/**
	 * �걨һ��������ѯ����趨
	 * 
	 * @param first_list �걨һ��������ѯ���
	 */
	public void setMap_first(Map<String, List<AnnualReportVW>> map_first) {
		this.map_first = map_first;
	}
	/**
	 * �걨����������ѯ���ȡ��
	 * 
	 * @return �걨����������ѯ���
	 */
	public List<RegulatoryReportInstanceInfo> getSecond_list() {
		return second_list;
	}

	/**
	 * �걨����������ѯ����趨
	 * 
	 * @param second_list �걨����������ѯ���
	 */
	public void setSecond_list(List<RegulatoryReportInstanceInfo> second_list) {
		this.second_list = second_list;
	}
	
	/**
	 * ��鿴formȡ��
	 * 
	 * @return ��鿴form
	 */
	public IGSMR0302Form getIgSMR0302Form() {
		return igSMR0302Form;
	}
	
	/**
	 * ��鿴form�趨
	 * 
	 * @param igSMR0302Form ��鿴form
	 */
	public void setIgSMR0302Form(IGSMR0302Form igSMR0302Form) {
		this.igSMR0302Form = igSMR0302Form;
	}
	/**
	 * ��鿴��ѯ���ȡ��
	 * 
	 * @return ��鿴��ѯ���
	 */

	public Map<String, List<AnnualReportVW>> getMap_see() {
		return map_see;
	}

	/**
	 * ��鿴��ѯ����趨
	 * 
	 * @param list_rri ��鿴��ѯ���
	 */
	public void setMap_see(Map<String, List<AnnualReportVW>> map_see) {
		this.map_see = map_see;
	}
	/**
	 * ��ʱ����formȡ��
	 * 
	 * @return ��ʱ����form
	 */
	public IGSMR0303Form getIgSMR0303Form() {
		return igSMR0303Form;
	}
	/**
	 * ��ʱ����form�趨
	 * 
	 * @param igSMR0303Form ��ʱ����form
	 */
	public void setIgSMR0303Form(IGSMR0303Form igSMR0303Form) {
		this.igSMR0303Form = igSMR0303Form;
	}

	public RemindConfigureInfo getRc() {
		return rc;
	}

	public void setRc(RemindConfigureInfo rc) {
		this.rc = rc;
	}

	public RemindConfigureInfo getRc1() {
		return rc1;
	}

	public void setRc1(RemindConfigureInfo rc1) {
		this.rc1 = rc1;
	}

	public RemindConfigureInfo getRc2() {
		return rc2;
	}

	public void setRc2(RemindConfigureInfo rc2) {
		this.rc2 = rc2;
	}

	public RemindConfigureInfo getRc3() {
		return rc3;
	}

	public void setRc3(RemindConfigureInfo rc3) {
		this.rc3 = rc3;
	}

	public RemindConfigureInfo getRc4() {
		return rc4;
	}

	public void setRc4(RemindConfigureInfo rc4) {
		this.rc4 = rc4;
	}

	public Map<String, List<AnnualReportVW>> getMap_more() {
		return map_more;
	}

	public void setMap_more(Map<String, List<AnnualReportVW>> map_more) {
		this.map_more = map_more;
	}

	public IGSMR0304Form getIgsmr0304Form() {
		return igsmr0304Form;
	}

	public void setIgsmr0304Form(IGSMR0304Form igsmr0304Form) {
		this.igsmr0304Form = igsmr0304Form;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public List<ReportHistorySearchVW> getList_rhs() {
		return list_rhs;
	}

	public void setList_rhs(List<ReportHistorySearchVW> list_rhs) {
		this.list_rhs = list_rhs;
	}

	
	
}
