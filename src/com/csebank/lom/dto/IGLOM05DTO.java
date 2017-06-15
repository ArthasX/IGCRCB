/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.csebank.lom.form.IGLOM0501Form;
import com.csebank.lom.form.IGLOM0502Form;
import com.csebank.lom.form.IGLOM0503Form;
import com.csebank.lom.form.IGLOM0504Form;
import com.csebank.lom.form.IGLOM0505Form;
import com.csebank.lom.form.IGLOM0506Form;
import com.csebank.lom.form.IGLOM0508Form;
import com.csebank.lom.form.IGLOM0509Form;
import com.csebank.lom.form.IGLOM0514Form;
import com.csebank.lom.form.IGLOM0515Form;
import com.csebank.lom.form.IGLOM0518Form;
import com.csebank.lom.form.IGLOM0519Form;
import com.csebank.lom.model.DeptEentertainment;
import com.csebank.lom.model.EEOrg;
import com.csebank.lom.model.Eatery;
import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.EentertainmentStatistics;
import com.csebank.lom.model.EworkingLunch;
import com.csebank.lom.model.GoodsStock;
import com.csebank.lom.model.GoutDetailInfo;
import com.csebank.lom.model.ItemsCodesSt;
import com.csebank.lom.model.SingleGoodsStock;
import com.csebank.lom.model.WorkLunchEatery;
import com.csebank.lom.model.condition.DeptEentertainmentSearchCond;
import com.csebank.lom.model.condition.EEOrgVWSearchCond;
import com.csebank.lom.model.condition.EESearchCond;
import com.csebank.lom.model.condition.EaterySearchCond;
import com.csebank.lom.model.condition.EentertainmentSearchCond;
import com.csebank.lom.model.condition.EentertainmentStatisticsSearchCond;
import com.csebank.lom.model.condition.EworkingLunchSearchCond;
import com.csebank.lom.model.condition.GoodsStockSearchCond;
import com.csebank.lom.model.condition.GoutDetailSearchCond;
import com.csebank.lom.model.condition.LunchCardSearchCond;
import com.csebank.lom.model.condition.SingleGoodsStockSearchCond;
import com.csebank.lom.model.condition.WorkLunchEaterySearchCond;
import com.csebank.lom.vo.IGLOM05051VO;
import com.csebank.lom.vo.IGLOM05141VO;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;

/**
 * 
 * ʳ�ù���DTO
 *
 */
@SuppressWarnings("serial")
public class IGLOM05DTO extends BaseDTO implements Serializable {
	
	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** ʳ���д����Ż�����ϸ��ѯ���� */
	protected EESearchCond eeSearchCond;
	/** ʳ�ù�����Ϣ���������� */
	protected int maxSearchCount;
	
	/** �Ӵ�ɾ��ID */
	protected String[] deleteEeid;

	/** ʳ�óɱ���Ϣ��ѯ���� */
	protected EaterySearchCond eaterySearchCond;
	
	/** ʳ�ù�������Ϣ��ѯ���� */
	protected EworkingLunchSearchCond eworkingLunchSearchCond;
	
	/** ʳ�ýӴ���Ϣ��ѯ���� */
	protected EentertainmentSearchCond eentertainmentSearchCond;
	
	/** �����ͳɱ���Ϣͳ������ */
	protected WorkLunchEaterySearchCond workLunchEaterySearchCond;
	
	/** �Ӵ���Ϣͳ������ */
	protected EentertainmentStatisticsSearchCond eentertainmentStatisticsSearchCond;
	
	/** ���ŽӴ���Ϣͳ������ */
	protected DeptEentertainmentSearchCond deptEentertainmentSearchCond;
	
	/** ���ͳ������ */
	protected GoodsStockSearchCond goodsStockSearchCond;
	
	/** ��һ��Ʒ���ͳ������ */
	protected SingleGoodsStockSearchCond singleGoodsStockSearchCond;
	
	/** �Ϳ����� */
	protected LunchCardSearchCond lunchCardSearchCond;
	
