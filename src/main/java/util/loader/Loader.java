package util.loader;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import model.LedsCodeModelPackage;
import model.Model;

public class Loader {
	private final String EXTENTION = "xml";

	private EObject loader(String pathXML, String ext) throws IOException {
		LedsCodeModelPackage.eINSTANCE.eClass();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put(ext, new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createURI(pathXML), true);
		return resource.getContents().get(0);
	}

	public Model load(String modelPath) throws IOException {
		return (Model) this.loader(modelPath, EXTENTION);
	}
}
