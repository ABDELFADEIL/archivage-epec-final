package org.simplon.epec.archivage.exposition.classificationNature.rest;

import org.simplon.epec.archivage.application.classificationNature.ClassificationNatureService;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classificationNatures")
public class ClassificationNatureResource {


    private final ClassificationNatureService classificationNatureService;

    public ClassificationNatureResource(ClassificationNatureService classificationNatureService) {
        this.classificationNatureService = classificationNatureService;
    }


    @PostMapping("/create-classificationNature")
    public ClassificationNature addClassificationNature(@RequestBody(required = true) ClassificationNature classificationNature) {
        return classificationNatureService.addClassificationNature(classificationNature);
    }


    @GetMapping("/get-classificationNature-code")
    public ClassificationNature findByClassificationNatureCode(@RequestParam(value = "classificationNature", required = true) String classificationNatureCode) {
        return classificationNatureService.findByClassificationNatureCode(classificationNatureCode);
    }
}
