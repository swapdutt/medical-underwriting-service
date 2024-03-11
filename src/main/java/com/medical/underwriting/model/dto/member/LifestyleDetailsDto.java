package com.medical.underwriting.model.dto.member;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class LifestyleDetailsDto {

	Integer lifestyleDetailsId;
	Integer amountOfTobaccoProductsConsumptionPerDay;
	Integer amountOfAlcoholConsumptionPerWeek;
	Integer amountOfCigarettesSticksSmokedPerDay;
	Integer durationOfSmokingCigarettes;
	Integer frequencyOfAlcoholConsumptionPerDay;

}
