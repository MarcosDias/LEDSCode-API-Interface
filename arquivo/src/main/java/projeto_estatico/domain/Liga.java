package projeto_estatico.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class Liga {

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Liga> nome = new HashSet<Liga>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Liga> jogadores = new HashSet<Liga>();
}
