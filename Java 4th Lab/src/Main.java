public class Main {
    public static void main(String[] args) {
        Om om = new Om("eurgen", 75);
        Maimuta maimuta = new Maimuta("ape", 35);
        UnMembruAlGastii membruAlGastii = new UnMembruAlGastii("apeee", 85);

        om.marcheazaTeritoriul();
        maimuta.marcheazaTeritoriul();
        membruAlGastii.marcheazaTeritoriul();
    }
}
