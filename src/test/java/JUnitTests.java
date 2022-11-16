import org.example.*;
import org.junit.Assert;
import org.junit.Test;

public class JUnitTests
{
    @Test
    public void testPriceBrutto()
    {
        int ilosc = 12345;
        double cena = 212.26;
        Towar towar = new Towar(ilosc, cena);

        Assert.assertEquals(ilosc * cena, towar.cenaBrutto, 0.0);
    }

    @Test(expected = BadDataException.class)
    public void testSetDane() throws BadDataException
    {
        Faktura faktura = new Faktura();

        faktura.setDane( "", "" );
    }

    @Test(expected = BadDataException.class)
    public void testZleLiczby() throws BadDataException
    {
        Faktura faktura = new Faktura();
        int i = -4;
        double d = 0.0;

        faktura.addElement( "nazwa", i, d );
    }

    @Test(expected = BadDataException.class)
    public void testMiejscaPoPrzecinku() throws BadDataException
    {
        Faktura faktura = new Faktura();
        int i = 3;
        double d = 4.012;

        faktura.addElement( "nazwa", i, d );
    }
}
