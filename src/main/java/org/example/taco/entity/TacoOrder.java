package org.example.taco.entity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.example.taco.dto.TacoDto;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder implements Serializable {

    private Long id;

    private String deliveryName;

    private String deliveryStreet;

    private String deliveryCity;

    private String deliveryState;

    private String deliveryZip;

    private String ccNumber;

    private String ccExpiration;

    private String ccCVV;

    private List<TacoDto> tacos = new ArrayList<>();

    private Date placedAt;

    public void addTaco(TacoDto taco) {
        this.tacos.add(taco);
    }
}

