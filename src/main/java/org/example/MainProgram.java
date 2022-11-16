package org.example;

import java.util.Scanner;

public final class MainProgram
{
    private MainProgram(){}
    public static void main( final String[] args ) throws BadDataException
    {
        final Scanner scan = new Scanner( System.in );
        System.out.println( "Czy chciał*byś wystawić fakturę?[T/N]" );
        String wiadomosc = scan.nextLine();
        switch ( wiadomosc )
        {
            case "T" ->
            {
                Faktura faktura = new Faktura();
                System.out.println( "Imię klienta: " );
                wiadomosc = scan.nextLine();
                faktura.setImie( wiadomosc );
                System.out.println( "Nazwisko klienta: " );
                wiadomosc = scan.nextLine();
                faktura.setNazwisko( wiadomosc );
                String elementyWiadomosc;
                elementyWiadomosc = "T";
                while( elementyWiadomosc.equalsIgnoreCase( "T" ) )
                {
                    System.out.println( "Czy chcial*bys dodac element?[T/N]" );
                    elementyWiadomosc = scan.nextLine();
                    switch( elementyWiadomosc )
                    {
                        case "T" ->
                        {
                            System.out.println( "Podaj nazwę artykułu: " );
                            String artykul = scan.nextLine();
                            System.out.println( "Podaj ilość artykułu: " );
                            int ilosc;
                            double cena;
                            try
                            {
                                ilosc = Integer.parseInt( scan.nextLine() );
                            }
                            catch ( NumberFormatException ex )
                            {
                                throw new BadDataException();
                            }
                            System.out.println( "Podaj cenę brutto za jeden artykuł: " );
                            try
                            {
                                cena = Double.parseDouble( scan.nextLine() );
                            }
                            catch ( NumberFormatException ex )
                            {
                                throw new BadDataException();
                            }
                            faktura.addElement( artykul, ilosc, cena );
                        }
                        case "N" ->
                        {
                            System.out.println( "Oto Twoja faktura: \n" );
                            faktura.getFaktura();
                        }
                        default ->
                        {
                            while( !( elementyWiadomosc.equals( "T" ) ) && !( elementyWiadomosc.equals( "N" ) ) )
                            {
                                System.out.println( "Wprowadzono błędne dane, spróbuj jeszcze raz." );
                                System.out.println( "Czy chcial*bys dodac element?[T/N]" );
                                elementyWiadomosc = scan.nextLine();
                            }
                        }
                    }
                }
            }
            case "N" -> System.out.println( "Nie chcę." );
            default -> throw new BadDataException();
        }
    }
}
