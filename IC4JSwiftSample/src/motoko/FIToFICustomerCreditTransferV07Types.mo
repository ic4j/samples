module {
	public type TaxParty1 = {
		RegnId : ?Text;
		TaxId : ?Text;
		TaxTp : ?Text;
	};

	public type TaxAuthorisation1 = {
		Nm : ?Text;
		Titl : ?Text;
	};

	public type TaxParty2 = {
		RegnId : ?Text;
		Authstn : ?TaxAuthorisation1;
		TaxId : ?Text;
		TaxTp : ?Text;
	};

	public type TaxRecordPeriod1Code = {
		#HLF1;
		#HLF2;
		#MM01;
		#MM02;
		#MM03;
		#MM04;
		#MM05;
		#MM06;
		#MM07;
		#MM08;
		#MM09;
		#MM10;
		#MM11;
		#MM12;
		#QTR1;
		#QTR2;
		#QTR3;
		#QTR4;
	};

	public type DatePeriod2 = {
		FrDt : Int;
		ToDt : Int;
	};

	public type TaxPeriod2 = {
		Tp : ?TaxRecordPeriod1Code;
		Yr : ?Int;
		FrToDt : ?DatePeriod2;
	};

	public type ActiveOrHistoricCurrencyAndAmount = {
		Ccy : Text;
		value : Float;
	};

	public type TaxRecordDetails2 = {
		Amt : ActiveOrHistoricCurrencyAndAmount;
		Prd : ?TaxPeriod2;
	};

	public type TaxAmount2 = {
		Dtls : ?[TaxRecordDetails2];

		Rate : ?Float;
		TaxblBaseAmt : ?ActiveOrHistoricCurrencyAndAmount;
		TtlAmt : ?ActiveOrHistoricCurrencyAndAmount;
	};

	public type TaxRecord2 = {
		Tp : ?Text;
		Prd : ?TaxPeriod2;
		Ctgy : ?Text;
		CertId : ?Text;
		DbtrSts : ?Text;
		TaxAmt : ?TaxAmount2;
		AddtlInf : ?Text;
		CtgyDtls : ?Text;
		FrmsCd : ?Text;
	};

	public type TaxInformation6 = {
		Dt : ?Int;
		Mtd : ?Text;
		SeqNb : ?Float;
		Cdtr : ?TaxParty1;
		Dbtr : ?TaxParty2;
		Rcrd : ?[TaxRecord2];

		TtlTaxAmt : ?ActiveOrHistoricCurrencyAndAmount;
		RefNb : ?Text;
		AdmstnZn : ?Text;
		TtlTaxblBaseAmt : ?ActiveOrHistoricCurrencyAndAmount;
	};

	public type AddressType2Code = {
		#ADDR;
		#BIZZ;
		#DLVY;
		#HOME;
		#MLTO;
		#PBOX;
	};

	public type PostalAddress6 = {
		Ctry : ?Text;
		Dept : ?Text;
		StrtNm : ?Text;
		PstCd : ?Text;
		AdrLine : ?[Text];

		TwnNm : ?Text;
		AdrTp : ?AddressType2Code;
		CtrySubDvsn : ?Text;
		BldgNb : ?Text;
		SubDept : ?Text;
	};

	public type FinancialIdentificationSchemeName1Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type GenericFinancialIdentification1 = {
		Id : Text;
		Issr : ?Text;
		SchmeNm : ?FinancialIdentificationSchemeName1Choice;
	};

	public type ClearingSystemIdentification2Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type ClearingSystemMemberIdentification2 = {
		ClrSysId : ?ClearingSystemIdentification2Choice;
		MmbId : Text;
	};

	public type FinancialInstitutionIdentification8 = {
		Nm : ?Text;
		PstlAdr : ?PostalAddress6;
		BICFI : ?Text;
		Othr : ?GenericFinancialIdentification1;
		ClrSysMmbId : ?ClearingSystemMemberIdentification2;
	};

	public type BranchData2 = {
		Id : ?Text;
		Nm : ?Text;
		PstlAdr : ?PostalAddress6;
	};

	public type BranchAndFinancialInstitutionIdentification5 = {
		FinInstnId : FinancialInstitutionIdentification8;
		BrnchId : ?BranchData2;
	};

	public type Charges2 = {
		Agt : BranchAndFinancialInstitutionIdentification5;
		Amt : ActiveOrHistoricCurrencyAndAmount;
	};

	public type Instruction3Code = {
		#CHQB;
		#HOLD;
		#PHOB;
		#TELB;
	};

	public type InstructionForCreditorAgent1 = {
		Cd : ?Instruction3Code;
		InstrInf : ?Text;
	};

	public type OrganisationIdentificationSchemeName1Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type GenericOrganisationIdentification1 = {
		Id : Text;
		Issr : ?Text;
		SchmeNm : ?OrganisationIdentificationSchemeName1Choice;
	};

	public type OrganisationIdentification8 = {
		Othr : ?[GenericOrganisationIdentification1];

		AnyBIC : ?Text;
	};

	public type DateAndPlaceOfBirth1 = {
		CityOfBirth : Text;
		PrvcOfBirth : ?Text;
		BirthDt : Int;
		CtryOfBirth : Text;
	};

	public type PersonIdentificationSchemeName1Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type GenericPersonIdentification1 = {
		Id : Text;
		Issr : ?Text;
		SchmeNm : ?PersonIdentificationSchemeName1Choice;
	};

	public type PersonIdentification13 = {
		DtAndPlcOfBirth : ?DateAndPlaceOfBirth1;
		Othr : ?[GenericPersonIdentification1];

	};

	public type Party34Choice = {
		OrgId : ?OrganisationIdentification8;
		PrvtId : ?PersonIdentification13;
	};

	public type NamePrefix1Code = {
		#DOCT;
		#MADM;
		#MISS;
		#MIST;
	};

	public type ContactDetails2 = {
		Nm : ?Text;
		PhneNb : ?Text;
		NmPrfx : ?NamePrefix1Code;
		Othr : ?Text;
		FaxNb : ?Text;
		MobNb : ?Text;
		EmailAdr : ?Text;
	};

	public type PartyIdentification125 = {
		Id : ?Party34Choice;
		Nm : ?Text;
		PstlAdr : ?PostalAddress6;
		CtctDtls : ?ContactDetails2;
		CtryOfRes : ?Text;
	};

	public type Purpose2Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type AccountSchemeName1Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type GenericAccountIdentification1 = {
		Id : Text;
		Issr : ?Text;
		SchmeNm : ?AccountSchemeName1Choice;
	};

	public type AccountIdentification4Choice = {
		IBAN : ?Text;
		Othr : ?GenericAccountIdentification1;
	};

	public type CashAccountType2Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type CashAccount24 = {
		Id : AccountIdentification4Choice;
		Nm : ?Text;
		Tp : ?CashAccountType2Choice;
		Ccy : ?Text;
	};

	public type Priority3Code = {
		#HIGH;
		#NORM;
		#URGT;
	};

	public type PaymentIdentification3 = {
		ClrSysRef : ?Text;
		TxId : Text;
		InstrId : ?Text;
		EndToEndId : Text;
	};

	public type SupplementaryDataEnvelope1 = {
		any : Any;
	};

	public type SupplementaryData1 = {
		Envlp : SupplementaryDataEnvelope1;
		PlcAndNm : ?Text;
	};

	public type RemittanceLocationMethod2Code = {
		#EDIC;
		#EMAL;
		#FAXI;
		#POST;
		#SMSM;
		#URID;
	};

	public type NameAndAddress10 = {
		Nm : Text;
		Adr : PostalAddress6;
	};

	public type RemittanceLocationDetails1 = {
		Mtd : RemittanceLocationMethod2Code;
		PstlAdr : ?NameAndAddress10;
		ElctrncAdr : ?Text;
	};

	public type RemittanceLocation4 = {
		RmtId : ?Text;
		RmtLctnDtls : ?[RemittanceLocationDetails1];

	};

	public type LocalInstrument2Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type ServiceLevel8Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type Priority2Code = {
		#HIGH;
		#NORM;
	};

	public type CategoryPurpose1Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type ClearingChannel2Code = {
		#BOOK;
		#MPNS;
		#RTGS;
		#RTNS;
	};

	public type PaymentTypeInformation21 = {
		LclInstrm : ?LocalInstrument2Choice;
		SvcLvl : ?ServiceLevel8Choice;
		InstrPrty : ?Priority2Code;
		CtgyPurp : ?CategoryPurpose1Choice;
		ClrChanl : ?ClearingChannel2Code;
	};

	public type SettlementTimeRequest2 = {
		RjctTm : ?Int;
		FrTm : ?Int;
		TillTm : ?Int;
		CLSTm : ?Int;
	};

	public type Instruction4Code = {
		#PHOA;
		#TELA;
	};

	public type InstructionForNextAgent1 = {
		Cd : ?Instruction4Code;
		InstrInf : ?Text;
	};

	public type ActiveCurrencyAndAmount = {
		Ccy : Text;
		value : Float;
	};

	public type GarnishmentType1Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type GarnishmentType1 = {
		Issr : ?Text;
		CdOrPrtry : GarnishmentType1Choice;
	};

	public type Garnishment2 = {
		Dt : ?Int;
		Tp : GarnishmentType1;
		GrnshmtAdmstr : ?PartyIdentification125;
		RefNb : ?Text;
		MplyeeTermntnInd : ?Bool;
		FmlyMdclInsrncInd : ?Bool;
		Grnshee : ?PartyIdentification125;
		RmtdAmt : ?ActiveOrHistoricCurrencyAndAmount;
	};

	public type DocumentType3Code = {
		#DISP;
		#FXDR;
		#PUOR;
		#RADM;
		#RPIN;
		#SCOR;
	};

	public type CreditorReferenceType1Choice = {
		Cd : ?DocumentType3Code;
		Prtry : ?Text;
	};

	public type CreditorReferenceType2 = {
		Issr : ?Text;
		CdOrPrtry : CreditorReferenceType1Choice;
	};

	public type CreditorReferenceInformation2 = {
		Tp : ?CreditorReferenceType2;
		Ref : ?Text;
	};

	public type DiscountAmountType1Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type DiscountAmountAndType1 = {
		Tp : ?DiscountAmountType1Choice;
		Amt : ActiveOrHistoricCurrencyAndAmount;
	};

	public type CreditDebitCode = {
		#CRDT;
		#DBIT;
	};

	public type DocumentAdjustment1 = {
		Amt : ActiveOrHistoricCurrencyAndAmount;
		Rsn : ?Text;
		CdtDbtInd : ?CreditDebitCode;
		AddtlInf : ?Text;
	};

	public type TaxAmountType1Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type TaxAmountAndType1 = {
		Tp : ?TaxAmountType1Choice;
		Amt : ActiveOrHistoricCurrencyAndAmount;
	};

	public type RemittanceAmount2 = {
		DscntApldAmt : ?[DiscountAmountAndType1];

		DuePyblAmt : ?ActiveOrHistoricCurrencyAndAmount;
		AdjstmntAmtAndRsn : ?[DocumentAdjustment1];

		CdtNoteAmt : ?ActiveOrHistoricCurrencyAndAmount;
		TaxAmt : ?[TaxAmountAndType1];

		RmtdAmt : ?ActiveOrHistoricCurrencyAndAmount;
	};

	public type DocumentType6Code = {
		#AROI;
		#BOLD;
		#CINV;
		#CMCN;
		#CNFA;
		#CREN;
		#DEBN;
		#DISP;
		#DNFA;
		#HIRI;
		#MSIN;
		#PUOR;
		#SBIN;
		#SOAC;
		#TSUT;
		#VCHR;
	};

	public type ReferredDocumentType3Choice = {
		Cd : ?DocumentType6Code;
		Prtry : ?Text;
	};

	public type ReferredDocumentType4 = {
		Issr : ?Text;
		CdOrPrtry : ReferredDocumentType3Choice;
	};

	public type DocumentLineType1Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type DocumentLineType1 = {
		Issr : ?Text;
		CdOrPrtry : DocumentLineType1Choice;
	};

	public type DocumentLineIdentification1 = {
		Nb : ?Text;
		Tp : ?DocumentLineType1;
		RltdDt : ?Int;
	};

	public type RemittanceAmount3 = {
		DscntApldAmt : ?[DiscountAmountAndType1];

		DuePyblAmt : ?ActiveOrHistoricCurrencyAndAmount;
		AdjstmntAmtAndRsn : ?[DocumentAdjustment1];

		CdtNoteAmt : ?ActiveOrHistoricCurrencyAndAmount;
		TaxAmt : ?[TaxAmountAndType1];

		RmtdAmt : ?ActiveOrHistoricCurrencyAndAmount;
	};

	public type DocumentLineInformation1 = {
		Id : [DocumentLineIdentification1];
		Amt : ?RemittanceAmount3;
		Desc : ?Text;
	};

	public type ReferredDocumentInformation7 = {
		Nb : ?Text;
		Tp : ?ReferredDocumentType4;
		RltdDt : ?Int;
		LineDtls : ?[DocumentLineInformation1];

	};

	public type TaxInformation7 = {
		Dt : ?Int;
		Mtd : ?Text;
		SeqNb : ?Float;
		Cdtr : ?TaxParty1;
		Dbtr : ?TaxParty2;
		AdmstnZone : ?Text;
		Rcrd : ?[TaxRecord2];

		TtlTaxAmt : ?ActiveOrHistoricCurrencyAndAmount;
		RefNb : ?Text;
		UltmtDbtr : ?TaxParty2;
		TtlTaxblBaseAmt : ?ActiveOrHistoricCurrencyAndAmount;
	};

	public type StructuredRemittanceInformation15 = {
		GrnshmtRmt : ?Garnishment2;
		Invcr : ?PartyIdentification125;
		CdtrRefInf : ?CreditorReferenceInformation2;
		AddtlRmtInf : ?[Text];

		RfrdDocAmt : ?RemittanceAmount2;
		RfrdDocInf : ?[ReferredDocumentInformation7];

		TaxRmt : ?TaxInformation7;
		Invcee : ?PartyIdentification125;
	};

	public type RemittanceInformation15 = {
		Strd : ?[StructuredRemittanceInformation15];

		Ustrd : ?[Text];

	};

	public type StructuredRegulatoryReporting3 = {
		Cd : ?Text;
		Dt : ?Int;
		Tp : ?Text;
		Amt : ?ActiveOrHistoricCurrencyAndAmount;
		Inf : ?[Text];

		Ctry : ?Text;
	};

	public type RegulatoryAuthority2 = {
		Nm : ?Text;
		Ctry : ?Text;
	};

	public type RegulatoryReportingType1Code = {
		#BOTH;
		#CRED;
		#DEBT;
	};

	public type RegulatoryReporting3 = {
		Dtls : ?[StructuredRegulatoryReporting3];

		Authrty : ?RegulatoryAuthority2;
		DbtCdtRptgInd : ?RegulatoryReportingType1Code;
	};

	public type ChargeBearerType1Code = {
		#CRED;
		#DEBT;
		#SHAR;
		#SLEV;
	};

	public type SettlementDateTimeIndication1 = {
		DbtDtTm : ?Int;
		CdtDtTm : ?Int;
	};

	public type CreditTransferTransaction30 = {
		Tax : ?TaxInformation6;
		ChrgsInf : ?[Charges2];

		InstrForCdtrAgt : ?[InstructionForCreditorAgent1];

		PrvsInstgAgt1 : ?BranchAndFinancialInstitutionIdentification5;
		PrvsInstgAgt2 : ?BranchAndFinancialInstitutionIdentification5;
		PrvsInstgAgt3 : ?BranchAndFinancialInstitutionIdentification5;
		Cdtr : PartyIdentification125;
		Dbtr : PartyIdentification125;
		Purp : ?Purpose2Choice;
		InstdAgt : ?BranchAndFinancialInstitutionIdentification5;
		InstdAmt : ?ActiveOrHistoricCurrencyAndAmount;
		InstgAgt : ?BranchAndFinancialInstitutionIdentification5;
		InitgPty : ?PartyIdentification125;
		IntrmyAgt1Acct : ?CashAccount24;
		DbtrAcct : ?CashAccount24;
		SttlmPrty : ?Priority3Code;
		DbtrAgt : BranchAndFinancialInstitutionIdentification5;
		IntrmyAgt1 : ?BranchAndFinancialInstitutionIdentification5;
		IntrmyAgt2 : ?BranchAndFinancialInstitutionIdentification5;
		IntrmyAgt3 : ?BranchAndFinancialInstitutionIdentification5;
		PmtId : PaymentIdentification3;
		PrvsInstgAgt2Acct : ?CashAccount24;
		IntrBkSttlmDt : ?Int;
		CdtrAcct : ?CashAccount24;
		IntrmyAgt3Acct : ?CashAccount24;
		SplmtryData : ?[SupplementaryData1];

		UltmtCdtr : ?PartyIdentification125;
		UltmtDbtr : ?PartyIdentification125;
		RltdRmtInf : ?[RemittanceLocation4];

		CdtrAgtAcct : ?CashAccount24;
		DbtrAgtAcct : ?CashAccount24;
		PmtTpInf : ?PaymentTypeInformation21;
		SttlmTmReq : ?SettlementTimeRequest2;
		InstrForNxtAgt : ?[InstructionForNextAgent1];

		IntrBkSttlmAmt : ActiveCurrencyAndAmount;
		AccptncDtTm : ?Int;
		PrvsInstgAgt1Acct : ?CashAccount24;
		PoolgAdjstmntDt : ?Int;
		IntrmyAgt2Acct : ?CashAccount24;
		XchgRate : ?Float;
		RmtInf : ?RemittanceInformation15;
		RgltryRptg : ?[RegulatoryReporting3];

		PrvsInstgAgt3Acct : ?CashAccount24;
		CdtrAgt : BranchAndFinancialInstitutionIdentification5;
		ChrgBr : ChargeBearerType1Code;
		SttlmTmIndctn : ?SettlementDateTimeIndication1;
	};

	public type SettlementMethod1Code = {
		#CLRG;
		#COVE;
		#INDA;
		#INGA;
	};

	public type ClearingSystemIdentification3Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type SettlementInstruction4 = {
		SttlmMtd : SettlementMethod1Code;
		SttlmAcct : ?CashAccount24;
		ClrSys : ?ClearingSystemIdentification3Choice;
		InstdRmbrsmntAgtAcct : ?CashAccount24;
		InstgRmbrsmntAgt : ?BranchAndFinancialInstitutionIdentification5;
		InstgRmbrsmntAgtAcct : ?CashAccount24;
		InstdRmbrsmntAgt : ?BranchAndFinancialInstitutionIdentification5;
		ThrdRmbrsmntAgtAcct : ?CashAccount24;
		ThrdRmbrsmntAgt : ?BranchAndFinancialInstitutionIdentification5;
	};

	public type GroupHeader70 = {
		CtrlSum : ?Float;
		InstdAgt : ?BranchAndFinancialInstitutionIdentification5;
		InstgAgt : ?BranchAndFinancialInstitutionIdentification5;
		SttlmInf : SettlementInstruction4;
		BtchBookg : ?Bool;
		IntrBkSttlmDt : ?Int;
		NbOfTxs : Text;
		PmtTpInf : ?PaymentTypeInformation21;
		MsgId : Text;
		TtlIntrBkSttlmAmt : ?ActiveCurrencyAndAmount;
		CreDtTm : Int;
	};

	public type FIToFICustomerCreditTransferV07 = {
		CdtTrfTxInf : [CreditTransferTransaction30];
		GrpHdr : GroupHeader70;
		SplmtryData : ?[SupplementaryData1];

	};

}