	/** ʳ�óɱ���ϢForm */
	protected IGLOM0501Form iglom0501Form;
	
	/** ʳ�óɱ�����Form */
	protected IGLOM0502Form iglom0502Form;
	
	/** ʳ�ù�������ϢForm */
	protected IGLOM0503Form iglom0503Form;
	
	/** ʳ�ù����͹���Form */
	protected IGLOM0504Form iglom0504Form;
	
	/** �����ͳɱ�ͳ��Form */
	protected IGLOM0505Form iglom0505Form;
	
	/** ʳ�ýӴ���ϢForm */
	protected IGLOM0506Form iglom0506Form;
	
	/** �Ӵ�ͳ��Form */
	protected IGLOM0508Form iglom0508Form;
	
	/** ���ŽӴ�ͳ��Form */
	protected IGLOM0509Form iglom0509Form;
	
	/** ���ͳ��Form */
	protected IGLOM0514Form iglom0514Form;
	
	/** ��һ��Ʒ���ͳ��Form */
	protected IGLOM0515Form iglom0515Form;
	
	/** �Ϳ�Form */
	protected IGLOM0518Form iglom0518Form;
	
	/** �Ϳ�Form */
	protected IGLOM0519Form iglom0519Form;
	
	/** ʳ�óɱ���Ϣ */
	protected Eatery eatery;
	
	/** ʳ�óɱ���Ϣ��������� */
	protected List<Eatery> eateryList;
	
	/** ʳ�ù�������Ϣ */
	protected EworkingLunch eworkingLunch;
	
	/** ʳ�ù�������Ϣ��������� */
	protected List<EworkingLunch> eworkingLunchList;
	
	/** ʳ�ýӴ���Ϣ */
	protected Eentertainment eentertainment;
	
	/** ʳ�ýӴ���Ϣ��������� */
	protected List<Eentertainment> eentertainmentList;
	
	/** �����ͳɱ�ͳ����Ϣ */
	protected WorkLunchEatery workLunchEatery;
	
	/** �����ͳɱ�ͳ����������� */
	protected List<WorkLunchEatery> workLunchEateryList;
	
	/** �Ӵ�ͳ�� */
	protected EentertainmentStatistics eentertainmentStatistics;
	
	/** �Ӵ�ͳ����������� */
	protected List<EentertainmentStatistics> eentertainmentStatisticsList;
	
	/** ���ŽӴ�ͳ�� */
	protected DeptEentertainment deptEentertainment;
	
	/** ���ŽӴ�ͳ����������� */
	protected List<DeptEentertainment> deptEentertainmentList;
	
	/** ���ͳ�� */
	protected GoodsStock goodsStock;
	
	/** ���ͳ����������� */
	protected List<GoodsStock> goodsStockList;
	
	/** ��һ��Ʒ���ͳ�� */
	protected SingleGoodsStock singleGoodsStock;
	
	/** ��һ��Ʒ���ͳ����������� */
	protected List<SingleGoodsStock> singleGoodsStockList;
	
	/** �Ϳ���Ϣ */
	protected ItemsCodesSt itemsCodes;
	
	/** �Ϳ������ */
	protected List<ItemsCodesSt> itemsCodesList;
	
	protected Map<String,IGLOM05141VO> map;
	protected Map<String,IGLOM05051VO> mapel;
	
	protected String innum;
	
	protected String outnum;

	protected String nownum;
	/** ʳ�ù���-ʳ�ýӴ����Ż��ܲ�ѯ�����ӿ�*/
	protected EEOrgVWSearchCond eeOrgVWSearchCond;
	/** ʳ���д�������������� */
	protected List<EEOrg> eeOrgVWList;
	/** ʳ�ù���-��Ʒ������ϸ��ѯ�����ӿ�*/
	protected GoutDetailSearchCond goutDetailSearchCond;
	/** ʳ����Ʒ������ϸ����� */
	protected List<GoutDetailInfo> goutDetailInfoList;
	
