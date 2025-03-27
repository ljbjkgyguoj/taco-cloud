package org.example.taco.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

@Data
public class TacoOrder {

    @NotBlank(message = "Необходимо указать имя получателя")
    private String deliveryName;

    @NotBlank(message = "Необходимо указать адрес доставки")
    private String deliveryStreet;

    @NotBlank(message = "Необходимо указать город доставки")
    private String deliveryCity;

    @NotBlank(message = "Необходимо указать регион доставки")
    private String deliveryState;

    private String deliveryZip;

    @CreditCardNumber(message = "Данный номер не существует")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Необходимо указать дату в формате мм/гг")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Неверный cvv номер")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}

