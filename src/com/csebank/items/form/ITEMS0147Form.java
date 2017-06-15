/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import java.util.ArrayList;
import java.util.List;

import com.csebank.items.model.condition.OutStockSearchCond;
import com.csebank.items.model.condition.OutStockSearchVWCond;
import com.deliverik.framework.base.BaseForm;

public class ITEMS0147Form extends BaseForm implements OutStockSearchCond,OutStockSearchVWCond {

	private static final long serialVersionUID = 1L;

	//批量提交使用
	protected Integer[] outstockids;//outstock表主键ID
	protected String[] outstockorgs;//库存机构号
	protected String[] categorys;//物品种类
	protected String[] seqcodes;//物品编号
	protected String[] typecodes;//物品型号
	protected String[] seqnos;//批次号
	protected String[] outtypes;//出库类型
	protected String reqstatusa;
	protected String[] reqids;//申请人或下拨人ＩＤ
	protected String[] reqnames;//申请人或下拨人姓名
	protected String[] reqtimes;//申请或下拨时间
	protected Integer[] reqnums;//申领数量
	protected Integer[] chknums;//审批完成数量
	protected Integer[] outnums;//实际出库数量
	protected String[] chkreasons;//审批说明
	protected String[] pakreasons;//出库说明
	protected String[] packnos;//包裹号
	protected String[] chkids;//审批人ID
	protected String[] chknames;//审批人姓名
	protected String[] chktimes;//审批时间
	protected String[] stockuserids;//库管人的ID
	protected String[] stocknames;//库管人的名字
	protected String[] outtimes;//出库时间
	protected String[] rcvids;//接收人ID
	protected String[] rcvnames;//接收人姓名
	protected String[] rcvtimes;//接收时间
	protected String[] reqstatuss;//出库状态
	protected String[] accountstatuss;//结账状态
	protected Double[] inprices;//入库单价（未使用）
	protected Double[] outprices;//出库单价
	protected Double[] outamounts;//出库金额
	protected Integer[] bigpacknums;//大包装数量
	protected Integer[] smallpacknums;//小包装数量
	protected String[] itemversions;//凭证版本
	protected Integer[] stockids;//stock库存静态信息表的主键ID
	protected String[] itemsnames;//物品名称
	protected Integer[] stocknums;//库存数量
	protected String[] types;//物品类型
	
	protected String[] reqorgs;//领用机构号
	protected String[] reqorg_names;//领用机构号
	
	
	//
	protected Integer outstockid;
	protected String outstockorg;//库存机构号
	protected String category;//物品种类
	protected String seqcode;//物品编号
	protected String typecode;//物品型号
	protected String seqno;//批次号
	protected String outtype;//出库类型
	protected String reqorg;//领用机构号
	protected String reqid;//申请人或下拨人ＩＤ
	protected String reqname;//申请人或下拨人姓名
	protected String reqtime;//申请或下拨时间	
	protected Integer reqnum;//申请数量
	protected Integer chknum;//审批完成数量
	protected Integer outnum;//实际出库数量
	protected String chkreason;//审批说明
	protected String pakreason;//出库说明
	protected String packno;//包裹号
	protected String chkid;//审批人ID
	protected String chkname;//审批人姓名
	protected String chktime;//审批时间
	protected String stockuserid;//库管人的ID
	protected String stockname;//库管人的名字
	protected String outtime;//出库时间
	protected String rcvid;//接收人ID
	protected String rcvname;//接收人姓名
	protected String rcvtime;//接收时间
	protected String reqstatus;//出库状态
	protected String accountstatus;//结账状态
	protected Double inprice;//入库单价（未使用）
	protected Double outprice;//出库单价
	protected Double outamount;//出库金额
	protected Integer bigpacknum;//大包装数量
	protected Integer smallpacknum;//小包装数量
	protected String itemversion;//凭证版本
	protected Integer stockid;//stock库存静态信息表的主键ID
	protected String itemsname;//物品名称
	protected Integer stocknum;//库存数量
	protected String type;//物品类型
	
