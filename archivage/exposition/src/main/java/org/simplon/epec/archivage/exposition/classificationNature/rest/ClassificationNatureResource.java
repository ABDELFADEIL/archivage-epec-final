package org.simplon.epec.archivage.exposition.classificationNature.rest;

import org.simplon.epec.archivage.application.classificationNature.ClassificationNatureService;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classificationNatures")
public class ClassificationNatureResource {


    private final transient ClassificationNatureService classificationNatureService;

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

    @GetMapping("/get-all-classificationNature")
    public List<ClassificationNature> getAll() {
        return classificationNatureService.getAllClassificationNature();
    }

    @GetMapping("/get-by-id")
    public ClassificationNature getById(@RequestParam("classificationNatureId") Long classificationNatureId){
        return classificationNatureService.findByClassificationNatureId(classificationNatureId);
    }

    @PutMapping("/update-one")
    public ClassificationNature updateClassificationNature(@RequestBody ClassificationNature classificationNature) {
        return classificationNatureService.updateClassificationNature(classificationNature);
    }

    @DeleteMapping("/delete-one")
    public void removeClassificationNature(@RequestParam("classificationNatureId") Long classificationNatureId) {
         classificationNatureService.removeClassificationNature(classificationNatureId);
    }


}
