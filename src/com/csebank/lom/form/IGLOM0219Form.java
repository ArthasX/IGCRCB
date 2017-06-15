package com.csebank.lom.form;

import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.condition.GoutstockSearchCond;
import com.deliverik.framework.base.BaseForm;

public class IGLOM0219Form extends BaseForm implements GoutstockSearchCond {

	private static final long serialVersionUID = -9166241878591311552L;

	
	/**出库类型 */
	protected String gotype;
	
	protected List<String> gotypeList;
	
	/**出库查询开始时间  */
	protected String gotime_f;
	
	/**出库查询结束时间  */
	protected String gotime_t;
	
	/**物品名称 */
	protected String goname;
	
	/**领用部门 */
	protected String goreqorg;
	
	/**领用/调剂人员 */
	protected String gorequsername;
	
	/**机构码 */
	protected String goorg;
	
	protected String goorgname;
	
	public String getGiodcategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodchkid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodchkkname() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGiodchknum() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodcode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGiodid() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGiodinnum() {
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal getGiodinprice() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodname() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodorg() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodoutype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodprovider() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodpurchaser() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGiodreliefnum() {
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal getGiodreliefprice() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodreqnum() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodreqorg() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodrequser() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodrequsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodtime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodtype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodunit() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGioduser() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodusername() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGioid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiotime_f() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiotime_t() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGoid() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	public String getGotype() {
		return gotype;
	}

	public void setGotype(String gotype) {
		this.gotype = gotype;
	}

	public String getGotime_f() {
		return gotime_f;
	}

	public void setGotime_f(String gotime_f) {
		this.gotime_f = gotime_f;
	}

	public String getGotime_t() {
		return gotime_t;
	}

	public void setGotime_t(String gotime_t) {
		this.gotime_t = gotime_t;
	}

	public String getGoname() {
		return goname;
	}

	public void setGoname(String goname) {
		this.goname = goname;
	}

	public String getGoreqorg() {
		return goreqorg;
	}

	public void setGoreqorg(String goreqorg) {
		this.goreqorg = goreqorg;
	}

	public String getGorequsername() {
		return gorequsername;
	}

	public void setGorequsername(String gorequsername) {
		this.gorequsername = gorequsername;
	}

	public void setGoorg(String goorg) {
		this.goorg = goorg;
	}
	
	

	public String getGoorgname() {
		return goorgname;
	}

	public void setGoorgname(String goorgname) {
		this.goorgname = goorgname;
	}

	public void setGotypeList(List<String> gotypeList) {
		this.gotypeList = gotypeList;
	}

	public String getGocategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGochkid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGochkkname() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGochknum() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGocode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGoinnum() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGoorg() {
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal getGooutprice() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGoprovider() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGopurchaser() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGoreliefnum() {
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal getGoreliefprice() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGoreqnum() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGorequser() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGostatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGotime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGounit() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGouser() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGousername() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getRid() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isHascategory() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setGiodtype(String giodtypeInstock) {
		// TODO Auto-generated method stub
		
	}

	public void setGiodorg(String defaultOrgsyscoding) {
		// TODO Auto-generated method stub
		
	}

	public List<String> getGotypeList() {
		// TODO Auto-generated method stub
		return gotypeList;
	}

	
}
