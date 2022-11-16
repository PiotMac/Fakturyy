package org.example;

public class Element
{
    private final Towar towar;
    public final int iloscElementu;
    private final double cenaElementu;
    private final String nazwa;
    public Element( final String artykul, final int ilosc, final double cena )
    {
        nazwa = artykul;
        iloscElementu = ilosc;
        cenaElementu = cena;
        towar = new Towar( ilosc, cena );
    }

    public final void getInfo()
    {
        System.out.println( "Nazwa artykułu: " + nazwa );
        System.out.println( "Ilość artykułu: " + iloscElementu );
        System.out.println( "Cena brutto za sztukę: " + cenaElementu + "zł" );
        towar.getPrice();
    }
}
