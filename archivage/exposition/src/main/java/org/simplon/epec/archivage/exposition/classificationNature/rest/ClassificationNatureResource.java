package org.simplon.epec.archivage.exposition.classificationNature.rest;

import org.simplon.epec.archivage.application.classificationNature.ClassificationNatureService;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classificationNatures")
@CrossOrigin("**")
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
    public ClassificationNature findByClassificationNatureCode(@RequestParam(value = "classificationNature", required = true) int classificationNatureCode) {
        return classificationNatureService.findByClassificationNatureCode(classificationNatureCode);
    }

    @GetMapping("/get-all-classificationNature")
    public List<ClassificationNature> getAll() {
        return classificationNatureService.getAllClassificationNature();
    }

    @GetMapping("/get-all-classificationNature-keyWord")
    public List<ClassificationNature> getByKeyWord(@RequestParam(value = "keyword", required = true, defaultValue = "") String keyword) {
        return classificationNatureService.getAllClassificationNatureByKeyWord(keyword);
    }

    @GetMapping("/get-by-id")
    public ClassificationNature getById(@RequestParam(value = "classificationNatureId") String classificationNatureId){
        return classificationNatureService.findByClassificationNatureId(classificationNatureId);
    }

    @PutMapping("/update-one")
    public ClassificationNature updateClassificationNature(@RequestBody ClassificationNature classificationNature) {
        return classificationNatureService.updateClassificationNature(classificationNature);
    }

    @DeleteMapping("/delete-one")
    public void removeClassificationNature(@RequestParam(value = "classificationNatureId") String classificationNatureId) {
        classificationNatureService.removeClassificationNature(classificationNatureId);
    }
/*
    @PutMapping("/add-all")
    public List<ClassificationNature> AddAllClassificationNature(@RequestBody(required = true) List<ClassificationNature> classificationNatures) {
        return classificationJpaNatureRepository.saveAll(classificationNatures);
    }
 */

}
