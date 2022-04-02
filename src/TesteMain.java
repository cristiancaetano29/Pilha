public class TesteMain {
    public static void main(String[] args) throws Exception {
        Pilha<Integer> p = new Pilha<Integer>(10);
        p.GuardaUmIem(5);
        p.GuardaUmIem(7);
        p.GuardaUmIem(221);
        p.GuardaUmIem(69);
        System.out.println(p);
    }
}