	//查询用
	protected String reqorg_name;//领用机构名称
	protected String outtime_f;//出库时间从
	protected String outtime_t;//出库时间至
	protected String reqorg_q;//申领机构
	protected String category_q;//物品种类
	protected String reqstatus_q;//状态
	protected String flag;//状态 标识 1待接收 0其他
	protected String outtype_q;//出库类型
	protected Integer sid;
	protected ArrayList<String> outtypelist;//出库类型
	protected String serachtype;//排序方式
	protected String outstockorg_q;//机构号
	protected String stockorg;//stock表机构号
	
	protected String reqtime_f;
	protected String reqtime_t;
	protected String chktime_f;
	protected String chktime_t;
	protected String rcvtime_f;
	protected String rcvtime_t;
	/**
	 * 出库类型集合
	 */
	protected List<String> outTypeList;
	
	
	
	/**
	 * @return the outTypeList
	 */
	public List<String> getOutTypeList() {
		return outTypeList;
	}
	/**
	 * @param outTypeList the outTypeList to set
	 */
	public void setOutTypeList(List<String> outTypeList) {
		this.outTypeList = outTypeList;
	}
	
	
	/**
	 * @return the rcvtime_f
	 */
	public String getRcvtime_f() {
		return rcvtime_f;
	}
	/**
	 * @param rcvtime_f the rcvtime_f to set
	 */
	public void setRcvtime_f(String rcvtime_f) {
		this.rcvtime_f = rcvtime_f;
	}
	/**
	 * @return the rcvtime_t
	 */
	public String getRcvtime_t() {
		return rcvtime_t;
	}
	/**
	 * @param rcvtime_t the rcvtime_t to set
	 */
	public void setRcvtime_t(String rcvtime_t) {
		this.rcvtime_t = rcvtime_t;
	}
	
	/**
	 * @return the chktime_f
	 */
	public String getChktime_f() {
		return chktime_f;
	}
	/**
	 * @param chktime_f the chktime_f to set
	 */
	public void setChktime_f(String chktime_f) {
		this.chktime_f = chktime_f;
	}
	/**
	 * @return the chktime_t
	 */
	public String getChktime_t() {
		return chktime_t;
	}
	/**
	 * @param chktime_t the chktime_t to set
	 */
	public void setChktime_t(String chktime_t) {
		this.chktime_t = chktime_t;
	}
	public String getReqtime_f() {
		return reqtime_f;
	}
	public void setReqtime_f(String reqtime_f) {
		this.reqtime_f = reqtime_f;
	}
	public String getReqtime_t() {
		return reqtime_t;
	}
	public void setReqtime_t(String reqtime_t) {
		this.reqtime_t = reqtime_t;
	}
	public String getStockorg() {
		return stockorg;
	}
	public void setStockorg(String stockorg) {
		this.stockorg = stockorg;
	}
	
	public String getOutstockorg_q() {
		return outstockorg_q;
	}
	public void setOutstockorg_q(String outstockorg_q) {
		this.outstockorg_q = outstockorg_q;
	}
	
	
	public String getSerachtype() {
		return serachtype;
	}
	public void setSerachtype(String serachtype) {
		this.serachtype = serachtype;
	}
	
