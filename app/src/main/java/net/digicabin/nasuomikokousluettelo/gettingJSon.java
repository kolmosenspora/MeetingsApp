package net.digicabin.nasuomikokousluettelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class gettingJSon {
    public static Map<String, List<ArrayList>> trying = new HashMap<>();
    public gettingJSon() {

    }

    ArrayList<String> gettingArray() {


        ArrayList myArray = new ArrayList();
        JsonArray entriess = (JsonArray) new JsonParser().parse(Ryhmikset.ryhmat1);

        int i = 0;
        while (i < entriess.size()) {


            JsonElement alkamisaika = ((JsonObject) entriess.get(i)).get("alkamisaika");
            JsonElement nimi = ((JsonObject) entriess.get(i)).get("slug");
            JsonElement paiva = ((JsonObject) entriess.get(i)).get("weekday");
            JsonElement kaupunki = ((JsonObject) entriess.get(i)).get("kaupunki");
            JsonElement katuosoite = ((JsonObject) entriess.get(i)).get("katuosoite");
            JsonElement lisatiedot = ((JsonObject) entriess.get(i)).get("lisatiedot");
            JsonElement osoite = ((JsonObject) entriess.get(i)).get("katuosoite");
            JsonElement postinumero = ((JsonObject) entriess.get(i)).get("postinumero");
            JsonElement title = ((JsonObject) entriess.get(i)).get("title");

            JsonElement titteli = title.getAsJsonObject().get("rendered");




            String tiddeli = titteli.getAsString();
            String osoide = osoite.getAsString() + ", " + postinumero.getAsString() + ", " + kaupunki.getAsString();
            String lisadiedot = lisatiedot.getAsString();
            String gatuosoite = katuosoite.getAsString();
            String baiva = paiva.getAsString();
            String kaupungi = kaupunki.getAsString();
            String nimikin = nimi.getAsString();
            String algamisaika = alkamisaika.getAsString();


            i++;

            if (Kokousluettelo.day.contains(baiva) && (City.city.contains(kaupungi))) {
                ArrayList kokoukset = new ArrayList();
                kokoukset.add("Kokouksen nimi: " + tiddeli + "\n");
                kokoukset.add("Kokous alkaa: " + algamisaika + "\n");
                kokoukset.add("kaupunki: " + kaupungi + "\n");
                kokoukset.add("Viikonpäivä: " + baiva + "\n" );
                kokoukset.add("Lisätiedot: " + lisadiedot + "\n");
                kokoukset.add("\n" + "Kokouksen osoite: " + osoide + "\n");

                Listedgroups.items.add(tiddeli + " " + algamisaika);
                Listedgroups.meetings.add(tiddeli);

                trying.put(tiddeli, kokoukset);







            }
        }
        return myArray;

    }
    ArrayList<String> gettingArrayn() {


        ArrayList myArray = new ArrayList();
        JsonArray entriess = (JsonArray) new JsonParser().parse(Ryhmikset.ryhmat2);

        int i = 0;
        while (i < entriess.size()) {


            JsonElement alkamisaika = ((JsonObject) entriess.get(i)).get("alkamisaika");
            JsonElement nimi = ((JsonObject) entriess.get(i)).get("slug");
            JsonElement paiva = ((JsonObject) entriess.get(i)).get("weekday");
            JsonElement kaupunki = ((JsonObject) entriess.get(i)).get("kaupunki");
            JsonElement katuosoite = ((JsonObject) entriess.get(i)).get("katuosoite");
            JsonElement lisatiedot = ((JsonObject) entriess.get(i)).get("lisatiedot");
            JsonElement osoite = ((JsonObject) entriess.get(i)).get("katuosoite");
            JsonElement postinumero = ((JsonObject) entriess.get(i)).get("postinumero");
            JsonElement title = ((JsonObject) entriess.get(i)).get("title");

            JsonElement titteli = title.getAsJsonObject().get("rendered");


            String tiddeli = titteli.getAsString();
            String osoide = osoite.getAsString() + ", " + postinumero.getAsString() + ", " + kaupunki.getAsString();
            String lisadiedot = lisatiedot.getAsString();
            String gatuosoite = katuosoite.getAsString();
            String baiva = paiva.getAsString();
            String kaupungi = kaupunki.getAsString();
            String nimikin = nimi.getAsString();
            String algamisaika = alkamisaika.getAsString();


            i++;

            if (Kokousluettelo.day.contains(baiva) && (City.city.contains(kaupungi))) {
                ArrayList kokoukset = new ArrayList();
                kokoukset.add("Kokouksen nimi: " + nimikin + "\n");
                kokoukset.add("Kokous alkaa: " + algamisaika + "\n");
                kokoukset.add("kaupunki: " + kaupungi + "\n");
                kokoukset.add("Viikonpäivä: " + baiva + "\n" );
                kokoukset.add("Lisätiedot: " + lisadiedot + "\n");
                kokoukset.add("\n" + "Kokouksen osoite: " + osoide + "\n");

                Listedgroups.items.add(tiddeli + " " + algamisaika);
                Listedgroups.meetings.add(tiddeli);

                trying.put(tiddeli, kokoukset);









            }
        }
        return myArray;

    }
}
