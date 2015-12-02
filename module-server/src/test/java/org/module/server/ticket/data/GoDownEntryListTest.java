package org.module.server.ticket.data;

import java.rmi.RemoteException;

import junit.framework.TestCase;

import org.module.common.po.GoDownEntryListPO;
import org.module.common.po.State;
import org.module.server.data.ticketData.GoDownEntryListDataImpl;

public class GoDownEntryListTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testGoDownEntryListDataImpl() {
		try {
			GoDownEntryListDataImpl data = new GoDownEntryListDataImpl();
			GoDownEntryListPO po = new GoDownEntryListPO("025156","courier","date", "destination",
					"qu", "pai","jia", "wei",State.SUBMITTED);
			data.add(po);
			
			assert(data.getAll().size()>0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