	/**
	 * ��ҳ��DTOȡ��
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	/**
	 * ʳ�ù�����Ϣ����������ȡ��
	 * @return ʳ�ù�����Ϣ����������ȡ��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ʳ�ù�����Ϣ�����������趨
	 * @param maxSearchCount ʳ�ù�����Ϣ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	
	/**
	 * �Ӵ�ɾ��ID
	 * @return �Ӵ�ɾ��ID
	 */
	public String[] getDeleteEeid() {
		return deleteEeid;
	}
	
	/**
	 * �Ӵ�ɾ��ID
	 * @param deleteEeid �Ӵ�ɾ��ID
	 */
	public void setDeleteEeid(String[] deleteEeid) {
		this.deleteEeid = deleteEeid;
	}
	
	/**
	 * ʳ�óɱ���Ϣ��ѯ����ȡ��
	 * @return
	 */
	public EaterySearchCond getEaterySearchCond() {
		return eaterySearchCond;
	}

	/**
	 * ʳ�óɱ���Ϣ��ѯ�����趨
	 * @param eaterySearchCond �Ӵ������ѯ�����趨
	 */
	public void setEaterySearchCond(EaterySearchCond eaterySearchCond) {
		this.eaterySearchCond = eaterySearchCond;
	}
	
	/**
	 * ʳ�ù����Ͳ�ѯ����ȡ��
	 * @return
	 */
	public EworkingLunchSearchCond getEworkingLunchSearchCond() {
		return eworkingLunchSearchCond;
	}

	/**
	 * ʳ�ù����Ͳ�ѯ�����趨
	 * @param eworkingLunchSearchCond �Ӵ������ѯ�����趨
	 */
	public void setEworkingLunchSearchCond(EworkingLunchSearchCond eworkingLunchSearchCond) {
		this.eworkingLunchSearchCond = eworkingLunchSearchCond;
	}
	
	/**
	 * ʳ�ýӴ���ѯ����ȡ��
	 * @return
	 */
	public EentertainmentSearchCond getEentertainmentSearchCond() {
		return eentertainmentSearchCond;
	}

	/**
	 * ʳ�ýӴ���ѯ�����趨
	 * @param eworkingLunchSearchCond �Ӵ������ѯ�����趨
	 */
	public void setEentertainmentSearchCond(EentertainmentSearchCond eentertainmentSearchCond) {
		this.eentertainmentSearchCond = eentertainmentSearchCond;
	}
	
	/**
	 * �����ͳɱ�ͳ�Ʋ�ѯ����ȡ��
	 * @return
	 */
	public WorkLunchEaterySearchCond getWorkLunchEaterySearchCond() {
		return workLunchEaterySearchCond;
	}

	/**
	 * �����ͳɱ�ͳ�Ʋ�ѯ�����趨
	 * @param workLunchEaterySearchCond �����ͳɱ�ͳ�Ʋ�ѯ�����趨
	 */
	public void setWorkLunchEaterySearchCond(WorkLunchEaterySearchCond workLunchEaterySearchCond) {
		this.workLunchEaterySearchCond = workLunchEaterySearchCond;
	}
	
	/**
	 * �Ӵ�ͳ�Ʋ�ѯ����ȡ��
	 * @return
	 */
	public EentertainmentStatisticsSearchCond getEentertainmentStatisticsSearchCond() {
		return eentertainmentStatisticsSearchCond;
	}

	/**
	 * �Ӵ�ͳ�Ʋ�ѯ�����趨
	 * @param workLunchEaterySearchCond �Ӵ�ͳ�Ʋ�ѯ�����趨
	 */
	public void setEentertainmentStatisticsSearchCond(EentertainmentStatisticsSearchCond eentertainmentStatisticsSearchCond) {
		this.eentertainmentStatisticsSearchCond = eentertainmentStatisticsSearchCond;
	}
	
	/**
	 * ���ŽӴ�ͳ�Ʋ�ѯ����ȡ��
	 * @return
	 */
	public DeptEentertainmentSearchCond getDeptEentertainmentSearchCond() {
		return deptEentertainmentSearchCond;
	}


