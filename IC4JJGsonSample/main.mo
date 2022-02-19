import Principal "mo:base/Principal";
import Time "mo:base/Time";
import Debug "mo:base/Debug";

actor class LoanProvider() = this {
      // Loan Application
  public type LoanApplication = {
    id: Nat;
    firstname: Text;
    lastname: Text;
    zipcode: Text;
    ssn: Text;
    amount: Float;
    term: Nat16;
    created: Int;
  };

   // Loan Offer
    public type LoanOffer = {
        providerid: Principal;
        providername: Text;
        applicationid: Nat;
        apr: Float;
        created: Int;
    };

  stable var counter : Nat = 0;  

    public shared (msg) func apply(input : LoanApplication) : async LoanOffer {
        counter += 1;

        Debug.print("Loan Application for user " #Principal.toText(msg.caller));
        
        let offer  : LoanOffer = {
            providerid = Principal.fromActor(this);
            providername = "Loan Provider";
            applicationid = counter;
            apr = 3.14;
            created = Time.now();
        };

        return offer;
    };       
}
