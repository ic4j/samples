import FIToFICustomerCreditTransferV07Types "FIToFICustomerCreditTransferV07Types";
import FinancialInstitutionCreditTransferV09Types "FinancialInstitutionCreditTransferV09Types";

actor {
  public func reversalRequest(request : FIToFICustomerCreditTransferV07Types.FIToFICustomerCreditTransferV07) : async FIToFICustomerCreditTransferV07Types.FIToFICustomerCreditTransferV07 {
    return request;
  };


  public func creditTransfer(credit : FinancialInstitutionCreditTransferV09Types.FinancialInstitutionCreditTransferV09) : async FinancialInstitutionCreditTransferV09Types.FinancialInstitutionCreditTransferV09 {
    return credit;
};

};
