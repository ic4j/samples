actor {
    stable var name = "Me";

    public func greet(value : Text) : async Text {
        name := value;
        return "Hello, " # name # "!";
    };

    public shared query func peek() : async Text {
        return name;
    };    
};
