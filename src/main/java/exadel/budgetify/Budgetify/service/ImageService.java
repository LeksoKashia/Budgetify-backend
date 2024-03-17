package exadel.budgetify.Budgetify.service;

import exadel.budgetify.Budgetify.model.Image;
import exadel.budgetify.Budgetify.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private final ImageRepo imageRepo;

    @Autowired
    public ImageService(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    public Image addImage(Image image){
        return imageRepo.save(image);
    }

    public List<Image> findAllImages(){
        return imageRepo.findAll();
    }

    public Image updateImage(Image image){
        return imageRepo.save(image);
    }

    public void deleteImage(Long id){
        imageRepo.deleteById(id);
    }
}