	public ArrayList<String> getOuttypelist() {
		return outtypelist;
	}
	public void setOuttypelist(ArrayList<String> outtypelist) {
		this.outtypelist = outtypelist;
	}	
	
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String[] getReqorg_names() {
		return reqorg_names;
	}
	public void setReqorg_names(String[] reqorg_names) {
		this.reqorg_names = reqorg_names;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOuttype_q() {
		return outtype_q;
	}
	public void setOuttype_q(String outtype_q) {
		this.outtype_q = outtype_q;
	}
	public Integer[] getOutstockids() {
		return outstockids;
	}
	public String[] getOutstockorgs() {
		return outstockorgs;
	}
	public String[] getCategorys() {
		return categorys;
	}
	public String[] getSeqcodes() {
		return seqcodes;
	}
	public String[] getTypecodes() {
		return typecodes;
	}
	public String[] getSeqnos() {
		return seqnos;
	}
	public String[] getOuttypes() {
		return outtypes;
	}
	public String[] getReqorgs() {
		return reqorgs;
	}
	public String[] getReqids() {
		return reqids;
	}
	public String[] getReqnames() {
		return reqnames;
	}
	public String[] getReqtimes() {
		return reqtimes;
	}
	public Integer[] getReqnums() {
		return reqnums;
	}
	public Integer[] getChknums() {
		return chknums;
	}
	public Integer[] getOutnums() {
		return outnums;
	}
	public String[] getChkreasons() {
		return chkreasons;
	}
	public String[] getPakreasons() {
		return pakreasons;
	}
	public String[] getPacknos() {
		return packnos;
	}
	public String[] getChkids() {
		return chkids;
	}
	public String[] getChknames() {
		return chknames;
	}
	public String[] getChktimes() {
		return chktimes;
	}
	public String[] getStockuserids() {
		return stockuserids;
	}
	public String[] getStocknames() {
		return stocknames;
	}
	public String[] getOuttimes() {
		return outtimes;
	}
	public String[] getRcvids() {
		return rcvids;
	}
	public String[] getRcvnames() {
		return rcvnames;
	}
	public String[] getRcvtimes() {
		return rcvtimes;
	}
	public String[] getReqstatuss() {
		return reqstatuss;
	}
	public String[] getAccountstatuss() {
		return accountstatuss;
	}
	public Double[] getInprices() {
		return inprices;
	}
	public Double[] getOutprices() {
		return outprices;
	}
	public Double[] getOutamounts() {
		return outamounts;
	}
	public Integer[] getBigpacknums() {
		return bigpacknums;
	}
	public Integer[] getSmallpacknums() {
		return smallpacknums;
	}
	public String[] getItemversions() {
		return itemversions;
	}
	public Integer[] getStockids() {
		return stockids;
	}
	public String[] getItemsnames() {
		return itemsnames;
	}
	public Integer[] getStocknums() {
		return stocknums;
	}
	public Integer getOutstockid() {
		return outstockid;
	}
	public String getOutstockorg() {
		return outstockorg;
	}
	public String getCategory() {
		return category;
	}
	public String getSeqcode() {
		return seqcode;
	}
	public String getTypecode() {
		return typecode;
	}
	public String getSeqno() {
		return seqno;
	}
	public String getOuttype() {
		return outtype;
	}
	public String getReqorg() {
		return reqorg;
	}
	public String getReqid() {
		return reqid;
	}
	public String getReqname() {
		return reqname;
	}
	public String getReqtime() {
		return reqtime;
	}
	public Integer getReqnum() {
		return reqnum;
	}
	public Integer getChknum() {
		return chknum;
	}
	public Integer getOutnum() {
		return outnum;
	}
	public String getChkreason() {
		return chkreason;
	}
	public String getPakreason() {
		return pakreason;
	}
	public String getPackno() {
		return packno;
	}
	public String getChkid() {
		return chkid;
	}
	public String getChkname() {
		return chkname;
	}
	public String getChktime() {
		return chktime;
	}
	public String getStockuserid() {
		return stockuserid;
	}
	public String getStockname() {
		return stockname;
	}
	public String getOuttime() {
		return outtime;
	}
	public String getRcvid() {
		return rcvid;
	}
	public String getRcvname() {
		return rcvname;
	}
	public String getRcvtime() {
		return rcvtime;
	}
	public String getReqstatus() {
		return reqstatus;
	}
	public String getAccountstatus() {
		return accountstatus;
	}
	public Double getInprice() {
		return inprice;
	}
	public Double getOutprice() {
		return outprice;
	}
	public Double getOutamount() {
		return outamount;
	}
	public Integer getBigpacknum() {
		return bigpacknum;
	}
	public Integer getSmallpacknum() {
		return smallpacknum;
	}
	public String getItemversion() {
		return itemversion;
	}
	public Integer getStockid() {
		return stockid;
	}
	public String getItemsname() {
		return itemsname;
	}
	public Integer getStocknum() {
		return stocknum;
	}
	public String getReqorg_name() {
		return reqorg_name;
	}
	public String getOuttime_f() {
		return outtime_f;
	}
	public String getOuttime_t() {
		return outtime_t;
	}
	public String getReqorg_q() {
		return reqorg_q;
	}
	public String getCategory_q() {
		return category_q;
	}
	public String getReqstatus_q() {
		return reqstatus_q;
	}
	public String getFlag() {
		return flag;
	}
	
	
	
	
	public void setOutstockids(Integer[] outstockids) {
		this.outstockids = outstockids;
	}
	public void setOutstockorgs(String[] outstockorgs) {
		this.outstockorgs = outstockorgs;
	}
	public void setCategorys(String[] categorys) {
		this.categorys = categorys;
	}
	public void setSeqcodes(String[] seqcodes) {
		this.seqcodes = seqcodes;
	}
	public void setTypecodes(String[] typecodes) {
		this.typecodes = typecodes;
	}
	public void setSeqnos(String[] seqnos) {
		this.seqnos = seqnos;
	}
	public void setOuttypes(String[] outtypes) {
		this.outtypes = outtypes;
	}
	public void setReqorgs(String[] reqorgs) {
		this.reqorgs = reqorgs;
	}
	public void setReqids(String[] reqids) {
		this.reqids = reqids;
	}
	public void setReqnames(String[] reqnames) {
		this.reqnames = reqnames;
	}
	public void setReqtimes(String[] reqtimes) {
		this.reqtimes = reqtimes;
	}
	public void setReqnums(Integer[] reqnums) {
		this.reqnums = reqnums;
	}
	public void setChknums(Integer[] chknums) {
		this.chknums = chknums;
	}
	public void setOutnums(Integer[] outnums) {
		this.outnums = outnums;
	}
	public void setChkreasons(String[] chkreasons) {
		this.chkreasons = chkreasons;
	}
	public void setPakreasons(String[] pakreasons) {
		this.pakreasons = pakreasons;
	}
	public void setPacknos(String[] packnos) {
		this.packnos = packnos;
	}
	public void setChkids(String[] chkids) {
		this.chkids = chkids;
	}
	public void setChknames(String[] chknames) {
		this.chknames = chknames;
	}
	public void setChktimes(String[] chktimes) {
		this.chktimes = chktimes;
	}
	public void setStockuserids(String[] stockuserids) {
		this.stockuserids = stockuserids;
	}
	public void setStocknames(String[] stocknames) {
		this.stocknames = stocknames;
	}
	public void setOuttimes(String[] outtimes) {
		this.outtimes = outtimes;
	}
	public void setRcvids(String[] rcvids) {
		this.rcvids = rcvids;
	}
	public void setRcvnames(String[] rcvnames) {
		this.rcvnames = rcvnames;
	}
	public void setRcvtimes(String[] rcvtimes) {
		this.rcvtimes = rcvtimes;
	}
	public void setReqstatuss(String[] reqstatuss) {
		this.reqstatuss = reqstatuss;
	}
	public void setAccountstatuss(String[] accountstatuss) {
		this.accountstatuss = accountstatuss;
	}
	public void setInprices(Double[] inprices) {
		this.inprices = inprices;
	}
	public void setOutprices(Double[] outprices) {
		this.outprices = outprices;
	}
	public void setOutamounts(Double[] outamounts) {
		this.outamounts = outamounts;
	}
	public void setBigpacknums(Integer[] bigpacknums) {
		this.bigpacknums = bigpacknums;
	}
	public void setSmallpacknums(Integer[] smallpacknums) {
		this.smallpacknums = smallpacknums;
	}
	public void setItemversions(String[] itemversions) {
		this.itemversions = itemversions;
	}
	public void setStockids(Integer[] stockids) {
		this.stockids = stockids;
	}
	public void setItemsnames(String[] itemsnames) {
		this.itemsnames = itemsnames;
	}
	public void setStocknums(Integer[] stocknums) {
		this.stocknums = stocknums;
	}
	public void setOutstockid(Integer outstockid) {
		this.outstockid = outstockid;
	}
	public void setOutstockorg(String outstockorg) {
		this.outstockorg = outstockorg;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setSeqcode(String seqcode) {
		this.seqcode = seqcode;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}
	public void setReqorg(String reqorg) {
		this.reqorg = reqorg;
	}
	public void setReqid(String reqid) {
		this.reqid = reqid;
	}
	public void setReqname(String reqname) {
		this.reqname = reqname;
	}
	public void setReqtime(String reqtime) {
		this.reqtime = reqtime;
	}
	public void setReqnum(Integer reqnum) {
		this.reqnum = reqnum;
	}
	public void setChknum(Integer chknum) {
		this.chknum = chknum;
	}
	public void setOutnum(Integer outnum) {
		this.outnum = outnum;
	}
	public void setChkreason(String chkreason) {
		this.chkreason = chkreason;
	}
	public void setPakreason(String pakreason) {
		this.pakreason = pakreason;
	}
	public void setPackno(String packno) {
		this.packno = packno;
	}
	public void setChkid(String chkid) {
		this.chkid = chkid;
	}
	public void setChkname(String chkname) {
		this.chkname = chkname;
	}
	public void setChktime(String chktime) {
		this.chktime = chktime;
	}
	public void setStockuserid(String stockuserid) {
		this.stockuserid = stockuserid;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public void setRcvid(String rcvid) {
		this.rcvid = rcvid;
	}
	public void setRcvname(String rcvname) {
		this.rcvname = rcvname;
	}
	public void setRcvtime(String rcvtime) {
		this.rcvtime = rcvtime;
	}
	public void setReqstatus(String reqstatus) {
		this.reqstatus = reqstatus;
	}
	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}
	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}
	public void setOutprice(Double outprice) {
		this.outprice = outprice;
	}
	public void setOutamount(Double outamount) {
		this.outamount = outamount;
	}
	public void setBigpacknum(Integer bigpacknum) {
		this.bigpacknum = bigpacknum;
	}
	public void setSmallpacknum(Integer smallpacknum) {
		this.smallpacknum = smallpacknum;
	}
	public void setItemversion(String itemversion) {
		this.itemversion = itemversion;
	}
	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}
	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
	}
	public void setStocknum(Integer stocknum) {
		this.stocknum = stocknum;
	}
	public void setReqorg_name(String reqorg_name) {
		this.reqorg_name = reqorg_name;
	}
	public void setOuttime_f(String outtime_f) {
		this.outtime_f = outtime_f;
	}
	public void setOuttime_t(String outtime_t) {
		this.outtime_t = outtime_t;
	}
	public void setReqorg_q(String reqorg_q) {
		this.reqorg_q = reqorg_q;
	}
	public void setCategory_q(String category_q) {
		this.category_q = category_q;
	}
	public void setReqstatus_q(String reqstatus_q) {
		this.reqstatus_q = reqstatus_q;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public List<String> getReqstatusList() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getSortType() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getIntime_f() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getIntime_t() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isCanPayment() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getAccountstatus_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getItemsname_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getSeqcode_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqstatusa() {
		return reqstatusa;
	}
	public void setReqstatusa(String reqstatusa) {
		this.reqstatusa = reqstatusa;
	}
	

}
