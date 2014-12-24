package ctrl;

import br.edu.ifes.leds.ledscode.ctrl.EngineController;
import model.*;

/**
 * @author Marcos Dias
 */
public class Controller {
    private EngineController engine;

    /**
     * Cria um modelo uml estatito, para geracao de codigo
     */
    public void staticProject(){
        Specification specificationStaticProject = engine.createStaticProject();

        engine.generateCodeProject(specificationStaticProject);
    }

    public Controller(){
        this.engine = new EngineController();
    }
}

