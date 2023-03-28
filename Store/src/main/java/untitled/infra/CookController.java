package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

@RestController
// @RequestMapping(value="/cooks")
@Transactional
public class CookController {

    @Autowired
    CookRepository cookRepository;

    @RequestMapping(
        value = "cooks/{id}/comfimyes or no",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cook comfimYesOrNo(
        @PathVariable(value = "id") Long id,
        @RequestBody ComfimYesOrNoCommand comfimYesOrNoCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cook/comfimYesOrNo  called #####");
        Optional<Cook> optionalCook = cookRepository.findById(id);

        optionalCook.orElseThrow(() -> new Exception("No Entity Found"));
        Cook cook = optionalCook.get();
        cook.comfimYesOrNo(comfimYesOrNoCommand);

        cookRepository.save(cook);
        return cook;
    }
}
