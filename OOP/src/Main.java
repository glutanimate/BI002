public class Main {
    public static void main(String[] args) {
        // einfacher Familienstammbaum über 3 Generationen für Mensch sohn:
        Mensch grossMutterVater = new Mensch(
                "Wilhelms", "Gertrude");
        Mensch grossVaterVater = new Mensch(
                "Wilhemls", "Otto");
        Mensch grossMutterMutter = new Mensch(
                "Müller", "Wilfriede");
        Mensch grossVaterMutter = new Mensch(
                "Müller", "Georg");
        Mensch vater = new Mensch(
                "Wilhelms-Müller", "Theodor",
                grossVaterVater, grossMutterVater);
        Mensch mutter = new Mensch(
                "Wilhelms-Müller", "Marie",
                grossVaterMutter, grossMutterMutter);
        Patient sohn = new Patient(
                "Wilhelms-Müller", "Fritz",
                vater, mutter);

        // Anamnese der Großmutter mütterlicherseits:
        System.out.println("Großmutter: " + sohn.zeigMutter().zeigMutter().nenneName());

        // gesamten Familenstatus im Terminal ausgeben:
        System.out.println("Patient: " + sohn.nenneName());
        System.out.println(sohn.nenneStammbaum());

        // Familienstammbaum für Arzt oberarzt nicht ersichtlich:
        Arzt oberarzt = new Arzt("Steffens", "Dr. Anne");
        sohn.weiseArztZu(oberarzt);

        // Patient sohn wird von seiner Tante (Pflegekraft krankenschwester) betreut:
        Pflegekraft krankenschwester = new Pflegekraft(
                "Lorenz", "Sabine",
                grossVaterMutter, grossMutterMutter);
        sohn.weisePflegerZu(krankenschwester);

        // Betreuendes Personal im Terminal ausgeben:
        System.out.println("Arzt: " + sohn.nenneArzt());
        System.out.println("Pflegekraft: " + sohn.nennePfleger());
    }
}
