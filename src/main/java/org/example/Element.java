package org.example;

public class Element
{
    private final Towar towar;
    private final int iloscElementu;
    private final double cenaElementu;
    public Element( final String artykul, final int ilosc, final double cena )
    {
        iloscElementu = ilosc;
        cenaElementu = cena;
        towar = new Towar( artykul, ilosc, cena );
    }

    public final void getName()
    {
        towar.getName();
    }

    public final void getIlosc()
    {
        System.out.println( "Ilość artykułu: " + iloscElementu );
    }
    public final void getCena() { System.out.println( "Cena brutto za sztukę: " + cenaElementu + "zł" ); }

    public final void getCenaBrutto()
    {
        towar.getPrice();
    }
}
