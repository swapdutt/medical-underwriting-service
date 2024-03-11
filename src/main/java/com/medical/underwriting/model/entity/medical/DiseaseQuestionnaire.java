package com.medical.underwriting.model.entity.medical;

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
@Table(name = "DISEASE_QUESTIONNAIRE")
public class DiseaseQuestionnaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
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
