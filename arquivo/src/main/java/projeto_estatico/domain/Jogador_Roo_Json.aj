// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package projeto_estatico.domain;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import projeto_estatico.domain.Jogador;

privileged aspect Jogador_Roo_Json {
    
    public String Jogador.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String Jogador.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static Jogador Jogador.fromJsonToJogador(String json) {
        return new JSONDeserializer<Jogador>()
        .use(null, Jogador.class).deserialize(json);
    }
    
    public static String Jogador.toJsonArray(Collection<Jogador> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String Jogador.toJsonArray(Collection<Jogador> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<Jogador> Jogador.fromJsonArrayToJogadors(String json) {
        return new JSONDeserializer<List<Jogador>>()
        .use("values", Jogador.class).deserialize(json);
    }
    
}
