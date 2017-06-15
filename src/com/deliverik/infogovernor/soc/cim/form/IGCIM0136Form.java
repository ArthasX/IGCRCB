package com.deliverik.infogovernor.soc.cim.form;



import com.deliverik.framework.base.BaseForm;

/**
 * 人员查询画面FORM
 * 
 */
public class IGCIM0136Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	protected String tableName;
	
	protected String numRows;
	
	protected String tableSpaceName;
	
	protected String instanceName;
	
	protected String businessName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getNumRows() {
		return numRows;
	}

	public void setNumRows(String numRows) {
		this.numRows = numRows;
	}

	public String getTableSpaceName() {
		return tableSpaceName;
	}

	public void setTableSpaceName(String tableSpaceName) {
		this.tableSpaceName = tableSpaceName;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
}
