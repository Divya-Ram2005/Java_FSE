// Interface definition
interface Playable {
    void play();
}

// Guitar class implementing Playable
class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Guitar is playing a melody.");
    }
}

// Piano class implementing Playable
class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Piano is playing a harmony.");
    }
}

// Main class
public class InterfaceDemo {
    public static void main(String[] args) {
        // Creating objects using the interface reference
        Playable myGuitar = new Guitar();
        Playable myPiano = new Piano();

        // Calling play() on each object
        myGuitar.play();  // Output: Guitar is playing a melody.
        myPiano.play();   // Output: Piano is playing a harmony.
    }
}
