package org.example;

//import java.util.Scanner;

import java.util.ArrayList;
import java.util.Objects;

public final class Faktura
{
    private String imie;
    private String nazwisko;
    private final ArrayList<Element> elementy = new ArrayList<>();
    public void setImie( final String wiadomosc ) throws BadDataException
    {
        if ( Objects.equals( wiadomosc, "" ) )
        {
            throw new BadDataException();
        }
        imie = wiadomosc;
    }

    public void setNazwisko( final String wiadomosc ) throws BadDataException
    {
        if ( Objects.equals( wiadomosc, "" ) )
        {
            throw new BadDataException();
        }
        nazwisko = wiadomosc;
    }

    public void addElement( final String artykul, final int ilosc, final double cena ) throws BadDataException
    {
        if ( Objects.equals( artykul, "" ) || ilosc <= 0 || cena <= 0.0 )
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
        for ( int counter = 0; counter < elementy.size(); counter++ )
        {
            System.out.println( "----- ELEMENT NR " + ( counter + 1 ) + " -----" );
            elementy.get( counter ).getName();
            elementy.get( counter ).getIlosc();
            elementy.get( counter ).getCena();
            elementy.get( counter ).getCenaBrutto();
        }
    }

    public void getFaktura()
    {
        System.out.println( "Imię: " + imie );
        System.out.println( "Nazwisko: " + nazwisko );
        showElements();
    }
}
