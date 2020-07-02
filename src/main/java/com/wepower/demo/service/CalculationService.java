package com.wepower.demo.service;

import com.wepower.demo.model.domain.CustomerType;
import com.wepower.demo.model.domain.Price;
import com.wepower.demo.model.domain.SerachHistroy;
import com.wepower.demo.model.request.CalculationRequest;
import com.wepower.demo.model.response.CalculationResponce;
import com.wepower.demo.repository.PriceRepository;
import com.wepower.demo.repository.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CalculationService {

    @Autowired
    private PriceRepository priceRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SearchHistoryRepository searchHistory;


    public List<SerachHistroy> history() {
        return searchHistory.findAll();
    }

    public CalculationResponce calculatePrice(CalculationRequest request) {
        CalculationResponce calculationResponce = new CalculationResponce();
        TypedQuery<Price> query = entityManager.createQuery("SELECT p FROM Price p " +
                "join fetch p.customerTypes ct " +
                "WHERE ct.type = :cystomerType ", Price.class);
        query.setParameter("cystomerType", request.getCustomerType());

        try {
            List<Price> selectedPrices = query.getResultList();
            double productQuarterlyPrice = 0;
            double productBasePrice = 0;
            double summaryPrice = 0;
            List<Double> productQuarterlyPrices = new ArrayList<>();
            if (!selectedPrices.isEmpty()) {
                for (Price price : selectedPrices) {
                    CustomerType customerType = new ArrayList<>(price.getCustomerTypes()).get(0);
                    if (request.getProductType().equals("Energy")) {
                        productQuarterlyPrice = Double.parseDouble(price.getEnergyPrice()) * Double.parseDouble(customerType.getValue());
                    } else if (request.getProductType().equals("LGS")) {
                        productQuarterlyPrice = Double.parseDouble(price.getLGSPrice()) * Double.parseDouble(customerType.getValue());
                    }
                    productQuarterlyPrices.add(productQuarterlyPrice);
                }
            }

            productBasePrice = calculateAverage(productQuarterlyPrices);
            summaryPrice = calculateSum(productQuarterlyPrices);
            calculationResponce.setProductBasePrice(String.valueOf(productBasePrice));
            calculationResponce.setSummaryPrice(String.valueOf(summaryPrice));

            SerachHistroy serachHistroy = new SerachHistroy();
            serachHistroy.setStartDate(request.getStartDate());
            serachHistroy.setEndDate(request.getEndDate());
            serachHistroy.setProductBasePrice(String.valueOf(productBasePrice));
            serachHistroy.setSummaryPrice(String.valueOf(summaryPrice));

            if (!serachHistroy.getEndDate().isEmpty()) {
                searchHistory.save(serachHistroy);
            }

        } catch (NoResultException e) {
            return null;
        }

        return calculationResponce;
    }

    private double calculateAverage(List<Double> numbers) {
        double sum = 0;
        if (!numbers.isEmpty()) {
            for (Double mark : numbers) {
                sum += mark;
            }
            return sum / numbers.size();
        }
        return sum;
    }

    private double calculateSum(List<Double> numbers) {
        double sum = 0;
        if (!numbers.isEmpty()) {
            for (Double mark : numbers) {
                sum += mark;
            }
            return sum;
        }
        return sum;
    }

    private String formatDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    private Date formatStringToDate(String dates) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(dates);
        return date;
    }
}

