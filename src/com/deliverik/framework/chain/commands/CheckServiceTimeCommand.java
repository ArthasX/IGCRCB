package com.deliverik.framework.chain.commands;

import java.util.Date;

import org.apache.commons.lang.math.IntRange;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.struts.chain.commands.ActionCommandBase;
import org.apache.struts.chain.contexts.ActionContext;
import org.apache.struts.util.MessageResources;

/**
 * Check service availability according system configuration.</br>
 * Typically the configuration should be specified within ApplicationResources.properties like:
 * SERVICE_TIME.FROM=0500
 * SERVICE_TIME.TO=0259
 * 
 */


public class CheckServiceTimeCommand extends ActionCommandBase
{

	private static FastDateFormat timeFormat = FastDateFormat.getInstance("HHmm");

  /**
   * Check service availability according system configuration.
   * @param actionContext
   * @return false
   * @throws CheckServiceTimeException 
   * @see org.apache.struts.chain.commands.ActionCommand#execute(org.apache.struts.chain.contexts.ActionContext)
   */
  public boolean execute(ActionContext actionContext) throws CheckServiceTimeException {
	  // 
	  MessageResources resources = actionContext.getMessageResources();
      // 
      int fromTime = Integer.valueOf(resources.getMessage("SERVICE_TIME.FROM"));
      int toTime   = Integer.valueOf(resources.getMessage("SERVICE_TIME.TO"));
      int sysTime  = Integer.valueOf(timeFormat.format(new Date()));

      if( toTime == fromTime)
        throw new CheckServiceTimeException();

      if(fromTime < toTime){
    	  // From < To
    	  IntRange range = new IntRange(fromTime, toTime);
    	  //  
    	  if(!range.containsDouble(sysTime))
    		  throw new CheckServiceTimeException();

      }else{
    	  // From > To
    	  IntRange range = new IntRange(toTime, fromTime);
    	  //  
    	  if(range.containsDouble(sysTime))
    		  throw new CheckServiceTimeException();
      }

      return false;

  }
}

