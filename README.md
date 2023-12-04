# Kivi sakset paperi refaktorointi

Tehtävä: 10 - Refaktorointi (Kivi-Paperi-Sakset) (Eclipse, JUnit 5, JaCoCoverage)

### Mitä refaktoroitiin?

Koodi on jaettu Pelin ja Pelaajan lisäksi useampaan uuteen luokkaan (Choice, Turn ja Outcome), millä parantaa koodin modulaarisuutta ja testattavuutta.

Koodi on myös vaihdettu olemaan englanniksi. Suomen kieli hajottaa.

Olio-ohjelmoinnin periaatteita, kuten kapselointia ja abstraktiota, on myöskin hyödynnetty.

Toistuvaa koodia on vähennetty keskittämällä voiton logiikka ja tulostus, mikä helpottaa ylläpitoa ja parantaa luettavuutta.

Lisäksi pelilogiikka on erotettu käyttöliittymästä, mikä tekee koodista joustavamman ja mahdollistaa helpomman laajennuksen, kuten graafisen käyttöliittymän lisäämisen tms.

Koodin testattavuus on parantunut, koska pelilogiikka on jaettu pienempiin, itsenäisiin osiin. Game-luokka käyttää List<Turn>-rakennetta pelattujen vuorojen tallentamiseen, mikä tarjoaa joustavan ja toiminnallisen ratkaisun pelin tilan hallintaan.

### Testaus

Muutama testi on lisätty jolla saadaan testikattavuutta ylös. GameTest hyödyntää Mockitoa.

### Javadoc

-tähän javadoc linkki-
