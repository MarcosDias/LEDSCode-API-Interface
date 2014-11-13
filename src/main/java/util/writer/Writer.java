package util.writer;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import model.Specification;

public class Writer {

	private final String EXTENTION = "ledscodemodel";

	public void writeXML(String filePath, String documentName, Specification model)
			throws IOException {

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;

		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put(EXTENTION, new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();

		// Create a resource
		Resource resource = resSet.createResource(URI.createURI(filePath
				+ File.separator + documentName + "." + EXTENTION));

		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		resource.getContents().add(model);

		// Now save the content.
		resource.save(Collections.EMPTY_MAP);
	}
}
