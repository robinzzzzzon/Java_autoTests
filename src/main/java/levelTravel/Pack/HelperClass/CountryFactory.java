package levelTravel.Pack.HelperClass;

import levelTravel.Pack.AbstractPage.AbstractBasePage;
import levelTravel.Pack.CountryPage.Classes.CountryList.*;
import org.openqa.selenium.WebDriver;

public class CountryFactory {

    private WebDriver driver;

    public CountryFactory(WebDriver driver) {
        this.driver = driver;
    }

    public AbstractBasePage createCountry(String countryName) {

        switch (countryName) {
            case "Turk" : return new TurkeyPage(driver);
            case "Thai" : return new ThaiPage(driver);
            case "Oae" : return new OAEPage(driver);
            case "Rus" : return new RussiaPage(driver);
            case "Vie" : return new VietnamPage(driver);
            case "Abk" : return new AbkhaziaPage(driver);
            case "Aus" : return new AustriaPage(driver);
            case "Alb" : return new AlbaniaPage(driver);
            case "And" : return new AndorraPage(driver);
            case "Arm" : return new ArmeniaPage(driver);
            case "Bak" : return new BakhreinPage(driver);
            case "Bel" : return new BelarusPage(driver);
            case "Bul" : return new BulgaryPage(driver);
            case "Hun" : return new HungaryPage(driver);
            case "Gam" : return new GambiaPage(driver);
            case "Gre" : return new GreecePage(driver);
            case "Dom" : return new DominikanaPage(driver);
            case "Egy" : return new EgyptPage(driver);
            case "Isr" : return new IsraelPage(driver);
            case "Ind" : return new IndiaPage(driver);
            case "Indo" : return new IndoneziaPage(driver);
            case "Ior" : return new IordaniaPage(driver);
            case "Spa" : return new SpainPage(driver);
            case "Ita" : return new ItalyPage(driver);
            case "Cyp" : return new CyprusPage(driver);
            case "Chi" : return new ChinaPage(driver);
            case "Cub" : return new CubaPage(driver);
            case "Mav" : return new MavrikiaPage(driver);
            case "Mald" : return new MaldivyPage(driver);
            case "Malt" : return new MaltaPage(driver);
            case "Mar" : return new MaroccoPage(driver);
            case "Mex" : return new MexicoPage(driver);
            case "Oman" : return new OmanPage(driver);
            case "Por" : return new PortugalPage(driver);
            case "Sei" : return new SeishelyPage(driver);
            case "Sin" : return new SingapurePage(driver);
            case "Tan" : return new TanzaniaPage(driver);
            case "Tun" : return new TunisPage(driver);
            case "Fin" : return new FinlandPage(driver);
            case "Fra" : return new FrancePage(driver);
            case "Chr" : return new ChroatiaPage(driver);
            case "Cher" : return new ChernogoriaPage(driver);
            case "Chec" : return new ChekhPage(driver);
            case "Swi" : return new SwissPage(driver);
            case "Swe" : return new SwedenPage(driver);
            case "Sri" : return new SriLankaPage(driver);
            case "Sou" : return new SouthKoreaPage(driver);
            case "Jam" : return new JamaicaPage(driver);
            default: return null;
        }
    }
}
