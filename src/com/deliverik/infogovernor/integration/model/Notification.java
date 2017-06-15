package com.deliverik.infogovernor.integration.model;

import com.deliverik.framework.base.BaseModel;

public interface Notification  extends BaseModel {

	public abstract Integer getNfid();

	public abstract String getNfinitime();

	public abstract String getNfsdrtime();

	public abstract String getNfexptime();

	public abstract String getNftitle();

	public abstract Integer getNfsdrrid();

	public abstract String getNfsdrrname();

	public abstract String getNfsdruid();

	public abstract String getNfsdruname();

	public abstract String getNftype();

	public abstract String getNftarget();

	public abstract String getNfstatus();

}