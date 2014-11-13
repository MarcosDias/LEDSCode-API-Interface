package ctrl;

import br.edu.ifes.leds.ledscode.serv.Service;
import model.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by marcosdias on 12/11/14.
 */
public class Controller {

    public void staticProject(){

        Service engine = new Service();
        ArrayList<String> languages = engine.getLanguages();
        ArrayList<String> frameworks = engine.getFrameworks(languages.get(0));
        ArrayList<String> database = engine.getDataBase(frameworks.get(0));
        ArrayList<String> orms = engine.getOrms(frameworks.get(0));
        ArrayList<String> applicationTypes = engine.getApplicationType(frameworks.get(0));

        LedsCodeModelFactory factory = LedsCodeModelFactory.eINSTANCE;

        Specification specification = factory.createSpecification();
        specification.setName("teste");
        specification.setCreatedDate(new Date());

        Feature features = factory.createFeature();
        features.setLanguage(languages.get(0));
        features.setEngine(frameworks.get(0));
        features.setDataBaseName(database.get(0));
        features.setOrm(orms.get(0));
        features.setApplicationType(applicationTypes.get(0));

        specification.setDescribed(features);

        ClassDiagram classDiagram = factory.createClassDiagram();
        classDiagram.setName("Boliche");

        specification.getHas().add(classDiagram);

        model.Class jogador = factory.createClass();

        classDiagram.getComposed().add(jogador);

        jogador.setName("Jogador");
        jogador.setAbstract(false);
        jogador.getStereotypeClass().add(StereotypeClass.ENTITY);
        jogador.getStereotypeClass().add(StereotypeClass.VIEW);

        Attribute nome = factory.createAttribute();
        nome.setName("nome");

        PrimitiveDataType primitiveDataType = factory.createPrimitiveDataType();
        primitiveDataType.setType(PrimitiveData.STRING);
        nome.setType(primitiveDataType);

        jogador.getAttributes().add(nome);

//        engine.criaProjeto(Specification);
    }
}
