package com.deliverik.framework.chain.commands;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.chain.commands.ActionCommandBase;
import org.apache.struts.chain.contexts.ActionContext;
import org.apache.struts.chain.contexts.ServletActionContext;

/**
 * Check and set request encoding.</br>
 * Typically the configuration should be specified within ApplicationResources.properties like:
 * config.encode=UTF-8
 *
 */


public class SetEncodingCommnad extends ActionCommandBase
{
  /**
   * Set request encoding.
   * @param context
   * @return false
   * @throws UnsupportedEncodingException 
   * @see org.apache.struts.chain.commands.ActionCommand#execute(org.apache.struts.chain.contexts.ActionContext)
   */
  public boolean execute(ActionContext context) throws UnsupportedEncodingException {

      ServletActionContext saContext = (ServletActionContext)context;
      HttpServletRequest request = saContext.getRequest();
      String encoding = saContext.getMessageResources().getMessage("config.encode");
      request.setCharacterEncoding(encoding);

    return false;

  }
}

