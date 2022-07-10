package com.example.test.service;

import com.example.test.model.InfoPurchaseUser;
import com.example.test.model.ReportAge;
import com.example.test.model.ReportFio;
import com.example.test.model.ReportPurchase;
import com.example.test.repository.InfoPurchaseUserRepository;
import com.example.test.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class InfoPurchaseUserService {
    @Autowired
    private InfoPurchaseUserRepository infoPurchaseUserRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;

    public InfoPurchaseUser save(InfoPurchaseUser pojo){
        return infoPurchaseUserRepository.save(pojo);
    }

    public void remove(InfoPurchaseUser pojo){
        infoPurchaseUserRepository.delete(pojo);
    }

    public InfoPurchaseUser update(InfoPurchaseUser pojo){
        return infoPurchaseUserRepository.save(pojo);
    }

    public List<InfoPurchaseUser> getAll(){
        return (List<InfoPurchaseUser>) infoPurchaseUserRepository.findAll();
    }

    public Optional<InfoPurchaseUser> findById(Long id){
        return infoPurchaseUserRepository.findById(id);
    }

    //Вывести список покупок за последнюю неделю
    public List<InfoPurchaseUser> findByLastWeek(){
        LocalDate localDateStart = LocalDate.now().minusDays(7);
        LocalDate localDateEnd = LocalDate.now();
        Date sta = convertToDateViaInstant(localDateStart);
        Date end = convertToDateViaInstant(localDateEnd);

        return infoPurchaseUserRepository.findByLastWeek(
                sta,
                end
        );
    }

    //Вывести самый покупаемый товар за последний месяц
    public List<ReportPurchase> findPurchaseNameByMaxCountLastMonth(){
        LocalDate localDateStart = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate localDateEnd = LocalDate.now().minusMonths(1).withDayOfMonth(30);
        List<String> result = infoPurchaseUserRepository.findPurchaseNameByMaxCountLastMonth(
                convertToDateViaInstant(localDateStart),
                convertToDateViaInstant(localDateEnd)
        );
        List<ReportPurchase> reportPurchases = new ArrayList<>();
        result.forEach(x -> {
            String [] arr = x.split(",");
            reportPurchases.add(new ReportPurchase(arr[0], arr[1]));
        });
        return reportPurchases;
    }


    //Вывести имя и фамилию человека, совершившего больше всего покупок за полгода
    public List<ReportFio> findByMaxPurchaseHalfYear() {
        LocalDate localDateStart = LocalDate.now().minusMonths(6);
        LocalDate localDateEnd = LocalDate.now();
        List<String> results = infoPurchaseUserRepository.findByMaxPurchaseHalfYear(
                convertToDateViaInstant(localDateStart),
                convertToDateViaInstant(localDateEnd)
        );
        List<ReportFio>reports = new ArrayList<>();
        results.forEach(x -> {
            String[] arr = x.split(",");
            ReportFio report = new ReportFio(
                    arr[0],
                    arr[1],
                    arr[2]
            );
            reports.add(report);
        });
        return reports;
    }

    //Что чаще всего покупают люди в возрасте 18 лет
    public List<ReportAge> findPurchaseNameByAge(){
        int age = 18;
        List<String> results = infoPurchaseUserRepository.findPurchaseNameByAge(age);
        List<ReportAge> reportAges = new ArrayList<>();
        results.forEach(x -> {
            String [] arr = x.split(",");
            reportAges.add(new ReportAge(arr[0], arr[1]));
        });
        return reportAges;
    }


    private Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

}
