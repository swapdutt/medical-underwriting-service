package com.medical.underwriting.model.member;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@ToString
@Entity
@Table(name = "LIFESTYLE")
public class LifestyleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String lifestyleDetailsId;
	Integer amountOfTobaccoProductsConsumptionPerDay;
	Integer amountOfAlcoholConsumptionPerWeek;
	Integer amountOfCigarettesSticksSmokedPerDay;
	Integer durationOfSmokingCigarettes;
	Integer frequencyOfAlcoholConsumptionPerDay;

}
