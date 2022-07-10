package com.example.test.controller;

import com.example.test.model.InfoPurchaseUser;
import com.example.test.model.Purchase;
import com.example.test.service.InfoPurchaseUserService;
import com.example.test.service.PurchaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.BindException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/admin/users")
public class SalesRestController {
    @Autowired
    private InfoPurchaseUserService infoPurchaseUserService;
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public List<InfoPurchaseUser> getAll(){
        return infoPurchaseUserService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> createSale(@ModelAttribute InfoPurchaseUser infoPurchaseUser, @RequestParam("purchase") String purchaseName){
        if (StringUtils.isEmpty(purchaseName)){
            return ResponseEntity.status(400).body("Выберите покупку");
        }
        Purchase purchase = purchaseService.findByName(purchaseName);
        infoPurchaseUser.setPurchaseItem(purchase);
        infoPurchaseUser.setPurchaseDate(new Date());
        return ResponseEntity.ok(infoPurchaseUserService.save(infoPurchaseUser));
    }

    @PutMapping
    public InfoPurchaseUser updateSale(@ModelAttribute InfoPurchaseUser infoPurchaseUser, @RequestParam("purchase") String purchaseName){
        Purchase purchase = purchaseService.findByName(purchaseName);
        infoPurchaseUser.setPurchaseItem(purchase);
        infoPurchaseUser.setPurchaseDate(new Date());
        return infoPurchaseUserService.save(infoPurchaseUser);
    }
    @PostMapping("/delete")
    public  void deleteUser(@RequestParam("id") Long id) {
        InfoPurchaseUser infoPurchaseUser = infoPurchaseUserService.findById(id).orElse(null);
        infoPurchaseUserService.remove(infoPurchaseUser);
    }


    @GetMapping("/{id}")
    public InfoPurchaseUser getById(@PathVariable Long id){
        return infoPurchaseUserService.findById(id).orElse(null);
    }

    @GetMapping("/purchases")
    public List<Purchase> getAllRoles(){
        return purchaseService.findAll();
    }


    @GetMapping("/lastweek")
    public List<InfoPurchaseUser> getByLastWeek(){
        return infoPurchaseUserService.findByLastWeek();
    }

    @GetMapping("/purchase-name-max-count")
    public ResponseEntity<?> getPurchaseNameByMaxCountLastMonth(){
        return ResponseEntity.ok(infoPurchaseUserService.findPurchaseNameByMaxCountLastMonth());
    }

    @GetMapping("/purchase-nalf-year")
    public ResponseEntity<?> getPurchaseHalfYear(){
        return ResponseEntity.ok(infoPurchaseUserService.findByMaxPurchaseHalfYear());
    }

    @GetMapping("/purchase-name-age")
    public ResponseEntity<?> getPurchaseNameByAge(){
        return ResponseEntity.ok(infoPurchaseUserService.findPurchaseNameByAge());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?>getError(Exception ex){
        return ResponseEntity.status(500).body(ex);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?>getError(BindException ex){
        return ResponseEntity.status(400).body(ex.getAllErrors());
    }
}
