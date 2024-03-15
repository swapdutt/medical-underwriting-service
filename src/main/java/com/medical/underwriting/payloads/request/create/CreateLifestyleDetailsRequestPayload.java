package com.medical.underwriting.payloads.request.create;

import java.util.UUID;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Builder
public class CreateLifestyleDetailsRequestPayload {

	@Builder.Default
	String lifestyleDetailsId = UUID.randomUUID().toString();
	Integer amountOfTobaccoProductsConsumptionPerDay;
	Integer amountOfAlcoholConsumptionPerWeek;
	Integer amountOfCigarettesSticksSmokedPerDay;
	Integer durationOfSmokingCigarettes;
	Integer frequencyOfAlcoholConsumptionPerDay;

}
