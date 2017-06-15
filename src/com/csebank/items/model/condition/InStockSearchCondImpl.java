package com.csebank.items.model.condition;

import java.util.List;

public class InStockSearchCondImpl implements InStockSearchCond {

	protected Integer instockid;
	protected String instockorg;//库存机构号
	protected String category;//物品种类
	protected String type;//物品类型
	protected String seqcode;//物品编号
	protected String seqcode_q;//物品编号,统计中的模糊查询
	protected String itemsname_q;//物品名称,统计中的模糊查询
	protected String intime_f;//入库时间从
	protected String intime_t;//入库时间至
	protected String seqno;//批次号
	protected String typecode;//物品型号
	protected String status;//入库后状态
	protected List<String> status_q;//入库后状态,出库时查询入库明细使用
	protected String intime;//入库时间
	protected boolean lossnumIsNotZero;
	protected String instockorg_q;//库存机构号
	protected boolean showNoneStock = true;
	protected String instock_sort;//instock表的排序方式 ，传入byintime 则按照入库时间排序，否则按照物品编号排序
	
	protected Integer outstockid;
	
	
	
	/**
	 * @return the outstockid
	 */
	public Integer getOutstockid() {
		return outstockid;
	}
	/**
	 * @param outstockid the outstockid to set
	 */
	public void setOutstockid(Integer outstockid) {
		this.outstockid = outstockid;
	}
	/**
	 * @return the instock_sort
	 */
	public String getInstock_sort() {
		return instock_sort;
	}
	/**
	 * @param instock_sort the instock_sort to set
	 */
	public void setInstock_sort(String instock_sort) {
		this.instock_sort = instock_sort;
	}
	public boolean isShowNoneStock() {
		return showNoneStock;
	}
	public void setShowNoneStock(boolean showNoneStock) {
		this.showNoneStock = showNoneStock;
	}
	public String getInstockorg_q() {
		return instockorg_q;
	}
	public void setInstockorg_q(String instockorg_q) {
		this.instockorg_q = instockorg_q;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public boolean isLossnumIsNotZero() {
		return lossnumIsNotZero;
	}
	public void setLossnumIsNotZero(boolean lossnumIsNotZero) {
		this.lossnumIsNotZero = lossnumIsNotZero;
	}
	public List<String> getStatus_q() {
		return status_q;
	}
	public void setStatus_q(List<String> status_q) {
		this.status_q = status_q;
	}
	public Integer getInstockid() {
		return instockid;
	}
	public String getInstockorg() {
		return instockorg;
	}
	public String getCategory() {
		return category;
	}
	public String getType() {
		return type;
	}
	public String getSeqcode() {
		return seqcode;
	}
	public String getSeqno() {
		return seqno;
	}
	public String getTypecode() {
		return typecode;
	}
	public String getStatus() {
		return status;
	}
	public String getIntime_f() {
		return intime_f;
	}
	public String getIntime_t() {
		return intime_t;
	}
	
	
	public void setIntime_f(String intime_f) {
		this.intime_f = intime_f;
	}
	public void setIntime_t(String intime_t) {
		this.intime_t = intime_t;
	}
	public void setInstockid(Integer instockid) {
		this.instockid = instockid;
	}
	public void setInstockorg(String instockorg) {
		this.instockorg = instockorg;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setSeqcode(String seqcode) {
		this.seqcode = seqcode;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSeqcode_q() {
		return seqcode_q;
	}
	public void setSeqcode_q(String seqcode_q) {
		this.seqcode_q = seqcode_q;
	}
	public String getItemsname_q() {
		return itemsname_q;
	}
	public void setItemsname_q(String itemsname_q) {
		this.itemsname_q = itemsname_q;
	}
	
	
	
}
