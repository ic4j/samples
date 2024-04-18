import Map "mo:base/HashMap";
import Text "mo:base/Text";
import Blob "mo:base/Blob";
import Debug "mo:base/Debug";

actor {
  let images = Map.HashMap<Text, Blob>(0, Text.equal, Text.hash);
  
  public func add(name : Text, image : [Nat8]) : async Text {
    let blob : Blob = Blob.fromArray(image);
    Debug.print("Source Image Size " #debug_show(blob.size()));
    images.put(name, blob );
    return  name;
  };

    public query func get(name : Text) : async [Nat8] {
   let blob : ?Blob = images.get(name);

    switch blob {
            case (null) { return [] };
            case (?image) { 
              Debug.print("Result Image Size " #debug_show(image.size()));
              Blob.toArray(image);
               };
        };  
  };
};
