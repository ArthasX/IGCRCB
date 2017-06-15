/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.items.form;

import java.util.ArrayList;
import java.util.List;

import com.csebank.items.model.condition.OutStockSearchCond;
import com.deliverik.framework.base.BaseForm;

public class ITEMS0141Form extends BaseForm implements OutStockSearchCond {

	private static final long serialVersionUID = 1L;

	protected Integer outstockid;
	protected String[] outstockorgs;//��������
	protected String[] categorys;//��Ʒ����
	protected String[] itemsnames;//��Ʒ����
	protected String[] seqcodes;//��Ʒ���
	protected String[] typecodes;//��Ʒ�ͺ�
	protected String[] seqnos;//���κ�
	protected Integer[] bigpacknums;//���װ����
	protected Integer[] smallpacknums;//С��װ����
	protected String[] itemversions;//ƾ֤�汾
	protected Integer[] stockids;//stock��澲̬��Ϣ�������ID
	protected Integer[] reqnums;//��������
	protected Integer[] chknums;//�����������
	protected Integer[] outnums;//ʵ�ʳ�������
	protected String[] types;//��Ʒ����
	protected String reqstatusa;
	protected String outtype;//��������
	
	protected String reqorg;//���û�����
	protected String reqid;//�����˻��²��ˣɣ�
	protected String reqname;//�����˻��²�������
	protected String reqtime;//������²�ʱ��

	
	protected String chkreason;//��������ԭ��
	protected String pakreason;//�������ԭ��
	protected String packno;//������
	protected String chkid;//������ID
	protected String chkname;//����������
	protected String chktime;//����ʱ��
	protected String stockuserid;//����˵�ID
	
	protected String stockname;//����˵�����
	protected String outtime;//����ʱ��
	protected String rcvid;//������ID
	protected String rcvname;//����������
	protected String rcvtime;//����ʱ��
	protected String reqstatus;//����״̬
	protected String accountstatus;//����״̬
	
	protected Double inprice;//��ⵥ�ۣ�δʹ�ã�
	protected Double outprice;//���ⵥ��
	protected Double outamount;//������

	
	protected String outtime_f;//����ʱ���
	protected String outtime_t;//����ʱ����
	
	protected String outstockorg;//��������
	protected String category;//��Ʒ����
	protected String seqcode;//��Ʒ���
	protected Integer stockid;//stock��澲̬��Ϣ�������ID
	protected String itemsname;//��Ʒ����
	protected String type;//��Ʒ����
	protected ArrayList<String> outtypelist;//��������
	protected String serachtype;//����ʽ
	protected String outstockorg_q;//������
	
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
	public Integer getOutstockid() {
		return outstockid;
	}
	public String[] getOutstockorgs() {
		return outstockorgs;
	}
	public String[] getCategorys() {
		return categorys;
	}
	public String[] getItemsnames() {
		return itemsnames;
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
	public Integer[] getReqnums() {
		return reqnums;
	}
	public Integer[] getChknums() {
		return chknums;
	}
	public Integer[] getOutnums() {
		return outnums;
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
	public String getOuttime_f() {
		return outtime_f;
	}
	public String getOuttime_t() {
		return outtime_t;
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
	public Integer getStockid() {
		return stockid;
	}
	public String getItemsname() {
		return itemsname;
	}
	
	
	
	
	public void setOutstockid(Integer outstockid) {
		this.outstockid = outstockid;
	}
	public void setOutstockorgs(String[] outstockorgs) {
		this.outstockorgs = outstockorgs;
	}
	public void setCategorys(String[] categorys) {
		this.categorys = categorys;
	}
	public void setItemsnames(String[] itemsnames) {
		this.itemsnames = itemsnames;
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
	public void setReqnums(Integer[] reqnums) {
		this.reqnums = reqnums;
	}
	public void setChknums(Integer[] chknums) {
		this.chknums = chknums;
	}
	public void setOutnums(Integer[] outnums) {
		this.outnums = outnums;
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
	public void setOuttime_f(String outtime_f) {
		this.outtime_f = outtime_f;
	}
	public void setOuttime_t(String outtime_t) {
		this.outtime_t = outtime_t;
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
	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}
	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
	}
	public List<String> getReqstatusList() {
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
	public String getCategory_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getOuttype_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqorg_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqstatus_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqtime_f() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqtime_t() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getSortType() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getStockorg() {
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
