package projeto_estatico.web;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import projeto_estatico.domain.Jogador;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;

@RequestMapping("/jogadors")
@Controller
@RooWebScaffold(path = "jogadors", formBackingObject = Jogador.class)
@RooWebJson(jsonObject = Jogador.class)
public class JogadorController {
}