	/**
	 * ���ŽӴ�ͳ�Ʋ�ѯ�����趨
	 * @param deptEentertainmentSearchCond �Ӵ�ͳ�Ʋ�ѯ�����趨
	 */
	public void setDeptEentertainmentSearchCond(DeptEentertainmentSearchCond deptEentertainmentSearchCond) {
		this.deptEentertainmentSearchCond = deptEentertainmentSearchCond;
	}
	
	/**
	 * ���ͳ�Ʋ�ѯ����ȡ��
	 * @return
	 */
	public GoodsStockSearchCond getGoodsStockSearchCond() {
		return goodsStockSearchCond;
	}

	/**
	 * ���ͳ�Ʋ�ѯ�����趨
	 * @param goodsStockSearchCond ���ͳ�Ʋ�ѯ�����趨
	 */
	public void setGoodsStockSearchCond(GoodsStockSearchCond goodsStockSearchCond) {
		this.goodsStockSearchCond = goodsStockSearchCond;
	}
	
	/**
	 * ��һ��Ʒ���ͳ�Ʋ�ѯ����ȡ��
	 * @return
	 */
	public SingleGoodsStockSearchCond getSingleGoodsStockSearchCond() {
		return singleGoodsStockSearchCond;
	}

	/**
	 * ��һ��Ʒ���ͳ�Ʋ�ѯ�����趨
	 * @param goodsStockSearchCond ��һ��Ʒ���ͳ�Ʋ�ѯ�����趨
	 */
	public void setSingleGoodsStockSearchCond(SingleGoodsStockSearchCond singleGoodsStockSearchCond) {
		this.singleGoodsStockSearchCond = singleGoodsStockSearchCond;
	}
	
	/**
	 * �Ϳ���ѯ����ȡ��
	 * @return
	 */
	public LunchCardSearchCond getLunchCardSearchCond() {
		return lunchCardSearchCond;
	}

	/**
	 * �Ϳ���ѯ�����趨
	 * @param lunchCardSearchCond ��һ��Ʒ���ͳ�Ʋ�ѯ�����趨
	 */
	public void setLunchCardSearchCond(LunchCardSearchCond lunchCardSearchCond) {
		this.lunchCardSearchCond = lunchCardSearchCond;
	}

	/**
	 * ʳ�óɱ���ϢFormȡ��
	 * @return ʳ�óɱ���ϢForm
	 */
	public IGLOM0501Form getIglom0501Form() {
		return iglom0501Form;
	}

	/**
	 * ʳ�óɱ���ϢForm�趨
	 * @param igLOM0501Form ʳ�óɱ���ϢForm
	 */
	public void setIglom0501Form(IGLOM0501Form iglom0501Form) {
		this.iglom0501Form = iglom0501Form;
	}
	
	/**
	 * ʳ�óɱ�����Formȡ��
	 * @return ʳ�óɱ�����Form
	 */
	public IGLOM0502Form getIglom0502Form() {
		return iglom0502Form;
	}

	/**
	 * ʳ�óɱ�����Form�趨
	 * @param igLOM0502Form ʳ�óɱ�����Form
	 */
	public void setIglom0502Form(IGLOM0502Form iglom0502Form) {
		this.iglom0502Form = iglom0502Form;
	}
	
	/**
	 * ʳ�ù�������ϢFormȡ��
	 * @return ʳ�ù�������ϢForm
	 */
	public IGLOM0503Form getIglom0503Form() {
		return iglom0503Form;
	}

	/**
	 * ʳ�ù�������ϢForm�趨
	 * @param igLOM0503Form ʳ�ù�������ϢForm
	 */
	public void setIglom0503Form(IGLOM0503Form iglom0503Form) {
		this.iglom0503Form = iglom0503Form;
	}
	
	/**
	 * ʳ�ù����͹���Formȡ��
	 * @return ʳ�ù����͹���Form
	 */
	public IGLOM0504Form getIglom0504Form() {
		return iglom0504Form;
	}

