package Ex13;
public class TestAdressWeb {
    public static void main(String[] args) {
        AdresseWeb adresse1 = new AdresseWeb("https", "supersite.fr", "/rep1/rep2/index.html");
        AdresseWeb adresse2 = new AdresseWeb("supersite.fr", "/rep1/rep2/index.html");
        AdresseWeb adresse3 = new AdresseWeb("supersite.fr");

        System.out.println(adresse1.toString());
        System.out.println(adresse2.toString());
        System.out.println(adresse3.toString());
        }
}
