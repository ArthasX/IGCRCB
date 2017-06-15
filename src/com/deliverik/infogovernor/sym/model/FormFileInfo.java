package com.deliverik.infogovernor.sym.model;

import java.io.Serializable;

import org.apache.struts.upload.FormFile;

public class FormFileInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private FormFile file;
	
	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}
}
