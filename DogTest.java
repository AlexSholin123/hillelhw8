public class DogTest {
    public static void main(String[] args) {

        Yorkshire yorkshire = new Yorkshire("Spike2");
        System.out.println(yorkshire.getName() + " says " + yorkshire.speak());

        Labrador labrador = new Labrador("Spike3", "black");
        System.out.println(labrador.getName() + " says " + labrador.speak());

        yorkshire.avgBreedWeight();
        labrador.avgBreedWeight();
    }
}
