import Principal "mo:base/Principal";
import Time "mo:base/Time";
import Debug "mo:base/Debug";

actor class LoanProvider() = this {
      // Loan Application
  public type LoanApplication = {
    id: Int;
    firstname: Text;
    lastname: Text;
    zipcode: Text;
    ssn: Text;
    amount: Float;
    term: Int16;
    created: Int;
  };

   // Loan Offer
    public type LoanOffer = {
        providerid: Text;
        providername: Text;
        applicationid: Int;
        apr: Float;
        created: Int;
    };
 
    public shared (msg) func apply(input : LoanApplication) : async LoanOffer {

        Debug.print("Loan Application for user " #Principal.toText(msg.caller));
        
        let offer  : LoanOffer = {
            providerid = Principal.toText(Principal.fromActor(this));
            providername = "Loan Provider";
            applicationid = 1;
            apr = 3.14;
            created = Time.now();
        };

        return offer;
    };           
}