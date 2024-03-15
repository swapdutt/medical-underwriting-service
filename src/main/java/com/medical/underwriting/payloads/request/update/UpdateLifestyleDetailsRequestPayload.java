package com.medical.underwriting.payloads.request.update;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UpdateLifestyleDetailsRequestPayload {

	Integer amountOfTobaccoProductsConsumptionPerDay;
	Integer amountOfAlcoholConsumptionPerWeek;
	Integer amountOfCigarettesSticksSmokedPerDay;
	Integer durationOfSmokingCigarettes;
	Integer frequencyOfAlcoholConsumptionPerDay;

}
