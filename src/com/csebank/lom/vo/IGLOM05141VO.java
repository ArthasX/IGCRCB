/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.csebank.lom.model.GoodsStock;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ���ͳ��VO
 *
 */
public class IGLOM05141VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * ���ͳ�ƽ��
	 */
	protected List<GoodsStock> goodsStock;
	
	protected String innum;
	
	protected String outnum;

	protected String nownum;

	protected Map<String,IGLOM05141VO> map;
	
	/**
	 * ���ͳ�ƽ��ȡ��
	 * @return ���ͳ�ƽ��
	 */
	public List<GoodsStock> getGoodsStockList() {
		return goodsStock;
	}

	/**
	 * ���ͳ�ƽ��
	 * @param goodsStock ���ͳ�ƽ��
	 */
	public void setGoodsStockList(List<GoodsStock> goodsStock) {
		this.goodsStock = goodsStock;
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

	public Map<String, IGLOM05141VO> getMap() {
		return map;
	}

	public void setMap(Map<String, IGLOM05141VO> map) {
		this.map = map;
	}

}
