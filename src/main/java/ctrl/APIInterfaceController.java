package ctrl;

import br.edu.ifes.leds.ledscode.ctrl.EngineController;
import model.*;
import model.Class;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;


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
        Specification specificationStaticProject = this.createStaticProject();

        xmlController.escreveArquivoXMl(specificationStaticProject);

        engine.acordarEngine("arquivo/" + specificationStaticProject.getName() + ".xml");
    }

    /**
     * Metodo que cria um projeto estatico.
     *
     * @return Retorna uma especificacao de um projeto.
     */
    public Specification createStaticProject() {
        ArrayList<String> languages = engine.getLanguages();
        ArrayList<String> frameworks = engine.getFrameworks(languages.get(0));
        ArrayList<String> database = engine.getDataBase(frameworks.get(0));
        ArrayList<String> orms = engine.getOrms(frameworks.get(0));
        ArrayList<String> applicationTypes = engine.getApplicationType(frameworks.get(0));

        Specification specification = new Specification();
        specification.setName("Projeto_Estatico");
        specification.setCreatedDate(Calendar.getInstance());

        Feature feature = new Feature();
        feature.setLanguage(languages.get(0));
        feature.setFramework(frameworks.get(0));
        feature.setDatabase(database.get(0));
        feature.setOrm(orms.get(0));
        feature.setApplicationType(applicationTypes.get(0));

        specification.setFeature(feature);

        ClassDiagram classDiagram = new ClassDiagram();
        classDiagram.setName("BolicheDiagram");

        specification.setClassDiagram(classDiagram);

        // Classe Jogador
        model.Class jogador = new model.Class();
        jogador.setName("Jogador");
        jogador.setAbstractClass(false);
        jogador.getStereotypeClasses().add(StereotypeClass.ENTITY);
        jogador.getStereotypeClasses().add(StereotypeClass.VIEW);

        // Atributos da class Jogador
        Attribute nomeJogador = new Attribute();
        nomeJogador.setName("nome");

        PrimitiveType primitiveTypeNomeJogador = new PrimitiveType();
        primitiveTypeNomeJogador.setType(Primitive.STRING);
        nomeJogador.setType(primitiveTypeNomeJogador);

        jogador.getAttributes().add(nomeJogador);

        //Classe Liga
        model.Class liga = new Class();
        liga.setName("Liga");
        liga.setAbstractClass(false);
        liga.getStereotypeClasses().add(StereotypeClass.ENTITY);
        liga.getStereotypeClasses().add(StereotypeClass.VIEW);

        //Atributos da classe Liga
        Attribute nomeLiga = new Attribute();
        nomeLiga.setName("nome");

        PrimitiveType primitiveDataTypeNomeLiga = new PrimitiveType();
        primitiveDataTypeNomeLiga.setType(Primitive.STRING);
        nomeLiga.setType(primitiveDataTypeNomeLiga);

        Attribute jogadores = new Attribute();
        jogadores.setName("jogadores");
        jogadores.setType(jogador);

        liga.getAttributes().add(nomeLiga);
        liga.getAttributes().add(jogadores);

        //Add classes no diagrama
        classDiagram.getClasses().add(jogador);
        classDiagram.getClasses().add(liga);

        return specification;
    }

    public APIInterfaceController(){
        this.engine = new EngineController();
        this.xmlController = new XmlController();
    }
}