	/**
	 * ʳ�ù����͹���Form�趨
	 * @param igLOM0504Form ʳ�ù����͹���Form
	 */
	public void setIglom0504Form(IGLOM0504Form iglom0504Form) {
		this.iglom0504Form = iglom0504Form;
	}
	
	/**
	 * �����ͳɱ�ͳ��Formȡ��
	 * @return �����ͳɱ�ͳ��Form
	 */
	public IGLOM0505Form getIglom0505Form() {
		return iglom0505Form;
	}

	/**
	 * �����ͳɱ�ͳ��Form�趨
	 * @param igLOM0505Form �����ͳɱ�ͳ��Form
	 */
	public void setIglom0505Form(IGLOM0505Form iglom0505Form) {
		this.iglom0505Form = iglom0505Form;
	}
	
	/**
	 * ʳ�ýӴ���ϢFormȡ��
	 * @return ʳ�ýӴ���ϢForm
	 */
	public IGLOM0506Form getIglom0506Form() {
		return iglom0506Form;
	}

	/**
	 * ʳ�ýӴ���ϢForm�趨
	 * @param igLOM0506Form ʳ�ýӴ���ϢForm
	 */
	public void setIglom0506Form(IGLOM0506Form iglom0506Form) {
		this.iglom0506Form = iglom0506Form;
	}
	
	/**
	 * �Ӵ�ͳ��Formȡ��
	 * @return �Ӵ�ͳ��Form
	 */
	public IGLOM0508Form getIglom0508Form() {
		return iglom0508Form;
	}

	/**
	 * �Ӵ�ͳ��Form�趨
	 * @param iglom0508Form �Ӵ�ͳ��Form
	 */
	public void setIglom0508Form(IGLOM0508Form iglom0508Form) {
		this.iglom0508Form = iglom0508Form;
	}
	
	/**
	 * ���ŽӴ�ͳ��Formȡ��
	 * @return �Ӵ�ͳ��Form
	 */
	public IGLOM0509Form getIglom0509Form() {
		return iglom0509Form;
	}

	/**
	 * ���ŽӴ�ͳ��Form�趨
	 * @param iglom0509Form �Ӵ�ͳ��Form
	 */
	public void setIglom0509Form(IGLOM0509Form iglom0509Form) {
		this.iglom0509Form = iglom0509Form;
	}
	
	/**
	 * ���ͳ��Formȡ��
	 * @return ���ͳ��Form
	 */
	public IGLOM0514Form getIglom0514Form() {
		return iglom0514Form;
	}

	/**
	 * ���ͳ��Form�趨
	 * @param iglom0514Form ���ͳ��Form
	 */
	public void setIglom0514Form(IGLOM0514Form iglom0514Form) {
		this.iglom0514Form = iglom0514Form;
	}
	
	/**
	 * ��һ��Ʒ���ͳ��Formȡ��
	 * @return ��һ��Ʒ���ͳ��Form
	 */
	public IGLOM0515Form getIglom0515Form() {
		return iglom0515Form;
	}

	/**
	 * ��һ��Ʒ���ͳ��Form�趨
	 * @param iglom0515Form ��һ��Ʒ���ͳ��Form
	 */
	public void setIglom0515Form(IGLOM0515Form iglom0515Form) {
		this.iglom0515Form = iglom0515Form;
	}
	
	/**
	 * �Ϳ�Formȡ��
	 * @return �Ϳ�Form
	 */
	public IGLOM0518Form getIglom0518Form() {
		return iglom0518Form;
	}

	/**
	 * �Ϳ�Form�趨
	 * @param iglom0518Form �Ϳ�Form
	 */
	public void setIglom0518Form(IGLOM0518Form iglom0518Form) {
		this.iglom0518Form = iglom0518Form;
	}
	/**
	 * �Ϳ�Formȡ��
	 * @return �Ϳ�Form
	 */
	public IGLOM0519Form getIglom0519Form() {
		return iglom0519Form;
	}
	/**
	 * �Ϳ�Form�趨
	 * @param iglom0519Form �Ϳ�Form
	 */
	public void setIglom0519Form(IGLOM0519Form iglom0519Form) {
		// TODO Auto-generated method stub
		this.iglom0519Form = iglom0519Form;
	}
	
