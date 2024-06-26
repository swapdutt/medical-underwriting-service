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
@Table(name = "LAB_TESTS")
public class LabTests {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String labTestsId;
	String sugarInUrine;
	String bilirubinInUrine;
	String ketonesInUrine;
	String proteinInUrine;
	String rbcBloodCountInUrine;
	String resultOfTMT;
	String resultOfDobutamineStressECHO;
	String resultOfStressThallium;
	String resultOfCTFindings;
	String resultOfChestXRay;
	String resultOfEcho;
	String resultOfECG;
	String resultOfUSGAbdomen;
	String otherMedicalReports;
	String crystalsInUrine;
	String rbcWBCCastsInUrine;
	String granularWaxyCasts;
	Double wbcPlusCellsInUrine;
	Double rbcPerHPF;
	Double countOfRBC;
	Double upperCountOfRBC;
	Double lowerCountOfRBC;
	Double pcvHematocrit;
	Double upperCountOfPCVHematocrit;
	Double lowerCountOfPCVHematocrit;
	Double countOfMCV;
	Double upperCountOfMCV;
	Double lowerCountOfMCV;
	Double countOfMCH;
	Double upperCountOfMCH;
	Double lowerCountOfMCH;
	Double countOfMCHC;
	Double upperCountOfMCHC;
	Double lowerCountOfMCHC;
	Double valueOfTSH;
	Double upperValueOfTSH;
	Double lowerValueOfTSH;
	Double valueOfTLC;
	Double upperValueOfTLC;
	Double lowerValueOfTLC;
	Double valueOfNeutrophil;
	Double upperValueOfNeutrophil;
	Double lowerValueOfNeutrophil;
	Double valueOfEsoinophil;
	Double upperValueOfEsoinophil;
	Double lowerValueOfEsoinophil;
	Double valueOfBasophil;
	Double upperValueOfBasophil;
	Double lowerValueOfBasophil;
	Double valueOfMonocyte;
	Double upperValueOfMonocyte;
	Double lowerValueOfMonocyte;
	Double valueOfLymphocyte;
	Double upperValueOfLymphocyte;
	Double lowerValueOfLymphocyte;
	Double countOfPlatelet;
	Double upperCountOfPlatelet;
	Double lowerCountOfPlatelet;
	Double valueOfESR;
	Double upperValueOfESR;
	Double lowerValueOfESR;
	Double valueOfFBS;
	Double upperValueOfFBS;
	Double lowerValueOfFBS;
	Double valueOfHbA1C;
	Double upperValueOfHbA1C;
	Double lowerValueOfHbA1C;
	Double valueOfSerumCreatinineRFT;
	Double upperValueOfSerumCreatinineRFT;
	Double lowerValueOfSerumCreatinineRFT;
	Double amountOfUricAcid;
	Double upperAmountOfUricAcid;
	Double lowerAmountOfUricAcid;
	Double valueOfSGOTAST;
	Double upperValueOfSGOTAST;
	Double lowerValueOfSGOTAST;
	Double valueOfSGPTALT;
	Double upperValueOfSGPTALT;
	Double lowerValueOfSGPTALT;
	Double ratioBetweenSGOAndSGPT;
	Double valueOfBUN;
	Double upperValueOfBUN;
	Double lowerValueOfBUN;
	Double valueOfNA;
	Double upperValueOfNA;
	Double lowerValueOfNA;
	Double valueOfK;
	Double upperValueOfK;
	Double lowerValueOfK;
	Double valueOfCA;
	Double upperValueOfCA;
	Double lowerValueOfCA;
	Double valueOfPO4;
	Double upperValueOfPO4;
	Double lowerValueOfPO4;
	Double valueOfCI;
	Double upperValueOfCI;
	Double lowerValueOfCI;
	Double valueOfHCO3;
	Double upperValueOfHCO3;
	Double lowerValueOfHCO3;
	Double valueOfGGT;
	Double upperValueOfGGT;
	Double lowerValueOfGGT;
	Double valueOfALP;
	Double upperValueOfALP;
	Double lowerValueOfALP;
	Double valueOfTotalBilirubin;
	Double upperValueOfTotalBilirubin;
	Double lowerValueOfTotalBilirubin;
	Double valueOfSerumAlbumin;
	Double upperValueOfSerumAlbumin;
	Double lowerValueOfSerumAlbumin;
	Double valueOfUrineMicroAlbumin;
	Double upperValueOfUrineMicroAlbumin;
	Double lowerValueOfUrineMicroAlbumin;
	Double valueOfTotalProtein;
	Double upperValueOfTotalProtein;
	Double lowerValueOfTotalProtein;
	Double valueOfPSA;
	Double upperValueOfPSA;
	Double lowerValueOfPSA;
	Double valueOfTC;
	Double upperValueOfTC;
	Double lowerValueOfTC;
	Double valueOfLDL;
	Double upperValueOfLDL;
	Double lowerValueOfLDL;
	Double heartRate;
	Double valueOfHDL;
	Double valueOfHB;
	Integer percentageOfLVEF;

}
