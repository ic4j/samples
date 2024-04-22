module {
	public type InstructionForCreditorAgent3 = {
		Cd : ?Text;
		InstrInf : ?Text;
	};

	public type AddressType2Code = {
		#ADDR;
		#BIZZ;
		#DLVY;
		#HOME;
		#MLTO;
		#PBOX;
	};

	public type GenericIdentification30 = {
		Id : Text;
		Issr : Text;
		SchmeNm : ?Text;
	};

	public type AddressType3Choice = {
		Cd : ?AddressType2Code;
		Prtry : ?GenericIdentification30;
	};

	public type PostalAddress24 = {
		Flr : ?Text;
		DstrctNm : ?Text;
		Ctry : ?Text;
		Dept : ?Text;
		Room : ?Text;
		StrtNm : ?Text;
		PstBx : ?Text;
		PstCd : ?Text;
		TwnLctnNm : ?Text;
		AdrLine : ?[Text];

		TwnNm : ?Text;
		AdrTp : ?AddressType3Choice;
		CtrySubDvsn : ?Text;
		BldgNb : ?Text;
		BldgNm : ?Text;
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

	public type FinancialInstitutionIdentification18 = {
		Nm : ?Text;
		LEI : ?Text;
		PstlAdr : ?PostalAddress24;
		BICFI : ?Text;
		Othr : ?GenericFinancialIdentification1;
		ClrSysMmbId : ?ClearingSystemMemberIdentification2;
	};

	public type BranchData3 = {
		Id : ?Text;
		Nm : ?Text;
		LEI : ?Text;
		PstlAdr : ?PostalAddress24;
	};

	public type BranchAndFinancialInstitutionIdentification6 = {
		FinInstnId : FinancialInstitutionIdentification18;
		BrnchId : ?BranchData3;
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

	public type ProxyAccountType1Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type ProxyAccountIdentification1 = {
		Id : Text;
		Tp : ?ProxyAccountType1Choice;
	};

	public type CashAccount38 = {
		Id : AccountIdentification4Choice;
		Nm : ?Text;
		Tp : ?CashAccountType2Choice;
		Ccy : ?Text;
		Prxy : ?ProxyAccountIdentification1;
	};

	public type Priority3Code = {
		#HIGH;
		#NORM;
		#URGT;
	};

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

	public type TaxInformation8 = {
		Dt : ?Int;
		Mtd : ?Text;
		SeqNb : ?Float;
		Cdtr : ?TaxParty1;
		Dbtr : ?TaxParty2;
		AdmstnZone : ?Text;
		Rcrd : ?[TaxRecord2];

		TtlTaxAmt : ?ActiveOrHistoricCurrencyAndAmount;
		RefNb : ?Text;
		TtlTaxblBaseAmt : ?ActiveOrHistoricCurrencyAndAmount;
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

	public type OrganisationIdentification29 = {
		LEI : ?Text;
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

	public type Party38Choice = {
		OrgId : ?OrganisationIdentification29;
		PrvtId : ?PersonIdentification13;
	};

	public type NamePrefix2Code = {
		#DOCT;
		#MADM;
		#MIKS;
		#MISS;
		#MIST;
	};

	public type OtherContact1 = {
		Id : ?Text;
		ChanlTp : Text;
	};

	public type PreferredContactMethod1Code = {
		#CELL;
		#FAXX;
		#LETT;
		#MAIL;
		#PHON;
	};

	public type Contact4 = {
		Nm : ?Text;
		JobTitl : ?Text;
		PhneNb : ?Text;
		NmPrfx : ?NamePrefix2Code;
		Dept : ?Text;
		Othr : ?[OtherContact1];

		EmailPurp : ?Text;
		PrefrdMtd : ?PreferredContactMethod1Code;
		FaxNb : ?Text;
		MobNb : ?Text;
		EmailAdr : ?Text;
		Rspnsblty : ?Text;
	};

	public type PartyIdentification135 = {
		Id : ?Party38Choice;
		Nm : ?Text;
		PstlAdr : ?PostalAddress24;
		CtctDtls : ?Contact4;
		CtryOfRes : ?Text;
	};

	public type Instruction4Code = {
		#PHOA;
		#TELA;
	};

	public type InstructionForNextAgent1 = {
		Cd : ?Instruction4Code;
		InstrInf : ?Text;
	};

	public type GarnishmentType1Choice = {
		Cd : ?Text;
		Prtry : ?Text;
	};

	public type GarnishmentType1 = {
		Issr : ?Text;
		CdOrPrtry : GarnishmentType1Choice;
	};

	public type Garnishment3 = {
		Dt : ?Int;
		Tp : GarnishmentType1;
		GrnshmtAdmstr : ?PartyIdentification135;
		RefNb : ?Text;
		MplyeeTermntnInd : ?Bool;
		FmlyMdclInsrncInd : ?Bool;
		Grnshee : ?PartyIdentification135;
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

	public type StructuredRemittanceInformation16 = {
		GrnshmtRmt : ?Garnishment3;
		Invcr : ?PartyIdentification135;
		CdtrRefInf : ?CreditorReferenceInformation2;
		AddtlRmtInf : ?[Text];

		RfrdDocAmt : ?RemittanceAmount2;
		RfrdDocInf : ?[ReferredDocumentInformation7];

		TaxRmt : ?TaxInformation7;
		Invcee : ?PartyIdentification135;
	};

	public type RemittanceInformation16 = {
		Strd : ?[StructuredRemittanceInformation16];

		Ustrd : ?[Text];

	};

	public type CreditTransferTransaction45 = {
		Tax : ?TaxInformation8;
		InstrForCdtrAgt : ?[InstructionForCreditorAgent3];

		PrvsInstgAgt1 : ?BranchAndFinancialInstitutionIdentification6;
		PrvsInstgAgt2 : ?BranchAndFinancialInstitutionIdentification6;
		PrvsInstgAgt3 : ?BranchAndFinancialInstitutionIdentification6;
		Cdtr : PartyIdentification135;
		Dbtr : PartyIdentification135;
		InstdAmt : ?ActiveOrHistoricCurrencyAndAmount;
		InitgPty : ?PartyIdentification135;
		IntrmyAgt1Acct : ?CashAccount38;
		DbtrAcct : ?CashAccount38;
		DbtrAgt : BranchAndFinancialInstitutionIdentification6;
		IntrmyAgt1 : ?BranchAndFinancialInstitutionIdentification6;
		IntrmyAgt2 : ?BranchAndFinancialInstitutionIdentification6;
		IntrmyAgt3 : ?BranchAndFinancialInstitutionIdentification6;
		PrvsInstgAgt2Acct : ?CashAccount38;
		CdtrAcct : ?CashAccount38;
		IntrmyAgt3Acct : ?CashAccount38;
		UltmtCdtr : ?PartyIdentification135;
		UltmtDbtr : ?PartyIdentification135;
		CdtrAgtAcct : ?CashAccount38;
		DbtrAgtAcct : ?CashAccount38;
		InstrForNxtAgt : ?[InstructionForNextAgent1];

		PrvsInstgAgt1Acct : ?CashAccount38;
		IntrmyAgt2Acct : ?CashAccount38;
		RmtInf : ?RemittanceInformation16;
		PrvsInstgAgt3Acct : ?CashAccount38;
		CdtrAgt : BranchAndFinancialInstitutionIdentification6;
	};

	public type PaymentIdentification13 = {
		ClrSysRef : ?Text;
		TxId : ?Text;
		UETR : ?Text;
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

	public type PaymentTypeInformation28 = {
		LclInstrm : ?LocalInstrument2Choice;
		SvcLvl : ?[ServiceLevel8Choice];

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

	public type ActiveCurrencyAndAmount = {
		Ccy : Text;
		value : Float;
	};

	public type RemittanceInformation2 = {
		Ustrd : ?[Text];

	};

	public type SettlementDateTimeIndication1 = {
		DbtDtTm : ?Int;
		CdtDtTm : ?Int;
	};

	public type CreditTransferTransaction44 = {
		InstrForCdtrAgt : ?[InstructionForCreditorAgent3];

		PrvsInstgAgt1 : ?BranchAndFinancialInstitutionIdentification6;
		PrvsInstgAgt2 : ?BranchAndFinancialInstitutionIdentification6;
		PrvsInstgAgt3 : ?BranchAndFinancialInstitutionIdentification6;
		Cdtr : BranchAndFinancialInstitutionIdentification6;
		Dbtr : BranchAndFinancialInstitutionIdentification6;
		Purp : ?Purpose2Choice;
		InstdAgt : ?BranchAndFinancialInstitutionIdentification6;
		InstgAgt : ?BranchAndFinancialInstitutionIdentification6;
		IntrmyAgt1Acct : ?CashAccount38;
		DbtrAcct : ?CashAccount38;
		SttlmPrty : ?Priority3Code;
		UndrlygCstmrCdtTrf : ?CreditTransferTransaction45;
		DbtrAgt : ?BranchAndFinancialInstitutionIdentification6;
		IntrmyAgt1 : ?BranchAndFinancialInstitutionIdentification6;
		IntrmyAgt2 : ?BranchAndFinancialInstitutionIdentification6;
		IntrmyAgt3 : ?BranchAndFinancialInstitutionIdentification6;
		PmtId : PaymentIdentification13;
		PrvsInstgAgt2Acct : ?CashAccount38;
		IntrBkSttlmDt : ?Int;
		CdtrAcct : ?CashAccount38;
		IntrmyAgt3Acct : ?CashAccount38;
		SplmtryData : ?[SupplementaryData1];

		UltmtCdtr : ?BranchAndFinancialInstitutionIdentification6;
		UltmtDbtr : ?BranchAndFinancialInstitutionIdentification6;
		CdtrAgtAcct : ?CashAccount38;
		DbtrAgtAcct : ?CashAccount38;
		PmtTpInf : ?PaymentTypeInformation28;
		SttlmTmReq : ?SettlementTimeRequest2;
		InstrForNxtAgt : ?[InstructionForNextAgent1];

		IntrBkSttlmAmt : ActiveCurrencyAndAmount;
		PrvsInstgAgt1Acct : ?CashAccount38;
		IntrmyAgt2Acct : ?CashAccount38;
		RmtInf : ?RemittanceInformation2;
		PrvsInstgAgt3Acct : ?CashAccount38;
		CdtrAgt : ?BranchAndFinancialInstitutionIdentification6;
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

	public type SettlementInstruction7 = {
		SttlmMtd : SettlementMethod1Code;
		SttlmAcct : ?CashAccount38;
		ClrSys : ?ClearingSystemIdentification3Choice;
		InstdRmbrsmntAgtAcct : ?CashAccount38;
		InstgRmbrsmntAgt : ?BranchAndFinancialInstitutionIdentification6;
		InstgRmbrsmntAgtAcct : ?CashAccount38;
		InstdRmbrsmntAgt : ?BranchAndFinancialInstitutionIdentification6;
		ThrdRmbrsmntAgtAcct : ?CashAccount38;
		ThrdRmbrsmntAgt : ?BranchAndFinancialInstitutionIdentification6;
	};

	public type GroupHeader93 = {
		CtrlSum : ?Float;
		InstdAgt : ?BranchAndFinancialInstitutionIdentification6;
		InstgAgt : ?BranchAndFinancialInstitutionIdentification6;
		SttlmInf : SettlementInstruction7;
		BtchBookg : ?Bool;
		IntrBkSttlmDt : ?Int;
		NbOfTxs : Text;
		PmtTpInf : ?PaymentTypeInformation28;
		MsgId : Text;
		TtlIntrBkSttlmAmt : ?ActiveCurrencyAndAmount;
		CreDtTm : Int;
	};

	public type FinancialInstitutionCreditTransferV09 = {
		CdtTrfTxInf : [CreditTransferTransaction44];
		GrpHdr : GroupHeader93;
		SplmtryData : ?[SupplementaryData1];

	};

}