	/**
	 * ʳ�óɱ���Ϣȡ��
	 * @return ʳ�óɱ���Ϣ
	 */
	public Eatery getEatery() {
		return eatery;
	}

	/**
	 * ʳ�óɱ���Ϣ�趨
	 * @param eatery ʳ�óɱ���Ϣ
	 */
	public void setEatery(Eatery eatery) {
		this.eatery = eatery;
	}
	
	/**
	 * ʳ�ù�������Ϣȡ��
	 * @return ʳ�ù�������Ϣ
	 */
	public EworkingLunch getEworkingLunch() {
		return eworkingLunch;
	}

	/**
	 * ʳ�ù�������Ϣ�趨
	 * @param eworkingLunch ʳ�ù�������Ϣ
	 */
	public void setEworkingLunch(EworkingLunch eworkingLunch) {
		this.eworkingLunch = eworkingLunch;
	}
	
	/**
	 * ʳ�ýӴ���Ϣȡ��
	 * @return ʳ�ýӴ���Ϣ
	 */
	public Eentertainment getEentertainment() {
		return eentertainment;
	}

	/**
	 * ʳ�ýӴ���Ϣ�趨
	 * @param eentertainment ʳ�ýӴ���Ϣ
	 */
	public void setEentertainment(Eentertainment eentertainment) {
		this.eentertainment = eentertainment;
	}
	
	/**
	 * �����ͳɱ�ͳ����Ϣȡ��
	 * @return �����ͳɱ�ͳ����Ϣ
	 */
	public WorkLunchEatery getWorkLunchEatery() {
		return workLunchEatery;
	}

	/**
	 * �����ͳɱ�ͳ����Ϣ�趨
	 * @param eentertainment �����ͳɱ�ͳ����Ϣ
	 */
	public void setWorkLunchEatery(WorkLunchEatery workLunchEatery) {
		this.workLunchEatery = workLunchEatery;
	}
	
	/**
	 * �Ӵ�ͳ����Ϣȡ��
	 * @return �Ӵ�ͳ����Ϣ
	 */
	public EentertainmentStatistics getEentertainmentStatistics() {
		return eentertainmentStatistics;
	}

	/**
	 * �Ӵ�ͳ����Ϣ�趨
	 * @param eentertainmentStatistics �Ӵ�ͳ����Ϣ
	 */
	public void setEentertainmentStatistics(EentertainmentStatistics eentertainmentStatistics) {
		this.eentertainmentStatistics = eentertainmentStatistics;
	}
	
	/**
	 * ���ŽӴ�ͳ����Ϣȡ��
	 * @return ���ŽӴ�ͳ����Ϣ
	 */
	public DeptEentertainment getDeptEentertainment() {
		return deptEentertainment;
	}

	/**
	 * ���ŽӴ�ͳ����Ϣ�趨
	 * @param deptEentertainment ���ŽӴ�ͳ����Ϣ
	 */
	public void setDeptEentertainment(DeptEentertainment deptEentertainment) {
		this.deptEentertainment = deptEentertainment;
	}
	
	/**
	 * ���ͳ����Ϣȡ��
	 * @return ���ͳ����Ϣ
	 */
	public GoodsStock getGoodsStock() {
		return goodsStock;
	}

	/**
	 * ���ͳ����Ϣ�趨
	 * @param goodsStock ���ͳ����Ϣ
	 */
	public void setGoodsStock(GoodsStock goodsStock) {
		this.goodsStock = goodsStock;
	}
	
	/**
	 * ��һ��Ʒ���ͳ����Ϣȡ��
	 * @return ��һ��Ʒ���ͳ����Ϣ
	 */
	public SingleGoodsStock getSingleGoodsStock() {
		return singleGoodsStock;
	}

