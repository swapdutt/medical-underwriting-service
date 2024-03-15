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
public class CreateDiseaseQuestionnaireRequestPayload {

	@Builder.Default
	String diseaseQuestionnaireId = UUID.randomUUID().toString();
	String question1;
	String question2;
	String question3;
	String question4;
	String question5;
	String question6;
	String question7;
	String question8;
	String question9;
	String question10;
	String question11;
	String question12;

}
