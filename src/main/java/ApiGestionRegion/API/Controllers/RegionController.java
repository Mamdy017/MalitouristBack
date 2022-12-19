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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/region")
@Api(value = "apiregion", description = "Une API de GESTION des REGIONS pour faciliter a l'agence de touristes")
@AllArgsConstructor


public class RegionController {

    private final RegionService RegionService;

    @ApiOperation(value = "Ajouter une region")
    @PostMapping("/ajout")

    public Object create(@RequestBody Region Region) {

        try {
            return RegionService.creer(Region);
        }catch (Exception e){
            return Message.ErreurReponse("La region " +Region.getNom()+" existe déjà", HttpStatus.OK,null);
        }


    }

    @PostMapping("/upload/")
    public void upload(@RequestParam("file") MultipartFile file) throws IOException {
         RegionService.uploaderImage(file);

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
