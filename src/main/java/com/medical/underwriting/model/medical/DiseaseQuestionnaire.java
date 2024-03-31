package com.medical.underwriting.model.medical;

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
@Table(name = "DISEASE_QUESTIONNAIRE")
public class DiseaseQuestionnaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String diseaseQuestionnaireId;
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