	/**
	 * ��һ��Ʒ���ͳ����Ϣ�趨
	 * @param goodsStock ��һ��Ʒ���ͳ����Ϣ
	 */
	public void setSingleGoodsStock(SingleGoodsStock singleGoodsStock) {
		this.singleGoodsStock = singleGoodsStock;
	}
	
	/**
	 * �Ϳ���Ϣȡ��
	 * @return �Ϳ���Ϣ
	 */
	public ItemsCodesSt getItemsCodes() {
		return itemsCodes;
	}

	/**
	 * �Ϳ���Ϣ�趨
	 * @param itemsCodes �Ϳ���Ϣ
	 */
	public void setItemsCodes(ItemsCodesSt itemsCodes) {
		this.itemsCodes = itemsCodes;
	}

	/**
	 * ʳ�óɱ���Ϣ���������ȡ��
	 * @return ʳ�óɱ���Ϣ���������
	 */
	public List<Eatery> getEateryList() {
		return eateryList;
	}

	/**
	 * ʳ�óɱ���Ϣ����������趨
	 * @param eateryList ʳ�óɱ���Ϣ���������
	 */
	public void setEateryList(List<Eatery> eateryList) {
		this.eateryList = eateryList;
	}
	
	/**
	 * ʳ�ù�������Ϣ���������ȡ��
	 * @return ʳ�ù�������Ϣ���������
	 */
	public List<EworkingLunch> getEworkingLunchList() {
		return eworkingLunchList;
	}

	/**
	 * ʳ�ù�������Ϣ����������趨
	 * @param eworkingLunchList ʳ�ù�������Ϣ���������
	 */
	public void setEworkingLunchList(List<EworkingLunch> eworkingLunchList) {
		this.eworkingLunchList = eworkingLunchList;
	}
	
	/**
	 * ʳ�ýӴ���Ϣ���������ȡ��
	 * @return ʳ�ýӴ���Ϣ���������
	 */
	public List<Eentertainment> getEentertainmentList() {
		return eentertainmentList;
	}

	/**
	 * ʳ�ýӴ���Ϣ����������趨
	 * @param eworkingLunchList ʳ�ýӴ���Ϣ���������
	 */
	public void setEentertainmentList(List<Eentertainment> eentertainmentList) {
		this.eentertainmentList = eentertainmentList;
	}
	
	/**
	 * �����ͳɱ�ͳ����Ϣ���������ȡ��
	 * @return �����ͳɱ�ͳ����Ϣ���������
	 */
	public List<WorkLunchEatery> getWorkLunchEateryList() {
		return workLunchEateryList;
	}

	/**
	 * �����ͳɱ�ͳ����Ϣ����������趨
	 * @param eworkingLunchList �����ͳɱ�ͳ����Ϣ���������
	 */
	public void setWorkLunchEateryList(List<WorkLunchEatery> workLunchEateryList) {
		this.workLunchEateryList = workLunchEateryList;
	}
	
	/**
	 * �Ӵ�ͳ����Ϣ���������ȡ��
	 * @return �Ӵ�ͳ����Ϣ���������
	 */
	public List<EentertainmentStatistics> getEentertainmentStatisticsList() {
		return eentertainmentStatisticsList;
	}

	/**
	 * �Ӵ�ͳ����Ϣ����������趨
	 * @param eworkingLunchList �Ӵ�ͳ����Ϣ���������
	 */
	public void setDeptEentertainmentList(List<DeptEentertainment> deptEentertainmentList) {
		this.deptEentertainmentList = deptEentertainmentList;
	}
	
	/**
	 * ���ŽӴ�ͳ����Ϣ���������ȡ��
	 * @return ���ŽӴ�ͳ����Ϣ���������
	 */
	public List<DeptEentertainment> getDeptEentertainmentList() {
		return deptEentertainmentList;
	}

