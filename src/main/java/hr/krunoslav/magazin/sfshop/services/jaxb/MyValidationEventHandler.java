package hr.krunoslav.magazin.sfshop.services.jaxb;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyValidationEventHandler implements ValidationEventHandler {

	private static final Logger LOG = LogManager.getLogger(MyValidationEventHandler.class);

	@Override
	public boolean handleEvent(ValidationEvent event) {
		LOG.trace("\nEVENT");
		LOG.trace("SEVERITY:  " + event.getSeverity());
		LOG.trace("MESSAGE:  " + event.getMessage());
		LOG.trace("LINKED EXCEPTION:  " + event.getLinkedException());
		LOG.trace("LOCATOR");
		LOG.trace("    LINE NUMBER:  " + event.getLocator().getLineNumber());
		LOG.trace("    COLUMN NUMBER:  " + event.getLocator().getColumnNumber());
		LOG.trace("    OFFSET:  " + event.getLocator().getOffset());
		LOG.trace("    OBJECT:  " + event.getLocator().getObject());
		LOG.trace("    NODE:  " + event.getLocator().getNode());
		LOG.trace("    URL:  " + event.getLocator().getURL());
		return false;
	}

}
