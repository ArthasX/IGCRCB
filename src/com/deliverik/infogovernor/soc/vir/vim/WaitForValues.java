/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.vim;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.ObjectUpdate;
import com.vmware.vim25.ObjectUpdateKind;
import com.vmware.vim25.PropertyChange;
import com.vmware.vim25.PropertyChangeOp;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertyFilterUpdate;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.mo.ServiceInstance;

public class WaitForValues {
	public static Object[] waitForValues(
			  ServiceInstance si,ManagedObjectReference objmor, String[] filterProps,
	          String[] endWaitProps, Object[][] expectedVals) throws Exception {
		  VimPortType vimPort = si.getServerConnection().getVimService();
		  
		  ManagedObjectReference SIMO_REF = new ManagedObjectReference();
		  SIMO_REF.setType("ServiceInstance");
	      SIMO_REF.set_value("ServiceInstance");
	      ServiceContent serviceContent = vimPort.retrieveServiceContent(SIMO_REF);
	      ManagedObjectReference propCollector = serviceContent.getPropertyCollector();
	      
	      String version = "";
	      Object[] endVals = new Object[endWaitProps.length];
	      Object[] filterVals = new Object[filterProps.length];

	      PropertyFilterSpec spec = new PropertyFilterSpec();
	      spec.setObjectSet(new ObjectSpec[]{new ObjectSpec()});
	      spec.getObjectSet()[0].setObj(objmor);

	      spec.setPropSet(new PropertySpec[]{new PropertySpec()});
	      spec.getPropSet()[0].setPathSet(filterProps);
	      spec.getPropSet()[0].setType(objmor.getType());

	      spec.getObjectSet()[0].setSelectSet(null);
	      spec.getObjectSet()[0].setSkip(Boolean.FALSE);

	      ManagedObjectReference filterSpecRef = vimPort.createFilter(propCollector, spec, true);

	      boolean reached = false;

	      UpdateSet updateset = null;
	      PropertyFilterUpdate[] filtupary = null;
	      PropertyFilterUpdate filtup = null;
	      ObjectUpdate[] objupary = null;
	      ObjectUpdate objup = null;
	      PropertyChange[] propchgary = null;
	      PropertyChange propchg = null;
	      while (!reached) {
	          updateset =
	                  vimPort.waitForUpdates(propCollector, version);

	          version = updateset.getVersion();

	          if (updateset == null || updateset.getFilterSet() == null) {
	              continue;
	          }

	          // Make this code more general purpose when PropCol changes later.
	          filtupary = updateset.getFilterSet();
	          filtup = null;
	          for (int fi = 0; fi < filtupary.length; fi++) {
	              filtup = filtupary[fi];
	              objupary = filtup.getObjectSet();
	              objup = null;
	              propchgary = null;
	              for (int oi = 0; oi < objupary.length; oi++) {
	                  objup = objupary[oi];

	                  // TODO: Handle all "kind"s of updates.
	                  if (objup.getKind() == ObjectUpdateKind.modify ||
	                          objup.getKind() == ObjectUpdateKind.enter ||
	                          objup.getKind() == ObjectUpdateKind.leave) {
	                      propchgary = objup.getChangeSet();
	                      for (int ci = 0; ci < propchgary.length; ci++) {
	                          propchg = propchgary[ci];
	                          updateValues(endWaitProps, endVals, propchg);
	                          updateValues(filterProps, filterVals, propchg);
	                      }
	                  }
	              }
	          }

	          Object expctdval = null;
	          // Check if the expected values have been reached and exit the loop if done.
	          // Also exit the WaitForUpdates loop if this is the case.
	          for (int chgi = 0; chgi < endVals.length && !reached; chgi++) {
	              for (int vali = 0; vali < expectedVals[chgi].length && !reached; vali++) {
	                  expctdval = expectedVals[chgi][vali];

	                  reached = expctdval.equals(endVals[chgi]) || reached;
	              }
	          }
	      }
	      
	      // Destroy the filter when we are done.
	      vimPort.destroyPropertyFilter(filterSpecRef);

	      return filterVals;
	  }
	  
	  protected static void updateValues(String[] props, Object[] vals, PropertyChange propchg) {
	      for (int findi = 0; findi < props.length; findi++) {
	          if (propchg.getName().lastIndexOf(props[findi]) >= 0) {
	              if (propchg.getOp() == PropertyChangeOp.remove) {
	                  vals[findi] = "";
	              } else {
	                  vals[findi] = propchg.getVal();
	              //System.out.println("Changed value : " + propchg.getVal());
	              }
	          }
	      }
	  }
}
