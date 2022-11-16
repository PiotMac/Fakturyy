package org.example;

public class Towar
{
    private final String nazwa;
    public final double cenaBrutto;
    public Towar( final String artykul, final int ilosc, final double cena )
    {
        nazwa = artykul;
        cenaBrutto = ilosc * cena;
    }

    public final void getName()
    {
        System.out.println( "Nazwa artykułu: " + nazwa );
    }

    public final void getPrice()
    {
        System.out.println( "Łączna cena brutto: " + cenaBrutto + "zł" );
    }
}
