package org.example;

public class Towar
{
    public final double cenaBrutto;
    public Towar( final int ilosc, final double cena )
    {
        cenaBrutto = ilosc * cena;
    }
    public final void getPrice()
    {
        System.out.println( "Łączna cena brutto: " + cenaBrutto + "zł" );
    }
}
