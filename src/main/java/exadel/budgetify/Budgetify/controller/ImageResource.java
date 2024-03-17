package exadel.budgetify.Budgetify.controller;


import exadel.budgetify.Budgetify.model.Image;
import exadel.budgetify.Budgetify.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageResource {

    private final ImageService imageService;

    public ImageResource(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/add")
    public ResponseEntity<Image> addImage(@RequestBody Image Image) {
        Image newImage = imageService.addImage(Image);
        return new ResponseEntity<>(newImage, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) {
        imageService.deleteImage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
