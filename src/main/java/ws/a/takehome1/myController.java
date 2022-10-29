/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.takehome1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author fuadi
 */
@Controller
public class myController {
    @RequestMapping("/pindahhalaman")
    public String pindah(
            @RequestParam(value = "varN") String isinama,
            @RequestParam(value = "varL") String isilokasi,
            Model kurir) {
        
        kurir.addAttribute("paketN", isinama);
        kurir.addAttribute("paketL", isilokasi);
        
        return "viewpage";
    }
}
