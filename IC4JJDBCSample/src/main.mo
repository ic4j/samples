import Debug "mo:base/Debug";

actor class CreditCheck() = this {

   // Credit Check
  public type Credit = {
    ssn: Text;   
    rating: Int32;
  };
  
    public shared (msg) func setCredit(input : Credit){
        Debug.print("Credit Check for ssn " #input.ssn);
    };          
}
