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
        Specification projectStatic = this.montaProjeto(engine);

        engine.criaProjeto(projectStatic);
    }

    public Specification montaProjeto(Service engine){
        ArrayList<String> languages = engine.getLanguages();
        ArrayList<String> frameworks = engine.getFrameworks(languages.get(0));
        ArrayList<String> database = engine.getDataBase(frameworks.get(0));
        ArrayList<String> orms = engine.getOrms(frameworks.get(0));
        ArrayList<String> applicationTypes = engine.getApplicationType(frameworks.get(0));

        LedsCodeModelFactory factory = LedsCodeModelFactory.eINSTANCE;

        Specification specification = factory.createSpecification();
        specification.setName("Projeto Estatico");
        specification.setCreatedDate(new Date());

        Feature features = factory.createFeature();
        features.setLanguage(languages.get(0));
        features.setEngine(frameworks.get(0));
        features.setDataBaseName(database.get(0));
        features.setOrm(orms.get(0));
        features.setApplicationType(applicationTypes.get(0));

        specification.setDescribed(features);

        ClassDiagram classDiagram = factory.createClassDiagram();
        classDiagram.setName("BolicheDiagram");

        specification.getHas().add(classDiagram);

        // Classe Jogador
        model.Class jogador = factory.createClass();
        jogador.setName("Jogador");
        jogador.setAbstract(false);
        jogador.getStereotypeClass().add(StereotypeClass.ENTITY);
        jogador.getStereotypeClass().add(StereotypeClass.VIEW);

        // Atributos da class Jogador
        Attribute nomeJogador = factory.createAttribute();
        nomeJogador.setName("nome");

        PrimitiveDataType primitiveDataTypeNomeJogador = factory.createPrimitiveDataType();
        primitiveDataTypeNomeJogador.setType(PrimitiveData.STRING);
        nomeJogador.setType(primitiveDataTypeNomeJogador);

        jogador.getAttributes().add(nomeJogador);

        //Classe Liga
        model.Class liga = factory.createClass();
        liga.setName("Liga");
        liga.setAbstract(false);
        liga.getStereotypeClass().add(StereotypeClass.ENTITY);
        liga.getStereotypeClass().add(StereotypeClass.VIEW);

        //Atributos da classe Liga
        Attribute nomeLiga = factory.createAttribute();
        nomeLiga.setName("nome");

        PrimitiveDataType primitiveDataTypeNomeLiga = factory.createPrimitiveDataType();
        primitiveDataTypeNomeJogador.setType(PrimitiveData.STRING);
        nomeLiga.setType(primitiveDataTypeNomeLiga);

        Attribute jogadores = factory.createAttribute();
        jogadores.setName("jogadores");
        jogadores.setType(jogador);

        liga.getAttributes().add(nomeLiga);
        liga.getAttributes().add(jogadores);

        //Add classes no diagrama
        classDiagram.getComposed().add(jogador);
        classDiagram.getComposed().add(liga);

        return specification;
    }
}

