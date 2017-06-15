/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.dut.form.IGDUT0301Form;
import com.deliverik.infogovernor.dut.form.IGDUT0302Form;
import com.deliverik.infogovernor.dut.form.IGDUT0304Form;
import com.deliverik.infogovernor.dut.form.IGDUT0305Form;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCond;
import com.deliverik.infogovernor.dut.model.condition.OnDutyPersonRecordSearchCond;

/**
 * ֵ���������DTO
 */
public class IGDUT03DTO extends BaseDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	/** CodeDetail list */
	protected List<CodeDetail> codeDetailList;

	

	/**
	 * CodeDetaillistȡ��
	 *
	 * @return codeDetailList CodeDetaillist
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	/**
	 * CodeDetaillist�趨
	 *
	 * @param codeDetailList CodeDetaillist
	 */
	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	/** ֵ��������ܲ�ѯ���� */
	protected DutyResultSearchCond dutyResultSearchCond;
	
	/** ֵ�����������ϢForm */
	protected IGDUT0302Form igDUT0302Form;
	
	/**ֵ�����������Ϣ����*/
	protected DutyResult dutyResult;

	/** ֵ�����������Ϣ��������� */
	protected List<DutyResult> dutyResultList;
	
	/** �װ�ƻ� */
	protected DutyPlan dutyPlanAM;
	
	/** ҹ��ƻ� */
	protected DutyPlan dutyPlanPM;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ֵ�����������Ϣ���������� */
	protected int maxSearchCount;

	/** ֵ�����������ϢForm */
	protected IGDUT0301Form igdut0301Form;
	
	protected int calendarYear;
	
	protected int calendarMonth;
	
	protected String dadcategory;
	
	/** ����� */
	protected Map<String,Integer> dutyResultMap;
	
	/** �ճ�ά���Ǽ���ϢForm */
    protected IGDUT0304Form igDUT0304Form;
    
    /** �ճ�ά����ѯ��ϢForm */
    protected IGDUT0305Form igDUT0305Form;
    
    /** �ճ�ά����������� */
    protected List<OnDutyPersonRecordInfo> onDutyPersonRecordList;
    
    /** �ճ�ά����ѯ���� */
    protected OnDutyPersonRecordSearchCond onDutyPersonRecordSearchCond;
	
    /** �ճ�ά������*/
    protected OnDutyPersonRecordInfo onDutyPersonRecordInfo;
	
	/** ��ʱ���� */
	protected Map<String,Integer> delayMap;
	
	public Map<String, Integer> getDelayMap() {
		return delayMap;
	}

	public void setDelayMap(Map<String, Integer> delayMap) {
		this.delayMap = delayMap;
	}
    
	
	public int getCalendarYear() {
		return calendarYear;
	}

	public void setCalendarYear(int calendarYear) {
		this.calendarYear = calendarYear;
	}

	public int getCalendarMonth() {
		return calendarMonth;
	}

	public void setCalendarMonth(int calendarMonth) {
		this.calendarMonth = calendarMonth;
	}

	/**
	 * ֵ��������ܲ�ѯ����ȡ��
	 * @return ֵ��������ܲ�ѯ����
	 */
	public DutyResultSearchCond getDutyResultSearchCond() {
		return dutyResultSearchCond;
	}

	/**
	 * ֵ��������ܲ�ѯ�����趨
	 * @param dutyResultSearchCond ֵ��������ܲ�ѯ����
	 */
	public void setDutyResultSearchCond(DutyResultSearchCond dutyResultSearchCond) {
		this.dutyResultSearchCond = dutyResultSearchCond;
	}

	/**
	 * ֵ�����������ϢFormȡ��
	 * @return ֵ�����������ϢForm
	 */
	public IGDUT0302Form getIgDUT0302Form() {
		return igDUT0302Form;
	}

	/**
	 * ֵ�����������ϢForm�趨
	 * @param igDUT0302Form ֵ�����������ϢForm
	 */
	public void setIgDUT0302Form(IGDUT0302Form igDUT0302Form) {
		this.igDUT0302Form = igDUT0302Form;
	}

	/**
	 * ֵ�����������Ϣ����ȡ��
	 * @return ֵ�����������Ϣ����
	 */
	public DutyResult getDutyResult() {
		return dutyResult;
	}

	/**
	 * ֵ�����������Ϣ�����趨
	 * @param dutyResult ֵ�����������Ϣ����
	 */
	public void setDutyResult(DutyResult dutyResult) {
		this.dutyResult = dutyResult;
	}

	/**
	 * ֵ�����������Ϣ���������ȡ��
	 * @return ֵ�����������Ϣ���������
	 */
	public List<DutyResult> getDutyResultList() {
		return dutyResultList;
	}

	/**
	 * ֵ�����������Ϣ����������趨
	 * @param dutyResultList ֵ�����������Ϣ���������
	 */
	public void setDutyResultList(List<DutyResult> dutyResultList) {
		this.dutyResultList = dutyResultList;
	}

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
	 * ֵ�����������Ϣ����������ȡ��
	 * @return ֵ�����������Ϣ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ֵ�����������Ϣ�����������趨
	 * @param maxSearchCount ֵ�����������Ϣ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public IGDUT0301Form getIgdut0301Form() {
		return igdut0301Form;
	}

	public void setIgdut0301Form(IGDUT0301Form igdut0301Form) {
		this.igdut0301Form = igdut0301Form;
	}

	public Map<String, Integer> getDutyResultMap() {
		return dutyResultMap;
	}

	public void setDutyResultMap(Map<String, Integer> dutyResultMap) {
		this.dutyResultMap = dutyResultMap;
	}

	public String getDadcategory() {
		return dadcategory;
	}

	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}
	
	/**
	 * �װ�ƻ�ȡ��
	 * @return �װ�ƻ�
	 */
	public DutyPlan getDutyPlanAM() {
		return dutyPlanAM;
	}

	/**
	 * �װ�ƻ��趨
	 * @param dutyPlanAM �װ�ƻ�
	 */
	public void setDutyPlanAM(DutyPlan dutyPlanAM) {
		this.dutyPlanAM = dutyPlanAM;
	}

	/**
	 * ҹ��ƻ�ȡ��
	 * @return ҹ��ƻ�
	 */
	public DutyPlan getDutyPlanPM() {
		return dutyPlanPM;
	}

	/**
	 * ҹ��ƻ��趨
	 * @param dutyPlanPM ҹ��ƻ�
	 */
	public void setDutyPlanPM(DutyPlan dutyPlanPM) {
		this.dutyPlanPM = dutyPlanPM;
	}

    /**
     * �ճ�ά���Ǽ���ϢFormȡ��
     *
     * @return igDUT0304Form �ճ�ά���Ǽ���ϢForm
     */
    public IGDUT0304Form getIgDUT0304Form() {
        return igDUT0304Form;
    }

    /**
     * �ճ�ά���Ǽ���ϢForm�趨
     *
     * @param igDUT0304Form �ճ�ά���Ǽ���ϢForm
     */
    public void setIgDUT0304Form(IGDUT0304Form igDUT0304Form) {
        this.igDUT0304Form = igDUT0304Form;
    }

    /**
     * �ճ�ά����ѯ��ϢFormȡ��
     *
     * @return igDUT0305Form �ճ�ά����ѯ��ϢForm
     */
    public IGDUT0305Form getIgDUT0305Form() {
        return igDUT0305Form;
    }

    /**
     * �ճ�ά����ѯ��ϢForm�趨
     *
     * @param igDUT0305Form �ճ�ά����ѯ��ϢForm
     */
    public void setIgDUT0305Form(IGDUT0305Form igDUT0305Form) {
        this.igDUT0305Form = igDUT0305Form;
    }

    /**
     * �ճ�ά�����������ȡ��
     *
     * @return onDutyPersonRecordList �ճ�ά�����������
     */
    public List<OnDutyPersonRecordInfo> getOnDutyPersonRecordList() {
        return onDutyPersonRecordList;
    }

    /**
     * �ճ�ά������������趨
     *
     * @param onDutyPersonRecordList �ճ�ά�����������
     */
    public void setOnDutyPersonRecordList(
            List<OnDutyPersonRecordInfo> onDutyPersonRecordList) {
        this.onDutyPersonRecordList = onDutyPersonRecordList;
    }

    /**
     * �ճ�ά����ѯ����ȡ��
     *
     * @return onDutyPersonRecordSearchCond �ճ�ά����ѯ����
     */
    public OnDutyPersonRecordSearchCond getOnDutyPersonRecordSearchCond() {
        return onDutyPersonRecordSearchCond;
    }

    /**
     * �ճ�ά����ѯ�����趨
     *
     * @param onDutyPersonRecordSearchCond �ճ�ά����ѯ����
     */
    public void setOnDutyPersonRecordSearchCond(
            OnDutyPersonRecordSearchCond onDutyPersonRecordSearchCond) {
        this.onDutyPersonRecordSearchCond = onDutyPersonRecordSearchCond;
    }

    /**
     * �ճ�ά������ȡ��
     *
     * @return onDutyPersonRecordInfo �ճ�ά������
     */
    public OnDutyPersonRecordInfo getOnDutyPersonRecordInfo() {
        return onDutyPersonRecordInfo;
    }

    /**
     * �ճ�ά�������趨
     *
     * @param onDutyPersonRecordInfo �ճ�ά������
     */
    public void setOnDutyPersonRecordInfo(
            OnDutyPersonRecordInfo onDutyPersonRecordInfo) {
        this.onDutyPersonRecordInfo = onDutyPersonRecordInfo;
    }

	

}
