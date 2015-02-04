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
        feature.setFramework(frameworks.get(1));
        feature.setDatabase(database.get(0));
        feature.setOrm(orms.get(0));
        feature.setApplicationType(applicationTypes.get(0));

        specification.setFeature(feature);

        ClassDiagram classDiagram = new ClassDiagram();
        classDiagram.setName("HospitalDiagram");

        specification.setClassDiagram(classDiagram);

        model.Class pessoa = new model.Class();
        model.Class funcionario = new model.Class();
        model.Class analista = new model.Class();
        model.Class captador = new model.Class();
        model.Class notificador = new model.Class();
        model.Class instituicao = new model.Class();
        model.Class instituicaoNotificadora = new model.Class();
        model.Class bancoOlhos = new model.Class();
        model.Class hospital = new model.Class();
        model.Class setor = new model.Class();
        
        //PESSOA
        pessoa.setName("Pessoa");
        pessoa.setAbstractClass(true);
        pessoa.getStereotypeClasses().add(StereotypeClass.ENTITY);
        pessoa.getStereotypeClasses().add(StereotypeClass.VIEW);

        //ATRIBUTOS -> PESSOA
        Attribute nomePessoa = new Attribute();
        nomePessoa.setName("nome");

        PrimitiveType primitiveTypeNomeJogador = new PrimitiveType();
        primitiveTypeNomeJogador.setName("STRING");
        primitiveTypeNomeJogador.setType(Primitive.STRING);
        nomePessoa.setType(primitiveTypeNomeJogador);

        pessoa.getAttributes().add(nomePessoa);

        //FUNCIONARIO
        funcionario.setName("Funcionario");
        funcionario.setAbstractClass(true);
        funcionario.getStereotypeClasses().add(StereotypeClass.ENTITY);
        funcionario.getStereotypeClasses().add(StereotypeClass.VIEW);
        
        //ATRIBUTOS -> FUNCIONARIO
        Attribute cpf = new Attribute();
        cpf.setName("cpf");
        Attribute documentoComFoto = new Attribute();
        documentoComFoto.setName("documentoComFoto");
        Attribute emailFuncionario = new Attribute();
        emailFuncionario.setName("email");

        PrimitiveType primitiveDataTypecpf = new PrimitiveType();
        primitiveDataTypecpf.setName("STRING");
        PrimitiveType primitiveDataTypeDocumentoComFoto = new PrimitiveType();
        primitiveDataTypeDocumentoComFoto.setName("STRING");
        PrimitiveType primitiveDataTypeEmail = new PrimitiveType();
        primitiveDataTypeEmail.setName("STRING");
        primitiveDataTypecpf.setType(Primitive.STRING);
        primitiveDataTypeDocumentoComFoto.setType(Primitive.STRING);
        primitiveDataTypeEmail.setType(Primitive.STRING);

        cpf.setType(primitiveDataTypecpf);
        documentoComFoto.setType(primitiveDataTypeDocumentoComFoto);
        emailFuncionario.setType(primitiveDataTypeEmail);

        funcionario.getAttributes().add(cpf);
        funcionario.getAttributes().add(documentoComFoto);
        funcionario.getAttributes().add(emailFuncionario);
        
        //ANALISTA
        analista.setName("Analista");
        analista.getStereotypeClasses().add(StereotypeClass.ENTITY);
        analista.getStereotypeClasses().add(StereotypeClass.VIEW);
        analista.setParent(funcionario);
        
        //CAPTADOR
        captador.setName("Captador");
        captador.getStereotypeClasses().add(StereotypeClass.ENTITY);
        captador.getStereotypeClasses().add(StereotypeClass.VIEW);
        captador.setParent(funcionario);
        
        //NOTIFICADOR
        notificador.setName("Notificador");
        notificador.getStereotypeClasses().add(StereotypeClass.ENTITY);
        notificador.getStereotypeClasses().add(StereotypeClass.VIEW);
        notificador.setParent(funcionario);
        
        //INSTITUICAO
        instituicao.setName("Instituicao");
        instituicao.setAbstractClass(true);
        instituicao.getStereotypeClasses().add(StereotypeClass.ENTITY);
        instituicao.getStereotypeClasses().add(StereotypeClass.VIEW);
        
        //ATRIBUTOS -> INSTITUICAO
        Attribute nomeInstituicao = new Attribute();
        nomeInstituicao.setName("nome");
        Attribute cnes = new Attribute();
        cnes.setName("cnes");
        Attribute emailInstituicao = new Attribute();
        emailFuncionario.setName("email");
        Attribute nomeFantasia = new Attribute();
        nomeFantasia.setName("nomeFantasia");
        Attribute funcionarios = new Attribute();
        funcionarios.setName("funcionarios");

        PrimitiveType primitiveDataTypeNomeInstituicao = new PrimitiveType();
        PrimitiveType primitiveDataTypeCnes = new PrimitiveType();
        PrimitiveType primitiveDataTypeEmailInstituicao = new PrimitiveType();
        PrimitiveType primitiveDataTypeNomeFantasia = new PrimitiveType();
        primitiveDataTypeNomeInstituicao.setType(Primitive.STRING);
        primitiveDataTypeCnes.setType(Primitive.STRING);
        primitiveDataTypeEmailInstituicao.setType(Primitive.STRING);
        primitiveDataTypeNomeFantasia.setType(Primitive.STRING);

        nomeInstituicao.setType(primitiveDataTypeNomeInstituicao);
        cnes.setType(primitiveDataTypeCnes);
        emailFuncionario.setType(primitiveDataTypeEmailInstituicao);
        nomeFantasia.setType(primitiveDataTypeNomeFantasia);
        funcionarios.setType(funcionario);

        instituicao.getAttributes().add(nomeInstituicao);
        instituicao.getAttributes().add(cnes);
        instituicao.getAttributes().add(emailFuncionario);
        instituicao.getAttributes().add(nomeFantasia);
        instituicao.getAttributes().add(funcionarios);
        
        //INSTITUICAO NOTIFICADOR
        instituicaoNotificadora.setName("InstituicaoNotificadora");
        instituicaoNotificadora.setAbstractClass(true);
        instituicaoNotificadora.setParent(instituicao);
        instituicaoNotificadora.getStereotypeClasses().add(StereotypeClass.ENTITY);
        instituicaoNotificadora.getStereotypeClasses().add(StereotypeClass.VIEW);
        
        //BANCOOLHOS
        bancoOlhos.setName("BancoOlhos");
        bancoOlhos.setParent(instituicao);
        bancoOlhos.getStereotypeClasses().add(StereotypeClass.ENTITY);
        bancoOlhos.getStereotypeClasses().add(StereotypeClass.VIEW);
        
        //SETOR
        setor.setName("Setor");
        instituicaoNotificadora.getStereotypeClasses().add(StereotypeClass.ENTITY);
        instituicaoNotificadora.getStereotypeClasses().add(StereotypeClass.VIEW);
        
        //ATRIBUTO -> SETOR
        Attribute nomeSetor = new Attribute();
        nomeSetor.setName("nome");

        PrimitiveType primitiveDataTypeNomeSetor = new PrimitiveType();
        primitiveDataTypeNomeSetor.setType(Primitive.STRING);
        nomeSetor.setType(primitiveDataTypeNomeSetor);
        
        setor.getAttributes().add(nomeSetor);
        
        //HOSPITAL
        hospital.setName("Hospital");
        hospital.getStereotypeClasses().add(StereotypeClass.ENTITY);
        hospital.getStereotypeClasses().add(StereotypeClass.VIEW);
        hospital.setParent(instituicaoNotificadora);
        
        //ATRIBUTO -> HOSPITAL
        Attribute setoresHospital = new Attribute();
        setoresHospital.setName("setores");
        setoresHospital.setType(setor);
        Attribute bancoOlhosHospital = new Attribute();
        bancoOlhosHospital.setName("bancoOlhos");
        bancoOlhosHospital.setType(bancoOlhos);
        
        hospital.getAttributes().add(setoresHospital);
        
        //Add classes no diagrama
        classDiagram.getClasses().add(pessoa);
        classDiagram.getClasses().add(funcionario);
        classDiagram.getClasses().add(analista);
        classDiagram.getClasses().add(captador);
        classDiagram.getClasses().add(notificador);
        classDiagram.getClasses().add(instituicao);
        classDiagram.getClasses().add(instituicaoNotificadora);
        classDiagram.getClasses().add(bancoOlhos);
        classDiagram.getClasses().add(hospital);
        classDiagram.getClasses().add(setor);

        return specification;
    }

    public APIInterfaceController(){
        this.engine = new EngineController();
        this.xmlController = new XmlController();
    }
}

