import Principal "mo:base/Principal";
import Time "mo:base/Time";
import Buffer "mo:base/Buffer";
import Map "mo:base/HashMap";
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

    type Offers<LoanOffer> = Buffer.Buffer<LoanOffer>;

    stable var counter : Nat = 0;

    let offers = Map.HashMap<Principal, Offers<LoanOffer>>(0, Principal.equal, Principal.hash); 

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

        var userOffers :  ?Offers<LoanOffer> = offers.get(msg.caller);

        switch userOffers {
            case (null) { var userOffer : Offers<LoanOffer> = Buffer.Buffer(0); userOffer.add(offer);  offers.put(msg.caller, userOffer)};
            case (?userOffer) { userOffer.add(offer); };
        };
        return offer;
    };

    public query (msg) func getOffers() : async [LoanOffer] {
        var userOffers :  ?Offers<LoanOffer> = offers.get(msg.caller);

        switch userOffers {
            case (null) { return [] };
            case (?userOffer) { return userOffer.toArray() };
        };
    };           
}
