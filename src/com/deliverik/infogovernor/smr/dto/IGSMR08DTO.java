/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.smr.form.IGSMR0801Form;
import com.deliverik.infogovernor.smr.form.IGSMR0803Form;
import com.deliverik.infogovernor.smr.form.IGSMR0804Form;
import com.deliverik.infogovernor.smr.model.ReportDetailVWInfo;
import com.deliverik.infogovernor.smr.vo.IGSMR08001VO;

/**
 * ����:����� 
 * ��������������� 
 * �����ˣ�����͢
 * ������¼�� 2013-09-02
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR08DTO extends BaseDTO {

	/**����Ա���˲�ѯ���*/
	protected Map<String,List<IGSMR08001VO>> map;
	
	/**���������˲�ѯ���*/
	protected List<IGSMR08001VO> list;
	
	/**���������˲�ѯ����ϼ�*/
	protected IGSMR08001VO orgsum;
	
	/**���������˲�ѯ����ϼ�*/
	protected IGSMR08001VO usersum;
	
	/**���˲�ѯform*/
	protected IGSMR0801Form igsmr0801Form;
	
	/**��ر�����ϸҳform*/
	protected IGSMR0803Form igsmr0803Form;
	
	/**��ر�����ϸҳ��Ϣ*/
	protected Map<String,List<ReportDetailVWInfo>> detailMap;
	
	/**��ر�����1�к�������ϵͳ���������Ϣ*/
	protected Map<String, List<String[]>> map_report;

	/**��ر�����1�к�������ϵͳ�������Form*/
	protected IGSMR0804Form igsmr0804Form;
	
	/**��ر�����1�ϱ�������*/
	protected int countall;
	
	/**
	 * ��ر�����1�ϱ�������ȡ��
	 *
	 * @return countall ��ر�����1�ϱ�������
	 */
	public int getCountall() {
		return countall;
	}

	/**
	 * ��ر�����1�ϱ��������趨
	 *
	 * @param countall ��ر�����1�ϱ�������
	 */
	public void setCountall(int countall) {
		this.countall = countall;
	}

	/**
	 * ��ر�����1�к�������ϵͳ�������Formȡ��
	 *
	 * @return igsmr0804Form ��ر�����1�к�������ϵͳ�������Form
	 */
	public IGSMR0804Form getIgsmr0804Form() {
		return igsmr0804Form;
	}

	/**
	 * ��ر�����1�к�������ϵͳ�������Form�趨
	 *
	 * @param igsmr0804Form ��ر�����1�к�������ϵͳ�������Form
	 */
	public void setIgsmr0804Form(IGSMR0804Form igsmr0804Form) {
		this.igsmr0804Form = igsmr0804Form;
	}

	/**
	 * ��ر�����1�к�������ϵͳ���������Ϣȡ��
	 *
	 * @return map_report ��ر�����1�к�������ϵͳ���������Ϣ
	 */
	public Map<String, List<String[]>> getMap_report() {
		return map_report;
	}

	/**
	 * ��ر�����1�к�������ϵͳ���������Ϣ�趨
	 *
	 * @param map_report ��ر�����1�к�������ϵͳ���������Ϣ
	 */
	public void setMap_report(Map<String, List<String[]>> map_report) {
		this.map_report = map_report;
	}

	public Map<String, List<IGSMR08001VO>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<IGSMR08001VO>> map) {
		this.map = map;
	}

	public List<IGSMR08001VO> getList() {
		return list;
	}

	public void setList(List<IGSMR08001VO> list) {
		this.list = list;
	}

	public IGSMR0801Form getIgsmr0801Form() {
		return igsmr0801Form;
	}

	public void setIgsmr0801Form(IGSMR0801Form igsmr0801Form) {
		this.igsmr0801Form = igsmr0801Form;
	}

	public IGSMR08001VO getOrgsum() {
		return orgsum;
	}

	public void setOrgsum(IGSMR08001VO orgsum) {
		this.orgsum = orgsum;
	}

	public IGSMR08001VO getUsersum() {
		return usersum;
	}

	public void setUsersum(IGSMR08001VO usersum) {
		this.usersum = usersum;
	}

	/**
	 * ��ر�����ϸҳ Formȡ��
	 * @return ��ر�����ϸҳForm
	 */
	public IGSMR0803Form getIgsmr0803Form() {
		return igsmr0803Form;
	}

	/**
	 * ��ر�����ϸҳForm�趨
	 * @param igsmr0803Form ��ر�����ϸҳForm
	 */
	public void setIgsmr0803Form(IGSMR0803Form igsmr0803Form) {
		this.igsmr0803Form = igsmr0803Form;
	}

	/**
	 * ��ر�����ϸҳ��Ϣ ȡ��
	 * @return ��ر�����ϸҳ��Ϣ
	 */
	public Map<String, List<ReportDetailVWInfo>> getDetailMap() {
		return detailMap;
	}

	/**
	 * ��ر�����ϸҳ��Ϣ�趨
	 * @param detailMap ��ر�����ϸҳ��Ϣ
	 */
	public void setDetailMap(Map<String, List<ReportDetailVWInfo>> detailMap) {
		this.detailMap = detailMap;
	}
	
	
	
	
}
