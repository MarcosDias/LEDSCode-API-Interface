package ctrl;

import br.edu.ifes.leds.ledscode.ctrl.EngineController;
import model.Specification;

import javax.xml.bind.JAXBException;
import java.io.IOException;


/**
 * @author Marcos Dias
 */
public class APIInterfaceController {
    private EngineController engine;
    private XmlController xmlController;

    /**
     * Cria um modelo uml estatito, para geracao de codigo
     */
    public void staticProject() throws JAXBException, IOException {
        Specification specificationStaticProject = engine.createStaticProject();

        xmlController.escreveArquivoXMl(specificationStaticProject);
    }

    public APIInterfaceController(){
        this.engine = new EngineController();
        this.xmlController = new XmlController();
    }
}

