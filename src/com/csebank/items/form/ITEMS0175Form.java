/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.items.form;

import java.util.ArrayList;
import java.util.List;

import com.csebank.items.model.condition.OutStockSearchCond;
import com.deliverik.framework.base.BaseForm;

public class ITEMS0175Form extends BaseForm implements OutStockSearchCond {

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
	protected Integer[] stocknum;//��������
	protected Integer[] chknums;//�����������
	protected Integer[] outnums;//ʵ�ʳ�������
	protected String[] types;//��Ʒ����
	
	protected String outtype;//��������
	protected String reqstatusa;
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
	protected String Typecode_q;//��Ʒ����
	
	public Integer getOutstockid() {
		return outstockid;
	}
	public void setOutstockid(Integer outstockid) {
		this.outstockid = outstockid;
	}
	public String[] getOutstockorgs() {
		return outstockorgs;
	}
	public void setOutstockorgs(String[] outstockorgs) {
		this.outstockorgs = outstockorgs;
	}
	public String[] getCategorys() {
		return categorys;
	}
	public void setCategorys(String[] categorys) {
		this.categorys = categorys;
	}
	public String[] getItemsnames() {
		return itemsnames;
	}
	public void setItemsnames(String[] itemsnames) {
		this.itemsnames = itemsnames;
	}
	public String[] getSeqcodes() {
		return seqcodes;
	}
	public void setSeqcodes(String[] seqcodes) {
		this.seqcodes = seqcodes;
	}
	public String[] getTypecodes() {
		return typecodes;
	}
	public void setTypecodes(String[] typecodes) {
		this.typecodes = typecodes;
	}
	public String[] getSeqnos() {
		return seqnos;
	}
	public void setSeqnos(String[] seqnos) {
		this.seqnos = seqnos;
	}
	public Integer[] getBigpacknums() {
		return bigpacknums;
	}
	public void setBigpacknums(Integer[] bigpacknums) {
		this.bigpacknums = bigpacknums;
	}
	public Integer[] getSmallpacknums() {
		return smallpacknums;
	}
	public void setSmallpacknums(Integer[] smallpacknums) {
		this.smallpacknums = smallpacknums;
	}
	public String[] getItemversions() {
		return itemversions;
	}
	public void setItemversions(String[] itemversions) {
		this.itemversions = itemversions;
	}
	public Integer[] getStockids() {
		return stockids;
	}
	public void setStockids(Integer[] stockids) {
		this.stockids = stockids;
	}
	public Integer[] getReqnums() {
		return reqnums;
	}
	public void setReqnums(Integer[] reqnums) {
		this.reqnums = reqnums;
	}
	public Integer[] getChknums() {
		return chknums;
	}
	public void setChknums(Integer[] chknums) {
		this.chknums = chknums;
	}
	public Integer[] getOutnums() {
		return outnums;
	}
	public void setOutnums(Integer[] outnums) {
		this.outnums = outnums;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	public String getOuttype() {
		return outtype;
	}
	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}
	public String getReqorg() {
		return reqorg;
	}
	public void setReqorg(String reqorg) {
		this.reqorg = reqorg;
	}
	public String getReqid() {
		return reqid;
	}
	public void setReqid(String reqid) {
		this.reqid = reqid;
	}
	public String getReqname() {
		return reqname;
	}
	public void setReqname(String reqname) {
		this.reqname = reqname;
	}
	public String getReqtime() {
		return reqtime;
	}
	public void setReqtime(String reqtime) {
		this.reqtime = reqtime;
	}
	public String getChkreason() {
		return chkreason;
	}
	public void setChkreason(String chkreason) {
		this.chkreason = chkreason;
	}
	public String getPakreason() {
		return pakreason;
	}
	public void setPakreason(String pakreason) {
		this.pakreason = pakreason;
	}
	public String getPackno() {
		return packno;
	}
	public void setPackno(String packno) {
		this.packno = packno;
	}
	public String getChkid() {
		return chkid;
	}
	public void setChkid(String chkid) {
		this.chkid = chkid;
	}
	public String getChkname() {
		return chkname;
	}
	public void setChkname(String chkname) {
		this.chkname = chkname;
	}
	public String getChktime() {
		return chktime;
	}
	public void setChktime(String chktime) {
		this.chktime = chktime;
	}
	public String getStockuserid() {
		return stockuserid;
	}
	public void setStockuserid(String stockuserid) {
		this.stockuserid = stockuserid;
	}
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public String getOuttime() {
		return outtime;
	}
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public String getRcvid() {
		return rcvid;
	}
	public void setRcvid(String rcvid) {
		this.rcvid = rcvid;
	}
	public String getRcvname() {
		return rcvname;
	}
	public void setRcvname(String rcvname) {
		this.rcvname = rcvname;
	}
	public String getRcvtime() {
		return rcvtime;
	}
	public void setRcvtime(String rcvtime) {
		this.rcvtime = rcvtime;
	}
	public String getReqstatus() {
		return reqstatus;
	}
	public void setReqstatus(String reqstatus) {
		this.reqstatus = reqstatus;
	}
	public String getAccountstatus() {
		return accountstatus;
	}
	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}
	public Double getInprice() {
		return inprice;
	}
	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}
	public Double getOutprice() {
		return outprice;
	}
	public void setOutprice(Double outprice) {
		this.outprice = outprice;
	}
	public Double getOutamount() {
		return outamount;
	}
	public void setOutamount(Double outamount) {
		this.outamount = outamount;
	}
	public String getOuttime_f() {
		return outtime_f;
	}
	public void setOuttime_f(String outtime_f) {
		this.outtime_f = outtime_f;
	}
	public String getOuttime_t() {
		return outtime_t;
	}
	public void setOuttime_t(String outtime_t) {
		this.outtime_t = outtime_t;
	}
	public String getOutstockorg() {
		return outstockorg;
	}
	public void setOutstockorg(String outstockorg) {
		this.outstockorg = outstockorg;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSeqcode() {
		return seqcode;
	}
	public void setSeqcode(String seqcode) {
		this.seqcode = seqcode;
	}
	public Integer getStockid() {
		return stockid;
	}
	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}
	public String getItemsname() {
		return itemsname;
	}
	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<String> getOuttypelist() {
		return outtypelist;
	}
	public void setOuttypelist(ArrayList<String> outtypelist) {
		this.outtypelist = outtypelist;
	}
	public String getSerachtype() {
		return serachtype;
	}
	public void setSerachtype(String serachtype) {
		this.serachtype = serachtype;
	}
	public String getOutstockorg_q() {
		return outstockorg_q;
	}
	public void setOutstockorg_q(String outstockorg_q) {
		this.outstockorg_q = outstockorg_q;
	}
	public String getAccountstatus_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCategory_q() {
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
	public String getOuttype_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqorg_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> getReqstatusList() {
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
	public String getTypecode_q() {
		return Typecode_q;
	}
	public void setTypecode_q(String typecode_q) {
		Typecode_q = typecode_q;
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
	public Integer[] getStocknum() {
		return stocknum;
	}
	public void setStocknum(Integer[] stocknum) {
		this.stocknum = stocknum;
	}
	
	
	
}
