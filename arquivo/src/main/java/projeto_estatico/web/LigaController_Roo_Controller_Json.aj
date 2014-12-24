// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package projeto_estatico.web;

import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import projeto_estatico.domain.Liga;
import projeto_estatico.web.LigaController;

privileged aspect LigaController_Roo_Controller_Json {
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> LigaController.showJson(@PathVariable("id") Long id) {
        Liga liga = Liga.findLiga(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (liga == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(liga.toJson(), headers, HttpStatus.OK);
    }
    
    @RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> LigaController.listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Liga> result = Liga.findAllLigas();
        return new ResponseEntity<String>(Liga.toJsonArray(result), headers, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> LigaController.createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        Liga liga = Liga.fromJsonToLiga(json);
        liga.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
        headers.add("Location",uriBuilder.path(a.value()[0]+"/"+liga.getId().toString()).build().toUriString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> LigaController.createFromJsonArray(@RequestBody String json) {
        for (Liga liga: Liga.fromJsonArrayToLigas(json)) {
            liga.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> LigaController.updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Liga liga = Liga.fromJsonToLiga(json);
        liga.setId(id);
        if (liga.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> LigaController.deleteFromJson(@PathVariable("id") Long id) {
        Liga liga = Liga.findLiga(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (liga == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        liga.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
    
}
