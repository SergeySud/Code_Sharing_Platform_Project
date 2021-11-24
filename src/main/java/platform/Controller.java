package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class Controller {
    CodeService codeService;

    @Autowired
    public Controller(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code/{uuid}")
    private ModelAndView getCodeById(@PathVariable UUID uuid) {
        ModelAndView model = new ModelAndView("GetCodeByUUID");
        CodeEntity code = codeService.findCodeEntityByUuid(uuid).get();
        model.addObject("code", code.getCode());
        model.addObject("date", code.getDate());
        model.addObject("time", code.getTime());
        model.addObject("views", code.getViews());
        return model;
    }

    @GetMapping("/api/code/{uuid}")
    public CodeEntity apiGetCodeById(@PathVariable UUID uuid) {
        CodeEntity code = codeService.findCodeEntityByUuid(uuid).get();
        return code;
    }

    @PostMapping("/api/code/new")
    public Map<String, UUID> apiPostCode(@RequestBody CodeEntity params) {
        String code = params.getCode();
        int time = params.getTime();
        int views = params.getViews();

        UUID uuid = codeService.addCode(new CodeEntity(code, time, views));

        return Map.of("id", uuid);
    }

    @GetMapping("/code/new")
    public ModelAndView GetNewCode() {
        return new ModelAndView("getNewCode");
    }

    @GetMapping("api/code/latest")
    public List<CodeEntity> apiGetLatestCode() {
        return codeService.findLatest();
    }

    @GetMapping("code/latest")
    public ModelAndView GetLatestCode() {
        ModelAndView model = new ModelAndView("latestCode");
        model.addObject("codeList", codeService.findLatest());
        return model;
    }
}


/**
 * GET /api/code/N should return JSON with the N-th uploaded code snippet.
 * GET /code/N should return HTML that contains the N-th uploaded code snippet.
 * POST /api/code/new should take a JSON object with a single field code, use it as the current code snippet, and return JSON with a single field id. ID is the unique number of the snippet that helps you access it via the endpoint GET /code/N.
 * GET /code/new should be the same as in the previous stage.
 * GET /api/code/latest should return a JSON array with 10 most recently uploaded code snippets sorted from the newest to the oldest.
 * GET /code/latest should return HTML that contains 10 most recently uploaded code snippets. Use the title Latest for this page.
 */


