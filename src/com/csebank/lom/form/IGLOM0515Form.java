/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.form;

import com.csebank.lom.model.condition.SingleGoodsStockSearchCond;
import com.deliverik.framework.base.BaseForm;
/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_ʳ�õ�һ��Ʒ���ͳ��FormBean
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0515Form extends BaseForm implements SingleGoodsStockSearchCond{
	private static final long serialVersionUID = 1L;
	
	/** ��Ʒ���� */
	protected String giodcategory;
	
	/** ��Ʒ���� */
	protected String goods;
	
	/** ��Ʒ��� */
	protected String giodcode;
	
	/** ʳ����֯ */
	public String giodorg;
	
	/**
	 * ͳ�ƿ�ʼʱ���ѯ
	 */
	public String etime_from;
	
	/**
	 * ͳ�ƽ���ʱ���ѯ
	 */
	public String etime_to;
	
	/**
	 * ����
	 */
	public String edate;
	
	/**
	 * ͳ�ƿ�ʼʱ���ѯ
	 * @return ͳ�ƿ�ʼʱ���ѯ
	 */
	public String getEtime_from() {
		return etime_from;
	}
	
	/**
	 * ͳ�ƿ�ʼʱ���ѯ
	 * @param etime_from ͳ�ƿ�ʼʱ���ѯ
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}
	
	/**
	 * ͳ�ƽ���ʱ���ѯ
	 * @return ͳ�ƽ���ʱ���ѯ
	 */
	public String getEtime_to() {
		return etime_to;
	}
	
	/**
	 * ͳ�ƽ���ʱ���ѯ
	 * @param etime_to ͳ�ƽ���ʱ���ѯ
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public String getEdate() {
		return edate;
	}
	
	/**
	 * ����
	 * @param edate ����
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getGiodcategory() {
		return giodcategory;
	}

	public void setGiodcategory(String giodcategory) {
		this.giodcategory = giodcategory;
	}

	public String getGiodorg() {
		return giodorg;
	}

	public void setGiodorg(String giodorg) {
		this.giodorg = giodorg;
	}

	public String getGiodcode() {
		return giodcode;
	}

	public void setGiodcode(String giodcode) {
		this.giodcode = giodcode;
	}
}