	/**
	 * ���ŽӴ�ͳ����Ϣ����������趨
	 * @param eworkingLunchList ���ŽӴ�ͳ����Ϣ���������
	 */
	public void setEentertainmentStatisticsList(List<EentertainmentStatistics> eentertainmentStatisticsList) {
		this.eentertainmentStatisticsList = eentertainmentStatisticsList;
	}
	
	/**
	 * ���ͳ����Ϣ���������ȡ��
	 * @return ���ͳ����Ϣ���������
	 */
	public List<GoodsStock> getGoodsStockList() {
		return goodsStockList;
	}

	/**
	 * ���ͳ����Ϣ����������趨
	 * @param goodsStockList ���ͳ����Ϣ���������
	 */
	public void setGoodsStockList(List<GoodsStock> goodsStockList) {
		this.goodsStockList = goodsStockList;
	}
	
	/**
	 * ��һ��Ʒ���ͳ����Ϣ���������ȡ��
	 * @return ��һ��Ʒ���ͳ����Ϣ���������
	 */
	public List<SingleGoodsStock> getSingleGoodsStockList() {
		return singleGoodsStockList;
	}

	/**
	 * ��һ��Ʒ���ͳ����Ϣ����������趨
	 * @param goodsStockList ��һ��Ʒ���ͳ����Ϣ���������
	 */
	public void setSingleGoodsStockList(List<SingleGoodsStock> singleGoodsStockList) {
		this.singleGoodsStockList = singleGoodsStockList;
	}
	
	/**
	 * �Ϳ���Ϣ���������ȡ��
	 * @return �Ϳ���Ϣ���������
	 */
	public List<ItemsCodesSt> getItemsCodesList() {
		return itemsCodesList;
	}

	/**
	 * �Ϳ���Ϣ����������趨
	 * @param itemsCodesList �Ϳ���Ϣ���������
	 */
	public void setItemsCodesList(List<ItemsCodesSt> itemsCodesList) {
		this.itemsCodesList = itemsCodesList;
	}

	public Map<String, IGLOM05141VO> getMap() {
		return map;
	}

	public void setMap(Map<String, IGLOM05141VO> map) {
		this.map = map;
	}

	public String getInnum() {
		return innum;
	}

	public void setInnum(String innum) {
		this.innum = innum;
	}

	public String getOutnum() {
		return outnum;
	}

	public void setOutnum(String outnum) {
		this.outnum = outnum;
	}

	public String getNownum() {
		return nownum;
	}

	public void setNownum(String nownum) {
		this.nownum = nownum;
	}

	public Map<String, IGLOM05051VO> getMapel() {
		return mapel;
	}

	public void setMapel(Map<String, IGLOM05051VO> mapel) {
		this.mapel = mapel;
	}
	public EEOrgVWSearchCond getEeOrgVWSearchCond() {
		return eeOrgVWSearchCond;
	}

	public void setEeOrgVWSearchCond(EEOrgVWSearchCond eeOrgVWSearchCond) {
		this.eeOrgVWSearchCond = eeOrgVWSearchCond;
	}

	public List<EEOrg> getEeOrgVWList() {
		return eeOrgVWList;
	}

	public void setEeOrgVWList(List<EEOrg> eeOrgVWList) {
		this.eeOrgVWList = eeOrgVWList;
	}

	public EESearchCond getEeSearchCond() {
		return eeSearchCond;
	}

	public void setEeSearchCond(EESearchCond eeSearchCond) {
		this.eeSearchCond = eeSearchCond;
	}

	public GoutDetailSearchCond getGoutDetailSearchCond() {
		return goutDetailSearchCond;
	}

	public void setGoutDetailSearchCond(GoutDetailSearchCond goutDetailSearchCond) {
		this.goutDetailSearchCond = goutDetailSearchCond;
	}

	public List<GoutDetailInfo> getGoutDetailInfoList() {
		return goutDetailInfoList;
	}

	public void setGoutDetailInfoList(List<GoutDetailInfo> goutDetailInfoList) {
		this.goutDetailInfoList = goutDetailInfoList;
	}

}
