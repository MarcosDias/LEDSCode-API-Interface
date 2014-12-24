// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package projeto_estatico.domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;
import projeto_estatico.domain.Jogador;
import projeto_estatico.domain.JogadorDataOnDemand;

privileged aspect JogadorDataOnDemand_Roo_DataOnDemand {
    
    declare @type: JogadorDataOnDemand: @Component;
    
    private Random JogadorDataOnDemand.rnd = new SecureRandom();
    
    private List<Jogador> JogadorDataOnDemand.data;
    
    public Jogador JogadorDataOnDemand.getNewTransientJogador(int index) {
        Jogador obj = new Jogador();
        return obj;
    }
    
    public Jogador JogadorDataOnDemand.getSpecificJogador(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Jogador obj = data.get(index);
        Long id = obj.getId();
        return Jogador.findJogador(id);
    }
    
    public Jogador JogadorDataOnDemand.getRandomJogador() {
        init();
        Jogador obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Jogador.findJogador(id);
    }
    
    public boolean JogadorDataOnDemand.modifyJogador(Jogador obj) {
        return false;
    }
    
    public void JogadorDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Jogador.findJogadorEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Jogador' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Jogador>();
        for (int i = 0; i < 10; i++) {
            Jogador obj = getNewTransientJogador(i);
            try {
                obj.persist();
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}