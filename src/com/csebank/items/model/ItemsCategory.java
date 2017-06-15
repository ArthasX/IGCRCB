package com.csebank.items.model;

import com.deliverik.framework.base.BaseModel;

public interface ItemsCategory extends BaseModel{

	public abstract Integer getIcid();

	public abstract String getCategory();

	public abstract String getSeqcode();

	public abstract String getTypecode();

	public abstract String getType();

	public abstract String getDesc();

	public abstract String getStatus();

}