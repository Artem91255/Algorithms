package HomeTask4;

public class Main {
    public static void main(String[] args) {
        Mapa<Integer, String> mapa = new Mapa<>();
        System.out.println(mapa.put(1, "a"));
        System.out.println(mapa.put(2, "uy"));
        System.out.println(mapa.put(3, "c"));
        System.out.println(mapa.put(4, "d"));
        System.out.println(mapa.put(1, "e"));
        System.out.println(mapa.put(3, "qwerty"));
        System.out.println();

        System.out.println(mapa.get(1));
        System.out.println(mapa.get(3));
        System.out.println();

        System.out.println(mapa.remove(4));
        System.out.println();

        System.out.println(mapa.replays(1, "r"));
        System.out.println();

        System.out.println(mapa.size());
        System.out.println();

        System.out.println(mapa.containsKey(1));
        System.out.println(mapa.containsKey(90));
        System.out.println();

        System.out.println(mapa.containsValue("qwerty"));
        System.out.println(mapa.containsKey(5));
    }
}
