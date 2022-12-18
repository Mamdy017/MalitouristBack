package ApiGestionRegion.API.Controllers;

import ApiGestionRegion.API.Modele.Message;
import ApiGestionRegion.API.Modele.Pays;
import ApiGestionRegion.API.Modele.Region;
import ApiGestionRegion.API.Services.RegionService;
import ApiGestionRegion.API.img.image;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/region")
@Api(value = "apiregion", description = "Une API de GESTION des REGIONS pour faciliter a l'agence de touristes")
@AllArgsConstructor


public class RegionController {

    private final RegionService RegionService;

    @ApiOperation(value = "Ajouter une region")
    @PostMapping("/creer")

    public Object create(@RequestBody Region Region) {

        try {
            return RegionService.creer(Region);
        }catch (Exception e){
            return Message.ErreurReponse("La region " +Region.getNom()+" existe déjà", HttpStatus.OK,null);
        }


    }

    @PostMapping("/ajout")
    public Object create(@Param("nom") String nom, @Param("code_region") String code_region, @Param("activite") String activite,
                         @Param("paysId") Pays paysId, @Param("superficie") String superficie, @Param("description") String description,
                         @Param("file") MultipartFile file,@Param("file3") MultipartFile file3,  @Param("file2") MultipartFile file2) throws IOException {
        Region region= new Region();
        String img1 = StringUtils.cleanPath(file.getOriginalFilename());
        String img2 = StringUtils.cleanPath(file2.getOriginalFilename());
        String img3 = StringUtils.cleanPath(file2.getOriginalFilename());
        region.setNom(nom);
        region.setCode_region(code_region);
        region.setActivite(activite);
        region.setSuperficie(superficie);
        region.setDescription(description);
        region.setImg1(img1);
        region.setImg2(img2);
        region.setImg3(img3);
        region.setPays(paysId);
        String uploRegion ="C:\\Users\\Camara\\Desktop\\ApiRegion\\MaliTourist\\MaliTouristBack\\src\\main\\resources\\image";
        image.saveimgR(uploRegion, img1,  file);
        image.saveimgR(uploRegion, img2,  file);
        image.saveimgR(uploRegion, img3,  file);
        return RegionService.creer(region);

    }



    @ApiOperation(value = "La liste des regions")
    @GetMapping("/afficher")
    public List<Region> Lire(){
        return RegionService.lire();

    }

    @ApiOperation(value = "La liste des regions sans pays")
    @GetMapping("/sans")
    public List<Object[]> Afficher(){
        return RegionService.getRegionsP();

    }
     @ApiOperation(value = "Modifier une region")
    @PutMapping("/modifier/{Id}")
    public Region Modifier(@PathVariable Long Id, Region Region) {
        return RegionService.modifier( Id, Region);
    }

    @ApiOperation(value = "Supprimer une region")
    @DeleteMapping("/delete/{Id}")
    public String delete(@PathVariable Long Id) {
        return RegionService.supprimer(Id);
    }


}
