package projeto_estatico.web;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import projeto_estatico.domain.Liga;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;

@RequestMapping("/ligas")
@Controller
@RooWebScaffold(path = "ligas", formBackingObject = Liga.class)
@RooWebJson(jsonObject = Liga.class)
public class LigaController {
}
