/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.takehome1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fuadi
 */
@Controller
public class myController {
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/templates";
    @RequestMapping("/pindahhalaman")
    public String pindah(
            @RequestParam(value = "varN") String isinama,
            @RequestParam(value = "varL") String isilokasi,
            @RequestParam(value = "varG") MultipartFile isigambar,
            Model kurir) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, isigambar.getOriginalFilename());
        fileNames.append(isigambar.getOriginalFilename());
        Files.write(fileNameAndPath, isigambar.getBytes());
        
        kurir.addAttribute("paketN", isinama);
        kurir.addAttribute("paketL", isilokasi);
        kurir.addAttribute("paketG", isigambar);
        
        return "viewpage";
    }
}