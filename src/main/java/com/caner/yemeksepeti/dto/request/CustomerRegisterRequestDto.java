package com.caner.yemeksepeti.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegisterRequestDto {
    @NotBlank(message = "Kullanıcı adını boş bırakmayınız.")
    @Size(min=3, max=20, message="Kullanıcı adı en az 3 en fazla 20 karakter olabilir.")

    private  String name;
    @Email(message="Lütfen geçerli bir email giriniz.")
    private  String email;
    @NotBlank(message="Şifre boş bırakılamaz!")
    @Size(min=8, max=20)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
            message = "Şifrenizde en az bir küçük harf, bir büyük harf, bir rakam ve bir özel işaret bulunmalıdır.")
    private  String password;
    private String repassword;

    @NotBlank(message="Kart bilgileriniz boş kalamaz.")
    private String cardDetails;
    private String address;
    private int phoneNumber;
}
