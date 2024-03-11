package com.medical.underwriting.model.entity.member;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "LIFESTYLE")
public class LifestyleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	@Builder.Default
	String lifestyleDetailsId = UUID.randomUUID().toString();
	Integer amountOfTobaccoProductsConsumptionPerDay;
	Integer amountOfAlcoholConsumptionPerWeek;
	Integer amountOfCigarettesSticksSmokedPerDay;
	Integer durationOfSmokingCigarettes;
	Integer frequencyOfAlcoholConsumptionPerDay;

}
