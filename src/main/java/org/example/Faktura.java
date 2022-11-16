package org.example;

import java.util.List;
import java.util.ArrayList;

public final class Faktura
{
    private String imie;
    private String nazwisko;
    private final List<Element> elementy = new ArrayList<>();
    public void setDane( final String imie, final String nazwisko ) throws BadDataException
    {
        if ( "".equals( imie ) || "".equals( nazwisko ) )
        {
            throw new BadDataException();
        }
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public void addElement( final String artykul, final int ilosc, final double cena ) throws BadDataException
    {
        if ( "".equals( artykul ) || ilosc <= 0 || cena <= 0.0 )
        {
            throw new BadDataException();
        }
        //Sprawdzanie miejsc po przecinku
        String check = Double.toString( cena );
        final int decimalPoint = 3;
        int integerPlaces = check.indexOf( '.' );
        int decimalPlaces = check.length() - integerPlaces - 1;
        if ( decimalPlaces >= decimalPoint )
        {
            throw new BadDataException();
        }
        Element element = new Element( artykul, ilosc, cena );
        elementy.add( element );
    }

    private void showElements()
    {
        System.out.println( "Imię: " + imie );
        System.out.println( "Nazwisko: " + nazwisko );
        for ( int counter = 0; counter < elementy.size(); counter++ )
        {
            System.out.println( "----- ELEMENT NR " + ( counter + 1 ) + " -----" );

            elementy.get( counter ).getInfo();
        }
    }

    public void getFaktura()
    {
        showElements();
    }
}
