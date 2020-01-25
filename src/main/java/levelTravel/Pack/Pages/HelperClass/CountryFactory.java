package levelTravel.Pack.Pages.HelperClass;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryPage;
import levelTravel.Pack.Pages.CountryPage.Classes.CountryList.*;
import org.jetbrains.annotations.NotNull;

public class CountryFactory extends AbstractBasePage {

    public CountryPage createCountry(@NotNull String countryName) {

        switch (countryName) {
            case "Turk":
                return new TurkeyPage();
            case "Thai":
                return new ThaiPage();
            case "Oae":
                return new OAEPage();
            case "Rus":
                return new RussiaPage();
            case "Vie":
                return new VietnamPage();
            case "Abk":
                return new AbkhaziaPage();
            case "Aus":
                return new AustriaPage();
            case "Alb":
                return new AlbaniaPage();
            case "And":
                return new AndorraPage();
            case "Arm":
                return new ArmeniaPage();
            case "Bak":
                return new BakhreinPage();
            case "Bel":
                return new BelarusPage();
            case "Bul":
                return new BulgaryPage();
            case "Hun":
                return new HungaryPage();
            case "Gam":
                return new GambiaPage();
            case "Gre":
                return new GreecePage();
            case "Dom":
                return new DominikanaPage();
            case "Egy":
                return new EgyptPage();
            case "Isr":
                return new IsraelPage();
            case "Ind":
                return new IndiaPage();
            case "Indo":
                return new IndoneziaPage();
            case "Ior":
                return new IordaniaPage();
            case "Spa":
                return new SpainPage();
            case "Ita":
                return new ItalyPage();
            case "Cyp":
                return new CyprusPage();
            case "Chi":
                return new ChinaPage();
            case "Cub":
                return new CubaPage();
            case "Mav":
                return new MavrikiaPage();
            case "Mald":
                return new MaldivyPage();
            case "Malt":
                return new MaltaPage();
            case "Mar":
                return new MaroccoPage();
            case "Mex":
                return new MexicoPage();
            case "Oman":
                return new OmanPage();
            case "Por":
                return new PortugalPage();
            case "Sei":
                return new SeishelyPage();
            case "Sin":
                return new SingapurePage();
            case "Tan":
                return new TanzaniaPage();
            case "Tun":
                return new TunisPage();
            case "Fin":
                return new FinlandPage();
            case "Fra":
                return new FrancePage();
            case "Chr":
                return new ChroatiaPage();
            case "Cher":
                return new ChernogoriaPage();
            case "Chec":
                return new ChekhPage();
            case "Swi":
                return new SwissPage();
            case "Swe":
                return new SwedenPage();
            case "Sri":
                return new SriLankaPage();
            case "Sou":
                return new SouthKoreaPage();
            case "Jam":
                return new JamaicaPage();
            default:
                return null;
        }
    }
}
